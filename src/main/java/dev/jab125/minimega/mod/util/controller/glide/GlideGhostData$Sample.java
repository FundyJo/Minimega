/*    */ package dev.jab125.minimega.mod.util.controller.glide;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.time.Duration;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Sample
/*    */   extends Record
/*    */ {
/*    */   private final Duration timestamp;
/*    */   private final GlideGhostData.Position position;
/*    */   private final GlideGhostData.Rotation rotation;
/*    */   public static StreamCodec<ByteBuf, Sample> STREAM_CODEC;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Sample;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #57	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Sample;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Sample;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #57	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Sample;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Sample;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #57	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Sample;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/*    */   
/*    */   public Sample(Duration timestamp, GlideGhostData.Position position, GlideGhostData.Rotation rotation) {
/* 57 */     this.timestamp = timestamp; this.position = position; this.rotation = rotation; } public Duration timestamp() { return this.timestamp; } public GlideGhostData.Position position() { return this.position; } public GlideGhostData.Rotation rotation() { return this.rotation; }
/*    */ 
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\controller\glide\GlideGhostData$Sample.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */