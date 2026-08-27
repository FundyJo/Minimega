/*    */ package dev.jab125.minimega.mod.client.mixin;
/*    */ 
/*    */ import dev.jab125.minimega.mod.init.ModBlocks;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import dev.jab125.minimega.mod.util.controller.glide.GlideMinigameController;
/*    */ import java.util.Optional;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.level.LevelHeightAccessor;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.level.chunk.LevelChunk;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin(targets = {"net.minecraft.client.renderer.chunk.SectionCopy"})
/*    */ public class RenderChunkMixin {
/*    */   @Shadow
/*    */   @Final
/*    */   private LevelHeightAccessor levelHeightAccessor;
/*    */   
/*    */   @Inject(method = {"getBlockState"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void getBlockState(BlockPos blockPos, CallbackInfoReturnable<BlockState> cir) {
/* 28 */     AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController(((LevelChunk)this.levelHeightAccessor).getLevel()).getController(Minigame.GLIDE); GlideMinigameController controller = (GlideMinigameController)abstractMinigameController; Optional<GlideMinigameController.ScoreRing> ring; if (abstractMinigameController instanceof GlideMinigameController && (
/*    */       
/* 30 */       ring = controller.getScoreRings().stream().filter(a -> a.shouldChange(blockPos)).findFirst()).isPresent()) {
/* 31 */       switch (((GlideMinigameController.ScoreRing)ring.get()).size) { default: throw new MatchException(null, null);case SMALL: case MEDIUM: case LARGE: break; }  cir.setReturnValue(
/*    */ 
/*    */           
/* 34 */           ModBlocks.EMERALD_RING_BLOCK
/* 35 */           .defaultBlockState());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\RenderChunkMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */