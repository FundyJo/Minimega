/*    */ package dev.jab125.minimega.mod.p2p.matchmaking.obj.leaderboards.c2s;
/*    */ 
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import net.minecraft.resources.Identifier;
/*    */ 
/*    */ public final class SubmitGlideMatchObj extends Record implements CodecObj<SubmitGlideMatchObj> {
/*    */   private final Identifier map;
/*    */   private final Duration duration;
/*    */   private final Optional<Integer> score;
/*    */   private final boolean legacy4j;
/*    */   public static final Codec<SubmitGlideMatchObj> CODEC;
/*    */   
/* 15 */   public SubmitGlideMatchObj(Identifier map, Duration duration, Optional<Integer> score, boolean legacy4j) { this.map = map; this.duration = duration; this.score = score; this.legacy4j = legacy4j; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/c2s/SubmitGlideMatchObj;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #15	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 15 */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/c2s/SubmitGlideMatchObj; } public Identifier map() { return this.map; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/c2s/SubmitGlideMatchObj;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #15	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/c2s/SubmitGlideMatchObj; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/c2s/SubmitGlideMatchObj;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #15	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/leaderboards/c2s/SubmitGlideMatchObj;
/* 15 */     //   0	8	1	o	Ljava/lang/Object; } public Duration duration() { return this.duration; } public Optional<Integer> score() { return this.score; } public boolean legacy4j() { return this.legacy4j; } static {
/* 16 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Identifier.CODEC.fieldOf("map").forGetter(SubmitGlideMatchObj::map), (App)ModCodecs.DURATION_CODEC.fieldOf("duration").forGetter(SubmitGlideMatchObj::duration), (App)Codec.INT.optionalFieldOf("score").forGetter(SubmitGlideMatchObj::score), (App)Codec.BOOL.fieldOf("legacy4j").forGetter(SubmitGlideMatchObj::legacy4j)).apply((Applicative)instance, SubmitGlideMatchObj::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Codec<SubmitGlideMatchObj> codec() {
/* 25 */     return CODEC;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\p2p\matchmaking\obj\leaderboards\c2s\SubmitGlideMatchObj.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */