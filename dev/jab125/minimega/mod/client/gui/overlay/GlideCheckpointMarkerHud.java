/*    */ package dev.jab125.minimega.mod.client.gui.overlay;
/*    */ 
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*    */ import net.minecraft.client.renderer.RenderPipelines;
/*    */ 
/*    */ public final class GlideCheckpointMarkerHud
/*    */ {
/*    */   private static final long RISE_DURATION_MILLIS = 35L;
/*    */   private static final long SETTLE_DURATION_MILLIS = 560L;
/*    */   private static final float START_SCALE = 1.65F;
/*    */   private static final float PEAK_SCALE = 1.95F;
/* 15 */   private static final Map<Integer, Long> START_TIMES = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static synchronized void trigger(int checkpointId) {
/* 21 */     if (checkpointId <= 0)
/* 22 */       return;  START_TIMES.put(Integer.valueOf(checkpointId), Long.valueOf(monotonicMillis()));
/*    */   }
/*    */   
/*    */   public static synchronized void reset() {
/* 26 */     START_TIMES.clear();
/*    */   }
/*    */   
/*    */   public static void render(GuiGraphicsExtractor guiGraphics, int checkpointId, int x, int progressBarY, int progressBarHeight) {
/* 30 */     guiGraphics.pose().pushMatrix();
/* 31 */     guiGraphics.pose().translate(0.0F, progressBarY + progressBarHeight / 2.0F);
/* 32 */     guiGraphics.pose().scale(1.0F, scaleY(checkpointId));
/* 33 */     guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Minimega.id("glide/lap_marker"), x, -7, 2, 14);
/* 34 */     guiGraphics.pose().popMatrix();
/*    */   }
/*    */   
/*    */   private static synchronized float scaleY(int checkpointId) {
/* 38 */     Long startedAt = START_TIMES.get(Integer.valueOf(checkpointId));
/* 39 */     if (startedAt == null) return 1.0F;
/*    */     
/* 41 */     long elapsed = monotonicMillis() - startedAt.longValue();
/* 42 */     if (elapsed < 35L) {
/* 43 */       float progress = (float)elapsed / 35.0F;
/* 44 */       return 1.65F + 0.30000007F * progress;
/*    */     } 
/*    */     
/* 47 */     long settling = elapsed - 35L;
/* 48 */     if (settling < 560L) {
/* 49 */       float remaining = 1.0F - (float)settling / 560.0F;
/* 50 */       return 1.0F + 0.95000005F * remaining * remaining;
/*    */     } 
/*    */     
/* 53 */     START_TIMES.remove(Integer.valueOf(checkpointId));
/* 54 */     return 1.0F;
/*    */   }
/*    */   
/*    */   private static long monotonicMillis() {
/* 58 */     return System.nanoTime() / 1000000L;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\overlay\GlideCheckpointMarkerHud.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */