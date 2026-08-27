/*    */ package dev.jab125.minimega.mod.p2p.matchmaking.obj;
/*    */ 
/*    */ import java.util.UUID;
/*    */ 
/*    */ public final class C2SPlayerInfoObj extends Record implements CodecObj<C2SPlayerInfoObj> {
/*    */   private final UUID uuid;
/*    */   private static final Codec<UUID> STRING_CODEC;
/*    */   public static final Codec<C2SPlayerInfoObj> CODEC;
/*    */   
/* 10 */   public C2SPlayerInfoObj(UUID uuid) { this.uuid = uuid; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/C2SPlayerInfoObj;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 10 */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/C2SPlayerInfoObj; } public UUID uuid() { return this.uuid; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/C2SPlayerInfoObj;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/C2SPlayerInfoObj; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/C2SPlayerInfoObj;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/C2SPlayerInfoObj;
/* 11 */     //   0	8	1	o	Ljava/lang/Object; } static { STRING_CODEC = Codec.STRING.comapFlatMap(string -> {
/*    */           try {
/*    */             return DataResult.success(UUID.fromString(string), Lifecycle.stable());
/* 14 */           } catch (IllegalArgumentException var2) {
/*    */             return DataResult.error(());
/*    */           } 
/*    */         }UUID::toString);
/*    */     
/* 19 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)STRING_CODEC.fieldOf("uuid").forGetter(C2SPlayerInfoObj::uuid)).apply((Applicative)instance, C2SPlayerInfoObj::new)); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Codec<C2SPlayerInfoObj> codec() {
/* 25 */     return CODEC;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\p2p\matchmaking\obj\C2SPlayerInfoObj.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */