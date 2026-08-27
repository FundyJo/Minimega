/*     */ package dev.jab125.minimega.mod.client.p2p.upnp;
/*     */ 
/*     */ import com.google.gson.JsonObject;
/*     */ import com.mojang.serialization.DynamicOps;
/*     */ import com.mojang.serialization.JsonOps;
/*     */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.IpObj;
/*     */ import java.io.IOException;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.util.Objects;
/*     */ import net.minecraft.util.GsonHelper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UPnP
/*     */ {
/*  39 */   private static Gateway defaultGW = null;
/*  40 */   private static final GatewayFinder finder = new GatewayFinder()
/*     */     {
/*     */       public void gatewayFound(Gateway g) {
/*  43 */         synchronized (UPnP.finder) {
/*  44 */           if (UPnP.defaultGW == null) {
/*  45 */             UPnP.defaultGW = g;
/*     */           }
/*     */         } 
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void waitInit() {
/*  56 */     while (finder.isSearching()) {
/*     */       try {
/*  58 */         Thread.sleep(1L);
/*  59 */       } catch (InterruptedException interruptedException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isUPnPAvailable() {
/*  72 */     waitInit();
/*  73 */     return (defaultGW != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static boolean openPortTCP(int port) {
/*  84 */     if (!isUPnPAvailable()) return false; 
/*  85 */     return openPort().internalPort(port).externalPort(port).tcp().open();
/*     */   }
/*     */   
/*     */   public static PortBuilder openPort() {
/*  89 */     return new PortBuilderImpl();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class PortBuilderImpl
/*     */     implements PortBuilder
/*     */   {
/*     */     private int internalPort;
/*     */ 
/*     */     
/*     */     private boolean setInternalPort;
/*     */ 
/*     */     
/*     */     private int externalPort;
/*     */ 
/*     */     
/*     */     private boolean setExternalPort;
/*     */ 
/*     */     
/*     */     private boolean mode;
/*     */     
/*     */     private boolean setMode;
/*     */ 
/*     */     
/*     */     public UPnP.PortBuilder internalPort(int port) {
/* 115 */       this.setInternalPort = true;
/* 116 */       this.internalPort = port;
/* 117 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public UPnP.PortBuilder externalPort(int port) {
/* 122 */       this.setExternalPort = true;
/* 123 */       this.externalPort = port;
/* 124 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public UPnP.PortBuilder udp() {
/* 129 */       this.setMode = true;
/* 130 */       this.mode = true;
/* 131 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public UPnP.PortBuilder tcp() {
/* 136 */       this.setMode = true;
/* 137 */       this.mode = false;
/* 138 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean open() {
/* 144 */       if (!this.setMode || !this.setInternalPort || !this.setExternalPort) throw new NullPointerException(); 
/* 145 */       return UPnP.defaultGW.openPort(this.internalPort, this.externalPort, this.mode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static boolean openPortUDP(int port) {
/* 157 */     if (!isUPnPAvailable()) return false; 
/* 158 */     return openPort().internalPort(port).externalPort(port).udp().open();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean closePortTCP(int port) {
/* 169 */     if (!isUPnPAvailable()) return false; 
/* 170 */     return defaultGW.closePort(port, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean closePortUDP(int port) {
/* 181 */     if (!isUPnPAvailable()) return false; 
/* 182 */     return defaultGW.closePort(port, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isMappedTCP(int port) {
/* 192 */     if (!isUPnPAvailable()) return false; 
/* 193 */     return defaultGW.isMapped(port, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isMappedUDP(int port) {
/* 203 */     if (!isUPnPAvailable()) return false; 
/* 204 */     return defaultGW.isMapped(port, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getExternalIP() {
/* 213 */     if (!isUPnPAvailable()) return null; 
/* 214 */     return defaultGW.getExternalIP();
/*     */   }
/*     */   
/*     */   public static String unisGetExternalIP() {
/*     */     try {
/* 219 */       String externalIP = getExternalIP();
/* 220 */       if (externalIP != null) return externalIP; 
/* 221 */       URL url = null;
/*     */       try {
/* 223 */         url = URI.create("https://api.ipify.org/?format=json").toURL();
/* 224 */       } catch (MalformedURLException e) {
/* 225 */         return null;
/*     */       } 
/* 227 */       byte[] bytes = null;
/*     */       try {
/* 229 */         bytes = url.openConnection().getInputStream().readAllBytes();
/* 230 */       } catch (IOException e) {
/* 231 */         return null;
/*     */       } 
/* 233 */       String s = new String(bytes);
/* 234 */       JsonObject parse = GsonHelper.parse(s);
/* 235 */       Objects.requireNonNull(System.err); return ((IpObj)IpObj.CODEC.parse((DynamicOps)JsonOps.INSTANCE, parse).resultOrPartial(System.err::println).orElseThrow()).ip();
/* 236 */     } catch (Throwable t) {
/* 237 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getLocalIP() {
/* 247 */     if (!isUPnPAvailable()) return null; 
/* 248 */     return defaultGW.getLocalIP();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getDefaultGatewayIP() {
/* 257 */     if (!isUPnPAvailable()) return null; 
/* 258 */     return defaultGW.getGatewayIP();
/*     */   }
/*     */   
/*     */   public static interface PortBuilder {
/*     */     PortBuilder internalPort(int param1Int);
/*     */     
/*     */     PortBuilder externalPort(int param1Int);
/*     */     
/*     */     PortBuilder udp();
/*     */     
/*     */     PortBuilder tcp();
/*     */     
/*     */     boolean open();
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\p2\\upnp\UPnP.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */