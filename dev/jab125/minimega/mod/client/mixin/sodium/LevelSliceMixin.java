/*    */ package dev.jab125.minimega.mod.client.mixin.sodium;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import com.llamalad7.mixinextras.sugar.Local;
/*    */ import dev.jab125.minimega.mod.init.ModBlocks;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import dev.jab125.minimega.mod.util.controller.glide.GlideMinigameController;
/*    */ import java.util.Optional;
/*    */ import net.caffeinemc.mods.sodium.client.world.LevelSlice;
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.SectionPos;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.level.chunk.LevelChunkSection;
/*    */ import org.spongepowered.asm.mixin.Dynamic;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({LevelSlice.class})
/*    */ public class LevelSliceMixin {
/*    */   @Shadow
/*    */   @Final
/*    */   private ClientLevel level;
/*    */   
/*    */   @WrapOperation(method = {"prepare"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/level/chunk/LevelChunkSection;hasOnlyAir()Z")})
/*    */   @Dynamic
/*    */   private static boolean mm$prepare(LevelChunkSection instance, Operation<Boolean> operation, @Local(argsOnly = true) SectionPos pos, @Local(argsOnly = true) Level level) {
/*    */     GlideMinigameController controller;
/* 36 */     AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController(level).getController(Minigame.GLIDE); if (abstractMinigameController instanceof GlideMinigameController) { controller = (GlideMinigameController)abstractMinigameController; }
/* 37 */     else { return ((Boolean)operation.call(new Object[] { instance })).booleanValue(); }
/* 38 */      if (controller.isSectionPosForceLoaded(pos)) return false; 
/* 39 */     return ((Boolean)operation.call(new Object[] { instance })).booleanValue();
/*    */   }
/*    */   @Inject(method = {"getBlockState(III)Lnet/minecraft/world/level/block/state/BlockState;"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void mm$getBlockState(int x, int y, int z, CallbackInfoReturnable<BlockState> cir) {
/*    */     GlideMinigameController controller;
/* 44 */     AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController((Level)this.level).getController(Minigame.GLIDE); if (abstractMinigameController instanceof GlideMinigameController) { controller = (GlideMinigameController)abstractMinigameController; }
/*    */     else { return; }
/* 46 */      BlockPos blockPos = new BlockPos(x, y, z);
/*    */     Optional<GlideMinigameController.ScoreRing> ring;
/* 48 */     if ((ring = controller.getScoreRings().stream().filter(a -> a.shouldChange(blockPos)).findFirst()).isPresent()) {
/* 49 */       switch (((GlideMinigameController.ScoreRing)ring.get()).size) { default: throw new MatchException(null, null);case SMALL: case MEDIUM: case LARGE: break; }  cir.setReturnValue(
/*    */ 
/*    */           
/* 52 */           ModBlocks.EMERALD_RING_BLOCK
/* 53 */           .defaultBlockState());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\sodium\LevelSliceMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */