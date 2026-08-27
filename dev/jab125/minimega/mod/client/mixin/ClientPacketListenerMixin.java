/*    */ package dev.jab125.minimega.mod.client.mixin;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import dev.jab125.minimega.mod.client.gui.screen.MapTransitionScreen;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.screens.Screen;
/*    */ import net.minecraft.client.multiplayer.ClientPacketListener;
/*    */ import net.minecraft.client.multiplayer.LevelLoadTracker;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import org.spongepowered.asm.mixin.Dynamic;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin(value = {ClientPacketListener.class}, priority = 1003)
/*    */ public class ClientPacketListenerMixin
/*    */ {
/*    */   @WrapOperation(method = {"startWaitingForNewLevel"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;setScreenAndShow(Lnet/minecraft/client/gui/screens/Screen;)V")})
/*    */   void startWaitingForNewLevel(Minecraft instance, Screen screen, Operation<Void> original) {
/* 24 */     Screen screen1 = instance.screen; if (screen1 instanceof MapTransitionScreen) { MapTransitionScreen screen2 = (MapTransitionScreen)screen1;
/* 25 */       Minimega.LOGGER.info("map transition screen now waiting for " + String.valueOf(this.levelLoadTracker));
/* 26 */       screen2.loadTracker = this.levelLoadTracker;
/*    */       return; }
/*    */     
/* 29 */     original.call(new Object[] { instance, screen });
/*    */   } @Shadow
/*    */   @Nullable
/*    */   private LevelLoadTracker levelLoadTracker; @WrapOperation(method = {"@Minimega:InvInit"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;setScreen(Lnet/minecraft/client/gui/screens/Screen;)V")}, require = 0)
/*    */   @Dynamic
/*    */   void legacy4jHandleRespawnScreen(Minecraft minecraft, Screen screen, Operation<Void> v) {
/* 35 */     if ((Minecraft.getInstance()).screen instanceof MapTransitionScreen)
/* 36 */       return;  v.call(new Object[] { minecraft, screen });
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\ClientPacketListenerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */