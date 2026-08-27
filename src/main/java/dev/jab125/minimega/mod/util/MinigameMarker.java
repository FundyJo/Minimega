/*   */ package dev.jab125.minimega.mod.util;
/*   */ public final class MinigameMarker extends Record {
/*   */   private final boolean dummyBooleanIdk;
/*   */   public static final Codec<MinigameMarker> CODEC;
/*   */   
/* 6 */   public MinigameMarker(boolean dummyBooleanIdk) { this.dummyBooleanIdk = dummyBooleanIdk; } public final String toString() { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/MinigameMarker;)Ljava/lang/String;
/*   */     //   6: areturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #6	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/* 6 */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/MinigameMarker; } public boolean dummyBooleanIdk() { return this.dummyBooleanIdk; }
/*   */   public final int hashCode() { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/MinigameMarker;)I
/*   */     //   6: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #6	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/MinigameMarker; } public final boolean equals(Object o) { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: aload_1
/*   */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/MinigameMarker;Ljava/lang/Object;)Z
/*   */     //   7: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #6	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/MinigameMarker;
/* 7 */     //   0	8	1	o	Ljava/lang/Object; } static { CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.BOOL.fieldOf("dummyBooleanIdk").forGetter(MinigameMarker::dummyBooleanIdk)).apply((Applicative)instance, MinigameMarker::new)); }
/*   */ 
/*   */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\MinigameMarker.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */