/*    */ package dev.jab125.minimega.mod.client.mixin;
/*    */ 
/*    */ import dev.jab125.minimega.mod.client.extension.LoadingOverlayExtension;
/*    */ import dev.jab125.minimega.mod.client.gui.screen.MapTransitionScreen;
/*    */ import java.util.Optional;
/*    */ import java.util.function.Consumer;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*    */ import net.minecraft.client.gui.screens.LoadingOverlay;
/*    */ import net.minecraft.client.gui.screens.Screen;
/*    */ import net.minecraft.server.packs.resources.ReloadInstance;
/*    */ import net.minecraft.util.Mth;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin(value = {LoadingOverlay.class}, priority = 850)
/*    */ public class LoadingOverlayMixin
/*    */   implements LoadingOverlayExtension {
/*    */   @Shadow
/*    */   @Final
/*    */   private Minecraft minecraft;
/*    */   @Shadow
/*    */   @Final
/*    */   private ReloadInstance reload;
/*    */   @Shadow
/*    */   @Final
/*    */   private Consumer<Optional<Throwable>> onFinish;
/*    */   @Unique
/* 34 */   private int zeroz = 10;
/*    */   
/*    */   private float mmcurrentProgress;
/*    */   
/*    */   @Inject(method = {"extractRenderState"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void l(GuiGraphicsExtractor guiGraphics, int i, int j, float f, CallbackInfo ci) {
/* 40 */     Screen screen = this.minecraft.screen; if (screen instanceof MapTransitionScreen) { MapTransitionScreen mapTransitionScreen = (MapTransitionScreen)screen;
/* 41 */       mapTransitionScreen.extractRenderStateWithTooltipAndSubtitles(guiGraphics, 0, 0, f);
/* 42 */       guiGraphics.nextStratum();
/* 43 */       float actualProgress = this.reload.getActualProgress();
/* 44 */       this.mmcurrentProgress = Mth.clamp(this.mmcurrentProgress * 0.95F + actualProgress * 0.050000012F, 0.0F, 1.0F);
/* 45 */       if (this.reload.getActualProgress() >= 0.9D && this.reload.isDone()) {
/*    */         try {
/* 47 */           this.reload.checkExceptions();
/* 48 */           this.onFinish.accept(Optional.empty());
/* 49 */         } catch (Throwable var24) {
/* 50 */           this.onFinish.accept(Optional.of(var24));
/*    */         } 
/* 52 */         this.zeroz--;
/*    */       } 
/* 54 */       if (this.zeroz <= 0) {
/* 55 */         this.minecraft.setOverlay(null);
/*    */       }
/* 57 */       ci.cancel(); }
/*    */   
/*    */   }
/*    */ 
/*    */   
/*    */   public float mm$getProgress() {
/* 63 */     return this.mmcurrentProgress;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\LoadingOverlayMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */