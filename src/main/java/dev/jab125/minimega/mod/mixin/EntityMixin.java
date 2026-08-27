/*     */ package dev.jab125.minimega.mod.mixin;
/*     */ 
/*     */ import com.google.gson.Gson;
/*     */ import com.llamalad7.mixinextras.sugar.Local;
/*     */ import com.llamalad7.mixinextras.sugar.Share;
/*     */ import com.llamalad7.mixinextras.sugar.ref.LocalRef;
/*     */ import com.mojang.datafixers.util.Pair;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.NamedArea;
/*     */ import dev.jab125.minimega.mod.extension.EntityExtension;
/*     */ import dev.jab125.minimega.mod.util.Minigame;
/*     */ import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*     */ import dev.jab125.minimega.mod.util.controller.fistfight.FistfightMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.glide.GlideMinigameController;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.portal.TeleportTransition;
/*     */ import net.minecraft.world.level.storage.ValueInput;
/*     */ import net.minecraft.world.level.storage.ValueOutput;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.Vec2;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.Unique;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
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
/*     */ @Mixin({Entity.class})
/*     */ public abstract class EntityMixin
/*     */   implements EntityExtension
/*     */ {
/*     */   @Shadow
/*     */   private Vec3 deltaMovement;
/*     */   @Shadow
/*     */   private int id;
/*     */   @Shadow
/*     */   private Level level;
/*     */   @Unique
/*     */   private Double absoluteTargetVelocity;
/*     */   @Unique
/*     */   private Direction absoluteTargetDirection;
/*     */   @Unique
/*     */   private Double relativeTargetVelocity;
/*     */   @Unique
/*     */   private int ticks;
/*     */   @Unique
/*     */   private Double staticLift;
/*     */   @Unique
/*     */   private Double targetAbsoluteHeight;
/*     */   @Unique
/*     */   private int staticTicks;
/*     */   
/*     */   public void mm$setAbsoluteTargetVelocity(Direction direction, Double velocity) {
/* 109 */     this.absoluteTargetVelocity = velocity;
/* 110 */     this.absoluteTargetDirection = direction;
/* 111 */     this.relativeTargetVelocity = null;
/* 112 */     if (velocity != null && direction != null) { this.ticks = 30; }
/* 113 */     else { this.ticks = 0; }
/*     */   
/*     */   }
/*     */   
/*     */   public Pair<Direction, Double> mm$getAbsoluteTargetVelocity() {
/* 118 */     return Pair.of(this.absoluteTargetDirection, this.absoluteTargetVelocity);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mm$setRelativeTargetVelocity(Double velocity) {
/* 123 */     this.relativeTargetVelocity = velocity;
/* 124 */     this.absoluteTargetVelocity = null;
/* 125 */     this.absoluteTargetDirection = null;
/* 126 */     if (velocity != null) { this.ticks = 30; }
/* 127 */     else { this.ticks = 0; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 138 */   private double targetThermalVelocity = 0.0D;
/* 139 */   private double thermalVelocity = 0.0D;
/* 140 */   private int lastCheckpoint = -1;
/* 141 */   private int respawnCheckpoint = -1; @Unique
/* 142 */   private AABB aabb = new AABB(-5000.0D, -5000.0D, -5000.0D, -5000.0D, -5000.0D, -5000.0D); @Unique
/*     */   private AABB prevAABB; @Unique
/*     */   private BlockPos exception; @Unique
/*     */   private boolean finishedMap;
/*     */   public void mm$setThermalVelocity(double velocity) {
/* 147 */     this.thermalVelocity = velocity;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mm$setTargetThermalVelocity(double target, AABB aabb) {
/* 152 */     this.aabb = aabb;
/* 153 */     if (this.thermalVelocity > target)
/* 154 */       return;  this.targetThermalVelocity = target;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mm$setTargetHeight(Double speedBoost, Double targetHeight) {
/* 159 */     if (targetHeight != null && targetHeight.doubleValue() == 0.0D) targetHeight = Double.valueOf(10000.0D); 
/* 160 */     this.staticLift = speedBoost;
/* 161 */     if (targetHeight == null) { this.targetAbsoluteHeight = null; }
/* 162 */     else { this.targetAbsoluteHeight = Double.valueOf(targetHeight.doubleValue() + getY()); }
/* 163 */      if (speedBoost != null && targetHeight != null) { this.staticTicks = 40; }
/* 164 */     else { this.staticTicks = 0; }
/*     */   
/*     */   }
/*     */   
/*     */   public Double mm$getRelativeTargetVelocity() {
/* 169 */     return this.relativeTargetVelocity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mm$clearPrevAABB() {
/* 177 */     this.prevAABB = null;
/*     */   }
/*     */   
/*     */   @Inject(method = {"baseTick"}, at = {@At("HEAD")})
/*     */   private void mm$baseTickStart(CallbackInfo ci, @Share("initialAABB") LocalRef<AABB> aabbRef) {
/* 182 */     if (!isAlive()) this.prevAABB = null; 
/* 183 */     if (this.prevAABB == null && isAlive()) this.prevAABB = makeBoundingBox(); 
/*     */   }
/*     */   
/*     */   @Inject(method = {"baseTick"}, at = {@At("RETURN")})
/*     */   private void mm$baseTickFistfight(CallbackInfo ci) {
/* 188 */     Level level = level(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController((Level)serverLevel).getController(Minigame.FISTFIGHT); if (abstractMinigameController instanceof FistfightMinigameController) { FistfightMinigameController controller = (FistfightMinigameController)abstractMinigameController;
/* 189 */         if (controller.getFistfightFlag() == 17 && getY() < 124.0D && isAlive()) {
/* 190 */           EntityMixin entityMixin = this; if (entityMixin instanceof ServerPlayer) { ServerPlayer player = (ServerPlayer)entityMixin; if (!(player.getAbilities()).invulnerable)
/* 191 */             { player.kill(serverLevel); return; }  }
/* 192 */            if (!(this instanceof ServerPlayer))
/* 193 */             kill(serverLevel); 
/*     */         }  }
/*     */        }
/*     */   
/*     */   }
/*     */   
/*     */   @Inject(method = {"baseTick"}, at = {@At("RETURN")})
/*     */   private void mm$baseTickNamedAreas(CallbackInfo ci) {
/* 201 */     Level level = level(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; AbstractMinigameController<?> abstractMinigameController = MinigamesController.getMinigameController((Level)serverLevel).getController(MinigamesController.getMinigameController((Level)serverLevel).getActiveMinigame()); if (abstractMinigameController instanceof AbstractMinigameController) { AbstractMinigameController<?> controller = abstractMinigameController;
/* 202 */         AABB aabb1 = makeBoundingBox();
/* 203 */         if (MinigamesController.getGameRules((Level)serverLevel).getLevelRules().streamOf(NamedArea.class).filter(a -> (a.dataTag() == 10000000)).anyMatch(a -> aabb1.intersects(a.toAABB()))) {
/* 204 */           EntityMixin entityMixin = this; if (entityMixin instanceof ServerPlayer) { ServerPlayer player = (ServerPlayer)entityMixin; if (!(player.getAbilities()).invulnerable)
/* 205 */             { player.kill(serverLevel); return; }  }
/* 206 */            if (!(this instanceof ServerPlayer)) {
/* 207 */             kill(serverLevel);
/*     */           }
/*     */         }  }
/*     */        }
/*     */   
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
/*     */   @Inject(method = {"baseTick"}, at = {@At("RETURN")})
/*     */   private void mm$baseTick(CallbackInfo ci, @Share("initialAABB") LocalRef<AABB> aabbRef) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield staticTicks : I
/*     */     //   4: ifle -> 17
/*     */     //   7: aload_0
/*     */     //   8: dup
/*     */     //   9: getfield staticTicks : I
/*     */     //   12: iconst_1
/*     */     //   13: isub
/*     */     //   14: putfield staticTicks : I
/*     */     //   17: aload_0
/*     */     //   18: getfield staticTicks : I
/*     */     //   21: ifgt -> 34
/*     */     //   24: aload_0
/*     */     //   25: aconst_null
/*     */     //   26: putfield staticLift : Ljava/lang/Double;
/*     */     //   29: aload_0
/*     */     //   30: aconst_null
/*     */     //   31: putfield targetAbsoluteHeight : Ljava/lang/Double;
/*     */     //   34: aload_0
/*     */     //   35: getfield ticks : I
/*     */     //   38: ifle -> 51
/*     */     //   41: aload_0
/*     */     //   42: dup
/*     */     //   43: getfield ticks : I
/*     */     //   46: iconst_1
/*     */     //   47: isub
/*     */     //   48: putfield ticks : I
/*     */     //   51: aload_0
/*     */     //   52: getfield ticks : I
/*     */     //   55: ifgt -> 73
/*     */     //   58: aload_0
/*     */     //   59: aconst_null
/*     */     //   60: putfield relativeTargetVelocity : Ljava/lang/Double;
/*     */     //   63: aload_0
/*     */     //   64: aconst_null
/*     */     //   65: putfield absoluteTargetVelocity : Ljava/lang/Double;
/*     */     //   68: aload_0
/*     */     //   69: aconst_null
/*     */     //   70: putfield absoluteTargetDirection : Lnet/minecraft/core/Direction;
/*     */     //   73: aload_0
/*     */     //   74: getfield relativeTargetVelocity : Ljava/lang/Double;
/*     */     //   77: astore_3
/*     */     //   78: aload_0
/*     */     //   79: getfield absoluteTargetVelocity : Ljava/lang/Double;
/*     */     //   82: astore #4
/*     */     //   84: aload_0
/*     */     //   85: getfield absoluteTargetDirection : Lnet/minecraft/core/Direction;
/*     */     //   88: astore #5
/*     */     //   90: aload_3
/*     */     //   91: ifnull -> 150
/*     */     //   94: aload_0
/*     */     //   95: invokevirtual getDeltaMovement : ()Lnet/minecraft/world/phys/Vec3;
/*     */     //   98: astore #6
/*     */     //   100: aload #6
/*     */     //   102: invokevirtual length : ()D
/*     */     //   105: aload_3
/*     */     //   106: invokevirtual doubleValue : ()D
/*     */     //   109: dcmpg
/*     */     //   110: ifge -> 142
/*     */     //   113: aload_0
/*     */     //   114: invokevirtual getLookAngle : ()Lnet/minecraft/world/phys/Vec3;
/*     */     //   117: astore #7
/*     */     //   119: aload #6
/*     */     //   121: ldc2_w 1.1
/*     */     //   124: dconst_1
/*     */     //   125: ldc2_w 1.1
/*     */     //   128: invokevirtual multiply : (DDD)Lnet/minecraft/world/phys/Vec3;
/*     */     //   131: astore #8
/*     */     //   133: aload_0
/*     */     //   134: aload #8
/*     */     //   136: invokevirtual setDeltaMovement : (Lnet/minecraft/world/phys/Vec3;)V
/*     */     //   139: goto -> 147
/*     */     //   142: aload_0
/*     */     //   143: aconst_null
/*     */     //   144: putfield relativeTargetVelocity : Ljava/lang/Double;
/*     */     //   147: goto -> 230
/*     */     //   150: aload_0
/*     */     //   151: getfield absoluteTargetVelocity : Ljava/lang/Double;
/*     */     //   154: ifnull -> 230
/*     */     //   157: aload_0
/*     */     //   158: invokevirtual getDeltaMovement : ()Lnet/minecraft/world/phys/Vec3;
/*     */     //   161: astore #6
/*     */     //   163: aload_0
/*     */     //   164: aload #6
/*     */     //   166: aload #5
/*     */     //   168: invokevirtual speed : (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/core/Direction;)D
/*     */     //   171: aload #4
/*     */     //   173: invokevirtual doubleValue : ()D
/*     */     //   176: dcmpg
/*     */     //   177: ifge -> 220
/*     */     //   180: aload #5
/*     */     //   182: invokevirtual getUnitVec3 : ()Lnet/minecraft/world/phys/Vec3;
/*     */     //   185: astore #7
/*     */     //   187: aload #6
/*     */     //   189: aload #7
/*     */     //   191: invokevirtual normalize : ()Lnet/minecraft/world/phys/Vec3;
/*     */     //   194: ldc2_w 0.1
/*     */     //   197: ldc2_w 0.1
/*     */     //   200: ldc2_w 0.1
/*     */     //   203: invokevirtual multiply : (DDD)Lnet/minecraft/world/phys/Vec3;
/*     */     //   206: invokevirtual add : (Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;
/*     */     //   209: astore #8
/*     */     //   211: aload_0
/*     */     //   212: aload #8
/*     */     //   214: invokevirtual setDeltaMovement : (Lnet/minecraft/world/phys/Vec3;)V
/*     */     //   217: goto -> 230
/*     */     //   220: aload_0
/*     */     //   221: aconst_null
/*     */     //   222: putfield absoluteTargetVelocity : Ljava/lang/Double;
/*     */     //   225: aload_0
/*     */     //   226: aconst_null
/*     */     //   227: putfield absoluteTargetDirection : Lnet/minecraft/core/Direction;
/*     */     //   230: aload_0
/*     */     //   231: getfield targetAbsoluteHeight : Ljava/lang/Double;
/*     */     //   234: ifnull -> 407
/*     */     //   237: aload_0
/*     */     //   238: getfield staticLift : Ljava/lang/Double;
/*     */     //   241: ifnull -> 407
/*     */     //   244: aload_0
/*     */     //   245: invokevirtual getY : ()D
/*     */     //   248: aload_0
/*     */     //   249: getfield targetAbsoluteHeight : Ljava/lang/Double;
/*     */     //   252: invokevirtual doubleValue : ()D
/*     */     //   255: dcmpg
/*     */     //   256: ifge -> 397
/*     */     //   259: aload_0
/*     */     //   260: invokevirtual getDeltaMovement : ()Lnet/minecraft/world/phys/Vec3;
/*     */     //   263: astore #6
/*     */     //   265: getstatic net/minecraft/core/Direction.UP : Lnet/minecraft/core/Direction;
/*     */     //   268: invokevirtual getUnitVec3 : ()Lnet/minecraft/world/phys/Vec3;
/*     */     //   271: astore #7
/*     */     //   273: aload_0
/*     */     //   274: aload #6
/*     */     //   276: getstatic net/minecraft/core/Direction.UP : Lnet/minecraft/core/Direction;
/*     */     //   279: invokevirtual speed : (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/core/Direction;)D
/*     */     //   282: dstore #8
/*     */     //   284: dload #8
/*     */     //   286: aload_0
/*     */     //   287: getfield staticLift : Ljava/lang/Double;
/*     */     //   290: invokevirtual doubleValue : ()D
/*     */     //   293: dcmpl
/*     */     //   294: ifle -> 300
/*     */     //   297: goto -> 394
/*     */     //   300: aload #6
/*     */     //   302: aload #7
/*     */     //   304: invokevirtual normalize : ()Lnet/minecraft/world/phys/Vec3;
/*     */     //   307: aload_0
/*     */     //   308: getfield staticLift : Ljava/lang/Double;
/*     */     //   311: invokevirtual doubleValue : ()D
/*     */     //   314: aload_0
/*     */     //   315: getfield staticLift : Ljava/lang/Double;
/*     */     //   318: invokevirtual doubleValue : ()D
/*     */     //   321: aload_0
/*     */     //   322: getfield staticLift : Ljava/lang/Double;
/*     */     //   325: invokevirtual doubleValue : ()D
/*     */     //   328: invokevirtual multiply : (DDD)Lnet/minecraft/world/phys/Vec3;
/*     */     //   331: invokevirtual add : (Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;
/*     */     //   334: astore #10
/*     */     //   336: aload #10
/*     */     //   338: invokevirtual y : ()D
/*     */     //   341: dload #8
/*     */     //   343: aload_0
/*     */     //   344: getfield staticLift : Ljava/lang/Double;
/*     */     //   347: invokevirtual doubleValue : ()D
/*     */     //   350: invokestatic max : (DD)D
/*     */     //   353: dcmpl
/*     */     //   354: ifle -> 388
/*     */     //   357: new net/minecraft/world/phys/Vec3
/*     */     //   360: dup
/*     */     //   361: aload #10
/*     */     //   363: invokevirtual x : ()D
/*     */     //   366: dload #8
/*     */     //   368: aload_0
/*     */     //   369: getfield staticLift : Ljava/lang/Double;
/*     */     //   372: invokevirtual doubleValue : ()D
/*     */     //   375: invokestatic max : (DD)D
/*     */     //   378: aload #10
/*     */     //   380: invokevirtual z : ()D
/*     */     //   383: invokespecial <init> : (DDD)V
/*     */     //   386: astore #10
/*     */     //   388: aload_0
/*     */     //   389: aload #10
/*     */     //   391: invokevirtual setDeltaMovement : (Lnet/minecraft/world/phys/Vec3;)V
/*     */     //   394: goto -> 407
/*     */     //   397: aload_0
/*     */     //   398: aconst_null
/*     */     //   399: putfield targetAbsoluteHeight : Ljava/lang/Double;
/*     */     //   402: aload_0
/*     */     //   403: aconst_null
/*     */     //   404: putfield staticLift : Ljava/lang/Double;
/*     */     //   407: aload_0
/*     */     //   408: invokevirtual level : ()Lnet/minecraft/world/level/Level;
/*     */     //   411: invokestatic getMinigameController : (Lnet/minecraft/world/level/Level;)Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */     //   414: getstatic dev/jab125/minimega/mod/util/Minigame.GLIDE : Ldev/jab125/minimega/mod/util/Minigame;
/*     */     //   417: invokevirtual getController : (Ldev/jab125/minimega/mod/util/Minigame;)Ldev/jab125/minimega/mod/util/controller/AbstractMinigameController;
/*     */     //   420: checkcast dev/jab125/minimega/mod/util/controller/glide/GlideMinigameController
/*     */     //   423: astore #6
/*     */     //   425: aload #6
/*     */     //   427: ifnull -> 438
/*     */     //   430: aload #6
/*     */     //   432: invokevirtual isBeforeStart : ()Z
/*     */     //   435: ifeq -> 439
/*     */     //   438: return
/*     */     //   439: aload_0
/*     */     //   440: getfield targetThermalVelocity : D
/*     */     //   443: dconst_0
/*     */     //   444: dcmpl
/*     */     //   445: ifle -> 463
/*     */     //   448: aload_0
/*     */     //   449: dup
/*     */     //   450: getfield thermalVelocity : D
/*     */     //   453: ldc2_w 0.025
/*     */     //   456: dadd
/*     */     //   457: putfield thermalVelocity : D
/*     */     //   460: goto -> 489
/*     */     //   463: aload_0
/*     */     //   464: dup
/*     */     //   465: getfield thermalVelocity : D
/*     */     //   468: ldc2_w 0.025
/*     */     //   471: dsub
/*     */     //   472: putfield thermalVelocity : D
/*     */     //   475: aload_0
/*     */     //   476: getfield thermalVelocity : D
/*     */     //   479: dconst_0
/*     */     //   480: dcmpg
/*     */     //   481: ifge -> 489
/*     */     //   484: aload_0
/*     */     //   485: dconst_0
/*     */     //   486: putfield thermalVelocity : D
/*     */     //   489: aload_0
/*     */     //   490: invokevirtual makeBoundingBox : ()Lnet/minecraft/world/phys/AABB;
/*     */     //   493: aload_0
/*     */     //   494: getfield aabb : Lnet/minecraft/world/phys/AABB;
/*     */     //   497: invokevirtual intersects : (Lnet/minecraft/world/phys/AABB;)Z
/*     */     //   500: ifne -> 508
/*     */     //   503: aload_0
/*     */     //   504: dconst_0
/*     */     //   505: putfield targetThermalVelocity : D
/*     */     //   508: aload_0
/*     */     //   509: getfield thermalVelocity : D
/*     */     //   512: dconst_0
/*     */     //   513: dcmpl
/*     */     //   514: ifle -> 541
/*     */     //   517: aload_0
/*     */     //   518: iconst_1
/*     */     //   519: invokevirtual setNoGravity : (Z)V
/*     */     //   522: aload_0
/*     */     //   523: aload_0
/*     */     //   524: getfield deltaMovement : Lnet/minecraft/world/phys/Vec3;
/*     */     //   527: dconst_1
/*     */     //   528: ldc2_w 0.9
/*     */     //   531: dconst_1
/*     */     //   532: invokevirtual multiply : (DDD)Lnet/minecraft/world/phys/Vec3;
/*     */     //   535: putfield deltaMovement : Lnet/minecraft/world/phys/Vec3;
/*     */     //   538: goto -> 546
/*     */     //   541: aload_0
/*     */     //   542: iconst_0
/*     */     //   543: invokevirtual setNoGravity : (Z)V
/*     */     //   546: aload #6
/*     */     //   548: ifnull -> 1159
/*     */     //   551: aload #6
/*     */     //   553: invokevirtual isBeforeStart : ()Z
/*     */     //   556: ifne -> 1159
/*     */     //   559: aload_0
/*     */     //   560: getfield finishedMap : Z
/*     */     //   563: ifne -> 1159
/*     */     //   566: aload #6
/*     */     //   568: invokevirtual getFinishLine : ()Lnet/minecraft/world/phys/AABB;
/*     */     //   571: astore #7
/*     */     //   573: iconst_0
/*     */     //   574: istore #8
/*     */     //   576: aload_0
/*     */     //   577: invokevirtual makeBoundingBox : ()Lnet/minecraft/world/phys/AABB;
/*     */     //   580: astore #9
/*     */     //   582: aload_0
/*     */     //   583: getfield finishedMap : Z
/*     */     //   586: ifne -> 727
/*     */     //   589: aload #6
/*     */     //   591: invokevirtual getCheckpoints : ()Ljava/util/ArrayList;
/*     */     //   594: invokevirtual stream : ()Ljava/util/stream/Stream;
/*     */     //   597: <illegal opcode> applyAsInt : ()Ljava/util/function/ToIntFunction;
/*     */     //   602: invokestatic comparingInt : (Ljava/util/function/ToIntFunction;)Ljava/util/Comparator;
/*     */     //   605: invokeinterface reversed : ()Ljava/util/Comparator;
/*     */     //   610: invokeinterface sorted : (Ljava/util/Comparator;)Ljava/util/stream/Stream;
/*     */     //   615: invokeinterface findFirst : ()Ljava/util/Optional;
/*     */     //   620: aload_0
/*     */     //   621: <illegal opcode> apply : (Ldev/jab125/minimega/mod/mixin/EntityMixin;)Ljava/util/function/Function;
/*     */     //   626: invokevirtual map : (Ljava/util/function/Function;)Ljava/util/Optional;
/*     */     //   629: iconst_1
/*     */     //   630: invokestatic valueOf : (Z)Ljava/lang/Boolean;
/*     */     //   633: invokevirtual orElse : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   636: checkcast java/lang/Boolean
/*     */     //   639: invokevirtual booleanValue : ()Z
/*     */     //   642: ifeq -> 727
/*     */     //   645: aload #9
/*     */     //   647: aload #7
/*     */     //   649: invokevirtual intersects : (Lnet/minecraft/world/phys/AABB;)Z
/*     */     //   652: ifne -> 684
/*     */     //   655: aload_0
/*     */     //   656: getfield prevAABB : Lnet/minecraft/world/phys/AABB;
/*     */     //   659: ifnonnull -> 667
/*     */     //   662: aload #9
/*     */     //   664: goto -> 671
/*     */     //   667: aload_0
/*     */     //   668: getfield prevAABB : Lnet/minecraft/world/phys/AABB;
/*     */     //   671: aload #9
/*     */     //   673: aload #7
/*     */     //   675: invokestatic intersected : (Lnet/minecraft/world/phys/AABB;Lnet/minecraft/world/phys/AABB;Lnet/minecraft/world/phys/AABB;)Z
/*     */     //   678: dup
/*     */     //   679: istore #8
/*     */     //   681: ifeq -> 727
/*     */     //   684: aload_0
/*     */     //   685: iconst_1
/*     */     //   686: putfield finishedMap : Z
/*     */     //   689: aload_0
/*     */     //   690: invokevirtual level : ()Lnet/minecraft/world/level/Level;
/*     */     //   693: invokevirtual isClientSide : ()Z
/*     */     //   696: ifne -> 724
/*     */     //   699: aload_0
/*     */     //   700: astore #11
/*     */     //   702: aload #11
/*     */     //   704: instanceof net/minecraft/server/level/ServerPlayer
/*     */     //   707: ifeq -> 724
/*     */     //   710: aload #11
/*     */     //   712: checkcast net/minecraft/server/level/ServerPlayer
/*     */     //   715: astore #10
/*     */     //   717: aload #6
/*     */     //   719: aload #10
/*     */     //   721: invokevirtual finished : (Lnet/minecraft/server/level/ServerPlayer;)V
/*     */     //   724: goto -> 1159
/*     */     //   727: aload_0
/*     */     //   728: astore #8
/*     */     //   730: aload #8
/*     */     //   732: instanceof net/minecraft/server/level/ServerPlayer
/*     */     //   735: ifeq -> 781
/*     */     //   738: aload #8
/*     */     //   740: checkcast net/minecraft/server/level/ServerPlayer
/*     */     //   743: astore #7
/*     */     //   745: aload #7
/*     */     //   747: invokevirtual level : ()Lnet/minecraft/server/level/ServerLevel;
/*     */     //   750: invokevirtual isClientSide : ()Z
/*     */     //   753: ifne -> 781
/*     */     //   756: aload #7
/*     */     //   758: invokevirtual isSpectator : ()Z
/*     */     //   761: ifne -> 781
/*     */     //   764: aload #6
/*     */     //   766: invokevirtual isPlaying : ()Z
/*     */     //   769: ifeq -> 781
/*     */     //   772: aload #6
/*     */     //   774: aload_0
/*     */     //   775: invokevirtual makeBoundingBox : ()Lnet/minecraft/world/phys/AABB;
/*     */     //   778: invokevirtual addAABB : (Lnet/minecraft/world/phys/AABB;)V
/*     */     //   781: aload #6
/*     */     //   783: invokevirtual getCheckpoints : ()Ljava/util/ArrayList;
/*     */     //   786: invokevirtual iterator : ()Ljava/util/Iterator;
/*     */     //   789: astore #7
/*     */     //   791: aload #7
/*     */     //   793: invokeinterface hasNext : ()Z
/*     */     //   798: ifeq -> 1094
/*     */     //   801: aload #7
/*     */     //   803: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   808: checkcast dev/jab125/minimega/mod/util/controller/glide/GlideMinigameController$Checkpoint
/*     */     //   811: astore #8
/*     */     //   813: new net/minecraft/world/phys/AABB
/*     */     //   816: dup
/*     */     //   817: aload #8
/*     */     //   819: getfield x0 : D
/*     */     //   822: aload #8
/*     */     //   824: getfield y0 : D
/*     */     //   827: aload #8
/*     */     //   829: getfield z0 : D
/*     */     //   832: aload #8
/*     */     //   834: getfield x1 : D
/*     */     //   837: aload #8
/*     */     //   839: getfield y1 : D
/*     */     //   842: aload #8
/*     */     //   844: getfield z1 : D
/*     */     //   847: invokespecial <init> : (DDDDDD)V
/*     */     //   850: astore #9
/*     */     //   852: aload_0
/*     */     //   853: invokevirtual makeBoundingBox : ()Lnet/minecraft/world/phys/AABB;
/*     */     //   856: astore #10
/*     */     //   858: iconst_0
/*     */     //   859: istore #11
/*     */     //   861: aload #8
/*     */     //   863: getfield id : I
/*     */     //   866: aload_0
/*     */     //   867: getfield lastCheckpoint : I
/*     */     //   870: if_icmpeq -> 1091
/*     */     //   873: aload #10
/*     */     //   875: aload #9
/*     */     //   877: invokevirtual intersects : (Lnet/minecraft/world/phys/AABB;)Z
/*     */     //   880: ifne -> 912
/*     */     //   883: aload_0
/*     */     //   884: getfield prevAABB : Lnet/minecraft/world/phys/AABB;
/*     */     //   887: ifnonnull -> 895
/*     */     //   890: aload #10
/*     */     //   892: goto -> 899
/*     */     //   895: aload_0
/*     */     //   896: getfield prevAABB : Lnet/minecraft/world/phys/AABB;
/*     */     //   899: aload #10
/*     */     //   901: aload #9
/*     */     //   903: invokestatic intersected : (Lnet/minecraft/world/phys/AABB;Lnet/minecraft/world/phys/AABB;Lnet/minecraft/world/phys/AABB;)Z
/*     */     //   906: dup
/*     */     //   907: istore #11
/*     */     //   909: ifeq -> 1091
/*     */     //   912: iload #11
/*     */     //   914: ifeq -> 923
/*     */     //   917: getstatic net/minecraft/ChatFormatting.AQUA : Lnet/minecraft/ChatFormatting;
/*     */     //   920: goto -> 926
/*     */     //   923: getstatic net/minecraft/ChatFormatting.BLUE : Lnet/minecraft/ChatFormatting;
/*     */     //   926: astore #12
/*     */     //   928: aload #8
/*     */     //   930: getfield id : I
/*     */     //   933: aload_0
/*     */     //   934: getfield lastCheckpoint : I
/*     */     //   937: iconst_1
/*     */     //   938: iadd
/*     */     //   939: if_icmpeq -> 971
/*     */     //   942: aload_0
/*     */     //   943: astore #14
/*     */     //   945: aload #14
/*     */     //   947: instanceof net/minecraft/server/level/ServerPlayer
/*     */     //   950: ifeq -> 968
/*     */     //   953: aload #14
/*     */     //   955: checkcast net/minecraft/server/level/ServerPlayer
/*     */     //   958: astore #13
/*     */     //   960: aload #13
/*     */     //   962: getstatic dev/jab125/minimega/mod/networking/payload/S2CStatusPayload$Status.WRONG_WAY : Ldev/jab125/minimega/mod/networking/payload/S2CStatusPayload$Status;
/*     */     //   965: invokestatic sendStatus : (Lnet/minecraft/server/level/ServerPlayer;Ldev/jab125/minimega/mod/networking/payload/S2CStatusPayload$Status;)V
/*     */     //   968: goto -> 1073
/*     */     //   971: aload_0
/*     */     //   972: aload #8
/*     */     //   974: getfield id : I
/*     */     //   977: invokevirtual mm$checkpoint : (I)V
/*     */     //   980: aload #8
/*     */     //   982: getfield updatePlayer : Ljava/util/Optional;
/*     */     //   985: invokevirtual isPresent : ()Z
/*     */     //   988: ifeq -> 1055
/*     */     //   991: aload_0
/*     */     //   992: aload #8
/*     */     //   994: getfield id : I
/*     */     //   997: putfield respawnCheckpoint : I
/*     */     //   1000: aload #8
/*     */     //   1002: getfield id : I
/*     */     //   1005: ifeq -> 1052
/*     */     //   1008: aload_0
/*     */     //   1009: astore #14
/*     */     //   1011: aload #14
/*     */     //   1013: instanceof net/minecraft/server/level/ServerPlayer
/*     */     //   1016: ifeq -> 1052
/*     */     //   1019: aload #14
/*     */     //   1021: checkcast net/minecraft/server/level/ServerPlayer
/*     */     //   1024: astore #13
/*     */     //   1026: aload #6
/*     */     //   1028: invokevirtual getScoreRingTracker : ()Ldev/jab125/minimega/mod/util/controller/glide/GlideMinigameController$ScoreRingTracker;
/*     */     //   1031: aload #13
/*     */     //   1033: invokevirtual getUUID : ()Ljava/util/UUID;
/*     */     //   1036: invokevirtual saveSnapshot : (Ljava/util/UUID;)V
/*     */     //   1039: aload #13
/*     */     //   1041: getstatic dev/jab125/minimega/mod/networking/payload/S2CStatusPayload$Status.CHECKPOINT : Ldev/jab125/minimega/mod/networking/payload/S2CStatusPayload$Status;
/*     */     //   1044: aload #8
/*     */     //   1046: getfield id : I
/*     */     //   1049: invokestatic sendStatus : (Lnet/minecraft/server/level/ServerPlayer;Ldev/jab125/minimega/mod/networking/payload/S2CStatusPayload$Status;I)V
/*     */     //   1052: goto -> 1073
/*     */     //   1055: aload_0
/*     */     //   1056: astore #14
/*     */     //   1058: aload #14
/*     */     //   1060: instanceof net/minecraft/server/level/ServerPlayer
/*     */     //   1063: ifeq -> 1073
/*     */     //   1066: aload #14
/*     */     //   1068: checkcast net/minecraft/server/level/ServerPlayer
/*     */     //   1071: astore #13
/*     */     //   1073: aload_0
/*     */     //   1074: astore #14
/*     */     //   1076: aload #14
/*     */     //   1078: instanceof net/minecraft/server/level/ServerPlayer
/*     */     //   1081: ifeq -> 1091
/*     */     //   1084: aload #14
/*     */     //   1086: checkcast net/minecraft/server/level/ServerPlayer
/*     */     //   1089: astore #13
/*     */     //   1091: goto -> 791
/*     */     //   1094: aload_0
/*     */     //   1095: astore #8
/*     */     //   1097: aload #8
/*     */     //   1099: instanceof net/minecraft/server/level/ServerPlayer
/*     */     //   1102: ifeq -> 1159
/*     */     //   1105: aload #8
/*     */     //   1107: checkcast net/minecraft/server/level/ServerPlayer
/*     */     //   1110: astore #7
/*     */     //   1112: aload #7
/*     */     //   1114: invokevirtual isSpectator : ()Z
/*     */     //   1117: ifne -> 1151
/*     */     //   1120: aload #7
/*     */     //   1122: invokevirtual isCreative : ()Z
/*     */     //   1125: ifeq -> 1131
/*     */     //   1128: goto -> 1151
/*     */     //   1131: aload #7
/*     */     //   1133: invokevirtual onGround : ()Z
/*     */     //   1136: ifeq -> 1151
/*     */     //   1139: aload #7
/*     */     //   1141: aload_0
/*     */     //   1142: getfield level : Lnet/minecraft/world/level/Level;
/*     */     //   1145: checkcast net/minecraft/server/level/ServerLevel
/*     */     //   1148: invokevirtual kill : (Lnet/minecraft/server/level/ServerLevel;)V
/*     */     //   1151: aload #7
/*     */     //   1153: invokevirtual isFallFlying : ()Z
/*     */     //   1156: ifne -> 1159
/*     */     //   1159: aload_0
/*     */     //   1160: aload_0
/*     */     //   1161: invokevirtual makeBoundingBox : ()Lnet/minecraft/world/phys/AABB;
/*     */     //   1164: putfield prevAABB : Lnet/minecraft/world/phys/AABB;
/*     */     //   1167: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #215	-> 0
/*     */     //   #216	-> 17
/*     */     //   #217	-> 24
/*     */     //   #218	-> 29
/*     */     //   #220	-> 34
/*     */     //   #221	-> 51
/*     */     //   #222	-> 58
/*     */     //   #223	-> 63
/*     */     //   #224	-> 68
/*     */     //   #226	-> 73
/*     */     //   #227	-> 78
/*     */     //   #228	-> 84
/*     */     //   #229	-> 90
/*     */     //   #230	-> 94
/*     */     //   #231	-> 100
/*     */     //   #232	-> 113
/*     */     //   #233	-> 119
/*     */     //   #234	-> 133
/*     */     //   #235	-> 139
/*     */     //   #236	-> 142
/*     */     //   #238	-> 147
/*     */     //   #240	-> 157
/*     */     //   #241	-> 163
/*     */     //   #242	-> 180
/*     */     //   #243	-> 187
/*     */     //   #244	-> 211
/*     */     //   #245	-> 217
/*     */     //   #246	-> 220
/*     */     //   #247	-> 225
/*     */     //   #250	-> 230
/*     */     //   #251	-> 244
/*     */     //   #252	-> 259
/*     */     //   #253	-> 265
/*     */     //   #254	-> 273
/*     */     //   #255	-> 284
/*     */     //   #258	-> 300
/*     */     //   #259	-> 336
/*     */     //   #260	-> 357
/*     */     //   #262	-> 388
/*     */     //   #268	-> 394
/*     */     //   #269	-> 397
/*     */     //   #270	-> 402
/*     */     //   #273	-> 407
/*     */     //   #274	-> 425
/*     */     //   #275	-> 439
/*     */     //   #276	-> 448
/*     */     //   #278	-> 463
/*     */     //   #279	-> 475
/*     */     //   #282	-> 489
/*     */     //   #283	-> 508
/*     */     //   #284	-> 517
/*     */     //   #285	-> 522
/*     */     //   #287	-> 541
/*     */     //   #291	-> 546
/*     */     //   #293	-> 566
/*     */     //   #294	-> 573
/*     */     //   #295	-> 576
/*     */     //   #296	-> 582
/*     */     //   #297	-> 684
/*     */     //   #298	-> 689
/*     */     //   #299	-> 717
/*     */     //   #301	-> 724
/*     */     //   #304	-> 727
/*     */     //   #305	-> 764
/*     */     //   #307	-> 781
/*     */     //   #308	-> 813
/*     */     //   #309	-> 852
/*     */     //   #310	-> 858
/*     */     //   #311	-> 861
/*     */     //   #312	-> 912
/*     */     //   #313	-> 928
/*     */     //   #314	-> 942
/*     */     //   #315	-> 960
/*     */     //   #317	-> 971
/*     */     //   #318	-> 980
/*     */     //   #319	-> 991
/*     */     //   #320	-> 1000
/*     */     //   #321	-> 1026
/*     */     //   #322	-> 1039
/*     */     //   #325	-> 1055
/*     */     //   #330	-> 1073
/*     */     //   #335	-> 1091
/*     */     //   #336	-> 1094
/*     */     //   #337	-> 1112
/*     */     //   #338	-> 1131
/*     */     //   #339	-> 1151
/*     */     //   #344	-> 1159
/*     */     //   #345	-> 1167
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   119	20	7	rotationVector	Lnet/minecraft/world/phys/Vec3;
/*     */     //   133	6	8	add	Lnet/minecraft/world/phys/Vec3;
/*     */     //   100	47	6	deltaMovement	Lnet/minecraft/world/phys/Vec3;
/*     */     //   187	30	7	rotationVector	Lnet/minecraft/world/phys/Vec3;
/*     */     //   211	6	8	add	Lnet/minecraft/world/phys/Vec3;
/*     */     //   163	67	6	deltaMovement	Lnet/minecraft/world/phys/Vec3;
/*     */     //   336	58	10	add	Lnet/minecraft/world/phys/Vec3;
/*     */     //   265	129	6	deltaMovement	Lnet/minecraft/world/phys/Vec3;
/*     */     //   273	121	7	rotationVector	Lnet/minecraft/world/phys/Vec3;
/*     */     //   284	110	8	y	D
/*     */     //   717	7	10	player	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   573	154	7	finishLine	Lnet/minecraft/world/phys/AABB;
/*     */     //   576	151	8	wasCaughtByFallback	Z
/*     */     //   582	145	9	aabb	Lnet/minecraft/world/phys/AABB;
/*     */     //   745	36	7	serverPlayer	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   960	8	13	serverPlayer	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   1026	26	13	serverPlayer	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   928	163	12	formatting	Lnet/minecraft/ChatFormatting;
/*     */     //   852	239	9	aabb	Lnet/minecraft/world/phys/AABB;
/*     */     //   858	233	10	newAABB	Lnet/minecraft/world/phys/AABB;
/*     */     //   861	230	11	wasCaughtByFallback	Z
/*     */     //   813	278	8	checkpoint	Ldev/jab125/minimega/mod/util/controller/glide/GlideMinigameController$Checkpoint;
/*     */     //   1112	47	7	serverPlayer	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   0	1168	0	this	Ldev/jab125/minimega/mod/mixin/EntityMixin;
/*     */     //   0	1168	1	ci	Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfo;
/*     */     //   0	1168	2	aabbRef	Lcom/llamalad7/mixinextras/sugar/ref/LocalRef;
/*     */     //   78	1090	3	relativeTargetVelocity1	Ljava/lang/Double;
/*     */     //   84	1084	4	absoluteTargetVelocity1	Ljava/lang/Double;
/*     */     //   90	1078	5	absoluteTargetDirection1	Lnet/minecraft/core/Direction;
/*     */     //   425	743	6	controller	Ldev/jab125/minimega/mod/util/controller/glide/GlideMinigameController;
/*     */     // Local variable type table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	1168	2	aabbRef	Lcom/llamalad7/mixinextras/sugar/ref/LocalRef<Lnet/minecraft/world/phys/AABB;>;
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
/*     */   public int mm$respawnCheckpoont() {
/* 349 */     return this.respawnCheckpoint;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mm$respawnCheckpoint(int id) {
/* 354 */     this.respawnCheckpoint = id;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mm$checkpoint() {
/* 359 */     return this.lastCheckpoint;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mm$checkpoint(int id) {
/* 364 */     this.lastCheckpoint = id;
/*     */   }
/*     */   
/*     */   @Inject(method = {"getDeltaMovement"}, at = {@At("HEAD")}, cancellable = true)
/*     */   void getD(CallbackInfoReturnable<Vec3> cir) {
/* 369 */     AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController(level()).getController(Minigame.GLIDE); if (abstractMinigameController instanceof GlideMinigameController) { GlideMinigameController controller = (GlideMinigameController)abstractMinigameController; if (controller.isBeforeStart())
/* 370 */         cir.setReturnValue(new Vec3(0.0D, 0.0D, 0.0D));  }
/*     */   
/*     */   }
/*     */   
/*     */   @Inject(method = {"getDeltaMovement"}, at = {@At("RETURN")}, cancellable = true)
/*     */   void getDV(CallbackInfoReturnable<Vec3> cir) {
/* 376 */     AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController(level()).getController(Minigame.GLIDE); if (abstractMinigameController instanceof GlideMinigameController) { GlideMinigameController controller = (GlideMinigameController)abstractMinigameController; if (controller.isBeforeStart())
/*     */         return;  }
/* 378 */      cir.setReturnValue(((Vec3)cir.getReturnValue()).add(new Vec3(0.0D, this.thermalVelocity, 0.0D)));
/*     */   }
/*     */   
/*     */   @Inject(method = {"setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V"}, at = {@At("HEAD")})
/*     */   void setDV(Vec3 vec3, CallbackInfo ci, @Local(argsOnly = true) LocalRef<Vec3> o) {
/* 383 */     AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController(level()).getController(Minigame.GLIDE); if (abstractMinigameController instanceof GlideMinigameController) { GlideMinigameController controller = (GlideMinigameController)abstractMinigameController; if (controller.isBeforeStart()) {
/* 384 */         o.set(new Vec3(0.0D, 0.0D, 0.0D)); return;
/*     */       }  }
/* 386 */      o.set(((Vec3)o.get()).subtract(new Vec3(0.0D, this.thermalVelocity, 0.0D)));
/*     */   }
/*     */ 
/*     */   
/*     */   @Unique
/*     */   private double speed(Vec3 deltaMovement, Direction absoluteTargetDirection) {
/* 392 */     switch (absoluteTargetDirection.getAxis()) { default: throw new MatchException(null, null);case NEGATIVE: case POSITIVE: case null: break; }  double mvt = 
/*     */ 
/*     */       
/* 395 */       deltaMovement.z();
/*     */     
/* 397 */     switch (absoluteTargetDirection.getAxisDirection()) { default: throw new MatchException(null, null);case NEGATIVE: case POSITIVE: break; }  mvt *= 
/*     */       
/* 399 */       1.0D;
/*     */     
/* 401 */     return mvt;
/*     */   }
/*     */   
/*     */   @Inject(method = {"saveWithoutId"}, at = {@At("RETURN")})
/*     */   private void mm$saveWithoutId(ValueOutput valueOutput, CallbackInfo ci) {
/* 406 */     if (this.relativeTargetVelocity != null) {
/* 407 */       valueOutput.putDouble("minimega:relative_target_velocity", this.relativeTargetVelocity.doubleValue());
/* 408 */     } else if (this.absoluteTargetVelocity != null && this.absoluteTargetDirection != null) {
/* 409 */       valueOutput.putDouble("minimega:absolute_target_velocity", this.absoluteTargetVelocity.doubleValue());
/* 410 */       valueOutput.putInt("minimega:absolute_target_direction", this.absoluteTargetDirection.ordinal());
/*     */     } 
/* 412 */     if (this.targetAbsoluteHeight != null && this.staticLift != null) {
/* 413 */       valueOutput.putDouble("minimega:target_absolute_height", this.targetAbsoluteHeight.doubleValue());
/* 414 */       valueOutput.putDouble("minimega:static_lift", this.staticLift.doubleValue());
/*     */     } 
/* 416 */     valueOutput.putDouble("minimega:thermal_velocity", this.thermalVelocity);
/* 417 */     valueOutput.putDouble("minimega:target_thermal_velocity", this.targetThermalVelocity);
/* 418 */     Gson gson = new Gson();
/* 419 */     valueOutput.putString("minimega:wipaabb", gson.toJson(this.aabb));
/* 420 */     valueOutput.putBoolean("minimega:finished_glide_map", this.finishedMap);
/*     */   }
/*     */   
/*     */   @Inject(method = {"load"}, at = {@At("RETURN")})
/*     */   private void mm$load(ValueInput valueInput, CallbackInfo ci) {
/* 425 */     if (valueInput.contains("minimega:relative_target_velocity")) {
/* 426 */       this.relativeTargetVelocity = Double.valueOf(valueInput.getDoubleOr("minimega:relative_target_velocity", 0.0D));
/*     */     }
/* 428 */     else if (valueInput.contains("minimega:absolute_target_velocity") && valueInput
/* 429 */       .contains("minimega:absolute_target_direction")) {
/* 430 */       this.absoluteTargetVelocity = Double.valueOf(valueInput.getDoubleOr("minimega:absolute_target_velocity", 0.0D));
/* 431 */       this.absoluteTargetDirection = Direction.values()[Math.clamp(((Integer)valueInput.getInt("absolute_target_direction").orElse((T)Integer.valueOf(0))).intValue(), 0, 5)];
/*     */     } 
/*     */     
/* 434 */     if (valueInput.contains("minimega:target_absolute_height") && valueInput
/* 435 */       .contains("minimega:static_lift")) {
/* 436 */       this.targetAbsoluteHeight = Double.valueOf(valueInput.getDoubleOr("minimega:target_absolute_height", 0.0D));
/* 437 */       this.staticLift = Double.valueOf(valueInput.getDoubleOr("minimega:static_lift", 0.0D));
/*     */     } 
/* 439 */     this.thermalVelocity = valueInput.getDoubleOr("minimega:thermal_velocity", 0.0D);
/* 440 */     this.targetThermalVelocity = valueInput.getDoubleOr("minimega:target_thermal_velocity", 0.0D);
/*     */     
/* 442 */     this.finishedMap = valueInput.getBooleanOr("minimega:finished_glide_map", false);
/*     */ 
/*     */     
/*     */     try {
/* 446 */       Gson gson = new Gson();
/* 447 */       this.aabb = (AABB)gson.fromJson(valueInput.getString("minimega:wipaabb").orElseThrow(), AABB.class);
/* 448 */       if (this.aabb == null) {
/* 449 */         this.aabb = new AABB(-5000.0D, -5000.0D, -5000.0D, -5000.0D, -5000.0D, -5000.0D);
/*     */       }
/* 451 */     } catch (Throwable throwable) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mm$addException(BlockPos blockPos) {
/* 460 */     this.exception = blockPos;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockPos mm$getException() {
/* 465 */     return this.exception;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean mm$finishedMap() {
/* 473 */     return this.finishedMap;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mm$finishedMap(boolean b) {
/* 478 */     this.finishedMap = b;
/*     */   }
/*     */   
/*     */   @Inject(method = {"teleport"}, at = {@At("HEAD")}, cancellable = true)
/*     */   void teleport(TeleportTransition teleportTransition, CallbackInfoReturnable<Entity> cir) {
/* 483 */     if (MinigamesController.getMinigameController(level()).isActive() && "minecraft".equals(teleportTransition.newLevel().dimension().identifier().getNamespace()))
/* 484 */       cir.cancel(); 
/*     */   }
/*     */   
/*     */   @Shadow
/*     */   public abstract Vec3 getDeltaMovement();
/*     */   
/*     */   @Shadow
/*     */   public abstract void setDeltaMovement(Vec3 paramVec3);
/*     */   
/*     */   @Shadow
/*     */   public abstract Vec2 getRotationVector();
/*     */   
/*     */   @Shadow
/*     */   public abstract Vec3 getLookAngle();
/*     */   
/*     */   @Shadow
/*     */   public abstract double getY();
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean addTag(String paramString);
/*     */   
/*     */   @Shadow
/*     */   public abstract AABB getBoundingBox();
/*     */   
/*     */   @Shadow
/*     */   protected abstract AABB makeBoundingBox();
/*     */   
/*     */   @Shadow
/*     */   protected abstract AABB makeBoundingBox(Vec3 paramVec3);
/*     */   
/*     */   @Shadow
/*     */   public abstract void setNoGravity(boolean paramBoolean);
/*     */   
/*     */   @Shadow
/*     */   public abstract Level level();
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean isAlive();
/*     */   
/*     */   @Shadow
/*     */   public abstract void playerTouch(Player paramPlayer);
/*     */   
/*     */   @Shadow
/*     */   public abstract void kill(ServerLevel paramServerLevel);
/*     */   
/*     */   @Shadow
/*     */   protected abstract boolean isInvulnerableToBase(DamageSource paramDamageSource);
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\EntityMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */