/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import dev.jab125.minimega.mod.util.NewScreenData;
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ 
/*    */ public final class S2COpenDataScreenPayload extends Record implements CustomPacketPayload {
/*    */   private final Minigame<?> minigame;
/*    */   private final NewScreenData data;
/*    */   
/* 13 */   public S2COpenDataScreenPayload(Minigame<?> minigame, NewScreenData data) { this.minigame = minigame; this.data = data; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/S2COpenDataScreenPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 13 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2COpenDataScreenPayload; } public Minigame<?> minigame() { return this.minigame; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/S2COpenDataScreenPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2COpenDataScreenPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/S2COpenDataScreenPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/S2COpenDataScreenPayload;
/* 13 */     //   0	8	1	o	Ljava/lang/Object; } public NewScreenData data() { return this.data; }
/* 14 */    public static final CustomPacketPayload.Type<S2COpenDataScreenPayload> TYPE = new CustomPacketPayload.Type(Minimega.id("s2copendatascreen"));
/* 15 */   public static final StreamCodec<ByteBuf, S2COpenDataScreenPayload> STREAM_CODEC = StreamCodec.composite(
/* 16 */       ByteBufCodecs.idMapper(Minigame::fromId, Minigame::getId), S2COpenDataScreenPayload::minigame, NewScreenData.STREAM_CODEC, S2COpenDataScreenPayload::data, S2COpenDataScreenPayload::new);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public S2COpenDataScreenPayload(Minigame<?> minigame, Function<Minigame<?>, NewScreenData> dataFunction) {
/* 22 */     this(minigame, dataFunction.apply(minigame));
/*    */   }
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<S2COpenDataScreenPayload> type() {
/* 27 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\S2COpenDataScreenPayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */