/*     */ package dev.jab125.minimega.mod.util.controller.fistfight;
/*     */ 
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.DropperY;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.FistfightFlag;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.LevelRules;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.UpdatePlayer;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.__ROOT__;
/*     */ import dev.jab125.minimega.mod.Minimega;
/*     */ import dev.jab125.minimega.mod.abstractions.modloader.ModLoader;
/*     */ import dev.jab125.minimega.mod.abstractions.networking.ServerNetworking;
/*     */ import dev.jab125.minimega.mod.networking.payload.S2CDisplayShieldPayload;
/*     */ import dev.jab125.minimega.mod.party.MinigameParty;
/*     */ import dev.jab125.minimega.mod.util.Minigame;
/*     */ import dev.jab125.minimega.mod.util.controller.MinigameAbilities;
/*     */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*     */ import dev.jab125.minimega.mod.util.controller.event.Event;
/*     */ import dev.jab125.minimega.mod.util.controller.event.TimerTickEvent;
/*     */ import dev.jab125.minimega.mod.util.controller.lobby.LobbyMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.obj.MinigameRules;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.OptionalDouble;
/*     */ import java.util.function.Function;
/*     */ import java.util.stream.Stream;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.RegistryAccess;
/*     */ import net.minecraft.core.Vec3i;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*     */ import net.minecraft.resources.Identifier;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.ai.behavior.ShufflingList;
/*     */ import net.minecraft.world.entity.item.ItemEntity;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.component.BlocksAttacks;
/*     */ import net.minecraft.world.level.GameType;
/*     */ import net.minecraft.world.level.Level;
/*     */ 
/*     */ public class FistfightMinigameController extends AbstractMinigameController<FistfightMinigameController> {
/*     */   private List<UpdatePlayer> updatePlayers;
/*     */   private OptionalDouble dropperY;
/*     */   private int fistfightFlag;
/*     */   private static final Function<RegistryAccess, ShufflingList<ItemStack>> LIST;
/*     */   private static final Function<RegistryAccess, ShufflingList<ItemStack>> AQUATIC_LIST;
/*     */   private static final Function<RegistryAccess, ShufflingList<ItemStack>> SPECIAL_LIST;
/*     */   private int startingOutPlayers;
/*     */   
/*  54 */   public FistfightMinigameController(MinigamesController controller) { super(controller);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 314 */     this.alreadyShowdowned = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 361 */     this.stage = 0;
/* 362 */     this.timer = 400; }
/*     */   private boolean alreadyShowdowned;
/*     */   boolean letPlayersKnow; private int stage; private int timer; public static final int BEFORE_START = 0; public static final int MAIN_GAME = 1; public static final int FINISHED = 2; public Minigame<FistfightMinigameController> getMinigame() { return Minigame.FISTFIGHT; } public void accept(__ROOT__ obj) { super.accept(obj);
/*     */     LevelRules levelRules = obj.getLevelRules();
/*     */     this.updatePlayers = levelRules.streamOf(UpdatePlayer.class).toList();
/*     */     this.dropperY = levelRules.getFirstOf(DropperY.class).map(DropperY::y).map(OptionalDouble::of).orElseGet(OptionalDouble::empty);
/*     */     this.fistfightFlag = ((Integer)levelRules.getFirstOf(FistfightFlag.class).map(FistfightFlag::flag).orElse(Integer.valueOf(-1))).intValue(); } public int getFistfightFlag() {
/* 369 */     return this.fistfightFlag;
/*     */   }
/*     */   
/*     */   public void afterRespawn(MinigameParty.PlayerSlot slot, ServerPlayer oldPlayer, ServerPlayer newPlayer) {
/*     */     newPlayer.setGameMode(GameType.SPECTATOR);
/*     */   }
/*     */   
/*     */   public void acceptPlayer(MinigameParty.PlayerSlot slot) {
/*     */     MinigameParty party = slot.getParty();
/*     */     Optional<ServerPlayer> playerOpt = party.player(slot);
/*     */     if (playerOpt.isEmpty())
/*     */       return; 
/*     */     ServerPlayer player = playerOpt.get();
/*     */     player.getInventory().clearContent();
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
/*     */   public Vec3i spawnPos() {
/*     */     return (Vec3i)BlockPos.containing(((UpdatePlayer)this.updatePlayers.get(0)).spawnX(), ((UpdatePlayer)this.updatePlayers.get(0)).spawnY(), ((UpdatePlayer)this.updatePlayers.get(0)).spawnZ());
/*     */   }
/*     */   
/*     */   private Vec3i spawnPos(int player) {
/*     */     int index = player % this.updatePlayers.size();
/*     */     return (Vec3i)BlockPos.containing(((UpdatePlayer)this.updatePlayers.get(index)).spawnX(), ((UpdatePlayer)this.updatePlayers.get(index)).spawnY(), ((UpdatePlayer)this.updatePlayers.get(index)).spawnZ());
/*     */   }
/*     */   
/*     */   public UpdatePlayer updatePlayer(int slotIndex) {
/*     */     int index = slotIndex % this.updatePlayers.size();
/*     */     return this.updatePlayers.get(index);
/*     */   }
/*     */   
/*     */   public MinigameAbilities minigameAbilities() {
/*     */     MinigameAbilities minigameAbilities = super.minigameAbilities();
/*     */     minigameAbilities.pvpEnabled = (this.stage >= 1);
/*     */     return minigameAbilities;
/*     */   }
/*     */   
/*     */   static {
/*     */     LIST = (access -> (new ShufflingList()).add(ds(access, bl(access, Items.DIAMOND_SWORD.getDefaultInstance())), 13).add(ds(access, Items.DIAMOND_AXE.getDefaultInstance()), 3).add(ds4(access, Items.SHIELD.getDefaultInstance()), 8).add(Items.SNOWBALL.getDefaultInstance().copyWithCount(3), 30).add(Items.WIND_CHARGE.getDefaultInstance().copyWithCount(3), 30).add(Items.PORKCHOP.getDefaultInstance(), 30).add(Items.OAK_PLANKS.getDefaultInstance(), 70).add(ds2(access, Items.FLINT_AND_STEEL.getDefaultInstance()), 5).add(Items.DEEPSLATE.getDefaultInstance(), 30).add(Items.NETHERRACK.getDefaultInstance(), 30).add(Items.ARROW.getDefaultInstance().copyWithCount(5), 13).add(ds3(access, Items.CROSSBOW.getDefaultInstance()), 2).add(ds3(access, Items.BOW.getDefaultInstance()), 4).add(ds(access, Items.MACE.getDefaultInstance()), 2));
/*     */     AQUATIC_LIST = (access -> (new ShufflingList()).add(ds(access, bl(access, Items.DIAMOND_SWORD.getDefaultInstance())), 13).add(ds(access, Items.DIAMOND_AXE.getDefaultInstance()), 3).add(ds4(access, Items.SHIELD.getDefaultInstance()), 8).add(Items.WIND_CHARGE.getDefaultInstance().copyWithCount(3), 30).add(Items.COOKED_COD.getDefaultInstance(), 30).add(Items.OAK_PLANKS.getDefaultInstance(), 70).add(ds2(access, Items.TRIDENT.getDefaultInstance()), 5).add(Items.PRISMARINE_BRICKS.getDefaultInstance(), 30).add(Items.NETHERRACK.getDefaultInstance(), 30).add(Items.ARROW.getDefaultInstance().copyWithCount(5), 13).add(ds3(access, Items.CROSSBOW.getDefaultInstance()), 5).add(ds3(access, Items.GOLDEN_APPLE.getDefaultInstance()), 1).add(ds3(access, Items.MAGMA_BLOCK.getDefaultInstance()), 1).add(ds3(access, Items.BOW.getDefaultInstance()), 8).add(ds3(access, Items.WOODEN_PICKAXE.getDefaultInstance()), 4));
/*     */     SPECIAL_LIST = (access -> (new ShufflingList()).add(ds(access, bl(access, Items.DIAMOND_SWORD.getDefaultInstance())), 13).add(ds(access, Items.DIAMOND_AXE.getDefaultInstance()), 3).add(ds4(access, Items.SHIELD.getDefaultInstance()), 8).add(Items.SNOWBALL.getDefaultInstance().copyWithCount(3), 30).add(Items.WIND_CHARGE.getDefaultInstance().copyWithCount(3), 30).add(Items.PORKCHOP.getDefaultInstance(), 30).add(Items.OAK_PLANKS.getDefaultInstance(), 70).add(ds2(access, Items.FLINT_AND_STEEL.getDefaultInstance()), 5).add(Items.DEEPSLATE.getDefaultInstance(), 30).add(Items.NETHERRACK.getDefaultInstance(), 30).add(Items.ARROW.getDefaultInstance().copyWithCount(5), 13).add(ds3(access, Items.CROSSBOW.getDefaultInstance()), 2).add(ds3(access, Items.BOW.getDefaultInstance()), 4).add(ds3(access, Items.WOODEN_PICKAXE.getDefaultInstance()), 8).add(ds(access, Items.MACE.getDefaultInstance()), 2));
/*     */   }
/*     */   
/*     */   private static ItemStack ds4(RegistryAccess access, ItemStack defaultInstance) {
/*     */     int maxDamage = defaultInstance.getMaxDamage();
/*     */     defaultInstance.setDamageValue(maxDamage - 8);
/*     */     return defaultInstance;
/*     */   }
/*     */   
/*     */   private static ItemStack ds2(RegistryAccess access, ItemStack defaultInstance) {
/*     */     int maxDamage = defaultInstance.getMaxDamage();
/*     */     defaultInstance.setDamageValue(maxDamage - 30);
/*     */     return defaultInstance;
/*     */   }
/*     */   
/*     */   public static ItemStack bl(RegistryAccess access, ItemStack defaultInstance) {
/*     */     defaultInstance.applyComponents(DataComponentPatch.builder().set(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.0F, 0.0F, List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 0.5F)), new BlocksAttacks.ItemDamageFunction(0.0F, 0.0F, 0.0F), Optional.of(access.getOrThrow(DamageTypeTags.BYPASSES_SHIELD)), Optional.of(SoundEvents.SHIELD_BLOCK), Optional.of(SoundEvents.SHIELD_BREAK))).build());
/*     */     return defaultInstance;
/*     */   }
/*     */   
/*     */   private static ItemStack ds3(RegistryAccess access, ItemStack defaultInstance) {
/*     */     int maxDamage = defaultInstance.getMaxDamage();
/*     */     defaultInstance.setDamageValue(maxDamage - 5);
/*     */     return defaultInstance;
/*     */   }
/*     */   
/*     */   private static ItemStack ds(RegistryAccess access, ItemStack defaultInstance) {
/*     */     int maxDamage = defaultInstance.getMaxDamage();
/*     */     defaultInstance.setDamageValue(maxDamage - 1);
/*     */     return defaultInstance;
/*     */   }
/*     */   
/*     */   protected void tick() {
/*     */     ServerLevel level = this.controller.getLevel();
/*     */     super.tick();
/*     */     this.controller.dirty();
/*     */     if (this.stage == 0)
/*     */       if (hasEnoughPlayers()) {
/*     */         if (this.timer <= 0) {
/*     */           this.timer = getCosmeticId().getPath().contains("skywars") ? 240000 : 6000;
/*     */           this.stage = 1;
/*     */           ServerPlayer[] players = this.controller.getPlayersFor(level);
/*     */           for (ServerPlayer player : players)
/*     */             sendTopMessage(player, (Component)Component.translatable("minimega.roundStart")); 
/*     */           this.startingOutPlayers = players.length;
/*     */         } else {
/*     */           for (ServerPlayer serverPlayer : this.controller.getPlayersFor(level)) {
/*     */             if (!serverPlayer.isDeadOrDying() && serverPlayer instanceof ServerPlayer)
/*     */               serverPlayer.setHealth(serverPlayer.getMaxHealth()); 
/*     */           } 
/*     */           this.timer--;
/*     */           if (this.timer % 20 == 0)
/*     */             for (ServerPlayer player : this.controller.getPlayersFor(level)) {
/*     */               sendTopMessage(player, (Component)Component.translatable("minimega.timeToStart", new Object[] { Integer.valueOf(this.timer / 20) }));
/*     */             }  
/*     */         } 
/*     */         fireEvent((Event)new TimerTickEvent(TimerTickEvent.ROUND_START_TIMER, this.timer));
/*     */       } else {
/*     */         this.timer = 400;
/*     */       }  
/*     */     if (this.stage == 1) {
/*     */       this.timer--;
/*     */       if (this.timer % 20 == 0) {
/*     */         int x = (int)(Math.random() * 30.0D - 15.0D);
/*     */         int z = (int)(Math.random() * 30.0D - 15.0D);
/*     */         ItemStack data = ((ShufflingList)((getFistfightFlag() == 45) ? AQUATIC_LIST : ((getFistfightFlag() == 39) ? SPECIAL_LIST : LIST)).apply(level.registryAccess())).shuffle().iterator().next();
/*     */         ItemEntity itemEntity = new ItemEntity((Level)level, x, this.dropperY.orElseThrow(), z, data);
/*     */         itemEntity.addTag("irc");
/*     */         itemEntity.setGlowingTag(true);
/*     */         itemEntity.setDefaultPickUpDelay();
/*     */         level.addFreshEntity((Entity)itemEntity);
/*     */       } 
/*     */       if (this.timer < 1200 && this.timer % 20 == 0) {
/*     */         tryStartShowdown();
/*     */         for (ServerPlayer player : this.controller.getPlayersFor(level)) {
/*     */           sendTopMessage(player, (Component)Component.translatable("minimega.timeToRoundEnd", new Object[] { Integer.valueOf(this.timer / 20) }));
/*     */         } 
/*     */       } 
/*     */       fireEvent((Event)new TimerTickEvent(TimerTickEvent.MAIN_GAME_TIMER, this.timer));
/*     */       Stream<ServerPlayer> serverPlayerStream = Arrays.<ServerPlayer>stream(this.controller.getPlayersFor(level)).filter(a -> (a.isAlive() && a.gameMode.isSurvival()));
/*     */       ServerPlayer[] array = serverPlayerStream.<ServerPlayer>toArray(x$0 -> new ServerPlayer[x$0]);
/*     */       if (this.startingOutPlayers > 2 && array.length <= 2)
/*     */         tryStartShowdown(); 
/*     */       if (!ModLoader.getInstance().isDevelopmentEnvironment() && array.length <= 1) {
/*     */         Optional<ServerPlayer> any = (array.length == 1) ? Optional.<ServerPlayer>of(array[0]) : Optional.<ServerPlayer>empty();
/*     */         if (any.isPresent()) {
/*     */           ServerPlayer serverPlayer = any.get();
/*     */           ((PlayerExtension)serverPlayer).mm$setFirstMarker();
/*     */           for (ServerPlayer player : this.controller.getPlayersFor(level)) {
/*     */             player.connection.send(ServerNetworking.getInstance().play((CustomPacketPayload)new S2CDisplayShieldPayload(Identifier.parse("minimega:fistfight/fistfight"), (Component)Component.translatable("minimega.playerWon", new Object[] { serverPlayer.nameAndId().name() }))));
/*     */           } 
/*     */         } 
/*     */         this.stage = 2;
/*     */         this.timer = 219;
/*     */       } else if (this.timer <= 0) {
/*     */         this.stage = 2;
/*     */         this.timer = 200;
/*     */       } 
/*     */     } 
/*     */     if (this.stage == 2) {
/*     */       Iterable<Entity> allEntities = level.getAllEntities();
/*     */       ArrayList<Entity> e = new ArrayList<>();
/*     */       for (Entity allEntity : allEntities) {
/*     */         if (allEntity != null && allEntity.removeTag("irc"))
/*     */           e.add(allEntity); 
/*     */       } 
/*     */       for (Entity entity : e)
/*     */         entity.discard(); 
/*     */       if (this.timer % 20 == 0)
/*     */         for (ServerPlayer player : this.controller.getPlayersFor(level))
/*     */           sendTopMessage(player, (Component)Component.literal("Time to round end: " + this.timer / 20 + " seconds."));  
/*     */       this.timer--;
/*     */       if (this.timer <= 0) {
/*     */         ServerPlayer[] players = this.controller.getPlayersFor(level);
/*     */         if (!this.letPlayersKnow) {
/*     */           for (ServerPlayer player : players)
/*     */             mapTransitionScreen(getMapInfo(Minigame.LOBBY, Minimega.id("lobby")), player); 
/*     */           this.letPlayersKnow = true;
/*     */         } else {
/*     */           ServerLevel lobby = Minimega.createLobbyWithMinigame(level.getServer(), getMinigameData());
/*     */           LobbyMinigameController lobbyController = (LobbyMinigameController)MinigamesController.getMinigameController((Level)lobby).getController(Minigame.LOBBY);
/*     */           Optional<MinigameParty> levelParty = ((MinecraftServerExtension)level.getServer()).getLevelParty(level);
/*     */           levelParty.ifPresent(party -> party.transferToLevel(lobby));
/*     */           if (Fantasy.get(level.getServer()).tickDeleteLevel(level));
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
/*     */     if (this.stage == 0)
/*     */       return new MinigameRules(new MinigameRules.DestroyPermissions(MinigameRules.Mode.WHITELIST), new MinigameRules.PlacePermissions(MinigameRules.Mode.WHITELIST), new MinigameRules.UsePermissions(MinigameRules.Mode.WHITELIST, List.of()), new MinigameRules.BlockUsePermissions(MinigameRules.Mode.WHITELIST, List.of()), new MinigameRules.Timers(), new MinigameRules.Sounds(), this.alreadyShowdowned); 
/*     */     return new MinigameRules(new MinigameRules.DestroyPermissions(MinigameRules.Mode.BLACKLIST), new MinigameRules.PlacePermissions(MinigameRules.Mode.BLACKLIST), new MinigameRules.UsePermissions(MinigameRules.Mode.BLACKLIST, List.of()), new MinigameRules.BlockUsePermissions(MinigameRules.Mode.BLACKLIST, List.of()), new MinigameRules.Timers(), new MinigameRules.Sounds(), this.alreadyShowdowned);
/*     */   }
/*     */   
/*     */   public void readNbt(CompoundTag tag) {
/*     */     super.readNbt(tag);
/*     */     this.stage = ((Integer)tag.getInt("stage").orElse(Integer.valueOf(0))).intValue();
/*     */     this.alreadyShowdowned = tag.getBooleanOr("alreadyShowdowned", false);
/*     */   }
/*     */   
/*     */   public void writeNbt(CompoundTag tag) {
/*     */     super.writeNbt(tag);
/*     */     tag.putInt("stage", this.stage);
/*     */     tag.putBoolean("alreadyShowdowned", this.alreadyShowdowned);
/*     */   }
/*     */   
/*     */   public int getStage() {
/*     */     return this.stage;
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\controller\fistfight\FistfightMinigameController.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */