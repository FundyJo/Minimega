/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ import java.time.Duration;
/*    */ import net.minecraft.network.codec.ByteBufCodecs;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ 
/*    */ public final class S2CTimerSynchronizationPayload extends Record implements CustomPacketPayload {
/*    */   private final Duration duration;
/*    */   private final int number;
/*    */   private final boolean leaderboardCounted;
/*    */   
/* 12 */   public S2CTimerSynchronizationPayload(Duration duration, int number, boolean leaderboardCounted) { this.duration = duration; this.number = number; this.leaderboardCounted = leaderboardCounted; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/S2CTimerSynchronizationPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 12 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CTimerSynchronizationPayload; } public Duration duration() { return this.duration; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/S2CTimerSynchronizationPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CTimerSynchronizationPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/S2CTimerSynchronizationPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CTimerSynchronizationPayload;
/* 12 */     //   0	8	1	o	Ljava/lang/Object; } public int number() { return this.number; } public boolean leaderboardCounted() { return this.leaderboardCounted; }
/* 13 */    public static final CustomPacketPayload.Type<S2CTimerSynchronizationPayload> TYPE = new CustomPacketPayload.Type(Minimega.id("s2c_timer_synchronization"));
/* 14 */   private static final StreamCodec<ByteBuf, Duration> DURATION_STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.LONG, Duration::getSeconds, ByteBufCodecs.INT, Duration::getNano, Duration::ofSeconds);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 19 */   public static final StreamCodec<RegistryFriendlyByteBuf, S2CTimerSynchronizationPayload> STREAM_CODEC = StreamCodec.composite(DURATION_STREAM_CODEC, S2CTimerSynchronizationPayload::duration, ByteBufCodecs.INT, S2CTimerSynchronizationPayload::number, ByteBufCodecs.BOOL, S2CTimerSynchronizationPayload::leaderboardCounted, S2CTimerSynchronizationPayload::new);
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<S2CTimerSynchronizationPayload> type() {
/* 23 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\S2CTimerSynchronizationPayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */