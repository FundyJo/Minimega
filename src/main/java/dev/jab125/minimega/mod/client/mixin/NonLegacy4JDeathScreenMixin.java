/*    */ package dev.jab125.minimega.mod.client.mixin;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.components.Button;
/*    */ import net.minecraft.client.gui.components.Renderable;
/*    */ import net.minecraft.client.gui.screens.DeathScreen;
/*    */ import net.minecraft.client.gui.screens.Screen;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.network.chat.ComponentContents;
/*    */ import net.minecraft.network.chat.MutableComponent;
/*    */ import net.minecraft.network.chat.contents.TranslatableContents;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Mutable;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin(value = {DeathScreen.class}, priority = 1001)
/*    */ public abstract class NonLegacy4JDeathScreenMixin
/*    */   extends Screen {
/*    */   @Shadow
/*    */   private int delayTicker;
/*    */   @Final
/*    */   @Shadow
/*    */   @Mutable
/*    */   private Component deathScore;
/*    */   @Mutable
/*    */   @Shadow
/*    */   @Final
/*    */   private Component causeOfDeath;
/*    */   @Shadow
/*    */   @Final
/*    */   private List<Button> exitButtons;
/*    */   
/*    */   protected NonLegacy4JDeathScreenMixin(Component component) {
/* 44 */     super(component);
/*    */   }
/*    */   
/*    */   @WrapOperation(method = {"<init>"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/network/chat/Component;translatable(Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;")})
/*    */   private static MutableComponent v(String string, Operation<MutableComponent> original) {
/* 49 */     if ((Minecraft.getInstance()).level != null && MinigamesController.getMinigameController((Level)(Minecraft.getInstance()).level).glideActive()) {
/* 50 */       return Component.translatable("minimega.youCrashed");
/*    */     }
/* 52 */     return (MutableComponent)original.call(new Object[] { string });
/*    */   }
/*    */   
/*    */   @Inject(method = {"init"}, at = {@At("RETURN")})
/*    */   void init(CallbackInfo ci) {
/* 57 */     if (this.minecraft.level != null && MinigamesController.getMinigameController((Level)this.minecraft.level).glideActive()) {
/* 58 */       this.causeOfDeath = null;
/* 59 */       ((ScreenAccessor)this).getRenderables().clear();
/* 60 */       this.deathScore = (Component)Component.empty();
/* 61 */     } else if (this.minecraft.level != null && MinigamesController.getMinigameController((Level)this.minecraft.level).getActiveMinigame() == Minigame.FISTFIGHT) {
/* 62 */       ((ScreenAccessor)this).getRenderables().removeIf(a -> { if (a instanceof Button) {
/*    */               Button button = (Button)a; ComponentContents patt0$temp = button.getMessage().getContents(); if (patt0$temp instanceof TranslatableContents) {
/*    */                 TranslatableContents contents = (TranslatableContents)patt0$temp; if ("deathScreen.titleScreen".equals(contents.getKey()));
/*    */               } 
/*    */             }  return false;
/*    */           });
/* 68 */     }  } @Inject(method = {"tick"}, at = {@At("RETURN")}) void tick(CallbackInfo ci) { if ((Minecraft.getInstance()).level != null && MinigamesController.getMinigameController((Level)(Minecraft.getInstance()).level).glideActive()) {
/* 69 */       this.causeOfDeath = null;
/* 70 */       if (this.delayTicker == 20) {
/* 71 */         this.minecraft.player.respawn();
/*    */       }
/* 73 */       this.deathScore = (Component)Component.empty();
/*    */     } 
/* 75 */     if ((Minecraft.getInstance()).level != null)
/* 76 */       if (MinigamesController.getMinigameController((Level)(Minecraft.getInstance()).level).glideActive()) {
/* 77 */         for (Button exitButton : this.exitButtons) {
/* 78 */           exitButton.active = false;
/*    */         }
/* 80 */       } else if (MinigamesController.getMinigameController((Level)(Minecraft.getInstance()).level).getActiveMinigame() == Minigame.FISTFIGHT) {
/* 81 */         for (Button exitButton : this.exitButtons) {
/* 82 */           ComponentContents componentContents = exitButton.getMessage().getContents(); if (componentContents instanceof TranslatableContents) { TranslatableContents contents = (TranslatableContents)componentContents; if ("deathScreen.titleScreen".equals(contents.getKey()))
/* 83 */               exitButton.active = false;  }
/*    */         
/*    */         } 
/*    */       }   }
/*    */ 
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\NonLegacy4JDeathScreenMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */