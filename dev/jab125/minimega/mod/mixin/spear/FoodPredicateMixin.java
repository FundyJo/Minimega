/*    */ package dev.jab125.minimega.mod.mixin.spear;
/*    */ 
/*    */ import com.llamalad7.mixinextras.expression.Definition;
/*    */ import com.llamalad7.mixinextras.expression.Definitions;
/*    */ import com.llamalad7.mixinextras.expression.Expression;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import java.util.Objects;
/*    */ import java.util.Optional;
/*    */ import net.minecraft.advancements.criterion.FoodPredicate;
/*    */ import net.minecraft.advancements.criterion.MinMaxBounds;
/*    */ import net.minecraft.util.Mth;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({FoodPredicate.class})
/*    */ public class FoodPredicateMixin {
/*    */   @WrapOperation(method = {"matches"}, at = {@At("MIXINEXTRAS:EXPRESSION")})
/*    */   @Definitions({@Definition(id = "level", field = {"Lnet/minecraft/advancements/criterion/FoodPredicate;level:Lnet/minecraft/advancements/criterion/MinMaxBounds$Ints;"}), @Definition(id = "matches", method = {"Lnet/minecraft/advancements/criterion/MinMaxBounds$Ints;matches(I)Z"})})
/*    */   @Expression({"this.level.matches(?)"})
/*    */   boolean helpme(MinMaxBounds.Ints instance, int value, Operation<Boolean> original) {
/* 23 */     Objects.requireNonNull(Integer.valueOf(7)); if (Minimega.ENCHANTMENT_CONTEXT.isBound() && ((Boolean)instance.bounds().min().map(Integer.valueOf(7)::equals).orElse(Boolean.valueOf(false))).booleanValue()) {
/* 24 */       MinMaxBounds.Bounds<Integer> bounds = new MinMaxBounds.Bounds(Optional.of(Integer.valueOf(((Integer)Minimega.ENCHANTMENT_CONTEXT.get()).intValue() + 1)), instance.bounds().max());
/* 25 */       instance = new MinMaxBounds.Ints(bounds, bounds.map(a -> Long.valueOf(Mth.square(a.longValue()))));
/*    */     } 
/* 27 */     return ((Boolean)original.call(new Object[] { instance, Integer.valueOf(value) })).booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\spear\FoodPredicateMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */