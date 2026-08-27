/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ 
/*    */ public final class C2STimerSynchronizationPayload extends Record implements CustomPacketPayload {
/*    */   private final int number;
/*    */   
/*  9 */   public C2STimerSynchronizationPayload(int number) { this.number = number; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/C2STimerSynchronizationPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  9 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/C2STimerSynchronizationPayload; } public int number() { return this.number; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/C2STimerSynchronizationPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/C2STimerSynchronizationPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/C2STimerSynchronizationPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/C2STimerSynchronizationPayload;
/* 10 */     //   0	8	1	o	Ljava/lang/Object; } public static final CustomPacketPayload.Type<C2STimerSynchronizationPayload> TYPE = new CustomPacketPayload.Type(Minimega.id("c2s_timer_synchronization"));
/* 11 */   public static final StreamCodec<RegistryFriendlyByteBuf, C2STimerSynchronizationPayload> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, C2STimerSynchronizationPayload::number, C2STimerSynchronizationPayload::new);
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<C2STimerSynchronizationPayload> type() {
/* 15 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\C2STimerSynchronizationPayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */