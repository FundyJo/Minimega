/*     */ package dev.jab125.minimega.mod.mixin;
/*     */ 
/*     */ import com.llamalad7.mixinextras.sugar.Local;
/*     */ import dev.jab125.minimega.mod.extension.PrepareSpawnTaskExtension;
/*     */ import dev.jab125.minimega.mod.party.MinigameParty;
/*     */ import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*     */ import net.minecraft.network.Connection;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.server.network.CommonListenerCookie;
/*     */ import net.minecraft.server.network.config.PrepareSpawnTask;
/*     */ import net.minecraft.world.level.Level;
/*     */ import org.spongepowered.asm.mixin.Final;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mixin(targets = {"net/minecraft/server/network/config/PrepareSpawnTask$Ready"})
/*     */ public class Ready
/*     */ {
/*     */   @Shadow
/*     */   @Final
/*     */   private PrepareSpawnTask this$0;
/*     */   
/*     */   @Inject(method = {"spawn"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/server/players/PlayerList;placeNewPlayer(Lnet/minecraft/network/Connection;Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/server/network/CommonListenerCookie;)V", shift = At.Shift.AFTER)})
/*     */   void load(Connection connection, CommonListenerCookie cookie, CallbackInfoReturnable<ServerPlayer> cir, @Local(ordinal = 0) ServerPlayer player) {
/* 202 */     MinigameParty minigameParty = ((PrepareSpawnTaskExtension)this.this$0).mm$getParty();
/* 203 */     if (minigameParty == null)
/* 204 */       return;  MinigamesController minigameController = MinigamesController.getMinigameController((Level)minigameParty.getPartyLevel());
/* 205 */     MinigameParty.PlayerSlot slot = ((PrepareSpawnTaskExtension)this.this$0).mm$playerSlot();
/* 206 */     AbstractMinigameController<?> controller = minigameController.getController(minigameController.getActiveMinigame());
/* 207 */     controller.mapTransitionScreen(controller.getMapInfo(controller.getMinigame(), controller.getCosmeticId().withPath(a -> a.substring(a.indexOf("/") + 1))), player, true);
/* 208 */     controller.acceptPlayer(slot);
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\PrepareSpawnTaskMixin$Ready.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */