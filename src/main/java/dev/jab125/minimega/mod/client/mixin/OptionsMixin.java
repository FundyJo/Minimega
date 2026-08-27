/*    */ package dev.jab125.minimega.mod.client.mixin;
/*    */ 
/*    */ import dev.jab125.minimega.mod.client.MinimegaClient;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import net.minecraft.client.CloudStatus;
/*    */ import net.minecraft.client.Options;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({Options.class})
/*    */ public class OptionsMixin {
/*    */   @Inject(method = {"getCloudStatus"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void mm$getCloudsType(CallbackInfoReturnable<CloudStatus> cir) {
/* 16 */     if (MinimegaClient.getMinigame() == Minigame.GLIDE) cir.setReturnValue(CloudStatus.OFF); 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\OptionsMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */