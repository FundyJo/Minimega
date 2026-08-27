/*    */ package dev.jab125.minimega.mod.client.gui.overlay;
/*    */ 
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import dev.jab125.minimega.mod.abstractions.modloader.ModLoader;
/*    */ import dev.jab125.minimega.mod.client.GlideHudHelpers;
/*    */ import dev.jab125.minimega.mod.client.gui.widget.leaderboard.RoundResultsList;
/*    */ import dev.jab125.minimega.mod.util.controller.glide.GlideMinigameController;
/*    */ import java.time.Duration;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.gui.Font;
/*    */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*    */ import net.minecraft.client.renderer.RenderPipelines;
/*    */ 
/*    */ public final class GlideMedalHud
/*    */ {
/*    */   private static final int MAX_ROWS = 3;
/*    */   private static final int MEDAL_SIZE = 18;
/*    */   private static final int ROW_HEIGHT = 23;
/* 19 */   private static volatile Row[] rows = new Row[0]; private static final class Row extends Record { private final String label; private final int ordinal;
/* 20 */     private Row(String label, int ordinal) { this.label = label; this.ordinal = ordinal; } public final String toString() { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/client/gui/overlay/GlideMedalHud$Row;)Ljava/lang/String;
/*    */       //   6: areturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #20	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/* 20 */       //   0	7	0	this	Ldev/jab125/minimega/mod/client/gui/overlay/GlideMedalHud$Row; } public String label() { return this.label; } public final int hashCode() { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/client/gui/overlay/GlideMedalHud$Row;)I
/*    */       //   6: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #20	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Ldev/jab125/minimega/mod/client/gui/overlay/GlideMedalHud$Row; } public final boolean equals(Object o) { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: aload_1
/*    */       //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/client/gui/overlay/GlideMedalHud$Row;Ljava/lang/Object;)Z
/*    */       //   7: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #20	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	8	0	this	Ldev/jab125/minimega/mod/client/gui/overlay/GlideMedalHud$Row;
/* 20 */       //   0	8	1	o	Ljava/lang/Object; } public int ordinal() { return this.ordinal; }
/*    */      }
/*    */ 
/*    */   
/*    */   public static void update(List<GlideMinigameController.PlayerInformation> players) {
/* 25 */     Row[] next = new Row[Math.min(players.size(), 3)];
/* 26 */     Duration leaderTime = (next.length == 0) ? null : ((GlideMinigameController.PlayerInformation)players.getFirst()).finishTime().orElse(null);
/* 27 */     for (int i = 0; i < next.length; ) { next[i] = new Row(label(players.get(i), i, leaderTime), ((GlideMinigameController.PlayerInformation)players.get(i)).ordinal()); i++; }
/* 28 */      rows = next;
/*    */   }
/*    */   
/*    */   public static void render(GuiGraphicsExtractor graphics, Font font) {
/* 32 */     Row[] current = rows;
/* 33 */     if (current.length > 1) render(graphics, font, current); 
/*    */   }
/*    */   
/*    */   private static void render(GuiGraphicsExtractor graphics, Font font, Row... rows) {
/* 37 */     float scale = GlideHudHelpers.textScale(1.0F);
/* 38 */     for (int i = 0; i < Math.min(rows.length, 3); i++) {
/* 39 */       int y = graphics.guiHeight() / 4 + i * 23;
/* 40 */       graphics.blitSprite(RenderPipelines.GUI_TEXTURED, Minimega.id("glide/position/" + rows[i].ordinal() + 1), 
/* 41 */           ModLoader.isLegacy4jInstalled() ? 32 : 10, y, 18, 18);
/* 42 */       GlideHudHelpers.renderScaledText(graphics, font, rows[i].label(), -1, ModLoader.isLegacy4jInstalled() ? 50 : 34, y + 6, scale);
/*    */     } 
/*    */   }
/*    */   
/*    */   private static String label(GlideMinigameController.PlayerInformation player, int position, Duration leaderTime) {
/* 47 */     Integer score = player.score().orElse(null);
/* 48 */     Duration time = player.finishTime().orElse(null);
/*    */ 
/*    */     
/* 51 */     String result = (score != null) ? score.toString() : ((time == null) ? null : ((position == 0 || leaderTime == null) ? RoundResultsList.format2(time) : ("+" + RoundResultsList.format2(Duration.ofMillis(Math.max(0L, time.toMillis() - leaderTime.toMillis()))))));
/* 52 */     return (result == null) ? player.playerName() : (result + " : " + result);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\overlay\GlideMedalHud.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */