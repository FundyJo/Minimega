/*    */ package dev.jab125.minimega.mod;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ public class MinimegaAliveDeadGen {
/*    */   public static void main(String[] args) throws IOException {
/* 10 */     for (int i = 0; i < 17; i++) {
/* 11 */       BufferedImage image = ImageIO.read(Path.of("originalicons/Circle_AliveDead_" + String.valueOf((i < 10) ? ("0" + i) : Integer.valueOf(i)) + ".png", new String[0]).toFile());
/* 12 */       BufferedImage newImage = new BufferedImage(18, 30, 2);
/* 13 */       for (int x = 0; x < 5; x++) {
/* 14 */         for (int y = 0; y < 5; y++) {
/* 15 */           newImage.setRGB(x * 2 + 4, y * 2 + 10, image.getRGB(x, y));
/* 16 */           newImage.setRGB(x * 2 + 4, y * 2 + 11, image.getRGB(x, y));
/* 17 */           newImage.setRGB(x * 2 + 5, y * 2 + 10, image.getRGB(x, y));
/* 18 */           newImage.setRGB(x * 2 + 5, y * 2 + 11, image.getRGB(x, y));
/*    */         } 
/*    */       } 
/* 21 */       ImageIO.write(newImage, "png", Path.of("newicons/player" + i + ".png", new String[0]).toFile());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\MinimegaAliveDeadGen.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */