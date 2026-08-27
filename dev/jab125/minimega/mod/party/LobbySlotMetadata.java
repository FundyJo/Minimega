/*   */ package dev.jab125.minimega.mod.party;
/*   */ 
/*   */ 
/*   */ public final class LobbySlotMetadata extends Record implements SlotMetadata {
/*   */   private final boolean ready;
/*   */   
/* 7 */   public LobbySlotMetadata(boolean ready) { this.ready = ready; } public final String toString() { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/party/LobbySlotMetadata;)Ljava/lang/String;
/*   */     //   6: areturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #7	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/* 7 */     //   0	7	0	this	Ldev/jab125/minimega/mod/party/LobbySlotMetadata; } public boolean ready() { return this.ready; }
/*   */   public final int hashCode() { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/party/LobbySlotMetadata;)I
/*   */     //   6: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #7	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	7	0	this	Ldev/jab125/minimega/mod/party/LobbySlotMetadata; } public final boolean equals(Object o) { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: aload_1
/*   */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/party/LobbySlotMetadata;Ljava/lang/Object;)Z
/*   */     //   7: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #7	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	8	0	this	Ldev/jab125/minimega/mod/party/LobbySlotMetadata;
/* 8 */     //   0	8	1	o	Ljava/lang/Object; } public static final StreamCodec<ByteBuf, LobbySlotMetadata> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.BOOL, LobbySlotMetadata::ready, LobbySlotMetadata::new);
/*   */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\party\LobbySlotMetadata.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */