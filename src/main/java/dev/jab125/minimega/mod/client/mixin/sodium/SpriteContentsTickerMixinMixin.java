/*    */ package dev.jab125.minimega.mod.client.mixin.sodium;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.client.MinimegaClient;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import net.minecraft.client.renderer.texture.SpriteContents;
/*    */ import org.spongepowered.asm.mixin.Dynamic;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin(value = {SpriteContents.AnimationState.class}, priority = 1500)
/*    */ public class SpriteContentsTickerMixinMixin {
/*    */   @WrapOperation(method = {"@Minimega:InvInit"}, at = {@At(value = "INVOKE", target = "Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfoReturnable;setReturnValue(Ljava/lang/Object;)V")})
/*    */   @Dynamic
/*    */   void pretick(CallbackInfoReturnable<Boolean> cir, Object value, Operation<Void> original) {
/* 18 */     if (MinimegaClient.getMinigame() == Minigame.GLIDE)
/* 19 */       return;  original.call(new Object[] { cir, value });
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\sodium\SpriteContentsTickerMixinMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */