/*    */ package dev.jab125.minimega.mod.util;
/*    */ 
/*    */ import java.awt.Color;
/*    */ 
/*    */ 
/*    */ public class ColorUtil
/*    */ {
/*    */   private static float toLinear(float c) {
/*  9 */     if (c <= 0.04045F) {
/* 10 */       return c / 12.92F;
/*    */     }
/* 12 */     return (float)Math.pow(((c + 0.055F) / 1.055F), 2.4D);
/*    */   }
/*    */ 
/*    */   
/*    */   private static float toSRGB(float c) {
/* 17 */     if (c <= 0.0031308F) {
/* 18 */       return c * 12.92F;
/*    */     }
/* 20 */     return 1.055F * (float)Math.pow(c, 0.4166666666666667D) - 0.055F;
/*    */   }
/*    */   
/*    */   public static Color lerpGamma(Color a, Color b, float t) {
/* 24 */     t = Math.max(0.0F, Math.min(1.0F, t));
/*    */ 
/*    */     
/* 27 */     float ar = a.getRed() / 255.0F;
/* 28 */     float ag = a.getGreen() / 255.0F;
/* 29 */     float ab = a.getBlue() / 255.0F;
/*    */     
/* 31 */     float br = b.getRed() / 255.0F;
/* 32 */     float bg = b.getGreen() / 255.0F;
/* 33 */     float bb = b.getBlue() / 255.0F;
/*    */ 
/*    */     
/* 36 */     ar = toLinear(ar);
/* 37 */     ag = toLinear(ag);
/* 38 */     ab = toLinear(ab);
/*    */     
/* 40 */     br = toLinear(br);
/* 41 */     bg = toLinear(bg);
/* 42 */     bb = toLinear(bb);
/*    */ 
/*    */     
/* 45 */     float r = ar + t * (br - ar);
/* 46 */     float g = ag + t * (bg - ag);
/* 47 */     float bl = ab + t * (bb - ab);
/*    */ 
/*    */     
/* 50 */     r = toSRGB(r);
/* 51 */     g = toSRGB(g);
/* 52 */     bl = toSRGB(bl);
/*    */ 
/*    */     
/* 55 */     float aOut = a.getAlpha() / 255.0F + t * (b.getAlpha() / 255.0F - a.getAlpha() / 255.0F);
/*    */     
/* 57 */     return new Color(
/* 58 */         clamp(r), clamp(g), clamp(bl), clamp(aOut));
/*    */   }
/*    */ 
/*    */   
/*    */   private static float clamp(float v) {
/* 63 */     return Math.max(0.0F, Math.min(1.0F, v));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\ColorUtil.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */