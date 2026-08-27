/*    */ package dev.jab125.minimega.mod.client.mixin.spectator;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import dev.jab125.minimega.mod.util.minigamedata.battle.SpectatorMode;
/*    */ import net.minecraft.client.renderer.SubmitNodeCollector;
/*    */ import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
/*    */ import net.minecraft.client.renderer.state.level.CameraRenderState;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ 
/*    */ @Mixin({EntityRenderDispatcher.class})
/*    */ public class EntityRenderDispatcherMixin {
/*    */   @WrapMethod(method = {"submit"})
/*    */   private <S extends net.minecraft.client.renderer.entity.state.EntityRenderState> void submit(S renderState, CameraRenderState camera, double x, double y, double z, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, Operation<Void> original) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: instanceof net/minecraft/client/renderer/entity/state/AvatarRenderState
/*    */     //   4: ifeq -> 445
/*    */     //   7: aload_1
/*    */     //   8: checkcast net/minecraft/client/renderer/entity/state/AvatarRenderState
/*    */     //   11: astore #12
/*    */     //   13: aload #12
/*    */     //   15: getfield isSpectator : Z
/*    */     //   18: ifeq -> 445
/*    */     //   21: invokestatic getController : ()Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*    */     //   24: invokevirtual getMinigameData : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;
/*    */     //   27: invokevirtual config : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;
/*    */     //   30: astore #15
/*    */     //   32: aload #15
/*    */     //   34: instanceof dev/jab125/minimega/mod/util/minigamedata/BattleConfig
/*    */     //   37: ifeq -> 445
/*    */     //   40: aload #15
/*    */     //   42: checkcast dev/jab125/minimega/mod/util/minigamedata/BattleConfig
/*    */     //   45: astore #13
/*    */     //   47: aload #13
/*    */     //   49: invokevirtual settings : ()Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*    */     //   52: astore #16
/*    */     //   54: aload #16
/*    */     //   56: astore #14
/*    */     //   58: getstatic dev/jab125/minimega/mod/client/mixin/spectator/EntityRenderDispatcherMixin$1.$SwitchMap$dev$jab125$minimega$mod$util$minigamedata$battle$SpectatorMode : [I
/*    */     //   61: aload #14
/*    */     //   63: invokeinterface spectatorMode : ()Ldev/jab125/minimega/mod/util/minigamedata/battle/SpectatorMode;
/*    */     //   68: invokevirtual ordinal : ()I
/*    */     //   71: iaload
/*    */     //   72: tableswitch default -> 445, 1 -> 116, 2 -> 116, 3 -> 116, 4 -> 116, 5 -> 116, 6 -> 445, 7 -> 445
/*    */     //   116: getstatic dev/jab125/minimega/mod/client/mixin/spectator/EntityRenderDispatcherMixin$1.$SwitchMap$dev$jab125$minimega$mod$util$minigamedata$battle$SpectatorMode : [I
/*    */     //   119: aload #14
/*    */     //   121: invokeinterface spectatorMode : ()Ldev/jab125/minimega/mod/util/minigamedata/battle/SpectatorMode;
/*    */     //   126: invokevirtual ordinal : ()I
/*    */     //   129: iaload
/*    */     //   130: tableswitch default -> 341, 1 -> 164, 2 -> 186, 3 -> 225, 4 -> 247, 5 -> 269
/*    */     //   164: new net/minecraft/client/renderer/entity/state/AllayRenderState
/*    */     //   167: dup
/*    */     //   168: invokespecial <init> : ()V
/*    */     //   171: astore #16
/*    */     //   173: aload #16
/*    */     //   175: getstatic net/minecraft/world/entity/EntityType.ALLAY : Lnet/minecraft/world/entity/EntityType;
/*    */     //   178: putfield entityType : Lnet/minecraft/world/entity/EntityType;
/*    */     //   181: aload #16
/*    */     //   183: goto -> 349
/*    */     //   186: new net/minecraft/client/renderer/entity/state/BatRenderState
/*    */     //   189: dup
/*    */     //   190: invokespecial <init> : ()V
/*    */     //   193: astore #16
/*    */     //   195: aload #16
/*    */     //   197: getstatic net/minecraft/world/entity/EntityType.BAT : Lnet/minecraft/world/entity/EntityType;
/*    */     //   200: putfield entityType : Lnet/minecraft/world/entity/EntityType;
/*    */     //   203: aload #16
/*    */     //   205: getfield restAnimationState : Lnet/minecraft/world/entity/AnimationState;
/*    */     //   208: invokevirtual stop : ()V
/*    */     //   211: aload #16
/*    */     //   213: getfield flyAnimationState : Lnet/minecraft/world/entity/AnimationState;
/*    */     //   216: iconst_0
/*    */     //   217: invokevirtual startIfStopped : (I)V
/*    */     //   220: aload #16
/*    */     //   222: goto -> 349
/*    */     //   225: new net/minecraft/client/renderer/entity/state/BeeRenderState
/*    */     //   228: dup
/*    */     //   229: invokespecial <init> : ()V
/*    */     //   232: astore #16
/*    */     //   234: aload #16
/*    */     //   236: getstatic net/minecraft/world/entity/EntityType.BEE : Lnet/minecraft/world/entity/EntityType;
/*    */     //   239: putfield entityType : Lnet/minecraft/world/entity/EntityType;
/*    */     //   242: aload #16
/*    */     //   244: goto -> 349
/*    */     //   247: new net/minecraft/client/renderer/entity/state/VexRenderState
/*    */     //   250: dup
/*    */     //   251: invokespecial <init> : ()V
/*    */     //   254: astore #16
/*    */     //   256: aload #16
/*    */     //   258: getstatic net/minecraft/world/entity/EntityType.VEX : Lnet/minecraft/world/entity/EntityType;
/*    */     //   261: putfield entityType : Lnet/minecraft/world/entity/EntityType;
/*    */     //   264: aload #16
/*    */     //   266: goto -> 349
/*    */     //   269: new net/minecraft/client/renderer/entity/state/ParrotRenderState
/*    */     //   272: dup
/*    */     //   273: invokespecial <init> : ()V
/*    */     //   276: astore #16
/*    */     //   278: aload #16
/*    */     //   280: getstatic net/minecraft/world/entity/EntityType.PARROT : Lnet/minecraft/world/entity/EntityType;
/*    */     //   283: putfield entityType : Lnet/minecraft/world/entity/EntityType;
/*    */     //   286: fconst_2
/*    */     //   287: aload #12
/*    */     //   289: getfield ageInTicks : F
/*    */     //   292: fmul
/*    */     //   293: fstore #17
/*    */     //   295: fconst_1
/*    */     //   296: fstore #18
/*    */     //   298: aload #16
/*    */     //   300: fload #17
/*    */     //   302: f2d
/*    */     //   303: invokestatic sin : (D)F
/*    */     //   306: fconst_1
/*    */     //   307: fadd
/*    */     //   308: fload #18
/*    */     //   310: fmul
/*    */     //   311: putfield flapAngle : F
/*    */     //   314: invokestatic values : ()[Lnet/minecraft/world/entity/animal/parrot/Parrot$Variant;
/*    */     //   317: astore #19
/*    */     //   319: aload #16
/*    */     //   321: aload #19
/*    */     //   323: aload #12
/*    */     //   325: getfield id : I
/*    */     //   328: aload #19
/*    */     //   330: arraylength
/*    */     //   331: irem
/*    */     //   332: aaload
/*    */     //   333: putfield variant : Lnet/minecraft/world/entity/animal/parrot/Parrot$Variant;
/*    */     //   336: aload #16
/*    */     //   338: goto -> 349
/*    */     //   341: new java/lang/IllegalStateException
/*    */     //   344: dup
/*    */     //   345: invokespecial <init> : ()V
/*    */     //   348: athrow
/*    */     //   349: astore #15
/*    */     //   351: aload #15
/*    */     //   353: aload #12
/*    */     //   355: getfield x : D
/*    */     //   358: putfield x : D
/*    */     //   361: aload #15
/*    */     //   363: aload #12
/*    */     //   365: getfield y : D
/*    */     //   368: dconst_1
/*    */     //   369: dadd
/*    */     //   370: putfield y : D
/*    */     //   373: aload #15
/*    */     //   375: aload #12
/*    */     //   377: getfield z : D
/*    */     //   380: putfield z : D
/*    */     //   383: aload #15
/*    */     //   385: aload #12
/*    */     //   387: getfield bodyRot : F
/*    */     //   390: putfield bodyRot : F
/*    */     //   393: aload #15
/*    */     //   395: aload #12
/*    */     //   397: getfield xRot : F
/*    */     //   400: putfield xRot : F
/*    */     //   403: aload #15
/*    */     //   405: aload #12
/*    */     //   407: getfield yRot : F
/*    */     //   410: putfield yRot : F
/*    */     //   413: aload #15
/*    */     //   415: aload #12
/*    */     //   417: getfield ageInTicks : F
/*    */     //   420: putfield ageInTicks : F
/*    */     //   423: aload #15
/*    */     //   425: aload #12
/*    */     //   427: getfield lightCoords : I
/*    */     //   430: putfield lightCoords : I
/*    */     //   433: dload #5
/*    */     //   435: dconst_1
/*    */     //   436: dadd
/*    */     //   437: dstore #5
/*    */     //   439: aload #15
/*    */     //   441: astore_1
/*    */     //   442: goto -> 445
/*    */     //   445: aload #11
/*    */     //   447: bipush #7
/*    */     //   449: anewarray java/lang/Object
/*    */     //   452: dup
/*    */     //   453: iconst_0
/*    */     //   454: aload_1
/*    */     //   455: aastore
/*    */     //   456: dup
/*    */     //   457: iconst_1
/*    */     //   458: aload_2
/*    */     //   459: aastore
/*    */     //   460: dup
/*    */     //   461: iconst_2
/*    */     //   462: dload_3
/*    */     //   463: invokestatic valueOf : (D)Ljava/lang/Double;
/*    */     //   466: aastore
/*    */     //   467: dup
/*    */     //   468: iconst_3
/*    */     //   469: dload #5
/*    */     //   471: invokestatic valueOf : (D)Ljava/lang/Double;
/*    */     //   474: aastore
/*    */     //   475: dup
/*    */     //   476: iconst_4
/*    */     //   477: dload #7
/*    */     //   479: invokestatic valueOf : (D)Ljava/lang/Double;
/*    */     //   482: aastore
/*    */     //   483: dup
/*    */     //   484: iconst_5
/*    */     //   485: aload #9
/*    */     //   487: aastore
/*    */     //   488: dup
/*    */     //   489: bipush #6
/*    */     //   491: aload #10
/*    */     //   493: aastore
/*    */     //   494: invokeinterface call : ([Ljava/lang/Object;)Ljava/lang/Object;
/*    */     //   499: pop
/*    */     //   500: goto -> 520
/*    */     //   503: astore #12
/*    */     //   505: new java/lang/MatchException
/*    */     //   508: dup
/*    */     //   509: aload #12
/*    */     //   511: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   514: aload #12
/*    */     //   516: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*    */     //   519: athrow
/*    */     //   520: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #38	-> 0
/*    */     //   #39	-> 13
/*    */     //   #40	-> 21
/*    */     //   #41	-> 58
/*    */     //   #43	-> 116
/*    */     //   #45	-> 164
/*    */     //   #46	-> 173
/*    */     //   #47	-> 181
/*    */     //   #50	-> 186
/*    */     //   #51	-> 195
/*    */     //   #52	-> 203
/*    */     //   #53	-> 211
/*    */     //   #54	-> 220
/*    */     //   #57	-> 225
/*    */     //   #58	-> 234
/*    */     //   #59	-> 242
/*    */     //   #62	-> 247
/*    */     //   #63	-> 256
/*    */     //   #64	-> 264
/*    */     //   #67	-> 269
/*    */     //   #68	-> 278
/*    */     //   #72	-> 286
/*    */     //   #73	-> 295
/*    */     //   #74	-> 298
/*    */     //   #75	-> 314
/*    */     //   #76	-> 319
/*    */     //   #77	-> 336
/*    */     //   #79	-> 341
/*    */     //   #43	-> 349
/*    */     //   #81	-> 351
/*    */     //   #82	-> 361
/*    */     //   #83	-> 373
/*    */     //   #84	-> 383
/*    */     //   #85	-> 393
/*    */     //   #86	-> 403
/*    */     //   #87	-> 413
/*    */     //   #88	-> 423
/*    */     //   #89	-> 433
/*    */     //   #90	-> 439
/*    */     //   #91	-> 442
/*    */     //   #99	-> 445
/*    */     //   #38	-> 503
/*    */     //   #100	-> 520
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   173	13	16	allayRenderState	Lnet/minecraft/client/renderer/entity/state/AllayRenderState;
/*    */     //   195	30	16	batRenderState	Lnet/minecraft/client/renderer/entity/state/BatRenderState;
/*    */     //   234	13	16	beeRenderState	Lnet/minecraft/client/renderer/entity/state/BeeRenderState;
/*    */     //   256	13	16	vexRenderState	Lnet/minecraft/client/renderer/entity/state/VexRenderState;
/*    */     //   278	63	16	parrotRenderState	Lnet/minecraft/client/renderer/entity/state/ParrotRenderState;
/*    */     //   295	46	17	flap	F
/*    */     //   298	43	18	flapSpeed	F
/*    */     //   319	22	19	values	[Lnet/minecraft/world/entity/animal/parrot/Parrot$Variant;
/*    */     //   351	91	15	livingEntityRenderState	Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;
/*    */     //   58	387	14	settings	Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*    */     //   13	432	12	state	Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;
/*    */     //   0	521	0	this	Ldev/jab125/minimega/mod/client/mixin/spectator/EntityRenderDispatcherMixin;
/*    */     //   0	521	1	renderState	Lnet/minecraft/client/renderer/entity/state/EntityRenderState;
/*    */     //   0	521	2	camera	Lnet/minecraft/client/renderer/state/level/CameraRenderState;
/*    */     //   0	521	3	x	D
/*    */     //   0	521	5	y	D
/*    */     //   0	521	7	z	D
/*    */     //   0	521	9	poseStack	Lcom/mojang/blaze3d/vertex/PoseStack;
/*    */     //   0	521	10	submitNodeCollector	Lnet/minecraft/client/renderer/SubmitNodeCollector;
/*    */     //   0	521	11	original	Lcom/llamalad7/mixinextras/injector/wrapoperation/Operation;
/*    */     // Local variable type table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	521	1	renderState	TS;
/*    */     //   0	521	11	original	Lcom/llamalad7/mixinextras/injector/wrapoperation/Operation<Ljava/lang/Void;>;
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   49	52	503	java/lang/Throwable
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\spectator\EntityRenderDispatcherMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */