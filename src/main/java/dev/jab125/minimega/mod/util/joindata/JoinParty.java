/*    */ package dev.jab125.minimega.mod.util.joindata;
/*    */ 
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ 
/*    */ public final class JoinParty extends Record implements CreateOrJoin {
/*    */   private final Minigame<?> minigame;
/*    */   
/*  8 */   public JoinParty(Minigame<?> minigame) { this.minigame = minigame; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/joindata/JoinParty;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  8 */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/joindata/JoinParty; } public Minigame<?> minigame() { return this.minigame; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/joindata/JoinParty;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/joindata/JoinParty; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/joindata/JoinParty;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/joindata/JoinParty;
/*  9 */     //   0	8	1	o	Ljava/lang/Object; } public static final StreamCodec<ByteBuf, JoinParty> STREAM_CODEC = StreamCodec.composite(
/* 10 */       ByteBufCodecs.idMapper(Minigame::fromId, Minigame::getId), JoinParty::minigame, JoinParty::new);
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\joindata\JoinParty.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */