/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.leaderboards.c2s.SubmitGlideMatchObj;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.network.codec.ByteBufCodecs;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ 
/*    */ public final class S2CMatchToSubmit extends Record implements CustomPacketPayload {
/*    */   private final SubmitGlideMatchObj obj;
/*    */   
/* 12 */   public S2CMatchToSubmit(SubmitGlideMatchObj obj) { this.obj = obj; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/S2CMatchToSubmit;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 12 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CMatchToSubmit; } public SubmitGlideMatchObj obj() { return this.obj; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/S2CMatchToSubmit;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CMatchToSubmit; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/S2CMatchToSubmit;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CMatchToSubmit;
/* 13 */     //   0	8	1	o	Ljava/lang/Object; } public static final CustomPacketPayload.Type<S2CMatchToSubmit> TYPE = new CustomPacketPayload.Type(Minimega.id("s2cmatchtosubmit"));
/* 14 */   private static final StreamCodec<ByteBuf, SubmitGlideMatchObj> INTERNAL_STREAM_CODEC = StreamCodec.composite(Identifier.STREAM_CODEC, SubmitGlideMatchObj::map, ModCodecs.DURATION_STREAM_CODEC, SubmitGlideMatchObj::duration, 
/*    */ 
/*    */       
/* 17 */       ByteBufCodecs.optional(ByteBufCodecs.INT), SubmitGlideMatchObj::score, ByteBufCodecs.BOOL, SubmitGlideMatchObj::legacy4j, SubmitGlideMatchObj::new);
/*    */ 
/*    */ 
/*    */   
/* 21 */   public static final StreamCodec<ByteBuf, S2CMatchToSubmit> STREAM_CODEC = StreamCodec.composite(INTERNAL_STREAM_CODEC, S2CMatchToSubmit::obj, S2CMatchToSubmit::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<S2CMatchToSubmit> type() {
/* 28 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\S2CMatchToSubmit.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */