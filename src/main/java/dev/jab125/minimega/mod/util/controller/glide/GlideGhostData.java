/*    */ package dev.jab125.minimega.mod.util.controller.glide;
/*    */ 
/*    */ import java.time.Duration;
/*    */ import net.minecraft.network.codec.ByteBufCodecs;
/*    */ 
/*    */ public final class GlideGhostData extends Record {
/*    */   private final float startX;
/*    */   private final float startY;
/*    */   private final float startZ;
/*    */   private final Duration length;
/*    */   private final List<Sample> samples;
/*    */   private static final String thx = "PhoenixARC https://discord.com/channels/806988877687423027/823332456149024849/1425522784569655467 https://media.discordapp.net/attachments/823332456149024849/1425522784108544192/image.png";
/*    */   
/* 14 */   public GlideGhostData(float startX, float startY, float startZ, Duration length, List<Sample> samples) { this.startX = startX; this.startY = startY; this.startZ = startZ; this.length = length; this.samples = samples; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 14 */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData; } public float startX() { return this.startX; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData;
/* 14 */     //   0	8	1	o	Ljava/lang/Object; } public float startY() { return this.startY; } public float startZ() { return this.startZ; } public Duration length() { return this.length; } public List<Sample> samples() { return this.samples; }
/*    */ 
/*    */   
/* 17 */   private static final StreamCodec<ByteBuf, Duration> DURATION_STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.LONG, Duration::getSeconds, ByteBufCodecs.INT, Duration::getNano, Duration::ofSeconds);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static {
/* 24 */     Rotation.STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.FLOAT, Rotation::yaw, ByteBufCodecs.FLOAT, Rotation::pitch, ByteBufCodecs.FLOAT, Rotation::roll, Rotation::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 30 */     Position.STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.FLOAT, Position::x, ByteBufCodecs.FLOAT, Position::y, ByteBufCodecs.FLOAT, Position::z, Position::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 36 */     Sample.STREAM_CODEC = StreamCodec.composite(DURATION_STREAM_CODEC, Sample::timestamp, Position.STREAM_CODEC, Sample::position, Rotation.STREAM_CODEC, Sample::rotation, Sample::new);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 42 */   public static StreamCodec<ByteBuf, GlideGhostData> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.FLOAT, GlideGhostData::startX, ByteBufCodecs.FLOAT, GlideGhostData::startY, ByteBufCodecs.FLOAT, GlideGhostData::startZ, DURATION_STREAM_CODEC, GlideGhostData::length, 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 47 */       ByteBufCodecs.list().apply(Sample.STREAM_CODEC), GlideGhostData::samples, GlideGhostData::new);
/*    */   
/*    */   public static void setup() {}
/*    */   
/*    */   public static final class Sample extends Record {
/*    */     private final Duration timestamp;
/*    */     private final GlideGhostData.Position position;
/*    */     private final GlideGhostData.Rotation rotation;
/*    */     public static StreamCodec<ByteBuf, Sample> STREAM_CODEC;
/*    */     
/* 57 */     public Sample(Duration timestamp, GlideGhostData.Position position, GlideGhostData.Rotation rotation) { this.timestamp = timestamp; this.position = position; this.rotation = rotation; } public final String toString() { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Sample;)Ljava/lang/String;
/*    */       //   6: areturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #57	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Sample; } public final int hashCode() { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Sample;)I
/*    */       //   6: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #57	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Sample; } public final boolean equals(Object o) { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: aload_1
/*    */       //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Sample;Ljava/lang/Object;)Z
/*    */       //   7: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #57	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	8	0	this	Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Sample;
/* 57 */       //   0	8	1	o	Ljava/lang/Object; } public Duration timestamp() { return this.timestamp; } public GlideGhostData.Position position() { return this.position; } public GlideGhostData.Rotation rotation() { return this.rotation; }
/*    */      }
/*    */   public static final class Position extends Record { private final float x; private final float y; private final float z; public static StreamCodec<ByteBuf, Position> STREAM_CODEC;
/* 60 */     public Position(float x, float y, float z) { this.x = x; this.y = y; this.z = z; } public final String toString() { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Position;)Ljava/lang/String;
/*    */       //   6: areturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #60	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Position; } public final int hashCode() { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Position;)I
/*    */       //   6: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #60	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Position; } public final boolean equals(Object o) { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: aload_1
/*    */       //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Position;Ljava/lang/Object;)Z
/*    */       //   7: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #60	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	8	0	this	Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Position;
/* 60 */       //   0	8	1	o	Ljava/lang/Object; } public float x() { return this.x; } public float y() { return this.y; } public float z() { return this.z; }
/*    */      }
/*    */   public static final class Rotation extends Record { private final float yaw; private final float pitch; private final float roll; public static StreamCodec<ByteBuf, Rotation> STREAM_CODEC;
/* 63 */     public Rotation(float yaw, float pitch, float roll) { this.yaw = yaw; this.pitch = pitch; this.roll = roll; } public final String toString() { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Rotation;)Ljava/lang/String;
/*    */       //   6: areturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #63	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Rotation; } public final int hashCode() { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Rotation;)I
/*    */       //   6: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #63	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Rotation; } public final boolean equals(Object o) { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: aload_1
/*    */       //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Rotation;Ljava/lang/Object;)Z
/*    */       //   7: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #63	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	8	0	this	Ldev/jab125/minimega/mod/util/controller/glide/GlideGhostData$Rotation;
/* 63 */       //   0	8	1	o	Ljava/lang/Object; } public float yaw() { return this.yaw; } public float pitch() { return this.pitch; } public float roll() { return this.roll; }
/*    */     
/*    */     public Vec2 toVec2() {
/* 66 */       return new Vec2(yaw(), pitch());
/*    */     }
/*    */     public Vec3 toVec3() {
/* 69 */       return new Vec3(yaw(), pitch(), roll());
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\controller\glide\GlideGhostData.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */