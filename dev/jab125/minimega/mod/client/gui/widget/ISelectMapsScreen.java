/*    */ package dev.jab125.minimega.mod.client.gui.widget;
/*    */ 
/*    */ import dev.jab125.minimega.mod.data.MapInfo;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import dev.jab125.minimega.mod.util.Ref;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.resources.Identifier;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface ISelectMapsScreen<T extends net.minecraft.client.gui.screens.Screen>
/*    */ {
/*    */   Minecraft getMinecraftClient();
/*    */   
/*    */   @Nullable
/*    */   ArrayList<Identifier> getSelectedMaps();
/*    */   
/*    */   @Nullable
/*    */   Ref<Identifier> selectedMap();
/*    */   
/*    */   @Nullable
/*    */   List<Identifier> enabledMaps();
/*    */   
/*    */   boolean isVotingScreen();
/*    */   
/*    */   Minigame<?> getMinigame();
/*    */   
/*    */   default T self() {
/* 34 */     return (T)this;
/*    */   }
/*    */   
/*    */   List<MapInfo> mapInfos();
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\widget\ISelectMapsScreen.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */