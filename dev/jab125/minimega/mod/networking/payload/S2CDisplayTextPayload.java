/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ 
/*    */ public final class S2CDisplayTextPayload extends Record implements CustomPacketPayload {
/*    */   private final Component component;
/*    */   
/* 10 */   public S2CDisplayTextPayload(Component component) { this.component = component; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/S2CDisplayTextPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 10 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CDisplayTextPayload; } public Component component() { return this.component; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/S2CDisplayTextPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CDisplayTextPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/S2CDisplayTextPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CDisplayTextPayload;
/* 11 */     //   0	8	1	o	Ljava/lang/Object; } public static final CustomPacketPayload.Type<S2CDisplayTextPayload> TYPE = new CustomPacketPayload.Type(Minimega.id("display_text"));
/* 12 */   public static final StreamCodec<RegistryFriendlyByteBuf, S2CDisplayTextPayload> STREAM_CODEC = StreamCodec.composite(ComponentSerialization.STREAM_CODEC, S2CDisplayTextPayload::component, S2CDisplayTextPayload::new);
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<S2CDisplayTextPayload> type() {
/* 16 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\S2CDisplayTextPayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */