/*   */ package dev.jab125.minimega.mod.util.joindata;
/*   */ 
/*   */ import dev.jab125.minimega.mod.party.SlotMetadataCodecs;
/*   */ import io.netty.buffer.ByteBuf;
/*   */ import net.minecraft.network.codec.StreamCodec;
/*   */ 
/*   */ public class CreateOrJoinCodecs
/*   */ {
/* 9 */   public static final StreamCodec<ByteBuf, CreateOrJoin> STREAM_CODEC = SlotMetadataCodecs.ofInterface(createOrJoin -> { // Byte code:
/*   */         //   0: aload_0
/*   */         //   1: dup
/*   */         //   2: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*   */         //   5: pop
/*   */         //   6: astore_1
/*   */         //   7: iconst_0
/*   */         //   8: istore_2
/*   */         //   9: aload_1
/*   */         //   10: iload_2
/*   */         //   11: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/mod/util/joindata/CreateOrJoin;I)I
/*   */         //   16: tableswitch default -> 48, 0 -> 58, 1 -> 65, 2 -> 72, 3 -> 79
/*   */         //   48: new java/lang/MatchException
/*   */         //   51: dup
/*   */         //   52: aconst_null
/*   */         //   53: aconst_null
/*   */         //   54: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*   */         //   57: athrow
/*   */         //   58: iconst_0
/*   */         //   59: invokestatic valueOf : (I)Ljava/lang/Integer;
/*   */         //   62: goto -> 83
/*   */         //   65: iconst_1
/*   */         //   66: invokestatic valueOf : (I)Ljava/lang/Integer;
/*   */         //   69: goto -> 83
/*   */         //   72: iconst_2
/*   */         //   73: invokestatic valueOf : (I)Ljava/lang/Integer;
/*   */         //   76: goto -> 83
/*   */         //   79: iconst_3
/*   */         //   80: invokestatic valueOf : (I)Ljava/lang/Integer;
/*   */         //   83: areturn
/*   */         // Line number table:
/*   */         //   Java source line number -> byte code offset
/*   */         //   #9	-> 0
/*   */         //   #10	-> 58
/*   */         //   #11	-> 65
/*   */         //   #12	-> 72
/*   */         //   #13	-> 79
/*   */         // Local variable table:
/*   */         //   start	length	slot	name	descriptor
/*   */         //   7	76	1	selector0$temp	Ldev/jab125/minimega/mod/util/joindata/CreateOrJoin;
/*   */         //   9	74	2	index$1	I
/* 9 */         //   0	84	0	createOrJoin	Ldev/jab125/minimega/mod/util/joindata/CreateOrJoin; }new StreamCodec[] { CreateParty.STREAM_CODEC, FriendData.STREAM_CODEC, JoinParty.STREAM_CODEC, Whatever.STREAM_CODEC });
/*   */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\joindata\CreateOrJoinCodecs.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */