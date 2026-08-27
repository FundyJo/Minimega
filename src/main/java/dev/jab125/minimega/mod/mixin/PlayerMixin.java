/*     */ package dev.jab125.minimega.mod.mixin;
/*     */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*     */ import dev.jab125.minimega.mod.extension.PlayerExtension;
/*     */ import dev.jab125.minimega.mod.networking.payload.S2CStatusPayload;
/*     */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.S2CPlayerInfoObj;
/*     */ import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*     */ import dev.jab125.minimega.mod.util.controller.glide.GlideMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.obj.MinigameRules;
/*     */ import dev.jab125.minimega.mod.util.joindata.CreateOrJoin;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import org.spongepowered.asm.mixin.Unique;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*     */ 
/*     */ @Mixin({Player.class})
/*     */ public abstract class PlayerMixin extends LivingEntity implements PlayerExtension {
/*     */   @Unique
/*     */   private int glideHealth;
/*     */   @Unique
/*     */   private S2CPlayerInfoObj s2CPlayerInfoObj;
/*     */   
/*     */   @Inject(method = {"mayUseItemAt"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void mm$canUseItemAt(BlockPos blockPos, Direction direction, ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
/*     */     Level level = level();
/*     */     MinigamesController minigameController = MinigamesController.getMinigameController(level);
/*     */     MinigameRules rules = minigameController.getRules();
/*     */     if (rules.placePermissions().mode() == MinigameRules.Mode.WHITELIST)
/*     */       cir.setReturnValue(Boolean.valueOf(false)); 
/*     */   }
/*     */   
/*     */   protected PlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) {
/*  42 */     super(entityType, level);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  60 */     this.glideHealth = 3;
/*     */   }
/*     */ 
/*     */   
/*     */   @WrapOperation(method = {"actuallyHurt"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;isInvulnerableTo(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/damagesource/DamageSource;)Z")})
/*     */   boolean mm$actuallyHurt(Player instance, ServerLevel serverLevel, DamageSource damageSource, Operation<Boolean> original) {
/*     */     GlideMinigameController controller;
/*  67 */     Boolean call = (Boolean)original.call(new Object[] { instance, serverLevel, damageSource });
/*  68 */     AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController(level()).getController(Minigame.GLIDE); if (abstractMinigameController instanceof GlideMinigameController) { controller = (GlideMinigameController)abstractMinigameController; }
/*  69 */     else { return call.booleanValue(); }
/*  70 */      if (((EntityExtension)this).mm$finishedMap()) return call.booleanValue(); 
/*  71 */     if (controller.getStage() >= 4) return call.booleanValue(); 
/*  72 */     if (controller.getStage() < 2) return call.booleanValue(); 
/*  73 */     if (!call.booleanValue() && 
/*  74 */       instance instanceof ServerPlayer) { ServerPlayer player = (ServerPlayer)instance;
/*  75 */       if (damageSource == damageSources().flyIntoWall()) {
/*  76 */         this.glideHealth--;
/*  77 */         player.connection.send(ServerNetworking.getInstance().play((CustomPacketPayload)new S2CStatusPayload(S2CStatusPayload.Status.GLIDE_HEALTH_UPDATE, this.glideHealth)));
/*  78 */         if (this.glideHealth == 0) {
/*  79 */           instance.kill(serverLevel);
/*     */         }
/*     */       }  }
/*     */ 
/*     */     
/*  84 */     return call.booleanValue(); } @Inject(method = {"blockActionRestricted"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void mm$blockActionRestricted(Level level, BlockPos blockPos, GameType gameType, CallbackInfoReturnable<Boolean> cir) { MinigamesController minigameController = MinigamesController.getMinigameController(level);
/*     */     MinigameRules rules = minigameController.getRules();
/*     */     if (rules.destroyPermissions().mode() == MinigameRules.Mode.WHITELIST)
/*     */       cir.setReturnValue(Boolean.valueOf(true));  }
/*  89 */   public int mm$getGlideHealth() { return this.glideHealth; }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mm$setGlideHealth(int health) {
/*  94 */     this.glideHealth = health;
/*     */   }
/*     */ 
/*     */   
/*     */   public S2CPlayerInfoObj mm$getMatchmakingServerInfo() {
/*  99 */     return this.s2CPlayerInfoObj;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mm$setMatchmakingServerInfo(S2CPlayerInfoObj obj) {
/* 104 */     this.s2CPlayerInfoObj = obj;
/*     */   }
/*     */ 
/*     */   
/*     */   public CreateOrJoin mm$getMinigameData() {
/* 109 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mm$setMinigameData(CreateOrJoin data) {}
/*     */ 
/*     */   
/*     */   @Unique
/* 118 */   private static final AABB defaultAABB = new AABB(-2.9999999E7D, 2.9999999E7D, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, -2.9999999E7D, 2.9999999E7D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   private AABB currentPlayerBoundsVolume;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject(method = {"tick"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Avatar;tick()V")})
/*     */   void clamp(CallbackInfo ci) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokevirtual level : ()Lnet/minecraft/world/level/Level;
/*     */     //   4: invokestatic getMinigameController : (Lnet/minecraft/world/level/Level;)Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */     //   7: astore_2
/*     */     //   8: aload_2
/*     */     //   9: invokevirtual isActive : ()Z
/*     */     //   12: ifne -> 21
/*     */     //   15: aload_0
/*     */     //   16: aconst_null
/*     */     //   17: putfield currentPlayerBoundsVolume : Lnet/minecraft/world/phys/AABB;
/*     */     //   20: return
/*     */     //   21: aload_0
/*     */     //   22: invokevirtual level : ()Lnet/minecraft/world/level/Level;
/*     */     //   25: invokestatic getGameRules : (Lnet/minecraft/world/level/Level;)Ldev/jab125/minimega/grf/newelements/mxml/grf/__ROOT__;
/*     */     //   28: invokevirtual getLevelRules : ()Ldev/jab125/minimega/grf/newelements/mxml/grf/LevelRules;
/*     */     //   31: ldc dev/jab125/minimega/grf/newelements/mxml/grf/PlayerBoundsVolume
/*     */     //   33: invokevirtual streamOf : (Ljava/lang/Class;)Ljava/util/stream/Stream;
/*     */     //   36: <illegal opcode> apply : ()Ljava/util/function/Function;
/*     */     //   41: invokeinterface map : (Ljava/util/function/Function;)Ljava/util/stream/Stream;
/*     */     //   46: invokeinterface toList : ()Ljava/util/List;
/*     */     //   51: astore_3
/*     */     //   52: aload_0
/*     */     //   53: getfield currentPlayerBoundsVolume : Lnet/minecraft/world/phys/AABB;
/*     */     //   56: ifnull -> 77
/*     */     //   59: aload_3
/*     */     //   60: aload_0
/*     */     //   61: getfield currentPlayerBoundsVolume : Lnet/minecraft/world/phys/AABB;
/*     */     //   64: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */     //   69: ifne -> 77
/*     */     //   72: aload_0
/*     */     //   73: aconst_null
/*     */     //   74: putfield currentPlayerBoundsVolume : Lnet/minecraft/world/phys/AABB;
/*     */     //   77: aload_0
/*     */     //   78: getfield currentPlayerBoundsVolume : Lnet/minecraft/world/phys/AABB;
/*     */     //   81: dup
/*     */     //   82: astore #4
/*     */     //   84: ifnull -> 249
/*     */     //   87: aload_0
/*     */     //   88: invokevirtual getX : ()D
/*     */     //   91: aload #4
/*     */     //   93: getfield minX : D
/*     */     //   96: aload #4
/*     */     //   98: getfield maxX : D
/*     */     //   101: invokestatic clamp : (DDD)D
/*     */     //   104: dstore #5
/*     */     //   106: aload_0
/*     */     //   107: invokevirtual getY : ()D
/*     */     //   110: aload #4
/*     */     //   112: getfield minY : D
/*     */     //   115: aload #4
/*     */     //   117: getfield maxY : D
/*     */     //   120: invokestatic clamp : (DDD)D
/*     */     //   123: dstore #7
/*     */     //   125: aload_0
/*     */     //   126: invokevirtual getZ : ()D
/*     */     //   129: aload #4
/*     */     //   131: getfield minZ : D
/*     */     //   134: aload #4
/*     */     //   136: getfield maxZ : D
/*     */     //   139: invokestatic clamp : (DDD)D
/*     */     //   142: dstore #9
/*     */     //   144: dload #5
/*     */     //   146: aload_0
/*     */     //   147: invokevirtual getX : ()D
/*     */     //   150: dcmpl
/*     */     //   151: ifne -> 174
/*     */     //   154: dload #7
/*     */     //   156: aload_0
/*     */     //   157: invokevirtual getY : ()D
/*     */     //   160: dcmpl
/*     */     //   161: ifne -> 174
/*     */     //   164: dload #9
/*     */     //   166: aload_0
/*     */     //   167: invokevirtual getZ : ()D
/*     */     //   170: dcmpl
/*     */     //   171: ifeq -> 246
/*     */     //   174: aload_3
/*     */     //   175: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   180: astore #11
/*     */     //   182: aload #11
/*     */     //   184: invokeinterface hasNext : ()Z
/*     */     //   189: ifeq -> 236
/*     */     //   192: aload #11
/*     */     //   194: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   199: checkcast net/minecraft/world/phys/AABB
/*     */     //   202: astore #12
/*     */     //   204: aload #12
/*     */     //   206: aload_0
/*     */     //   207: invokevirtual getX : ()D
/*     */     //   210: aload_0
/*     */     //   211: invokevirtual getY : ()D
/*     */     //   214: aload_0
/*     */     //   215: invokevirtual getZ : ()D
/*     */     //   218: invokevirtual contains : (DDD)Z
/*     */     //   221: ifeq -> 233
/*     */     //   224: aload_0
/*     */     //   225: aload #12
/*     */     //   227: putfield currentPlayerBoundsVolume : Lnet/minecraft/world/phys/AABB;
/*     */     //   230: goto -> 246
/*     */     //   233: goto -> 182
/*     */     //   236: aload_0
/*     */     //   237: dload #5
/*     */     //   239: dload #7
/*     */     //   241: dload #9
/*     */     //   243: invokevirtual setPos : (DDD)V
/*     */     //   246: goto -> 303
/*     */     //   249: aload_3
/*     */     //   250: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   255: astore #5
/*     */     //   257: aload #5
/*     */     //   259: invokeinterface hasNext : ()Z
/*     */     //   264: ifeq -> 303
/*     */     //   267: aload #5
/*     */     //   269: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   274: checkcast net/minecraft/world/phys/AABB
/*     */     //   277: astore #6
/*     */     //   279: aload #6
/*     */     //   281: aload_0
/*     */     //   282: invokevirtual position : ()Lnet/minecraft/world/phys/Vec3;
/*     */     //   285: invokevirtual contains : (Lnet/minecraft/world/phys/Vec3;)Z
/*     */     //   288: ifeq -> 300
/*     */     //   291: aload_0
/*     */     //   292: aload #6
/*     */     //   294: putfield currentPlayerBoundsVolume : Lnet/minecraft/world/phys/AABB;
/*     */     //   297: goto -> 303
/*     */     //   300: goto -> 257
/*     */     //   303: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #122	-> 0
/*     */     //   #123	-> 8
/*     */     //   #124	-> 21
/*     */     //   #126	-> 52
/*     */     //   #128	-> 77
/*     */     //   #129	-> 87
/*     */     //   #130	-> 106
/*     */     //   #131	-> 125
/*     */     //   #132	-> 144
/*     */     //   #135	-> 174
/*     */     //   #137	-> 204
/*     */     //   #138	-> 224
/*     */     //   #139	-> 230
/*     */     //   #141	-> 233
/*     */     //   #142	-> 236
/*     */     //   #145	-> 246
/*     */     //   #146	-> 249
/*     */     //   #147	-> 279
/*     */     //   #148	-> 291
/*     */     //   #149	-> 297
/*     */     //   #151	-> 300
/*     */     //   #153	-> 303
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   204	29	12	volume	Lnet/minecraft/world/phys/AABB;
/*     */     //   106	140	5	d	D
/*     */     //   125	121	7	e	D
/*     */     //   144	102	9	f	D
/*     */     //   279	21	6	aabb	Lnet/minecraft/world/phys/AABB;
/*     */     //   0	304	0	this	Ldev/jab125/minimega/mod/mixin/PlayerMixin;
/*     */     //   0	304	1	ci	Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfo;
/*     */     //   8	296	2	minigameController	Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */     //   52	252	3	volumes	Ljava/util/List;
/*     */     //   84	220	4	vol	Lnet/minecraft/world/phys/AABB;
/*     */     // Local variable type table:
/*     */     //   start	length	slot	name	signature
/*     */     //   52	252	3	volumes	Ljava/util/List<Lnet/minecraft/world/phys/AABB;>;
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
/*     */   public AABB mm$getCurrentPlayerBoundsVolume() {
/* 158 */     return this.currentPlayerBoundsVolume;
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\PlayerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */