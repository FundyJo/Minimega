/*    */ package dev.jab125.minimega.mod.client.compat.controlify.screen;
/*    */ import dev.isxander.controlify.api.buttonguide.ButtonGuideApi;
/*    */ import dev.isxander.controlify.api.buttonguide.ButtonGuidePredicate;
/*    */ import dev.isxander.controlify.bindings.ControlifyBindings;
/*    */ import dev.isxander.controlify.controller.ControllerEntity;
/*    */ import dev.isxander.controlify.screenop.ScreenProcessor;
/*    */ import dev.jab125.minimega.mod.client.gui.screen.minigame.NewDataScreen;
/*    */ import net.minecraft.client.gui.screens.Screen;
/*    */ 
/*    */ public class DataScreenProcessor extends ScreenProcessor<NewDataScreen> {
/*    */   public DataScreenProcessor(NewDataScreen dataScreen) {
/* 12 */     super((Screen)dataScreen);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onWidgetRebuild() {
/* 17 */     super.onWidgetRebuild();
/* 18 */     if (((NewDataScreen)this.screen).open != null) ButtonGuideApi.addGuideToButton(((NewDataScreen)this.screen).open, ControlifyBindings.GUI_ABSTRACT_ACTION_1, ButtonGuidePredicate.always()); 
/* 19 */     if (((NewDataScreen)this.screen).hasSelectMaps()) {
/* 20 */       ButtonGuideApi.addGuideToButton(((NewDataScreen)this.screen).selectMaps, ControlifyBindings.GUI_ABSTRACT_ACTION_2, ButtonGuidePredicate.always());
/*    */     }
/* 22 */     ButtonGuideApi.addGuideToButton(((NewDataScreen)this.screen).quit, ControlifyBindings.GUI_BACK, ButtonGuidePredicate.always());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void handleButtons(ControllerEntity controllerEntity) {
/* 27 */     super.handleButtons(controllerEntity);
/* 28 */     if (ControlifyBindings.GUI_ABSTRACT_ACTION_1.on(controllerEntity).justPressed() && 
/* 29 */       ((NewDataScreen)this.screen).open != null && ((NewDataScreen)this.screen).open.active) {
/* 30 */       playClackSound();
/* 31 */       ((NewDataScreen)this.screen).open.onPress(null);
/*    */     } 
/*    */     
/* 34 */     if (ControlifyBindings.GUI_ABSTRACT_ACTION_2.on(controllerEntity).justPressed() && (
/* 35 */       (NewDataScreen)this.screen).hasSelectMaps() && ((NewDataScreen)this.screen).selectMaps.active) {
/* 36 */       playClackSound();
/* 37 */       ((NewDataScreen)this.screen).selectMaps.onPress(null);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\compat\controlify\screen\DataScreenProcessor.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */