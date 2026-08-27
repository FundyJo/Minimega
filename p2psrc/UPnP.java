/*
 * Copyright (C) 2015 Federico Dossena (adolfintel.com).
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package dev.jab125.minimega.mod.p2p.upnp;

import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import dev.jab125.minimega.mod.p2p.matchmaking.obj.IpObj;
import net.minecraft.util.GsonHelper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * This class contains static methods that allow quick access to UPnP Port Mapping.<br>
 * Commands will be sent to the default gateway.
 * 
 * @author Federico
 */
public class UPnP {

    private static Gateway defaultGW = null;
    private static final GatewayFinder finder = new GatewayFinder() {
        @Override
        public void gatewayFound(Gateway g) {
            synchronized (finder) {
                if (defaultGW == null) {
                    defaultGW = g;
                }
            }
        }
    };

    /**
     * Waits for UPnP to be initialized (takes ~3 seconds).<br>
     * It is not necessary to call this method manually before using UPnP functions
     */
    public static void waitInit() {
        while (finder.isSearching()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    /**
     * Is there an UPnP gateway?<br>
     * This method is blocking if UPnP is still initializing<br>
     * All UPnP commands will fail if UPnP is not available
     * 
     * @return true if available, false if not
     */
    public static boolean isUPnPAvailable(){
        waitInit();
        return defaultGW!=null;
    }

    /**
     * Opens a TCP port on the gateway
     * 
     * @param port TCP port (0-65535)
     * @return true if the operation was successful, false otherwise
     */
    @Deprecated
    public static boolean openPortTCP(int port) {
        if(!isUPnPAvailable()) return false;
        return openPort().internalPort(port).externalPort(port).tcp().open();
    }

    public static PortBuilder openPort() {
        return new PortBuilderImpl();
    }

    public interface PortBuilder {
        PortBuilder internalPort(int port);
        PortBuilder externalPort(int port);
        PortBuilder udp();
        PortBuilder tcp();
        boolean open();
    }

    private static class PortBuilderImpl implements PortBuilder {
        private int internalPort;
        private boolean setInternalPort;
        private int externalPort;
        private boolean setExternalPort;
        // false tcp true udp
        private boolean mode;
        private boolean setMode;
        @Override
        public PortBuilder internalPort(int port) {
            this.setInternalPort = true;
            this.internalPort = port;
            return this;
        }

        @Override
        public PortBuilder externalPort(int port) {
            this.setExternalPort = true;
            this.externalPort = port;
            return this;
        }

        @Override
        public PortBuilder udp() {
            this.setMode = true;
            this.mode = true;
            return this;
        }

        @Override
        public PortBuilder tcp() {
            this.setMode = true;
            this.mode = false;
            return this;
        }

        @SuppressWarnings("deprecation")
		@Override
        public boolean open() {
            if (!setMode || !setInternalPort || !setExternalPort) throw new NullPointerException();
            return defaultGW.openPort(internalPort, externalPort, mode);
        }
    }
    
    /**
     * Opens a UDP port on the gateway
     * 
     * @param port UDP port (0-65535)
     * @return true if the operation was successful, false otherwise
     */
    @Deprecated
    public static boolean openPortUDP(int port) {
        if(!isUPnPAvailable()) return false;
        return openPort().internalPort(port).externalPort(port).udp().open();
    }
    
    /**
     * Closes a TCP port on the gateway<br>
     * Most gateways seem to refuse to do this
     * 
     * @param port TCP port (0-65535)
     * @return true if the operation was successful, false otherwise
     */
    public static boolean closePortTCP(int port) {
        if(!isUPnPAvailable()) return false;
        return defaultGW.closePort(port, false);
    }
    
    /**
     * Closes a UDP port on the gateway<br>
     * Most gateways seem to refuse to do this
     * 
     * @param port UDP port (0-65535)
     * @return true if the operation was successful, false otherwise
     */
    public static boolean closePortUDP(int port) {
        if(!isUPnPAvailable()) return false;
        return defaultGW.closePort(port, true);
    }
    
    /**
     * Checks if a TCP port is mapped<br>
     * 
     * @param port TCP port (0-65535)
     * @return true if the port is mapped, false otherwise
     */
    public static boolean isMappedTCP(int port) {
        if(!isUPnPAvailable()) return false;
        return defaultGW.isMapped(port, false);
    }
    
    /**
     * Checks if a UDP port is mapped<br>
     * 
     * @param port UDP port (0-65535)
     * @return true if the port is mapped, false otherwise
     */
    public static boolean isMappedUDP(int port) {
        if(!isUPnPAvailable()) return false;
        return defaultGW.isMapped(port, true);
    }
    
    /**
     * Gets the external IP address of the default gateway
     * 
     * @return external IP address as string, or null if not available
     */
    public static String getExternalIP(){
        if(!isUPnPAvailable()) return null;
        return defaultGW.getExternalIP();
    }

    public static String unisGetExternalIP() {
        try {
            String externalIP = getExternalIP();
            if (externalIP != null) return externalIP;
            URL url = null;
            try {
                url = URI.create("https://api.ipify.org/?format=json").toURL();
            } catch (MalformedURLException e) {
                return null;
            }
            byte[] bytes = null;
            try {
                bytes = url.openConnection().getInputStream().readAllBytes();
            } catch (IOException e) {
                return null;
            }
            String s = new String(bytes);
            JsonObject parse = GsonHelper.parse(s);
            return IpObj.CODEC.parse(JsonOps.INSTANCE, parse).resultOrPartial(System.err::println).orElseThrow().ip();
        } catch (Throwable t) {
            return null;
        }
    }
    
    /**
     * Gets the internal IP address of this machine
     * 
     * @return internal IP address as string, or null if not available
     */
    public static String getLocalIP(){
        if(!isUPnPAvailable()) return null;
        return defaultGW.getLocalIP();
    }

    /**
     * Gets the  IP address of the router
     *
     * @return internal IP address as string, or null if not available
     */
    public static String getDefaultGatewayIP(){
        if(!isUPnPAvailable()) return null;
        return defaultGW.getGatewayIP();
    }

}