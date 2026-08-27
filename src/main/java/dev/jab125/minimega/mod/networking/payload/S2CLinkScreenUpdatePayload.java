/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ 
/*    */ public final class S2CLinkScreenUpdatePayload extends Record implements CustomPacketPayload {
/*    */   private final boolean successful;
/*    */   
/*  9 */   public S2CLinkScreenUpdatePayload(boolean successful) { this.successful = successful; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/S2CLinkScreenUpdatePayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  9 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CLinkScreenUpdatePayload; } public boolean successful() { return this.successful; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/S2CLinkScreenUpdatePayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CLinkScreenUpdatePayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/S2CLinkScreenUpdatePayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CLinkScreenUpdatePayload;
/* 10 */     //   0	8	1	o	Ljava/lang/Object; } public static final CustomPacketPayload.Type<S2CLinkScreenUpdatePayload> TYPE = new CustomPacketPayload.Type(Minimega.id("linkscreenpacket"));
/* 11 */   public static final StreamCodec<ByteBuf, S2CLinkScreenUpdatePayload> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.BOOL, S2CLinkScreenUpdatePayload::successful, S2CLinkScreenUpdatePayload::new);
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<S2CLinkScreenUpdatePayload> type() {
/* 15 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\S2CLinkScreenUpdatePayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */