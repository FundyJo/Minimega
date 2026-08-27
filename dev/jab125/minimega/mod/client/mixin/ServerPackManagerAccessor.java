package dev.jab125.minimega.mod.client.mixin;

import java.util.List;
import net.minecraft.client.resources.server.ServerPackManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({ServerPackManager.class})
public interface ServerPackManagerAccessor {
  @Accessor
  List getPacks();
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\ServerPackManagerAccessor.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */