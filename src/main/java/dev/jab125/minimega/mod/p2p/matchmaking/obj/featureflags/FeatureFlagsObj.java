/*    */ package dev.jab125.minimega.mod.p2p.matchmaking.obj.featureflags;
/*    */ 
/*    */ 
/*    */ public final class FeatureFlagsObj extends Record implements CodecObj<FeatureFlagsObj> {
/*    */   private final List<String> features;
/*    */   public static final String BATTLE = "battle";
/*    */   public static final String INVITATION_MENU = "Feature Flags Invites Menu";
/*    */   
/*  9 */   public FeatureFlagsObj(List<String> features) { this.features = features; } public static final String TUMBLE = "tumble"; public static final String CHAT = "can_use_chat"; public static final Codec<FeatureFlagsObj> CODEC; public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/featureflags/FeatureFlagsObj;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  9 */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/featureflags/FeatureFlagsObj; } public List<String> features() { return this.features; } public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/featureflags/FeatureFlagsObj;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/featureflags/FeatureFlagsObj;
/*    */   } public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/featureflags/FeatureFlagsObj;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/featureflags/FeatureFlagsObj;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   } static {
/* 14 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.STRING.listOf().fieldOf("features").forGetter(FeatureFlagsObj::features)).apply((Applicative)instance, FeatureFlagsObj::new));
/*    */   }
/*    */   
/*    */   public Codec<FeatureFlagsObj> codec() {
/* 18 */     return CODEC;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\p2p\matchmaking\obj\featureflags\FeatureFlagsObj.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */