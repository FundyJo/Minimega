/*    */ package dev.jab125.minimega.mod.util.minigamedata;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ 
/*    */ public final class NoConfig extends Record implements MinigameSpecificConfig {
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/minigamedata/NoConfig;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/minigamedata/NoConfig;
/*    */   }
/*    */   
/*  9 */   public static final StreamCodec<ByteBuf, NoConfig> STREAM_CODEC = StreamCodec.unit(new NoConfig());
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/minigamedata/NoConfig;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/minigamedata/NoConfig; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/minigamedata/NoConfig;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/minigamedata/NoConfig;
/* 10 */     //   0	8	1	o	Ljava/lang/Object; } public static final Codec<NoConfig> CODEC = MapCodec.unitCodec(new NoConfig());
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\minigamedata\NoConfig.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */