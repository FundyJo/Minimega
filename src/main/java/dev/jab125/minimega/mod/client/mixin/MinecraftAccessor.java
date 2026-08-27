package dev.jab125.minimega.mod.client.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.BlockModelResolver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({Minecraft.class})
public interface MinecraftAccessor {
  @Accessor
  BlockModelResolver getBlockModelResolver();
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\MinecraftAccessor.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */