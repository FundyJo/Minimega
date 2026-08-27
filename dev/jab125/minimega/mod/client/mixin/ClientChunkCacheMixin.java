/*    */ package dev.jab125.minimega.mod.client.mixin;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.sugar.Local;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import dev.jab125.minimega.mod.util.controller.glide.GlideMinigameController;
/*    */ import net.minecraft.core.SectionPos;
/*    */ import net.minecraft.world.level.chunk.LevelChunk;
/*    */ import net.minecraft.world.level.chunk.LevelChunkSection;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin(targets = {"net.minecraft.client.multiplayer.ClientChunkCache$Storage"})
/*    */ public class ClientChunkCacheMixin {
/*    */   @WrapOperation(method = {"addEmptySections", "refreshEmptySections"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/level/chunk/LevelChunkSection;hasOnlyAir()Z")})
/*    */   boolean hasOnlyAir(LevelChunkSection instance, Operation<Boolean> original, @Local(argsOnly = true) LevelChunk chunk, @Local int i) {
/*    */     GlideMinigameController controller;
/* 19 */     AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController(chunk.getLevel()).getController(Minigame.GLIDE); if (abstractMinigameController instanceof GlideMinigameController) { controller = (GlideMinigameController)abstractMinigameController; }
/* 20 */     else { return ((Boolean)original.call(new Object[] { instance })).booleanValue(); }
/* 21 */      SectionPos sectionPos = SectionPos.of(chunk.getPos(), chunk.getSectionIndexFromSectionY(i));
/* 22 */     if (controller.isSectionPosForceLoaded(sectionPos)) {
/* 23 */       return false;
/*    */     }
/* 25 */     return ((Boolean)original.call(new Object[] { instance })).booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\ClientChunkCacheMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */