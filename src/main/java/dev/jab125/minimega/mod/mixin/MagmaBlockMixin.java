/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import dev.jab125.minimega.mod.util.controller.fistfight.FistfightMinigameController;
/*    */ import net.minecraft.world.damagesource.DamageSource;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.block.MagmaBlock;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({MagmaBlock.class})
/*    */ public class MagmaBlockMixin {
/*    */   @WrapOperation(method = {"stepOn"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)V")})
/*    */   void noHurtInUnderseaOasis(Entity instance, DamageSource damageSource, float f, Operation<Void> original) {
/* 19 */     Level level = instance.level();
/* 20 */     if (level != null) { AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController(level).getController(Minigame.FISTFIGHT); if (abstractMinigameController instanceof FistfightMinigameController) { FistfightMinigameController controller = (FistfightMinigameController)abstractMinigameController; if (controller.getFistfightFlag() != 45)
/* 21 */         { original.call(new Object[] { instance, damageSource, Float.valueOf(f) }); return; }  return; }  }  original.call(new Object[] { instance, damageSource, Float.valueOf(f) });
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\MagmaBlockMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */