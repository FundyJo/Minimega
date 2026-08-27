/*    */ package dev.jab125.minimega.mod.abstractions.modloader;
/*    */ 
/*    */ import dev.jab125.minimega.mod.abstractions.modloader.impl.FabricModLoader;
/*    */ import java.nio.file.Path;
/*    */ 
/*    */ public interface ModLoader
/*    */ {
/*    */   boolean isModLoaded(String paramString);
/*    */   
/*    */   String getModVersion(String paramString);
/*    */   
/*    */   Environment getEnvironment();
/*    */   
/*    */   ModUniverse getUniverse();
/*    */   
/*    */   Path getConfigDir();
/*    */   
/*    */   boolean isDevelopmentEnvironment();
/*    */   
/*    */   static ModLoader getInstance() {
/* 21 */     return (ModLoader)FabricModLoader.FABRIC_MOD_LOADER;
/*    */   }
/*    */   
/*    */   static boolean isLegacy4jInstalled() {
/* 25 */     return getInstance().isModLoaded("legacy");
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\abstractions\modloader\ModLoader.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */