/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import net.minecraft.world.level.ChunkPos;
/*    */ import net.minecraft.world.level.chunk.storage.ChunkIOErrorReporter;
/*    */ import net.minecraft.world.level.chunk.storage.RegionStorageInfo;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Overwrite;
/*    */ 
/*    */ @Mixin({ChunkIOErrorReporter.class})
/*    */ public interface ChunkIOErrorReporter {
/*    */   @Overwrite
/*    */   default void reportMisplacedChunk(ChunkPos storedPos, ChunkPos requestedPos, RegionStorageInfo storageInfo) {
/* 13 */     Minimega.LOGGER.error("Chunk at stored pos" + String.valueOf(storedPos) + " does not match chunk at " + String.valueOf(requestedPos));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\ChunkIOErrorReporter.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */