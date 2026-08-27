/*    */ package dev.jab125.minimega.mod.util.minigamedata;
/*    */ 
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import dev.jab125.minimega.mod.util.controller.glide.GlideGameType;
/*    */ 
/*    */ public final class GlideConfig extends Record implements MinigameSpecificConfig {
/*    */   private final GlideGameType type;
/*    */   private final boolean solo;
/*    */   
/* 10 */   public GlideConfig(GlideGameType type, boolean solo) { this.type = type; this.solo = solo; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/minigamedata/GlideConfig;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 10 */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/minigamedata/GlideConfig; } public GlideGameType type() { return this.type; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/minigamedata/GlideConfig;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/minigamedata/GlideConfig; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/minigamedata/GlideConfig;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/minigamedata/GlideConfig;
/* 10 */     //   0	8	1	o	Ljava/lang/Object; } public boolean solo() { return this.solo; }
/* 11 */    public static final StreamCodec<ByteBuf, GlideConfig> STREAM_CODEC = StreamCodec.composite(GlideGameType.STREAM_CODEC, GlideConfig::type, ByteBufCodecs.BOOL, GlideConfig::solo, GlideConfig::new);
/*    */   
/*    */   public static final Codec<GlideConfig> CODEC;
/*    */   
/*    */   static {
/* 16 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)GlideGameType.CODEC.fieldOf("type").forGetter(GlideConfig::type), (App)Codec.BOOL.fieldOf("solo").forGetter(GlideConfig::solo)).apply((Applicative)instance, GlideConfig::new));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\minigamedata\GlideConfig.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */