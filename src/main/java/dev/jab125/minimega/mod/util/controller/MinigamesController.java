/*     */ package dev.jab125.minimega.mod.util.controller;
/*     */ import com.mojang.serialization.Codec;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.__ROOT__;
/*     */ import dev.jab125.minimega.mod.Minimega;
/*     */ import dev.jab125.minimega.mod.annotations.ServerSide;
/*     */ import dev.jab125.minimega.mod.util.Minigame;
/*     */ import dev.jab125.minimega.mod.util.MinigameFoodConstant;
/*     */ import dev.jab125.minimega.mod.util.controller.obj.MinigameRules;
/*     */ import dev.jab125.minimega.mod.util.minigamedata.MinigameData;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Optional;
/*     */ import java.util.function.Supplier;
/*     */ import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
/*     */ import net.fabricmc.fabric.api.attachment.v1.AttachmentSyncPredicate;
/*     */ import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.codec.ByteBufCodecs;
/*     */ import net.minecraft.network.codec.StreamCodec;
/*     */ import net.minecraft.resources.Identifier;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.world.level.Level;
/*     */ 
/*     */ public class MinigamesController {
/*     */   public static final Codec<MinigamesController> CODEC;
/*     */   
/*     */   static {
/*  30 */     CODEC = CompoundTag.CODEC.xmap(a -> {
/*     */           MinigamesController minigamesController = new MinigamesController();
/*     */           minigamesController.readNbt(a);
/*     */           return minigamesController;
/*     */         }a -> {
/*     */           CompoundTag compoundTag = new CompoundTag();
/*     */           a.writeNbt(compoundTag);
/*     */           return compoundTag;
/*     */         });
/*  39 */   } public static final StreamCodec<ByteBuf, MinigamesController> STREAM_CODEC = ByteBufCodecs.fromCodec(CODEC); public static final AttachmentType<MinigamesController> ATTACHMENT_TYPE;
/*     */   static {
/*  41 */     ATTACHMENT_TYPE = AttachmentRegistry.create(Minimega.id("minigame_data"), c -> c.initializer(MinigamesController::new).syncWith(STREAM_CODEC, AttachmentSyncPredicate.all()));
/*     */   }
/*     */   
/*  44 */   private Minigame<?> activeMinigame = Minigame.NONE;
/*  45 */   private AbstractMinigameController minigameController = Minigame.NONE.newController(this); private Level level;
/*     */   
/*     */   public void writeNbt(CompoundTag tag) {
/*  48 */     tag.putInt("activeMinigame", this.activeMinigame.getId());
/*  49 */     CompoundTag compoundTag = new CompoundTag();
/*  50 */     this.minigameController.writeNbt(compoundTag);
/*  51 */     tag.put("minigameController", (Tag)compoundTag);
/*     */   }
/*     */   
/*     */   public void readNbt(CompoundTag tag) {
/*  55 */     this.activeMinigame = Minigame.fromId(((Integer)tag.getInt("activeMinigame").orElse(Integer.valueOf(0))).intValue());
/*  56 */     CompoundTag compoundTag = tag.getCompound("minigameController").orElseThrow();
/*  57 */     this.minigameController = this.activeMinigame.newController(this);
/*  58 */     this.minigameController.readNbt(compoundTag);
/*     */   }
/*     */ 
/*     */   
/*     */   public <T extends AbstractMinigameController<T>> T getController(Minigame<T> minigame) {
/*  63 */     if (this.activeMinigame != minigame) return null; 
/*  64 */     return (T)this.minigameController;
/*     */   }
/*     */   
/*     */   public <T extends AbstractMinigameController<T>> Optional<T> getControllerOpt(Minigame<T> minigame) {
/*  68 */     if (this.activeMinigame != minigame) return Optional.empty(); 
/*  69 */     return Optional.ofNullable((T)this.minigameController);
/*     */   }
/*     */   
/*     */   public Minigame<?> getActiveMinigame() {
/*  73 */     return this.activeMinigame;
/*     */   }
/*     */   
/*     */   public boolean glideActive() {
/*  77 */     return (getActiveMinigame() == Minigame.GLIDE);
/*     */   }
/*     */   
/*     */   public boolean isLobby() {
/*  81 */     return (getActiveMinigame() == Minigame.LOBBY);
/*     */   }
/*     */   
/*     */   public boolean isActive() {
/*  85 */     Minigame<?> activeMinigame = getActiveMinigame();
/*  86 */     return (activeMinigame != null && activeMinigame != Minigame.NONE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MinigamesController getMinigameController(Level level) {
/*  93 */     if (level == null)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  99 */       return new MinigamesController();
/*     */     }
/* 101 */     MinigamesController attachedOrCreate = (MinigamesController)level.getAttachedOrCreate(ATTACHMENT_TYPE);
/* 102 */     attachedOrCreate.level = level;
/* 103 */     return attachedOrCreate;
/*     */   }
/*     */   
/*     */   public static __ROOT__ getGameRules(Level level) {
/* 107 */     return (getMinigameController(level)).minigameController.getGameRules();
/*     */   }
/*     */   
/*     */   public void dirty() {
/* 111 */     if (this.level != null) { this.level.setAttached(ATTACHMENT_TYPE, this); }
/* 112 */     else { Minimega.LOGGER.warn("No level!?!?"); }
/*     */   
/*     */   }
/*     */   public <T extends AbstractMinigameController<T>> T setActiveMinigame(Minigame<T> minigame) {
/* 116 */     this.activeMinigame = minigame;
/* 117 */     this.minigameController = minigame.newController(this);
/* 118 */     dirty();
/* 119 */     return (T)this.minigameController;
/*     */   }
/*     */   
/*     */   @ServerSide
/*     */   public ServerLevel getLevel() {
/* 124 */     return (ServerLevel)this.level;
/*     */   }
/*     */   
/*     */   public <T extends Throwable> MinigameRules getRules() throws T {
/*     */     try {
/* 129 */       return this.minigameController.getRules();
/* 130 */     } catch (Throwable t) {
/* 131 */       throw (T)t;
/*     */     } 
/*     */   }
/*     */   
/*     */   public ServerPlayer[] getPlayersFor(ServerLevel level) {
/* 136 */     ArrayList<ServerPlayer> players = new ArrayList<>();
/* 137 */     for (ServerPlayer player : level.getServer().getPlayerList().getPlayers()) {
/* 138 */       if (player.level() == level) players.add(player); 
/*     */     } 
/* 140 */     return (ServerPlayer[])players.toArray(x$0 -> new ServerPlayer[x$0]);
/*     */   }
/*     */   
/*     */   public void playerLoadedIn(ServerPlayer player) {
/* 144 */     this.minigameController.playerLoadedIn(player);
/*     */   }
/*     */   
/*     */   public boolean hideNearbyPlayers() {
/* 148 */     return this.minigameController.hideNearbyPlayers();
/*     */   }
/*     */   
/*     */   public boolean pvpEnabled() {
/* 152 */     return this.minigameController.pvpEnabled();
/*     */   }
/*     */   
/*     */   public MinigameData getMinigameData() {
/* 156 */     return this.minigameController.getMinigameData();
/*     */   }
/*     */   
/*     */   public boolean canAcceptNewPlayers() {
/* 160 */     return this.minigameController.canAcceptNewPlayers();
/*     */   }
/*     */   
/*     */   public boolean isSmallInventory() {
/* 164 */     return this.minigameController.isSmallInventory();
/*     */   }
/*     */   
/*     */   public static ServerLevel lobbyOf(MinecraftServer server, MinigameData data) {
/* 168 */     return Minimega.createLobbyWithMinigame(server, data);
/*     */   }
/*     */   
/*     */   public boolean hasPlayers() {
/* 172 */     return ((getPlayersFor(getLevel())).length > 0);
/*     */   }
/*     */   
/*     */   public void playerReady(ServerPlayer player, boolean ready) {
/* 176 */     this.minigameController.playerReady(player, ready);
/*     */   }
/*     */   
/*     */   public void playerVoted(ServerPlayer player, Identifier resourceLocation) {
/* 180 */     this.minigameController.playerVoted(player, resourceLocation);
/*     */   }
/*     */   
/*     */   public int getFoodConstantI(MinigameFoodConstant foodConstant) {
/* 184 */     return this.minigameController.getFoodConstantI(foodConstant);
/*     */   }
/*     */   
/*     */   public float getFoodConstantF(MinigameFoodConstant foodConstant) {
/* 188 */     return this.minigameController.getFoodConstantF(foodConstant);
/*     */   }
/*     */   
/*     */   public boolean movementDisabled() {
/* 192 */     return this.minigameController.movementDisabled();
/*     */   }
/*     */   
/*     */   public boolean isClient() {
/* 196 */     return this.level.isClientSide();
/*     */   }
/*     */   
/*     */   public boolean takeAllEnabled() {
/* 200 */     return this.minigameController.takeAllEnabled();
/*     */   }
/*     */   
/*     */   public MinigameAbilities minigameAbilities() {
/* 204 */     return this.minigameController.minigameAbilities();
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\controller\MinigamesController.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */