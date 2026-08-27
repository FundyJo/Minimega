/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ import java.util.Optional;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ import net.minecraft.resources.Identifier;
/*    */ 
/*    */ public final class S2CGlobalSoundPayload extends Record implements CustomPacketPayload {
/*    */   private final Identifier id;
/*    */   private final Optional<BlockPos> pos;
/*    */   
/* 13 */   public S2CGlobalSoundPayload(Identifier id, Optional<BlockPos> pos) { this.id = id; this.pos = pos; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/S2CGlobalSoundPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 13 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CGlobalSoundPayload; } public Identifier id() { return this.id; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/S2CGlobalSoundPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CGlobalSoundPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/S2CGlobalSoundPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CGlobalSoundPayload;
/* 13 */     //   0	8	1	o	Ljava/lang/Object; } public Optional<BlockPos> pos() { return this.pos; }
/* 14 */    public static final CustomPacketPayload.Type<S2CGlobalSoundPayload> TYPE = new CustomPacketPayload.Type(Minimega.id("s2c_global_sound"));
/* 15 */   public static final StreamCodec<ByteBuf, S2CGlobalSoundPayload> STREAM_CODEC = StreamCodec.composite(Identifier.STREAM_CODEC, S2CGlobalSoundPayload::id, 
/*    */       
/* 17 */       ByteBufCodecs.optional(BlockPos.STREAM_CODEC), S2CGlobalSoundPayload::pos, S2CGlobalSoundPayload::new);
/*    */ 
/*    */ 
/*    */   
/*    */   public S2CGlobalSoundPayload(Identifier id) {
/* 22 */     this(id, Optional.empty());
/*    */   }
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<S2CGlobalSoundPayload> type() {
/* 27 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\S2CGlobalSoundPayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */