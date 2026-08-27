/*    */ package dev.jab125.minimega.mod.util.minigamedata.battle;
/*    */ 
/*    */ import com.mojang.serialization.Codec;
/*    */ import dev.jab125.minimega.mod.party.SlotMetadataCodecs;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BattleConfigSettingsCodecs
/*    */ {
/* 14 */   public static final StreamCodec<ByteBuf, BattleConfigSettings> STREAM_CODEC = SlotMetadataCodecs.ofInterface(config -> { // Byte code:
/*    */         //   0: aload_0
/*    */         //   1: dup
/*    */         //   2: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*    */         //   5: pop
/*    */         //   6: astore_1
/*    */         //   7: iconst_0
/*    */         //   8: istore_2
/*    */         //   9: aload_1
/*    */         //   10: iload_2
/*    */         //   11: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;I)I
/*    */         //   16: tableswitch default -> 44, 0 -> 54, 1 -> 61, 2 -> 68
/*    */         //   44: new java/lang/MatchException
/*    */         //   47: dup
/*    */         //   48: aconst_null
/*    */         //   49: aconst_null
/*    */         //   50: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*    */         //   53: athrow
/*    */         //   54: iconst_0
/*    */         //   55: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */         //   58: goto -> 72
/*    */         //   61: iconst_1
/*    */         //   62: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */         //   65: goto -> 72
/*    */         //   68: iconst_2
/*    */         //   69: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */         //   72: areturn
/*    */         // Line number table:
/*    */         //   Java source line number -> byte code offset
/*    */         //   #14	-> 0
/*    */         //   #15	-> 54
/*    */         //   #16	-> 61
/*    */         //   #17	-> 68
/*    */         // Local variable table:
/*    */         //   start	length	slot	name	descriptor
/*    */         //   7	65	1	selector0$temp	Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*    */         //   9	63	2	index$1	I
/* 14 */         //   0	73	0	config	Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings; }new StreamCodec[] { CasualBattleConfigSettings.STREAM_CODEC, CompetitiveBattleConfigSettings.STREAM_CODEC, CustomBattleConfigSettings.STREAM_CODEC });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 20 */   public static final Codec<BattleConfigSettings> CODEC = SlotMetadataCodecs.ofInterface(config -> { // Byte code:
/*    */         //   0: aload_0
/*    */         //   1: dup
/*    */         //   2: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*    */         //   5: pop
/*    */         //   6: astore_1
/*    */         //   7: iconst_0
/*    */         //   8: istore_2
/*    */         //   9: aload_1
/*    */         //   10: iload_2
/*    */         //   11: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;I)I
/*    */         //   16: tableswitch default -> 44, 0 -> 54, 1 -> 61, 2 -> 68
/*    */         //   44: new java/lang/MatchException
/*    */         //   47: dup
/*    */         //   48: aconst_null
/*    */         //   49: aconst_null
/*    */         //   50: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*    */         //   53: athrow
/*    */         //   54: iconst_0
/*    */         //   55: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */         //   58: goto -> 72
/*    */         //   61: iconst_1
/*    */         //   62: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */         //   65: goto -> 72
/*    */         //   68: iconst_2
/*    */         //   69: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */         //   72: areturn
/*    */         // Line number table:
/*    */         //   Java source line number -> byte code offset
/*    */         //   #20	-> 0
/*    */         //   #21	-> 54
/*    */         //   #22	-> 61
/*    */         //   #23	-> 68
/*    */         // Local variable table:
/*    */         //   start	length	slot	name	descriptor
/*    */         //   7	65	1	selector0$temp	Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*    */         //   9	63	2	index$1	I
/* 20 */         //   0	73	0	config	Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings; }new Codec[] { CasualBattleConfigSettings.CODEC, CompetitiveBattleConfigSettings.CODEC, CustomBattleConfigSettings.CODEC });
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\minigamedata\battle\BattleConfigSettingsCodecs.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */