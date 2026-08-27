/*    */ package dev.jab125.minimega.mod.client.gui.overlay;
/*    */ 
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import dev.jab125.minimega.mod.abstractions.modloader.ModLoader;
/*    */ import dev.jab125.minimega.mod.client.GlideHudHelpers;
/*    */ import dev.jab125.minimega.mod.client.gui.widget.leaderboard.RoundResultsList;
/*    */ import java.time.Duration;
/*    */ import net.minecraft.client.gui.Font;
/*    */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*    */ import net.minecraft.client.renderer.RenderPipelines;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class GlideTimerHud
/*    */ {
/*    */   private static final int SIZE = 16;
/*    */   private static final float TEXT_SCALE = 1.5F;
/*    */   private static final int FRAME_STEP = 5;
/*    */   
/*    */   public static void render(GuiGraphicsExtractor guiGraphics, Font font, Duration elapsed, boolean validForLeaderboards, int index, int total) {
/* 22 */     long totalMillis = Math.max(0L, elapsed.toMillis());
/* 23 */     int secondsFrame = (int)(totalMillis / 1000L % 60L) / 5;
/* 24 */     int minutesFrame = (int)(totalMillis / 60000L % 60L) / 5;
/* 25 */     String label = RoundResultsList.format2(elapsed);
/*    */     
/* 27 */     int y = ModLoader.isLegacy4jInstalled() ? (guiGraphics.guiHeight() / 4) : (guiGraphics.guiHeight() / 2 - (total - 1) * 18 / 2 + index * 18 - 9);
/* 28 */     int iconX = guiGraphics.guiWidth() - GlideHudHelpers.getIconMargin();
/* 29 */     float scale = GlideHudHelpers.textScale(1.5F);
/* 30 */     int labelX = guiGraphics.guiWidth() - GlideHudHelpers.getTextRightMargin() - Math.round(font.width(label) * scale);
/* 31 */     int color = validForLeaderboards ? -1 : -43691;
/*    */     
/* 33 */     GlideHudHelpers.renderScaledText(guiGraphics, font, label, color, labelX, y + 3, scale);
/* 34 */     guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Minimega.id("glide/timer/background"), iconX, y, 16, 16);
/* 35 */     guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Minimega.id("glide/timer/seconds_" + secondsFrame), iconX, y, 16, 16);
/* 36 */     guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Minimega.id("glide/timer/minutes_" + minutesFrame), iconX, y, 16, 16);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\overlay\GlideTimerHud.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */