/*    */ package dev.jab125.minimega.mod.p2p.matchmaking.obj.leaderboards;
/*    */ public final class GlideMatchRecordObj extends Record implements CodecObj<GlideMatchRecordObj> {
/*    */   private final int place;
/*    */   private final String displayName;
/*    */   private final Optional<Duration> duration;
/*    */   private final Optional<Integer> score;
/*    */   private final boolean legacy4j;
/*    */   private final int protocolVersion;
/*    */   public static final Codec<GlideMatchRecordObj> CODEC;
/*    */   
/* 11 */   public GlideMatchRecordObj(int place, String displayName, Optional<Duration> duration, Optional<Integer> score, boolean legacy4j, int protocolVersion) { this.place = place; this.displayName = displayName; this.duration = duration; this.score = score; this.legacy4j = legacy4j; this.protocolVersion = protocolVersion; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/GlideMatchRecordObj;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 11 */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/GlideMatchRecordObj; } public int place() { return this.place; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/GlideMatchRecordObj;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/GlideMatchRecordObj; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/GlideMatchRecordObj;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/GlideMatchRecordObj;
/* 11 */     //   0	8	1	o	Ljava/lang/Object; } public String displayName() { return this.displayName; } public Optional<Duration> duration() { return this.duration; } public Optional<Integer> score() { return this.score; } public boolean legacy4j() { return this.legacy4j; } public int protocolVersion() { return this.protocolVersion; } static {
/* 12 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.INT.fieldOf("position").forGetter(GlideMatchRecordObj::place), (App)Codec.STRING.fieldOf("display_name").forGetter(GlideMatchRecordObj::displayName), (App)ModCodecs.DURATION_CODEC.optionalFieldOf("duration").forGetter(GlideMatchRecordObj::duration), (App)Codec.INT.optionalFieldOf("score").forGetter(GlideMatchRecordObj::score), (App)Codec.BOOL.fieldOf("legacy4j").forGetter(GlideMatchRecordObj::legacy4j), (App)Codec.INT.fieldOf("version").forGetter(GlideMatchRecordObj::protocolVersion)).apply((Applicative)instance, GlideMatchRecordObj::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Codec<GlideMatchRecordObj> codec() {
/* 23 */     return CODEC;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\p2p\matchmaking\obj\leaderboards\GlideMatchRecordObj.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */