/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.world.inventory.RecipeCraftingHolder;
/*    */ import net.minecraft.world.item.crafting.RecipeHolder;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({RecipeCraftingHolder.class})
/*    */ public interface RecipeCraftingHolderMixin {
/*    */   @Inject(method = {"setRecipeUsed(Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/world/item/crafting/RecipeHolder;)Z"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void mm$setRecipeUsed(ServerPlayer serverPlayer, RecipeHolder<?> recipeHolder, CallbackInfoReturnable<Boolean> cir) {
/* 17 */     Minigame<?> activeMinigame = MinigamesController.getMinigameController((Level)serverPlayer.level()).getActiveMinigame();
/* 18 */     if (activeMinigame == Minigame.FISTFIGHT || activeMinigame == Minigame.BATTLE)
/* 19 */       cir.setReturnValue(Boolean.valueOf(false)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\RecipeCraftingHolderMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */