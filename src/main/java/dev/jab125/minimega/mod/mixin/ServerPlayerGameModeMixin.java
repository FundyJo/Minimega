/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import dev.jab125.minimega.mod.util.controller.obj.MinigameRules;
/*    */ import net.minecraft.core.registries.BuiltInRegistries;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.server.level.ServerPlayerGameMode;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.InteractionResult;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.phys.BlockHitResult;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({ServerPlayerGameMode.class})
/*    */ public class ServerPlayerGameModeMixin {
/*    */   @Inject(method = {"useItem"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void canU(ServerPlayer serverPlayer, Level level, ItemStack itemStack, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResult> cir) {
/* 26 */     MinigameRules rules = MinigamesController.getMinigameController(level).getRules();
/* 27 */     MinigameRules.UsePermissions usePermissions = rules.usePermissions();
/* 28 */     if (usePermissions.mode() == MinigameRules.Mode.WHITELIST && 
/* 29 */       !usePermissions.exceptions().contains(BuiltInRegistries.ITEM.getKey(itemStack.getItem()))) {
/* 30 */       cir.setReturnValue(InteractionResult.PASS);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @Inject(method = {"useItemOn"}, at = {@At("HEAD")})
/*    */   void useItemOn(ServerPlayer serverPlayer, Level level, ItemStack itemStack, InteractionHand interactionHand, BlockHitResult blockHitResult, CallbackInfoReturnable<InteractionResult> cir) {}
/*    */ 
/*    */   
/*    */   @WrapOperation(method = {"useItemOn"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;useWithoutItem(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/phys/BlockHitResult;)Lnet/minecraft/world/InteractionResult;")})
/*    */   InteractionResult l(BlockState instance, Level level, Player player, BlockHitResult blockHitResult, Operation<InteractionResult> original) {
/* 42 */     MinigameRules rules = MinigamesController.getMinigameController(level).getRules();
/* 43 */     MinigameRules.BlockUsePermissions blockUsePermissions = rules.blockUsePermissions();
/* 44 */     if (blockUsePermissions.mode() == MinigameRules.Mode.WHITELIST && 
/* 45 */       !blockUsePermissions.exceptions().contains(BuiltInRegistries.BLOCK.getKey(instance.getBlock()))) {
/* 46 */       return (InteractionResult)InteractionResult.PASS;
/*    */     }
/*    */     
/* 49 */     return (InteractionResult)original.call(new Object[] { instance, level, player, blockHitResult });
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\ServerPlayerGameModeMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */