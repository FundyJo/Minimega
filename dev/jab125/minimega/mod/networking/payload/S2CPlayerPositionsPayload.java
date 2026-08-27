/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ 
/*    */ public final class S2CPlayerPositionsPayload extends Record implements CustomPacketPayload {
/*    */   private final List<GlideMinigameController.PlayerInformation> playerInformations;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/S2CPlayerPositionsPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #15	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CPlayerPositionsPayload;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/S2CPlayerPositionsPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #15	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CPlayerPositionsPayload;
/*    */   }
/*    */   
/* 15 */   public S2CPlayerPositionsPayload(List<GlideMinigameController.PlayerInformation> playerInformations) { this.playerInformations = playerInformations; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/S2CPlayerPositionsPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #15	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CPlayerPositionsPayload;
/* 15 */     //   0	8	1	o	Ljava/lang/Object; } public List<GlideMinigameController.PlayerInformation> playerInformations() { return this.playerInformations; }
/* 16 */    public static final CustomPacketPayload.Type<S2CPlayerPositionsPayload> TYPE = new CustomPacketPayload.Type(Minimega.id("s2c_player_positions"));
/* 17 */   public static final StreamCodec<RegistryFriendlyByteBuf, S2CPlayerPositionsPayload> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.list().apply(GlideMinigameController.PlayerInformation.STREAM_CODEC), S2CPlayerPositionsPayload::playerInformations, S2CPlayerPositionsPayload::new);
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<S2CPlayerPositionsPayload> type() {
/* 21 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\S2CPlayerPositionsPayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */