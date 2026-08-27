/*    */ package dev.jab125.minimega.mod.abstractions.networking;
/*    */ 
/*    */ import dev.jab125.minimega.mod.abstractions.networking.impl.FabricClientNetworking;
/*    */ import net.minecraft.network.protocol.Packet;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ 
/*    */ public interface ClientNetworking
/*    */   extends CommonNetworking
/*    */ {
/*    */   Packet<?> play(CustomPacketPayload paramCustomPacketPayload);
/*    */   
/*    */   Packet<?> configuration(CustomPacketPayload paramCustomPacketPayload);
/*    */   
/*    */   static ClientNetworking getInstance() {
/* 15 */     return (ClientNetworking)FabricClientNetworking.FABRIC_CLIENT_NETWORKING;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\abstractions\networking\ClientNetworking.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */