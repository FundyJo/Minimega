/*    */ package dev.jab125.minimega.mod.client.gui.screen;
/*    */ 
/*    */ import dev.jab125.minimega.mod.client.MinimegaClient;
/*    */ import java.util.List;
/*    */ import java.util.Objects;
/*    */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*    */ import net.minecraft.client.gui.components.Button;
/*    */ import net.minecraft.client.gui.components.EditBox;
/*    */ import net.minecraft.client.gui.components.events.GuiEventListener;
/*    */ import net.minecraft.client.gui.screens.Screen;
/*    */ import net.minecraft.network.chat.CommonComponents;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.network.chat.FormattedText;
/*    */ import net.minecraft.network.chat.MutableComponent;
/*    */ import net.minecraft.util.FormattedCharSequence;
/*    */ 
/*    */ public class AccessScreen
/*    */   extends Screen {
/*    */   private final Screen parent;
/*    */   
/*    */   public AccessScreen(Screen screen) {
/* 22 */     super((Component)Component.literal("Access"));
/* 23 */     this.parent = screen;
/*    */   }
/*    */   private EditBox code; private Button done;
/*    */   
/*    */   public void onClose() {
/* 28 */     this.minecraft.setScreen(this.parent);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void init() {
/* 33 */     super.init();
/* 34 */     this.code = new EditBox(this.font, this.width / 2 - 100, 66, 200, 20, (Component)Component.translatable("minimega.link.entercode"));
/* 35 */     this.code.setMaxLength(30);
/* 36 */     this.code.setResponder(s -> {
/*    */           this.done.setMessage((Component)Component.translatable("minimega.link.submit"));
/*    */           this.done.active = true;
/*    */         });
/* 40 */     addWidget((GuiEventListener)this.code);
/* 41 */     addRenderableWidget((GuiEventListener)Button.builder(CommonComponents.GUI_CANCEL, button -> cancel()).bounds(this.width / 2 - 100, this.height / 4 + 96 + 18 - 20 - 2, 200, 20).build());
/* 42 */     this.done = (Button)addRenderableWidget(
/* 43 */         (GuiEventListener)Button.builder((Component)Component.translatable("minimega.link.submit"), button -> submit()).bounds(this.width / 2 - 100, this.height / 4 + 96 + 18, 200, 20).build());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void cancel() {
/* 49 */     onClose();
/*    */   }
/*    */ 
/*    */   
/*    */   private void submit() {
/* 54 */     MinimegaClient.submitFeatureFlag(this.code.getValue());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extractRenderState(GuiGraphicsExtractor guiGraphics, int i, int j, float f) {
/* 59 */     super.extractRenderState(guiGraphics, i, j, f);
/* 60 */     MutableComponent s = Component.literal("Enter a code below:");
/* 61 */     List<FormattedCharSequence> formattedText = this.font.split((FormattedText)s, (int)(this.width / 1.5D));
/* 62 */     Objects.requireNonNull(this.font); int offset = 61 - 9 * formattedText.size();
/* 63 */     for (FormattedCharSequence component : formattedText) {
/* 64 */       guiGraphics.centeredText(this.font, component, this.width / 2, offset, -1);
/* 65 */       Objects.requireNonNull(this.font); offset += 9;
/*    */     } 
/* 67 */     this.code.extractRenderState(guiGraphics, i, j, f);
/*    */   }
/*    */   
/*    */   public void success() {
/* 71 */     this.done.active = false;
/* 72 */     this.done.setMessage((Component)Component.literal("Success! You might have to restart the game."));
/*    */   }
/*    */   
/*    */   public void invalidCode() {
/* 76 */     this.done.active = false;
/* 77 */     this.done.setMessage((Component)Component.literal("Invalid code!"));
/*    */   }
/*    */   
/*    */   public void error() {
/* 81 */     this.done.active = false;
/* 82 */     this.done.setMessage((Component)Component.literal("Error!"));
/*    */   }
/*    */   
/*    */   public void ratelimit() {
/* 86 */     this.done.active = false;
/* 87 */     this.done.setMessage((Component)Component.literal("Rate limited!"));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\screen\AccessScreen.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */