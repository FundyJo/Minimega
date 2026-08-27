/*    */ package dev.jab125.minimega.mod.client.compat.controlify.screen;
/*    */ import dev.isxander.controlify.api.buttonguide.ButtonGuideApi;
/*    */ import dev.isxander.controlify.bindings.ControlifyBindings;
/*    */ import dev.isxander.controlify.screenop.ScreenProcessor;
/*    */ import net.minecraft.client.gui.components.Button;
/*    */ import net.minecraft.client.gui.components.events.GuiEventListener;
/*    */ import net.minecraft.client.gui.screens.Screen;
/*    */ import net.minecraft.network.chat.ComponentContents;
/*    */ import net.minecraft.network.chat.contents.TranslatableContents;
/*    */ 
/*    */ public class CancelButtonScreenProcessor<T extends Screen> extends ScreenProcessor<T> {
/*    */   public CancelButtonScreenProcessor(T screen) {
/* 13 */     super((Screen)screen);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onWidgetRebuild() {
/* 18 */     super.onWidgetRebuild();
/* 19 */     ButtonGuideApi.addGuideToButton(this.screen.children().stream().filter(a -> { if (a instanceof Button) { Button button = (Button)a; ComponentContents patt0$temp = button.getMessage().getContents(); if (patt0$temp instanceof TranslatableContents) { TranslatableContents contents = (TranslatableContents)patt0$temp; if ("gui.back".equals(contents.getKey()) || "gui.cancel".equals(contents.getKey())); }  }  return false; }).findFirst().orElseThrow(), ControlifyBindings.GUI_BACK, ButtonGuidePredicate.always());
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\compat\controlify\screen\CancelButtonScreenProcessor.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */