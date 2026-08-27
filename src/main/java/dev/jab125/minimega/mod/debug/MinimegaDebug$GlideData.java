package dev.jab125.minimega.mod.debug;

import dev.jab125.minimega.mod.util.controller.glide.GlideMinigameController;
import net.minecraft.world.phys.AABB;

public class GlideData {
  public boolean isApplyingStaticLift;
  
  public boolean isApplyingLift;
  
  public int liftDurationTimer;
  
  public double staticLiftTargetHeight;
  
  public boolean isUpdraft;
  
  public double targetLiftVelocity;
  
  public GlideMinigameController.Thermal thermalArea;
  
  public double appliedLiftVelocity;
  
  public boolean isSpeedBoosting;
  
  public double targetBoostSpeed;
  
  public double liftForceModifier;
  
  public boolean hasPendingThermalEntry;
  
  public int points;
  
  public int checkpoint;
  
  public boolean finishedMap;
  
  public AABB currentPlayerBoundsVolume;
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\debug\MinimegaDebug$GlideData.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */