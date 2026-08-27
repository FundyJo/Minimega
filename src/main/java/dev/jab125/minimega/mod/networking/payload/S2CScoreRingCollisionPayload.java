/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.minecraft.network.codec.ByteBufCodecs;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ 
/*    */ public final class S2CScoreRingCollisionPayload extends Record implements CustomPacketPayload {
/*    */   private final int level;
/*    */   private final UUID uuid;
/*    */   private final int points;
/*    */   
/* 12 */   public S2CScoreRingCollisionPayload(int level, UUID uuid, int points) { this.level = level; this.uuid = uuid; this.points = points; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/S2CScoreRingCollisionPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 12 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CScoreRingCollisionPayload; } public int level() { return this.level; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/S2CScoreRingCollisionPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CScoreRingCollisionPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/S2CScoreRingCollisionPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CScoreRingCollisionPayload;
/* 12 */     //   0	8	1	o	Ljava/lang/Object; } public UUID uuid() { return this.uuid; } public int points() { return this.points; }
/* 13 */    public static final CustomPacketPayload.Type<S2CScoreRingCollisionPayload> TYPE = new CustomPacketPayload.Type(Minimega.id("score_ring_collision"));
/* 14 */   public static final StreamCodec<RegistryFriendlyByteBuf, S2CScoreRingCollisionPayload> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, S2CScoreRingCollisionPayload::level, UUIDUtil.STREAM_CODEC, S2CScoreRingCollisionPayload::uuid, ByteBufCodecs.VAR_INT, S2CScoreRingCollisionPayload::points, S2CScoreRingCollisionPayload::new);
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<S2CScoreRingCollisionPayload> type() {
/* 18 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\S2CScoreRingCollisionPayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */