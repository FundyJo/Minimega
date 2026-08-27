/*    */ package dev.jab125.minimega.mod.client.gui.screen.leaderboard;
/*    */ 
/*    */ import dev.jab125.minimega.mod.client.gui.widget.leaderboard.IPlayerTracker;
/*    */ import dev.jab125.minimega.mod.client.gui.widget.leaderboard.RoundResultsList;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*    */ import net.minecraft.client.gui.components.events.GuiEventListener;
/*    */ import net.minecraft.client.gui.screens.Screen;
/*    */ import net.minecraft.network.chat.Component;
/*    */ 
/*    */ public class RoundResultsScreen extends Screen {
/*    */   private final Screen parent;
/*    */   private final List<? extends IPlayerTracker> trackers;
/*    */   private RoundResultsList list;
/*    */   
/*    */   public RoundResultsScreen(Screen parent, List<? extends IPlayerTracker> trackers) {
/* 17 */     super((Component)Component.empty());
/* 18 */     this.parent = parent;
/* 19 */     this.trackers = trackers;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void init() {
/* 24 */     super.init();
/* 25 */     this.list = (RoundResultsList)addRenderableWidget((GuiEventListener)new RoundResultsList(this.minecraft, this.width, this.height - 70, 32, 18, this.trackers));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void extractTransparentBackground(GuiGraphicsExtractor guiGraphics) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldCloseOnEsc() {
/* 39 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isPauseScreen() {
/* 44 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isInGameUi() {
/* 49 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onClose() {
/* 54 */     this.minecraft.setScreen(this.parent);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\screen\leaderboard\RoundResultsScreen.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */