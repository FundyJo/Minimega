/*    */ package dev.jab125.minimega.mod.client.mixin;
/*    */ 
/*    */ import dev.jab125.minimega.mod.client.extension.ScreenExtension;
/*    */ import net.minecraft.client.gui.screens.Screen;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ 
/*    */ @Mixin({Screen.class})
/*    */ public class ScreenMixin
/*    */   implements ScreenExtension {
/*    */   @Unique
/*    */   private boolean stopTrying;
/*    */   
/*    */   public boolean mm$stopTrying() {
/* 15 */     return this.stopTrying;
/*    */   }
/*    */ 
/*    */   
/*    */   public void mm$stopTrying2() {
/* 20 */     this.stopTrying = true;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\ScreenMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */