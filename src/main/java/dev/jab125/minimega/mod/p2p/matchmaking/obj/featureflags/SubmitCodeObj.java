/*    */ package dev.jab125.minimega.mod.p2p.matchmaking.obj.featureflags;
/*    */ 
/*    */ public final class SubmitCodeObj extends Record implements CodecObj<SubmitCodeObj> {
/*    */   private final String code;
/*    */   public static final Codec<SubmitCodeObj> CODEC;
/*    */   
/*  7 */   public SubmitCodeObj(String code) { this.code = code; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/featureflags/SubmitCodeObj;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  7 */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/featureflags/SubmitCodeObj; } public String code() { return this.code; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/featureflags/SubmitCodeObj;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/featureflags/SubmitCodeObj; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/featureflags/SubmitCodeObj;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/featureflags/SubmitCodeObj;
/*  8 */     //   0	8	1	o	Ljava/lang/Object; } static { CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.STRING.fieldOf("code").forGetter(SubmitCodeObj::code)).apply((Applicative)instance, SubmitCodeObj::new)); }
/*    */ 
/*    */   
/*    */   public Codec<SubmitCodeObj> codec() {
/* 12 */     return CODEC;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\p2p\matchmaking\obj\featureflags\SubmitCodeObj.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */