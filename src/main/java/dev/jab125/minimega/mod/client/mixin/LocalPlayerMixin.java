/*    */ package dev.jab125.minimega.mod.client.mixin;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.minecraft.client.player.ClientInput;
/*    */ import net.minecraft.client.player.LocalPlayer;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({LocalPlayer.class})
/*    */ public class LocalPlayerMixin {
/*    */   @WrapOperation(method = {"aiStep"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/player/ClientInput;tick()V")})
/*    */   void tick(ClientInput instance, Operation<Void> original) {
/* 15 */     if (MinigamesController.getMinigameController(((LocalPlayer)this).level()).movementDisabled())
/* 16 */       return;  original.call(new Object[] { instance });
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\LocalPlayerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */