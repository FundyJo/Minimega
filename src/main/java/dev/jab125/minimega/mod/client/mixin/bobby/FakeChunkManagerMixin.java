/*     */ package dev.jab125.minimega.mod.client.mixin.bobby;
/*     */ 
/*     */ import de.johni0702.minecraft.bobby.FakeChunkManager;
/*     */ import de.johni0702.minecraft.bobby.FakeChunkStorage;
/*     */ import dev.jab125.minimega.mod.Minimega;
/*     */ import dev.jab125.minimega.mod.client.extension.FakeChunkManagerExtension;
/*     */ import dev.jab125.minimega.mod.client.worldgen.ClientsideChunkGenerator;
/*     */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*     */ import it.unimi.dsi.fastutil.longs.Long2ObjectArrayMap;
/*     */ import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
/*     */ import java.nio.file.Path;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import java.util.concurrent.CompletableFuture;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Supplier;
/*     */ import net.minecraft.client.multiplayer.ClientChunkCache;
/*     */ import net.minecraft.client.multiplayer.ClientLevel;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.world.level.ChunkPos;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.chunk.LevelChunk;
/*     */ import org.spongepowered.asm.mixin.Final;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Mutable;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mixin({FakeChunkManager.class})
/*     */ public abstract class FakeChunkManagerMixin
/*     */   implements FakeChunkManagerExtension
/*     */ {
/*     */   @Mutable
/*     */   @Shadow
/*     */   @Final
/*     */   private FakeChunkStorage storage;
/*     */   @Shadow
/*     */   @Final
/*     */   private Long2ObjectMap<LevelChunk> fakeChunks;
/*     */   @Shadow
/*     */   @Final
/*     */   private List<Function<ChunkPos, CompletableFuture<Optional<CompoundTag>>>> storages;
/*     */   @Shadow
/*     */   @Final
/*     */   private ClientLevel world;
/*     */   private ClientsideChunkGenerator generator;
/*  55 */   private Long2ObjectArrayMap<LevelChunk> map = new Long2ObjectArrayMap();
/*     */   
/*     */   private boolean inited;
/*     */ 
/*     */   
/*     */   @Shadow
/*     */   public abstract LevelChunk getChunk(int paramInt1, int paramInt2);
/*     */ 
/*     */   
/*     */   @Shadow
/*     */   public abstract Supplier<LevelChunk> save(LevelChunk paramLevelChunk);
/*     */ 
/*     */   
/*     */   @Inject(method = {"<init>"}, at = {@At("RETURN")})
/*     */   void init(ClientLevel world, ClientChunkCache clientChunkManager, CallbackInfo ci) {}
/*     */   
/*     */   void sto() {
/*  72 */     Minimega.LOGGER.info("Initing for " + String.valueOf(this.world));
/*  73 */     if (this.world == null)
/*  74 */       return;  FakeChunkStorage cavern = FakeChunkStorage.getFor(Path.of("cavern", new String[0]), false);
/*  75 */     MinigamesController minigameController = MinigamesController.getMinigameController((Level)this.world);
/*  76 */     if (this.generator == null) this.generator = ClientsideChunkGenerator.create(this.world, minigameController.getController(minigameController.getActiveMinigame()).getCosmeticId()); 
/*  77 */     this.storage = cavern;
/*  78 */     for (LevelChunk levelChunk : this.generator.getEntireMap().left()) {
/*  79 */       save(levelChunk);
/*     */     }
/*  81 */     Objects.requireNonNull(this.storage); this.storages.add(this.storage::loadTag);
/*     */   }
/*     */   
/*     */   boolean canInit() {
/*  85 */     MinigamesController minigameController = MinigamesController.getMinigameController((Level)this.world);
/*  86 */     if (minigameController == null) return false; 
/*  87 */     if (!minigameController.isActive()) return false; 
/*  88 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void attemptInit() {
/*  93 */     if (!this.inited && canInit()) {
/*  94 */       this.inited = true;
/*  95 */       sto();
/*     */     } 
/*     */   }
/*     */   @Inject(method = {"getChunk"}, at = {@At("HEAD")}, cancellable = true)
/*     */   void g(int x, int z, CallbackInfoReturnable<LevelChunk> cir) {
/* 100 */     attemptInit();
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
/*     */   private static long packInts(int firstInt, int secondInt) {
/* 114 */     long packed = firstInt << 32L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 120 */     packed |= secondInt & 0xFFFFFFFFL;
/*     */     
/* 122 */     return packed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int[] unpackInts(long packedLong) {
/* 128 */     int firstInt = (int)(packedLong >> 32L);
/*     */ 
/*     */ 
/*     */     
/* 132 */     int secondInt = (int)packedLong;
/*     */     
/* 134 */     return new int[] { firstInt, secondInt };
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\bobby\FakeChunkManagerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */