/*    */ package dev.jab125.minimega.mod.mixin.battle.foodconstants;
/*    */ import com.llamalad7.mixinextras.expression.Definition;
/*    */ import com.llamalad7.mixinextras.expression.Expression;
/*    */ import com.llamalad7.mixinextras.expression.Expressions;
/*    */ import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
/*    */ import com.llamalad7.mixinextras.sugar.Local;
/*    */ import dev.jab125.minimega.mod.util.MinigameFoodConstant;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.world.food.FoodData;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({FoodData.class})
/*    */ public class FoodDataMixin {
/*    */   @ModifyExpressionValue(method = {"tick"}, at = {@At("MIXINEXTRAS:EXPRESSION")})
/*    */   @Definition(id = "tickTimer", field = {"Lnet/minecraft/world/food/FoodData;tickTimer:I"})
/*    */   @Expression({"this.tickTimer >= @(80)"})
/*    */   int healthTickCount(int original, @Local(argsOnly = true) ServerPlayer serverPlayer) {
/* 22 */     return controller(serverPlayer).getFoodConstantI(MinigameFoodConstant.HEALTH_TICK_COUNT);
/*    */   }
/*    */   
/*    */   @ModifyExpressionValue(method = {"tick"}, at = {@At("MIXINEXTRAS:EXPRESSION")})
/*    */   @Definition(id = "tickTimer", field = {"Lnet/minecraft/world/food/FoodData;tickTimer:I"})
/*    */   @Expression({"this.tickTimer >= @(10)"})
/*    */   int healthTickCountSaturated(int original, @Local(argsOnly = true) ServerPlayer serverPlayer) {
/* 29 */     return controller(serverPlayer).getFoodConstantI(MinigameFoodConstant.HEALTH_TICK_COUNT_SATURATED);
/*    */   }
/*    */ 
/*    */   
/*    */   @ModifyExpressionValue(method = {"tick"}, at = {@At("MIXINEXTRAS:EXPRESSION")})
/*    */   @Definition(id = "exhaustionLevel", field = {"Lnet/minecraft/world/food/FoodData;exhaustionLevel:F"})
/*    */   @Expressions({@Expression({"this.exhaustionLevel > @(4.0)"}), @Expression({"?.exhaustionLevel = ?.exhaustionLevel - @(4.0)"})})
/*    */   float exhaustionDrop(float original, @Local(argsOnly = true) ServerPlayer serverPlayer) {
/* 37 */     return controller(serverPlayer).getFoodConstantF(MinigameFoodConstant.EXHAUSTION_DROP);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @ModifyExpressionValue(method = {"tick"}, at = {@At("MIXINEXTRAS:EXPRESSION")})
/*    */   @Definitions({@Definition(id = "min", method = {"Ljava/lang/Math;min(FF)F"}), @Definition(id = "saturationLevel", field = {"Lnet/minecraft/world/food/FoodData;saturationLevel:F"}), @Definition(id = "serverPlayer", local = {@Local(type = ServerPlayer.class, argsOnly = true)}), @Definition(id = "heal", method = {"Lnet/minecraft/server/level/ServerPlayer;heal(F)V"}), @Definition(id = "addExhaustion", method = {"Lnet/minecraft/world/food/FoodData;addExhaustion(F)V"})})
/*    */   @Expressions({@Expression({"min(this.saturationLevel, @(6.0))"}), @Expression({"serverPlayer.heal(? / @(6.0))"}), @Expression({"this.addExhaustion(@(6.0))"})})
/*    */   float exhaustionHeal(float original, @Local(argsOnly = true) ServerPlayer serverPlayer) {
/* 50 */     return controller(serverPlayer).getFoodConstantF(MinigameFoodConstant.EXHAUSTION_HEAL);
/*    */   }
/*    */   
/*    */   @ModifyExpressionValue(method = {"tick"}, at = {@At("MIXINEXTRAS:EXPRESSION")})
/*    */   @Definition(id = "foodLevel", field = {"Lnet/minecraft/world/food/FoodData;foodLevel:I"})
/*    */   @Expression({"this.foodLevel <= @(0)"})
/*    */   int starveLevel(int original, @Local(argsOnly = true) ServerPlayer serverPlayer) {
/* 57 */     return controller(serverPlayer).getFoodConstantI(MinigameFoodConstant.STARVE_LEVEL);
/*    */   }
/*    */   
/*    */   @ModifyExpressionValue(method = {"tick"}, at = {@At("MIXINEXTRAS:EXPRESSION")})
/*    */   @Definition(id = "foodLevel", field = {"Lnet/minecraft/world/food/FoodData;foodLevel:I"})
/*    */   @Expression({"this.foodLevel >= @(18)"})
/*    */   int healLevel(int original, @Local(argsOnly = true) ServerPlayer serverPlayer) {
/* 64 */     return controller(serverPlayer).getFoodConstantI(MinigameFoodConstant.HEAL_LEVEL);
/*    */   }
/*    */   
/*    */   @Unique
/*    */   private MinigamesController controller(ServerPlayer serverPlayer) {
/* 69 */     return MinigamesController.getMinigameController((Level)serverPlayer.level());
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\battle\foodconstants\FoodDataMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */