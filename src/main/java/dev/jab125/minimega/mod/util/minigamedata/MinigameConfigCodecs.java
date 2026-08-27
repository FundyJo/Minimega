/*    */ package dev.jab125.minimega.mod.util.minigamedata;
/*    */ 
/*    */ import com.mojang.serialization.Codec;
/*    */ import dev.jab125.minimega.mod.party.SlotMetadataCodecs;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ 
/*    */ public class MinigameConfigCodecs
/*    */ {
/* 10 */   public static final StreamCodec<ByteBuf, MinigameSpecificConfig> STREAM_CODEC = SlotMetadataCodecs.ofInterface(config -> { // Byte code:
/*    */         //   0: aload_0
/*    */         //   1: dup
/*    */         //   2: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*    */         //   5: pop
/*    */         //   6: astore_1
/*    */         //   7: iconst_0
/*    */         //   8: istore_2
/*    */         //   9: aload_1
/*    */         //   10: iload_2
/*    */         //   11: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;I)I
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
/*    */         //   #10	-> 0
/*    */         //   #11	-> 54
/*    */         //   #12	-> 61
/*    */         //   #13	-> 68
/*    */         // Local variable table:
/*    */         //   start	length	slot	name	descriptor
/*    */         //   7	65	1	selector0$temp	Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;
/*    */         //   9	63	2	index$1	I
/* 10 */         //   0	73	0	config	Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig; }new StreamCodec[] { NoConfig.STREAM_CODEC, GlideConfig.STREAM_CODEC, BattleConfig.STREAM_CODEC });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 16 */   public static final Codec<MinigameSpecificConfig> CODEC = SlotMetadataCodecs.ofInterface(config -> { // Byte code:
/*    */         //   0: aload_0
/*    */         //   1: dup
/*    */         //   2: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*    */         //   5: pop
/*    */         //   6: astore_1
/*    */         //   7: iconst_0
/*    */         //   8: istore_2
/*    */         //   9: aload_1
/*    */         //   10: iload_2
/*    */         //   11: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;I)I
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
/*    */         //   #16	-> 0
/*    */         //   #17	-> 54
/*    */         //   #18	-> 61
/*    */         //   #19	-> 68
/*    */         // Local variable table:
/*    */         //   start	length	slot	name	descriptor
/*    */         //   7	65	1	selector0$temp	Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;
/*    */         //   9	63	2	index$1	I
/* 16 */         //   0	73	0	config	Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig; }new Codec[] { NoConfig.CODEC, GlideConfig.CODEC, BattleConfig.CODEC });
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\minigamedata\MinigameConfigCodecs.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */