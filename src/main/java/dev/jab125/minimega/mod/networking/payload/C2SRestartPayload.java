/*    */ package dev.jab125.minimega.mod.networking.payload;
/*    */ 
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ 
/*    */ public final class C2SRestartPayload extends Record implements CustomPacketPayload {
/*    */   private final boolean fromStart;
/*    */   
/*  9 */   public C2SRestartPayload(boolean fromStart) { this.fromStart = fromStart; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/networking/payload/C2SRestartPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  9 */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/C2SRestartPayload; } public boolean fromStart() { return this.fromStart; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/networking/payload/C2SRestartPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/networking/payload/C2SRestartPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/networking/payload/C2SRestartPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/networking/payload/C2SRestartPayload;
/* 10 */     //   0	8	1	o	Ljava/lang/Object; } public static final CustomPacketPayload.Type<C2SRestartPayload> TYPE = new CustomPacketPayload.Type(Minimega.id("c2srestart"));
/* 11 */   public static final StreamCodec<ByteBuf, C2SRestartPayload> STREAM_CODEC = ByteBufCodecs.BOOL.map(C2SRestartPayload::new, C2SRestartPayload::fromStart);
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<C2SRestartPayload> type() {
/* 15 */     return TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\payload\C2SRestartPayload.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */