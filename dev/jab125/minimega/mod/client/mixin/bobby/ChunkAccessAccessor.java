package dev.jab125.minimega.mod.client.mixin.bobby;

import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.lighting.ChunkSkyLightSources;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({ChunkAccess.class})
public interface ChunkAccessAccessor {
  @Accessor
  ChunkSkyLightSources getSkyLightSources();
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\bobby\ChunkAccessAccessor.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */