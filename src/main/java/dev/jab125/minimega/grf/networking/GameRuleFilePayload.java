/*    */ package dev.jab125.minimega.grf.networking;
/*    */ 
/*    */ import dev.jab125.minimega.grf.newelements.mxml.grf.__ROOT__;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.Optional;
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.network.codec.ByteBufCodecs;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ 
/*    */ public final class GameRuleFilePayload extends Record implements CustomPacketPayload {
/*    */   private final Optional<__ROOT__> root;
/*    */   
/* 14 */   public GameRuleFilePayload(Optional<__ROOT__> root) { this.root = root; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/grf/networking/GameRuleFilePayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 14 */     //   0	7	0	this	Ldev/jab125/minimega/grf/networking/GameRuleFilePayload; } public Optional<__ROOT__> root() { return this.root; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/grf/networking/GameRuleFilePayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/grf/networking/GameRuleFilePayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/grf/networking/GameRuleFilePayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/grf/networking/GameRuleFilePayload;
/* 15 */     //   0	8	1	o	Ljava/lang/Object; } public static final CustomPacketPayload.Type<GameRuleFilePayload> TYPE = new CustomPacketPayload.Type(Identifier.parse("minimega_grf_minecraft:grf_payload"));
/* 16 */   public static final StreamCodec<ByteBuf, GameRuleFilePayload> STREAM_CODEC = StreamCodec.composite(
/* 17 */       ByteBufCodecs.optional(ByteBufCodecs.fromCodecTrusted(GrfCodecs.CODEC)), GameRuleFilePayload::root, GameRuleFilePayload::new);
/*    */ 
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<GameRuleFilePayload> type() {
/* 22 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\networking\GameRuleFilePayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */