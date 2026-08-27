/*    */ package dev.jab125.minimega.mod.client.mixin.smallinv;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import com.mojang.blaze3d.pipeline.RenderPipeline;
/*    */ import dev.jab125.minimega.mod.client.MinimegaClient;
/*    */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*    */ import net.minecraft.client.gui.navigation.ScreenPosition;
/*    */ import net.minecraft.client.gui.screens.inventory.AbstractRecipeBookScreen;
/*    */ import net.minecraft.client.gui.screens.inventory.InventoryScreen;
/*    */ import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.resources.Identifier;
/*    */ import net.minecraft.world.entity.player.Inventory;
/*    */ import net.minecraft.world.inventory.InventoryMenu;
/*    */ import net.minecraft.world.inventory.RecipeBookMenu;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({InventoryScreen.class})
/*    */ public abstract class InventoryScreenMixin
/*    */   extends AbstractRecipeBookScreen<InventoryMenu> {
/*    */   public InventoryScreenMixin(InventoryMenu recipeBookMenu, RecipeBookComponent<?> recipeBookComponent, Inventory inventory, Component component) {
/* 24 */     super((RecipeBookMenu)recipeBookMenu, recipeBookComponent, inventory, component);
/*    */   }
/*    */   
/*    */   @WrapOperation(method = {"extractBackground"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;blit(Lcom/mojang/blaze3d/pipeline/RenderPipeline;Lnet/minecraft/resources/Identifier;IIFFIIII)V")})
/*    */   void renderBg(GuiGraphicsExtractor instance, RenderPipeline pipeline, Identifier location, int x, int y, float uOffset, float vOffset, int uWidth, int vHeight, int textureWidth, int textureHeight, Operation<Void> original) {
/* 29 */     if (MinimegaClient.getController().isSmallInventory()) {
/* 30 */       instance.blit(pipeline, location, x, y, uOffset, vOffset, uWidth, 79, textureWidth, textureHeight);
/* 31 */       instance.blit(pipeline, location, x, y + 79, uOffset, vOffset + 79.0F + 58.0F, uWidth, vHeight - 79 - 58, textureWidth, textureHeight);
/*    */     } else {
/* 33 */       original.call(new Object[] { instance, pipeline, location, Integer.valueOf(x), Integer.valueOf(y), Float.valueOf(uOffset), Float.valueOf(vOffset), Integer.valueOf(uWidth), Integer.valueOf(vHeight), Integer.valueOf(textureWidth), Integer.valueOf(textureHeight) });
/*    */     } 
/*    */   }
/*    */   @WrapOperation(method = {"getRecipeBookButtonPosition"}, at = {@At(value = "NEW", target = "net/minecraft/client/gui/navigation/ScreenPosition")})
/*    */   ScreenPosition getRecipeBookButtonLocation(int a, int b, Operation<ScreenPosition> constructor) {
/* 38 */     if (MinimegaClient.getController().isSmallInventory()) {
/* 39 */       return (ScreenPosition)constructor.call(new Object[] { Integer.valueOf(a), Integer.valueOf(b + 29) });
/*    */     }
/* 41 */     return (ScreenPosition)constructor.call(new Object[] { Integer.valueOf(a), Integer.valueOf(b) });
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\smallinv\InventoryScreenMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */