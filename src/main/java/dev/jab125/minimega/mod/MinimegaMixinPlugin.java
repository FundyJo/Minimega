/*    */ package dev.jab125.minimega.mod;
/*    */ 
/*    */ import dev.jab125.minimega.mod.abstractions.modloader.ModLoader;
/*    */ import dev.jab125.minimega.mod.enforcer.Enforcer;
/*    */ import dev.jab125.minimega.mod.enforcer.WrongLegacy4JVersionException;
/*    */ import dev.jab125.minimega.mod.mext.MixinExtensionBootstrap;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import org.objectweb.asm.tree.ClassNode;
/*    */ import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
/*    */ import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
/*    */ 
/*    */ public class MinimegaMixinPlugin
/*    */   implements IMixinConfigPlugin
/*    */ {
/*    */   private static boolean isLegacy4JLoaded = false;
/*    */   private static boolean isSodiumLoaded = false;
/*    */   private static boolean isWorldHostLoaded = false;
/*    */   private static boolean isModernerBeta2Loaded = false;
/*    */   private static boolean isBobbyLoaded = false;
/*    */   private static boolean isControlifyLoaded = false;
/*    */   private static boolean isE4mcLoaded = false;
/*    */   
/*    */   public void onLoad(String mixinPackage) {
/*    */     try {
/* 26 */       Enforcer.enforceLegacy4JVersion();
/* 27 */     } catch (WrongLegacy4JVersionException e) {
/* 28 */       throw0(new Throwable((Throwable)e));
/*    */     } 
/* 30 */     MixinExtensionBootstrap.init();
/* 31 */     if (ModLoader.isLegacy4jInstalled()) isLegacy4JLoaded = true; 
/* 32 */     if (ModLoader.getInstance().isModLoaded("sodium")) isSodiumLoaded = true; 
/* 33 */     if (ModLoader.getInstance().isModLoaded("world-host")) isWorldHostLoaded = true; 
/* 34 */     if (ModLoader.getInstance().isModLoaded("moderner_beta") && ModLoader.getInstance().getModVersion("moderner_beta").startsWith("2.")) isModernerBeta2Loaded = true; 
/* 35 */     if (ModLoader.getInstance().isModLoaded("bobby")) isBobbyLoaded = true; 
/* 36 */     if (ModLoader.getInstance().isModLoaded("controlify")) isControlifyLoaded = true; 
/* 37 */     if (ModLoader.getInstance().isModLoaded("e4mc") || ModLoader.getInstance().isModLoaded("e4mc_minecraft")) isE4mcLoaded = true; 
/*    */   }
/*    */   
/*    */   private static <T extends Throwable> void throw0(Throwable t) throws T {
/* 41 */     throw (T)t;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getRefMapperConfig() {
/* 46 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
/* 51 */     if (mixinClassName.contains("ChunkIOErrorReporter")) return false; 
/* 52 */     if (mixinClassName.contains("smallinv") && mixinClassName.contains("client") && isLegacy4JLoaded) return false; 
/* 53 */     if (mixinClassName.contains("NonLegacy4J") && isLegacy4JLoaded)
/* 54 */       return false; 
/* 55 */     if ((mixinClassName.contains("legacy4j") || (mixinClassName.contains("Legacy4J") && !mixinClassName.contains("NonLegacy4J"))) && !isLegacy4JLoaded) {
/* 56 */       return false;
/*    */     }
/* 58 */     if (mixinClassName.contains("sodium") && !isSodiumLoaded) {
/* 59 */       return false;
/*    */     }
/* 61 */     if (mixinClassName.contains("worldhost") && !isWorldHostLoaded) {
/* 62 */       return false;
/*    */     }
/* 64 */     if (mixinClassName.contains("modernerbeta") && !isModernerBeta2Loaded) {
/* 65 */       return false;
/*    */     }
/* 67 */     if (mixinClassName.contains("bobby") && !isBobbyLoaded) {
/* 68 */       return false;
/*    */     }
/* 70 */     if (mixinClassName.contains("controlify") && !isControlifyLoaded) {
/* 71 */       return false;
/*    */     }
/* 73 */     if (mixinClassName.contains("e4mc") && !isE4mcLoaded) {
/* 74 */       return false;
/*    */     }
/* 76 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public List<String> getMixins() {
/* 86 */     return null;
/*    */   }
/*    */   
/*    */   public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
/*    */   
/*    */   public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\MinimegaMixinPlugin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */