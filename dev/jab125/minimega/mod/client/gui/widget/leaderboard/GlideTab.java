/*    */ package dev.jab125.minimega.mod.client.gui.widget.leaderboard;
/*    */ 
/*    */ import java.util.function.Consumer;
/*    */ import net.minecraft.client.gui.components.AbstractWidget;
/*    */ import net.minecraft.client.gui.components.tabs.Tab;
/*    */ import net.minecraft.client.gui.navigation.ScreenRectangle;
/*    */ import net.minecraft.network.chat.Component;
/*    */ 
/*    */ public class GlideTab
/*    */   implements Tab
/*    */ {
/*    */   public Component getTabTitle() {
/* 13 */     return (Component)Component.translatable("minimega.glide");
/*    */   }
/*    */ 
/*    */   
/*    */   public Component getTabExtraNarration() {
/* 18 */     return (Component)Component.translatable("minimega.glide");
/*    */   }
/*    */   
/*    */   public void visitChildren(Consumer<AbstractWidget> consumer) {}
/*    */   
/*    */   public void doLayout(ScreenRectangle screenRectangle) {}
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\widget\leaderboard\GlideTab.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */