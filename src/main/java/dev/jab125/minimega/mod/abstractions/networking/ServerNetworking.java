/*    */ package dev.jab125.minimega.mod.abstractions.networking;
/*    */ 
/*    */ import dev.jab125.minimega.mod.abstractions.networking.impl.FabricServerNetworking;
/*    */ import net.minecraft.network.protocol.Packet;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ import net.minecraft.network.protocol.game.ClientGamePacketListener;
/*    */ 
/*    */ public interface ServerNetworking
/*    */   extends CommonNetworking
/*    */ {
/*    */   Packet<? super ClientGamePacketListener> play(CustomPacketPayload paramCustomPacketPayload);
/*    */   
/*    */   Packet<?> configuration(CustomPacketPayload paramCustomPacketPayload);
/*    */   
/*    */   static ServerNetworking getInstance() {
/* 16 */     return (ServerNetworking)FabricServerNetworking.FABRIC_SERVER_NETWORKING;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\abstractions\networking\ServerNetworking.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */