package dev.jab125.minimega.mod.client;

import dev.jab125.minimega.mod.util.controller.glide.GlideMinigameController;
import java.util.List;

public class MinimegaClient {

   static record BeaconRenderData(List<GlideMinigameController.BeaconBeam> beams, float gameTimeDeltaPartialTick, long gameTime) {}

   static record Box(int x0, int y0, int z0, int x1, int y1, int z1) {}

   static record Coords(int x, int y, int z, int yRot) {}

   static record ThermalRenderData(List<GlideMinigameController.Thermal> thermals, float gameTimeDeltaPartialTick, long gameTime, boolean renderHitboxes) {}
}
