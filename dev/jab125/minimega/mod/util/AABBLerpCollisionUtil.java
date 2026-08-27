/*     */ package dev.jab125.minimega.mod.util;
/*     */ 
/*     */ import net.minecraft.world.phys.AABB;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AABBLerpCollisionUtil
/*     */ {
/*     */   public static boolean intersected(AABB oldLoc, AABB newLoc, AABB collision) {
/*  23 */     double deltaX = newLoc.minX - oldLoc.minX;
/*  24 */     double xStart = 0.0D;
/*  25 */     double xEnd = 1.0D;
/*  26 */     if (deltaX == 0.0D) {
/*  27 */       if (oldLoc.maxX <= collision.minX || oldLoc.minX >= collision.maxX) {
/*  28 */         return false;
/*     */       }
/*     */     } else {
/*  31 */       double t0 = (collision.minX - oldLoc.maxX) / deltaX;
/*  32 */       double t1 = (collision.maxX - oldLoc.minX) / deltaX;
/*  33 */       if (deltaX > 0.0D) {
/*  34 */         xStart = t0;
/*  35 */         xEnd = t1;
/*     */       } else {
/*  37 */         xStart = t1;
/*  38 */         xEnd = t0;
/*     */       } 
/*  40 */       xStart = Math.max(xStart, 0.0D);
/*  41 */       xEnd = Math.min(xEnd, 1.0D);
/*  42 */       if (xStart >= xEnd) {
/*  43 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  48 */     double deltaY = newLoc.minY - oldLoc.minY;
/*  49 */     double yStart = 0.0D;
/*  50 */     double yEnd = 1.0D;
/*  51 */     if (deltaY == 0.0D) {
/*  52 */       if (oldLoc.maxY <= collision.minY || oldLoc.minY >= collision.maxY) {
/*  53 */         return false;
/*     */       }
/*     */     } else {
/*  56 */       double t0 = (collision.minY - oldLoc.maxY) / deltaY;
/*  57 */       double t1 = (collision.maxY - oldLoc.minY) / deltaY;
/*  58 */       if (deltaY > 0.0D) {
/*  59 */         yStart = t0;
/*  60 */         yEnd = t1;
/*     */       } else {
/*  62 */         yStart = t1;
/*  63 */         yEnd = t0;
/*     */       } 
/*  65 */       yStart = Math.max(yStart, 0.0D);
/*  66 */       yEnd = Math.min(yEnd, 1.0D);
/*  67 */       if (yStart >= yEnd) {
/*  68 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  73 */     double deltaZ = newLoc.minZ - oldLoc.minZ;
/*  74 */     double zStart = 0.0D;
/*  75 */     double zEnd = 1.0D;
/*  76 */     if (deltaZ == 0.0D) {
/*  77 */       if (oldLoc.maxZ <= collision.minZ || oldLoc.minZ >= collision.maxZ) {
/*  78 */         return false;
/*     */       }
/*     */     } else {
/*  81 */       double t0 = (collision.minZ - oldLoc.maxZ) / deltaZ;
/*  82 */       double t1 = (collision.maxZ - oldLoc.minZ) / deltaZ;
/*  83 */       if (deltaZ > 0.0D) {
/*  84 */         zStart = t0;
/*  85 */         zEnd = t1;
/*     */       } else {
/*  87 */         zStart = t1;
/*  88 */         zEnd = t0;
/*     */       } 
/*  90 */       zStart = Math.max(zStart, 0.0D);
/*  91 */       zEnd = Math.min(zEnd, 1.0D);
/*  92 */       if (zStart >= zEnd) {
/*  93 */         return false;
/*     */       }
/*     */     } 
/*     */     
/*  97 */     double overallStart = Math.max(xStart, Math.max(yStart, zStart));
/*  98 */     double overallEnd = Math.min(xEnd, Math.min(yEnd, zEnd));
/*  99 */     return (overallStart <= overallEnd);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 104 */     AABB oldLoc1 = new AABB(0.0D, 2.0D, 0.0D, 2.0D, 0.0D, 2.0D);
/* 105 */     AABB newLoc1 = new AABB(3.0D, 5.0D, 3.0D, 5.0D, 3.0D, 5.0D);
/* 106 */     AABB collision1 = new AABB(1.0D, 2.0D, 1.0D, 2.0D, 1.0D, 2.0D);
/* 107 */     boolean result1 = intersected(oldLoc1, newLoc1, collision1);
/* 108 */     System.out.println("Test 1 - Expected: false, Actual: " + result1);
/*     */ 
/*     */     
/* 111 */     AABB oldLoc2 = new AABB(0.0D, 2.0D, 0.0D, 2.0D, 0.0D, 2.0D);
/* 112 */     AABB newLoc2 = new AABB(1.0D, 3.0D, 1.0D, 3.0D, 1.0D, 3.0D);
/* 113 */     AABB collision2 = new AABB(1.0D, 2.0D, 1.0D, 2.0D, 1.0D, 2.0D);
/* 114 */     boolean result2 = intersected(oldLoc2, newLoc2, collision2);
/* 115 */     System.out.println("Test 2 - Expected: true, Actual: " + result2);
/*     */ 
/*     */     
/* 118 */     AABB oldLoc3 = new AABB(0.0D, 2.0D, 0.0D, 2.0D, 0.0D, 2.0D);
/* 119 */     AABB newLoc3 = new AABB(1.5D, 3.5D, 1.5D, 3.5D, 1.5D, 3.5D);
/* 120 */     AABB collision3 = new AABB(1.0D, 2.0D, 1.0D, 2.0D, 1.0D, 2.0D);
/* 121 */     boolean result3 = intersected(oldLoc3, newLoc3, collision3);
/* 122 */     System.out.println("Test 3 - Expected: true, Actual: " + result3);
/*     */ 
/*     */     
/* 125 */     AABB oldLoc4 = new AABB(0.0D, 2.0D, 0.0D, 2.0D, 0.0D, 2.0D);
/* 126 */     AABB newLoc4 = new AABB(2.0D, 4.0D, 2.0D, 4.0D, 2.0D, 4.0D);
/* 127 */     AABB collision4 = new AABB(2.0D, 3.0D, 2.0D, 3.0D, 2.0D, 3.0D);
/* 128 */     boolean result4 = intersected(oldLoc4, newLoc4, collision4);
/* 129 */     System.out.println("Test 4 - Expected: false, Actual: " + result4);
/*     */ 
/*     */     
/* 132 */     AABB oldLoc5 = new AABB(1.0D, 2.0D, 1.0D, 2.0D, 1.0D, 2.0D);
/* 133 */     AABB newLoc5 = new AABB(1.0D, 2.0D, 1.0D, 2.0D, 1.0D, 2.0D);
/* 134 */     AABB collision5 = new AABB(1.0D, 2.0D, 1.0D, 2.0D, 1.0D, 2.0D);
/* 135 */     boolean result5 = intersected(oldLoc5, newLoc5, collision5);
/* 136 */     System.out.println("Test 5 - Expected: true, Actual: " + result5);
/*     */ 
/*     */     
/* 139 */     AABB oldLoc6 = new AABB(0.0D, 1.0D, 0.0D, 1.0D, 0.0D, 1.0D);
/* 140 */     AABB newLoc6 = new AABB(0.0D, 1.0D, 0.0D, 1.0D, 0.0D, 1.0D);
/* 141 */     AABB collision6 = new AABB(2.0D, 3.0D, 2.0D, 3.0D, 2.0D, 3.0D);
/* 142 */     boolean result6 = intersected(oldLoc6, newLoc6, collision6);
/* 143 */     System.out.println("Test 6 - Expected: false, Actual: " + result6);
/*     */ 
/*     */     
/* 146 */     AABB oldLoc7 = new AABB(0.0D, 1.0D, 0.0D, 1.0D, 0.0D, 1.0D);
/* 147 */     AABB newLoc7 = new AABB(3.0D, 4.0D, 3.0D, 4.0D, 3.0D, 4.0D);
/* 148 */     AABB collision7 = new AABB(1.0D, 2.0D, 1.0D, 2.0D, 1.0D, 2.0D);
/* 149 */     boolean result7 = intersected(oldLoc7, newLoc7, collision7);
/* 150 */     System.out.println("Test 7 - Expected: true, Actual: " + result7);
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\AABBLerpCollisionUtil.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */