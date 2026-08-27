/*    */ package dev.jab125.minimega.mod.client.mixin.smallinv.controlify;
/*    */ import dev.isxander.controlify.api.buttonguide.ButtonGuideApi;
/*    */ import dev.isxander.controlify.api.buttonguide.ButtonGuidePredicate;
/*    */ import dev.isxander.controlify.bindings.ControlifyBindings;
/*    */ import dev.isxander.controlify.controller.ControllerEntity;
/*    */ import dev.isxander.controlify.screenop.ScreenProcessor;
/*    */ import dev.isxander.controlify.screenop.compat.vanilla.AbstractContainerScreenProcessor;
/*    */ import dev.isxander.controlify.virtualmouse.VirtualMouseHandler;
/*    */ import java.util.Optional;
/*    */ import net.minecraft.client.gui.components.Button;
/*    */ import net.minecraft.client.gui.components.events.GuiEventListener;
/*    */ import net.minecraft.client.gui.screens.Screen;
/*    */ import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
/*    */ import net.minecraft.network.chat.ComponentContents;
/*    */ import net.minecraft.network.chat.contents.TranslatableContents;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({AbstractContainerScreenProcessor.class})
/*    */ public class AbstractContainerScreenProcessorMixin<T extends AbstractContainerScreen<?>> extends ScreenProcessor<T> {
/*    */   public AbstractContainerScreenProcessorMixin(T t) {
/* 24 */     super((Screen)t);
/*    */   }
/*    */   
/*    */   @Inject(method = {"onWidgetRebuild"}, at = {@At("RETURN")}, remap = false)
/*    */   void mi(CallbackInfo ci) {
/* 29 */     Optional<? extends GuiEventListener> takeAll = ((AbstractContainerScreen)this.screen).children().stream().filter(a -> { if (a instanceof Button) { Button button = (Button)a; ComponentContents patt0$temp = button.getMessage().getContents(); if (patt0$temp instanceof TranslatableContents) { TranslatableContents contents = (TranslatableContents)patt0$temp; if (contents.getKey().equals("minimega.takeAll")); }  }  return false; }).findFirst();
/* 30 */     if (takeAll.isPresent()) {
/* 31 */       ButtonGuideApi.addGuideToButton(takeAll.get(), ControlifyBindings.GUI_PREV_TAB, ButtonGuidePredicate.always());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @Inject(method = {"handleScreenVMouse"}, at = {@At("RETURN")}, remap = false)
/*    */   private void hanfdleButtons(ControllerEntity par1, VirtualMouseHandler par2, CallbackInfo ci) {
/* 38 */     if (this instanceof AbstractContainerScreenProcessor) {
/* 39 */       Optional<? extends GuiEventListener> takeAll = ((AbstractContainerScreen)this.screen).children().stream().filter(a -> { if (a instanceof Button) { Button button = (Button)a; ComponentContents patt0$temp = button.getMessage().getContents(); if (patt0$temp instanceof TranslatableContents) { TranslatableContents contents = (TranslatableContents)patt0$temp; if (contents.getKey().equals("minimega.takeAll")); }  }  return false; }).findFirst();
/* 40 */       if (takeAll.isPresent() && 
/* 41 */         ControlifyBindings.GUI_PREV_TAB.on(par1).justPressed() && 
/* 42 */         ((Button)takeAll.get()).active) {
/* 43 */         playClackSound();
/* 44 */         ((Button)takeAll.get()).onPress(null);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\smallinv\controlify\AbstractContainerScreenProcessorMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */