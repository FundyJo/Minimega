/*    */ package dev.jab125.minimega.mod.client.gui.overlay;
/*    */ 
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import dev.jab125.minimega.mod.abstractions.modloader.ModLoader;
/*    */ import dev.jab125.minimega.mod.client.MinimegaClient;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*    */ import net.minecraft.client.player.LocalPlayer;
/*    */ import net.minecraft.client.renderer.RenderPipelines;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.phys.AABB;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import net.minecraft.world.phys.shapes.VoxelShape;
/*    */ 
/*    */ 
/*    */ public final class GlideProximityIndicatorHud
/*    */ {
/*    */   private static final int SEGMENT_COUNT = 8;
/*    */   private static final int SIZE = 15;
/* 22 */   private static final float[] OPACITY = new float[8];
/*    */   private static final double RANGE = 2.0D;
/*    */   private static final double PLAYER_RANGE_SQUARED = 9.0D;
/*    */   private static final float FADE_STEP = 0.1F;
/*    */   
/*    */   public static void tick(Minecraft minecraft) {
/* 28 */     for (int segment = 0; segment < 8; segment++) {
/* 29 */       OPACITY[segment] = Math.max(0.0F, OPACITY[segment] - 0.1F);
/*    */     }
/* 31 */     detect(minecraft);
/*    */   }
/*    */   
/*    */   public static void render(GuiGraphicsExtractor guiGraphics) {
/* 35 */     int x = (guiGraphics.guiWidth() - 15) / 2;
/* 36 */     int y = (guiGraphics.guiHeight() - 15) / 2;
/* 37 */     for (int segment = 0; segment < 8; segment++) {
/* 38 */       if (OPACITY[segment] > 0.0F) {
/* 39 */         if (ModLoader.isLegacy4jInstalled()) {
/* 40 */           int size = 15 * Minecraft.getInstance().getWindow().getGuiScale() - 1;
/* 41 */           guiGraphics.pose().pushMatrix();
/* 42 */           guiGraphics.pose().translate((guiGraphics.guiWidth() / 2), (guiGraphics.guiHeight() / 2));
/* 43 */           guiGraphics.pose().scale(1.0F / Minecraft.getInstance().getWindow().getGuiScale());
/* 44 */           guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Minimega.id("proximity/damage_" + segment), -size / 2, -size / 2, size, size, OPACITY[segment]);
/* 45 */           guiGraphics.pose().popMatrix();
/*    */         } else {
/* 47 */           guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Minimega.id("proximity/damage_" + segment), x, y, 15, 15, OPACITY[segment]);
/*    */         } 
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   private static void detect(Minecraft minecraft) {
/* 54 */     LocalPlayer player = minecraft.player;
/* 55 */     if (player == null || !player.isAlive() || !player.isFallFlying())
/* 56 */       return;  if (MinimegaClient.getMinigame() != Minigame.GLIDE)
/*    */       return; 
/* 58 */     Vec3 position = player.position();
/* 59 */     AABB nearest = null;
/* 60 */     double nearestDistance = Double.POSITIVE_INFINITY;
/* 61 */     for (VoxelShape shape : player.level().getBlockCollisions((Entity)player, player.getBoundingBox().inflate(2.0D))) {
/* 62 */       AABB bounds = shape.bounds();
/* 63 */       double distance = bounds.distanceToSqr(position);
/* 64 */       if (distance < nearestDistance) {
/* 65 */         nearest = bounds;
/* 66 */         nearestDistance = distance;
/*    */       } 
/*    */     } 
/*    */     
/* 70 */     if (nearest != null) OPACITY[getSegment(player, position.subtract(nearest.getCenter()))] = 1.0F; 
/* 71 */     for (Player other : player.level().players()) {
/* 72 */       if (other != player && other.isAlive() && !other.isSpectator() && player
/* 73 */         .distanceToSqr((Entity)other) <= 9.0D) {
/* 74 */         OPACITY[getSegment(player, position.subtract(other.position()))] = 1.0F;
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   private static int getSegment(LocalPlayer player, Vec3 direction) {
/* 80 */     Vec3 view = player.getLookAngle();
/* 81 */     double angle = Math.toDegrees(Math.atan2(view.x * direction.z - view.z * direction.x, view.x * direction.x + view.z * direction.z));
/*    */ 
/*    */     
/* 84 */     return Math.floorMod((int)Math.round((angle + 180.0D) / 45.0D), 8);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\overlay\GlideProximityIndicatorHud.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */