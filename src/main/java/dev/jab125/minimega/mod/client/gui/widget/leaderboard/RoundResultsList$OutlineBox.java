/*     */ package dev.jab125.minimega.mod.client.gui.widget.leaderboard;
/*     */ 
/*     */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class OutlineBox
/*     */   extends Record
/*     */ {
/*     */   private final int x;
/*     */   private final int y;
/*     */   private final int width;
/*     */   private final int height;
/*     */   private final int color;
/*     */   
/*     */   public final String toString() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/client/gui/widget/leaderboard/RoundResultsList$OutlineBox;)Ljava/lang/String;
/*     */     //   6: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #149	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	7	0	this	Ldev/jab125/minimega/mod/client/gui/widget/leaderboard/RoundResultsList$OutlineBox;
/*     */   }
/*     */   
/*     */   public final int hashCode() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/client/gui/widget/leaderboard/RoundResultsList$OutlineBox;)I
/*     */     //   6: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #149	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	7	0	this	Ldev/jab125/minimega/mod/client/gui/widget/leaderboard/RoundResultsList$OutlineBox;
/*     */   }
/*     */   
/*     */   public final boolean equals(Object o) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_1
/*     */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/client/gui/widget/leaderboard/RoundResultsList$OutlineBox;Ljava/lang/Object;)Z
/*     */     //   7: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #149	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	8	0	this	Ldev/jab125/minimega/mod/client/gui/widget/leaderboard/RoundResultsList$OutlineBox;
/*     */     //   0	8	1	o	Ljava/lang/Object;
/*     */   }
/*     */   
/*     */   OutlineBox(int x, int y, int width, int height, int color) {
/* 149 */     this.x = x; this.y = y; this.width = width; this.height = height; this.color = color; } public int x() { return this.x; } public int y() { return this.y; } public int width() { return this.width; } public int height() { return this.height; } public int color() { return this.color; }
/*     */    public void render(GuiGraphicsExtractor guiGraphics) {
/* 151 */     guiGraphics.fill(this.x, this.y, this.x + this.width, this.y + 1, this.color);
/* 152 */     guiGraphics.fill(this.x, this.y + this.height - 1, this.x + this.width, this.y + this.height, this.color);
/* 153 */     guiGraphics.fill(this.x, this.y + 1, this.x + 1, this.y + this.height - 1, this.color);
/* 154 */     guiGraphics.fill(this.x + this.width - 1, this.y + 1, this.x + this.width, this.y + this.height - 1, this.color);
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\widget\leaderboard\RoundResultsList$OutlineBox.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */