package dev.jab125.minimega.mod.client.extension;

import dev.jab125.minimega.mod.util.Ref;
import net.minecraft.client.CameraType;
import net.minecraft.resources.Identifier;

public interface MinecraftExtension {
  boolean mm$isReady();
  
  void mm$resetReady();
  
  Ref<Identifier> mm$vote();
  
  boolean mm$isValid(Ref<Identifier> paramRef);
  
  void mm$resetVote();
  
  void mm$ready(boolean paramBoolean);
  
  CameraType mm$prev();
  
  void mm$prev(CameraType paramCameraType);
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\extension\MinecraftExtension.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */