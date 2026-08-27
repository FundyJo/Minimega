/*    */ package dev.jab125.minimega.mod.p2p.matchmaking.obj.leaderboards.c2s;
/*    */ public final class FetchGlideMatchesObj extends Record implements CodecObj<FetchGlideMatchesObj> {
/*    */   private final GlideGameType type;
/*    */   private final Identifier mapId;
/*    */   private final int amount;
/*    */   private final int offset;
/*    */   private final boolean onlyVerified;
/*    */   public static final Codec<FetchGlideMatchesObj> CODEC;
/*    */   
/* 10 */   public FetchGlideMatchesObj(GlideGameType type, Identifier mapId, int amount, int offset, boolean onlyVerified) { this.type = type; this.mapId = mapId; this.amount = amount; this.offset = offset; this.onlyVerified = onlyVerified; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/c2s/FetchGlideMatchesObj;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 10 */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/c2s/FetchGlideMatchesObj; } public GlideGameType type() { return this.type; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/c2s/FetchGlideMatchesObj;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/c2s/FetchGlideMatchesObj; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/c2s/FetchGlideMatchesObj;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/c2s/FetchGlideMatchesObj;
/* 10 */     //   0	8	1	o	Ljava/lang/Object; } public Identifier mapId() { return this.mapId; } public int amount() { return this.amount; } public int offset() { return this.offset; } public boolean onlyVerified() { return this.onlyVerified; } static {
/* 11 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)GlideGameType.CODEC.fieldOf("type").forGetter(FetchGlideMatchesObj::type), (App)Identifier.CODEC.fieldOf("map_id").forGetter(FetchGlideMatchesObj::mapId), (App)Codec.INT.fieldOf("amount").forGetter(FetchGlideMatchesObj::amount), (App)Codec.INT.fieldOf("offset").forGetter(FetchGlideMatchesObj::offset), (App)Codec.BOOL.fieldOf("verified_only").forGetter(FetchGlideMatchesObj::onlyVerified)).apply((Applicative)instance, FetchGlideMatchesObj::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Codec<FetchGlideMatchesObj> codec() {
/* 21 */     return CODEC;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\p2p\matchmaking\obj\leaderboards\c2s\FetchGlideMatchesObj.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */