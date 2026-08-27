/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ import dev.jab125.minimega.mod.util.controller.glide.GlideGameType;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.network.codec.ByteBufCodecs;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ 
/*    */ public final class S2CGlideFinishPayload extends Record implements CustomPacketPayload {
/*    */   private final UUID playerUuid;
/*    */   private final int place;
/*    */   private final boolean bestResult;
/*    */   private final GlideGameType glideGameType;
/*    */   
/* 14 */   public S2CGlideFinishPayload(UUID playerUuid, int place, boolean bestResult, GlideGameType glideGameType) { this.playerUuid = playerUuid; this.place = place; this.bestResult = bestResult; this.glideGameType = glideGameType; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/S2CGlideFinishPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 14 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CGlideFinishPayload; } public UUID playerUuid() { return this.playerUuid; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/S2CGlideFinishPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CGlideFinishPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/S2CGlideFinishPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CGlideFinishPayload;
/* 14 */     //   0	8	1	o	Ljava/lang/Object; } public int place() { return this.place; } public boolean bestResult() { return this.bestResult; } public GlideGameType glideGameType() { return this.glideGameType; }
/* 15 */    public static final CustomPacketPayload.Type<S2CGlideFinishPayload> TYPE = new CustomPacketPayload.Type(Minimega.id("s2c_glide_finish"));
/* 16 */   public static final StreamCodec<RegistryFriendlyByteBuf, S2CGlideFinishPayload> STREAM_CODEC = StreamCodec.composite(UUIDUtil.STREAM_CODEC, S2CGlideFinishPayload::playerUuid, ByteBufCodecs.VAR_INT, S2CGlideFinishPayload::place, ByteBufCodecs.BOOL, S2CGlideFinishPayload::bestResult, GlideGameType.STREAM_CODEC, S2CGlideFinishPayload::glideGameType, S2CGlideFinishPayload::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Identifier soundForResult(S2CGlideFinishPayload payload)
/*    */   {
/* 25 */     if (payload instanceof S2CGlideFinishPayload) { S2CGlideFinishPayload s2CGlideFinishPayload = payload; try { int place; boolean bestResult; GlideGameType glideGameType; UUID uUID = s2CGlideFinishPayload.playerUuid(); int i = s2CGlideFinishPayload.place(), j = i; if (true) { place = i; boolean bool1 = s2CGlideFinishPayload.bestResult(), bool2 = bool1; if (true) { bestResult = bool1; GlideGameType glideGameType1 = s2CGlideFinishPayload.glideGameType(); } else { throw new NullPointerException(); }  } else { throw new NullPointerException(); }
/* 26 */          switch (place) { case 1: case 2: case 3:
/* 27 */             switch (glideGameType) { default: throw new MatchException(null, null);
/*    */               case TIME_ATTACK: 
/*    */               case SCORE_ATTACK: break; } 
/*    */           default:
/* 31 */             break; }  return Minimega.id("glide_finish" + ""); }
/*    */       catch (Throwable throwable)
/*    */       { throw new MatchException(throwable.toString(), throwable); }
/*    */        }
/*    */     
/*    */     throw new NullPointerException(); } public CustomPacketPayload.Type<S2CGlideFinishPayload> type() {
/* 37 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\S2CGlideFinishPayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */