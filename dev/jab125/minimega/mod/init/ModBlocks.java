/*    */ package dev.jab125.minimega.mod.init;
/*    */ import com.mojang.serialization.MapCodec;
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import dev.jab125.minimega.mod.block.RingBlock;
/*    */ import dev.jab125.minimega.mod.block.UnregisteredBlock;
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.world.level.BlockGetter;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.minecraft.world.level.block.DirectionalBlock;
/*    */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.level.block.state.StateDefinition;
/*    */ import net.minecraft.world.level.block.state.properties.Property;
/*    */ 
/*    */ public class ModBlocks {
/* 18 */   public static final Block DIAMOND_RING_BLOCK = (Block)new RingBlock(BlockBehaviour.Properties.of().destroyTime(-1.0F).explosionResistance(1800000.0F).noCollision().setId(ResourceKey.create(Registries.BLOCK, Minimega.id("diamond_ring_block"))));
/* 19 */   public static final Block GOLD_RING_BLOCK = (Block)new RingBlock(BlockBehaviour.Properties.of().destroyTime(-1.0F).explosionResistance(1800000.0F).noCollision().setId(ResourceKey.create(Registries.BLOCK, Minimega.id("gold_ring_block"))));
/* 20 */   public static final Block EMERALD_RING_BLOCK = (Block)new RingBlock(BlockBehaviour.Properties.of().destroyTime(-1.0F).explosionResistance(1800000.0F).noCollision().setId(ResourceKey.create(Registries.BLOCK, Minimega.id("emerald_ring_block"))));
/* 21 */   public static final Block THERMAL_VISUALIZER = (Block)new RingBlock(BlockBehaviour.Properties.of().destroyTime(-1.0F).explosionResistance(1800000.0F).noCollision().setId(ResourceKey.create(Registries.BLOCK, Minimega.id("thermal_visualizer"))));
/* 22 */   public static final Block ABSOLUTE_SPEED_BOOST = (Block)new SpeedBoostBlock(BlockBehaviour.Properties.of().destroyTime(-1.0F).explosionResistance(1800000.0F).noCollision().setId(ResourceKey.create(Registries.BLOCK, Minimega.id("absolute_speed_boost"))));
/* 23 */   public static final Block BOOSTER_VISUALIZER = (Block)new MyDirectionalBlock(BlockBehaviour.Properties.of().destroyTime(-1.0F).explosionResistance(1800000.0F).noCollision().setId(ResourceKey.create(Registries.BLOCK, Minimega.id("booster_visualizer"))));
/* 24 */   public static final Block QBOOSTER_VISUALIZER = (Block)new MyDirectionalBlock(BlockBehaviour.Properties.of().destroyTime(-1.0F).explosionResistance(1800000.0F).noCollision().setId(ResourceKey.create(Registries.BLOCK, Minimega.id("qbooster_visualizer"))));
/*    */ 
/*    */   
/*    */   public static void init() {
/* 28 */     DIAMOND_RING_BLOCK.defaultBlockState().initCache();
/* 29 */     GOLD_RING_BLOCK.defaultBlockState().initCache();
/* 30 */     EMERALD_RING_BLOCK.defaultBlockState().initCache();
/* 31 */     ABSOLUTE_SPEED_BOOST.getStateDefinition().getPossibleStates().forEach(BlockBehaviour.BlockStateBase::initCache);
/* 32 */     BOOSTER_VISUALIZER.getStateDefinition().getPossibleStates().forEach(BlockBehaviour.BlockStateBase::initCache);
/* 33 */     QBOOSTER_VISUALIZER.getStateDefinition().getPossibleStates().forEach(BlockBehaviour.BlockStateBase::initCache);
/* 34 */     THERMAL_VISUALIZER.getStateDefinition().getPossibleStates().forEach(BlockBehaviour.BlockStateBase::initCache);
/*    */   }
/*    */   
/*    */   private static class MyDirectionalBlock extends DirectionalBlock implements UnregisteredBlock {
/* 38 */     public static final MapCodec<MyDirectionalBlock> CODEC = simpleCodec(MyDirectionalBlock::new);
/*    */     
/*    */     public MyDirectionalBlock(BlockBehaviour.Properties properties) {
/* 41 */       super(properties.emissiveRendering((blockState, blockGetter, blockPos) -> true));
/* 42 */       registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)FACING, (Comparable)Direction.UP));
/*    */     }
/*    */ 
/*    */     
/*    */     protected MapCodec<? extends DirectionalBlock> codec() {
/* 47 */       return (MapCodec)CODEC;
/*    */     }
/*    */ 
/*    */     
/*    */     protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
/* 52 */       builder.add(new Property[] { (Property)FACING });
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\init\ModBlocks.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */