package dev.jab125.minimega.mod.client.mixin.glide;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(targets = {"net/minecraft/client/particle/FireworkParticles$SparkParticle"})
public interface FireworkParticlesAccessor {
  @Invoker
  void callSetTrail(boolean paramBoolean);
  
  @Invoker
  void callSetTwinkle(boolean paramBoolean);
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\glide\FireworkParticlesAccessor.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */