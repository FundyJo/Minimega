/*    */ package dev.jab125.minimega.mod.mixin.spectator;
/*    */ 
/*    */ import com.llamalad7.mixinextras.expression.Definition;
/*    */ import com.llamalad7.mixinextras.expression.Expression;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import dev.jab125.minimega.mod.util.minigamedata.BattleConfig;
/*    */ import dev.jab125.minimega.mod.util.minigamedata.MinigameSpecificConfig;
/*    */ import dev.jab125.minimega.mod.util.minigamedata.battle.BattleConfigSettings;
/*    */ import dev.jab125.minimega.mod.util.minigamedata.battle.SpectatorMode;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({ServerPlayer.class})
/*    */ public abstract class ServerPlayerMixin
/*    */   extends Entity
/*    */ {
/*    */   public ServerPlayerMixin(EntityType<?> type, Level level) {
/* 28 */     super(type, level);
/*    */   }
/*    */   
/*    */   @Inject(method = {"broadcastToPlayer"}, at = {@At("MIXINEXTRAS:EXPRESSION")}, cancellable = true)
/*    */   @Definition(id = "isSpectator", method = {"Lnet/minecraft/server/level/ServerPlayer;isSpectator()Z"})
/*    */   @Expression({"this.isSpectator()"})
/*    */   void i(ServerPlayer player, CallbackInfoReturnable<Boolean> cir) {
/* 35 */     MinigameSpecificConfig config = MinigamesController.getMinigameController((Level)level()).getMinigameData().config();
/* 36 */     if (config instanceof BattleConfig) { BattleConfig battleConfig = (BattleConfig)config; try { BattleConfigSettings battleConfigSettings1 = battleConfig.settings(), settings = battleConfigSettings1; if (settings.spectatorMode() != SpectatorMode.INVISIBLE)
/* 37 */           cir.setReturnValue(Boolean.valueOf(true));  }
/*    */       catch (Throwable throwable)
/*    */       { throw new MatchException(throwable.toString(), throwable); }
/*    */        }
/*    */   
/*    */   }
/*    */   
/*    */   @Shadow
/*    */   public abstract ServerLevel level();
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\spectator\ServerPlayerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */