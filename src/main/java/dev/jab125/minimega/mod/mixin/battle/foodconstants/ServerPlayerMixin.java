/*    */ package dev.jab125.minimega.mod.mixin.battle.foodconstants;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.util.MinigameFoodConstant;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({ServerPlayer.class})
/*    */ public class ServerPlayerMixin {
/*    */   @WrapOperation(method = {"jumpFromGround"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerPlayer;causeFoodExhaustion(F)V")})
/*    */   void jumpFromGround(ServerPlayer instance, float v, Operation<Void> original) {
/* 16 */     MinigamesController minigameController = MinigamesController.getMinigameController((Level)instance.level());
/* 17 */     if (v == 0.05F) {
/* 18 */       v = minigameController.getFoodConstantF(MinigameFoodConstant.EXHAUSTION_JUMP);
/* 19 */     } else if (v == 0.2F) {
/* 20 */       v = minigameController.getFoodConstantF(MinigameFoodConstant.EXHAUSTION_SPRINT_JUMP);
/*    */     } 
/* 22 */     original.call(new Object[] { instance, Float.valueOf(v) });
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\battle\foodconstants\ServerPlayerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */