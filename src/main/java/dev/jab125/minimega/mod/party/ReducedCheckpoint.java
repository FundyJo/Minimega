/*   */ package dev.jab125.minimega.mod.party;
/*   */ 
/*   */ public final class ReducedCheckpoint extends Record {
/*   */   private final int id;
/*   */   private final boolean respawn;
/*   */   
/* 7 */   public ReducedCheckpoint(int id, boolean respawn) { this.id = id; this.respawn = respawn; } public final String toString() { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/party/ReducedCheckpoint;)Ljava/lang/String;
/*   */     //   6: areturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #7	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/* 7 */     //   0	7	0	this	Ldev/jab125/minimega/mod/party/ReducedCheckpoint; } public int id() { return this.id; } public final int hashCode() { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/party/ReducedCheckpoint;)I
/*   */     //   6: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #7	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	7	0	this	Ldev/jab125/minimega/mod/party/ReducedCheckpoint; } public final boolean equals(Object o) { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: aload_1
/*   */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/party/ReducedCheckpoint;Ljava/lang/Object;)Z
/*   */     //   7: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #7	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	8	0	this	Ldev/jab125/minimega/mod/party/ReducedCheckpoint;
/* 7 */     //   0	8	1	o	Ljava/lang/Object; } public boolean respawn() { return this.respawn; }
/* 8 */    public static final StreamCodec<ByteBuf, ReducedCheckpoint> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, ReducedCheckpoint::id, ByteBufCodecs.BOOL, ReducedCheckpoint::respawn, ReducedCheckpoint::new);
/*   */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\party\ReducedCheckpoint.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */