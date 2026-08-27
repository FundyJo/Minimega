/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ public final class S2CMapTransitionStartPayload extends Record implements CustomPacketPayload {
/*    */   private final MapInfo info;
/*    */   private final boolean inInSameLevel;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/S2CMapTransitionStartPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CMapTransitionStartPayload;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/S2CMapTransitionStartPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CMapTransitionStartPayload;
/*    */   }
/*    */   
/* 14 */   public S2CMapTransitionStartPayload(MapInfo info, boolean inInSameLevel) { this.info = info; this.inInSameLevel = inInSameLevel; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/S2CMapTransitionStartPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CMapTransitionStartPayload;
/* 14 */     //   0	8	1	o	Ljava/lang/Object; } public MapInfo info() { return this.info; } public boolean inInSameLevel() { return this.inInSameLevel; }
/*    */   
/* 16 */   public static final CustomPacketPayload.Type<S2CMapTransitionStartPayload> TYPE = new CustomPacketPayload.Type(Minimega.id("map_transition_start"));
/* 17 */   public static final StreamCodec<ByteBuf, S2CMapTransitionStartPayload> STREAM_CODEC = StreamCodec.composite(MapInfo.STREAM_CODEC, S2CMapTransitionStartPayload::info, ByteBufCodecs.BOOL, S2CMapTransitionStartPayload::inInSameLevel, S2CMapTransitionStartPayload::new);
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<S2CMapTransitionStartPayload> type() {
/* 21 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\S2CMapTransitionStartPayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */