/*     */ package dev.jab125.minimega.mod.mixin.glide;
/*     */ 
/*     */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*     */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*     */ import dev.jab125.minimega.mod.abstractions.networking.ServerNetworking;
/*     */ import dev.jab125.minimega.mod.debug.MinimegaDebug;
/*     */ import dev.jab125.minimega.mod.extension.EntityExtension;
/*     */ import dev.jab125.minimega.mod.extension.PlayerExtension;
/*     */ import dev.jab125.minimega.mod.init.ModSounds;
/*     */ import dev.jab125.minimega.mod.networking.payload.S2CScoreRingCollisionPayload;
/*     */ import dev.jab125.minimega.mod.networking.payload.S2CStatusPayload;
/*     */ import dev.jab125.minimega.mod.util.MinecraftClientQuarantine;
/*     */ import dev.jab125.minimega.mod.util.Minigame;
/*     */ import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*     */ import dev.jab125.minimega.mod.util.controller.glide.GlideMinigameController;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.Unique;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ 
/*     */ @Mixin({LivingEntity.class})
/*     */ public abstract class LivingEntityMixin extends Entity implements EntityExtension {
/*     */   @Shadow
/*     */   private BlockPos lastPos;
/*     */   @Unique
/*     */   private boolean isApplyingStaticLift;
/*     */   @Unique
/*     */   private boolean isApplyingLift;
/*     */   @Unique
/*     */   private int liftDurationTimer;
/*     */   @Unique
/*     */   private double staticLiftTargetHeight;
/*     */   @Unique
/*     */   private boolean isUpdraft;
/*     */   
/*     */   @Unique
/*  49 */   private MinimegaDebug.GlideData data() { LivingEntity livingEntity = (LivingEntity)this; if (livingEntity instanceof LivingEntity) { LivingEntity livingEntity1 = livingEntity;
/*  50 */       if (MinecraftClientQuarantine.isClientEntity.test(livingEntity1)) {
/*  51 */         return MinimegaDebug.CLIENT;
/*     */       }
/*  53 */       if (MinecraftClientQuarantine.isClientEntityIntegratedServerPerspective.test(livingEntity1)) {
/*  54 */         return MinimegaDebug.SERVER;
/*     */       } }
/*     */     
/*  57 */     return MinimegaDebug.SINK; } @Unique private double targetLiftVelocity; @Unique private GlideMinigameController.Thermal thermalArea; @Unique
/*     */   private double appliedLiftVelocity; @Unique
/*     */   private boolean isSpeedBoosting; @Unique
/*     */   private double targetBoostSpeed; @Unique
/*  61 */   private double liftForceModifier; private boolean hasPendingThermalEntry; public LivingEntityMixin(EntityType<?> entityType, Level level) { super(entityType, level);
/*     */ 
/*     */     
/*  64 */     this.hasPendingThermalEntry = true; }
/*     */   
/*     */   @Unique
/*     */   void setLiftForceModifier(double d) {
/*  68 */     this.liftForceModifier = d;
/*     */   }
/*     */   
/*     */   @Inject(method = {"travel"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;travelFallFlying(Lnet/minecraft/world/phys/Vec3;)V")})
/*     */   void travel(Vec3 vec3, CallbackInfo ci) {
/*  73 */     checkThermalAreas();
/*     */   }
/*     */   
/*     */   @WrapOperation(method = {"travelFallFlying"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;getDeltaMovement()Lnet/minecraft/world/phys/Vec3;")})
/*     */   Vec3 a(LivingEntity instance, Operation<Vec3> original) {
/*  78 */     Vec3 call = (Vec3)original.call(new Object[] { instance });
/*  79 */     if (this.appliedLiftVelocity != 0.0D) {
/*  80 */       Vec3 add = call.multiply(1.0D, 0.0D, 1.0D).add(0.0D, this.appliedLiftVelocity, 0.0D);
/*  81 */       setDeltaMovement(getDeltaMovement().multiply(1.0D, 0.0D, 1.0D));
/*  82 */       return add;
/*     */     } 
/*  84 */     return call;
/*     */   }
/*     */   
/*     */   @WrapOperation(method = {"updateFallFlyingMovement"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/util/Mth;square(D)D")})
/*     */   double updateFallFlyingMovement(double cosLeanAngle, Operation<Double> original) {
/*  89 */     Double call = (Double)original.call(new Object[] { Double.valueOf(cosLeanAngle) });
/*  90 */     if (findActiveThermal() != null) call = Double.valueOf(call.doubleValue() * this.liftForceModifier); 
/*  91 */     return call.doubleValue();
/*     */   }
/*     */   @Unique
/*     */   void checkThermalAreas() {
/*     */     GlideMinigameController controller;
/*  96 */     setLiftForceModifier(1.0D);
/*  97 */     AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController(level()).getController(Minigame.GLIDE); if (abstractMinigameController instanceof GlideMinigameController) { controller = (GlideMinigameController)abstractMinigameController; }
/*     */     else
/*     */     { return; }
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
/* 111 */     Level level = level();
/* 112 */     GlideMinigameController.Thermal activeThermal = null;
/* 113 */     for (GlideMinigameController.Thermal thermal : controller.getThermals()) {
/* 114 */       if (thermal.bounds().intersects(getBoundingBox())) {
/* 115 */         activeThermal = thermal;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 120 */     boolean isInThermal = (activeThermal != null);
/* 121 */     boolean validBoostDirection = false;
/* 122 */     int[] boostDirection = { 0, 0 };
/*     */     
/* 124 */     if (isInThermal) {
/*     */       
/* 126 */       if (this.hasPendingThermalEntry) {
/* 127 */         this.hasPendingThermalEntry = false;
/* 128 */         if (activeThermal.speedDirection().isSpecial()) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 133 */           playSound((SoundEvent)ModSounds.THERMAL.value(), 1.0F, 1.0F);
/* 134 */           if (!level.isClientSide()) { LivingEntityMixin livingEntityMixin = this; if (livingEntityMixin instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)livingEntityMixin;
/* 135 */               serverPlayer.connection.send(ServerNetworking.getInstance().play((CustomPacketPayload)new S2CStatusPayload(S2CStatusPayload.Status.GLIDE_THERMAL))); }
/*     */              }
/*     */         
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 145 */         if (!activeThermal.speedDirection().isSpecial()) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 150 */           playSound((SoundEvent)ModSounds.BOOST.value(), 1.0F, 1.0F);
/* 151 */           if (!level.isClientSide()) { LivingEntityMixin livingEntityMixin = this; if (livingEntityMixin instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)livingEntityMixin;
/* 152 */               serverPlayer.connection.send(ServerNetworking.getInstance().play((CustomPacketPayload)new S2CStatusPayload(S2CStatusPayload.Status.GLIDE_BOOST))); }
/*     */              }
/*     */         
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 163 */       setLiftForceModifier(activeThermal.liftForceModifier());
/*     */       
/* 165 */       if (!this.isApplyingStaticLift) {
/* 166 */         double liftMod = activeThermal.staticLift();
/* 167 */         if (liftMod != 0.0D) {
/* 168 */           this.isApplyingLift = true;
/* 169 */           this.liftDurationTimer = 0;
/*     */         } 
/* 171 */         this.targetLiftVelocity = activeThermal.staticLift();
/*     */       } 
/*     */       
/* 174 */       if (activeThermal.targetHeight() > 0.0D) {
/* 175 */         this.isApplyingStaticLift = true;
/* 176 */         this.staticLiftTargetHeight = activeThermal.targetHeight();
/*     */       } 
/*     */       
/* 179 */       this.isUpdraft = (activeThermal.staticLift() >= 0.0D);
/*     */       
/* 181 */       if (activeThermal.speedBoost() > 0.0D) {
/* 182 */         activateElytraSpeedBoost(activeThermal.speedBoost());
/* 183 */         validBoostDirection = activeThermal.setBoostMods(boostDirection);
/*     */       } 
/*     */ 
/*     */       
/* 187 */       if (this.thermalArea != activeThermal) { LivingEntityMixin livingEntityMixin = this; if (livingEntityMixin instanceof ServerPlayer) ServerPlayer serverPlayer = (ServerPlayer)livingEntityMixin;
/*     */          }
/*     */ 
/*     */       
/* 191 */       this.thermalArea = activeThermal;
/* 192 */     } else if (this.thermalArea != null) {
/* 193 */       this.hasPendingThermalEntry = true;
/* 194 */       if (!level.isClientSide())
/*     */       {
/* 196 */         this.thermalArea = null;
/*     */       }
/*     */     } 
/*     */     
/* 200 */     if (this.isApplyingStaticLift) {
/* 201 */       if (getY() >= this.staticLiftTargetHeight || this.verticalCollision) {
/* 202 */         this.isApplyingStaticLift = false;
/* 203 */         this.isApplyingLift = false;
/*     */       } else {
/* 205 */         this.isApplyingLift = true;
/*     */       } 
/*     */     }
/*     */     
/* 209 */     if (this.isApplyingLift) {
/* 210 */       if (this.appliedLiftVelocity == 0.0D && (getDeltaMovement()).y != 0.0D) {
/* 211 */         this.appliedLiftVelocity = (getDeltaMovement()).y;
/*     */       }
/* 213 */       if (this.isUpdraft) {
/* 214 */         if (this.appliedLiftVelocity < this.targetLiftVelocity) {
/* 215 */           this.appliedLiftVelocity += (this.targetLiftVelocity - this.appliedLiftVelocity) / this.targetLiftVelocity * 0.1D;
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 220 */       else if (this.appliedLiftVelocity > this.targetLiftVelocity) {
/* 221 */         this.appliedLiftVelocity += (this.targetLiftVelocity - this.appliedLiftVelocity) / this.targetLiftVelocity * -0.1D;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 227 */       if (!this.isApplyingStaticLift) {
/* 228 */         this.liftDurationTimer++;
/* 229 */         if (this.liftDurationTimer > 20) {
/* 230 */           this.isApplyingLift = false;
/* 231 */           this.liftDurationTimer = 0;
/*     */         } 
/*     */       } 
/* 234 */     } else if (this.isUpdraft) {
/* 235 */       this.appliedLiftVelocity = (this.appliedLiftVelocity > 0.0D) ? (this.appliedLiftVelocity - 0.025D) : 0.0D;
/*     */     } else {
/* 237 */       this.appliedLiftVelocity = (this.appliedLiftVelocity < 0.0D) ? (this.appliedLiftVelocity + 0.025D) : 0.0D;
/*     */     } 
/*     */     
/* 240 */     if (this.isSpeedBoosting) {
/* 241 */       Vec3 deltaMovement = getDeltaMovement();
/* 242 */       double x = deltaMovement.x;
/* 243 */       double z = deltaMovement.z;
/* 244 */       double horizSpeed = deltaMovement.horizontalDistance();
/* 245 */       double[] deltaXZ = { x, z };
/* 246 */       boolean ch = false;
/* 247 */       if (horizSpeed < this.targetBoostSpeed) {
/* 248 */         if (validBoostDirection) {
/* 249 */           double deltaX = x;
/* 250 */           double absX = Math.abs(deltaX);
/* 251 */           int boostX = boostDirection[1];
/*     */           
/* 253 */           deltaX += absX * 0.1D * boostX;
/* 254 */           deltaXZ[0] = deltaX;
/* 255 */           ch = true;
/*     */           
/* 257 */           double deltaZ = z;
/* 258 */           double absZ = Math.abs(deltaZ);
/* 259 */           int boostZ = boostDirection[0];
/*     */           
/* 261 */           deltaZ += absZ * 0.1D * boostZ;
/* 262 */           deltaXZ[1] = deltaZ;
/* 263 */           ch = true;
/*     */           
/* 265 */           if (deltaX * boostX < 0.0D || deltaZ * boostZ < 0.0D) {
/* 266 */             this.isSpeedBoosting = false;
/*     */           }
/*     */         } else {
/* 269 */           deltaXZ[0] = deltaXZ[0] * 1.1D;
/* 270 */           ch = true;
/* 271 */           deltaXZ[1] = deltaXZ[1] * 1.1D;
/* 272 */           ch = true;
/*     */         } 
/*     */       } else {
/* 275 */         this.isSpeedBoosting = false;
/*     */       } 
/* 277 */       if (ch) setDeltaMovement(deltaXZ[0], deltaMovement.y, deltaXZ[1]);
/*     */     
/*     */     } 
/*     */   }
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
/*     */   @Inject(method = {"tick"}, at = {@At("RETURN")})
/*     */   void tick(CallbackInfo ci) {
/* 298 */     Level level = level();
/* 299 */     int points = 0;
/* 300 */     MinigamesController minigameController = MinigamesController.getMinigameController(level);
/* 301 */     if (minigameController != null) { AbstractMinigameController abstractMinigameController = minigameController.getController(Minigame.GLIDE); if (abstractMinigameController instanceof GlideMinigameController) { GlideMinigameController controller = (GlideMinigameController)abstractMinigameController;
/* 302 */         points = controller.getScoreRingTracker().pointsOf(getUUID());
/* 303 */         for (GlideMinigameController.ScoreRing scoreRing : controller.getScoreRings()) {
/* 304 */           if (controller.getScoreRingTracker().hasNotScored(scoreRing, getUUID()) && 
/* 305 */             collidedWithShapeMovingFrom(oldPosition(), position(), scoreRing.getVoxelShape().toAabbs()) && 
/* 306 */             !level.isClientSide()) { LivingEntityMixin livingEntityMixin1 = this; if (livingEntityMixin1 instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)livingEntityMixin1;
/* 307 */               controller.getScoreRingTracker().score(scoreRing, getUUID());
/* 308 */               serverPlayer.level().getChunkSource().sendToTrackingPlayers((Entity)serverPlayer, 
/* 309 */                   ServerNetworking.getInstance().play((CustomPacketPayload)new S2CScoreRingCollisionPayload(scoreRing.size
/* 310 */                       .ordinal(), serverPlayer.getUUID(), 0)));
/*     */               
/* 312 */               serverPlayer.connection.send(ServerNetworking.getInstance().play((CustomPacketPayload)new S2CScoreRingCollisionPayload(scoreRing.size
/* 313 */                       .ordinal(), serverPlayer.getUUID(), controller.getScoreRingTracker().pointsOf(getUUID())))); }
/*     */              }
/*     */         
/*     */         }  }
/*     */        }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 323 */     int checkpoint = mm$checkpoint();
/* 324 */     boolean finishedMaps = mm$finishedMap();
/* 325 */     MinimegaDebug.GlideData data = data();
/* 326 */     data.isApplyingStaticLift = this.isApplyingStaticLift;
/* 327 */     data.isApplyingLift = this.isApplyingLift;
/* 328 */     data.liftDurationTimer = this.liftDurationTimer;
/* 329 */     data.staticLiftTargetHeight = this.staticLiftTargetHeight;
/* 330 */     data.isUpdraft = this.isUpdraft;
/* 331 */     data.targetLiftVelocity = this.targetLiftVelocity;
/* 332 */     data.thermalArea = this.thermalArea;
/* 333 */     data.appliedLiftVelocity = this.appliedLiftVelocity;
/* 334 */     data.isSpeedBoosting = this.isSpeedBoosting;
/* 335 */     data.targetBoostSpeed = this.targetBoostSpeed;
/* 336 */     data.liftForceModifier = this.liftForceModifier;
/* 337 */     data.hasPendingThermalEntry = this.hasPendingThermalEntry;
/* 338 */     data.points = points;
/* 339 */     data.checkpoint = checkpoint;
/* 340 */     data.finishedMap = finishedMaps;
/* 341 */     LivingEntityMixin livingEntityMixin = this; PlayerExtension extension = (PlayerExtension)livingEntityMixin; data.currentPlayerBoundsVolume = (livingEntityMixin instanceof PlayerExtension) ? extension.mm$getCurrentPlayerBoundsVolume() : null;
/*     */   }
/*     */ 
/*     */   
/*     */   @Unique
/*     */   private void activateElytraSpeedBoost(double v) {
/* 347 */     this.isSpeedBoosting = true;
/* 348 */     this.targetBoostSpeed = v;
/*     */   }
/*     */   
/*     */   @Unique
/*     */   private GlideMinigameController.Thermal findActiveThermal() {
/* 353 */     if (this.thermalArea == null) return null; 
/* 354 */     if (!getBoundingBox().intersects(this.thermalArea.bounds())) {
/* 355 */       return null;
/*     */     }
/* 357 */     return this.thermalArea;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mm$abortBoosts() {
/* 362 */     this.isSpeedBoosting = false;
/* 363 */     this.isApplyingLift = false;
/* 364 */     this.isApplyingStaticLift = false;
/* 365 */     this.appliedLiftVelocity = 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\glide\LivingEntityMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */