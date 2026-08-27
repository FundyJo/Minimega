package dev.jab125.minimega.mod.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({MinecraftServer.class})
public class ExampleMixin {
  @Inject(at = {@At("HEAD")}, method = {"loadLevel"})
  private void init(CallbackInfo info) {}
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\ExampleMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */