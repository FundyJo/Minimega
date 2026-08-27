/*    */ package dev.jab125.minimega.mod.abstractions.networking.impl;
/*    */ 
/*    */ import dev.jab125.minimega.mod.abstractions.networking.ClientNetworking;
/*    */ import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
/*    */ import net.minecraft.network.protocol.Packet;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ 
/*    */ public class FabricClientNetworking implements ClientNetworking {
/*  9 */   public static final FabricClientNetworking FABRIC_CLIENT_NETWORKING = new FabricClientNetworking();
/*    */ 
/*    */   
/*    */   public Packet<?> play(CustomPacketPayload payload) {
/* 13 */     return ClientPlayNetworking.createServerboundPacket(payload);
/*    */   }
/*    */ 
/*    */   
/*    */   public Packet<?> configuration(CustomPacketPayload payload) {
/* 18 */     return ClientPlayNetworking.createServerboundPacket(payload);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\abstractions\networking\impl\FabricClientNetworking.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */