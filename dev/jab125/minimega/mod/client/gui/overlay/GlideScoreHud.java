/*    */ package dev.jab125.minimega.mod.client.gui.overlay;
/*    */ 
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import dev.jab125.minimega.mod.abstractions.modloader.ModLoader;
/*    */ import dev.jab125.minimega.mod.client.GlideHudHelpers;
/*    */ import net.minecraft.client.gui.Font;
/*    */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*    */ import net.minecraft.client.renderer.RenderPipelines;
/*    */ import net.minecraft.util.Util;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class GlideScoreHud
/*    */ {
/*    */   private static final int SIZE = 16;
/*    */   private static final int FRAMES = 21;
/*    */   private static int tier;
/*    */   private static int animationTier;
/*    */   private static long animationStarted;
/*    */   
/*    */   public static void update(int ringLevel) {
/* 22 */     switch (ringLevel) { case 0: 
/*    */       case 1:
/*    */       
/*    */       default:
/* 26 */         break; }  int nextTier = 1;
/* 27 */     if (nextTier == tier)
/* 28 */       return;  animationTier = tier;
/* 29 */     animationStarted = Util.getMillis();
/* 30 */     tier = nextTier;
/*    */   }
/*    */   
/*    */   public static void reset() {
/* 34 */     tier = 0;
/* 35 */     animationStarted = 0L;
/*    */   }
/*    */   
/*    */   public static void render(GuiGraphicsExtractor graphics, Font font, int score, int color, int index, int total) {
/* 39 */     String text = Integer.toString(score);
/* 40 */     int y = ModLoader.isLegacy4jInstalled() ? (graphics.guiHeight() / 4 + 40) : (graphics.guiHeight() / 2 - (total - 1) * 18 / 2 + index * 18 - 9);
/* 41 */     float scale = GlideHudHelpers.textScale(1.0F);
/* 42 */     int x = graphics.guiWidth() - GlideHudHelpers.getTextRightMargin() - Math.round(font.width(text) * scale);
/* 43 */     GlideHudHelpers.renderScaledText(graphics, font, text, color, x, y + 5, scale);
/*    */     
/* 45 */     int iconX = graphics.guiWidth() - GlideHudHelpers.getIconMargin();
/* 46 */     graphics.blitSprite(RenderPipelines.GUI_TEXTURED, Minimega.id("glide/score/" + tier + "/0"), iconX, y, 16, 16);
/* 47 */     long frame = (Util.getMillis() - animationStarted) * 60L / 1800L;
/* 48 */     if (frame < 21L)
/* 49 */       graphics.blitSprite(RenderPipelines.GUI_TEXTURED, Minimega.id("glide/score/" + animationTier + "/" + frame + 1L), iconX, y, 16, 16); 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\overlay\GlideScoreHud.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */