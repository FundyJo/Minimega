/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ 
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.LevelReader;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ @Mixin({BlockBehaviour.BlockStateBase.class})
/*    */ public abstract class BlockStateBaseMixin
/*    */ {
/*    */   @Shadow
/*    */   public abstract Block getBlock();
/*    */   
/*    */   @Inject(method = {"canSurvive"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void canSurvive(LevelReader levelReader, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
/* 24 */     if (levelReader instanceof Level) { Level level = (Level)levelReader; if (MinigamesController.getMinigameController(level).glideActive())
/* 25 */         cir.setReturnValue(Boolean.valueOf(true));  }
/*    */   
/*    */   }
/*    */   @Inject(method = {"is(Lnet/minecraft/core/Holder;)Z", "is(Lnet/minecraft/tags/TagKey;)Z", "is(Lnet/minecraft/tags/TagKey;Ljava/util/function/Predicate;)Z", "is(Lnet/minecraft/core/HolderSet;)Z", "is(Lnet/minecraft/resources/ResourceKey;)Z"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void is(CallbackInfoReturnable<Boolean> cir) {
/* 30 */     if (getBlock() instanceof dev.jab125.minimega.mod.block.UnregisteredBlock) cir.setReturnValue(Boolean.valueOf(false)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\BlockStateBaseMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */