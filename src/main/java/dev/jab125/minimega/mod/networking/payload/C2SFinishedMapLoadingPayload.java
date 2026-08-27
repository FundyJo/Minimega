/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ 
/*    */ public final class C2SFinishedMapLoadingPayload extends Record implements CustomPacketPayload {
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/C2SFinishedMapLoadingPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/C2SFinishedMapLoadingPayload;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/*    */   
/*  9 */   public static final CustomPacketPayload.Type<C2SFinishedMapLoadingPayload> TYPE = new CustomPacketPayload.Type(Minimega.id("finished_map_loading"));
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/C2SFinishedMapLoadingPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/C2SFinishedMapLoadingPayload; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/C2SFinishedMapLoadingPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 10 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/C2SFinishedMapLoadingPayload; } public static final StreamCodec<ByteBuf, C2SFinishedMapLoadingPayload> STREAM_CODEC = StreamCodec.unit(new C2SFinishedMapLoadingPayload());
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<C2SFinishedMapLoadingPayload> type() {
/* 14 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\C2SFinishedMapLoadingPayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */