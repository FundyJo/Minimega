/*    */ package dev.jab125.minimega.mod.util.minigamedata.battle;
/*    */ 
/*    */ 
/*    */ public final class CasualBattleConfigSettings extends Record implements PreconfiguredBattleConfigSettings {
/*    */   private final RoundLength roundLength;
/*    */   private final boolean centralSpawn;
/*    */   public static final Codec<CasualBattleConfigSettings> CODEC;
/*    */   
/*  9 */   public CasualBattleConfigSettings(RoundLength roundLength, boolean centralSpawn) { this.roundLength = roundLength; this.centralSpawn = centralSpawn; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/minigamedata/battle/CasualBattleConfigSettings;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  9 */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/minigamedata/battle/CasualBattleConfigSettings; } public RoundLength roundLength() { return this.roundLength; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/minigamedata/battle/CasualBattleConfigSettings;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/minigamedata/battle/CasualBattleConfigSettings; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/minigamedata/battle/CasualBattleConfigSettings;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/minigamedata/battle/CasualBattleConfigSettings;
/*  9 */     //   0	8	1	o	Ljava/lang/Object; } public boolean centralSpawn() { return this.centralSpawn; } static {
/* 10 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)RoundLength.CODEC.fieldOf("roundLength").forGetter(CasualBattleConfigSettings::roundLength), (App)Codec.BOOL.fieldOf("centralSpawn").forGetter(CasualBattleConfigSettings::centralSpawn)).apply((Applicative)instance, CasualBattleConfigSettings::new));
/*    */   }
/*    */ 
/*    */   
/* 14 */   public static final StreamCodec<ByteBuf, CasualBattleConfigSettings> STREAM_CODEC = StreamCodec.composite(RoundLength.STREAM_CODEC, CasualBattleConfigSettings::roundLength, ByteBufCodecs.BOOL, CasualBattleConfigSettings::centralSpawn, CasualBattleConfigSettings::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SpectatorMode spectatorMode() {
/* 21 */     return SpectatorMode.BAT;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean allowAllSkins() {
/* 26 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public MapSize mapSize() {
/* 31 */     return MapSize.AUTO;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean shortSneaking() {
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\minigamedata\battle\CasualBattleConfigSettings.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */