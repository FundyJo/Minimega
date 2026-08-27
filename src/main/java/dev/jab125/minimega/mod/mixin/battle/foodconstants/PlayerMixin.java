/*    */ package dev.jab125.minimega.mod.mixin.battle.foodconstants;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.util.MinigameFoodConstant;
/*    */ import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.minecraft.world.entity.Avatar;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.food.FoodData;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({Player.class})
/*    */ public abstract class PlayerMixin extends Avatar {
/*    */   protected PlayerMixin() {
/* 17 */     super(null, null);
/*    */   }
/*    */   
/*    */   @WrapOperation(method = {"attack"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;causeFoodExhaustion(F)V")})
/*    */   void attack(Player instance, float f, Operation<Void> original) {
/* 22 */     if (MinigamesController.getMinigameController(instance.level()).isActive()) {
/* 23 */       MinigamesController minigameController = MinigamesController.getMinigameController(instance.level());
/* 24 */       AbstractMinigameController<?> controller = minigameController.getController(minigameController.getActiveMinigame());
/* 25 */       assert controller != null;
/* 26 */       original.call(new Object[] { instance, Float.valueOf(controller.getFoodConstantF(MinigameFoodConstant.EXHAUSTION_ATTACK)) });
/*    */       return;
/*    */     } 
/* 29 */     original.call(new Object[] { instance, Float.valueOf(f) });
/*    */   }
/*    */   @WrapOperation(method = {"hasEnoughFoodToDoExhaustiveManoeuvres"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/food/FoodData;hasEnoughFood()Z")})
/*    */   boolean hasEnoughFoodToDoExhaustiveManoeuvres(FoodData instance, Operation<Boolean> original) {
/* 33 */     if (MinigamesController.getMinigameController(level()).isActive()) return (instance.getFoodLevel() > MinigamesController.getMinigameController(level()).getFoodConstantI(MinigameFoodConstant.SPRINT_LEVEL)); 
/* 34 */     return ((Boolean)original.call(new Object[] { instance })).booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\battle\foodconstants\PlayerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */