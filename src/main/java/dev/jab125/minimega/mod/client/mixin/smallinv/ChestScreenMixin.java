/*    */ package dev.jab125.minimega.mod.client.mixin.smallinv;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import com.mojang.blaze3d.pipeline.RenderPipeline;
/*    */ import dev.jab125.minimega.mod.client.MinimegaClient;
/*    */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*    */ import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
/*    */ import net.minecraft.client.gui.screens.inventory.ContainerScreen;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.resources.Identifier;
/*    */ import net.minecraft.world.entity.player.Inventory;
/*    */ import net.minecraft.world.inventory.AbstractContainerMenu;
/*    */ import net.minecraft.world.inventory.ChestMenu;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.ModifyVariable;
/*    */ 
/*    */ @Mixin({ContainerScreen.class})
/*    */ public abstract class ChestScreenMixin
/*    */   extends AbstractContainerScreen<ChestMenu> {
/*    */   public ChestScreenMixin(ChestMenu abstractContainerMenu, Inventory inventory, Component component) {
/* 23 */     super((AbstractContainerMenu)abstractContainerMenu, inventory, component);
/*    */   }
/*    */   
/*    */   @WrapOperation(method = {"extractBackground"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;blit(Lcom/mojang/blaze3d/pipeline/RenderPipeline;Lnet/minecraft/resources/Identifier;IIFFIIII)V", ordinal = 1)})
/*    */   void renderBg(GuiGraphicsExtractor instance, RenderPipeline renderPipeline, Identifier resourceLocation, int i, int j, float f, float g, int k, int l, int m, int n, Operation<Void> original) {
/* 28 */     if (MinimegaClient.getController().isSmallInventory()) {
/* 29 */       original.call(new Object[] { instance, renderPipeline, resourceLocation, Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f), Float.valueOf(g), Integer.valueOf(k), Integer.valueOf(13), Integer.valueOf(m), Integer.valueOf(n) });
/* 30 */       original.call(new Object[] { instance, renderPipeline, resourceLocation, Integer.valueOf(i), Integer.valueOf(j + 13), Float.valueOf(f), Float.valueOf(g + 13.0F + 58.0F), Integer.valueOf(k), Integer.valueOf(l - 13 - 58), Integer.valueOf(m), Integer.valueOf(n) });
/*    */     } else {
/* 32 */       original.call(new Object[] { instance, renderPipeline, resourceLocation, Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f), Float.valueOf(g), Integer.valueOf(k), Integer.valueOf(l), Integer.valueOf(m), Integer.valueOf(n) });
/*    */     } 
/*    */   }
/*    */   
/*    */   @ModifyVariable(method = {"extractBackground"}, at = @At("STORE"), ordinal = 3)
/*    */   int i(int i) {
/* 38 */     if (MinimegaClient.getController().isSmallInventory()) return i + 29; 
/* 39 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\smallinv\ChestScreenMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */