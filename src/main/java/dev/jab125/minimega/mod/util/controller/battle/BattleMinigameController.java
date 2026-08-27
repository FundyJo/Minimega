/*     */ package dev.jab125.minimega.mod.util.controller.battle;
/*     */ 
/*     */ import com.google.common.base.Stopwatch;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.Tester;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.gamemode.ChestItem;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.gamemode.GameMode;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.gamemode.HasWeight;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.gamemode.Item;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.gamemode.Kit;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.gamemode.LootGroup;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.gamemode.LootSet;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.gamemode.LootSets;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.DistributeItems;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.LevelRules;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.SpawnPositionSet;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.UpdatePlayer;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.WorldPosition;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.__ROOT__;
/*     */ import dev.jab125.minimega.mod.Minimega;
/*     */ import dev.jab125.minimega.mod.abstractions.modloader.ModLoader;
/*     */ import dev.jab125.minimega.mod.abstractions.networking.ServerNetworking;
/*     */ import dev.jab125.minimega.mod.networking.payload.S2CDisplayShieldPayload;
/*     */ import dev.jab125.minimega.mod.party.MinigameParty;
/*     */ import dev.jab125.minimega.mod.util.LETSGOGAMBLING;
/*     */ import dev.jab125.minimega.mod.util.Minigame;
/*     */ import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.MinigameAbilities;
/*     */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*     */ import dev.jab125.minimega.mod.util.controller.event.Event;
/*     */ import dev.jab125.minimega.mod.util.controller.event.ShowdownEvent;
/*     */ import dev.jab125.minimega.mod.util.controller.obj.MinigameRules;
/*     */ import it.unimi.dsi.fastutil.objects.ObjectArrayList;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.CompletableFuture;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*     */ import net.minecraft.resources.Identifier;
/*     */ import net.minecraft.resources.ResourceKey;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.util.datafix.DataFixers;
/*     */ import net.minecraft.world.Container;
/*     */ import net.minecraft.world.RandomizableContainer;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.GameType;
/*     */ import net.minecraft.world.level.block.entity.BlockEntity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BattleMinigameController
/*     */   extends AbstractMinigameController<BattleMinigameController>
/*     */ {
/*  68 */   private static final CompletableFuture<LootSets> lootSets = loadLootSets(); private List<UpdatePlayer> updatePlayers; private int startingOutPlayers; private boolean alreadyShowdowned; boolean letPlayersKnow; private int theme; private int stage;
/*     */   
/*     */   public static boolean lootSetsLoaded() {
/*  71 */     return lootSets.isDone();
/*     */   }
/*     */   private int timer; public static final int INITIALIZATION = 0; public static final int BEFORE_START = 1; public static final int GRACE_PERIOD = 2; public static final int MAIN_GAME = 3; public static final int SHOWDOWN = 4; public static final int FINISHED = 5;
/*     */   public static void init() {}
/*     */   
/*     */   private static CompletableFuture<LootSets> loadLootSets() {
/*  77 */     return CompletableFuture.supplyAsync(() -> {
/*     */           Stopwatch stopwatch = Stopwatch.createStarted();
/*     */           try {
/*     */             return ((GameMode)Tester.loadFromXML(new String(BattleMinigameController.class.getResourceAsStream("/data/minimega/minimega_minigames/gamerules/battle_partial_flattened.xml").readAllBytes()), DataFixers.getDataFixer()).orElseThrow(())).getFirstOf(LootSets.class).orElseThrow();
/*  81 */           } catch (IOException e) {
/*     */             throw new RuntimeException(e);
/*     */           } finally {
/*     */             stopwatch.stop();
/*     */             Minimega.LOGGER.info("Took {}ms to set load battle loot ({}s)", Long.valueOf(stopwatch.elapsed(TimeUnit.MILLISECONDS)), Long.valueOf(stopwatch.elapsed(TimeUnit.SECONDS)));
/*     */           } 
/*     */         });
/*     */   }
/*     */   
/*     */   public BattleMinigameController(MinigamesController controller) {
/*  91 */     super(controller);
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
/* 398 */     this.alreadyShowdowned = false;
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
/* 453 */     this.stage = 0;
/* 454 */     this.timer = 400;
/*     */   }
/*     */   
/*     */   public Minigame<BattleMinigameController> getMinigame() {
/*     */     return Minigame.BATTLE;
/*     */   }
/*     */   
/*     */   public void accept(__ROOT__ obj) {
/*     */     super.accept(obj);
/*     */     LevelRules levelRules = obj.getLevelRules();
/*     */     this.theme = obj.getMapOptions().themeId();
/*     */     this.updatePlayers = ((SpawnPositionSet)levelRules.flatStreamOf(SpawnPositionSet.class).filter(a -> (a.method() == 0)).findFirst().orElseThrow()).streamOf(UpdatePlayer.class).toList();
/*     */   }
/*     */   
/*     */   public void acceptPlayer(MinigameParty.PlayerSlot slot) {
/*     */     MinigameParty party = slot.getParty();
/*     */     Optional<ServerPlayer> playerOpt = party.player(slot);
/*     */     if (playerOpt.isEmpty())
/*     */       return; 
/*     */     ServerPlayer player = playerOpt.get();
/*     */     player.getInventory().clearOrCountMatchingItems(i -> true, -1, (Container)player.inventoryMenu.getCraftSlots());
/*     */     player.setGameMode(GameType.ADVENTURE);
/*     */   }
/*     */   
/*     */   public void afterRespawn(MinigameParty.PlayerSlot slot, ServerPlayer oldPlayer, ServerPlayer newPlayer) {
/*     */     newPlayer.setGameMode(GameType.SPECTATOR);
/*     */   }
/*     */   
/*     */   public float xRot() {
/*     */     return ((UpdatePlayer)this.updatePlayers.get(0)).xRot();
/*     */   }
/*     */   
/*     */   public float yRot() {
/*     */     return ((UpdatePlayer)this.updatePlayers.get(0)).yRot();
/*     */   }
/*     */   
/*     */   public float xRot(int player) {
/*     */     return ((UpdatePlayer)this.updatePlayers.get(player)).xRot();
/*     */   }
/*     */   
/*     */   public float yRot(int player) {
/*     */     return ((UpdatePlayer)this.updatePlayers.get(player)).yRot();
/*     */   }
/*     */   
/*     */   public UpdatePlayer updatePlayer(int player, Random random) {
/*     */     int index = player % this.updatePlayers.size();
/*     */     ArrayList<UpdatePlayer> list = new ArrayList<>(this.updatePlayers);
/*     */     Collections.shuffle(list, random);
/*     */     return list.get(index);
/*     */   }
/*     */   
/*     */   public MinigameAbilities minigameAbilities() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial minigameAbilities : ()Ldev/jab125/minimega/mod/util/controller/MinigameAbilities;
/*     */     //   4: astore_1
/*     */     //   5: aload_1
/*     */     //   6: aload_0
/*     */     //   7: getfield stage : I
/*     */     //   10: iconst_3
/*     */     //   11: if_icmpeq -> 22
/*     */     //   14: aload_0
/*     */     //   15: getfield stage : I
/*     */     //   18: iconst_4
/*     */     //   19: if_icmpne -> 26
/*     */     //   22: iconst_1
/*     */     //   23: goto -> 27
/*     */     //   26: iconst_0
/*     */     //   27: putfield pvpEnabled : Z
/*     */     //   30: aload_1
/*     */     //   31: aload_0
/*     */     //   32: getfield stage : I
/*     */     //   35: iconst_2
/*     */     //   36: if_icmpge -> 43
/*     */     //   39: iconst_1
/*     */     //   40: goto -> 44
/*     */     //   43: iconst_0
/*     */     //   44: putfield movementDisabled : Z
/*     */     //   47: aload_1
/*     */     //   48: new dev/jab125/minimega/mod/util/controller/MinigameAbilities$FoodConstantPatch
/*     */     //   51: dup
/*     */     //   52: getstatic dev/jab125/minimega/mod/util/MinigameFoodConstant.MAX_FOOD : Ldev/jab125/minimega/mod/util/MinigameFoodConstant;
/*     */     //   55: bipush #20
/*     */     //   57: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   60: getstatic dev/jab125/minimega/mod/util/MinigameFoodConstant.MAX_SATURATION : Ldev/jab125/minimega/mod/util/MinigameFoodConstant;
/*     */     //   63: iconst_4
/*     */     //   64: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   67: getstatic dev/jab125/minimega/mod/util/MinigameFoodConstant.START_SATURATION : Ldev/jab125/minimega/mod/util/MinigameFoodConstant;
/*     */     //   70: iconst_4
/*     */     //   71: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   74: getstatic dev/jab125/minimega/mod/util/MinigameFoodConstant.SATURATION_FLOOR : Ldev/jab125/minimega/mod/util/MinigameFoodConstant;
/*     */     //   77: iconst_0
/*     */     //   78: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   81: getstatic dev/jab125/minimega/mod/util/MinigameFoodConstant.EXHAUSTION_DROP : Ldev/jab125/minimega/mod/util/MinigameFoodConstant;
/*     */     //   84: iconst_4
/*     */     //   85: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   88: getstatic dev/jab125/minimega/mod/util/MinigameFoodConstant.HEALTH_TICK_COUNT : Ldev/jab125/minimega/mod/util/MinigameFoodConstant;
/*     */     //   91: bipush #40
/*     */     //   93: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   96: getstatic dev/jab125/minimega/mod/util/MinigameFoodConstant.HEALTH_TICK_COUNT_SATURATED : Ldev/jab125/minimega/mod/util/MinigameFoodConstant;
/*     */     //   99: bipush #40
/*     */     //   101: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   104: getstatic dev/jab125/minimega/mod/util/MinigameFoodConstant.HEAL_LEVEL : Ldev/jab125/minimega/mod/util/MinigameFoodConstant;
/*     */     //   107: iconst_4
/*     */     //   108: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   111: getstatic dev/jab125/minimega/mod/util/MinigameFoodConstant.STARVE_LEVEL : Ldev/jab125/minimega/mod/util/MinigameFoodConstant;
/*     */     //   114: iconst_0
/*     */     //   115: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   118: getstatic dev/jab125/minimega/mod/util/MinigameFoodConstant.SPRINT_LEVEL : Ldev/jab125/minimega/mod/util/MinigameFoodConstant;
/*     */     //   121: iconst_0
/*     */     //   122: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   125: invokestatic of : (Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;
/*     */     //   128: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   133: invokeinterface stream : ()Ljava/util/stream/Stream;
/*     */     //   138: getstatic dev/jab125/minimega/mod/util/MinigameFoodConstant.EXHAUSTION_HEAL : Ldev/jab125/minimega/mod/util/MinigameFoodConstant;
/*     */     //   141: ldc2_w 4.0
/*     */     //   144: invokestatic valueOf : (D)Ljava/lang/Double;
/*     */     //   147: getstatic dev/jab125/minimega/mod/util/MinigameFoodConstant.EXHAUSTION_JUMP : Ldev/jab125/minimega/mod/util/MinigameFoodConstant;
/*     */     //   150: ldc2_w 0.2
/*     */     //   153: invokestatic valueOf : (D)Ljava/lang/Double;
/*     */     //   156: getstatic dev/jab125/minimega/mod/util/MinigameFoodConstant.EXHAUSTION_SPRINT_JUMP : Ldev/jab125/minimega/mod/util/MinigameFoodConstant;
/*     */     //   159: ldc2_w 0.8
/*     */     //   162: invokestatic valueOf : (D)Ljava/lang/Double;
/*     */     //   165: getstatic dev/jab125/minimega/mod/util/MinigameFoodConstant.EXHAUSTION_MINE : Ldev/jab125/minimega/mod/util/MinigameFoodConstant;
/*     */     //   168: ldc2_w 0.025
/*     */     //   171: invokestatic valueOf : (D)Ljava/lang/Double;
/*     */     //   174: getstatic dev/jab125/minimega/mod/util/MinigameFoodConstant.EXHAUSTION_ATTACK : Ldev/jab125/minimega/mod/util/MinigameFoodConstant;
/*     */     //   177: ldc2_w 0.3
/*     */     //   180: invokestatic valueOf : (D)Ljava/lang/Double;
/*     */     //   183: getstatic dev/jab125/minimega/mod/util/MinigameFoodConstant.EXHAUSTION_WALK : Ldev/jab125/minimega/mod/util/MinigameFoodConstant;
/*     */     //   186: ldc2_w 0.04
/*     */     //   189: invokestatic valueOf : (D)Ljava/lang/Double;
/*     */     //   192: getstatic dev/jab125/minimega/mod/util/MinigameFoodConstant.EXHAUSTION_SPRINT : Ldev/jab125/minimega/mod/util/MinigameFoodConstant;
/*     */     //   195: ldc2_w 0.085
/*     */     //   198: invokestatic valueOf : (D)Ljava/lang/Double;
/*     */     //   201: getstatic dev/jab125/minimega/mod/util/MinigameFoodConstant.EXHAUSTION_SWIM : Ldev/jab125/minimega/mod/util/MinigameFoodConstant;
/*     */     //   204: ldc2_w 0.03
/*     */     //   207: invokestatic valueOf : (D)Ljava/lang/Double;
/*     */     //   210: getstatic dev/jab125/minimega/mod/util/MinigameFoodConstant.EXHAUSTION_IDLE : Ldev/jab125/minimega/mod/util/MinigameFoodConstant;
/*     */     //   213: ldc2_w 0.004
/*     */     //   216: invokestatic valueOf : (D)Ljava/lang/Double;
/*     */     //   219: invokestatic of : (Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;
/*     */     //   222: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   227: invokeinterface stream : ()Ljava/util/stream/Stream;
/*     */     //   232: invokestatic concat : (Ljava/util/stream/Stream;Ljava/util/stream/Stream;)Ljava/util/stream/Stream;
/*     */     //   235: <illegal opcode> apply : ()Ljava/util/function/Function;
/*     */     //   240: <illegal opcode> apply : ()Ljava/util/function/Function;
/*     */     //   245: invokestatic toMap : (Ljava/util/function/Function;Ljava/util/function/Function;)Ljava/util/stream/Collector;
/*     */     //   248: invokeinterface collect : (Ljava/util/stream/Collector;)Ljava/lang/Object;
/*     */     //   253: checkcast java/util/Map
/*     */     //   256: invokespecial <init> : (Ljava/util/Map;)V
/*     */     //   259: putfield foodConstantPatch : Ldev/jab125/minimega/mod/util/controller/MinigameAbilities$FoodConstantPatch;
/*     */     //   262: aload_1
/*     */     //   263: aload_0
/*     */     //   264: invokevirtual getMinigameData : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;
/*     */     //   267: invokevirtual config : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;
/*     */     //   270: astore #4
/*     */     //   272: aload #4
/*     */     //   274: instanceof dev/jab125/minimega/mod/util/minigamedata/BattleConfig
/*     */     //   277: ifeq -> 308
/*     */     //   280: aload #4
/*     */     //   282: checkcast dev/jab125/minimega/mod/util/minigamedata/BattleConfig
/*     */     //   285: astore_3
/*     */     //   286: aload_3
/*     */     //   287: invokevirtual settings : ()Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*     */     //   290: astore #5
/*     */     //   292: aload #5
/*     */     //   294: astore_2
/*     */     //   295: aload_2
/*     */     //   296: invokeinterface takeEverything : ()Z
/*     */     //   301: ifeq -> 308
/*     */     //   304: iconst_1
/*     */     //   305: goto -> 309
/*     */     //   308: iconst_0
/*     */     //   309: putfield takeAll : Z
/*     */     //   312: aload_1
/*     */     //   313: iconst_1
/*     */     //   314: putfield showArmorInHud : Z
/*     */     //   317: aload_1
/*     */     //   318: iconst_1
/*     */     //   319: putfield primePlacedTnt : Z
/*     */     //   322: aload_1
/*     */     //   323: iconst_1
/*     */     //   324: putfield shorterLavaNextToSoulSand : Z
/*     */     //   327: aload_1
/*     */     //   328: aload_0
/*     */     //   329: invokevirtual getMinigameData : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;
/*     */     //   332: invokevirtual config : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;
/*     */     //   335: astore #4
/*     */     //   337: aload #4
/*     */     //   339: instanceof dev/jab125/minimega/mod/util/minigamedata/BattleConfig
/*     */     //   342: ifeq -> 373
/*     */     //   345: aload #4
/*     */     //   347: checkcast dev/jab125/minimega/mod/util/minigamedata/BattleConfig
/*     */     //   350: astore_3
/*     */     //   351: aload_3
/*     */     //   352: invokevirtual settings : ()Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*     */     //   355: astore #5
/*     */     //   357: aload #5
/*     */     //   359: astore_2
/*     */     //   360: aload_2
/*     */     //   361: invokeinterface smallInventory : ()Z
/*     */     //   366: ifeq -> 373
/*     */     //   369: iconst_1
/*     */     //   370: goto -> 374
/*     */     //   373: iconst_0
/*     */     //   374: putfield smallInventory : Z
/*     */     //   377: aload_1
/*     */     //   378: iconst_1
/*     */     //   379: putfield fjs : Z
/*     */     //   382: aload_1
/*     */     //   383: aload_0
/*     */     //   384: invokevirtual getMinigameData : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;
/*     */     //   387: invokevirtual config : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;
/*     */     //   390: astore #4
/*     */     //   392: aload #4
/*     */     //   394: instanceof dev/jab125/minimega/mod/util/minigamedata/BattleConfig
/*     */     //   397: ifeq -> 424
/*     */     //   400: aload #4
/*     */     //   402: checkcast dev/jab125/minimega/mod/util/minigamedata/BattleConfig
/*     */     //   405: astore_3
/*     */     //   406: aload_3
/*     */     //   407: invokevirtual settings : ()Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*     */     //   410: astore #5
/*     */     //   412: aload #5
/*     */     //   414: astore_2
/*     */     //   415: aload_2
/*     */     //   416: invokeinterface shortSneaking : ()Z
/*     */     //   421: ifne -> 428
/*     */     //   424: iconst_1
/*     */     //   425: goto -> 429
/*     */     //   428: iconst_0
/*     */     //   429: putfield oldCrouch : Z
/*     */     //   432: aload_1
/*     */     //   433: areturn
/*     */     //   434: astore_2
/*     */     //   435: new java/lang/MatchException
/*     */     //   438: dup
/*     */     //   439: aload_2
/*     */     //   440: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   443: aload_2
/*     */     //   444: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   447: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #150	-> 0
/*     */     //   #151	-> 5
/*     */     //   #152	-> 30
/*     */     //   #153	-> 47
/*     */     //   #154	-> 57
/*     */     //   #155	-> 64
/*     */     //   #156	-> 71
/*     */     //   #157	-> 78
/*     */     //   #158	-> 85
/*     */     //   #159	-> 93
/*     */     //   #160	-> 101
/*     */     //   #161	-> 108
/*     */     //   #162	-> 115
/*     */     //   #163	-> 122
/*     */     //   #153	-> 125
/*     */     //   #164	-> 128
/*     */     //   #165	-> 144
/*     */     //   #166	-> 153
/*     */     //   #167	-> 162
/*     */     //   #168	-> 171
/*     */     //   #169	-> 180
/*     */     //   #172	-> 189
/*     */     //   #173	-> 198
/*     */     //   #174	-> 207
/*     */     //   #175	-> 216
/*     */     //   #164	-> 219
/*     */     //   #176	-> 222
/*     */     //   #153	-> 232
/*     */     //   #176	-> 245
/*     */     //   #177	-> 262
/*     */     //   #178	-> 312
/*     */     //   #179	-> 317
/*     */     //   #180	-> 322
/*     */     //   #181	-> 327
/*     */     //   #182	-> 377
/*     */     //   #183	-> 382
/*     */     //   #184	-> 432
/*     */     //   #183	-> 434
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   295	13	2	settings	Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*     */     //   360	13	2	settings	Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*     */     //   415	9	2	settings	Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*     */     //   428	1	2	settings	Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*     */     //   5	429	1	minigameAbilities	Ldev/jab125/minimega/mod/util/controller/MinigameAbilities;
/*     */     //   0	448	0	this	Ldev/jab125/minimega/mod/util/controller/battle/BattleMinigameController;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   287	290	434	java/lang/Throwable
/*     */     //   352	355	434	java/lang/Throwable
/*     */     //   407	410	434	java/lang/Throwable
/*     */   }
/*     */   
/*     */   private <T extends HasWeight> T getWeightedRandomKit(List<T> kits, RandomSource random) {
/*     */     int totalWeight = kits.stream().filter(a -> a.weight().isPresent()).mapToInt(a -> ((Integer)a.weight().orElseThrow()).intValue()).sum();
/*     */     int r = random.nextInt(totalWeight);
/*     */     for (HasWeight hasWeight : kits) {
/*     */       r -= ((Integer)hasWeight.weight().orElseThrow()).intValue();
/*     */       if (r < 0)
/*     */         return (T)hasWeight; 
/*     */     } 
/*     */     throw new IllegalStateException("No kit selected");
/*     */   }
/*     */   
/*     */   protected void tick() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield controller : Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */     //   4: invokevirtual getLevel : ()Lnet/minecraft/server/level/ServerLevel;
/*     */     //   7: astore_1
/*     */     //   8: aload_0
/*     */     //   9: invokespecial tick : ()V
/*     */     //   12: aload_0
/*     */     //   13: getfield controller : Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */     //   16: invokevirtual dirty : ()V
/*     */     //   19: aload_0
/*     */     //   20: getfield stage : I
/*     */     //   23: ifne -> 37
/*     */     //   26: aload_0
/*     */     //   27: iconst_1
/*     */     //   28: putfield stage : I
/*     */     //   31: aload_0
/*     */     //   32: aload_1
/*     */     //   33: iconst_0
/*     */     //   34: invokevirtual distributeItems : (Lnet/minecraft/server/level/ServerLevel;Z)V
/*     */     //   37: aload_0
/*     */     //   38: getfield stage : I
/*     */     //   41: iconst_1
/*     */     //   42: if_icmpne -> 291
/*     */     //   45: aload_0
/*     */     //   46: invokevirtual hasEnoughPlayers : ()Z
/*     */     //   49: ifeq -> 266
/*     */     //   52: aload_0
/*     */     //   53: getfield timer : I
/*     */     //   56: ifgt -> 128
/*     */     //   59: aload_0
/*     */     //   60: sipush #600
/*     */     //   63: putfield timer : I
/*     */     //   66: aload_0
/*     */     //   67: iconst_2
/*     */     //   68: putfield stage : I
/*     */     //   71: aload_0
/*     */     //   72: getfield controller : Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */     //   75: aload_1
/*     */     //   76: invokevirtual getPlayersFor : (Lnet/minecraft/server/level/ServerLevel;)[Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   79: astore_2
/*     */     //   80: aload_2
/*     */     //   81: astore_3
/*     */     //   82: aload_3
/*     */     //   83: arraylength
/*     */     //   84: istore #4
/*     */     //   86: iconst_0
/*     */     //   87: istore #5
/*     */     //   89: iload #5
/*     */     //   91: iload #4
/*     */     //   93: if_icmpge -> 119
/*     */     //   96: aload_3
/*     */     //   97: iload #5
/*     */     //   99: aaload
/*     */     //   100: astore #6
/*     */     //   102: aload #6
/*     */     //   104: ldc_w 'Grace period start!'
/*     */     //   107: invokestatic literal : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*     */     //   110: invokestatic sendTopMessage : (Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/network/chat/Component;)V
/*     */     //   113: iinc #5, 1
/*     */     //   116: goto -> 89
/*     */     //   119: aload_0
/*     */     //   120: aload_2
/*     */     //   121: arraylength
/*     */     //   122: putfield startingOutPlayers : I
/*     */     //   125: goto -> 273
/*     */     //   128: aload_0
/*     */     //   129: getfield controller : Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */     //   132: aload_1
/*     */     //   133: invokevirtual getPlayersFor : (Lnet/minecraft/server/level/ServerLevel;)[Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   136: astore_2
/*     */     //   137: aload_2
/*     */     //   138: arraylength
/*     */     //   139: istore_3
/*     */     //   140: iconst_0
/*     */     //   141: istore #4
/*     */     //   143: iload #4
/*     */     //   145: iload_3
/*     */     //   146: if_icmpge -> 190
/*     */     //   149: aload_2
/*     */     //   150: iload #4
/*     */     //   152: aaload
/*     */     //   153: astore #5
/*     */     //   155: aload #5
/*     */     //   157: invokevirtual isDeadOrDying : ()Z
/*     */     //   160: ifne -> 184
/*     */     //   163: aload #5
/*     */     //   165: instanceof net/minecraft/server/level/ServerPlayer
/*     */     //   168: ifne -> 174
/*     */     //   171: goto -> 184
/*     */     //   174: aload #5
/*     */     //   176: aload #5
/*     */     //   178: invokevirtual getMaxHealth : ()F
/*     */     //   181: invokevirtual setHealth : (F)V
/*     */     //   184: iinc #4, 1
/*     */     //   187: goto -> 143
/*     */     //   190: aload_0
/*     */     //   191: dup
/*     */     //   192: getfield timer : I
/*     */     //   195: iconst_1
/*     */     //   196: isub
/*     */     //   197: putfield timer : I
/*     */     //   200: aload_0
/*     */     //   201: getfield timer : I
/*     */     //   204: bipush #20
/*     */     //   206: irem
/*     */     //   207: ifne -> 273
/*     */     //   210: aload_0
/*     */     //   211: getfield controller : Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */     //   214: aload_1
/*     */     //   215: invokevirtual getPlayersFor : (Lnet/minecraft/server/level/ServerLevel;)[Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   218: astore_2
/*     */     //   219: aload_2
/*     */     //   220: arraylength
/*     */     //   221: istore_3
/*     */     //   222: iconst_0
/*     */     //   223: istore #4
/*     */     //   225: iload #4
/*     */     //   227: iload_3
/*     */     //   228: if_icmpge -> 263
/*     */     //   231: aload_2
/*     */     //   232: iload #4
/*     */     //   234: aaload
/*     */     //   235: astore #5
/*     */     //   237: aload #5
/*     */     //   239: aload_0
/*     */     //   240: getfield timer : I
/*     */     //   243: bipush #20
/*     */     //   245: idiv
/*     */     //   246: <illegal opcode> makeConcatWithConstants : (I)Ljava/lang/String;
/*     */     //   251: invokestatic literal : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*     */     //   254: invokestatic sendTopMessage : (Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/network/chat/Component;)V
/*     */     //   257: iinc #4, 1
/*     */     //   260: goto -> 225
/*     */     //   263: goto -> 273
/*     */     //   266: aload_0
/*     */     //   267: sipush #400
/*     */     //   270: putfield timer : I
/*     */     //   273: aload_0
/*     */     //   274: new dev/jab125/minimega/mod/util/controller/event/TimerTickEvent
/*     */     //   277: dup
/*     */     //   278: getstatic dev/jab125/minimega/mod/util/controller/event/TimerTickEvent.ROUND_START_TIMER : Lnet/minecraft/resources/Identifier;
/*     */     //   281: aload_0
/*     */     //   282: getfield timer : I
/*     */     //   285: invokespecial <init> : (Lnet/minecraft/resources/Identifier;I)V
/*     */     //   288: invokevirtual fireEvent : (Ldev/jab125/minimega/mod/util/controller/event/Event;)V
/*     */     //   291: aload_0
/*     */     //   292: getfield stage : I
/*     */     //   295: iconst_2
/*     */     //   296: if_icmpne -> 563
/*     */     //   299: aload_0
/*     */     //   300: getfield timer : I
/*     */     //   303: ifgt -> 410
/*     */     //   306: aload_0
/*     */     //   307: aload_0
/*     */     //   308: invokevirtual getMinigameData : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;
/*     */     //   311: invokevirtual config : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;
/*     */     //   314: astore #4
/*     */     //   316: aload #4
/*     */     //   318: instanceof dev/jab125/minimega/mod/util/minigamedata/BattleConfig
/*     */     //   321: ifeq -> 351
/*     */     //   324: aload #4
/*     */     //   326: checkcast dev/jab125/minimega/mod/util/minigamedata/BattleConfig
/*     */     //   329: astore_3
/*     */     //   330: aload_3
/*     */     //   331: invokevirtual settings : ()Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*     */     //   334: astore #5
/*     */     //   336: aload #5
/*     */     //   338: astore_2
/*     */     //   339: aload_2
/*     */     //   340: invokeinterface roundLength : ()Ldev/jab125/minimega/mod/util/minigamedata/battle/RoundLength;
/*     */     //   345: invokevirtual getRoundLengthInTicks : ()I
/*     */     //   348: goto -> 354
/*     */     //   351: sipush #300
/*     */     //   354: putfield timer : I
/*     */     //   357: aload_0
/*     */     //   358: getfield controller : Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */     //   361: aload_1
/*     */     //   362: invokevirtual getPlayersFor : (Lnet/minecraft/server/level/ServerLevel;)[Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   365: astore_2
/*     */     //   366: aload_2
/*     */     //   367: astore_3
/*     */     //   368: aload_3
/*     */     //   369: arraylength
/*     */     //   370: istore #4
/*     */     //   372: iconst_0
/*     */     //   373: istore #5
/*     */     //   375: iload #5
/*     */     //   377: iload #4
/*     */     //   379: if_icmpge -> 405
/*     */     //   382: aload_3
/*     */     //   383: iload #5
/*     */     //   385: aaload
/*     */     //   386: astore #6
/*     */     //   388: aload #6
/*     */     //   390: ldc_w 'Round start!'
/*     */     //   393: invokestatic literal : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*     */     //   396: invokestatic sendTopMessage : (Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/network/chat/Component;)V
/*     */     //   399: iinc #5, 1
/*     */     //   402: goto -> 375
/*     */     //   405: aload_0
/*     */     //   406: iconst_3
/*     */     //   407: putfield stage : I
/*     */     //   410: aload_0
/*     */     //   411: getfield controller : Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */     //   414: aload_1
/*     */     //   415: invokevirtual getPlayersFor : (Lnet/minecraft/server/level/ServerLevel;)[Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   418: astore_2
/*     */     //   419: aload_2
/*     */     //   420: arraylength
/*     */     //   421: istore_3
/*     */     //   422: iconst_0
/*     */     //   423: istore #4
/*     */     //   425: iload #4
/*     */     //   427: iload_3
/*     */     //   428: if_icmpge -> 472
/*     */     //   431: aload_2
/*     */     //   432: iload #4
/*     */     //   434: aaload
/*     */     //   435: astore #5
/*     */     //   437: aload #5
/*     */     //   439: invokevirtual isDeadOrDying : ()Z
/*     */     //   442: ifne -> 466
/*     */     //   445: aload #5
/*     */     //   447: instanceof net/minecraft/server/level/ServerPlayer
/*     */     //   450: ifne -> 456
/*     */     //   453: goto -> 466
/*     */     //   456: aload #5
/*     */     //   458: aload #5
/*     */     //   460: invokevirtual getMaxHealth : ()F
/*     */     //   463: invokevirtual setHealth : (F)V
/*     */     //   466: iinc #4, 1
/*     */     //   469: goto -> 425
/*     */     //   472: aload_0
/*     */     //   473: dup
/*     */     //   474: getfield timer : I
/*     */     //   477: iconst_1
/*     */     //   478: isub
/*     */     //   479: putfield timer : I
/*     */     //   482: aload_0
/*     */     //   483: getfield timer : I
/*     */     //   486: bipush #20
/*     */     //   488: irem
/*     */     //   489: ifne -> 545
/*     */     //   492: aload_0
/*     */     //   493: getfield controller : Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */     //   496: aload_1
/*     */     //   497: invokevirtual getPlayersFor : (Lnet/minecraft/server/level/ServerLevel;)[Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   500: astore_2
/*     */     //   501: aload_2
/*     */     //   502: arraylength
/*     */     //   503: istore_3
/*     */     //   504: iconst_0
/*     */     //   505: istore #4
/*     */     //   507: iload #4
/*     */     //   509: iload_3
/*     */     //   510: if_icmpge -> 545
/*     */     //   513: aload_2
/*     */     //   514: iload #4
/*     */     //   516: aaload
/*     */     //   517: astore #5
/*     */     //   519: aload #5
/*     */     //   521: aload_0
/*     */     //   522: getfield timer : I
/*     */     //   525: bipush #20
/*     */     //   527: idiv
/*     */     //   528: <illegal opcode> makeConcatWithConstants : (I)Ljava/lang/String;
/*     */     //   533: invokestatic literal : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*     */     //   536: invokestatic sendTopMessage : (Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/network/chat/Component;)V
/*     */     //   539: iinc #4, 1
/*     */     //   542: goto -> 507
/*     */     //   545: aload_0
/*     */     //   546: new dev/jab125/minimega/mod/util/controller/event/TimerTickEvent
/*     */     //   549: dup
/*     */     //   550: getstatic dev/jab125/minimega/mod/util/controller/event/TimerTickEvent.GRACE_PERIOD_END_TIMER : Lnet/minecraft/resources/Identifier;
/*     */     //   553: aload_0
/*     */     //   554: getfield timer : I
/*     */     //   557: invokespecial <init> : (Lnet/minecraft/resources/Identifier;I)V
/*     */     //   560: invokevirtual fireEvent : (Ldev/jab125/minimega/mod/util/controller/event/Event;)V
/*     */     //   563: aload_0
/*     */     //   564: getfield stage : I
/*     */     //   567: iconst_3
/*     */     //   568: if_icmpne -> 1040
/*     */     //   571: aload_0
/*     */     //   572: dup
/*     */     //   573: getfield timer : I
/*     */     //   576: iconst_1
/*     */     //   577: isub
/*     */     //   578: putfield timer : I
/*     */     //   581: aload_0
/*     */     //   582: new dev/jab125/minimega/mod/util/controller/event/TimerTickEvent
/*     */     //   585: dup
/*     */     //   586: getstatic dev/jab125/minimega/mod/util/controller/event/TimerTickEvent.MAIN_GAME_TIMER : Lnet/minecraft/resources/Identifier;
/*     */     //   589: aload_0
/*     */     //   590: getfield timer : I
/*     */     //   593: invokespecial <init> : (Lnet/minecraft/resources/Identifier;I)V
/*     */     //   596: invokevirtual fireEvent : (Ldev/jab125/minimega/mod/util/controller/event/Event;)V
/*     */     //   599: aload_0
/*     */     //   600: getfield timer : I
/*     */     //   603: sipush #1200
/*     */     //   606: irem
/*     */     //   607: ifne -> 721
/*     */     //   610: aload_0
/*     */     //   611: invokevirtual getMinigameData : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;
/*     */     //   614: invokevirtual config : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;
/*     */     //   617: astore #4
/*     */     //   619: aload #4
/*     */     //   621: instanceof dev/jab125/minimega/mod/util/minigamedata/BattleConfig
/*     */     //   624: ifeq -> 651
/*     */     //   627: aload #4
/*     */     //   629: checkcast dev/jab125/minimega/mod/util/minigamedata/BattleConfig
/*     */     //   632: astore_2
/*     */     //   633: aload_2
/*     */     //   634: invokevirtual settings : ()Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*     */     //   637: astore #5
/*     */     //   639: aload #5
/*     */     //   641: astore_3
/*     */     //   642: aload_3
/*     */     //   643: invokeinterface chestRefill : ()Z
/*     */     //   648: ifeq -> 721
/*     */     //   651: aload_0
/*     */     //   652: aload_1
/*     */     //   653: iconst_1
/*     */     //   654: invokevirtual distributeItems : (Lnet/minecraft/server/level/ServerLevel;Z)V
/*     */     //   657: aload_0
/*     */     //   658: getfield controller : Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */     //   661: aload_1
/*     */     //   662: invokevirtual getPlayersFor : (Lnet/minecraft/server/level/ServerLevel;)[Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   665: astore #4
/*     */     //   667: aload #4
/*     */     //   669: arraylength
/*     */     //   670: istore #5
/*     */     //   672: iconst_0
/*     */     //   673: istore #6
/*     */     //   675: iload #6
/*     */     //   677: iload #5
/*     */     //   679: if_icmpge -> 721
/*     */     //   682: aload #4
/*     */     //   684: iload #6
/*     */     //   686: aaload
/*     */     //   687: astore #7
/*     */     //   689: aload #7
/*     */     //   691: getfield connection : Lnet/minecraft/server/network/ServerGamePacketListenerImpl;
/*     */     //   694: invokestatic getInstance : ()Ldev/jab125/minimega/mod/abstractions/networking/ServerNetworking;
/*     */     //   697: new dev/jab125/minimega/mod/networking/payload/S2CStatusPayload
/*     */     //   700: dup
/*     */     //   701: getstatic dev/jab125/minimega/mod/networking/payload/S2CStatusPayload$Status.MINIGAME_CHEST : Ldev/jab125/minimega/mod/networking/payload/S2CStatusPayload$Status;
/*     */     //   704: invokespecial <init> : (Ldev/jab125/minimega/mod/networking/payload/S2CStatusPayload$Status;)V
/*     */     //   707: invokeinterface play : (Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;)Lnet/minecraft/network/protocol/Packet;
/*     */     //   712: invokevirtual send : (Lnet/minecraft/network/protocol/Packet;)V
/*     */     //   715: iinc #6, 1
/*     */     //   718: goto -> 675
/*     */     //   721: aload_0
/*     */     //   722: getfield timer : I
/*     */     //   725: sipush #1200
/*     */     //   728: if_icmpge -> 798
/*     */     //   731: aload_0
/*     */     //   732: getfield timer : I
/*     */     //   735: bipush #20
/*     */     //   737: irem
/*     */     //   738: ifne -> 798
/*     */     //   741: aload_0
/*     */     //   742: invokevirtual tryStartShowdown : ()V
/*     */     //   745: aload_0
/*     */     //   746: getfield controller : Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */     //   749: aload_1
/*     */     //   750: invokevirtual getPlayersFor : (Lnet/minecraft/server/level/ServerLevel;)[Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   753: astore_2
/*     */     //   754: aload_2
/*     */     //   755: arraylength
/*     */     //   756: istore_3
/*     */     //   757: iconst_0
/*     */     //   758: istore #4
/*     */     //   760: iload #4
/*     */     //   762: iload_3
/*     */     //   763: if_icmpge -> 798
/*     */     //   766: aload_2
/*     */     //   767: iload #4
/*     */     //   769: aaload
/*     */     //   770: astore #5
/*     */     //   772: aload #5
/*     */     //   774: aload_0
/*     */     //   775: getfield timer : I
/*     */     //   778: bipush #20
/*     */     //   780: idiv
/*     */     //   781: <illegal opcode> makeConcatWithConstants : (I)Ljava/lang/String;
/*     */     //   786: invokestatic literal : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*     */     //   789: invokestatic sendTopMessage : (Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/network/chat/Component;)V
/*     */     //   792: iinc #4, 1
/*     */     //   795: goto -> 760
/*     */     //   798: aload_0
/*     */     //   799: getfield controller : Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */     //   802: aload_1
/*     */     //   803: invokevirtual getPlayersFor : (Lnet/minecraft/server/level/ServerLevel;)[Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   806: invokestatic stream : ([Ljava/lang/Object;)Ljava/util/stream/Stream;
/*     */     //   809: <illegal opcode> test : ()Ljava/util/function/Predicate;
/*     */     //   814: invokeinterface filter : (Ljava/util/function/Predicate;)Ljava/util/stream/Stream;
/*     */     //   819: astore_2
/*     */     //   820: aload_2
/*     */     //   821: <illegal opcode> apply : ()Ljava/util/function/IntFunction;
/*     */     //   826: invokeinterface toArray : (Ljava/util/function/IntFunction;)[Ljava/lang/Object;
/*     */     //   831: checkcast [Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   834: astore_3
/*     */     //   835: aload_0
/*     */     //   836: getfield startingOutPlayers : I
/*     */     //   839: iconst_2
/*     */     //   840: if_icmple -> 853
/*     */     //   843: aload_3
/*     */     //   844: arraylength
/*     */     //   845: iconst_2
/*     */     //   846: if_icmpgt -> 853
/*     */     //   849: aload_0
/*     */     //   850: invokevirtual tryStartShowdown : ()V
/*     */     //   853: invokestatic getInstance : ()Ldev/jab125/minimega/mod/abstractions/modloader/ModLoader;
/*     */     //   856: invokeinterface isDevelopmentEnvironment : ()Z
/*     */     //   861: ifne -> 1021
/*     */     //   864: aload_3
/*     */     //   865: arraylength
/*     */     //   866: iconst_1
/*     */     //   867: if_icmpgt -> 1021
/*     */     //   870: aload_3
/*     */     //   871: arraylength
/*     */     //   872: iconst_1
/*     */     //   873: if_icmpne -> 885
/*     */     //   876: aload_3
/*     */     //   877: iconst_0
/*     */     //   878: aaload
/*     */     //   879: invokestatic of : (Ljava/lang/Object;)Ljava/util/Optional;
/*     */     //   882: goto -> 888
/*     */     //   885: invokestatic empty : ()Ljava/util/Optional;
/*     */     //   888: astore #4
/*     */     //   890: aload #4
/*     */     //   892: invokevirtual isPresent : ()Z
/*     */     //   895: ifeq -> 1006
/*     */     //   898: aload #4
/*     */     //   900: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   903: checkcast net/minecraft/server/level/ServerPlayer
/*     */     //   906: astore #5
/*     */     //   908: aload #5
/*     */     //   910: checkcast dev/jab125/minimega/mod/extension/PlayerExtension
/*     */     //   913: invokeinterface mm$setFirstMarker : ()V
/*     */     //   918: aload_0
/*     */     //   919: getfield controller : Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */     //   922: aload_1
/*     */     //   923: invokevirtual getPlayersFor : (Lnet/minecraft/server/level/ServerLevel;)[Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   926: astore #6
/*     */     //   928: aload #6
/*     */     //   930: arraylength
/*     */     //   931: istore #7
/*     */     //   933: iconst_0
/*     */     //   934: istore #8
/*     */     //   936: iload #8
/*     */     //   938: iload #7
/*     */     //   940: if_icmpge -> 1006
/*     */     //   943: aload #6
/*     */     //   945: iload #8
/*     */     //   947: aaload
/*     */     //   948: astore #9
/*     */     //   950: aload #9
/*     */     //   952: getfield connection : Lnet/minecraft/server/network/ServerGamePacketListenerImpl;
/*     */     //   955: invokestatic getInstance : ()Ldev/jab125/minimega/mod/abstractions/networking/ServerNetworking;
/*     */     //   958: new dev/jab125/minimega/mod/networking/payload/S2CDisplayShieldPayload
/*     */     //   961: dup
/*     */     //   962: ldc_w 'minimega:battle/battle'
/*     */     //   965: invokestatic parse : (Ljava/lang/String;)Lnet/minecraft/resources/Identifier;
/*     */     //   968: ldc_w 'minimega.playerWon'
/*     */     //   971: iconst_1
/*     */     //   972: anewarray java/lang/Object
/*     */     //   975: dup
/*     */     //   976: iconst_0
/*     */     //   977: aload #5
/*     */     //   979: invokevirtual nameAndId : ()Lnet/minecraft/server/players/NameAndId;
/*     */     //   982: invokevirtual name : ()Ljava/lang/String;
/*     */     //   985: aastore
/*     */     //   986: invokestatic translatable : (Ljava/lang/String;[Ljava/lang/Object;)Lnet/minecraft/network/chat/MutableComponent;
/*     */     //   989: invokespecial <init> : (Lnet/minecraft/resources/Identifier;Lnet/minecraft/network/chat/Component;)V
/*     */     //   992: invokeinterface play : (Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;)Lnet/minecraft/network/protocol/Packet;
/*     */     //   997: invokevirtual send : (Lnet/minecraft/network/protocol/Packet;)V
/*     */     //   1000: iinc #8, 1
/*     */     //   1003: goto -> 936
/*     */     //   1006: aload_0
/*     */     //   1007: iconst_5
/*     */     //   1008: putfield stage : I
/*     */     //   1011: aload_0
/*     */     //   1012: sipush #219
/*     */     //   1015: putfield timer : I
/*     */     //   1018: goto -> 1040
/*     */     //   1021: aload_0
/*     */     //   1022: getfield timer : I
/*     */     //   1025: ifgt -> 1040
/*     */     //   1028: aload_0
/*     */     //   1029: iconst_5
/*     */     //   1030: putfield stage : I
/*     */     //   1033: aload_0
/*     */     //   1034: sipush #200
/*     */     //   1037: putfield timer : I
/*     */     //   1040: aload_0
/*     */     //   1041: getfield stage : I
/*     */     //   1044: iconst_5
/*     */     //   1045: if_icmpne -> 1283
/*     */     //   1048: aload_0
/*     */     //   1049: getfield timer : I
/*     */     //   1052: bipush #20
/*     */     //   1054: irem
/*     */     //   1055: ifne -> 1111
/*     */     //   1058: aload_0
/*     */     //   1059: getfield controller : Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */     //   1062: aload_1
/*     */     //   1063: invokevirtual getPlayersFor : (Lnet/minecraft/server/level/ServerLevel;)[Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   1066: astore_2
/*     */     //   1067: aload_2
/*     */     //   1068: arraylength
/*     */     //   1069: istore_3
/*     */     //   1070: iconst_0
/*     */     //   1071: istore #4
/*     */     //   1073: iload #4
/*     */     //   1075: iload_3
/*     */     //   1076: if_icmpge -> 1111
/*     */     //   1079: aload_2
/*     */     //   1080: iload #4
/*     */     //   1082: aaload
/*     */     //   1083: astore #5
/*     */     //   1085: aload #5
/*     */     //   1087: aload_0
/*     */     //   1088: getfield timer : I
/*     */     //   1091: bipush #20
/*     */     //   1093: idiv
/*     */     //   1094: <illegal opcode> makeConcatWithConstants : (I)Ljava/lang/String;
/*     */     //   1099: invokestatic literal : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*     */     //   1102: invokestatic sendTopMessage : (Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/network/chat/Component;)V
/*     */     //   1105: iinc #4, 1
/*     */     //   1108: goto -> 1073
/*     */     //   1111: aload_0
/*     */     //   1112: dup
/*     */     //   1113: getfield timer : I
/*     */     //   1116: iconst_1
/*     */     //   1117: isub
/*     */     //   1118: putfield timer : I
/*     */     //   1121: aload_0
/*     */     //   1122: getfield timer : I
/*     */     //   1125: ifgt -> 1283
/*     */     //   1128: aload_0
/*     */     //   1129: getfield controller : Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */     //   1132: aload_1
/*     */     //   1133: invokevirtual getPlayersFor : (Lnet/minecraft/server/level/ServerLevel;)[Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   1136: astore_2
/*     */     //   1137: aload_0
/*     */     //   1138: getfield letPlayersKnow : Z
/*     */     //   1141: ifne -> 1199
/*     */     //   1144: aload_2
/*     */     //   1145: astore_3
/*     */     //   1146: aload_3
/*     */     //   1147: arraylength
/*     */     //   1148: istore #4
/*     */     //   1150: iconst_0
/*     */     //   1151: istore #5
/*     */     //   1153: iload #5
/*     */     //   1155: iload #4
/*     */     //   1157: if_icmpge -> 1191
/*     */     //   1160: aload_3
/*     */     //   1161: iload #5
/*     */     //   1163: aaload
/*     */     //   1164: astore #6
/*     */     //   1166: aload_0
/*     */     //   1167: aload_0
/*     */     //   1168: getstatic dev/jab125/minimega/mod/util/Minigame.LOBBY : Ldev/jab125/minimega/mod/util/Minigame;
/*     */     //   1171: ldc_w 'lobby'
/*     */     //   1174: invokestatic id : (Ljava/lang/String;)Lnet/minecraft/resources/Identifier;
/*     */     //   1177: invokevirtual getMapInfo : (Ldev/jab125/minimega/mod/util/Minigame;Lnet/minecraft/resources/Identifier;)Ldev/jab125/minimega/mod/data/MapInfo;
/*     */     //   1180: aload #6
/*     */     //   1182: invokevirtual mapTransitionScreen : (Ldev/jab125/minimega/mod/data/MapInfo;Lnet/minecraft/server/level/ServerPlayer;)V
/*     */     //   1185: iinc #5, 1
/*     */     //   1188: goto -> 1153
/*     */     //   1191: aload_0
/*     */     //   1192: iconst_1
/*     */     //   1193: putfield letPlayersKnow : Z
/*     */     //   1196: goto -> 1266
/*     */     //   1199: aload_1
/*     */     //   1200: invokevirtual getServer : ()Lnet/minecraft/server/MinecraftServer;
/*     */     //   1203: aload_0
/*     */     //   1204: invokevirtual getMinigameData : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;
/*     */     //   1207: invokestatic createLobbyWithMinigame : (Lnet/minecraft/server/MinecraftServer;Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;)Lnet/minecraft/server/level/ServerLevel;
/*     */     //   1210: astore_3
/*     */     //   1211: aload_3
/*     */     //   1212: invokestatic getMinigameController : (Lnet/minecraft/world/level/Level;)Ldev/jab125/minimega/mod/util/controller/MinigamesController;
/*     */     //   1215: getstatic dev/jab125/minimega/mod/util/Minigame.LOBBY : Ldev/jab125/minimega/mod/util/Minigame;
/*     */     //   1218: invokevirtual getController : (Ldev/jab125/minimega/mod/util/Minigame;)Ldev/jab125/minimega/mod/util/controller/AbstractMinigameController;
/*     */     //   1221: checkcast dev/jab125/minimega/mod/util/controller/lobby/LobbyMinigameController
/*     */     //   1224: astore #4
/*     */     //   1226: aload_1
/*     */     //   1227: invokevirtual getServer : ()Lnet/minecraft/server/MinecraftServer;
/*     */     //   1230: checkcast dev/jab125/minimega/mod/extension/MinecraftServerExtension
/*     */     //   1233: aload_1
/*     */     //   1234: invokeinterface getLevelParty : (Lnet/minecraft/server/level/ServerLevel;)Ljava/util/Optional;
/*     */     //   1239: astore #5
/*     */     //   1241: aload #5
/*     */     //   1243: aload_3
/*     */     //   1244: <illegal opcode> accept : (Lnet/minecraft/server/level/ServerLevel;)Ljava/util/function/Consumer;
/*     */     //   1249: invokevirtual ifPresent : (Ljava/util/function/Consumer;)V
/*     */     //   1252: aload_1
/*     */     //   1253: invokevirtual getServer : ()Lnet/minecraft/server/MinecraftServer;
/*     */     //   1256: invokestatic get : (Lnet/minecraft/server/MinecraftServer;)Lxyz/nucleoid/fantasy/Fantasy;
/*     */     //   1259: aload_1
/*     */     //   1260: invokevirtual tickDeleteLevel : (Lnet/minecraft/server/level/ServerLevel;)Z
/*     */     //   1263: ifeq -> 1266
/*     */     //   1266: goto -> 1283
/*     */     //   1269: astore_2
/*     */     //   1270: new java/lang/MatchException
/*     */     //   1273: dup
/*     */     //   1274: aload_2
/*     */     //   1275: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1278: aload_2
/*     */     //   1279: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   1282: athrow
/*     */     //   1283: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #203	-> 0
/*     */     //   #204	-> 8
/*     */     //   #205	-> 12
/*     */     //   #206	-> 19
/*     */     //   #207	-> 26
/*     */     //   #208	-> 31
/*     */     //   #210	-> 37
/*     */     //   #211	-> 45
/*     */     //   #212	-> 52
/*     */     //   #213	-> 59
/*     */     //   #214	-> 66
/*     */     //   #215	-> 71
/*     */     //   #216	-> 80
/*     */     //   #217	-> 102
/*     */     //   #216	-> 113
/*     */     //   #219	-> 119
/*     */     //   #220	-> 125
/*     */     //   #221	-> 128
/*     */     //   #222	-> 155
/*     */     //   #223	-> 174
/*     */     //   #221	-> 184
/*     */     //   #225	-> 190
/*     */     //   #226	-> 200
/*     */     //   #227	-> 210
/*     */     //   #228	-> 237
/*     */     //   #227	-> 257
/*     */     //   #233	-> 266
/*     */     //   #235	-> 273
/*     */     //   #237	-> 291
/*     */     //   #238	-> 299
/*     */     //   #239	-> 306
/*     */     //   #240	-> 357
/*     */     //   #241	-> 366
/*     */     //   #242	-> 388
/*     */     //   #241	-> 399
/*     */     //   #244	-> 405
/*     */     //   #246	-> 410
/*     */     //   #247	-> 437
/*     */     //   #248	-> 456
/*     */     //   #246	-> 466
/*     */     //   #250	-> 472
/*     */     //   #251	-> 482
/*     */     //   #252	-> 492
/*     */     //   #253	-> 519
/*     */     //   #252	-> 539
/*     */     //   #256	-> 545
/*     */     //   #258	-> 563
/*     */     //   #259	-> 571
/*     */     //   #260	-> 581
/*     */     //   #261	-> 599
/*     */     //   #262	-> 610
/*     */     //   #263	-> 651
/*     */     //   #264	-> 657
/*     */     //   #265	-> 689
/*     */     //   #264	-> 715
/*     */     //   #269	-> 721
/*     */     //   #270	-> 741
/*     */     //   #271	-> 745
/*     */     //   #272	-> 772
/*     */     //   #271	-> 792
/*     */     //   #275	-> 798
/*     */     //   #276	-> 820
/*     */     //   #277	-> 835
/*     */     //   #278	-> 853
/*     */     //   #279	-> 870
/*     */     //   #280	-> 890
/*     */     //   #281	-> 898
/*     */     //   #282	-> 908
/*     */     //   #283	-> 918
/*     */     //   #284	-> 950
/*     */     //   #283	-> 1000
/*     */     //   #287	-> 1006
/*     */     //   #288	-> 1011
/*     */     //   #289	-> 1018
/*     */     //   #290	-> 1028
/*     */     //   #291	-> 1033
/*     */     //   #294	-> 1040
/*     */     //   #295	-> 1048
/*     */     //   #296	-> 1058
/*     */     //   #297	-> 1085
/*     */     //   #296	-> 1105
/*     */     //   #300	-> 1111
/*     */     //   #301	-> 1121
/*     */     //   #302	-> 1128
/*     */     //   #303	-> 1137
/*     */     //   #304	-> 1144
/*     */     //   #305	-> 1166
/*     */     //   #304	-> 1185
/*     */     //   #307	-> 1191
/*     */     //   #309	-> 1199
/*     */     //   #310	-> 1211
/*     */     //   #311	-> 1226
/*     */     //   #312	-> 1241
/*     */     //   #313	-> 1252
/*     */     //   #317	-> 1266
/*     */     //   #262	-> 1269
/*     */     //   #319	-> 1283
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   102	11	6	player	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   80	45	2	players	[Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   155	29	5	serverPlayer	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   237	20	5	player	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   339	12	2	settings	Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*     */     //   388	11	6	player	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   366	44	2	players	[Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   437	29	5	serverPlayer	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   519	20	5	player	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   642	9	3	settings	Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*     */     //   689	26	7	player	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   772	20	5	player	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   950	50	9	player	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   908	98	5	serverPlayer	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   890	128	4	any	Ljava/util/Optional;
/*     */     //   820	220	2	serverPlayerStream	Ljava/util/stream/Stream;
/*     */     //   835	205	3	array	[Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   1085	20	5	player	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   1166	19	6	player	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   1211	55	3	lobby	Lnet/minecraft/server/level/ServerLevel;
/*     */     //   1226	40	4	lobbyController	Ldev/jab125/minimega/mod/util/controller/lobby/LobbyMinigameController;
/*     */     //   1241	25	5	levelParty	Ljava/util/Optional;
/*     */     //   1137	129	2	players	[Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   8	1261	1	level	Lnet/minecraft/server/level/ServerLevel;
/*     */     //   0	1284	0	this	Ldev/jab125/minimega/mod/util/controller/battle/BattleMinigameController;
/*     */     //   1283	1	1	level	Lnet/minecraft/server/level/ServerLevel;
/*     */     // Local variable type table:
/*     */     //   start	length	slot	name	signature
/*     */     //   890	128	4	any	Ljava/util/Optional<Lnet/minecraft/server/level/ServerPlayer;>;
/*     */     //   820	220	2	serverPlayerStream	Ljava/util/stream/Stream<Lnet/minecraft/server/level/ServerPlayer;>;
/*     */     //   1241	25	5	levelParty	Ljava/util/Optional<Ldev/jab125/minimega/mod/party/MinigameParty;>;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   331	334	1269	java/lang/Throwable
/*     */     //   634	637	1269	java/lang/Throwable
/*     */   }
/*     */   
/*     */   private void distributeItems(ServerLevel level, boolean update) {
/*     */     Objects.requireNonNull(getGameRules().getLevelRules().flatStreamOf(DistributeItems.class));
/*     */     for (Iterator<?> iterator = getGameRules().getLevelRules().flatStreamOf(DistributeItems.class)::iterator.iterator(); iterator.hasNext(); ) {
/*     */       DistributeItems distributeItems = (DistributeItems)iterator.next();
/*     */       Objects.requireNonNull(distributeItems.flatStreamOf(WorldPosition.class));
/*     */       for (WorldPosition worldPosition : distributeItems.flatStreamOf(WorldPosition.class)::iterator) {
/*     */         BlockEntity blockEntity = level.getBlockEntity(new BlockPos(worldPosition.x(), worldPosition.y(), worldPosition.z()));
/*     */         LootSet normal = ((LootSets)lootSets.join()).streamOf(LootSet.class).filter(a -> {
/*     */               // Byte code:
/*     */               //   0: aload_2
/*     */               //   1: invokevirtual name : ()Ljava/lang/String;
/*     */               //   4: aload_0
/*     */               //   5: invokevirtual getMinigameData : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;
/*     */               //   8: invokevirtual config : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;
/*     */               //   11: dup
/*     */               //   12: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */               //   15: pop
/*     */               //   16: astore_3
/*     */               //   17: iconst_0
/*     */               //   18: istore #4
/*     */               //   20: aload_3
/*     */               //   21: iload #4
/*     */               //   23: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;I)I
/*     */               //   28: lookupswitch default -> 148, 0 -> 48
/*     */               //   48: aload_3
/*     */               //   49: checkcast dev/jab125/minimega/mod/util/minigamedata/BattleConfig
/*     */               //   52: astore #5
/*     */               //   54: aload #5
/*     */               //   56: invokevirtual settings : ()Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*     */               //   59: astore #8
/*     */               //   61: aload #8
/*     */               //   63: astore #6
/*     */               //   65: aload #6
/*     */               //   67: invokeinterface itemSet : ()Ldev/jab125/minimega/mod/util/minigamedata/battle/ItemSet;
/*     */               //   72: dup
/*     */               //   73: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */               //   76: pop
/*     */               //   77: astore #8
/*     */               //   79: iconst_0
/*     */               //   80: istore #9
/*     */               //   82: aload #8
/*     */               //   84: iload #9
/*     */               //   86: <illegal opcode> enumSwitch : (Ldev/jab125/minimega/mod/util/minigamedata/battle/ItemSet;I)I
/*     */               //   91: lookupswitch default -> 136, 0 -> 108
/*     */               //   108: invokestatic values : ()[Ldev/jab125/minimega/mod/util/minigamedata/battle/ItemSet;
/*     */               //   111: new java/util/Random
/*     */               //   114: dup
/*     */               //   115: aload_1
/*     */               //   116: invokevirtual hashCode : ()I
/*     */               //   119: i2l
/*     */               //   120: invokespecial <init> : (J)V
/*     */               //   123: invokestatic values : ()[Ldev/jab125/minimega/mod/util/minigamedata/battle/ItemSet;
/*     */               //   126: arraylength
/*     */               //   127: iconst_2
/*     */               //   128: isub
/*     */               //   129: invokevirtual nextInt : (I)I
/*     */               //   132: aaload
/*     */               //   133: goto -> 142
/*     */               //   136: aload #8
/*     */               //   138: astore #7
/*     */               //   140: aload #7
/*     */               //   142: invokevirtual getId : ()Ljava/lang/String;
/*     */               //   145: goto -> 151
/*     */               //   148: ldc_w 'Normal'
/*     */               //   151: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */               //   154: ireturn
/*     */               //   155: astore_3
/*     */               //   156: new java/lang/MatchException
/*     */               //   159: dup
/*     */               //   160: aload_3
/*     */               //   161: invokevirtual toString : ()Ljava/lang/String;
/*     */               //   164: aload_3
/*     */               //   165: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */               //   168: athrow
/*     */               // Line number table:
/*     */               //   Java source line number -> byte code offset
/*     */               //   #327	-> 0
/*     */               //   #326	-> 1
/*     */               //   #327	-> 48
/*     */               //   #328	-> 108
/*     */               //   #329	-> 136
/*     */               //   #330	-> 142
/*     */               //   #331	-> 148
/*     */               //   #326	-> 151
/*     */               //   #327	-> 154
/*     */               // Local variable table:
/*     */               //   start	length	slot	name	descriptor
/*     */               //   61	4	8	patt3$temp	Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*     */               //   140	2	7	s	Ldev/jab125/minimega/mod/util/minigamedata/battle/ItemSet;
/*     */               //   79	63	8	selector4$temp	Ldev/jab125/minimega/mod/util/minigamedata/battle/ItemSet;
/*     */               //   82	60	9	index$5	I
/*     */               //   54	94	5	$b$0	Ldev/jab125/minimega/mod/util/minigamedata/BattleConfig;
/*     */               //   65	83	6	settings	Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*     */               //   17	134	3	selector1$temp	Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;
/*     */               //   20	131	4	index$2	I
/*     */               //   0	169	0	this	Ldev/jab125/minimega/mod/util/controller/battle/BattleMinigameController;
/*     */               //   0	169	1	level	Lnet/minecraft/server/level/ServerLevel;
/*     */               //   0	169	2	a	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/LootSet;
/*     */               // Exception table:
/*     */               //   from	to	target	type
/*     */               //   56	59	155	java/lang/Throwable
/*     */             }).findFirst().orElseThrow();
/*     */         LootGroup group = normal.streamOf(LootGroup.class).filter(a -> ((update && a.name().equals("UpdateItems")) ? "StartItems" : a.name()).equals(distributeItems.id())).findFirst().orElseThrow();
/*     */         ArrayList<Kit> list = new ArrayList<>(group.streamOf(Kit.class).toList());
/*     */         Collections.shuffle(list);
/*     */         ArrayList<ChestItem> w = new ArrayList<>(group.streamOf(ChestItem.class).toList());
/*     */         Collections.shuffle(w);
/*     */         int availableKpScore = group.kpScore();
/*     */         ObjectArrayList<ItemStack> itemStacks = new ObjectArrayList();
/*     */         List<Kit> available = new ArrayList<>(list);
/*     */         Item.PotionBalancer potionBalancer = (resourceKey, splash) -> {
/*     */             String string = resourceKey.identifier().toString();
/*     */             if (splash) {
/*     */               switch (string) {
/*     */                 case "minecraft:weakness":
/*     */                 
/*     */                 case "minecraft:slowness":
/*     */                 
/*     */                 case "minecraft:poison":
/*     */                 
/*     */                 case "minecraft:strong_poison":
/*     */                 
/*     */               } 
/*     */               return null;
/*     */             } 
/*     */             switch (string) {
/*     */               case "minecraft:fire_resistance":
/*     */               
/*     */               case "minecraft:strength":
/*     */               
/*     */               case "minecraft:regeneration":
/*     */               
/*     */               case "minecraft:swiftness":
/*     */               
/*     */               case "minecraft:strong_leaping":
/*     */               
/*     */               case "minecraft:invisibility":
/*     */               
/*     */             } 
/*     */             return null;
/*     */           };
/*     */         while (!available.isEmpty()) {
/*     */           Kit selected = getWeightedRandomKit(available, level.getRandom());
/*     */           if (availableKpScore - selected.kpScore() >= 0) {
/*     */             selected.flatStreamOf(Item.class).forEach(item -> itemStacks.add(item.createItemStack(level.registryAccess(), potionBalancer)));
/*     */             availableKpScore -= selected.kpScore();
/*     */           } 
/*     */           available.remove(selected);
/*     */         } 
/*     */         for (ChestItem imXmls : w) {
/*     */           Optional<Integer> i = imXmls.kpScore();
/*     */           if (!i.isEmpty() && availableKpScore - ((Integer)i.get()).intValue() >= 0) {
/*     */             imXmls.flatStreamOf(Item.class).forEach(item -> itemStacks.add(item.createItemStack(level.registryAccess(), potionBalancer)));
/*     */             availableKpScore -= ((Integer)i.get()).intValue();
/*     */           } 
/*     */         } 
/*     */         if (blockEntity instanceof RandomizableContainer) {
/*     */           RandomizableContainer container = (RandomizableContainer)blockEntity;
/*     */           if (!container.getEntitiesWithContainerOpen().isEmpty())
/*     */             return; 
/*     */           container.clearContent();
/*     */           LETSGOGAMBLING.fill((Container)container, itemStacks, level.getRandom());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void tryStartShowdown() {
/*     */     if (this.alreadyShowdowned)
/*     */       return; 
/*     */     this.alreadyShowdowned = true;
/*     */     fireEvent((Event)new ShowdownEvent());
/*     */     ServerLevel level = this.controller.getLevel();
/*     */     for (ServerPlayer player : this.controller.getPlayersFor(level)) {
/*     */       player.connection.send(ServerNetworking.getInstance().play((CustomPacketPayload)new S2CDisplayShieldPayload(Identifier.parse("minimega:time_icon"), (Component)Component.translatable("minimega.showdown"))));
/*     */       if (player.isAlive() && player.gameMode() != GameType.SPECTATOR)
/*     */         player.setGlowingTag(true); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean hasEnoughPlayers() {
/*     */     int playerCount = this.controller.getLevel().players().size();
/*     */     return ModLoader.getInstance().isDevelopmentEnvironment() ? ((playerCount >= 1)) : ((playerCount >= 2));
/*     */   }
/*     */   
/*     */   public <R extends Throwable> MinigameRules getRules() throws R {
/*     */     if (this.stage == 1 || this.stage == 0)
/*     */       return new MinigameRules(new MinigameRules.DestroyPermissions(MinigameRules.Mode.WHITELIST), new MinigameRules.PlacePermissions(MinigameRules.Mode.WHITELIST), new MinigameRules.UsePermissions(MinigameRules.Mode.WHITELIST, List.of()), new MinigameRules.BlockUsePermissions(MinigameRules.Mode.WHITELIST, List.of()), new MinigameRules.Timers(), new MinigameRules.Sounds(), this.alreadyShowdowned); 
/*     */     return new MinigameRules(new MinigameRules.DestroyPermissions(MinigameRules.Mode.BLACKLIST), new MinigameRules.PlacePermissions(MinigameRules.Mode.BLACKLIST), new MinigameRules.UsePermissions(MinigameRules.Mode.BLACKLIST, List.of()), new MinigameRules.BlockUsePermissions(MinigameRules.Mode.BLACKLIST, List.of()), new MinigameRules.Timers(), new MinigameRules.Sounds(), this.alreadyShowdowned);
/*     */   }
/*     */   
/*     */   public void readNbt(CompoundTag tag) {
/*     */     super.readNbt(tag);
/*     */     this.stage = ((Integer)tag.getInt("stage").orElse(Integer.valueOf(0))).intValue();
/*     */     this.theme = ((Integer)tag.getInt("theme").orElse(Integer.valueOf(0))).intValue();
/*     */     this.alreadyShowdowned = tag.getBooleanOr("alreadyShowdowned", false);
/*     */   }
/*     */   
/*     */   public void writeNbt(CompoundTag tag) {
/*     */     super.writeNbt(tag);
/*     */     tag.putInt("stage", this.stage);
/*     */     tag.putInt("theme", this.theme);
/*     */     tag.putBoolean("alreadyShowdowned", this.alreadyShowdowned);
/*     */   }
/*     */   
/*     */   public int getTheme() {
/*     */     return this.theme;
/*     */   }
/*     */   
/*     */   public int getStage() {
/*     */     return this.stage;
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\controller\battle\BattleMinigameController.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */