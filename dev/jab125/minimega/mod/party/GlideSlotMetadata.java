/*    */ package dev.jab125.minimega.mod.party;
/*    */ 
/*    */ 
/*    */ public final class GlideSlotMetadata extends Record implements SlotMetadata {
/*    */   private final int checkpoint;
/*    */   private final double progressToNextCheckpoint;
/*    */   private final boolean dead;
/*    */   private final Optional<GlideMinigameController.PlayerInformation> playerInformation;
/*    */   
/* 10 */   public GlideSlotMetadata(int checkpoint, double progressToNextCheckpoint, boolean dead, Optional<GlideMinigameController.PlayerInformation> playerInformation) { this.checkpoint = checkpoint; this.progressToNextCheckpoint = progressToNextCheckpoint; this.dead = dead; this.playerInformation = playerInformation; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/party/GlideSlotMetadata;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 10 */     //   0	7	0	this	Ldev/jab125/minimega/mod/party/GlideSlotMetadata; } public int checkpoint() { return this.checkpoint; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/party/GlideSlotMetadata;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/party/GlideSlotMetadata; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/party/GlideSlotMetadata;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/party/GlideSlotMetadata;
/* 10 */     //   0	8	1	o	Ljava/lang/Object; } public double progressToNextCheckpoint() { return this.progressToNextCheckpoint; } public boolean dead() { return this.dead; } public Optional<GlideMinigameController.PlayerInformation> playerInformation() { return this.playerInformation; }
/* 11 */    public static final StreamCodec<ByteBuf, GlideSlotMetadata> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, GlideSlotMetadata::checkpoint, ByteBufCodecs.DOUBLE, GlideSlotMetadata::progressToNextCheckpoint, ByteBufCodecs.BOOL, GlideSlotMetadata::dead, 
/*    */ 
/*    */ 
/*    */       
/* 15 */       ByteBufCodecs.optional(GlideMinigameController.PlayerInformation.STREAM_CODEC), GlideSlotMetadata::playerInformation, GlideSlotMetadata::new);
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\party\GlideSlotMetadata.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */