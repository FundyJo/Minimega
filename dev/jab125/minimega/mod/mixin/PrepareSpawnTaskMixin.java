/*     */ package dev.jab125.minimega.mod.mixin;
/*     */ 
/*     */ import com.llamalad7.mixinextras.expression.Definition;
/*     */ import com.llamalad7.mixinextras.expression.Expression;
/*     */ import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
/*     */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*     */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*     */ import com.llamalad7.mixinextras.sugar.Local;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.UpdatePlayer;
/*     */ import dev.jab125.minimega.mod.Minimega;
/*     */ import dev.jab125.minimega.mod.abstractions.modloader.Environment;
/*     */ import dev.jab125.minimega.mod.abstractions.modloader.ModLoader;
/*     */ import dev.jab125.minimega.mod.extension.MinecraftServerExtension;
/*     */ import dev.jab125.minimega.mod.extension.PrepareSpawnTaskExtension;
/*     */ import dev.jab125.minimega.mod.party.MinigameParty;
/*     */ import dev.jab125.minimega.mod.util.Minigame;
/*     */ import dev.jab125.minimega.mod.util.UnableToJoinWorldException;
/*     */ import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*     */ import dev.jab125.minimega.mod.util.joindata.CreateOrJoin;
/*     */ import dev.jab125.minimega.mod.util.minigamedata.MinigameData;
/*     */ import dev.jab125.minimega.mod.util.minigamedata.MinigameSpecificConfig;
/*     */ import dev.jab125.minimega.mod.util.minigamedata.NoConfig;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.concurrent.CompletableFuture;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.Connection;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.server.network.CommonListenerCookie;
/*     */ import net.minecraft.server.network.config.PrepareSpawnTask;
/*     */ import net.minecraft.server.players.NameAndId;
/*     */ import net.minecraft.server.players.PlayerList;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.Vec2;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import org.spongepowered.asm.mixin.Final;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.Unique;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mixin({PrepareSpawnTask.class})
/*     */ public abstract class PrepareSpawnTaskMixin
/*     */   implements PrepareSpawnTaskExtension
/*     */ {
/*     */   @Shadow
/*     */   @Final
/*     */   MinecraftServer server;
/*     */   @Shadow
/*     */   @Final
/*     */   NameAndId nameAndId;
/*     */   @Unique
/*     */   private MinigameParty.PlayerSlot playerSlot;
/*     */   @Unique
/*     */   private MinigameParty party;
/*     */   @Unique
/*     */   private CreateOrJoin data;
/*     */   
/*     */   public MinigameParty.PlayerSlot mm$playerSlot() {
/*  69 */     return this.playerSlot;
/*     */   }
/*     */   
/*     */   @WrapOperation(method = {"start"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/server/players/PlayerList;loadPlayerData(Lnet/minecraft/server/players/NameAndId;)Ljava/util/Optional;")})
/*     */   Optional<CompoundTag> r(PlayerList instance, NameAndId nameAndId, Operation<Optional<CompoundTag>> original) {
/*  74 */     if (Minimega.isMinigameServer(this.server)) return Optional.empty(); 
/*  75 */     return (Optional<CompoundTag>)original.call(new Object[] { instance, nameAndId });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MinigameParty mm$getParty() {
/*  83 */     return this.party;
/*     */   }
/*     */ 
/*     */   
/*     */   @ModifyExpressionValue(method = {"start"}, at = {@At("MIXINEXTRAS:EXPRESSION")})
/*     */   @Definition(id = "loadedData", local = {@Local(type = Optional.class, name = {"loadedData"})})
/*     */   @Expression({"loadedData = @(?)"})
/*     */   <U> Optional<U> optionalEquals(Optional<U> original) {
/*  91 */     if (!Minimega.isMinigameServer(this.server)) return original; 
/*  92 */     return Optional.empty();
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
/*     */   @ModifyExpressionValue(method = {"start"}, at = {@At("MIXINEXTRAS:EXPRESSION")})
/*     */   @Definition(id = "serverLevel", local = {@Local(type = ServerLevel.class)})
/*     */   @Expression({"serverLevel = @(?)"})
/*     */   ServerLevel sjflA(ServerLevel original) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield server : Lnet/minecraft/server/MinecraftServer;
/*     */     //   4: invokestatic isMinigameServer : (Lnet/minecraft/server/MinecraftServer;)Z
/*     */     //   7: ifne -> 12
/*     */     //   10: aload_1
/*     */     //   11: areturn
/*     */     //   12: aload_0
/*     */     //   13: getfield server : Lnet/minecraft/server/MinecraftServer;
/*     */     //   16: new com/mojang/authlib/GameProfile
/*     */     //   19: dup
/*     */     //   20: aload_0
/*     */     //   21: getfield nameAndId : Lnet/minecraft/server/players/NameAndId;
/*     */     //   24: invokevirtual id : ()Ljava/util/UUID;
/*     */     //   27: aload_0
/*     */     //   28: getfield nameAndId : Lnet/minecraft/server/players/NameAndId;
/*     */     //   31: invokevirtual name : ()Ljava/lang/String;
/*     */     //   34: invokespecial <init> : (Ljava/util/UUID;Ljava/lang/String;)V
/*     */     //   37: invokestatic shouldAcceptChoices : (Lnet/minecraft/server/MinecraftServer;Lcom/mojang/authlib/GameProfile;)Z
/*     */     //   40: ifeq -> 445
/*     */     //   43: aload_0
/*     */     //   44: invokevirtual mm$getMinigameData : ()Ldev/jab125/minimega/mod/util/joindata/CreateOrJoin;
/*     */     //   47: dup
/*     */     //   48: astore_2
/*     */     //   49: instanceof dev/jab125/minimega/mod/util/joindata/Whatever
/*     */     //   52: ifne -> 445
/*     */     //   55: aload_2
/*     */     //   56: astore_3
/*     */     //   57: iconst_0
/*     */     //   58: istore #4
/*     */     //   60: aload_3
/*     */     //   61: iload #4
/*     */     //   63: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/mod/util/joindata/CreateOrJoin;I)I
/*     */     //   68: tableswitch default -> 381, -1 -> 381, 0 -> 100, 1 -> 285, 2 -> 295
/*     */     //   100: aload_3
/*     */     //   101: checkcast dev/jab125/minimega/mod/util/joindata/CreateParty
/*     */     //   104: astore #5
/*     */     //   106: aload #5
/*     */     //   108: invokevirtual data : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;
/*     */     //   111: astore #7
/*     */     //   113: aload #7
/*     */     //   115: astore #6
/*     */     //   117: invokestatic getInstance : ()Ldev/jab125/minimega/mod/abstractions/modloader/ModLoader;
/*     */     //   120: invokeinterface isDevelopmentEnvironment : ()Z
/*     */     //   125: ifeq -> 139
/*     */     //   128: aload #6
/*     */     //   130: invokevirtual online : ()Z
/*     */     //   133: ifeq -> 239
/*     */     //   136: goto -> 192
/*     */     //   139: aload #6
/*     */     //   141: invokevirtual config : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;
/*     */     //   144: astore #9
/*     */     //   146: aload #9
/*     */     //   148: instanceof dev/jab125/minimega/mod/util/minigamedata/GlideConfig
/*     */     //   151: ifeq -> 192
/*     */     //   154: aload #9
/*     */     //   156: checkcast dev/jab125/minimega/mod/util/minigamedata/GlideConfig
/*     */     //   159: astore #7
/*     */     //   161: aload #7
/*     */     //   163: invokevirtual type : ()Ldev/jab125/minimega/mod/util/controller/glide/GlideGameType;
/*     */     //   166: astore #10
/*     */     //   168: aload #7
/*     */     //   170: invokevirtual solo : ()Z
/*     */     //   173: istore #10
/*     */     //   175: iload #10
/*     */     //   177: istore #11
/*     */     //   179: iconst_1
/*     */     //   180: ifeq -> 192
/*     */     //   183: iload #10
/*     */     //   185: istore #8
/*     */     //   187: iload #8
/*     */     //   189: ifne -> 239
/*     */     //   192: getstatic dev/jab125/minimega/mod/Minimega.isSingleplayerOwner : Ljava/util/function/BiFunction;
/*     */     //   195: aload_0
/*     */     //   196: getfield server : Lnet/minecraft/server/MinecraftServer;
/*     */     //   199: aload_0
/*     */     //   200: getfield nameAndId : Lnet/minecraft/server/players/NameAndId;
/*     */     //   203: invokeinterface apply : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   208: checkcast java/lang/Boolean
/*     */     //   211: invokevirtual booleanValue : ()Z
/*     */     //   214: ifeq -> 239
/*     */     //   217: aload #6
/*     */     //   219: invokevirtual online : ()Z
/*     */     //   222: invokestatic scheduleWWW : (Z)V
/*     */     //   225: aload_0
/*     */     //   226: getfield server : Lnet/minecraft/server/MinecraftServer;
/*     */     //   229: checkcast dev/jab125/minimega/mod/extension/MinecraftServerExtension
/*     */     //   232: aload #6
/*     */     //   234: invokeinterface mm$setData : (Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;)V
/*     */     //   239: aload_0
/*     */     //   240: getfield server : Lnet/minecraft/server/MinecraftServer;
/*     */     //   243: checkcast dev/jab125/minimega/mod/extension/MinecraftServerExtension
/*     */     //   246: aload #6
/*     */     //   248: invokeinterface createMinigamePartyBasedInLobby : (Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;)Ldev/jab125/minimega/mod/party/MinigameParty;
/*     */     //   253: astore #7
/*     */     //   255: aload_0
/*     */     //   256: aload #7
/*     */     //   258: aload_0
/*     */     //   259: getfield nameAndId : Lnet/minecraft/server/players/NameAndId;
/*     */     //   262: invokevirtual id : ()Ljava/util/UUID;
/*     */     //   265: invokevirtual addConnectingPlayerViaUUID : (Ljava/util/UUID;)Ldev/jab125/minimega/mod/party/MinigameParty$PlayerSlot;
/*     */     //   268: putfield playerSlot : Ldev/jab125/minimega/mod/party/MinigameParty$PlayerSlot;
/*     */     //   271: aload_0
/*     */     //   272: aload #7
/*     */     //   274: putfield party : Ldev/jab125/minimega/mod/party/MinigameParty;
/*     */     //   277: aload #7
/*     */     //   279: invokevirtual getPartyLevel : ()Lnet/minecraft/server/level/ServerLevel;
/*     */     //   282: goto -> 444
/*     */     //   285: new dev/jab125/minimega/mod/util/UnableToJoinWorldException
/*     */     //   288: dup
/*     */     //   289: ldc 'what!? that's impossible! send a bug report'
/*     */     //   291: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   294: athrow
/*     */     //   295: aload_3
/*     */     //   296: checkcast dev/jab125/minimega/mod/util/joindata/JoinParty
/*     */     //   299: astore #7
/*     */     //   301: aload #7
/*     */     //   303: invokevirtual minigame : ()Ldev/jab125/minimega/mod/util/Minigame;
/*     */     //   306: astore #9
/*     */     //   308: aload #9
/*     */     //   310: astore #8
/*     */     //   312: invokestatic getDiscordHandler : ()Ldev/jab125/minimega/mod/IDiscordHandler;
/*     */     //   315: getstatic dev/jab125/minimega/mod/IDiscordHandler.BLUE : Ljava/awt/Color;
/*     */     //   318: aload_0
/*     */     //   319: getfield nameAndId : Lnet/minecraft/server/players/NameAndId;
/*     */     //   322: invokevirtual name : ()Ljava/lang/String;
/*     */     //   325: aload #8
/*     */     //   327: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   330: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   335: invokestatic literal : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*     */     //   338: invokeinterface relaySystemMessageToDiscord : (Ljava/awt/Color;Lnet/minecraft/network/chat/Component;)V
/*     */     //   343: aload_0
/*     */     //   344: aload #8
/*     */     //   346: invokevirtual searchForLobbyWithMinigame : (Ldev/jab125/minimega/mod/util/Minigame;)Ldev/jab125/minimega/mod/party/MinigameParty;
/*     */     //   349: astore #9
/*     */     //   351: aload_0
/*     */     //   352: aload #9
/*     */     //   354: aload_0
/*     */     //   355: getfield nameAndId : Lnet/minecraft/server/players/NameAndId;
/*     */     //   358: invokevirtual id : ()Ljava/util/UUID;
/*     */     //   361: invokevirtual addConnectingPlayerViaUUID : (Ljava/util/UUID;)Ldev/jab125/minimega/mod/party/MinigameParty$PlayerSlot;
/*     */     //   364: putfield playerSlot : Ldev/jab125/minimega/mod/party/MinigameParty$PlayerSlot;
/*     */     //   367: aload_0
/*     */     //   368: aload #9
/*     */     //   370: putfield party : Ldev/jab125/minimega/mod/party/MinigameParty;
/*     */     //   373: aload #9
/*     */     //   375: invokevirtual getPartyLevel : ()Lnet/minecraft/server/level/ServerLevel;
/*     */     //   378: goto -> 444
/*     */     //   381: invokestatic getDiscordHandler : ()Ldev/jab125/minimega/mod/IDiscordHandler;
/*     */     //   384: getstatic dev/jab125/minimega/mod/IDiscordHandler.BLUE : Ljava/awt/Color;
/*     */     //   387: aload_0
/*     */     //   388: getfield nameAndId : Lnet/minecraft/server/players/NameAndId;
/*     */     //   391: invokevirtual name : ()Ljava/lang/String;
/*     */     //   394: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   399: invokestatic literal : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*     */     //   402: invokeinterface relaySystemMessageToDiscord : (Ljava/awt/Color;Lnet/minecraft/network/chat/Component;)V
/*     */     //   407: aload_0
/*     */     //   408: aconst_null
/*     */     //   409: invokevirtual searchForLobbyWithMinigame : (Ldev/jab125/minimega/mod/util/Minigame;)Ldev/jab125/minimega/mod/party/MinigameParty;
/*     */     //   412: astore #9
/*     */     //   414: aload_0
/*     */     //   415: aload #9
/*     */     //   417: aload_0
/*     */     //   418: getfield nameAndId : Lnet/minecraft/server/players/NameAndId;
/*     */     //   421: invokevirtual id : ()Ljava/util/UUID;
/*     */     //   424: invokevirtual addConnectingPlayerViaUUID : (Ljava/util/UUID;)Ldev/jab125/minimega/mod/party/MinigameParty$PlayerSlot;
/*     */     //   427: putfield playerSlot : Ldev/jab125/minimega/mod/party/MinigameParty$PlayerSlot;
/*     */     //   430: aload_0
/*     */     //   431: aload #9
/*     */     //   433: putfield party : Ldev/jab125/minimega/mod/party/MinigameParty;
/*     */     //   436: aload #9
/*     */     //   438: invokevirtual getPartyLevel : ()Lnet/minecraft/server/level/ServerLevel;
/*     */     //   441: goto -> 444
/*     */     //   444: areturn
/*     */     //   445: aload_0
/*     */     //   446: aconst_null
/*     */     //   447: invokevirtual searchForLobbyWithMinigame : (Ldev/jab125/minimega/mod/util/Minigame;)Ldev/jab125/minimega/mod/party/MinigameParty;
/*     */     //   450: astore_3
/*     */     //   451: aload_0
/*     */     //   452: aload_3
/*     */     //   453: aload_0
/*     */     //   454: getfield nameAndId : Lnet/minecraft/server/players/NameAndId;
/*     */     //   457: invokevirtual id : ()Ljava/util/UUID;
/*     */     //   460: invokevirtual addConnectingPlayerViaUUID : (Ljava/util/UUID;)Ldev/jab125/minimega/mod/party/MinigameParty$PlayerSlot;
/*     */     //   463: putfield playerSlot : Ldev/jab125/minimega/mod/party/MinigameParty$PlayerSlot;
/*     */     //   466: aload_0
/*     */     //   467: aload_3
/*     */     //   468: putfield party : Ldev/jab125/minimega/mod/party/MinigameParty;
/*     */     //   471: aload_3
/*     */     //   472: invokevirtual getPartyLevel : ()Lnet/minecraft/server/level/ServerLevel;
/*     */     //   475: areturn
/*     */     //   476: astore #4
/*     */     //   478: new java/lang/MatchException
/*     */     //   481: dup
/*     */     //   482: aload #4
/*     */     //   484: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   487: aload #4
/*     */     //   489: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   492: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #99	-> 0
/*     */     //   #101	-> 12
/*     */     //   #102	-> 55
/*     */     //   #103	-> 100
/*     */     //   #104	-> 117
/*     */     //   #105	-> 192
/*     */     //   #106	-> 217
/*     */     //   #107	-> 225
/*     */     //   #110	-> 239
/*     */     //   #111	-> 255
/*     */     //   #112	-> 271
/*     */     //   #113	-> 277
/*     */     //   #115	-> 285
/*     */     //   #116	-> 295
/*     */     //   #117	-> 312
/*     */     //   #118	-> 343
/*     */     //   #119	-> 351
/*     */     //   #120	-> 367
/*     */     //   #121	-> 373
/*     */     //   #124	-> 381
/*     */     //   #125	-> 407
/*     */     //   #126	-> 414
/*     */     //   #127	-> 430
/*     */     //   #128	-> 436
/*     */     //   #102	-> 444
/*     */     //   #132	-> 445
/*     */     //   #133	-> 451
/*     */     //   #134	-> 466
/*     */     //   #135	-> 471
/*     */     //   #116	-> 476
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   187	5	8	solo	Z
/*     */     //   255	30	7	minigameParty	Ldev/jab125/minimega/mod/party/MinigameParty;
/*     */     //   117	168	6	minigameData	Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;
/*     */     //   351	30	9	minigameParty	Ldev/jab125/minimega/mod/party/MinigameParty;
/*     */     //   312	69	8	minigame	Ldev/jab125/minimega/mod/util/Minigame;
/*     */     //   414	30	9	minigameParty	Ldev/jab125/minimega/mod/party/MinigameParty;
/*     */     //   49	396	2	data	Ldev/jab125/minimega/mod/util/joindata/CreateOrJoin;
/*     */     //   451	25	3	minigameParty	Ldev/jab125/minimega/mod/party/MinigameParty;
/*     */     //   0	493	0	this	Ldev/jab125/minimega/mod/mixin/PrepareSpawnTaskMixin;
/*     */     //   0	493	1	original	Lnet/minecraft/server/level/ServerLevel;
/*     */     // Local variable type table:
/*     */     //   start	length	slot	name	signature
/*     */     //   312	69	8	minigame	Ldev/jab125/minimega/mod/util/Minigame<*>;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   108	111	476	java/lang/Throwable
/*     */     //   163	166	476	java/lang/Throwable
/*     */     //   170	173	476	java/lang/Throwable
/*     */     //   303	306	476	java/lang/Throwable
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
/*     */   @Unique
/*     */   private MinigameParty searchForLobbyWithMinigame(@Nullable Minigame<?> data) {
/* 140 */     List<MinigameParty> minigamePartyList = ((MinecraftServerExtension)this.server).getMinigamePartyList();
/* 141 */     Optional<MinigameParty> lobbyOpt = minigamePartyList.stream().filter(a -> (MinigamesController.getMinigameController((Level)a.getPartyLevel()).isLobby() && a.isAcceptingAnymorePlayers() && (data == null || a.data().minigame() == data))).findFirst();
/* 142 */     if (lobbyOpt.isPresent()) return lobbyOpt.get(); 
/* 143 */     Minimega.LOGGER.error("Couldn't find a public lobby for {}!, joining an existing game...", (data == null) ? "any" : data);
/* 144 */     Optional<MinigameParty> activeOpt = minigamePartyList.stream().filter(a -> { // Byte code:
/*     */           //   0: aload_0
/*     */           //   1: ifnonnull -> 20
/*     */           //   4: aload_1
/*     */           //   5: invokevirtual getPartyLevel : ()Lnet/minecraft/server/level/ServerLevel;
/*     */           //   8: invokestatic getMinigameController : (Lnet/minecraft/world/level/Level;)Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */           //   11: invokevirtual isActive : ()Z
/*     */           //   14: ifeq -> 45
/*     */           //   17: goto -> 34
/*     */           //   20: aload_1
/*     */           //   21: invokevirtual getPartyLevel : ()Lnet/minecraft/server/level/ServerLevel;
/*     */           //   24: invokestatic getMinigameController : (Lnet/minecraft/world/level/Level;)Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */           //   27: invokevirtual getActiveMinigame : ()Ldev/jab125/minimega/mod/util/Minigame;
/*     */           //   30: aload_0
/*     */           //   31: if_acmpne -> 45
/*     */           //   34: aload_1
/*     */           //   35: invokevirtual isAcceptingAnymorePlayers : ()Z
/*     */           //   38: ifeq -> 45
/*     */           //   41: iconst_1
/*     */           //   42: goto -> 46
/*     */           //   45: iconst_0
/*     */           //   46: ireturn
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #144	-> 0
/*     */           // Local variable table:
/*     */           //   start	length	slot	name	descriptor
/*     */           //   0	47	0	data	Ldev/jab125/minimega/mod/util/Minigame;
/* 144 */           //   0	47	1	a	Ldev/jab125/minimega/mod/party/MinigameParty; }).findFirst();
/* 145 */     if (activeOpt.isPresent()) return activeOpt.get(); 
/* 146 */     Minimega.LOGGER.error("Still couldn't find any public lobby or in progress game with {}!", (data == null) ? "any" : data);
/* 147 */     if (ModLoader.getInstance().getEnvironment() == Environment.DEDICATED_SERVER) {
/* 148 */       MinigameData data1 = new MinigameData(List.of(), Minigame.LOBBY, 1, (MinigameSpecificConfig)new NoConfig(), false, false);
/* 149 */       ServerLevel lobbyWithMinigame = Minimega.createLobbyWithMinigame(this.server, data1);
/* 150 */       MinigameParty minigameParty = ((MinecraftServerExtension)this.server).createMinigameParty(data1);
/* 151 */       minigameParty.transferToLevel(lobbyWithMinigame);
/* 152 */       return minigameParty;
/*     */     } 
/* 154 */     throw new UnableToJoinWorldException("No suitable game can be found for you to join.\nTry creating a game for others to join instead.");
/*     */   }
/*     */   
/*     */   @ModifyExpressionValue(method = {"start"}, at = {@At("MIXINEXTRAS:EXPRESSION")})
/*     */   @Definition(id = "completableFuture", local = {@Local(type = CompletableFuture.class)})
/*     */   @Expression({"completableFuture = @(?)"})
/*     */   CompletableFuture<Vec3> cf(CompletableFuture<Vec3> original, @Local ServerLevel level) {
/* 161 */     if (this.party != null) {
/* 162 */       UpdatePlayer spawnLocation = this.party.getSpawnLocation(this.playerSlot);
/* 163 */       Vec3 vec3 = spawnLocation.getPos();
/* 164 */       return CompletableFuture.completedFuture(vec3);
/*     */     } 
/* 166 */     return original;
/*     */   }
/*     */   
/*     */   @ModifyExpressionValue(method = {"start"}, at = {@At("MIXINEXTRAS:EXPRESSION")})
/*     */   @Definition(id = "vec2", local = {@Local(type = Vec2.class)})
/*     */   @Expression({"vec2 = @(?)"})
/*     */   Vec2 v2(Vec2 original) {
/* 173 */     if (this.party != null) {
/* 174 */       UpdatePlayer spawnLocation = this.party.getSpawnLocation(this.playerSlot);
/* 175 */       return new Vec2(spawnLocation.yRot(), spawnLocation.xRot());
/*     */     } 
/* 177 */     return original;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mm$setMinigameData(CreateOrJoin data) {
/* 185 */     this.data = data;
/*     */   }
/*     */ 
/*     */   
/*     */   public CreateOrJoin mm$getMinigameData() {
/* 190 */     return this.data;
/*     */   }
/*     */   
/*     */   @Mixin(targets = {"net/minecraft/server/network/config/PrepareSpawnTask$Ready"})
/*     */   public static class Ready
/*     */   {
/*     */     @Shadow
/*     */     @Final
/*     */     private PrepareSpawnTask this$0;
/*     */     
/*     */     @Inject(method = {"spawn"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/server/players/PlayerList;placeNewPlayer(Lnet/minecraft/network/Connection;Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/server/network/CommonListenerCookie;)V", shift = At.Shift.AFTER)})
/*     */     void load(Connection connection, CommonListenerCookie cookie, CallbackInfoReturnable<ServerPlayer> cir, @Local(ordinal = 0) ServerPlayer player) {
/* 202 */       MinigameParty minigameParty = ((PrepareSpawnTaskExtension)this.this$0).mm$getParty();
/* 203 */       if (minigameParty == null)
/* 204 */         return;  MinigamesController minigameController = MinigamesController.getMinigameController((Level)minigameParty.getPartyLevel());
/* 205 */       MinigameParty.PlayerSlot slot = ((PrepareSpawnTaskExtension)this.this$0).mm$playerSlot();
/* 206 */       AbstractMinigameController<?> controller = minigameController.getController(minigameController.getActiveMinigame());
/* 207 */       controller.mapTransitionScreen(controller.getMapInfo(controller.getMinigame(), controller.getCosmeticId().withPath(a -> a.substring(a.indexOf("/") + 1))), player, true);
/* 208 */       controller.acceptPlayer(slot);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\PrepareSpawnTaskMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */