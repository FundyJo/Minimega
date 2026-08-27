/*    */ package dev.jab125.minimega.mod.client.mixin.leaderboard;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.client.extension.StatsScreenExtension;
/*    */ import dev.jab125.minimega.mod.client.gui.widget.leaderboard.GlideTab;
/*    */ import java.util.Arrays;
/*    */ import net.minecraft.client.gui.components.tabs.Tab;
/*    */ import net.minecraft.client.gui.components.tabs.TabNavigationBar;
/*    */ import net.minecraft.client.gui.screens.Screen;
/*    */ import net.minecraft.client.gui.screens.achievement.StatsScreen;
/*    */ import net.minecraft.stats.StatsCounter;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({StatsScreen.class})
/*    */ public class StatsScreenMixin
/*    */   implements StatsScreenExtension
/*    */ {
/*    */   @Shadow
/*    */   @Final
/*    */   protected Screen lastScreen;
/*    */   @Shadow
/*    */   @Final
/*    */   private StatsCounter stats;
/*    */   
/*    */   @WrapOperation(method = {"init", "onStatsUpdated"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/tabs/TabNavigationBar$Builder;addTabs([Lnet/minecraft/client/gui/components/tabs/Tab;)Lnet/minecraft/client/gui/components/tabs/TabNavigationBar$Builder;")})
/*    */   TabNavigationBar.Builder init(TabNavigationBar.Builder instance, Tab[] tabs, Operation<TabNavigationBar.Builder> original) {
/* 31 */     Tab[] newtabs = Arrays.<Tab>copyOf(tabs, tabs.length + 1);
/* 32 */     newtabs[newtabs.length - 1] = (Tab)new GlideTab();
/* 33 */     return (TabNavigationBar.Builder)original.call(new Object[] { instance, newtabs });
/*    */   }
/*    */ 
/*    */   
/*    */   public Screen mm$parent() {
/* 38 */     return this.lastScreen;
/*    */   }
/*    */ 
/*    */   
/*    */   public StatsCounter mm$statsCounter() {
/* 43 */     return this.stats;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\leaderboard\StatsScreenMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */