/*    */ package dev.jab125.minimega.mod.enforcer;
/*    */ 
/*    */ import dev.jab125.minimega.mod.abstractions.modloader.ModLoader;
/*    */ 
/*    */ public class Enforcer {
/*    */   public static void enforceLegacy4JVersion() {
/*  7 */     if (!ModLoader.isLegacy4jInstalled())
/*  8 */       return;  String legacy = ModLoader.getInstance().getModVersion("legacy");
/*  9 */     if (!"1.9".equals(legacy))
/* 10 */       throw new WrongLegacy4JVersionException("Wrong Legacy4J version! Required version: 1.9; You have " + legacy + "!"); 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\enforcer\Enforcer.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */