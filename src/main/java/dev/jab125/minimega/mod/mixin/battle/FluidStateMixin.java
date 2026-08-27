/*    */ package dev.jab125.minimega.mod.mixin.battle;
/*    */ 
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.tags.FluidTags;
/*    */ import net.minecraft.world.level.BlockGetter;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.block.Blocks;
/*    */ import net.minecraft.world.level.material.Fluid;
/*    */ import net.minecraft.world.level.material.FluidState;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({FluidState.class})
/*    */ public abstract class FluidStateMixin {
/*    */   @Shadow
/*    */   public abstract Fluid getType();
/*    */   
/*    */   @Inject(method = {"getHeight"}, at = {@At("RETURN")}, cancellable = true)
/*    */   void cwf(BlockGetter level, BlockPos pos, CallbackInfoReturnable<Float> cir) {
/* 24 */     if (level instanceof Level) { Level level1 = (Level)level; if ((MinigamesController.getMinigameController(level1).minigameAbilities()).shorterLavaNextToSoulSand) {
/* 25 */         if (!level.getFluidState(pos.above()).isEmpty())
/* 26 */           return;  if (!level.getBlockState(pos.above()).isAir())
/* 27 */           return;  if (!getType().is(FluidTags.LAVA))
/* 28 */           return;  for (BlockPos blockPos : BlockPos.betweenClosed(pos.getX() - 1, pos.getY(), pos.getZ() - 1, pos.getX() + 1, pos.getY(), pos.getZ() + 1)) {
/* 29 */           if (level.getBlockState(blockPos).is(Blocks.SOUL_SAND)) {
/* 30 */             cir.setReturnValue(Float.valueOf(Math.min(cir.getReturnValueF(), 0.84375F)));
/*    */             return;
/*    */           } 
/*    */         } 
/*    */         return;
/*    */       }  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\battle\FluidStateMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */