/*     */ package dev.jab125.minimega.mod.util.state;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.text.ParseException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.function.Consumer;
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
/*     */ 
/*     */ 
/*     */ public class ConditionParser
/*     */ {
/*     */   public static Consumer<State> parse(String s) throws ParseException {
/*     */     // Byte code:
/*     */     //   0: new java/io/StringReader
/*     */     //   3: dup
/*     */     //   4: aload_0
/*     */     //   5: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   8: astore_1
/*     */     //   9: new java/io/StreamTokenizer
/*     */     //   12: dup
/*     */     //   13: aload_1
/*     */     //   14: invokespecial <init> : (Ljava/io/Reader;)V
/*     */     //   17: astore_2
/*     */     //   18: aload_2
/*     */     //   19: iconst_0
/*     */     //   20: bipush #32
/*     */     //   22: invokevirtual ordinaryChars : (II)V
/*     */     //   25: aload_2
/*     */     //   26: bipush #44
/*     */     //   28: invokevirtual ordinaryChar : (I)V
/*     */     //   31: aload_2
/*     */     //   32: bipush #33
/*     */     //   34: invokevirtual ordinaryChar : (I)V
/*     */     //   37: aload_2
/*     */     //   38: bipush #34
/*     */     //   40: invokevirtual ordinaryChar : (I)V
/*     */     //   43: aload_2
/*     */     //   44: bipush #39
/*     */     //   46: invokevirtual quoteChar : (I)V
/*     */     //   49: new dev/jab125/minimega/mod/util/state/ConditionParser$1StackBuilder
/*     */     //   52: dup
/*     */     //   53: invokespecial <init> : ()V
/*     */     //   56: astore_3
/*     */     //   57: iconst_0
/*     */     //   58: istore #4
/*     */     //   60: aload_2
/*     */     //   61: dup
/*     */     //   62: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   65: pop
/*     */     //   66: <illegal opcode> call : (Ljava/io/StreamTokenizer;)Ldev/jab125/minimega/mod/util/state/ConditionParser$SwallowIOExceptionWhichIsntEvenPossibleInTheFirstPlace;
/*     */     //   71: invokestatic swallow : (Ldev/jab125/minimega/mod/util/state/ConditionParser$SwallowIOExceptionWhichIsntEvenPossibleInTheFirstPlace;)I
/*     */     //   74: iconst_m1
/*     */     //   75: if_icmpeq -> 542
/*     */     //   78: aload_2
/*     */     //   79: getfield ttype : I
/*     */     //   82: tableswitch default -> 501, -3 -> 288, -2 -> 400, -1 -> 501, 0 -> 476, 1 -> 476, 2 -> 476, 3 -> 476, 4 -> 476, 5 -> 476, 6 -> 476, 7 -> 476, 8 -> 476, 9 -> 495, 10 -> 476, 11 -> 476, 12 -> 476, 13 -> 476, 14 -> 476, 15 -> 476, 16 -> 476, 17 -> 476, 18 -> 476, 19 -> 476, 20 -> 476, 21 -> 476, 22 -> 476, 23 -> 476, 24 -> 476, 25 -> 476, 26 -> 476, 27 -> 476, 28 -> 476, 29 -> 476, 30 -> 476, 31 -> 476, 32 -> 495, 33 -> 436, 34 -> 476, 35 -> 501, 36 -> 501, 37 -> 501, 38 -> 501, 39 -> 418, 40 -> 501, 41 -> 501, 42 -> 501, 43 -> 501, 44 -> 459
/*     */     //   288: aload_2
/*     */     //   289: getfield sval : Ljava/lang/String;
/*     */     //   292: dup
/*     */     //   293: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   296: pop
/*     */     //   297: astore #5
/*     */     //   299: iconst_0
/*     */     //   300: istore #6
/*     */     //   302: aload #5
/*     */     //   304: iload #6
/*     */     //   306: <illegal opcode> typeSwitch : (Ljava/lang/String;I)I
/*     */     //   311: tableswitch default -> 380, 0 -> 336, 1 -> 351, 2 -> 366
/*     */     //   336: aload_3
/*     */     //   337: new dev/jab125/minimega/mod/util/state/ConditionParser$1PushBoolean
/*     */     //   340: dup
/*     */     //   341: iconst_1
/*     */     //   342: invokespecial <init> : (Z)V
/*     */     //   345: invokevirtual push : (Ldev/jab125/minimega/mod/util/state/ConditionParser$1Instruction;)V
/*     */     //   348: goto -> 397
/*     */     //   351: aload_3
/*     */     //   352: new dev/jab125/minimega/mod/util/state/ConditionParser$1PushBoolean
/*     */     //   355: dup
/*     */     //   356: iconst_0
/*     */     //   357: invokespecial <init> : (Z)V
/*     */     //   360: invokevirtual push : (Ldev/jab125/minimega/mod/util/state/ConditionParser$1Instruction;)V
/*     */     //   363: goto -> 397
/*     */     //   366: aload_3
/*     */     //   367: new dev/jab125/minimega/mod/util/state/ConditionParser$1PushNull
/*     */     //   370: dup
/*     */     //   371: invokespecial <init> : ()V
/*     */     //   374: invokevirtual push : (Ldev/jab125/minimega/mod/util/state/ConditionParser$1Instruction;)V
/*     */     //   377: goto -> 397
/*     */     //   380: aload #5
/*     */     //   382: astore #7
/*     */     //   384: aload_3
/*     */     //   385: new dev/jab125/minimega/mod/util/state/ConditionParser$1PushFetch
/*     */     //   388: dup
/*     */     //   389: aload #7
/*     */     //   391: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   394: invokevirtual push : (Ldev/jab125/minimega/mod/util/state/ConditionParser$1Instruction;)V
/*     */     //   397: goto -> 536
/*     */     //   400: aload_3
/*     */     //   401: new dev/jab125/minimega/mod/util/state/ConditionParser$1PushDouble
/*     */     //   404: dup
/*     */     //   405: aload_2
/*     */     //   406: getfield nval : D
/*     */     //   409: invokespecial <init> : (D)V
/*     */     //   412: invokevirtual push : (Ldev/jab125/minimega/mod/util/state/ConditionParser$1Instruction;)V
/*     */     //   415: goto -> 536
/*     */     //   418: aload_3
/*     */     //   419: new dev/jab125/minimega/mod/util/state/ConditionParser$1PushStringLiteral
/*     */     //   422: dup
/*     */     //   423: aload_2
/*     */     //   424: getfield sval : Ljava/lang/String;
/*     */     //   427: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   430: invokevirtual push : (Ldev/jab125/minimega/mod/util/state/ConditionParser$1Instruction;)V
/*     */     //   433: goto -> 536
/*     */     //   436: iload #4
/*     */     //   438: ifeq -> 452
/*     */     //   441: new java/text/ParseException
/*     */     //   444: dup
/*     */     //   445: ldc 'there cannot be whitespace before a function call!'
/*     */     //   447: iconst_0
/*     */     //   448: invokespecial <init> : (Ljava/lang/String;I)V
/*     */     //   451: athrow
/*     */     //   452: aload_3
/*     */     //   453: invokevirtual bang : ()V
/*     */     //   456: goto -> 536
/*     */     //   459: aload_3
/*     */     //   460: new dev/jab125/minimega/mod/util/state/ConditionParser$1CommaMarker
/*     */     //   463: dup
/*     */     //   464: invokespecial <init> : ()V
/*     */     //   467: invokevirtual push : (Ldev/jab125/minimega/mod/util/state/ConditionParser$1Instruction;)V
/*     */     //   470: iconst_0
/*     */     //   471: istore #4
/*     */     //   473: goto -> 60
/*     */     //   476: new java/text/ParseException
/*     */     //   479: dup
/*     */     //   480: aload_2
/*     */     //   481: getfield ttype : I
/*     */     //   484: i2c
/*     */     //   485: <illegal opcode> makeConcatWithConstants : (C)Ljava/lang/String;
/*     */     //   490: iconst_0
/*     */     //   491: invokespecial <init> : (Ljava/lang/String;I)V
/*     */     //   494: athrow
/*     */     //   495: iconst_1
/*     */     //   496: istore #4
/*     */     //   498: goto -> 60
/*     */     //   501: getstatic java/lang/System.out : Ljava/io/PrintStream;
/*     */     //   504: aload_2
/*     */     //   505: getfield ttype : I
/*     */     //   508: i2c
/*     */     //   509: <illegal opcode> makeConcatWithConstants : (C)Ljava/lang/String;
/*     */     //   514: invokevirtual println : (Ljava/lang/String;)V
/*     */     //   517: new java/text/ParseException
/*     */     //   520: dup
/*     */     //   521: aload_2
/*     */     //   522: getfield ttype : I
/*     */     //   525: i2c
/*     */     //   526: <illegal opcode> makeConcatWithConstants : (C)Ljava/lang/String;
/*     */     //   531: iconst_0
/*     */     //   532: invokespecial <init> : (Ljava/lang/String;I)V
/*     */     //   535: athrow
/*     */     //   536: iconst_0
/*     */     //   537: istore #4
/*     */     //   539: goto -> 60
/*     */     //   542: aload_3
/*     */     //   543: invokevirtual build : ()Ljava/util/function/Consumer;
/*     */     //   546: astore #5
/*     */     //   548: aload_1
/*     */     //   549: invokevirtual close : ()V
/*     */     //   552: aload #5
/*     */     //   554: areturn
/*     */     //   555: astore_2
/*     */     //   556: aload_1
/*     */     //   557: invokevirtual close : ()V
/*     */     //   560: goto -> 569
/*     */     //   563: astore_3
/*     */     //   564: aload_2
/*     */     //   565: aload_3
/*     */     //   566: invokevirtual addSuppressed : (Ljava/lang/Throwable;)V
/*     */     //   569: aload_2
/*     */     //   570: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #15	-> 0
/*     */     //   #16	-> 9
/*     */     //   #17	-> 18
/*     */     //   #18	-> 25
/*     */     //   #19	-> 31
/*     */     //   #20	-> 37
/*     */     //   #21	-> 43
/*     */     //   #128	-> 49
/*     */     //   #129	-> 57
/*     */     //   #130	-> 60
/*     */     //   #131	-> 78
/*     */     //   #132	-> 288
/*     */     //   #133	-> 336
/*     */     //   #134	-> 351
/*     */     //   #135	-> 366
/*     */     //   #136	-> 380
/*     */     //   #137	-> 397
/*     */     //   #138	-> 400
/*     */     //   #139	-> 418
/*     */     //   #141	-> 436
/*     */     //   #142	-> 452
/*     */     //   #143	-> 456
/*     */     //   #145	-> 459
/*     */     //   #146	-> 470
/*     */     //   #147	-> 473
/*     */     //   #150	-> 476
/*     */     //   #153	-> 495
/*     */     //   #154	-> 498
/*     */     //   #157	-> 501
/*     */     //   #158	-> 517
/*     */     //   #161	-> 536
/*     */     //   #164	-> 542
/*     */     //   #165	-> 548
/*     */     //   #164	-> 552
/*     */     //   #15	-> 555
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   384	13	7	str	Ljava/lang/String;
/*     */     //   18	537	2	tokenizer	Ljava/io/StreamTokenizer;
/*     */     //   57	498	3	builder	Ldev/jab125/minimega/mod/util/state/ConditionParser$1StackBuilder;
/*     */     //   60	495	4	justSawWhitespace	Z
/*     */     //   9	562	1	reader	Ljava/io/StringReader;
/*     */     //   0	571	0	s	Ljava/lang/String;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   9	548	555	java/lang/Throwable
/*     */     //   556	560	563	java/lang/Throwable
/*     */   }
/*     */   
/*     */   private static int swallow(SwallowIOExceptionWhichIsntEvenPossibleInTheFirstPlace call) {
/*     */     try {
/* 174 */       return call.call();
/* 175 */     } catch (IOException e) {
/* 176 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   static void main() throws ParseException, State.InvalidResultException {
/* 181 */     String s = "gameType,2.5,eqn!,gameType,2.5,eqn!,eq!,gameType,2.5,eqn!,gameType,2.5,eqn!,eq!,eq!";
/* 182 */     Consumer<State> condition = parse(s);
/* 183 */     State state = new AbstractState()
/*     */       {
/*     */         public Object fetch(String s)
/*     */         {
/* 187 */           if (s.equals("gameType")) return Integer.valueOf(2); 
/* 188 */           return null;
/*     */         }
/*     */       };
/* 191 */     condition.accept(state);
/* 192 */     System.out.println(condition);
/* 193 */     System.out.println(state.retrieveFinalResult());
/*     */   }
/*     */   
/*     */   static interface SwallowIOExceptionWhichIsntEvenPossibleInTheFirstPlace {
/*     */     int call() throws IOException;
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\state\ConditionParser.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */