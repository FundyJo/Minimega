/*    */ package dev.jab125.minimega.mod.util;
/*    */ 
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.datafixers.kinds.Applicative;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import dev.jab125.minimega.call.Result;
/*    */ import dev.jab125.minimega.grf.newelements.mxml.IMXml;
/*    */ import dev.jab125.minimega.grf.newelements.mxml.gui.GameMode;
/*    */ import dev.jab125.minimega.grf.newelements.mxml.gui.GuiCodecs;
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import dev.jab125.minimega.mod.data.MapData;
/*    */ import dev.jab125.minimega.mod.data.MapInfo;
/*    */ import dev.jab125.minimega.mod.data.MinigamesResourceManager;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import java.util.Optional;
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.server.packs.resources.ResourceManager;
/*    */ 
/*    */ @Experimental
/*    */ public final class NewScreenData extends Record {
/*    */   private final GameMode data;
/*    */   private final Optional<List<MapInfo>> mapInfos;
/*    */   public static final Codec<NewScreenData> CODEC;
/*    */   
/* 29 */   public GameMode data() { return this.data; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/NewScreenData;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #29	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/NewScreenData; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/NewScreenData;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #29	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/NewScreenData; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/NewScreenData;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #29	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/NewScreenData;
/* 29 */     //   0	8	1	o	Ljava/lang/Object; } public Optional<List<MapInfo>> mapInfos() { return this.mapInfos; }
/* 30 */   public NewScreenData(GameMode data, Optional<List<MapInfo>> mapInfos) { this.data = data; this.mapInfos = mapInfos; } static {
/* 31 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)GuiCodecs.CODEC.fieldOf("data").forGetter(NewScreenData::data), (App)MapInfo.CODEC.listOf().optionalFieldOf("mapInfos").forGetter(NewScreenData::mapInfos)).apply((Applicative)instance, ()));
/*    */   }
/*    */ 
/*    */   
/* 35 */   public static final StreamCodec<ByteBuf, NewScreenData> STREAM_CODEC = ByteBufCodecs.fromCodecTrusted(CODEC);
/*    */   
/*    */   public static Result<NewScreenData, IOException> getScreenData(Minigame<?> minigame, ResourceManager manager) {
/* 38 */     return getScreenData(manager).apply(minigame);
/*    */   }
/*    */   
/*    */   public static Function<Minigame<?>, Result<NewScreenData, IOException>> getScreenData(ResourceManager manager) {
/* 42 */     return minigame -> (Result)getScreenData(minigame.tId(), manager).get();
/*    */   }
/*    */   
/*    */   public static Supplier<Result<NewScreenData, IOException>> getScreenData(String id, ResourceManager manager) {
/* 46 */     return () -> Result.wrapGet((), (Throwable[])new IOException[0]);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\NewScreenData.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */