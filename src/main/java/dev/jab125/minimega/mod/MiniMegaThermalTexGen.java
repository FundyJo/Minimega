/*    */ package dev.jab125.minimega.mod;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ public class MiniMegaThermalTexGen {
/*    */   public static void main(String[] args) throws IOException {
/* 11 */     BufferedImage image = ImageIO.read(MiniMegaThermalTexGen.class.getResourceAsStream("/assets/minimega/textures/block/thermal_2.png"));
/* 12 */     BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight() * image.getHeight(), 2);
/* 13 */     int height = newImage.getHeight();
/* 14 */     int width = newImage.getWidth();
/* 15 */     for (int y = 0; y < height; y++) {
/* 16 */       for (int x = 0; x < width; x++) {
/* 17 */         int rgb, xP = x - 31;
/* 18 */         int yP = y - 31;
/*    */         
/* 20 */         if (yP < 0) {
/* 21 */           if (xP < 0) {
/* 22 */             rgb = image.getRGB(xP + 32, yP + 32);
/*    */           } else {
/* 24 */             rgb = image.getRGB(x, yP + 32);
/*    */           } 
/* 26 */         } else if (xP < 0) {
/* 27 */           System.out.println("" + xP + 32 + ", " + xP + 32);
/* 28 */           rgb = image.getRGB(xP + 32, y);
/*    */         } else {
/* 30 */           rgb = newImage.getRGB(xP, yP);
/*    */         } 
/*    */ 
/*    */         
/* 34 */         newImage.setRGB(x, y, rgb);
/*    */       } 
/*    */     } 
/* 37 */     File file = Path.of("output.png", new String[0]).toFile();
/* 38 */     System.out.println(file.toPath().toAbsolutePath());
/* 39 */     ImageIO.write(newImage, "png", file);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\MiniMegaThermalTexGen.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */