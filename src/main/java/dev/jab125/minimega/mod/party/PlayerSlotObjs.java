/*    */ package dev.jab125.minimega.mod.party;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public final class PlayerSlotObjs extends Record {
/*    */   private final List<PlayerSlotObj> list;
/*    */   private final SlotsMetadata slotsMetadata;
/*    */   
/*  9 */   public PlayerSlotObjs(List<PlayerSlotObj> list, SlotsMetadata slotsMetadata) { this.list = list; this.slotsMetadata = slotsMetadata; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/party/PlayerSlotObjs;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  9 */     //   0	7	0	this	Ldev/jab125/minimega/mod/party/PlayerSlotObjs; } public List<PlayerSlotObj> list() { return this.list; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/party/PlayerSlotObjs;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/party/PlayerSlotObjs; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/party/PlayerSlotObjs;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/party/PlayerSlotObjs;
/*  9 */     //   0	8	1	o	Ljava/lang/Object; } public SlotsMetadata slotsMetadata() { return this.slotsMetadata; }
/* 10 */    public static final StreamCodec<ByteBuf, PlayerSlotObjs> STREAM_CODEC = StreamCodec.composite(
/* 11 */       ByteBufCodecs.list().apply(PlayerSlotObj.STREAM_CODEC), PlayerSlotObjs::list, SlotsMetadataCodecs.STREAM_CODEC, PlayerSlotObjs::slotsMetadata, PlayerSlotObjs::new);
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\party\PlayerSlotObjs.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */