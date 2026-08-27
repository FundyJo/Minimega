/*     */ package dev.jab125.minimega.mod.client.mixin.leaderboard;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.UnmodifiableIterator;
/*     */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*     */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*     */ import dev.jab125.minimega.mod.client.extension.TabNavigationBarExtension;
/*     */ import dev.jab125.minimega.mod.client.gui.screen.leaderboard.LeaderboardScreen;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.components.TabButton;
/*     */ import net.minecraft.client.gui.components.events.GuiEventListener;
/*     */ import net.minecraft.client.gui.components.tabs.Tab;
/*     */ import net.minecraft.client.gui.components.tabs.TabNavigationBar;
/*     */ import net.minecraft.client.gui.layouts.LinearLayout;
/*     */ import net.minecraft.client.gui.screens.Screen;
/*     */ import org.spongepowered.asm.mixin.Final;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.Unique;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mixin({TabNavigationBar.class})
/*     */ public class TabNavigationBarMixin
/*     */   implements TabNavigationBarExtension
/*     */ {
/*     */   @Shadow
/*     */   @Final
/*     */   private LinearLayout layout;
/*     */   @Shadow
/*     */   @Final
/*     */   private ImmutableList<Tab> tabs;
/*     */   @Shadow
/*     */   @Final
/*     */   private ImmutableList<TabButton> tabButtons;
/*     */   @Unique
/*     */   private int y;
/*     */   
/*     */   @WrapOperation(method = {"arrangeElements"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/gui/layouts/LinearLayout;setY(I)V")})
/*     */   void y(LinearLayout instance, int i, Operation<Void> original) {
/*  44 */     original.call(new Object[] { instance, Integer.valueOf(this.y) });
/*     */   }
/*     */   
/*     */   @WrapOperation(method = {"arrangeElements"}, at = {@At(value = "INVOKE", target = "Ljava/lang/Math;min(II)I")})
/*     */   int y(int a, int b, Operation<Integer> original) {
/*  49 */     return ((Integer)original.call(new Object[] { Integer.valueOf(this.width), Integer.valueOf(b) })).intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mm$setY(int y) {
/*  56 */     this.y = y;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mm$getY() {
/*  61 */     return this.y;
/*     */   }
/*     */   @Unique
/*  64 */   private int width = 400;
/*     */ 
/*     */   
/*     */   public void mm$setWidth(int width) {
/*  68 */     this.width = width;
/*     */   }
/*     */   
/*     */   @Unique
/*     */   private boolean paginated = false;
/*     */   
/*     */   public void mm$setPaginated() {
/*  75 */     this.paginated = true;
/*     */   }
/*     */ 
/*     */   
/*     */   @WrapOperation(method = {"arrangeElements"}, at = {@At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableList;size()I")})
/*     */   private <E> int set(ImmutableList<E> instance, Operation<Integer> original) {
/*  81 */     if (!this.paginated) return ((Integer)original.call(new Object[] { instance })).intValue(); 
/*  82 */     return Math.min(((Integer)original.call(new Object[] { instance }, )).intValue(), 5);
/*     */   }
/*     */   
/*     */   @WrapOperation(method = {"arrangeElements"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/gui/layouts/LinearLayout;setX(I)V")})
/*     */   void q(LinearLayout instance, int i, Operation<Void> original) {
/*  87 */     if (this.paginated) {
/*  88 */       int x, buttonWidth = ((TabButton)this.tabButtons.get(0)).getWidth();
/*     */ 
/*     */       
/*  91 */       int e = 0;
/*  92 */       UnmodifiableIterator<TabButton> unmodifiableIterator = this.tabButtons.iterator(); while (true) { if (unmodifiableIterator.hasNext()) { TabButton tabButton = unmodifiableIterator.next();
/*  93 */           if (tabButton.isSelected()) {
/*  94 */             e = Math.clamp((e - 2), 0, this.tabs.size() - 5);
/*  95 */             int j = e * buttonWidth;
/*     */             break;
/*     */           } 
/*  98 */           e++; continue; }
/*     */         
/* 100 */         x = 0; break; }
/*     */       
/* 102 */       original.call(new Object[] { instance, Integer.valueOf(i - x) });
/*     */     } else {
/* 104 */       original.call(new Object[] { instance, Integer.valueOf(i) });
/*     */     } 
/*     */   }
/*     */   @Inject(method = {"setFocused(Lnet/minecraft/client/gui/components/events/GuiEventListener;)V"}, at = {@At("HEAD")}, cancellable = true)
/*     */   void sf(GuiEventListener guiEventListener, CallbackInfo ci) {
/* 109 */     if (guiEventListener instanceof TabButton) { TabButton button = (TabButton)guiEventListener; if (button.tab() instanceof dev.jab125.minimega.mod.client.gui.widget.leaderboard.GlideTab) {
/*     */         
/* 111 */         Minecraft.getInstance().setScreen((Screen)new LeaderboardScreen((Minecraft.getInstance()).screen));
/* 112 */         ci.cancel();
/*     */       }  }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\leaderboard\TabNavigationBarMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */