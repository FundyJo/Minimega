/*     */ package dev.jab125.minimega.mod.client.gui.overlay;
/*     */ import dev.jab125.minimega.mod.abstractions.modloader.ModLoader;
/*     */ import net.minecraft.ChatFormatting;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Font;
/*     */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*     */ import net.minecraft.client.renderer.RenderPipelines;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.network.chat.FormattedText;
/*     */ import net.minecraft.resources.Identifier;
/*     */ import net.minecraft.util.ARGB;
/*     */ 
/*     */ public class MinigameShield {
/*     */   private final int x;
/*     */   private final int y;
/*     */   private final Component component;
/*     */   private final Identifier sprite;
/*     */   private final int priority;
/*  19 */   private int tick = 0;
/*     */   private final Font font;
/*  21 */   private final boolean legacy4j = ModLoader.isLegacy4jInstalled();
/*     */   public MinigameShield(int x, int y, Component component, Identifier sprite, int priority) {
/*  23 */     this.x = x;
/*  24 */     this.y = y;
/*  25 */     this.font = (Minecraft.getInstance()).font;
/*  26 */     this.component = nothing() ? null : (Component)component.copy().withStyle(ChatFormatting.DARK_GRAY);
/*  27 */     this.sprite = sprite;
/*  28 */     this.priority = priority;
/*     */   }
/*     */   
/*     */   public int getPriority() {
/*  32 */     if (this.tick >= 160) return Integer.MIN_VALUE; 
/*  33 */     return this.priority;
/*     */   }
/*     */   
/*     */   public void render(GuiGraphicsExtractor guiGraphics, float delta) {
/*  37 */     float intrinsicScale = 1.0F;
/*  38 */     if (this.tick >= 160)
/*  39 */       return;  float shieldCenterX = this.x / intrinsicScale;
/*  40 */     float shieldCenterY = this.y / intrinsicScale;
/*     */ 
/*     */ 
/*     */     
/*  44 */     guiGraphics.pose().pushMatrix();
/*  45 */     guiGraphics.pose().scale(intrinsicScale);
/*  46 */     if (this.tick > 4 && this.tick < 10) {
/*     */       
/*  48 */       float tickoff = ((this.tick - 5) + delta) * 4.0F;
/*     */       
/*  50 */       switch (this.tick - 5) { case 0: 
/*     */         case 1: 
/*     */         case 2: 
/*     */         case 3:
/*     */         
/*     */         default:
/*  56 */           break; }  float opacity = 0.0F;
/*     */       
/*  58 */       float f1 = shieldCenterY - 36.0F;
/*  59 */       float f2 = shieldCenterX - 36.0F;
/*  60 */       guiGraphics.pose().pushMatrix();
/*  61 */       guiGraphics.pose().translate(f2 - tickoff, f1 - tickoff);
/*  62 */       guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Identifier.parse("minimega:lsd"), 17, 52, 8, 7, opacity);
/*  63 */       guiGraphics.pose().popMatrix();
/*     */       
/*  65 */       guiGraphics.pose().pushMatrix();
/*  66 */       guiGraphics.pose().translate(f2 + tickoff, f1 - tickoff);
/*  67 */       guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Identifier.parse("minimega:lsd"), 47, 52, 8, 7, opacity);
/*  68 */       guiGraphics.pose().popMatrix();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  73 */     switch (this.tick) { case 0: 
/*     */       case 1: 
/*     */       case 2: 
/*     */       case 3: 
/*     */       case 4: 
/*     */       case 5: 
/*     */       case 6:
/*     */       
/*     */       default:
/*  82 */         break; }  float scale = 1.0F;
/*     */     
/*  84 */     float shieldY = shieldCenterY - 36.0F * scale;
/*  85 */     float shieldX = shieldCenterX - 36.0F * scale;
/*  86 */     guiGraphics.pose().pushMatrix();
/*  87 */     guiGraphics.pose().translate(shieldX, shieldY);
/*  88 */     guiGraphics.pose().scale(scale, scale);
/*  89 */     renderTheShield(guiGraphics, Math.min(1.0F, scale));
/*  90 */     guiGraphics.pose().popMatrix();
/*     */ 
/*     */     
/*  93 */     if (this.tick > 10) {
/*     */       
/*  95 */       switch (this.tick - 11) { case 0: 
/*     */         case 1: 
/*     */         case 2: 
/*     */         case 3: 
/*     */         case 4:
/*     */         
/*     */         default:
/* 102 */           break; }  scale = 1.0F;
/*     */       
/* 104 */       shieldY = shieldCenterY - 36.0F * scale;
/* 105 */       shieldX = shieldCenterX - 36.0F * scale;
/* 106 */       guiGraphics.pose().pushMatrix();
/* 107 */       guiGraphics.pose().translate(shieldX, shieldY);
/* 108 */       guiGraphics.pose().scale(scale, scale);
/* 109 */       renderRibbon(guiGraphics, this.component);
/* 110 */       guiGraphics.pose().popMatrix();
/*     */     } 
/*     */ 
/*     */     
/* 114 */     if (this.tick > 15) {
/*     */       
/* 116 */       switch (this.tick - 16) { case 0: 
/*     */         case 1: 
/*     */         case 2: 
/*     */         case 3: 
/*     */         case 4:
/*     */         
/*     */         default:
/* 123 */           break; }  float opacity = 1.0F;
/*     */       
/* 125 */       shieldY = shieldCenterY - 36.0F;
/* 126 */       shieldX = shieldCenterX - 36.0F;
/* 127 */       guiGraphics.pose().pushMatrix();
/* 128 */       guiGraphics.pose().translate(shieldX, shieldY);
/* 129 */       renderRibbonText(guiGraphics, this.component, opacity);
/* 130 */       guiGraphics.pose().popMatrix();
/*     */     } 
/*     */     
/* 133 */     guiGraphics.pose().popMatrix();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 137 */     if (this.tick >= 165)
/* 138 */       return;  this.tick++;
/*     */   }
/*     */   
/*     */   private void renderTheShield(GuiGraphicsExtractor guiGraphics, float alpha) {
/* 142 */     guiGraphics.pose().pushMatrix();
/* 143 */     guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Identifier.parse("minimega:shieldwhite"), 0, 0, 72, 72);
/* 144 */     guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Identifier.parse("minimega:shield"), 0, 0, 72, 72, alpha);
/* 145 */     guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, this.sprite, 21, 16, 30, 30, alpha);
/*     */     
/* 147 */     guiGraphics.pose().popMatrix();
/*     */   }
/*     */   
/*     */   private void renderRibbon(GuiGraphicsExtractor guiGraphics, Component component) {
/* 151 */     int ribbonWidth = (int)(this.font.width((FormattedText)component) * 0.8F) + 20;
/* 152 */     int ribbonHeight = 16;
/* 153 */     guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Identifier.parse("minimega:ribbon"), 36 - ribbonWidth / 2, 36 - ribbonHeight / 2 + 19, ribbonWidth, ribbonHeight);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void renderRibbonText(GuiGraphicsExtractor guiGraphics, Component component, float opacity) {
/* 160 */     int ribbonHeight = 16;
/* 161 */     guiGraphics.pose().pushMatrix();
/* 162 */     guiGraphics.pose().translate(36.0F - this.font.width((FormattedText)component) * 0.8F / 2.0F, 36.0F - ribbonHeight / 2.0F + 19.0F + 3.0F);
/* 163 */     guiGraphics.pose().scale(0.8F, 0.8F);
/* 164 */     guiGraphics.text(this.font, component, 0, 0, ARGB.color(opacity, -1), false);
/* 165 */     guiGraphics.pose().popMatrix();
/*     */   }
/*     */   
/*     */   boolean nothing() {
/* 169 */     return false;
/*     */   }
/*     */   
/*     */   public static MinigameShield ofNothing() {
/* 173 */     return new MinigameShield(0, 0, null, null, -2147483648)
/*     */       {
/*     */         boolean nothing() {
/* 176 */           return true;
/*     */         }
/*     */         
/*     */         public void render(GuiGraphicsExtractor guiGraphics, float delta) {}
/*     */         
/*     */         public void tick() {}
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\overlay\MinigameShield.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */