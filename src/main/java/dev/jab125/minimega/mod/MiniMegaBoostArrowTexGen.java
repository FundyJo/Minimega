/*    */ package dev.jab125.minimega.mod;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ public class MiniMegaBoostArrowTexGen {
/*    */   public static void main(String[] args) throws IOException {
/* 11 */     BufferedImage image = ImageIO.read(MiniMegaBoostArrowTexGen.class.getResourceAsStream("/assets/minimega/textures/block/thermal_2.png"));
/* 12 */     BufferedImage newImage = new BufferedImage(image.getWidth(), 16384, 2);
/* 13 */     int height = newImage.getHeight();
/* 14 */     int width = newImage.getWidth();
/* 15 */     int xO = 0;
/* 16 */     int y0 = 0;
/* 17 */     for (int y = 0; y < height; y++) {
/* 18 */       for (int x = 0; x < width; x++) {
/*    */ 
/*    */         
/* 21 */         int xP = x + xO;
/* 22 */         for (; xP >= width; xP -= width);
/* 23 */         int yP = y + y0;
/* 24 */         for (; yP >= image.getHeight(); yP -= image.getHeight());
/* 25 */         System.out.println("" + xP + ", " + xP);
/* 26 */         int rgb = image.getRGB(xP, yP);
/*    */         
/* 28 */         newImage.setRGB(x, y, rgb);
/*    */       } 
/* 30 */       if ((y - 31) % 32 == 0) {
/* 31 */         System.out.println("Y is " + y + ", resetting");
/* 32 */         xO++;
/* 33 */         y0 -= 31;
/*    */       } 
/*    */     } 
/* 36 */     File file = Path.of("output.png", new String[0]).toFile();
/* 37 */     System.out.println(file.toPath().toAbsolutePath());
/* 38 */     ImageIO.write(newImage, "png", file);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\MiniMegaBoostArrowTexGen.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */