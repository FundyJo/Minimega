/*    */ package dev.jab125.minimega.mod.block;
/*    */ 
/*    */ import java.util.function.BiConsumer;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.util.RandomSource;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.projectile.Projectile;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.Explosion;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.LevelReader;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.minecraft.world.level.block.Blocks;
/*    */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.level.redstone.Orientation;
/*    */ import net.minecraft.world.phys.BlockHitResult;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ public class RingBlock extends Block implements UnregisteredBlock {
/*    */   public RingBlock(BlockBehaviour.Properties properties) {
/* 23 */     super(properties);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
/* 29 */     level.setBlockAndUpdate(blockPos, Blocks.AIR.defaultBlockState());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
/* 34 */     serverLevel.setBlockAndUpdate(blockPos, Blocks.AIR.defaultBlockState());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
/* 39 */     serverLevel.setBlockAndUpdate(blockPos, Blocks.AIR.defaultBlockState());
/*    */   }
/*    */ 
/*    */   
/*    */   public void fallOn(Level level, BlockState blockState, BlockPos blockPos, Entity entity, double f) {
/* 44 */     level.setBlockAndUpdate(blockPos, Blocks.AIR.defaultBlockState());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, @Nullable Orientation orientation, boolean bl) {
/* 49 */     level.setBlockAndUpdate(blockPos, Blocks.AIR.defaultBlockState());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void onExplosionHit(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, Explosion explosion, BiConsumer<ItemStack, BlockPos> biConsumer) {
/* 54 */     serverLevel.setBlockAndUpdate(blockPos, Blocks.AIR.defaultBlockState());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void onProjectileHit(Level level, BlockState blockState, BlockHitResult blockHitResult, Projectile projectile) {
/* 59 */     level.setBlockAndUpdate(blockHitResult.getBlockPos(), Blocks.AIR.defaultBlockState());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
/* 70 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\block\RingBlock.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */