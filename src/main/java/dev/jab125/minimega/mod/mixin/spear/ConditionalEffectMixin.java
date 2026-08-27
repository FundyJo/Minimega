/*    */ package dev.jab125.minimega.mod.mixin.spear;
/*    */ import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import dev.jab125.minimega.mod.util.MinigameFoodConstant;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.minecraft.world.item.enchantment.ConditionalEffect;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.storage.loot.LootContext;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ 
/*    */ @Mixin({ConditionalEffect.class})
/*    */ public class ConditionalEffectMixin {
/*    */   @WrapMethod(method = {"matches"})
/*    */   boolean matches(LootContext context, Operation<Boolean> original) {
/* 16 */     return ((Boolean)ScopedValue.<Integer>where(Minimega.ENCHANTMENT_CONTEXT, Integer.valueOf(MinigamesController.getMinigameController((Level)context.getLevel()).getFoodConstantI(MinigameFoodConstant.SPRINT_LEVEL))).call(() -> (Boolean)original.call(new Object[] { context }))).booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\spear\ConditionalEffectMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */