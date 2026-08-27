package dev.jab125.minimega.mod.debug;

import dev.jab125.minimega.mod.util.controller.glide.GlideMinigameController;
import net.minecraft.world.phys.AABB;

public class MinimegaDebug {

   public static class GlideData {
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
}
