/*   */ package dev.jab125.minimega.mod.util.joindata;
/*   */ 
/*   */ 
/*   */ public final class CreateParty extends Record implements CreateOrJoin {
/*   */   private final MinigameData data;
/*   */   
/* 7 */   public CreateParty(MinigameData data) { this.data = data; } public final String toString() { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/joindata/CreateParty;)Ljava/lang/String;
/*   */     //   6: areturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #7	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/* 7 */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/joindata/CreateParty; } public MinigameData data() { return this.data; }
/*   */   public final int hashCode() { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/joindata/CreateParty;)I
/*   */     //   6: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #7	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/joindata/CreateParty; } public final boolean equals(Object o) { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: aload_1
/*   */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/joindata/CreateParty;Ljava/lang/Object;)Z
/*   */     //   7: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #7	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/joindata/CreateParty;
/* 8 */     //   0	8	1	o	Ljava/lang/Object; } public static final StreamCodec<ByteBuf, CreateParty> STREAM_CODEC = StreamCodec.composite(MinigameData.STREAM_CODEC, CreateParty::data, CreateParty::new);
/*   */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\joindata\CreateParty.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */