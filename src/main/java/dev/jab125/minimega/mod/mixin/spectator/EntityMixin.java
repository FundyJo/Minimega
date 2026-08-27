/*    */ package dev.jab125.minimega.mod.mixin.spectator;
/*    */ 
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import dev.jab125.minimega.mod.util.minigamedata.BattleConfig;
/*    */ import dev.jab125.minimega.mod.util.minigamedata.MinigameSpecificConfig;
/*    */ import dev.jab125.minimega.mod.util.minigamedata.battle.BattleConfigSettings;
/*    */ import dev.jab125.minimega.mod.util.minigamedata.battle.SpectatorMode;
/*    */ import net.minecraft.world.entity.Avatar;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({Entity.class})
/*    */ public class EntityMixin
/*    */ {
/*    */   @Shadow
/*    */   private Level level;
/*    */   
/*    */   @Inject(method = {"isInvisibleTo"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void i(Player player, CallbackInfoReturnable<Boolean> cir) {
/* 27 */     MinigameSpecificConfig config = MinigamesController.getMinigameController(this.level).getMinigameData().config();
/* 28 */     if (config instanceof BattleConfig) { BattleConfig battleConfig = (BattleConfig)config; try { BattleConfigSettings battleConfigSettings1 = battleConfig.settings(), settings = battleConfigSettings1; if (settings.spectatorMode() != SpectatorMode.INVISIBLE) { EntityMixin entityMixin = this; if (entityMixin instanceof Avatar) { Avatar avatar = (Avatar)entityMixin; if (avatar.isSpectator())
/* 29 */               cir.setReturnValue(Boolean.valueOf(false));  }
/*    */            }
/*    */          }
/*    */       catch (Throwable throwable)
/*    */       { throw new MatchException(throwable.toString(), throwable); }
/*    */        }
/*    */   
/*    */   }
/*    */   
/*    */   @Inject(method = {"push(Lnet/minecraft/world/entity/Entity;)V"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void push(Entity entity, CallbackInfo ci) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield level : Lnet/minecraft/world/level/Level;
/*    */     //   4: invokestatic getMinigameController : (Lnet/minecraft/world/level/Level;)Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*    */     //   7: invokevirtual minigameAbilities : ()Ldev/jab125/minimega/mod/util/controller/MinigameAbilities;
/*    */     //   10: getfield fjs : Z
/*    */     //   13: ifne -> 17
/*    */     //   16: return
/*    */     //   17: aload_0
/*    */     //   18: astore #5
/*    */     //   20: aload #5
/*    */     //   22: instanceof net/minecraft/world/entity/player/Player
/*    */     //   25: ifeq -> 47
/*    */     //   28: aload #5
/*    */     //   30: checkcast net/minecraft/world/entity/player/Player
/*    */     //   33: astore #4
/*    */     //   35: aload #4
/*    */     //   37: invokevirtual isSpectator : ()Z
/*    */     //   40: ifeq -> 47
/*    */     //   43: iconst_1
/*    */     //   44: goto -> 48
/*    */     //   47: iconst_0
/*    */     //   48: istore_3
/*    */     //   49: aload_1
/*    */     //   50: instanceof net/minecraft/world/entity/player/Player
/*    */     //   53: ifeq -> 74
/*    */     //   56: aload_1
/*    */     //   57: checkcast net/minecraft/world/entity/player/Player
/*    */     //   60: astore #5
/*    */     //   62: aload #5
/*    */     //   64: invokevirtual isSpectator : ()Z
/*    */     //   67: ifeq -> 74
/*    */     //   70: iconst_1
/*    */     //   71: goto -> 75
/*    */     //   74: iconst_0
/*    */     //   75: istore #4
/*    */     //   77: iload_3
/*    */     //   78: ifne -> 86
/*    */     //   81: iload #4
/*    */     //   83: ifeq -> 90
/*    */     //   86: aload_2
/*    */     //   87: invokevirtual cancel : ()V
/*    */     //   90: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #35	-> 0
/*    */     //   #36	-> 17
/*    */     //   #37	-> 49
/*    */     //   #38	-> 77
/*    */     //   #39	-> 86
/*    */     //   #41	-> 90
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   35	12	4	self	Lnet/minecraft/world/entity/player/Player;
/*    */     //   62	12	5	other	Lnet/minecraft/world/entity/player/Player;
/*    */     //   0	91	0	this	Ldev/jab125/minimega/mod/mixin/spectator/EntityMixin;
/*    */     //   0	91	1	entity	Lnet/minecraft/world/entity/Entity;
/*    */     //   0	91	2	ci	Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfo;
/*    */     //   49	42	3	selfSpectator	Z
/*    */     //   77	14	4	otherSpectator	Z
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\spectator\EntityMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */