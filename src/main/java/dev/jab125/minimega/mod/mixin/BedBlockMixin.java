/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ 
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.InteractionResult;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.block.BedBlock;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.phys.BlockHitResult;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({BedBlock.class})
/*    */ public abstract class BedBlockMixin {
/*    */   @Inject(method = {"useWithoutItem"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void minimega$preventBedUse(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult, CallbackInfoReturnable<InteractionResult> cir) {
/* 20 */     if (MinigamesController.getMinigameController(level).isActive())
/* 21 */       cir.setReturnValue(InteractionResult.FAIL); 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\BedBlockMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */