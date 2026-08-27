/*    */ package dev.jab125.minimega.mod.mixin.tumble;
/*    */ 
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.projectile.Projectile;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.block.Blocks;
/*    */ import net.minecraft.world.level.block.TntBlock;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.phys.BlockHitResult;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({Projectile.class})
/*    */ public abstract class ProjectileMixin extends Entity {
/*    */   public ProjectileMixin(EntityType<?> entityType, Level level) {
/* 21 */     super(entityType, level);
/*    */   }
/*    */   
/*    */   @Inject(method = {"onHitBlock"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void onHitBlock(BlockHitResult blockHitResult, CallbackInfo ci) {
/* 26 */     Minigame<?> activeMinigame = MinigamesController.getMinigameController(level()).getActiveMinigame();
/* 27 */     EntityType<?> type = getType();
/* 28 */     if (activeMinigame == Minigame.TUMBLE && !level().isClientSide() && (type == EntityType.SNOWBALL || type == EntityType.SPLASH_POTION)) {
/* 29 */       BlockState blockState = level().getBlockState(blockHitResult.getBlockPos());
/* 30 */       if (blockState.is(Blocks.TNT)) {
/* 31 */         TntBlock.prime(level(), blockHitResult.getBlockPos());
/*    */       }
/* 33 */       level().destroyBlock(blockHitResult.getBlockPos(), false);
/* 34 */       ci.cancel();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\tumble\ProjectileMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */