/*    */ package dev.jab125.minimega.mod.util.joindata;
/*    */ 
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ 
/*    */ public final class FriendData extends Record implements CreateOrJoin {
/*    */   private final UUID friendUUID;
/*    */   private final Minigame<?> minigame;
/*    */   
/* 11 */   public FriendData(UUID friendUUID, Minigame<?> minigame) { this.friendUUID = friendUUID; this.minigame = minigame; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/joindata/FriendData;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 11 */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/joindata/FriendData; } public UUID friendUUID() { return this.friendUUID; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/joindata/FriendData;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/joindata/FriendData; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/joindata/FriendData;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/joindata/FriendData;
/* 11 */     //   0	8	1	o	Ljava/lang/Object; } public Minigame<?> minigame() { return this.minigame; }
/* 12 */    public static final StreamCodec<ByteBuf, FriendData> STREAM_CODEC = StreamCodec.composite(UUIDUtil.STREAM_CODEC, FriendData::friendUUID, ByteBufCodecs.INT
/*    */       
/* 14 */       .map(Minigame::fromId, Minigame::getId), FriendData::minigame, FriendData::new);
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\joindata\FriendData.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */