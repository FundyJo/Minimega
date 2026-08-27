/*    */ package dev.jab125.minimega.mod.client.mixin.leaderboard;
/*    */ 
/*    */ import dev.jab125.minimega.mod.client.gui.screen.leaderboard.LeaderboardScreen;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.components.tabs.Tab;
/*    */ import net.minecraft.client.gui.components.tabs.TabManager;
/*    */ import net.minecraft.client.gui.screens.Screen;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({TabManager.class})
/*    */ public class TabManagerMixin {
/*    */   @Inject(method = {"setCurrentTab"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void a(Tab tab, boolean bl, CallbackInfo ci) {
/* 17 */     if (tab instanceof dev.jab125.minimega.mod.client.gui.widget.leaderboard.GlideTab) {
/* 18 */       Minecraft.getInstance().setScreen((Screen)new LeaderboardScreen((Minecraft.getInstance()).screen));
/* 19 */       ci.cancel();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\leaderboard\TabManagerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */