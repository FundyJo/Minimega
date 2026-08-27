/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ import net.minecraft.resources.Identifier;
/*    */ 
/*    */ public final class C2SVotePayload extends Record implements CustomPacketPayload {
/*    */   private final Identifier resourceLocation;
/*    */   
/*  9 */   public C2SVotePayload(Identifier resourceLocation) { this.resourceLocation = resourceLocation; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/C2SVotePayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  9 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/C2SVotePayload; } public Identifier resourceLocation() { return this.resourceLocation; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/C2SVotePayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/C2SVotePayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/C2SVotePayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/C2SVotePayload;
/* 10 */     //   0	8	1	o	Ljava/lang/Object; } public static final CustomPacketPayload.Type<C2SVotePayload> TYPE = new CustomPacketPayload.Type(Minimega.id("vote"));
/* 11 */   public static final StreamCodec<ByteBuf, C2SVotePayload> CODEC = Identifier.STREAM_CODEC.map(C2SVotePayload::new, C2SVotePayload::resourceLocation);
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<C2SVotePayload> type() {
/* 15 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\C2SVotePayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */