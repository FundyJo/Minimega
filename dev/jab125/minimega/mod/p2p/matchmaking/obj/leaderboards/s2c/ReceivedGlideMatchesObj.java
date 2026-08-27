/*    */ package dev.jab125.minimega.mod.p2p.matchmaking.obj.leaderboards.s2c;
/*    */ 
/*    */ 
/*    */ public final class ReceivedGlideMatchesObj extends Record implements CodecObj<ReceivedGlideMatchesObj> {
/*    */   private final List<GlideMatchRecordObj> records;
/*    */   private final int offset;
/*    */   private final int total;
/*    */   public static final Codec<ReceivedGlideMatchesObj> CODEC;
/*    */   
/* 10 */   public ReceivedGlideMatchesObj(List<GlideMatchRecordObj> records, int offset, int total) { this.records = records; this.offset = offset; this.total = total; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/s2c/ReceivedGlideMatchesObj;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 10 */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/s2c/ReceivedGlideMatchesObj; } public List<GlideMatchRecordObj> records() { return this.records; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/s2c/ReceivedGlideMatchesObj;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/s2c/ReceivedGlideMatchesObj; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/s2c/ReceivedGlideMatchesObj;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/s2c/ReceivedGlideMatchesObj;
/* 10 */     //   0	8	1	o	Ljava/lang/Object; } public int offset() { return this.offset; } public int total() { return this.total; } static {
/* 11 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)GlideMatchRecordObj.CODEC.listOf().fieldOf("records").forGetter(ReceivedGlideMatchesObj::records), (App)Codec.INT.fieldOf("offset").forGetter(ReceivedGlideMatchesObj::offset), (App)Codec.INT.fieldOf("total").forGetter(ReceivedGlideMatchesObj::total)).apply((Applicative)instance, ReceivedGlideMatchesObj::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Codec<ReceivedGlideMatchesObj> codec() {
/* 19 */     return CODEC;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\p2p\matchmaking\obj\leaderboards\s2c\ReceivedGlideMatchesObj.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */