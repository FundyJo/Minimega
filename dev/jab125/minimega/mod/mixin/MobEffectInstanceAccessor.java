package dev.jab125.minimega.mod.mixin;

import net.minecraft.world.effect.MobEffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({MobEffectInstance.class})
public interface MobEffectInstanceAccessor {
  @Accessor
  void setDuration(int paramInt);
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\MobEffectInstanceAccessor.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */