/*    */ package dev.jab125.minimega.mod.party;public final class PlayerSlotObj extends Record { private final int slotIndex;
/*    */   private final boolean active;
/*    */   private final boolean exists;
/*    */   private final boolean isMe;
/*    */   private final SlotMetadata metadata;
/*    */   
/*  7 */   public SlotMetadata metadata() { return this.metadata; } public boolean isMe() { return this.isMe; } public boolean exists() { return this.exists; } public boolean active() { return this.active; } public int slotIndex() { return this.slotIndex; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/party/PlayerSlotObj;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/party/PlayerSlotObj;
/*  7 */     //   0	8	1	o	Ljava/lang/Object; } public PlayerSlotObj(int slotIndex, boolean active, boolean exists, boolean isMe, SlotMetadata metadata) { this.slotIndex = slotIndex; this.active = active; this.exists = exists; this.isMe = isMe; this.metadata = metadata; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/party/PlayerSlotObj;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/party/PlayerSlotObj; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/party/PlayerSlotObj;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  8 */     //   0	7	0	this	Ldev/jab125/minimega/mod/party/PlayerSlotObj; } public static final StreamCodec<ByteBuf, PlayerSlotObj> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, PlayerSlotObj::slotIndex, ByteBufCodecs.BOOL, PlayerSlotObj::active, ByteBufCodecs.BOOL, PlayerSlotObj::exists, ByteBufCodecs.BOOL, PlayerSlotObj::isMe, SlotMetadataCodecs.STREAM_CODEC, PlayerSlotObj::metadata, PlayerSlotObj::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PlayerSlotObj(PlayerSlotObj prev, boolean isMe) {
/* 18 */     this(prev.slotIndex, prev.active, prev.exists, isMe, prev.metadata);
/*    */   } }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\party\PlayerSlotObj.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */