/*    */ package dev.jab125.minimega.mod.client.mixin;
/*    */ import dev.jab125.minimega.mod.client.MinimegaClient;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import dev.jab125.minimega.mod.util.controller.glide.GlideMinigameController;
/*    */ import java.util.function.BooleanSupplier;
/*    */ import net.minecraft.client.server.IntegratedServer;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.level.GameType;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({IntegratedServer.class})
/*    */ public class IntegratedServerMixin {
/*    */   @Inject(method = {"publishServer"}, at = {@At("HEAD")})
/*    */   void publish(GameType gameType, boolean bl, int i, CallbackInfoReturnable<Boolean> cir) {
/* 21 */     if (bl || (gameType != GameType.SURVIVAL && gameType != GameType.ADVENTURE)) MinimegaClient.leaderboardsCounted = false; 
/*    */   }
/*    */   
/*    */   @Inject(method = {"tickServer"}, at = {@At(value = "FIELD", target = "Lnet/minecraft/client/server/IntegratedServer;paused:Z", opcode = 181, shift = At.Shift.AFTER)})
/*    */   private void mm$syncGlideTimerPause(BooleanSupplier hasTimeLeft, CallbackInfo ci) {
/* 26 */     IntegratedServer server = (IntegratedServer)this;
/* 27 */     server.getAllLevels().forEach(level -> MinigamesController.getMinigameController((Level)level).getControllerOpt(Minigame.GLIDE).ifPresent(()));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\IntegratedServerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */