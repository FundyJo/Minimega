package dev.jab125.minimega.mod.extension;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;

public interface EntityExtension {
  void mm$setAbsoluteTargetVelocity(Direction paramDirection, Double paramDouble);
  
  Pair<Direction, Double> mm$getAbsoluteTargetVelocity();
  
  void mm$setRelativeTargetVelocity(Double paramDouble);
  
  Double mm$getRelativeTargetVelocity();
  
  void mm$setThermalVelocity(double paramDouble);
  
  void mm$setTargetThermalVelocity(double paramDouble, AABB paramAABB);
  
  void mm$setTargetHeight(Double paramDouble1, Double paramDouble2);
  
  void mm$respawnCheckpoint(int paramInt);
  
  int mm$checkpoint();
  
  void mm$checkpoint(int paramInt);
  
  void mm$addException(BlockPos paramBlockPos);
  
  BlockPos mm$getException();
  
  void mm$clearPrevAABB();
  
  int mm$respawnCheckpoont();
  
  boolean mm$finishedMap();
  
  void mm$finishedMap(boolean paramBoolean);
  
  void mm$abortBoosts();
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\extension\EntityExtension.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */