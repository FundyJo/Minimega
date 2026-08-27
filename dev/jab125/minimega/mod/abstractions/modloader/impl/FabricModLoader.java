/*    */ package dev.jab125.minimega.mod.abstractions.modloader.impl;
/*    */ import dev.jab125.minimega.mod.abstractions.modloader.Environment;
/*    */ import dev.jab125.minimega.mod.abstractions.modloader.ModLoader;
/*    */ import dev.jab125.minimega.mod.abstractions.modloader.ModUniverse;
/*    */ import java.nio.file.Path;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.loader.api.FabricLoader;
/*    */ import net.fabricmc.loader.api.ModContainer;
/*    */ 
/*    */ public final class FabricModLoader implements ModLoader {
/* 11 */   public static final FabricModLoader FABRIC_MOD_LOADER = new FabricModLoader();
/*    */ 
/*    */   
/*    */   public boolean isModLoaded(String id) {
/* 15 */     return FabricLoader.getInstance().isModLoaded(id);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getModVersion(String id) {
/* 20 */     return isModLoaded(id) ? ((ModContainer)FabricLoader.getInstance().getModContainer(id).get()).getMetadata().getVersion().getFriendlyString() : null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Environment getEnvironment() {
/* 25 */     switch (FabricLoader.getInstance().getEnvironmentType()) { default: throw new MatchException(null, null);case CLIENT: case SERVER: break; }  return 
/*    */       
/* 27 */       Environment.DEDICATED_SERVER;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ModUniverse getUniverse() {
/* 33 */     return ModUniverse.FABRIC;
/*    */   }
/*    */ 
/*    */   
/*    */   public Path getConfigDir() {
/* 38 */     return FabricLoader.getInstance().getConfigDir();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isDevelopmentEnvironment() {
/* 43 */     return FabricLoader.getInstance().isDevelopmentEnvironment();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\abstractions\modloader\impl\FabricModLoader.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */