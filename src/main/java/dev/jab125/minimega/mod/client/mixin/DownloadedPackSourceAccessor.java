package dev.jab125.minimega.mod.client.mixin;

import net.minecraft.client.resources.server.DownloadedPackSource;
import net.minecraft.client.resources.server.ServerPackManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({DownloadedPackSource.class})
public interface DownloadedPackSourceAccessor {
  @Accessor
  ServerPackManager getManager();
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\DownloadedPackSourceAccessor.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */