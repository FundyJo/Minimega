/*    */ package dev.jab125.minimega.mod.client.mixin.e4mc;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import dev.jab125.minimega.mod.extension.MinecraftServerExtension;
/*    */ import dev.jab125.minimega.mod.util.minigamedata.MinigameData;
/*    */ import link.e4mc.QuiclimeSession;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.server.IntegratedServer;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.server.network.ServerConnectionListener;
/*    */ import org.spongepowered.asm.mixin.Dynamic;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin(value = {ServerConnectionListener.class}, priority = 1500)
/*    */ public class ServerConnectionListenerMixin
/*    */ {
/*    */   @Shadow
/*    */   @Final
/*    */   private MinecraftServer server;
/*    */   
/*    */   @WrapOperation(method = {"@Minimega:InvInit"}, at = {@At(value = "INVOKE", target = "Llink/e4mc/QuiclimeSession;startAsync()V")})
/*    */   @Dynamic
/*    */   private void interceptGroupMixin(QuiclimeSession session, Operation<Void> original) {
/* 35 */     IntegratedServer integratedServer = Minecraft.getInstance().getSingleplayerServer(); if (integratedServer instanceof IntegratedServer) { IntegratedServer server = integratedServer; if (server == this.server && Minimega.isMinigameServer((MinecraftServer)server)) {
/*    */ 
/*    */ 
/*    */         
/* 39 */         MinigameData minigameData = ((MinecraftServerExtension)server).mm$getData(); if (minigameData instanceof MinigameData) { MinigameData data = minigameData; if (data.online()) {
/*    */ 
/*    */             
/* 42 */             original.call(new Object[] { session });
/*    */             return;
/*    */           }  }
/*    */         
/*    */         return;
/*    */       }  }
/*    */     
/*    */     original.call(new Object[] { session });
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\e4mc\ServerConnectionListenerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */