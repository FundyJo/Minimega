/*   */ package dev.jab125.minimega.mod.party;
/*   */ 
/*   */ import io.netty.buffer.ByteBuf;
/*   */ import net.minecraft.network.codec.StreamCodec;
/*   */ 
/*   */ 
/*   */ public class SlotsMetadataCodecs
/*   */ {
/* 9 */   public static final StreamCodec<ByteBuf, SlotsMetadata> STREAM_CODEC = SlotMetadataCodecs.ofInterface(slotMetadata -> { // Byte code:
/*   */         //   0: aload_0
/*   */         //   1: dup
/*   */         //   2: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*   */         //   5: pop
/*   */         //   6: astore_1
/*   */         //   7: iconst_0
/*   */         //   8: istore_2
/*   */         //   9: aload_1
/*   */         //   10: iload_2
/*   */         //   11: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/mod/party/SlotsMetadata;I)I
/*   */         //   16: tableswitch default -> 48, 0 -> 58, 1 -> 70, 2 -> 83, 3 -> 96
/*   */         //   48: new java/lang/MatchException
/*   */         //   51: dup
/*   */         //   52: aconst_null
/*   */         //   53: aconst_null
/*   */         //   54: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*   */         //   57: athrow
/*   */         //   58: aload_1
/*   */         //   59: checkcast dev/jab125/minimega/mod/party/BattleSlotsMetadata
/*   */         //   62: astore_3
/*   */         //   63: iconst_0
/*   */         //   64: invokestatic valueOf : (I)Ljava/lang/Integer;
/*   */         //   67: goto -> 106
/*   */         //   70: aload_1
/*   */         //   71: checkcast dev/jab125/minimega/mod/party/LobbySlotsMetadata
/*   */         //   74: astore #4
/*   */         //   76: iconst_1
/*   */         //   77: invokestatic valueOf : (I)Ljava/lang/Integer;
/*   */         //   80: goto -> 106
/*   */         //   83: aload_1
/*   */         //   84: checkcast dev/jab125/minimega/mod/party/NoSlotsMetadata
/*   */         //   87: astore #5
/*   */         //   89: iconst_2
/*   */         //   90: invokestatic valueOf : (I)Ljava/lang/Integer;
/*   */         //   93: goto -> 106
/*   */         //   96: aload_1
/*   */         //   97: checkcast dev/jab125/minimega/mod/party/GlideSlotsMetadata
/*   */         //   100: astore #6
/*   */         //   102: iconst_3
/*   */         //   103: invokestatic valueOf : (I)Ljava/lang/Integer;
/*   */         //   106: areturn
/*   */         // Line number table:
/*   */         //   Java source line number -> byte code offset
/*   */         //   #9	-> 0
/*   */         //   #10	-> 58
/*   */         //   #11	-> 70
/*   */         //   #12	-> 83
/*   */         //   #13	-> 96
/*   */         // Local variable table:
/*   */         //   start	length	slot	name	descriptor
/*   */         //   63	7	3	ignored	Ldev/jab125/minimega/mod/party/BattleSlotsMetadata;
/*   */         //   76	7	4	ignored	Ldev/jab125/minimega/mod/party/LobbySlotsMetadata;
/*   */         //   89	7	5	ignored	Ldev/jab125/minimega/mod/party/NoSlotsMetadata;
/*   */         //   102	4	6	ignored	Ldev/jab125/minimega/mod/party/GlideSlotsMetadata;
/*   */         //   7	99	1	selector0$temp	Ldev/jab125/minimega/mod/party/SlotsMetadata;
/*   */         //   9	97	2	index$1	I
/* 9 */         //   0	107	0	slotMetadata	Ldev/jab125/minimega/mod/party/SlotsMetadata; }(StreamCodec<? super ByteBuf, ? extends SlotsMetadata>[])new StreamCodec[] { BattleSlotsMetadata.STREAM_CODEC, LobbySlotsMetadata.STREAM_CODEC, NoSlotsMetadata.STREAM_CODEC, GlideSlotsMetadata.STREAM_CODEC });
/*   */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\party\SlotsMetadataCodecs.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */