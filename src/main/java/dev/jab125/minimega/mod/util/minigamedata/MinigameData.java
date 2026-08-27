/*    */ package dev.jab125.minimega.mod.util.minigamedata;
/*    */ 
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.serialization.Codec;
/*    */ 
/*    */ public final class MinigameData extends Record {
/*    */   private final List<Identifier> selectedMaps;
/*    */   private final Minigame<?> minigame;
/*    */   private final int maxPlayers;
/*    */   private final MinigameSpecificConfig config;
/*    */   private final boolean online;
/*    */   private final boolean public_;
/*    */   public static final Codec<MinigameData> CODEC;
/*    */   
/* 15 */   public MinigameData(List<Identifier> selectedMaps, Minigame<?> minigame, int maxPlayers, MinigameSpecificConfig config, boolean online, boolean public_) { this.selectedMaps = selectedMaps; this.minigame = minigame; this.maxPlayers = maxPlayers; this.config = config; this.online = online; this.public_ = public_; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #15	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 15 */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/minigamedata/MinigameData; } public List<Identifier> selectedMaps() { return this.selectedMaps; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #15	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/minigamedata/MinigameData; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #15	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;
/* 15 */     //   0	8	1	o	Ljava/lang/Object; } public Minigame<?> minigame() { return this.minigame; } public int maxPlayers() { return this.maxPlayers; } public MinigameSpecificConfig config() { return this.config; } public boolean online() { return this.online; } public boolean public_() { return this.public_; }
/*    */   
/*    */   static {
/* 18 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Identifier.CODEC.listOf().fieldOf("selectedMaps").forGetter(MinigameData::selectedMaps), (App)Codec.INT.xmap(Minigame::fromId, Minigame::getId).fieldOf("minigame").forGetter(cast(MinigameData::minigame)), (App)Codec.intRange(1, 32).fieldOf("maxPlayers").forGetter(MinigameData::maxPlayers), (App)MinigameConfigCodecs.CODEC.fieldOf("config").forGetter(MinigameData::config), (App)Codec.BOOL.fieldOf("online").forGetter(MinigameData::online), (App)Codec.BOOL.fieldOf("public").forGetter(MinigameData::public_)).apply((Applicative)instance, MinigameData::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 27 */   public static final StreamCodec<ByteBuf, MinigameData> STREAM_CODEC = ByteBufCodecs.fromCodec(CODEC);
/*    */   
/*    */   private static <T, O, R> T cast(Function<O, R> function) {
/* 30 */     return (T)function;
/*    */   }
/*    */   
/*    */   public MinigameData noSolo() {
/*    */     // Byte code:
/*    */     //   0: new dev/jab125/minimega/mod/util/minigamedata/MinigameData
/*    */     //   3: dup
/*    */     //   4: aload_0
/*    */     //   5: invokevirtual selectedMaps : ()Ljava/util/List;
/*    */     //   8: aload_0
/*    */     //   9: invokevirtual minigame : ()Ldev/jab125/minimega/mod/util/Minigame;
/*    */     //   12: aload_0
/*    */     //   13: invokevirtual maxPlayers : ()I
/*    */     //   16: aload_0
/*    */     //   17: invokevirtual config : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;
/*    */     //   20: dup
/*    */     //   21: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*    */     //   24: pop
/*    */     //   25: astore_1
/*    */     //   26: iconst_0
/*    */     //   27: istore_2
/*    */     //   28: aload_1
/*    */     //   29: iload_2
/*    */     //   30: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;I)I
/*    */     //   35: tableswitch default -> 60, 0 -> 70, 1 -> 104, 2 -> 115
/*    */     //   60: new java/lang/MatchException
/*    */     //   63: dup
/*    */     //   64: aconst_null
/*    */     //   65: aconst_null
/*    */     //   66: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*    */     //   69: athrow
/*    */     //   70: aload_1
/*    */     //   71: checkcast dev/jab125/minimega/mod/util/minigamedata/GlideConfig
/*    */     //   74: astore_3
/*    */     //   75: aload_3
/*    */     //   76: invokevirtual type : ()Ldev/jab125/minimega/mod/util/controller/glide/GlideGameType;
/*    */     //   79: astore #5
/*    */     //   81: aload #5
/*    */     //   83: astore #4
/*    */     //   85: aload_3
/*    */     //   86: invokevirtual solo : ()Z
/*    */     //   89: istore #5
/*    */     //   91: new dev/jab125/minimega/mod/util/minigamedata/GlideConfig
/*    */     //   94: dup
/*    */     //   95: aload #4
/*    */     //   97: iconst_0
/*    */     //   98: invokespecial <init> : (Ldev/jab125/minimega/mod/util/controller/glide/GlideGameType;Z)V
/*    */     //   101: goto -> 123
/*    */     //   104: aload_1
/*    */     //   105: checkcast dev/jab125/minimega/mod/util/minigamedata/NoConfig
/*    */     //   108: astore #5
/*    */     //   110: aload #5
/*    */     //   112: goto -> 123
/*    */     //   115: aload_1
/*    */     //   116: checkcast dev/jab125/minimega/mod/util/minigamedata/BattleConfig
/*    */     //   119: astore #6
/*    */     //   121: aload #6
/*    */     //   123: aload_0
/*    */     //   124: invokevirtual online : ()Z
/*    */     //   127: aload_0
/*    */     //   128: invokevirtual public_ : ()Z
/*    */     //   131: invokespecial <init> : (Ljava/util/List;Ldev/jab125/minimega/mod/util/Minigame;ILdev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;ZZ)V
/*    */     //   134: areturn
/*    */     //   135: astore_1
/*    */     //   136: new java/lang/MatchException
/*    */     //   139: dup
/*    */     //   140: aload_1
/*    */     //   141: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   144: aload_1
/*    */     //   145: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*    */     //   148: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #34	-> 0
/*    */     //   #35	-> 70
/*    */     //   #37	-> 104
/*    */     //   #38	-> 115
/*    */     //   #39	-> 123
/*    */     //   #34	-> 134
/*    */     //   #38	-> 135
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   85	19	4	type	Ldev/jab125/minimega/mod/util/controller/glide/GlideGameType;
/*    */     //   110	5	5	config	Ldev/jab125/minimega/mod/util/minigamedata/NoConfig;
/*    */     //   121	2	6	config	Ldev/jab125/minimega/mod/util/minigamedata/BattleConfig;
/*    */     //   0	149	0	this	Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   76	79	135	java/lang/Throwable
/*    */     //   86	89	135	java/lang/Throwable
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\minigamedata\MinigameData.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */