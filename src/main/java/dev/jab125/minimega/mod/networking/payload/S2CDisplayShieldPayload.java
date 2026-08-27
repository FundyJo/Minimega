/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ import net.minecraft.resources.Identifier;
/*    */ 
/*    */ public final class S2CDisplayShieldPayload extends Record implements CustomPacketPayload {
/*    */   private final Identifier sprite;
/*    */   private final Component component;
/*    */   private final int priority;
/*    */   
/* 12 */   public S2CDisplayShieldPayload(Identifier sprite, Component component, int priority) { this.sprite = sprite; this.component = component; this.priority = priority; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/S2CDisplayShieldPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 12 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CDisplayShieldPayload; } public Identifier sprite() { return this.sprite; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/S2CDisplayShieldPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CDisplayShieldPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/S2CDisplayShieldPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CDisplayShieldPayload;
/* 12 */     //   0	8	1	o	Ljava/lang/Object; } public Component component() { return this.component; } public int priority() { return this.priority; }
/* 13 */    public static final CustomPacketPayload.Type<S2CDisplayShieldPayload> TYPE = new CustomPacketPayload.Type(Minimega.id("s2cdisplayshield"));
/* 14 */   public static final StreamCodec<ByteBuf, S2CDisplayShieldPayload> STREAM_CODEC = StreamCodec.composite(Identifier.STREAM_CODEC, S2CDisplayShieldPayload::sprite, ComponentSerialization.TRUSTED_CONTEXT_FREE_STREAM_CODEC, S2CDisplayShieldPayload::component, ByteBufCodecs.VAR_INT, S2CDisplayShieldPayload::priority, S2CDisplayShieldPayload::new);
/*    */   
/*    */   public S2CDisplayShieldPayload(Identifier sprite, Component component) {
/* 17 */     this(sprite, component, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<S2CDisplayShieldPayload> type() {
/* 22 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\S2CDisplayShieldPayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */