package dev.jab125.minimega.mod.client.mixin;

import java.util.List;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({Screen.class})
public interface ScreenAccessor {
  @Accessor
  List<Renderable> getRenderables();
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\ScreenAccessor.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */