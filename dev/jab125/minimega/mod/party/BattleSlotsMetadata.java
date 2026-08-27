/*   */ package dev.jab125.minimega.mod.party;
/*   */ 
/*   */ import io.netty.buffer.ByteBuf;
/*   */ import net.minecraft.network.codec.StreamCodec;
/*   */ 
/*   */ public final class BattleSlotsMetadata extends Record implements SlotsMetadata {
/* 7 */   public static final StreamCodec<ByteBuf, BattleSlotsMetadata> STREAM_CODEC = StreamCodec.unit(new BattleSlotsMetadata());
/*   */   
/*   */   public final String toString() {
/*   */     // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/party/BattleSlotsMetadata;)Ljava/lang/String;
/*   */     //   6: areturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #6	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	7	0	this	Ldev/jab125/minimega/mod/party/BattleSlotsMetadata;
/*   */   }
/*   */   
/*   */   public final int hashCode() {
/*   */     // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/party/BattleSlotsMetadata;)I
/*   */     //   6: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #6	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	7	0	this	Ldev/jab125/minimega/mod/party/BattleSlotsMetadata;
/*   */   }
/*   */   
/*   */   public final boolean equals(Object o) {
/*   */     // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: aload_1
/*   */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/party/BattleSlotsMetadata;Ljava/lang/Object;)Z
/*   */     //   7: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #6	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	8	0	this	Ldev/jab125/minimega/mod/party/BattleSlotsMetadata;
/*   */     //   0	8	1	o	Ljava/lang/Object;
/*   */   }
/*   */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\party\BattleSlotsMetadata.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */