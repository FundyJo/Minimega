/*     */ package dev.jab125.minimega.mod.mixin;
/*     */ 
/*     */ import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
/*     */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*     */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*     */ import dev.jab125.minimega.mod.abstractions.networking.ServerNetworking;
/*     */ import dev.jab125.minimega.mod.extension.EntityExtension;
/*     */ import dev.jab125.minimega.mod.init.ModSounds;
/*     */ import dev.jab125.minimega.mod.networking.payload.S2CStatusPayload;
/*     */ import dev.jab125.minimega.mod.util.Minigame;
/*     */ import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*     */ import dev.jab125.minimega.mod.util.controller.fistfight.FistfightMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.glide.GlideMinigameController;
/*     */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.level.Level;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mixin({LivingEntity.class})
/*     */ public abstract class LivingEntityMixin
/*     */   extends Entity
/*     */ {
/*     */   @Shadow
/*     */   public abstract boolean isFallFlying();
/*     */   
/*     */   public LivingEntityMixin(EntityType<?> entityType, Level level) {
/*  40 */     super(entityType, level); } @Shadow
/*     */   protected abstract SoundEvent getFallDamageSound(int paramInt); @Shadow
/*     */   public abstract boolean isDeadOrDying(); @Inject(method = {"canGlide"}, at = {@At("HEAD")}, cancellable = true)
/*     */   void canGlide(CallbackInfoReturnable<Boolean> cir) {
/*     */     GlideMinigameController controller;
/*  45 */     AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController(level()).getController(Minigame.GLIDE); if (abstractMinigameController instanceof GlideMinigameController) { controller = (GlideMinigameController)abstractMinigameController; }
/*     */     else { return; }
/*  47 */      if (((EntityExtension)this).mm$finishedMap() && 
/*  48 */       !isFallFlying()) {
/*  49 */       cir.setReturnValue(Boolean.valueOf(false));
/*     */       
/*     */       return;
/*     */     } 
/*  53 */     if (controller.getStage() >= 4)
/*     */     {
/*     */ 
/*     */       
/*  57 */       if (!isFallFlying()) cir.setReturnValue(Boolean.valueOf(false));  } 
/*     */   }
/*     */   
/*     */   @Inject(method = {"handleFallFlyingCollisions"}, at = {@At("HEAD")}, cancellable = true)
/*     */   void hhC(double d, double e, CallbackInfo ci) {
/*     */     GlideMinigameController controller;
/*  63 */     AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController(level()).getController(Minigame.GLIDE); if (abstractMinigameController instanceof GlideMinigameController) { controller = (GlideMinigameController)abstractMinigameController; }
/*     */     else { return; }
/*  65 */      if (((EntityExtension)this).mm$finishedMap())
/*  66 */       return;  if (controller.getStage() >= 4)
/*  67 */       return;  if (controller.getStage() < 2)
/*  68 */       return;  if (this.horizontalCollision || (this.verticalCollision && !this.verticalCollisionBelow)) {
/*  69 */       playSound(getFallDamageSound(150), 1.0F, 1.0F);
/*  70 */       hurt(damageSources().flyIntoWall(), 1.0F);
/*  71 */       ci.cancel();
/*     */     } 
/*     */   }
/*     */   
/*     */   @Inject(method = {"kill"}, at = {@At("HEAD")})
/*     */   void kill(ServerLevel serverLevel, CallbackInfo ci) {
/*  77 */     AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController(level()).getController(Minigame.GLIDE); if (abstractMinigameController instanceof GlideMinigameController) { GlideMinigameController controller = (GlideMinigameController)abstractMinigameController; }
/*     */     else { return; }
/*  79 */      if (isDeadOrDying())
/*  80 */       return;  playSound((SoundEvent)ModSounds.DEATH.value(), 1.0F, 1.0F);
/*  81 */     LivingEntityMixin livingEntityMixin = this; if (livingEntityMixin instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)livingEntityMixin;
/*  82 */       serverPlayer.connection.send(ServerNetworking.getInstance().play((CustomPacketPayload)new S2CStatusPayload(S2CStatusPayload.Status.GLIDE_DEATH))); }
/*     */   
/*     */   }
/*     */   
/*     */   @WrapOperation(method = {"travelFallFlying"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;onClimbable()Z")})
/*     */   boolean travelFallFlying(LivingEntity instance, Operation<Boolean> original) {
/*  88 */     AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController(level()).getController(Minigame.GLIDE); if (abstractMinigameController instanceof GlideMinigameController) { GlideMinigameController controller = (GlideMinigameController)abstractMinigameController; }
/*  89 */     else { return ((Boolean)original.call(new Object[] { instance })).booleanValue(); }
/*  90 */      return false;
/*     */   }
/*     */ 
/*     */   
/*     */   @WrapMethod(method = {"decreaseAirSupply"})
/*     */   int fasterAirDrainage(int i, Operation<Integer> original) {
/*  96 */     AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController(level()).getController(Minigame.FISTFIGHT); if (abstractMinigameController instanceof FistfightMinigameController) { FistfightMinigameController controller = (FistfightMinigameController)abstractMinigameController; if (controller.getFistfightFlag() == 45)
/*     */       {
/*  98 */         return ((Integer)original.call(new Object[] { original.call(new Object[] { Integer.valueOf(i) }) })).intValue(); }  }
/*     */     
/*     */     return ((Integer)original.call(new Object[] { Integer.valueOf(i) })).intValue();
/*     */   } @WrapOperation(method = {"baseTick"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;getAirSupply()I", ordinal = 1)})
/*     */   int baseTickPatchy(LivingEntity instance, Operation<Integer> original) {
/* 103 */     AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController(level()).getController(Minigame.FISTFIGHT); if (abstractMinigameController instanceof FistfightMinigameController) { FistfightMinigameController controller = (FistfightMinigameController)abstractMinigameController; if (controller.getFistfightFlag() == 45) {
/*     */         
/* 105 */         int call = ((Integer)original.call(new Object[] { instance })).intValue();
/* 106 */         return Math.max(call, -20);
/*     */       }  }
/*     */     
/*     */     return ((Integer)original.call(new Object[] { instance })).intValue();
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\LivingEntityMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */