/*    */ package dev.jab125.minimega.mod.init;
/*    */ 
/*    */ import com.mojang.serialization.MapCodec;
/*    */ import dev.jab125.minimega.mod.block.UnregisteredBlock;
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.Direction;
/*    */ import net.minecraft.world.level.BlockGetter;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.minecraft.world.level.block.DirectionalBlock;
/*    */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.level.block.state.StateDefinition;
/*    */ import net.minecraft.world.level.block.state.properties.Property;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class MyDirectionalBlock
/*    */   extends DirectionalBlock
/*    */   implements UnregisteredBlock
/*    */ {
/* 38 */   public static final MapCodec<MyDirectionalBlock> CODEC = simpleCodec(MyDirectionalBlock::new);
/*    */   
/*    */   public MyDirectionalBlock(BlockBehaviour.Properties properties) {
/* 41 */     super(properties.emissiveRendering((blockState, blockGetter, blockPos) -> true));
/* 42 */     registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)FACING, (Comparable)Direction.UP));
/*    */   }
/*    */ 
/*    */   
/*    */   protected MapCodec<? extends DirectionalBlock> codec() {
/* 47 */     return (MapCodec)CODEC;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
/* 52 */     builder.add(new Property[] { (Property)FACING });
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\init\ModBlocks$MyDirectionalBlock.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */