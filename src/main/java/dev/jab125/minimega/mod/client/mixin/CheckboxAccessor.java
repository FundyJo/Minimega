package dev.jab125.minimega.mod.client.mixin;

import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.MultiLineTextWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({Checkbox.class})
public interface CheckboxAccessor {
  @Accessor
  void setSelected(boolean paramBoolean);
  
  @Accessor
  MultiLineTextWidget getTextWidget();
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\CheckboxAccessor.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */