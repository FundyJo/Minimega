/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.block.TntBlock;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.gen.Invoker;
/*    */ 
/*    */ @Mixin({TntBlock.class})
/*    */ public interface TntBlockAccessor {
/*    */   @Invoker
/*    */   static boolean callPrime(Level level, BlockPos pos, LivingEntity source) {
/* 13 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\TntBlockAccessor.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */