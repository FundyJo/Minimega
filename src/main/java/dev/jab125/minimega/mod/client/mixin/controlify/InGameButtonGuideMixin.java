/*    */ package dev.jab125.minimega.mod.client.mixin.controlify;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.isxander.controlify.api.guide.GuideInstance;
/*    */ import dev.isxander.controlify.api.guide.InGameCtx;
/*    */ import dev.isxander.controlify.gui.guide.InGameButtonGuide;
/*    */ import dev.jab125.minimega.mod.client.MinimegaClient;
/*    */ import dev.jab125.minimega.mod.client.compat.controlify.InGameGlideCtx;
/*    */ import dev.jab125.minimega.mod.client.compat.controlify.InGameLobbyCtx;
/*    */ import dev.jab125.minimega.mod.client.compat.controlify.MinimegaDomains;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import net.minecraft.client.gui.Font;
/*    */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*    */ import org.spongepowered.asm.mixin.Dynamic;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({InGameButtonGuide.class})
/*    */ public class InGameButtonGuideMixin
/*    */ {
/*    */   @Shadow
/*    */   @Final
/*    */   private GuideInstance<InGameCtx> guideInstance;
/*    */   @Unique
/*    */   private GuideInstance<InGameLobbyCtx> lobby;
/*    */   @Unique
/*    */   private GuideInstance<InGameGlideCtx> glide;
/*    */   
/*    */   @Inject(method = {"extractRenderState"}, at = {@At("HEAD")})
/*    */   @Dynamic
/*    */   void renderHud(CallbackInfo info) {
/* 41 */     if (MinimegaClient.getMinigame() == Minigame.GLIDE && this.glide == null) { this.glide = MinimegaDomains.IN_GAME_GLIDE.createInstance(); }
/* 42 */     else if (MinimegaClient.getMinigame() == Minigame.LOBBY && this.lobby == null)
/* 43 */     { this.lobby = MinimegaDomains.IN_GAME_LOBBY.createInstance(); }
/*    */   
/*    */   }
/*    */ 
/*    */   
/*    */   @WrapOperation(method = {"extractRenderState"}, at = {@At(value = "INVOKE", target = "Ldev/isxander/controlify/api/guide/GuideInstance;extractRenderState(Lnet/minecraft/client/gui/GuiGraphicsExtractor;ZZ)V")})
/*    */   @Dynamic
/*    */   void extractRnederState(GuideInstance<?> guideInstance, GuiGraphicsExtractor var1, boolean var2, boolean var3, Operation<Void> original) {
/* 51 */     if (MinimegaClient.getMinigame() == Minigame.GLIDE) { guideInstance = this.glide; }
/* 52 */     else if (MinimegaClient.getMinigame() == Minigame.LOBBY) { guideInstance = this.lobby; }
/* 53 */      original.call(new Object[] { guideInstance, var1, Boolean.valueOf(var2), Boolean.valueOf(var3) }); } @WrapOperation(method = {"tick"}, at = {@At(value = "INVOKE", target = "Ldev/isxander/controlify/api/guide/GuideInstance;update(Ldev/isxander/controlify/api/guide/FactCtx;Lnet/minecraft/client/gui/Font;)Z")})
/*    */   @Dynamic
/*    */   <T extends dev.isxander.controlify.api.guide.FactCtx> boolean updateGuides(GuideInstance<T> instance, T var1, Font var2, Operation<Boolean> original) {
/*    */     GuideInstance<InGameLobbyCtx> guideInstance;
/*    */     InGameGlideCtx inGameGlideCtx;
/*    */     InGameLobbyCtx inGameLobbyCtx;
/* 59 */     if (MinimegaClient.getMinigame() == Minigame.GLIDE && this.glide != null) {
/*    */       
/* 61 */       GuideInstance<InGameGlideCtx> guideInstance1 = this.glide;
/* 62 */       inGameGlideCtx = new InGameGlideCtx((InGameCtx)var1);
/* 63 */     } else if (MinimegaClient.getMinigame() == Minigame.LOBBY && this.lobby != null) {
/*    */ 
/*    */       
/* 66 */       guideInstance = this.lobby;
/* 67 */       original.call(new Object[] { this.guideInstance, inGameGlideCtx, var2 });
/* 68 */       inGameLobbyCtx = new InGameLobbyCtx((InGameCtx)inGameGlideCtx);
/*    */     } 
/* 70 */     return ((Boolean)original.call(new Object[] { guideInstance, inGameLobbyCtx, var2 })).booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\controlify\InGameButtonGuideMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */