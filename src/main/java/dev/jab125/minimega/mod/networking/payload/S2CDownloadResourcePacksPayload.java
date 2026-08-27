/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ 
/*    */ public final class S2CDownloadResourcePacksPayload extends Record implements CustomPacketPayload {
/*    */   private final List<MinimegaPackObj> packs;
/*    */   
/* 10 */   public S2CDownloadResourcePacksPayload(List<MinimegaPackObj> packs) { this.packs = packs; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/S2CDownloadResourcePacksPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 10 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CDownloadResourcePacksPayload; } public List<MinimegaPackObj> packs() { return this.packs; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/S2CDownloadResourcePacksPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CDownloadResourcePacksPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/S2CDownloadResourcePacksPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CDownloadResourcePacksPayload;
/* 11 */     //   0	8	1	o	Ljava/lang/Object; } public static final CustomPacketPayload.Type<S2CDownloadResourcePacksPayload> TYPE = new CustomPacketPayload.Type(Minimega.id("download_resource_packs"));
/* 12 */   public static final StreamCodec<ByteBuf, S2CDownloadResourcePacksPayload> STREAM_CODEC = StreamCodec.composite(MinimegaPackObj.COLLECTION_STREAM_CODEC, S2CDownloadResourcePacksPayload::packs, S2CDownloadResourcePacksPayload::new);
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<S2CDownloadResourcePacksPayload> type() {
/* 16 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\S2CDownloadResourcePacksPayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */