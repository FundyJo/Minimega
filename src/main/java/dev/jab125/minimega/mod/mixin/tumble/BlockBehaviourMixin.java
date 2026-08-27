/*    */ package dev.jab125.minimega.mod.mixin.tumble;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import com.llamalad7.mixinextras.sugar.Local;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import dev.jab125.minimega.mod.util.controller.tumble.TumbleMinigameController;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.BlockGetter;
/*    */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({BlockBehaviour.class})
/*    */ public class BlockBehaviourMixin
/*    */ {
/*    */   @Inject(method = {"getDestroyProgress"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void breakingSpeed(BlockState blockState, Player player, BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<Float> cir) {}
/*    */   
/*    */   @WrapOperation(method = {"getDestroyProgress"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getDestroySpeed(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)F")})
/*    */   float that(BlockState instance, BlockGetter blockGetter, BlockPos blockPos, Operation<Float> original, @Local(argsOnly = true) Player player) {
/* 30 */     AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController(player.level()).getController(Minigame.TUMBLE); if (abstractMinigameController instanceof TumbleMinigameController) { TumbleMinigameController controller = (TumbleMinigameController)abstractMinigameController;
/* 31 */       return 0.0F; }
/*    */     
/* 33 */     return ((Float)original.call(new Object[] { instance, blockGetter, blockPos })).floatValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\tumble\BlockBehaviourMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */