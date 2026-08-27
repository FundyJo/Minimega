/*    */ package dev.jab125.minimega.mod.client.mixin.glide;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import dev.jab125.minimega.mod.init.ModBlocks;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.CompletionStage;
/*    */ import java.util.concurrent.Executor;
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.client.resources.model.BlockStateModelLoader;
/*    */ import net.minecraft.resources.Identifier;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.level.block.state.StateDefinition;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({BlockStateModelLoader.class})
/*    */ public class BlockStateModelLoaderMixin
/*    */ {
/*    */   @Inject(method = {"lambda$loadBlockStates$1"}, at = {@At("HEAD")})
/*    */   private static void e(Function function, Executor executor, Map map, CallbackInfoReturnable<CompletionStage> cir) {}
/*    */   
/*    */   @WrapOperation(method = {"loadBlockStates"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model/BlockStateDefinitions;definitionLocationToBlockStateMapper()Ljava/util/function/Function;")})
/*    */   private static Function<Identifier, StateDefinition<Block, BlockState>> loatthat(Operation<Function<Identifier, StateDefinition<Block, BlockState>>> original) {
/* 32 */     return rl -> rl.equals(Minimega.id("diamond_ring_block")) ? ModBlocks.DIAMOND_RING_BLOCK.getStateDefinition() : (rl.equals(Minimega.id("gold_ring_block")) ? ModBlocks.GOLD_RING_BLOCK.getStateDefinition() : (rl.equals(Minimega.id("emerald_ring_block")) ? ModBlocks.EMERALD_RING_BLOCK.getStateDefinition() : (rl.equals(Minimega.id("qbooster_visualizer")) ? ModBlocks.QBOOSTER_VISUALIZER.getStateDefinition() : (rl.equals(Minimega.id("booster_visualizer")) ? ModBlocks.BOOSTER_VISUALIZER.getStateDefinition() : ((Function<Identifier, StateDefinition>)original.call(new Object[0])).apply(rl)))));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\glide\BlockStateModelLoaderMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */