/*    */ package dev.jab125.minimega.mod.client.gui.screen;
/*    */ 
/*    */ import dev.jab125.minimega.mod.networking.payload.C2SLinkPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.S2CLinkPayload;
/*    */ import net.fabricmc.fabric.api.client.networking.v1.ClientConfigurationNetworking;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements LinkScreen.PayloadUtil
/*    */ {
/*    */   public String code() {
/* 36 */     return payload.code();
/*    */   }
/*    */ 
/*    */   
/*    */   public void respond(String newCode) {
/* 41 */     context.responseSender().sendPacket((CustomPacketPayload)new C2SLinkPayload(newCode));
/*    */   }
/*    */ 
/*    */   
/*    */   public void disconnect() {
/* 46 */     context.responseSender().disconnect((Component)Component.translatable("minimega.cancelledLogin"));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\screen\LinkScreen$1.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */