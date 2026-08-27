/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ public final class C2SJoiningChoicePayload extends Record implements CustomPacketPayload {
/*    */   private final CreateOrJoin data;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/C2SJoiningChoicePayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/C2SJoiningChoicePayload;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/C2SJoiningChoicePayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/C2SJoiningChoicePayload;
/*    */   }
/*    */   
/* 14 */   public C2SJoiningChoicePayload(CreateOrJoin data) { this.data = data; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/C2SJoiningChoicePayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/C2SJoiningChoicePayload;
/* 14 */     //   0	8	1	o	Ljava/lang/Object; } public CreateOrJoin data() { return this.data; }
/* 15 */    public static final CustomPacketPayload.Type<C2SJoiningChoicePayload> TYPE = new CustomPacketPayload.Type(Minimega.id("c2s_joining_choice"));
/* 16 */   public static final StreamCodec<ByteBuf, C2SJoiningChoicePayload> STREAM_CODEC = StreamCodec.composite(CreateOrJoinCodecs.STREAM_CODEC, C2SJoiningChoicePayload::data, C2SJoiningChoicePayload::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<C2SJoiningChoicePayload> type() {
/* 23 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\C2SJoiningChoicePayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */