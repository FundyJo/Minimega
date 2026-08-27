/*    */ package dev.jab125.minimega.mod.client.gui.overlay;
/*    */ 
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import dev.jab125.minimega.mod.abstractions.modloader.ModLoader;
/*    */ import dev.jab125.minimega.mod.client.GlideHudHelpers;
/*    */ import net.minecraft.client.gui.Font;
/*    */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*    */ import net.minecraft.client.renderer.RenderPipelines;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class GlideSpeedometerHud
/*    */ {
/*    */   private static final int SIZE = 16;
/*    */   private static final int FRAME_COUNT = 12;
/*    */   private static final double TICKS_PER_SECOND = 20.0D;
/*    */   private static final double GAUGE_MAX_SPEED = 50.0D;
/*    */   
/*    */   public static void render(GuiGraphicsExtractor guiGraphics, Font font, Player player, int index, int total) {
/* 22 */     double speed = player.getDeltaMovement().length() * 20.0D;
/* 23 */     int frame = Mth.clamp((int)(speed / 50.0D * 12.0D + 0.5D), 1, 12);
/* 24 */     String label = "%.2f m/s".formatted(new Object[] { Double.valueOf(speed) });
/*    */     
/* 26 */     int y = ModLoader.isLegacy4jInstalled() ? (guiGraphics.guiHeight() / 4 + 20) : (guiGraphics.guiHeight() / 2 - (total - 1) * 18 / 2 + index * 18 - 9);
/* 27 */     int iconX = guiGraphics.guiWidth() - GlideHudHelpers.getIconMargin();
/* 28 */     float scale = GlideHudHelpers.textScale(1.0F);
/* 29 */     int labelX = guiGraphics.guiWidth() - GlideHudHelpers.getTextRightMargin() - Math.round(font.width(label) * scale);
/*    */     
/* 31 */     GlideHudHelpers.renderScaledText(guiGraphics, font, label, -1, labelX, y + 5, scale);
/* 32 */     guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Minimega.id("glide/speedometer/background"), iconX, y, 16, 16);
/* 33 */     guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Minimega.id("glide/speedometer/needle_" + frame), iconX, y, 16, 16);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\overlay\GlideSpeedometerHud.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */