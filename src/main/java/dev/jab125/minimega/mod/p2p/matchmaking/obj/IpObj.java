/*    */ package dev.jab125.minimega.mod.p2p.matchmaking.obj;
/*    */ public final class IpObj extends Record implements CodecObj<IpObj> {
/*    */   private final String ip;
/*    */   public static final Codec<IpObj> CODEC;
/*    */   
/*  6 */   public IpObj(String ip) { this.ip = ip; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/IpObj;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #6	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  6 */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/IpObj; } public String ip() { return this.ip; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/IpObj;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #6	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/IpObj; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/IpObj;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #6	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/IpObj;
/*  7 */     //   0	8	1	o	Ljava/lang/Object; } static { CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.STRING.fieldOf("ip").forGetter(IpObj::ip)).apply((Applicative)instance, IpObj::new)); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Codec<IpObj> codec() {
/* 13 */     return CODEC;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\p2p\matchmaking\obj\IpObj.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */