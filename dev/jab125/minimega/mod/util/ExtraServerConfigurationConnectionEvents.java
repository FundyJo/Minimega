/*   */ package dev.jab125.minimega.mod.util;
/*   */ import net.fabricmc.fabric.api.event.EventFactory;
/*   */ import net.fabricmc.fabric.api.networking.v1.ServerConfigurationConnectionEvents;
/*   */ import net.minecraft.server.MinecraftServer;
/*   */ import net.minecraft.server.network.ServerConfigurationPacketListenerImpl;
/*   */ 
/*   */ public final class ExtraServerConfigurationConnectionEvents {
/* 8 */   public static final Event<ServerConfigurationConnectionEvents.Configure> BEFORE_BEFORE_CONFIGURE = EventFactory.createArrayBacked(ServerConfigurationConnectionEvents.Configure.class, callbacks -> ());
/*   */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\ExtraServerConfigurationConnectionEvents.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */