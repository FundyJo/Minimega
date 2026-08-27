/*    */ package dev.jab125.minimega.mod.client;
/*    */ 
/*    */ import java.util.Locale;
/*    */ import java.util.function.BooleanSupplier;
/*    */ import java.util.function.Supplier;
/*    */ 
/*    */ public class IrisMethods {
/*    */   public static BooleanSupplier areShadersOn = () -> false;
/*    */   public static Supplier<String> getShaderName = () -> "";
/*    */   
/*    */   public static boolean nameContainsnC(String text) {
/* 12 */     String s = getShaderName.get();
/* 13 */     if (s == null) return false; 
/* 14 */     return s.toLowerCase(Locale.ROOT).contains(text.toLowerCase(Locale.ROOT));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\IrisMethods.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */