/*    */ package dev.jab125.minimega.mod.util.minigamedata;
/*    */ 
/*    */ import com.mojang.serialization.Codec;
/*    */ import dev.jab125.minimega.mod.util.minigamedata.battle.BattleConfigSettings;
/*    */ import dev.jab125.minimega.mod.util.minigamedata.battle.BattleConfigSettingsCodecs;
/*    */ import dev.jab125.minimega.mod.util.minigamedata.battle.CasualBattleConfigSettings;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ 
/*    */ public final class BattleConfig extends Record implements MinigameSpecificConfig {
/*    */   private final BattleConfigSettings settings;
/*    */   
/* 14 */   public BattleConfigSettings settings() { return this.settings; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/minigamedata/BattleConfig;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/minigamedata/BattleConfig;
/* 14 */     //   0	8	1	o	Ljava/lang/Object; } public BattleConfig(BattleConfigSettings settings) { this.settings = settings; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/minigamedata/BattleConfig;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/minigamedata/BattleConfig; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/minigamedata/BattleConfig;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 15 */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/minigamedata/BattleConfig; } public static final StreamCodec<ByteBuf, BattleConfig> STREAM_CODEC = BattleConfigSettingsCodecs.STREAM_CODEC.map(BattleConfig::new, BattleConfig::settings);
/* 16 */   public static final Codec<BattleConfig> CODEC = BattleConfigSettingsCodecs.CODEC.xmap(BattleConfig::new, BattleConfig::settings);
/*    */   
/*    */   @Deprecated(forRemoval = true)
/*    */   public BattleConfig() {
/* 20 */     this((BattleConfigSettings)new CasualBattleConfigSettings(RoundLength.NORMAL, true));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\minigamedata\BattleConfig.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */