/*    */ package dev.jab125.minimega.mod.p2p.matchmaking.obj;
/*    */ 
/*    */ public final class AccessTokenObj extends Record implements CodecObj<AccessTokenObj> {
/*    */   private final String token;
/*    */   public static final Codec<AccessTokenObj> CODEC;
/*    */   
/*  7 */   public AccessTokenObj(String token) { this.token = token; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/AccessTokenObj;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  7 */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/AccessTokenObj; } public String token() { return this.token; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/AccessTokenObj;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/AccessTokenObj; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/AccessTokenObj;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/AccessTokenObj;
/*  8 */     //   0	8	1	o	Ljava/lang/Object; } static { CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.STRING.fieldOf("token").forGetter(AccessTokenObj::token)).apply((Applicative)instance, AccessTokenObj::new)); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Codec<AccessTokenObj> codec() {
/* 14 */     return CODEC;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\p2p\matchmaking\obj\AccessTokenObj.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */