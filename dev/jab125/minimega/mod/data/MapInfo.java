/*    */ package dev.jab125.minimega.mod.data;
/*    */ 
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.datafixers.util.Function4;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import java.util.List;
/*    */ import java.util.Optional;
/*    */ import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.network.codec.ByteBufCodecs;
/*    */ import net.minecraft.resources.Identifier;
/*    */ 
/*    */ public final class MapInfo extends Record {
/*    */   private final Identifier id;
/*    */   private final Minigame<?> minigame;
/*    */   private final String resourcepack;
/*    */   private final Optional<Identifier> actualResourcePack;
/*    */   
/* 21 */   public MapInfo(Identifier id, Minigame<?> minigame, String resourcepack, Optional<Identifier> actualResourcePack) { this.id = id; this.minigame = minigame; this.resourcepack = resourcepack; this.actualResourcePack = actualResourcePack; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/data/MapInfo;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #21	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 21 */     //   0	7	0	this	Ldev/jab125/minimega/mod/data/MapInfo; } public Identifier id() { return this.id; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/data/MapInfo;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #21	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/data/MapInfo; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/data/MapInfo;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #21	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/data/MapInfo;
/* 21 */     //   0	8	1	o	Ljava/lang/Object; } public Minigame<?> minigame() { return this.minigame; } public String resourcepack() { return this.resourcepack; } public Optional<Identifier> actualResourcePack() { return this.actualResourcePack; }
/* 22 */    public static final StreamCodec<ByteBuf, MapInfo> STREAM_CODEC = StreamCodec.composite(Identifier.STREAM_CODEC, MapInfo::id, ByteBufCodecs.INT
/*    */       
/* 24 */       .map(Minigame::fromId, Minigame::getId), MapInfo::minigame, ByteBufCodecs.STRING_UTF8, MapInfo::resourcepack, 
/*    */       
/* 26 */       ByteBufCodecs.optional(Identifier.STREAM_CODEC), MapInfo::actualResourcePack, MapInfo::new);
/*    */ 
/*    */   
/* 29 */   public static final StreamCodec<ByteBuf, List<MapInfo>> LIST_STREAM_CODEC = ByteBufCodecs.list().apply(STREAM_CODEC); public static final Codec<MapInfo> CODEC; public static final AttachmentType<List<MapInfo>> ATTACHMENT_TYPE; static {
/* 30 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Identifier.CODEC.fieldOf("id").forGetter(MapInfo::id), (App)Codec.INT.xmap(Minigame::fromId, Minigame::getId).fieldOf("minigame").forGetter(cast(MinigameData::minigame)), (App)Codec.STRING.fieldOf("resourcepack").forGetter(MapInfo::resourcepack), (App)Identifier.CODEC.optionalFieldOf("actualResourcePack").forGetter(MapInfo::actualResourcePack)).apply((Applicative)instance, MapInfo::new));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 36 */     ATTACHMENT_TYPE = AttachmentRegistry.create(Minimega.id("mapinfos"), c -> c.initializer(List::of).syncWith(LIST_STREAM_CODEC, AttachmentSyncPredicate.all()));
/*    */   }
/*    */   
/*    */   public Component displayName() {
/* 40 */     return (Component)Component.translatable(this.id.getNamespace() + ".map." + this.id.getNamespace() + "." + this.minigame.tId());
/*    */   }
/*    */   
/*    */   public Component description() {
/* 44 */     return (Component)Component.translatable(this.id.getNamespace() + ".map." + this.id.getNamespace() + "." + this.minigame.tId() + ".description");
/*    */   }
/*    */   
/*    */   private static <T, O, R> T cast(Function<O, R> function) {
/* 48 */     return (T)function;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\data\MapInfo.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */