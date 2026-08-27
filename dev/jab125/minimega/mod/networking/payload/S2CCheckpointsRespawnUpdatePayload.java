/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ import net.minecraft.network.codec.ByteBufCodecs;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ 
/*    */ public final class S2CCheckpointsRespawnUpdatePayload extends Record implements CustomPacketPayload {
/*    */   private final int checkpoint;
/*    */   private final int respawnCheckpoint;
/*    */   private final boolean finishedMap;
/*    */   private final int score;
/*    */   
/* 13 */   public S2CCheckpointsRespawnUpdatePayload(int checkpoint, int respawnCheckpoint, boolean finishedMap, int score) { this.checkpoint = checkpoint; this.respawnCheckpoint = respawnCheckpoint; this.finishedMap = finishedMap; this.score = score; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/S2CCheckpointsRespawnUpdatePayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 13 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CCheckpointsRespawnUpdatePayload; } public int checkpoint() { return this.checkpoint; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/S2CCheckpointsRespawnUpdatePayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CCheckpointsRespawnUpdatePayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/S2CCheckpointsRespawnUpdatePayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CCheckpointsRespawnUpdatePayload;
/* 13 */     //   0	8	1	o	Ljava/lang/Object; } public int respawnCheckpoint() { return this.respawnCheckpoint; } public boolean finishedMap() { return this.finishedMap; } public int score() { return this.score; }
/* 14 */    public static final CustomPacketPayload.Type<S2CCheckpointsRespawnUpdatePayload> TYPE = new CustomPacketPayload.Type(Minimega.id("s2crpup"));
/* 15 */   public static final StreamCodec<RegistryFriendlyByteBuf, S2CCheckpointsRespawnUpdatePayload> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, S2CCheckpointsRespawnUpdatePayload::checkpoint, ByteBufCodecs.INT, S2CCheckpointsRespawnUpdatePayload::respawnCheckpoint, ByteBufCodecs.BOOL, S2CCheckpointsRespawnUpdatePayload::finishedMap, ByteBufCodecs.VAR_INT, S2CCheckpointsRespawnUpdatePayload::score, S2CCheckpointsRespawnUpdatePayload::new);
/*    */   
/*    */   public S2CCheckpointsRespawnUpdatePayload(ServerPlayer serverPlayer) {
/* 18 */     this(((EntityExtension)serverPlayer).mm$checkpoint(), ((EntityExtension)serverPlayer).mm$respawnCheckpoont(), ((EntityExtension)serverPlayer).mm$finishedMap(), ((Integer)MinigamesController.getMinigameController((Level)serverPlayer.level()).getControllerOpt(Minigame.GLIDE).map(controller -> Integer.valueOf(controller.getScoreRingTracker().pointsOf(serverPlayer.getUUID()))).orElse(Integer.valueOf(0))).intValue());
/*    */   }
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<S2CCheckpointsRespawnUpdatePayload> type() {
/* 23 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\S2CCheckpointsRespawnUpdatePayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */