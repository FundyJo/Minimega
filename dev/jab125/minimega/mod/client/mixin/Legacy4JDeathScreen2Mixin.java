/*    */ package dev.jab125.minimega.mod.client.mixin;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.minecraft.client.gui.components.Button;
/*    */ import net.minecraft.client.gui.components.Renderable;
/*    */ import net.minecraft.client.gui.screens.DeathScreen;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.network.chat.ComponentContents;
/*    */ import net.minecraft.network.chat.contents.TranslatableContents;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin(value = {DeathScreen.class}, priority = 1200)
/*    */ public class Legacy4JDeathScreen2Mixin extends Screen {
/*    */   protected Legacy4JDeathScreen2Mixin(Component component) {
/* 18 */     super(component);
/*    */   }
/*    */   
/*    */   @Inject(method = {"@Minimega:InvInit"}, at = {@At("RETURN")})
/*    */   void init2(CallbackInfo ci2, CallbackInfo ci) {
/* 23 */     if (this.minecraft.level != null && MinigamesController.getMinigameController((Level)this.minecraft.level).getActiveMinigame() == Minigame.FISTFIGHT)
/* 24 */       ((ScreenAccessor)this).getRenderables().removeIf(a -> {
/*    */             if (a instanceof Button) {
/*    */               Button button = (Button)a;
/*    */               ComponentContents patt0$temp = button.getMessage().getContents();
/*    */               if (patt0$temp instanceof TranslatableContents) {
/*    */                 TranslatableContents contents = (TranslatableContents)patt0$temp;
/*    */                 if ("deathScreen.titleScreen".equals(contents.getKey()) || "menu.quit".equals(contents.getKey()));
/*    */               } 
/*    */             } 
/*    */             return false;
/*    */           }); 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\Legacy4JDeathScreen2Mixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */