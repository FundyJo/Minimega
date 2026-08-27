/*    */ package dev.jab125.minimega.mod.client.mixin.debug;
/*    */ import dev.jab125.minimega.mod.debug.MinimegaDebug;
/*    */ import java.util.Iterator;
/*    */ import java.util.Objects;
/*    */ import net.minecraft.client.DeltaTracker;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ 
/*    */ @Mixin({Gui.class})
/*    */ public abstract class GuiMixin {
/*    */   @Inject(method = {"extractRenderState"}, at = {@At("RETURN")})
/*    */   void rten(GuiGraphicsExtractor guiGraphics, DeltaTracker deltaTracker, CallbackInfo ci) {
/* 17 */     if (MinimegaDebug.render)
/* 18 */       MinimegaDebug.renderDebug(MinimegaDebug.CLIENT, text -> {
/*    */             guiGraphics.pose().pushMatrix(); if (MinimegaDebug.Anchor.LEFT == MinimegaDebug.Anchor.RIGHT)
/*    */               guiGraphics.pose().translate(guiGraphics.guiWidth(), 0.0F);  int y = 0;
/*    */             for (String i : ()) {
/*    */               guiGraphics.text((Minecraft.getInstance()).font, i, (MinimegaDebug.Anchor.LEFT == MinimegaDebug.Anchor.RIGHT) ? -(Minecraft.getInstance()).font.width(i) : 0, y, -1, false);
/*    */               Objects.requireNonNull((Minecraft.getInstance()).font);
/*    */               y += 9;
/*    */             } 
/*    */             guiGraphics.pose().popMatrix();
/*    */           }); 
/* 28 */     if (MinimegaDebug.render)
/* 29 */       MinimegaDebug.renderDebug(MinimegaDebug.SERVER, text -> {
/*    */             guiGraphics.pose().pushMatrix();
/*    */             if (MinimegaDebug.Anchor.RIGHT == MinimegaDebug.Anchor.RIGHT)
/*    */               guiGraphics.pose().translate(guiGraphics.guiWidth(), 0.0F); 
/*    */             int y = 0;
/*    */             for (String i : ()) {
/*    */               guiGraphics.text((Minecraft.getInstance()).font, i, (MinimegaDebug.Anchor.RIGHT == MinimegaDebug.Anchor.RIGHT) ? -(Minecraft.getInstance()).font.width(i) : 0, y, -1, false);
/*    */               Objects.requireNonNull((Minecraft.getInstance()).font);
/*    */               y += 9;
/*    */             } 
/*    */             guiGraphics.pose().popMatrix();
/*    */           }); 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\debug\GuiMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */