/*    */ package dev.jab125.minimega.mod.client.mixin.bobby;
/*    */ 
/*    */ import de.johni0702.minecraft.bobby.FakeChunkManager;
/*    */ import dev.jab125.minimega.mod.client.extension.FakeChunkManagerExtension;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
/*    */ import net.minecraft.client.multiplayer.ClientChunkCache;
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.chunk.LevelChunk;
/*    */ import net.minecraft.world.level.chunk.status.ChunkStatus;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({ClientChunkCache.class})
/*    */ public class ClientChunkMixin
/*    */ {
/*    */   @Inject(method = {"getChunk(IILnet/minecraft/world/level/chunk/status/ChunkStatus;Z)Lnet/minecraft/world/level/chunk/LevelChunk;"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void create(int i, int j, ChunkStatus chunkStatus, boolean bl, CallbackInfoReturnable<LevelChunk> cir) throws NoSuchFieldException, IllegalAccessException {
/* 26 */     FakeChunkManager bobbyChunkManager = (FakeChunkManager)ClientChunkCache.class.getDeclaredField("bobbyChunkManager").get(this);
/* 27 */     if (bobbyChunkManager == null)
/* 28 */       return;  ((FakeChunkManagerExtension)bobbyChunkManager).attemptInit();
/*    */   } @Shadow
/*    */   @Final
/*    */   private ClientLevel level;
/*    */   @Inject(method = {"getLoadedEmptySections"}, at = {@At("HEAD")}, cancellable = true)
/*    */   public void getLoadedEmptySections(CallbackInfoReturnable<LongOpenHashSet> cir) {
/* 34 */     if (MinigamesController.getMinigameController((Level)this.level).isActive()) cir.setReturnValue(new LongOpenHashSet()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\bobby\ClientChunkMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */