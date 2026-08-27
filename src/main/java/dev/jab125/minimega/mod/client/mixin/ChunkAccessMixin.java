package dev.jab125.minimega.mod.client.mixin;

import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.chunk.ChunkAccess;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({ChunkAccess.class})
public abstract class ChunkAccessMixin implements LevelHeightAccessor {
  @Shadow
  @Final
  protected ChunkPos chunkPos;
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\ChunkAccessMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */