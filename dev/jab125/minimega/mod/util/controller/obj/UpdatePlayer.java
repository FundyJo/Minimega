/*    */ package dev.jab125.minimega.mod.util.controller.obj;
/*    */ 
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.datafixers.kinds.Applicative;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ 
/*    */ @Deprecated(forRemoval = true)
/*    */ public class UpdatePlayer {
/*    */   public int spawnX;
/*    */   
/*    */   static {
/* 13 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.INT.fieldOf("spawnX").forGetter(()), (App)Codec.INT.fieldOf("spawnY").forGetter(()), (App)Codec.INT.fieldOf("spawnZ").forGetter(()), (App)Codec.DOUBLE.fieldOf("xRot").forGetter(()), (App)Codec.DOUBLE.fieldOf("yRot").forGetter(())).apply((Applicative)instance, UpdatePlayer::make));
/*    */   }
/*    */ 
/*    */   
/*    */   public int spawnY;
/*    */   
/*    */   public int spawnZ;
/*    */   
/*    */   public static UpdatePlayer make(int spawnX, int spawnY, int spawnZ, double xRot, double yRot) {
/* 22 */     UpdatePlayer updatePlayer = new UpdatePlayer();
/* 23 */     updatePlayer.spawnX = spawnX;
/* 24 */     updatePlayer.spawnY = spawnY;
/* 25 */     updatePlayer.spawnZ = spawnZ;
/* 26 */     updatePlayer.xRot = xRot;
/* 27 */     updatePlayer.yRot = yRot;
/* 28 */     return updatePlayer;
/*    */   }
/*    */   
/*    */   public double xRot;
/*    */   public double yRot;
/*    */   public static final Codec<UpdatePlayer> CODEC;
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\controller\obj\UpdatePlayer.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */