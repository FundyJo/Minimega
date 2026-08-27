/*    */ package dev.jab125.minimega.mod.p2p.matchmaking.obj;
/*    */ public final class ErrorObj extends Record implements CodecObj<ErrorObj> { private final String error;
/*    */   private final int code;
/*    */   public static Codec<ErrorObj> CODEC;
/*    */   
/*  6 */   public ErrorObj(String error, int code) { this.error = error; this.code = code; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/ErrorObj;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #6	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  6 */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/ErrorObj; } public String error() { return this.error; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/ErrorObj;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #6	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/ErrorObj; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/ErrorObj;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #6	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/ErrorObj;
/*  6 */     //   0	8	1	o	Ljava/lang/Object; } public int code() { return this.code; } static {
/*  7 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.STRING.fieldOf("error").forGetter(ErrorObj::error), (App)Codec.INT.fieldOf("code").forGetter(ErrorObj::code)).apply((Applicative)instance, ErrorObj::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Codec<ErrorObj> codec() {
/* 14 */     return CODEC;
/*    */   } }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\p2p\matchmaking\obj\ErrorObj.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */