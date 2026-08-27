/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.network.codec.ByteBufCodecs;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.resources.Identifier;
/*    */ 
/*    */ public final class MinimegaPackObj extends Record {
/*    */   private final Identifier packId;
/*    */   private final String url;
/*    */   private final String hash;
/*    */   private final boolean required;
/*    */   
/* 14 */   public boolean required() { return this.required; } public String hash() { return this.hash; } public String url() { return this.url; } public Identifier packId() { return this.packId; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/MinimegaPackObj;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/MinimegaPackObj;
/* 14 */     //   0	8	1	o	Ljava/lang/Object; } public MinimegaPackObj(Identifier packId, String url, String hash, boolean required) { this.packId = packId; this.url = url; this.hash = hash; this.required = required; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/MinimegaPackObj;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/MinimegaPackObj; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/MinimegaPackObj;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 15 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/MinimegaPackObj; } public static final StreamCodec<ByteBuf, MinimegaPackObj> STREAM_CODEC = StreamCodec.composite(Identifier.STREAM_CODEC, MinimegaPackObj::packId, ByteBufCodecs.STRING_UTF8, MinimegaPackObj::url, ByteBufCodecs.STRING_UTF8, MinimegaPackObj::hash, ByteBufCodecs.BOOL, MinimegaPackObj::required, MinimegaPackObj::new);
/* 16 */   public static final StreamCodec<ByteBuf, List<MinimegaPackObj>> COLLECTION_STREAM_CODEC = ByteBufCodecs.list().apply(STREAM_CODEC);
/*    */   
/*    */   public MinimegaPackObj(Identifier packId, String url, String hash) {
/* 19 */     this(packId, url, hash, true);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\MinimegaPackObj.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */