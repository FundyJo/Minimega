/*     */ package dev.jab125.minimega.mod.util.minigamedata.battle;
/*     */ 
/*     */ import net.minecraft.network.codec.StreamCodec;
/*     */ 
/*     */ public final class CustomBattleConfigSettings extends Record implements BattleConfigSettings {
/*     */   private final RoundLength roundLength;
/*     */   private final boolean centralSpawn;
/*     */   private final MapSize mapSize;
/*     */   private final Lives livesPerRound;
/*     */   private final SpectatorMode spectatorMode;
/*     */   private final boolean allowAllSkins;
/*     */   private final ItemSet itemSet;
/*     */   
/*  14 */   public CustomBattleConfigSettings(RoundLength roundLength, boolean centralSpawn, MapSize mapSize, Lives livesPerRound, SpectatorMode spectatorMode, boolean allowAllSkins, ItemSet itemSet, HungerSettings hungerSettings, int roundCount, boolean naturalRegeneration, boolean smallInventory, boolean takeEverything, boolean chestRefill, boolean shortSneaking) { this.roundLength = roundLength; this.centralSpawn = centralSpawn; this.mapSize = mapSize; this.livesPerRound = livesPerRound; this.spectatorMode = spectatorMode; this.allowAllSkins = allowAllSkins; this.itemSet = itemSet; this.hungerSettings = hungerSettings; this.roundCount = roundCount; this.naturalRegeneration = naturalRegeneration; this.smallInventory = smallInventory; this.takeEverything = takeEverything; this.chestRefill = chestRefill; this.shortSneaking = shortSneaking; } private final HungerSettings hungerSettings; private final int roundCount; private final boolean naturalRegeneration; private final boolean smallInventory; private final boolean takeEverything; private final boolean chestRefill; private final boolean shortSneaking; public static final Codec<CustomBattleConfigSettings> CODEC; public final String toString() { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/minigamedata/battle/CustomBattleConfigSettings;)Ljava/lang/String;
/*     */     //   6: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #14	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/minigamedata/battle/CustomBattleConfigSettings; } public final int hashCode() { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/minigamedata/battle/CustomBattleConfigSettings;)I
/*     */     //   6: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #14	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/minigamedata/battle/CustomBattleConfigSettings; } public final boolean equals(Object o) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_1
/*     */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/minigamedata/battle/CustomBattleConfigSettings;Ljava/lang/Object;)Z
/*     */     //   7: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #14	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/minigamedata/battle/CustomBattleConfigSettings;
/*  14 */     //   0	8	1	o	Ljava/lang/Object; } public RoundLength roundLength() { return this.roundLength; } public boolean centralSpawn() { return this.centralSpawn; } public MapSize mapSize() { return this.mapSize; } public Lives livesPerRound() { return this.livesPerRound; } public SpectatorMode spectatorMode() { return this.spectatorMode; } public boolean allowAllSkins() { return this.allowAllSkins; } public ItemSet itemSet() { return this.itemSet; } public HungerSettings hungerSettings() { return this.hungerSettings; } public int roundCount() { return this.roundCount; } public boolean naturalRegeneration() { return this.naturalRegeneration; } public boolean smallInventory() { return this.smallInventory; } public boolean takeEverything() { return this.takeEverything; } public boolean chestRefill() { return this.chestRefill; } public boolean shortSneaking() { return this.shortSneaking; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  30 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)RoundLength.CODEC.fieldOf("roundLength").forGetter(CustomBattleConfigSettings::roundLength), (App)Codec.BOOL.fieldOf("centralSpawn").forGetter(CustomBattleConfigSettings::centralSpawn), (App)MapSize.CODEC.fieldOf("mapSize").forGetter(CustomBattleConfigSettings::mapSize), (App)Lives.CODEC.fieldOf("livesPerRound").forGetter(CustomBattleConfigSettings::livesPerRound), (App)SpectatorMode.CODEC.fieldOf("spectatorMode").forGetter(CustomBattleConfigSettings::spectatorMode), (App)Codec.BOOL.fieldOf("allowAllSkins").forGetter(CustomBattleConfigSettings::allowAllSkins), (App)ItemSet.CODEC.fieldOf("itemSet").forGetter(CustomBattleConfigSettings::itemSet), (App)HungerSettings.CODEC.fieldOf("hungerSettings").forGetter(CustomBattleConfigSettings::hungerSettings), (App)Codec.INT.fieldOf("roundCount").forGetter(CustomBattleConfigSettings::roundCount), (App)Codec.BOOL.fieldOf("naturalRegeneration").forGetter(CustomBattleConfigSettings::naturalRegeneration), (App)Codec.BOOL.fieldOf("smallInventory").forGetter(CustomBattleConfigSettings::smallInventory), (App)Codec.BOOL.fieldOf("takeEverything").forGetter(CustomBattleConfigSettings::takeEverything), (App)Codec.BOOL.fieldOf("chestRefill").forGetter(CustomBattleConfigSettings::chestRefill), (App)Codec.BOOL.fieldOf("shortSneaking").forGetter(CustomBattleConfigSettings::shortSneaking)).apply((Applicative)instance, CustomBattleConfigSettings::new));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   public static final StreamCodec<ByteBuf, CustomBattleConfigSettings> STREAM_CODEC = composite(RoundLength.STREAM_CODEC, CustomBattleConfigSettings::roundLength, ByteBufCodecs.BOOL, CustomBattleConfigSettings::centralSpawn, MapSize.STREAM_CODEC, CustomBattleConfigSettings::mapSize, Lives.STREAM_CODEC, CustomBattleConfigSettings::livesPerRound, SpectatorMode.STREAM_CODEC, CustomBattleConfigSettings::spectatorMode, ByteBufCodecs.BOOL, CustomBattleConfigSettings::allowAllSkins, ItemSet.STREAM_CODEC, CustomBattleConfigSettings::itemSet, HungerSettings.STREAM_CODEC, CustomBattleConfigSettings::hungerSettings, ByteBufCodecs.INT, CustomBattleConfigSettings::roundCount, ByteBufCodecs.BOOL, CustomBattleConfigSettings::naturalRegeneration, ByteBufCodecs.BOOL, CustomBattleConfigSettings::smallInventory, ByteBufCodecs.BOOL, CustomBattleConfigSettings::takeEverything, ByteBufCodecs.BOOL, CustomBattleConfigSettings::chestRefill, ByteBufCodecs.BOOL, CustomBattleConfigSettings::shortSneaking, CustomBattleConfigSettings::new);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CustomBattleConfigSettings createReversed(boolean shortSneaking, boolean chestRefill, boolean takeEverything, boolean smallInventory, boolean naturalRegeneration, int roundCount, HungerSettings hungerSettings, ItemSet itemSet, boolean allowAllSkins, SpectatorMode spectatorMode, Lives livesPerRound, MapSize mapSize, boolean centralSpawn, RoundLength roundLength) {
/*  79 */     return new CustomBattleConfigSettings(roundLength, centralSpawn, mapSize, livesPerRound, spectatorMode, allowAllSkins, itemSet, hungerSettings, roundCount, naturalRegeneration, smallInventory, takeEverything, chestRefill, shortSneaking);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static <B, C, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> StreamCodec<B, C> composite(final StreamCodec<? super B, T1> codec1, final Function<C, T1> getter1, final StreamCodec<? super B, T2> codec2, final Function<C, T2> getter2, final StreamCodec<? super B, T3> codec3, final Function<C, T3> getter3, final StreamCodec<? super B, T4> codec4, final Function<C, T4> getter4, final StreamCodec<? super B, T5> codec5, final Function<C, T5> getter5, final StreamCodec<? super B, T6> codec6, final Function<C, T6> getter6, final StreamCodec<? super B, T7> codec7, final Function<C, T7> getter7, final StreamCodec<? super B, T8> codec8, final Function<C, T8> getter8, final StreamCodec<? super B, T9> codec9, final Function<C, T9> getter9, final StreamCodec<? super B, T10> codec10, final Function<C, T10> getter10, final StreamCodec<? super B, T11> codec11, final Function<C, T11> getter11, final StreamCodec<? super B, T12> codec12, final Function<C, T12> getter12, final StreamCodec<? super B, T13> codec13, final Function<C, T13> getter13, final StreamCodec<? super B, T14> codec14, final Function<C, T14> getter14, final Function14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, C> constructor) {
/* 113 */     return new StreamCodec<B, C>()
/*     */       {
/*     */         public C decode(B input) {
/* 116 */           T1 v1 = (T1)codec1.decode(input);
/* 117 */           T2 v2 = (T2)codec2.decode(input);
/* 118 */           T3 v3 = (T3)codec3.decode(input);
/* 119 */           T4 v4 = (T4)codec4.decode(input);
/* 120 */           T5 v5 = (T5)codec5.decode(input);
/* 121 */           T6 v6 = (T6)codec6.decode(input);
/* 122 */           T7 v7 = (T7)codec7.decode(input);
/* 123 */           T8 v8 = (T8)codec8.decode(input);
/* 124 */           T9 v9 = (T9)codec9.decode(input);
/* 125 */           T10 v10 = (T10)codec10.decode(input);
/* 126 */           T11 v11 = (T11)codec11.decode(input);
/* 127 */           T12 v12 = (T12)codec12.decode(input);
/* 128 */           T13 v13 = (T13)codec13.decode(input);
/* 129 */           T14 v14 = (T14)codec14.decode(input);
/* 130 */           return (C)constructor.apply(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14);
/*     */         }
/*     */ 
/*     */         
/*     */         public void encode(B output, C value) {
/* 135 */           codec1.encode(output, getter1.apply(value));
/* 136 */           codec2.encode(output, getter2.apply(value));
/* 137 */           codec3.encode(output, getter3.apply(value));
/* 138 */           codec4.encode(output, getter4.apply(value));
/* 139 */           codec5.encode(output, getter5.apply(value));
/* 140 */           codec6.encode(output, getter6.apply(value));
/* 141 */           codec7.encode(output, getter7.apply(value));
/* 142 */           codec8.encode(output, getter8.apply(value));
/* 143 */           codec9.encode(output, getter9.apply(value));
/* 144 */           codec10.encode(output, getter10.apply(value));
/* 145 */           codec11.encode(output, getter11.apply(value));
/* 146 */           codec12.encode(output, getter12.apply(value));
/* 147 */           codec13.encode(output, getter13.apply(value));
/* 148 */           codec14.encode(output, getter14.apply(value));
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\minigamedata\battle\CustomBattleConfigSettings.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */