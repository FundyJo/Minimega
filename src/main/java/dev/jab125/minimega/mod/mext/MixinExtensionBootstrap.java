/*    */ package dev.jab125.minimega.mod.mext;
/*    */ 
/*    */ import org.spongepowered.asm.mixin.injection.selectors.TargetSelector;
/*    */ 
/*    */ public class MixinExtensionBootstrap {
/*    */   private static boolean inited;
/*    */   
/*    */   public static void init() {
/*  9 */     if (inited)
/* 10 */       return;  inited = true;
/* 11 */     TargetSelector.register(DynamicTargetSelector.class, "Minimega");
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mext\MixinExtensionBootstrap.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */