/*    */ package dev.jab125.minimega.mod.p2p.matchmaking.obj;
/*    */ public final class SuccessObj extends Record implements CodecObj<SuccessObj> {
/*    */   private final String string;
/*    */   public static final Codec<SuccessObj> CODEC;
/*    */   
/*  6 */   public SuccessObj(String string) { this.string = string; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/SuccessObj;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #6	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  6 */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/SuccessObj; } public String string() { return this.string; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/SuccessObj;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #6	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/SuccessObj; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/SuccessObj;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #6	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/SuccessObj;
/*  7 */     //   0	8	1	o	Ljava/lang/Object; } static { CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.STRING.fieldOf("message").forGetter(SuccessObj::string)).apply((Applicative)instance, SuccessObj::new)); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Codec<SuccessObj> codec() {
/* 13 */     return CODEC;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\p2p\matchmaking\obj\SuccessObj.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */