/*    */ package dev.jab125.minimega.mod.abstractions.networking.impl;
/*    */ 
/*    */ import dev.jab125.minimega.mod.abstractions.networking.PayloadRegistry;
/*    */ import java.util.Objects;
/*    */ import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import net.minecraft.network.RegistryFriendlyByteBuf;
/*    */ 
/*    */ public class FabricPayloadRegistry implements PayloadRegistry {
/*    */   public PayloadRegistry.Type<FriendlyByteBuf> configurationC2S() {
/* 11 */     Objects.requireNonNull(PayloadTypeRegistry.serverboundConfiguration()); return PayloadTypeRegistry.serverboundConfiguration()::register;
/*    */   }
/*    */ 
/*    */   
/*    */   public PayloadRegistry.Type<FriendlyByteBuf> configurationS2C() {
/* 16 */     Objects.requireNonNull(PayloadTypeRegistry.clientboundConfiguration()); return PayloadTypeRegistry.clientboundConfiguration()::register;
/*    */   }
/*    */ 
/*    */   
/*    */   public PayloadRegistry.Type<RegistryFriendlyByteBuf> playC2S() {
/* 21 */     Objects.requireNonNull(PayloadTypeRegistry.serverboundPlay()); return PayloadTypeRegistry.serverboundPlay()::register;
/*    */   }
/*    */ 
/*    */   
/*    */   public PayloadRegistry.Type<RegistryFriendlyByteBuf> playS2C() {
/* 26 */     Objects.requireNonNull(PayloadTypeRegistry.clientboundPlay()); return PayloadTypeRegistry.clientboundPlay()::register;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\abstractions\networking\impl\FabricPayloadRegistry.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */