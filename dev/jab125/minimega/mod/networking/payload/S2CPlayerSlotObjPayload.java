/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ import dev.jab125.minimega.mod.party.PlayerSlotObjs;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ 
/*    */ public final class S2CPlayerSlotObjPayload extends Record implements CustomPacketPayload {
/*    */   private final PlayerSlotObjs objs;
/*    */   
/*  9 */   public S2CPlayerSlotObjPayload(PlayerSlotObjs objs) { this.objs = objs; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/S2CPlayerSlotObjPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  9 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CPlayerSlotObjPayload; } public PlayerSlotObjs objs() { return this.objs; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/S2CPlayerSlotObjPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CPlayerSlotObjPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/S2CPlayerSlotObjPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/S2CPlayerSlotObjPayload;
/* 10 */     //   0	8	1	o	Ljava/lang/Object; } public static final CustomPacketPayload.Type<S2CPlayerSlotObjPayload> TYPE = new CustomPacketPayload.Type(Minimega.id("s2c_playerslotobjspayload"));
/* 11 */   public static final StreamCodec<RegistryFriendlyByteBuf, S2CPlayerSlotObjPayload> STREAM_CODEC = StreamCodec.composite(PlayerSlotObjs.STREAM_CODEC, S2CPlayerSlotObjPayload::objs, S2CPlayerSlotObjPayload::new);
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<S2CPlayerSlotObjPayload> type() {
/* 15 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\S2CPlayerSlotObjPayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */