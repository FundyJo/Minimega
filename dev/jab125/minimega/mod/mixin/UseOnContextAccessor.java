package dev.jab125.minimega.mod.mixin;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin({UseOnContext.class})
public interface UseOnContextAccessor {
  @Invoker
  BlockHitResult callGetHitResult();
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\UseOnContextAccessor.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */