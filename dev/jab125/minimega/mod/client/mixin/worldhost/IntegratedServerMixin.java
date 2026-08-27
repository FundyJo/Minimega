/*    */ package dev.jab125.minimega.mod.client.mixin.worldhost;
/*    */ 
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import net.minecraft.client.server.IntegratedServer;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin(value = {IntegratedServer.class}, priority = 1100)
/*    */ public class IntegratedServerMixin
/*    */ {
/*    */   @Inject(method = {"@Minimega:InvInit"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void shareWorldOnLoad(CallbackInfo original, CallbackInfo info) {
/* 16 */     if (Minimega.isMinigameServer((MinecraftServer)this)) info.cancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\worldhost\IntegratedServerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */