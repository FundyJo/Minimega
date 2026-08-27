/*    */ package dev.jab125.minimega.mod.util;
/*    */ 
/*    */ import dev.jab125.minimega.call.Result;
/*    */ import dev.jab125.minimega.mod.data.MapData;
/*    */ import dev.jab125.minimega.mod.data.MapInfo;
/*    */ import dev.jab125.minimega.mod.data.MinigamesResourceManager;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.server.packs.resources.ResourceManager;
/*    */ 
/*    */ @Deprecated(forRemoval = true)
/*    */ public final class OldScreenData extends Record {
/*    */   private final String data;
/*    */   private final List<MapInfo> mapInfos;
/*    */   
/* 19 */   public String data() { return this.data; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/OldScreenData;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #19	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/OldScreenData; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/OldScreenData;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #19	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/OldScreenData; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/OldScreenData;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #19	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/OldScreenData;
/* 19 */     //   0	8	1	o	Ljava/lang/Object; } public List<MapInfo> mapInfos() { return this.mapInfos; } public OldScreenData(String data, List<MapInfo> mapInfos) {
/* 20 */     this.data = data; this.mapInfos = mapInfos;
/* 21 */   } public static final StreamCodec<ByteBuf, OldScreenData> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, OldScreenData::data, MapInfo.LIST_STREAM_CODEC, OldScreenData::mapInfos, OldScreenData::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Result<OldScreenData, IOException> getScreenData(Minigame<?> minigame, ResourceManager manager) {
/* 28 */     return getScreenData(manager).apply(minigame);
/*    */   }
/*    */   
/*    */   public static Function<Minigame<?>, Result<OldScreenData, IOException>> getScreenData(ResourceManager manager) {
/* 32 */     return minigame -> Result.wrapGet((), (Throwable[])new IOException[0]);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\OldScreenData.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */