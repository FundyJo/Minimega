/*    */ package dev.jab125.minimega.mod.block;
/*    */ import com.mojang.serialization.MapCodec;
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.Direction;
/*    */ import net.minecraft.util.RandomSource;
/*    */ import net.minecraft.world.level.BlockGetter;
/*    */ import net.minecraft.world.level.LevelReader;
/*    */ import net.minecraft.world.level.ScheduledTickAccess;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.level.block.state.StateDefinition;
/*    */ import net.minecraft.world.level.block.state.properties.BlockStateProperties;
/*    */ import net.minecraft.world.level.block.state.properties.Property;
/*    */ import net.minecraft.world.level.material.Fluids;
/*    */ import net.minecraft.world.phys.shapes.CollisionContext;
/*    */ import net.minecraft.world.phys.shapes.VoxelShape;
/*    */ 
/*    */ public class SpeedBoostBlock extends Block implements SimpleWaterloggedBlock, UnregisteredBlock {
/* 21 */   public static final MapCodec<SpeedBoostBlock> CODEC = simpleCodec(SpeedBoostBlock::new);
/*    */   
/*    */   public SpeedBoostBlock(BlockBehaviour.Properties properties) {
/* 24 */     super(properties.dynamicShape());
/* 25 */     registerDefaultState((BlockState)((BlockState)getStateDefinition().any()).setValue((Property)BlockStateProperties.WATERLOGGED, Boolean.FALSE));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
/* 34 */     return super.getCollisionShape(blockState, blockGetter, blockPos, collisionContext);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
/* 39 */     builder.add(new Property[] { (Property)BlockStateProperties.WATERLOGGED });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos blockPos2, BlockState blockState2, RandomSource randomSource) {
/* 53 */     if (((Boolean)blockState.getValue((Property)BlockStateProperties.WATERLOGGED)).booleanValue()) {
/* 54 */       scheduledTickAccess.scheduleTick(blockPos, (Fluid)Fluids.WATER, Fluids.WATER.getTickDelay(levelReader));
/*    */     }
/*    */     
/* 57 */     return super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, blockPos2, blockState2, randomSource);
/*    */   }
/*    */ 
/*    */   
/*    */   protected FluidState getFluidState(BlockState blockState) {
/* 62 */     return ((Boolean)blockState.getValue((Property)BlockStateProperties.WATERLOGGED)).booleanValue() ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected MapCodec<SpeedBoostBlock> codec() {
/* 74 */     return CODEC;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\block\SpeedBoostBlock.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */