/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ import dev.jab125.minimega.mod.util.minigamedata.MinigameData;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ 
/*    */ public final class C2SRecreationPayload extends Record implements CustomPacketPayload {
/*    */   private final MinigameData data;
/*    */   
/* 10 */   public C2SRecreationPayload(MinigameData data) { this.data = data; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/C2SRecreationPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 10 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/C2SRecreationPayload; } public MinigameData data() { return this.data; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/C2SRecreationPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/C2SRecreationPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/C2SRecreationPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/C2SRecreationPayload;
/* 11 */     //   0	8	1	o	Ljava/lang/Object; } public static final CustomPacketPayload.Type<C2SRecreationPayload> TYPE = new CustomPacketPayload.Type(Minimega.id("c2srecreation"));
/* 12 */   public static final StreamCodec<ByteBuf, C2SRecreationPayload> STREAM_CODEC = StreamCodec.composite(MinigameData.STREAM_CODEC, C2SRecreationPayload::data, C2SRecreationPayload::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<C2SRecreationPayload> type() {
/* 19 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\C2SRecreationPayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */