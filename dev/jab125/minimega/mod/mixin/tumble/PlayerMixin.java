/*    */ package dev.jab125.minimega.mod.mixin.tumble;
/*    */ 
/*    */ import com.llamalad7.mixinextras.expression.Definition;
/*    */ import com.llamalad7.mixinextras.expression.Expression;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import com.llamalad7.mixinextras.sugar.Local;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.minecraft.world.damagesource.DamageSource;
/*    */ import net.minecraft.world.damagesource.DamageTypes;
/*    */ import net.minecraft.world.entity.Avatar;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Abilities;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({Player.class})
/*    */ public abstract class PlayerMixin
/*    */   extends Avatar
/*    */ {
/*    */   protected PlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) {
/* 26 */     super(entityType, level);
/*    */   }
/*    */   
/*    */   @WrapOperation(method = {"hurtServer"}, at = {@At("MIXINEXTRAS:EXPRESSION")})
/*    */   @Definition(id = "f", local = {@Local(type = float.class, argsOnly = true)})
/*    */   @Expression({"f == 0.0"})
/*    */   boolean snowballsWorkInFistfightAndTumbleAndBattle(float left, float right, Operation<Boolean> original, @Local(argsOnly = true) DamageSource source) {
/* 33 */     if (source.is(DamageTypes.THROWN)) {
/* 34 */       Minigame<?> activeMinigame = MinigamesController.getMinigameController(level()).getActiveMinigame();
/* 35 */       if (activeMinigame == Minigame.TUMBLE || activeMinigame == Minigame.FISTFIGHT || activeMinigame == Minigame.BATTLE) return false; 
/*    */     } 
/* 37 */     return ((Boolean)original.call(new Object[] { Float.valueOf(left), Float.valueOf(right) })).booleanValue();
/*    */   }
/*    */   
/*    */   @WrapOperation(method = {"hurtServer"}, at = {@At(value = "FIELD", target = "Lnet/minecraft/world/entity/player/Abilities;invulnerable:Z", opcode = 180)})
/*    */   boolean snowballsWorkInFistfightAndTumble(Abilities instance, Operation<Boolean> original, @Local(argsOnly = true) DamageSource source) {
/* 42 */     Minigame<?> activeMinigame = MinigamesController.getMinigameController(level()).getActiveMinigame();
/* 43 */     if (activeMinigame == Minigame.TUMBLE && source.is(DamageTypes.THROWN)) return false; 
/* 44 */     return ((Boolean)original.call(new Object[] { instance })).booleanValue();
/*    */   }
/*    */   
/*    */   @WrapOperation(method = {"hasInfiniteMaterials", "canUseGameMasterBlocks"}, at = {@At(value = "FIELD", target = "Lnet/minecraft/world/entity/player/Abilities;instabuild:Z", opcode = 180)})
/*    */   boolean preventHaxsInTumble(Abilities instance, Operation<Boolean> original) {
/* 49 */     Minigame<?> activeMinigame = MinigamesController.getMinigameController(level()).getActiveMinigame();
/* 50 */     if (activeMinigame == Minigame.TUMBLE) return false; 
/* 51 */     return ((Boolean)original.call(new Object[] { instance })).booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\tumble\PlayerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */