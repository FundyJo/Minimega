/*    */ package dev.jab125.minimega.mod.abstractions.networking.impl;
/*    */ 
/*    */ import dev.jab125.minimega.mod.abstractions.networking.ServerNetworking;
/*    */ import net.fabricmc.fabric.api.networking.v1.ServerConfigurationNetworking;
/*    */ import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
/*    */ import net.minecraft.network.protocol.Packet;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ import net.minecraft.network.protocol.game.ClientGamePacketListener;
/*    */ 
/*    */ public class FabricServerNetworking implements ServerNetworking {
/* 11 */   public static final FabricServerNetworking FABRIC_SERVER_NETWORKING = new FabricServerNetworking();
/*    */ 
/*    */   
/*    */   public Packet<? super ClientGamePacketListener> play(CustomPacketPayload payload) {
/* 15 */     return ServerPlayNetworking.createClientboundPacket(payload);
/*    */   }
/*    */ 
/*    */   
/*    */   public Packet<?> configuration(CustomPacketPayload payload) {
/* 20 */     return ServerConfigurationNetworking.createClientboundPacket(payload);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\abstractions\networking\impl\FabricServerNetworking.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */