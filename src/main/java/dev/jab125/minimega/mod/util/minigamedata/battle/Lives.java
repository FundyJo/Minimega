/*    */ package dev.jab125.minimega.mod.util.minigamedata.battle;
/*    */ import com.mojang.serialization.Codec;
/*    */ 
/*    */ public interface Lives {
/*    */   public static final Codec<Lives> CODEC;
/*    */   public static final StreamCodec<ByteBuf, Lives> STREAM_CODEC;
/*    */   
/*    */   static {
/*  9 */     CODEC = Codec.INT.xmap(a -> (a.intValue() <= 0) ? new Infinite() : new Numbered(a.intValue()), a -> {
/*    */           // Byte code:
/*    */           //   0: aload_0
/*    */           //   1: dup
/*    */           //   2: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*    */           //   5: pop
/*    */           //   6: astore_1
/*    */           //   7: iconst_0
/*    */           //   8: istore_2
/*    */           //   9: aload_1
/*    */           //   10: iload_2
/*    */           //   11: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives;I)I
/*    */           //   16: lookupswitch default -> 44, 0 -> 54, 1 -> 66
/*    */           //   44: new java/lang/MatchException
/*    */           //   47: dup
/*    */           //   48: aconst_null
/*    */           //   49: aconst_null
/*    */           //   50: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*    */           //   53: athrow
/*    */           //   54: aload_1
/*    */           //   55: checkcast dev/jab125/minimega/mod/util/minigamedata/battle/Lives$Infinite
/*    */           //   58: astore_3
/*    */           //   59: iconst_0
/*    */           //   60: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */           //   63: goto -> 107
/*    */           //   66: aload_1
/*    */           //   67: checkcast dev/jab125/minimega/mod/util/minigamedata/battle/Lives$Numbered
/*    */           //   70: astore #4
/*    */           //   72: aload #4
/*    */           //   74: invokevirtual amount : ()I
/*    */           //   77: istore #6
/*    */           //   79: iload #6
/*    */           //   81: istore #7
/*    */           //   83: iconst_1
/*    */           //   84: ifeq -> 94
/*    */           //   87: iload #6
/*    */           //   89: istore #5
/*    */           //   91: goto -> 99
/*    */           //   94: iconst_2
/*    */           //   95: istore_2
/*    */           //   96: goto -> 9
/*    */           //   99: iload #5
/*    */           //   101: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */           //   104: goto -> 107
/*    */           //   107: areturn
/*    */           //   108: astore_1
/*    */           //   109: new java/lang/MatchException
/*    */           //   112: dup
/*    */           //   113: aload_1
/*    */           //   114: invokevirtual toString : ()Ljava/lang/String;
/*    */           //   117: aload_1
/*    */           //   118: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*    */           //   121: athrow
/*    */           // Line number table:
/*    */           //   Java source line number -> byte code offset
/*    */           //   #9	-> 0
/*    */           //   #10	-> 54
/*    */           //   #11	-> 66
/*    */           // Local variable table:
/*    */           //   start	length	slot	name	descriptor
/*    */           //   59	7	3	$b$0	Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives$Infinite;
/*    */           //   83	1	7	tmp0$	I
/*    */           //   79	12	6	patt4$temp	I
/*    */           //   91	3	5	amount	I
/*    */           //   72	35	4	$b$1	Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives$Numbered;
/*    */           //   99	8	5	amount	I
/*    */           //   7	100	1	selector2$temp	Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives;
/*    */           //   9	98	2	index$3	I
/*    */           //   0	122	0	a	Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives;
/*    */           // Exception table:
/*    */           //   from	to	target	type
/*    */           //   74	77	108	java/lang/Throwable
/*    */         });
/*    */     
/* 13 */     STREAM_CODEC = ByteBufCodecs.INT.map(a -> (a.intValue() <= 0) ? new Infinite() : new Numbered(a.intValue()), a -> {
/*    */           // Byte code:
/*    */           //   0: aload_0
/*    */           //   1: dup
/*    */           //   2: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*    */           //   5: pop
/*    */           //   6: astore_1
/*    */           //   7: iconst_0
/*    */           //   8: istore_2
/*    */           //   9: aload_1
/*    */           //   10: iload_2
/*    */           //   11: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives;I)I
/*    */           //   16: lookupswitch default -> 44, 0 -> 54, 1 -> 66
/*    */           //   44: new java/lang/MatchException
/*    */           //   47: dup
/*    */           //   48: aconst_null
/*    */           //   49: aconst_null
/*    */           //   50: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*    */           //   53: athrow
/*    */           //   54: aload_1
/*    */           //   55: checkcast dev/jab125/minimega/mod/util/minigamedata/battle/Lives$Infinite
/*    */           //   58: astore_3
/*    */           //   59: iconst_0
/*    */           //   60: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */           //   63: goto -> 107
/*    */           //   66: aload_1
/*    */           //   67: checkcast dev/jab125/minimega/mod/util/minigamedata/battle/Lives$Numbered
/*    */           //   70: astore #4
/*    */           //   72: aload #4
/*    */           //   74: invokevirtual amount : ()I
/*    */           //   77: istore #6
/*    */           //   79: iload #6
/*    */           //   81: istore #7
/*    */           //   83: iconst_1
/*    */           //   84: ifeq -> 94
/*    */           //   87: iload #6
/*    */           //   89: istore #5
/*    */           //   91: goto -> 99
/*    */           //   94: iconst_2
/*    */           //   95: istore_2
/*    */           //   96: goto -> 9
/*    */           //   99: iload #5
/*    */           //   101: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */           //   104: goto -> 107
/*    */           //   107: areturn
/*    */           //   108: astore_1
/*    */           //   109: new java/lang/MatchException
/*    */           //   112: dup
/*    */           //   113: aload_1
/*    */           //   114: invokevirtual toString : ()Ljava/lang/String;
/*    */           //   117: aload_1
/*    */           //   118: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*    */           //   121: athrow
/*    */           // Line number table:
/*    */           //   Java source line number -> byte code offset
/*    */           //   #13	-> 0
/*    */           //   #14	-> 54
/*    */           //   #15	-> 66
/*    */           // Local variable table:
/*    */           //   start	length	slot	name	descriptor
/*    */           //   59	7	3	$b$0	Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives$Infinite;
/*    */           //   83	1	7	tmp0$	I
/*    */           //   79	12	6	patt4$temp	I
/*    */           //   91	3	5	amount	I
/*    */           //   72	35	4	$b$1	Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives$Numbered;
/*    */           //   99	8	5	amount	I
/*    */           //   7	100	1	selector2$temp	Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives;
/*    */           //   9	98	2	index$3	I
/*    */           //   0	122	0	a	Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives;
/*    */           // Exception table:
/*    */           //   from	to	target	type
/*    */           //   74	77	108	java/lang/Throwable
/*    */         });
/*    */   } public static final class Numbered extends Record implements Lives {
/* 17 */     public Numbered(int amount) { this.amount = amount; } private final int amount; public int amount() { return this.amount; }
/*    */ 
/*    */     
/*    */     public final String toString() {
/*    */       // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives$Numbered;)Ljava/lang/String;
/*    */       //   6: areturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #17	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives$Numbered;
/*    */     }
/*    */     
/*    */     public final int hashCode() {
/*    */       // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives$Numbered;)I
/*    */       //   6: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #17	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives$Numbered;
/*    */     }
/*    */     
/*    */     public final boolean equals(Object o) {
/*    */       // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: aload_1
/*    */       //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives$Numbered;Ljava/lang/Object;)Z
/*    */       //   7: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #17	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	8	0	this	Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives$Numbered;
/*    */       //   0	8	1	o	Ljava/lang/Object;
/*    */     }
/*    */   }
/*    */   
/*    */   public static final class Infinite extends Record implements Lives {
/*    */     public final String toString() {
/*    */       // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives$Infinite;)Ljava/lang/String;
/*    */       //   6: areturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #18	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives$Infinite;
/*    */     }
/*    */     
/*    */     public final int hashCode() {
/*    */       // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives$Infinite;)I
/*    */       //   6: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #18	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives$Infinite;
/*    */     }
/*    */     
/*    */     public final boolean equals(Object o) {
/*    */       // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: aload_1
/*    */       //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives$Infinite;Ljava/lang/Object;)Z
/*    */       //   7: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #18	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	8	0	this	Ldev/jab125/minimega/mod/util/minigamedata/battle/Lives$Infinite;
/*    */       //   0	8	1	o	Ljava/lang/Object;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\minigamedata\battle\Lives.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */