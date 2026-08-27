/*    */ package dev.jab125.minimega.mod.client.gui.overlay;
/*    */ 
/*    */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*    */ import net.minecraft.client.renderer.RenderPipelines;
/*    */ import net.minecraft.resources.Identifier;
/*    */ 
/*    */ public class MinigameChest {
/*    */   private final int x;
/*    */   private final int y;
/*    */   private final int priority;
/* 11 */   private int tick = 0;
/*    */   public MinigameChest(int x, int y, int priority) {
/* 13 */     this.x = x;
/* 14 */     this.y = y;
/* 15 */     this.priority = priority;
/*    */   }
/*    */   
/*    */   public int getPriority() {
/* 19 */     if (this.tick >= 60) return Integer.MIN_VALUE; 
/* 20 */     return this.priority;
/*    */   }
/*    */   
/*    */   public void render(GuiGraphicsExtractor guiGraphics, float delta) {
/* 24 */     float intrinsicScale = 1.0F;
/* 25 */     if (this.tick >= 60)
/* 26 */       return;  float chestCenterX = this.x / intrinsicScale;
/* 27 */     float chestCenterY = this.y / intrinsicScale;
/*    */ 
/*    */ 
/*    */     
/* 31 */     guiGraphics.pose().pushMatrix();
/* 32 */     guiGraphics.pose().scale(intrinsicScale);
/* 33 */     if (this.tick <= 2 || this.tick >= 24) {
/* 34 */       guiGraphics.pose().pushMatrix();
/* 35 */       guiGraphics.pose().translate(chestCenterX - 8.0F, chestCenterY - 8.0F);
/*    */       
/* 37 */       guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Identifier.parse("minimega:battle/bottom"), 0, 0, 16, 11, -1);
/* 38 */       guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Identifier.parse("minimega:battle/top1"), 0, -5, 16, 8, -1);
/* 39 */       guiGraphics.pose().popMatrix();
/* 40 */     } else if (this.tick <= 3 || this.tick >= 23) {
/* 41 */       guiGraphics.pose().pushMatrix();
/* 42 */       guiGraphics.pose().translate(chestCenterX - 8.0F, chestCenterY - 8.0F);
/*    */       
/* 44 */       guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Identifier.parse("minimega:battle/bottom"), 0, 0, 16, 11, -1);
/* 45 */       guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Identifier.parse("minimega:battle/top2"), 0, -8, 16, 8, -1);
/* 46 */       guiGraphics.pose().popMatrix();
/*    */     } else {
/* 48 */       guiGraphics.pose().pushMatrix();
/* 49 */       guiGraphics.pose().translate(chestCenterX - 8.0F, chestCenterY - 8.0F);
/*    */       
/* 51 */       guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Identifier.parse("minimega:battle/top3"), 0, -14, 16, 14, -1);
/* 52 */       guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Identifier.parse("minimega:battle/sword"), 0, -12, 16, 16, -1);
/* 53 */       guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Identifier.parse("minimega:battle/bottom"), 0, 0, 16, 11, -1);
/* 54 */       guiGraphics.pose().popMatrix();
/*    */     } 
/* 56 */     guiGraphics.pose().popMatrix();
/*    */   }
/*    */   
/*    */   public void tick() {
/* 60 */     if (this.tick >= 80)
/* 61 */       return;  this.tick++;
/*    */   }
/*    */   
/*    */   boolean nothing() {
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public static MinigameChest ofNothing() {
/* 69 */     return new MinigameChest(0, 0, -2147483648)
/*    */       {
/*    */         boolean nothing() {
/* 72 */           return true;
/*    */         }
/*    */ 
/*    */         
/*    */         public void render(GuiGraphicsExtractor guiGraphics, float delta) {}
/*    */ 
/*    */         
/*    */         public void tick() {}
/*    */       };
/*    */   }
/*    */   
/*    */   public boolean fake() {
/* 84 */     return nothing();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\overlay\MinigameChest.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */