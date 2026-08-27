/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ import dev.jab125.minimega.mod.util.controller.glide.GlideMinigameController;
/*    */ import java.util.ArrayList;
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.network.RegistryFriendlyByteBuf;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ 
/*    */ public final class S2CThermalsPayload extends Record implements CustomPacketPayload {
/*    */   private final ArrayList<GlideMinigameController.Thermal> thermals;
/*    */   
/* 13 */   public S2CThermalsPayload(ArrayList<GlideMinigameController.Thermal> thermals) { this.thermals = thermals; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/S2CThermalsPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 13 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CThermalsPayload; } public ArrayList<GlideMinigameController.Thermal> thermals() { return this.thermals; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/S2CThermalsPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CThermalsPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/S2CThermalsPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CThermalsPayload;
/* 14 */     //   0	8	1	o	Ljava/lang/Object; } public static final CustomPacketPayload.Type<S2CThermalsPayload> TYPE = new CustomPacketPayload.Type(Minimega.id("thermals")); private static final StreamCodec<ByteBuf, ArrayList<GlideMinigameController.Thermal>> THERMALS_LIST_CODEC; static {
/* 15 */     THERMALS_LIST_CODEC = ByteBufCodecs.list().apply(GlideMinigameController.Thermal.STREAM_CODEC).map(ArrayList::new, a -> a);
/* 16 */   } public static final StreamCodec<RegistryFriendlyByteBuf, S2CThermalsPayload> STREAM_CODEC = StreamCodec.composite(THERMALS_LIST_CODEC, S2CThermalsPayload::thermals, S2CThermalsPayload::new);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<S2CThermalsPayload> type() {
/* 22 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\S2CThermalsPayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */