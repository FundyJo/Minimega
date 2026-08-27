/*    */ package dev.jab125.minimega.mod.util;
/*    */ 
/*    */ import net.minecraft.world.phys.AABB;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ 
/*    */ public class ProgressUtil
/*    */ {
/*    */   public static double calculateInterpolation(AABB aabb1, AABB aabb2, Vec3 position) {
/*  9 */     Vec3 closest1 = getClosestPoint(aabb1, position);
/* 10 */     Vec3 closest2 = getClosestPoint(aabb2, position);
/*    */ 
/*    */     
/* 13 */     double dirX = closest2.x() - closest1.x();
/* 14 */     double dirY = closest2.y() - closest1.y();
/* 15 */     double dirZ = closest2.z() - closest1.z();
/*    */ 
/*    */     
/* 18 */     double apX = position.x() - closest1.x();
/* 19 */     double apY = position.y() - closest1.y();
/* 20 */     double apZ = position.z() - closest1.z();
/*    */ 
/*    */     
/* 23 */     double apDotDir = apX * dirX + apY * dirY + apZ * dirZ;
/* 24 */     double dirDotDir = dirX * dirX + dirY * dirY + dirZ * dirZ;
/*    */ 
/*    */     
/* 27 */     if (dirDotDir == 0.0D) {
/* 28 */       return 0.5D;
/*    */     }
/*    */     
/* 31 */     return apDotDir / dirDotDir;
/*    */   }
/*    */   
/*    */   private static Vec3 getClosestPoint(AABB aabb, Vec3 position) {
/* 35 */     double closestX = clamp(position.x(), aabb.minX, aabb.maxX);
/* 36 */     double closestY = clamp(position.y(), aabb.minY, aabb.maxY);
/* 37 */     double closestZ = clamp(position.z(), aabb.minZ, aabb.maxZ);
/* 38 */     return new Vec3(closestX, closestY, closestZ);
/*    */   }
/*    */   
/*    */   private static double clamp(double value, double min, double max) {
/* 42 */     return Math.max(min, Math.min(value, max));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\ProgressUtil.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */