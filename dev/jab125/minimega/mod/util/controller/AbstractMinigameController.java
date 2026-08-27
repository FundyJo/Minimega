/*     */ package dev.jab125.minimega.mod.util.controller;
/*     */ 
/*     */ import com.mojang.serialization.DynamicOps;
/*     */ import dev.jab125.minimega.grf.GrfContainer;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.LevelRules;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.MapOptions;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.__ROOT__;
/*     */ import dev.jab125.minimega.mod.IDiscordHandler;
/*     */ import dev.jab125.minimega.mod.Minimega;
/*     */ import dev.jab125.minimega.mod.MinimegaClientMethods;
/*     */ import dev.jab125.minimega.mod.abstractions.networking.ServerNetworking;
/*     */ import dev.jab125.minimega.mod.annotations.ServerSide;
/*     */ import dev.jab125.minimega.mod.data.MapInfo;
/*     */ import dev.jab125.minimega.mod.extension.MinecraftServerExtension;
/*     */ import dev.jab125.minimega.mod.networking.payload.S2CMapTransitionStartPayload;
/*     */ import dev.jab125.minimega.mod.party.MinigameParty;
/*     */ import dev.jab125.minimega.mod.util.Minigame;
/*     */ import dev.jab125.minimega.mod.util.MinigameFoodConstant;
/*     */ import dev.jab125.minimega.mod.util.controller.event.Event;
/*     */ import dev.jab125.minimega.mod.util.controller.event.TickEvent;
/*     */ import dev.jab125.minimega.mod.util.controller.glide.GlideMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.obj.MinigameRules;
/*     */ import dev.jab125.minimega.mod.util.minigamedata.MinigameData;
/*     */ import dev.jab125.minimega.mod.util.minigamedata.MinigameSpecificConfig;
/*     */ import dev.jab125.minimega.mod.util.minigamedata.NoConfig;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.nbt.NbtOps;
/*     */ import net.minecraft.nbt.Tag;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*     */ import net.minecraft.resources.Identifier;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import org.jetbrains.annotations.ApiStatus.OverrideOnly;
/*     */ import xyz.nucleoid.fantasy.Fantasy;
/*     */ 
/*     */ public abstract class AbstractMinigameController<T extends AbstractMinigameController<T>> {
/*     */   public final MinigamesController controller;
/*  42 */   private Identifier cosmeticId = (this instanceof dev.jab125.minimega.mod.util.controller.lobby.LobbyMinigameController) ? Minimega.id("lobby") : ((this instanceof NoneMinigameController) ? Minimega.id("none") : null);
/*  43 */   private MinigameData minigameData = new MinigameData(List.of(), Minigame.NONE, 1, (MinigameSpecificConfig)new NoConfig(), false, false);
/*     */   
/*     */   private __ROOT__ gameRules;
/*     */   
/*     */   private int ticksWithNoPlayers;
/*     */ 
/*     */   
/*     */   public void writeNbt(CompoundTag tag) {
/*  51 */     tag.put("rules", (Tag)MinigameRules.CODEC.encodeStart((DynamicOps)NbtOps.INSTANCE, getRules()).getOrThrow());
/*  52 */     if (this.cosmeticId != null) {
/*  53 */       tag.putString("cosmeticId", this.cosmeticId.toString());
/*     */     }
/*  55 */     Objects.requireNonNull(Minimega.LOGGER); tag.put("minigameData", GlideMinigameController.codecFromStreamCodec(MinigameData.STREAM_CODEC).encodeStart((DynamicOps)NbtOps.INSTANCE, this.minigameData).resultOrPartial(Minimega.LOGGER::error).orElseThrow());
/*     */   }
/*     */   
/*     */   protected __ROOT__ getGameRules() {
/*  59 */     __ROOT__ gameRules0 = getGameRules0();
/*  60 */     if (gameRules0 == null) return new __ROOT__(List.of(new MapOptions(0, Optional.empty(), 0.0D, List.of()), new LevelRules(0, List.of()))); 
/*  61 */     return gameRules0;
/*     */   }
/*     */   private __ROOT__ getGameRules0() {
/*  64 */     if (this.controller == null) return null; 
/*  65 */     return this.controller.isClient() ? MinimegaClientMethods.currentDimensionGrf.get() : ((GrfContainer)this.controller.getLevel()).getGrf();
/*     */   }
/*     */   
/*     */   public void readNbt(CompoundTag tag) {
/*  69 */     if (tag.contains("rules")) {
/*  70 */       Objects.requireNonNull(Minimega.LOGGER); setRules(MinigameRules.CODEC.parse((DynamicOps)NbtOps.INSTANCE, tag.get("rules")).resultOrPartial(Minimega.LOGGER::error).orElseThrow());
/*     */     } 
/*  72 */     if (tag.contains("cosmeticId")) {
/*  73 */       this.cosmeticId = Identifier.parse(tag.getString("cosmeticId").orElseThrow());
/*     */     } else {
/*  75 */       this.cosmeticId = null;
/*     */     } 
/*  77 */     if (tag.contains("minigameData")) {
/*  78 */       Objects.requireNonNull(Minimega.LOGGER); this.minigameData = GlideMinigameController.codecFromStreamCodec(MinigameData.STREAM_CODEC).parse((DynamicOps)NbtOps.INSTANCE, tag.get("minigameData")).resultOrPartial(Minimega.LOGGER::error).orElseThrow();
/*     */     } else {
/*  80 */       this.minigameData = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated(forRemoval = true)
/*     */   public void setRules(MinigameRules rules) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated(forRemoval = true)
/*     */   public <R extends Throwable> MinigameRules getRules() throws R {
/*     */     try {
/* 100 */       return new MinigameRules(new MinigameRules.DestroyPermissions(MinigameRules.Mode.BLACKLIST), new MinigameRules.PlacePermissions(MinigameRules.Mode.BLACKLIST), new MinigameRules.UsePermissions(MinigameRules.Mode.BLACKLIST, List.of()), new MinigameRules.BlockUsePermissions(MinigameRules.Mode.BLACKLIST, List.of()), new MinigameRules.Timers(), new MinigameRules.Sounds(), true);
/* 101 */     } catch (Throwable t) {
/* 102 */       throw (R)t;
/*     */     } 
/*     */   }
/*     */   public AbstractMinigameController(MinigamesController controller) {
/* 106 */     this.ticksWithNoPlayers = 0;
/*     */     this.controller = controller;
/*     */   } public final void callTick(boolean frozen) {
/* 109 */     fireEvent((Event)new TickEvent());
/* 110 */     tick(frozen);
/* 111 */     if (this instanceof NoneMinigameController)
/* 112 */       return;  ServerLevel level = this.controller.getLevel();
/* 113 */     if ((this.controller.getPlayersFor(level)).length == 0) {
/* 114 */       this.ticksWithNoPlayers++;
/* 115 */       if (this.ticksWithNoPlayers >= 200) {
/* 116 */         String txt = "Level " + String.valueOf(level.dimension().identifier()) + ", with minigame " + this.controller.getActiveMinigame().toString() + ", hasn't had players for 10 entire seconds, attempting to remove level.";
/* 117 */         Minimega.LOGGER.info(txt);
/* 118 */         Minimega.getDiscordHandler().relaySystemMessageToDiscord(IDiscordHandler.BLUE, (Component)Component.literal(this.controller.getActiveMinigame().getName() + " map has been unloaded."));
/* 119 */         Fantasy.get(level.getServer()).tickDeleteLevel(level);
/*     */       } 
/*     */     } else {
/* 122 */       this.ticksWithNoPlayers = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void tick(boolean frozen) {
/* 127 */     tick();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void tick() {}
/*     */ 
/*     */   
/*     */   public void setCosmeticId(Identifier id) {
/* 135 */     this.cosmeticId = id;
/*     */   }
/*     */   
/*     */   public Identifier getCosmeticId() {
/* 139 */     return this.cosmeticId;
/*     */   }
/*     */ 
/*     */   
/*     */   public void acceptPlayer(MinigameParty.PlayerSlot slot) {
/* 144 */     Minimega.LOGGER.error("acceptPlayer(PlayerSlot) is not implemented!");
/*     */   }
/*     */ 
/*     */   
/*     */   public void playerLoadedIn(ServerPlayer player) {}
/*     */ 
/*     */   
/*     */   public void accept(__ROOT__ gameRules) {
/* 152 */     this.gameRules = gameRules;
/*     */   }
/*     */   
/*     */   @Deprecated(forRemoval = true, since = "4.1.130")
/*     */   public final boolean hideNearbyPlayers() {
/* 157 */     return (minigameAbilities()).hideNearbyPlayers;
/*     */   }
/*     */   
/*     */   public boolean canAcceptNewPlayers() {
/* 161 */     return true;
/*     */   }
/*     */   
/*     */   @Deprecated(forRemoval = true, since = "4.1.130")
/*     */   public final boolean isSmallInventory() {
/* 166 */     return (minigameAbilities()).smallInventory;
/*     */   }
/*     */   
/*     */   @Deprecated(forRemoval = true, since = "4.1.130")
/*     */   public final boolean pvpEnabled() {
/* 171 */     return (minigameAbilities()).pvpEnabled;
/*     */   }
/*     */   
/*     */   @Deprecated(forRemoval = true, since = "4.1.130")
/*     */   public final boolean movementDisabled() {
/* 176 */     return (minigameAbilities()).movementDisabled;
/*     */   }
/*     */   
/*     */   public void acceptMinigameData(MinigameData data) {
/* 180 */     this.minigameData = data;
/*     */   }
/*     */   
/*     */   public MinigameData getMinigameData() {
/* 184 */     return this.minigameData;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void playerReady(ServerPlayer player, boolean ready) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void playerVoted(ServerPlayer player, Identifier resourceLocation) {}
/*     */ 
/*     */ 
/*     */   
/*     */   @OverrideOnly
/*     */   public MinigameAbilities minigameAbilities() {
/* 199 */     return new MinigameAbilities();
/*     */   }
/*     */   
/*     */   @Deprecated(forRemoval = true, since = "4.1.130")
/*     */   public final int getFoodConstantI(MinigameFoodConstant minigameFoodConstant) {
/* 204 */     return minigameAbilities().getFoodConstantI(minigameFoodConstant);
/*     */   }
/*     */   
/*     */   @Deprecated(forRemoval = true, since = "4.1.130")
/*     */   public final float getFoodConstantF(MinigameFoodConstant minigameFoodConstant) {
/* 209 */     return minigameAbilities().getFoodConstantF(minigameFoodConstant);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void beforeRespawn(MinigameParty.PlayerSlot slot, ServerPlayer oldPlayer, ServerPlayer newPlayer) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void afterRespawn(MinigameParty.PlayerSlot slot, ServerPlayer oldPlayer, ServerPlayer newPlayer) {}
/*     */ 
/*     */   
/*     */   public final void fireEvent(Event event) {
/* 222 */     if (this.controller.isClient())
/* 223 */       return;  receiveEvent(event);
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
/*     */   protected void receiveEvent(Event event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: dup
/*     */     //   2: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   5: pop
/*     */     //   6: astore_2
/*     */     //   7: iconst_0
/*     */     //   8: istore_3
/*     */     //   9: aload_2
/*     */     //   10: iload_3
/*     */     //   11: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/mod/util/controller/event/Event;I)I
/*     */     //   16: tableswitch default -> 464, 0 -> 52, 1 -> 150, 2 -> 248, 3 -> 346, 4 -> 445
/*     */     //   52: aload_2
/*     */     //   53: checkcast dev/jab125/minimega/mod/util/controller/event/TimerTickEvent
/*     */     //   56: astore #4
/*     */     //   58: aload #4
/*     */     //   60: invokevirtual timerId : ()Lnet/minecraft/resources/Identifier;
/*     */     //   63: astore #7
/*     */     //   65: aload #7
/*     */     //   67: astore #5
/*     */     //   69: aload #4
/*     */     //   71: invokevirtual ticksRemaining : ()I
/*     */     //   74: istore #7
/*     */     //   76: iload #7
/*     */     //   78: istore #8
/*     */     //   80: iconst_1
/*     */     //   81: ifeq -> 107
/*     */     //   84: iload #7
/*     */     //   86: istore #6
/*     */     //   88: getstatic dev/jab125/minimega/mod/util/controller/event/TimerTickEvent.LOBBY_ROUND_START_TIMER : Lnet/minecraft/resources/Identifier;
/*     */     //   91: aload #5
/*     */     //   93: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   96: ifeq -> 107
/*     */     //   99: iload #6
/*     */     //   101: bipush #20
/*     */     //   103: irem
/*     */     //   104: ifeq -> 112
/*     */     //   107: iconst_1
/*     */     //   108: istore_3
/*     */     //   109: goto -> 9
/*     */     //   112: iload #6
/*     */     //   114: ifgt -> 130
/*     */     //   117: aload_0
/*     */     //   118: ldc_w 'timer/lobby/zero'
/*     */     //   121: invokestatic id : (Ljava/lang/String;)Lnet/minecraft/resources/Identifier;
/*     */     //   124: invokevirtual broadcastGlobalSound : (Lnet/minecraft/resources/Identifier;)V
/*     */     //   127: goto -> 467
/*     */     //   130: iload #6
/*     */     //   132: bipush #100
/*     */     //   134: if_icmpgt -> 467
/*     */     //   137: aload_0
/*     */     //   138: ldc_w 'timer/lobby'
/*     */     //   141: invokestatic id : (Ljava/lang/String;)Lnet/minecraft/resources/Identifier;
/*     */     //   144: invokevirtual broadcastGlobalSound : (Lnet/minecraft/resources/Identifier;)V
/*     */     //   147: goto -> 467
/*     */     //   150: aload_2
/*     */     //   151: checkcast dev/jab125/minimega/mod/util/controller/event/TimerTickEvent
/*     */     //   154: astore #7
/*     */     //   156: aload #7
/*     */     //   158: invokevirtual timerId : ()Lnet/minecraft/resources/Identifier;
/*     */     //   161: astore #10
/*     */     //   163: aload #10
/*     */     //   165: astore #8
/*     */     //   167: aload #7
/*     */     //   169: invokevirtual ticksRemaining : ()I
/*     */     //   172: istore #10
/*     */     //   174: iload #10
/*     */     //   176: istore #11
/*     */     //   178: iconst_1
/*     */     //   179: ifeq -> 205
/*     */     //   182: iload #10
/*     */     //   184: istore #9
/*     */     //   186: getstatic dev/jab125/minimega/mod/util/controller/event/TimerTickEvent.ROUND_START_TIMER : Lnet/minecraft/resources/Identifier;
/*     */     //   189: aload #8
/*     */     //   191: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   194: ifeq -> 205
/*     */     //   197: iload #9
/*     */     //   199: bipush #20
/*     */     //   201: irem
/*     */     //   202: ifeq -> 210
/*     */     //   205: iconst_2
/*     */     //   206: istore_3
/*     */     //   207: goto -> 9
/*     */     //   210: iload #9
/*     */     //   212: ifgt -> 228
/*     */     //   215: aload_0
/*     */     //   216: ldc_w 'timer/start/zero'
/*     */     //   219: invokestatic id : (Ljava/lang/String;)Lnet/minecraft/resources/Identifier;
/*     */     //   222: invokevirtual broadcastGlobalSound : (Lnet/minecraft/resources/Identifier;)V
/*     */     //   225: goto -> 467
/*     */     //   228: iload #9
/*     */     //   230: bipush #100
/*     */     //   232: if_icmpgt -> 467
/*     */     //   235: aload_0
/*     */     //   236: ldc_w 'timer/start'
/*     */     //   239: invokestatic id : (Ljava/lang/String;)Lnet/minecraft/resources/Identifier;
/*     */     //   242: invokevirtual broadcastGlobalSound : (Lnet/minecraft/resources/Identifier;)V
/*     */     //   245: goto -> 467
/*     */     //   248: aload_2
/*     */     //   249: checkcast dev/jab125/minimega/mod/util/controller/event/TimerTickEvent
/*     */     //   252: astore #10
/*     */     //   254: aload #10
/*     */     //   256: invokevirtual timerId : ()Lnet/minecraft/resources/Identifier;
/*     */     //   259: astore #13
/*     */     //   261: aload #13
/*     */     //   263: astore #11
/*     */     //   265: aload #10
/*     */     //   267: invokevirtual ticksRemaining : ()I
/*     */     //   270: istore #13
/*     */     //   272: iload #13
/*     */     //   274: istore #14
/*     */     //   276: iconst_1
/*     */     //   277: ifeq -> 303
/*     */     //   280: iload #13
/*     */     //   282: istore #12
/*     */     //   284: getstatic dev/jab125/minimega/mod/util/controller/event/TimerTickEvent.GRACE_PERIOD_END_TIMER : Lnet/minecraft/resources/Identifier;
/*     */     //   287: aload #11
/*     */     //   289: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   292: ifeq -> 303
/*     */     //   295: iload #12
/*     */     //   297: bipush #20
/*     */     //   299: irem
/*     */     //   300: ifeq -> 308
/*     */     //   303: iconst_3
/*     */     //   304: istore_3
/*     */     //   305: goto -> 9
/*     */     //   308: iload #12
/*     */     //   310: ifgt -> 326
/*     */     //   313: aload_0
/*     */     //   314: ldc_w 'timer/grace/zero'
/*     */     //   317: invokestatic id : (Ljava/lang/String;)Lnet/minecraft/resources/Identifier;
/*     */     //   320: invokevirtual broadcastGlobalSound : (Lnet/minecraft/resources/Identifier;)V
/*     */     //   323: goto -> 467
/*     */     //   326: iload #12
/*     */     //   328: bipush #60
/*     */     //   330: if_icmpgt -> 467
/*     */     //   333: aload_0
/*     */     //   334: ldc_w 'timer/grace'
/*     */     //   337: invokestatic id : (Ljava/lang/String;)Lnet/minecraft/resources/Identifier;
/*     */     //   340: invokevirtual broadcastGlobalSound : (Lnet/minecraft/resources/Identifier;)V
/*     */     //   343: goto -> 467
/*     */     //   346: aload_2
/*     */     //   347: checkcast dev/jab125/minimega/mod/util/controller/event/TimerTickEvent
/*     */     //   350: astore #13
/*     */     //   352: aload #13
/*     */     //   354: invokevirtual timerId : ()Lnet/minecraft/resources/Identifier;
/*     */     //   357: astore #16
/*     */     //   359: aload #16
/*     */     //   361: astore #14
/*     */     //   363: aload #13
/*     */     //   365: invokevirtual ticksRemaining : ()I
/*     */     //   368: istore #16
/*     */     //   370: iload #16
/*     */     //   372: istore #17
/*     */     //   374: iconst_1
/*     */     //   375: ifeq -> 401
/*     */     //   378: iload #16
/*     */     //   380: istore #15
/*     */     //   382: getstatic dev/jab125/minimega/mod/util/controller/event/TimerTickEvent.MAIN_GAME_TIMER : Lnet/minecraft/resources/Identifier;
/*     */     //   385: aload #14
/*     */     //   387: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   390: ifeq -> 401
/*     */     //   393: iload #15
/*     */     //   395: bipush #20
/*     */     //   397: irem
/*     */     //   398: ifeq -> 406
/*     */     //   401: iconst_4
/*     */     //   402: istore_3
/*     */     //   403: goto -> 9
/*     */     //   406: iload #15
/*     */     //   408: ifgt -> 424
/*     */     //   411: aload_0
/*     */     //   412: ldc_w 'timer/lobby/zero'
/*     */     //   415: invokestatic id : (Ljava/lang/String;)Lnet/minecraft/resources/Identifier;
/*     */     //   418: invokevirtual broadcastGlobalSound : (Lnet/minecraft/resources/Identifier;)V
/*     */     //   421: goto -> 467
/*     */     //   424: iload #15
/*     */     //   426: sipush #600
/*     */     //   429: if_icmpgt -> 467
/*     */     //   432: aload_0
/*     */     //   433: ldc_w 'timer/lobby'
/*     */     //   436: invokestatic id : (Ljava/lang/String;)Lnet/minecraft/resources/Identifier;
/*     */     //   439: invokevirtual broadcastGlobalSound : (Lnet/minecraft/resources/Identifier;)V
/*     */     //   442: goto -> 467
/*     */     //   445: aload_2
/*     */     //   446: checkcast dev/jab125/minimega/mod/util/controller/event/ShowdownEvent
/*     */     //   449: astore #16
/*     */     //   451: aload_0
/*     */     //   452: ldc_w 'showdown'
/*     */     //   455: invokestatic id : (Ljava/lang/String;)Lnet/minecraft/resources/Identifier;
/*     */     //   458: invokevirtual broadcastGlobalSound : (Lnet/minecraft/resources/Identifier;)V
/*     */     //   461: goto -> 467
/*     */     //   464: goto -> 467
/*     */     //   467: goto -> 484
/*     */     //   470: astore_2
/*     */     //   471: new java/lang/MatchException
/*     */     //   474: dup
/*     */     //   475: aload_2
/*     */     //   476: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   479: aload_2
/*     */     //   480: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   483: athrow
/*     */     //   484: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #228	-> 0
/*     */     //   #229	-> 52
/*     */     //   #230	-> 112
/*     */     //   #231	-> 117
/*     */     //   #232	-> 130
/*     */     //   #233	-> 137
/*     */     //   #236	-> 150
/*     */     //   #237	-> 210
/*     */     //   #238	-> 215
/*     */     //   #239	-> 228
/*     */     //   #240	-> 235
/*     */     //   #243	-> 248
/*     */     //   #244	-> 308
/*     */     //   #245	-> 313
/*     */     //   #246	-> 326
/*     */     //   #247	-> 333
/*     */     //   #250	-> 346
/*     */     //   #251	-> 406
/*     */     //   #252	-> 411
/*     */     //   #253	-> 424
/*     */     //   #254	-> 432
/*     */     //   #257	-> 445
/*     */     //   #258	-> 451
/*     */     //   #259	-> 461
/*     */     //   #260	-> 464
/*     */     //   #257	-> 470
/*     */     //   #262	-> 484
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   88	19	6	timeRemaining	I
/*     */     //   69	81	5	id	Lnet/minecraft/resources/Identifier;
/*     */     //   112	38	6	timeRemaining	I
/*     */     //   186	19	9	timeRemaining	I
/*     */     //   167	81	8	id	Lnet/minecraft/resources/Identifier;
/*     */     //   210	38	9	timeRemaining	I
/*     */     //   284	19	12	timeRemaining	I
/*     */     //   265	81	11	id	Lnet/minecraft/resources/Identifier;
/*     */     //   308	38	12	timeRemaining	I
/*     */     //   382	19	15	timeRemaining	I
/*     */     //   363	82	14	id	Lnet/minecraft/resources/Identifier;
/*     */     //   406	39	15	timeRemaining	I
/*     */     //   0	485	0	this	Ldev/jab125/minimega/mod/util/controller/AbstractMinigameController;
/*     */     //   0	485	1	event	Ldev/jab125/minimega/mod/util/controller/event/Event;
/*     */     // Local variable type table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	485	0	this	Ldev/jab125/minimega/mod/util/controller/AbstractMinigameController<TT;>;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   60	63	470	java/lang/Throwable
/*     */     //   71	74	470	java/lang/Throwable
/*     */     //   158	161	470	java/lang/Throwable
/*     */     //   169	172	470	java/lang/Throwable
/*     */     //   256	259	470	java/lang/Throwable
/*     */     //   267	270	470	java/lang/Throwable
/*     */     //   354	357	470	java/lang/Throwable
/*     */     //   365	368	470	java/lang/Throwable
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
/*     */   public void broadcastGlobalSound(Identifier id) {
/*     */     MinigameParty party;
/* 265 */     ServerLevel level = this.controller.getLevel();
/* 266 */     MinigameParty minigameParty1 = (MinigameParty)((MinecraftServerExtension)level.getServer()).getLevelParty(level).orElse(null); if (minigameParty1 instanceof MinigameParty) { party = minigameParty1; } else { return; }
/* 267 */      party.playGlobalSound(id);
/*     */   }
/*     */   
/*     */   @Deprecated(forRemoval = true, since = "4.1.130")
/*     */   public final boolean takeAllEnabled() {
/* 272 */     return (minigameAbilities()).takeAll;
/*     */   }
/*     */   
/*     */   public static final class NoneMinigameController extends AbstractMinigameController<NoneMinigameController> {
/*     */     public NoneMinigameController(MinigamesController controller) {
/* 277 */       super(controller);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void writeNbt(CompoundTag tag) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void readNbt(CompoundTag tag) {}
/*     */ 
/*     */     
/*     */     public Minigame<NoneMinigameController> getMinigame() {
/* 290 */       return Minigame.NONE;
/*     */     }
/*     */ 
/*     */     
/*     */     public MinigameAbilities minigameAbilities() {
/* 295 */       MinigameAbilities minigameAbilities = super.minigameAbilities();
/* 296 */       minigameAbilities.smallInventory = false;
/* 297 */       minigameAbilities.pvpEnabled = true;
/* 298 */       minigameAbilities.canTakeItemsOutOfItemFrames = true;
/* 299 */       minigameAbilities.canInteractWithArmorStands = true;
/* 300 */       minigameAbilities.canInteractWithPaintings = true;
/* 301 */       return minigameAbilities;
/*     */     }
/*     */   }
/*     */   
/*     */   public static void sendTopMessage(ServerPlayer player, Component message) {
/* 306 */     Minimega.sendTopMessage(player, message);
/*     */   }
/*     */   
/*     */   @ServerSide
/*     */   public MapInfo getMapInfo(Minigame<?> minigame, Identifier mapId) {
/* 311 */     int theme = Minimega.getGrf(mapId, minigame.tId(), this.controller.getLevel().getServer()).getMapOptions().themeId();
/* 312 */     return Minimega.getMapInfo(mapId, minigame.tId(), this.controller.getLevel().getServer());
/*     */   }
/*     */   
/*     */   public void mapTransitionScreen(MapInfo info, ServerPlayer player) {
/* 316 */     mapTransitionScreen(info, player, false);
/*     */   }
/*     */   
/*     */   public void mapTransitionScreen(MapInfo info, ServerPlayer player, boolean sameLevel) {
/* 320 */     player.connection.send(ServerNetworking.getInstance().play((CustomPacketPayload)new S2CMapTransitionStartPayload(info, sameLevel)));
/*     */   }
/*     */   
/*     */   public abstract Minigame<T> getMinigame();
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\controller\AbstractMinigameController.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */