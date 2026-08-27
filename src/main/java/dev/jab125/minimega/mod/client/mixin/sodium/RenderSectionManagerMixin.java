/*    */ package dev.jab125.minimega.mod.client.mixin.sodium;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import com.llamalad7.mixinextras.sugar.Local;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import dev.jab125.minimega.mod.util.controller.glide.GlideMinigameController;
/*    */ import net.caffeinemc.mods.sodium.client.render.chunk.RenderSectionManager;
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.core.SectionPos;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.chunk.LevelChunkSection;
/*    */ import org.spongepowered.asm.mixin.Dynamic;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({RenderSectionManager.class})
/*    */ public class RenderSectionManagerMixin
/*    */ {
/*    */   @WrapOperation(method = {"onSectionAdded"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/level/chunk/LevelChunkSection;hasOnlyAir()Z")})
/*    */   @Dynamic
/*    */   boolean mm$onSectionAdded(LevelChunkSection instance, Operation<Boolean> operation, @Local(argsOnly = true, ordinal = 0) int x, @Local(argsOnly = true, ordinal = 1) int y, @Local(argsOnly = true, ordinal = 2) int z) {
/*    */     GlideMinigameController controller;
/* 28 */     AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController((Level)this.level).getController(Minigame.GLIDE); if (abstractMinigameController instanceof GlideMinigameController) { controller = (GlideMinigameController)abstractMinigameController; }
/* 29 */     else { return ((Boolean)operation.call(new Object[] { instance })).booleanValue(); }
/* 30 */      if (controller.isSectionPosForceLoaded(SectionPos.of(x, y, z))) return false; 
/* 31 */     return ((Boolean)operation.call(new Object[] { instance })).booleanValue();
/*    */   }
/*    */   
/*    */   @Shadow
/*    */   @Final
/*    */   private ClientLevel level;
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\sodium\RenderSectionManagerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */