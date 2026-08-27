/*    */ package dev.jab125.minimega.mod.client.mixin;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.client.extension.SafetyScreenExtension;
/*    */ import java.util.function.Consumer;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.screens.Screen;
/*    */ import net.minecraft.client.gui.screens.multiplayer.SafetyScreen;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({SafetyScreen.class})
/*    */ public class SafetyScreenMixin
/*    */   implements SafetyScreenExtension
/*    */ {
/*    */   @Shadow
/*    */   @Final
/*    */   private Screen previous;
/*    */   @Unique
/*    */   private Consumer<Screen> customAction;
/*    */   
/*    */   @WrapOperation(method = {"lambda$addFooterButtons$0"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;setScreen(Lnet/minecraft/client/gui/screens/Screen;)V")})
/*    */   void kaka(Minecraft instance, Screen screen, Operation<Void> original) {
/* 28 */     if (this.customAction == null) {
/* 29 */       original.call(new Object[] { instance, screen });
/*    */       return;
/*    */     } 
/* 32 */     this.customAction.accept(this.previous);
/*    */   }
/*    */ 
/*    */   
/*    */   public void mm$setCustomAction(Consumer<Screen> action) {
/* 37 */     this.customAction = action;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\SafetyScreenMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */