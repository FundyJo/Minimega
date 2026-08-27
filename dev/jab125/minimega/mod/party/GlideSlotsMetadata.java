/*    */ package dev.jab125.minimega.mod.party;
/*    */ 
/*    */ 
/*    */ public final class GlideSlotsMetadata extends Record implements SlotsMetadata {
/*    */   private final List<ReducedCheckpoint> checkpointInfo;
/*    */   private final int round;
/*    */   private final int maxRounds;
/*    */   
/*  9 */   public GlideSlotsMetadata(List<ReducedCheckpoint> checkpointInfo, int round, int maxRounds) { this.checkpointInfo = checkpointInfo; this.round = round; this.maxRounds = maxRounds; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/party/GlideSlotsMetadata;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  9 */     //   0	7	0	this	Ldev/jab125/minimega/mod/party/GlideSlotsMetadata; } public List<ReducedCheckpoint> checkpointInfo() { return this.checkpointInfo; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/party/GlideSlotsMetadata;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/party/GlideSlotsMetadata; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/party/GlideSlotsMetadata;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/party/GlideSlotsMetadata;
/*  9 */     //   0	8	1	o	Ljava/lang/Object; } public int round() { return this.round; } public int maxRounds() { return this.maxRounds; }
/* 10 */    public static final StreamCodec<ByteBuf, GlideSlotsMetadata> STREAM_CODEC = StreamCodec.composite(
/* 11 */       ByteBufCodecs.list().apply(ReducedCheckpoint.STREAM_CODEC), GlideSlotsMetadata::checkpointInfo, ByteBufCodecs.INT, GlideSlotsMetadata::round, ByteBufCodecs.INT, GlideSlotsMetadata::maxRounds, GlideSlotsMetadata::new);
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\party\GlideSlotsMetadata.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */