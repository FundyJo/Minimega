/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ 
/*    */ public final class C2SLinkPayload extends Record implements CustomPacketPayload {
/*    */   private final String code;
/*    */   
/*  9 */   public C2SLinkPayload(String code) { this.code = code; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/C2SLinkPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  9 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/C2SLinkPayload; } public String code() { return this.code; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/C2SLinkPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/C2SLinkPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/C2SLinkPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/C2SLinkPayload;
/* 10 */     //   0	8	1	o	Ljava/lang/Object; } public static final CustomPacketPayload.Type<C2SLinkPayload> TYPE = new CustomPacketPayload.Type(Minimega.id("c2slink"));
/* 11 */   public static final StreamCodec<ByteBuf, C2SLinkPayload> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.stringUtf8(30), C2SLinkPayload::code, C2SLinkPayload::new);
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<C2SLinkPayload> type() {
/* 15 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\C2SLinkPayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */