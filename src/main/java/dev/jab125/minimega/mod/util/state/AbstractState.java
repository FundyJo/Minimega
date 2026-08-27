/*     */ package dev.jab125.minimega.mod.util.state;
/*     */ 
/*     */ import java.util.EmptyStackException;
/*     */ import java.util.Stack;
/*     */ 
/*     */ 
/*     */ public abstract class AbstractState
/*     */   implements State
/*     */ {
/*  10 */   protected final Stack<Object> objects = new Stack();
/*     */ 
/*     */   
/*     */   public void push(Object object) {
/*  14 */     this.objects.push(object);
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
/*     */   public void execute(String func) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: astore_2
/*     */     //   2: iconst_m1
/*     */     //   3: istore_3
/*     */     //   4: aload_2
/*     */     //   5: invokevirtual hashCode : ()I
/*     */     //   8: lookupswitch default -> 241, -1354795244 -> 184, 3244 -> 114, 3555 -> 156, 96727 -> 142, 99839 -> 214, 100674 -> 100, 109267 -> 170, 2989037 -> 199, 3119861 -> 128, 97322682 -> 229
/*     */     //   100: aload_2
/*     */     //   101: ldc 'eqn'
/*     */     //   103: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   106: ifeq -> 241
/*     */     //   109: iconst_0
/*     */     //   110: istore_3
/*     */     //   111: goto -> 241
/*     */     //   114: aload_2
/*     */     //   115: ldc 'eq'
/*     */     //   117: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   120: ifeq -> 241
/*     */     //   123: iconst_1
/*     */     //   124: istore_3
/*     */     //   125: goto -> 241
/*     */     //   128: aload_2
/*     */     //   129: ldc 'eqJS'
/*     */     //   131: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   134: ifeq -> 241
/*     */     //   137: iconst_2
/*     */     //   138: istore_3
/*     */     //   139: goto -> 241
/*     */     //   142: aload_2
/*     */     //   143: ldc 'and'
/*     */     //   145: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   148: ifeq -> 241
/*     */     //   151: iconst_3
/*     */     //   152: istore_3
/*     */     //   153: goto -> 241
/*     */     //   156: aload_2
/*     */     //   157: ldc 'or'
/*     */     //   159: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   162: ifeq -> 241
/*     */     //   165: iconst_4
/*     */     //   166: istore_3
/*     */     //   167: goto -> 241
/*     */     //   170: aload_2
/*     */     //   171: ldc 'not'
/*     */     //   173: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   176: ifeq -> 241
/*     */     //   179: iconst_5
/*     */     //   180: istore_3
/*     */     //   181: goto -> 241
/*     */     //   184: aload_2
/*     */     //   185: ldc 'concat'
/*     */     //   187: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   190: ifeq -> 241
/*     */     //   193: bipush #6
/*     */     //   195: istore_3
/*     */     //   196: goto -> 241
/*     */     //   199: aload_2
/*     */     //   200: ldc 'addn'
/*     */     //   202: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   205: ifeq -> 241
/*     */     //   208: bipush #7
/*     */     //   210: istore_3
/*     */     //   211: goto -> 241
/*     */     //   214: aload_2
/*     */     //   215: ldc 'dup'
/*     */     //   217: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   220: ifeq -> 241
/*     */     //   223: bipush #8
/*     */     //   225: istore_3
/*     */     //   226: goto -> 241
/*     */     //   229: aload_2
/*     */     //   230: ldc 'fetch'
/*     */     //   232: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   235: ifeq -> 241
/*     */     //   238: bipush #9
/*     */     //   240: istore_3
/*     */     //   241: iload_3
/*     */     //   242: tableswitch default -> 933, 0 -> 296, 1 -> 393, 2 -> 432, 3 -> 487, 4 -> 570, 5 -> 653, 6 -> 704, 7 -> 758, 8 -> 856, 9 -> 888
/*     */     //   296: aload_0
/*     */     //   297: getfield objects : Ljava/util/Stack;
/*     */     //   300: invokevirtual pop : ()Ljava/lang/Object;
/*     */     //   303: astore #4
/*     */     //   305: aload_0
/*     */     //   306: getfield objects : Ljava/util/Stack;
/*     */     //   309: invokevirtual pop : ()Ljava/lang/Object;
/*     */     //   312: astore #5
/*     */     //   314: aload_0
/*     */     //   315: getfield objects : Ljava/util/Stack;
/*     */     //   318: aload_0
/*     */     //   319: aload #4
/*     */     //   321: invokevirtual tryCoerceToNum : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   324: astore #8
/*     */     //   326: aload #8
/*     */     //   328: instanceof java/lang/Number
/*     */     //   331: ifeq -> 382
/*     */     //   334: aload #8
/*     */     //   336: checkcast java/lang/Number
/*     */     //   339: astore #7
/*     */     //   341: aload_0
/*     */     //   342: aload #5
/*     */     //   344: invokevirtual tryCoerceToNum : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   347: astore #8
/*     */     //   349: aload #8
/*     */     //   351: instanceof java/lang/Number
/*     */     //   354: ifeq -> 382
/*     */     //   357: aload #8
/*     */     //   359: checkcast java/lang/Number
/*     */     //   362: astore #6
/*     */     //   364: aload #7
/*     */     //   366: invokevirtual doubleValue : ()D
/*     */     //   369: aload #6
/*     */     //   371: invokevirtual doubleValue : ()D
/*     */     //   374: dcmpl
/*     */     //   375: ifne -> 382
/*     */     //   378: iconst_1
/*     */     //   379: goto -> 383
/*     */     //   382: iconst_0
/*     */     //   383: invokestatic valueOf : (Z)Ljava/lang/Boolean;
/*     */     //   386: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   389: pop
/*     */     //   390: goto -> 948
/*     */     //   393: aload_0
/*     */     //   394: getfield objects : Ljava/util/Stack;
/*     */     //   397: invokevirtual pop : ()Ljava/lang/Object;
/*     */     //   400: astore #4
/*     */     //   402: aload_0
/*     */     //   403: getfield objects : Ljava/util/Stack;
/*     */     //   406: invokevirtual pop : ()Ljava/lang/Object;
/*     */     //   409: astore #5
/*     */     //   411: aload_0
/*     */     //   412: getfield objects : Ljava/util/Stack;
/*     */     //   415: aload #5
/*     */     //   417: aload #4
/*     */     //   419: invokestatic equals : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   422: invokestatic valueOf : (Z)Ljava/lang/Boolean;
/*     */     //   425: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   428: pop
/*     */     //   429: goto -> 948
/*     */     //   432: aload_0
/*     */     //   433: getfield objects : Ljava/util/Stack;
/*     */     //   436: invokevirtual pop : ()Ljava/lang/Object;
/*     */     //   439: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   442: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   447: astore #4
/*     */     //   449: aload_0
/*     */     //   450: getfield objects : Ljava/util/Stack;
/*     */     //   453: invokevirtual pop : ()Ljava/lang/Object;
/*     */     //   456: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   459: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   464: astore #5
/*     */     //   466: aload_0
/*     */     //   467: getfield objects : Ljava/util/Stack;
/*     */     //   470: aload #5
/*     */     //   472: aload #4
/*     */     //   474: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   477: invokestatic valueOf : (Z)Ljava/lang/Boolean;
/*     */     //   480: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   483: pop
/*     */     //   484: goto -> 948
/*     */     //   487: aload_0
/*     */     //   488: getfield objects : Ljava/util/Stack;
/*     */     //   491: invokevirtual pop : ()Ljava/lang/Object;
/*     */     //   494: astore #4
/*     */     //   496: aload_0
/*     */     //   497: getfield objects : Ljava/util/Stack;
/*     */     //   500: invokevirtual pop : ()Ljava/lang/Object;
/*     */     //   503: astore #5
/*     */     //   505: aload_0
/*     */     //   506: getfield objects : Ljava/util/Stack;
/*     */     //   509: aload #4
/*     */     //   511: instanceof java/lang/Boolean
/*     */     //   514: ifeq -> 559
/*     */     //   517: aload #4
/*     */     //   519: checkcast java/lang/Boolean
/*     */     //   522: astore #7
/*     */     //   524: aload #5
/*     */     //   526: instanceof java/lang/Boolean
/*     */     //   529: ifeq -> 559
/*     */     //   532: aload #5
/*     */     //   534: checkcast java/lang/Boolean
/*     */     //   537: astore #6
/*     */     //   539: aload #7
/*     */     //   541: invokevirtual booleanValue : ()Z
/*     */     //   544: ifeq -> 559
/*     */     //   547: aload #6
/*     */     //   549: invokevirtual booleanValue : ()Z
/*     */     //   552: ifeq -> 559
/*     */     //   555: iconst_1
/*     */     //   556: goto -> 560
/*     */     //   559: iconst_0
/*     */     //   560: invokestatic valueOf : (Z)Ljava/lang/Boolean;
/*     */     //   563: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   566: pop
/*     */     //   567: goto -> 948
/*     */     //   570: aload_0
/*     */     //   571: getfield objects : Ljava/util/Stack;
/*     */     //   574: invokevirtual pop : ()Ljava/lang/Object;
/*     */     //   577: astore #4
/*     */     //   579: aload_0
/*     */     //   580: getfield objects : Ljava/util/Stack;
/*     */     //   583: invokevirtual pop : ()Ljava/lang/Object;
/*     */     //   586: astore #5
/*     */     //   588: aload_0
/*     */     //   589: getfield objects : Ljava/util/Stack;
/*     */     //   592: aload #4
/*     */     //   594: instanceof java/lang/Boolean
/*     */     //   597: ifeq -> 642
/*     */     //   600: aload #4
/*     */     //   602: checkcast java/lang/Boolean
/*     */     //   605: astore #7
/*     */     //   607: aload #5
/*     */     //   609: instanceof java/lang/Boolean
/*     */     //   612: ifeq -> 642
/*     */     //   615: aload #5
/*     */     //   617: checkcast java/lang/Boolean
/*     */     //   620: astore #6
/*     */     //   622: aload #7
/*     */     //   624: invokevirtual booleanValue : ()Z
/*     */     //   627: ifne -> 638
/*     */     //   630: aload #6
/*     */     //   632: invokevirtual booleanValue : ()Z
/*     */     //   635: ifeq -> 642
/*     */     //   638: iconst_1
/*     */     //   639: goto -> 643
/*     */     //   642: iconst_0
/*     */     //   643: invokestatic valueOf : (Z)Ljava/lang/Boolean;
/*     */     //   646: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   649: pop
/*     */     //   650: goto -> 948
/*     */     //   653: aload_0
/*     */     //   654: getfield objects : Ljava/util/Stack;
/*     */     //   657: invokevirtual pop : ()Ljava/lang/Object;
/*     */     //   660: astore #4
/*     */     //   662: aload_0
/*     */     //   663: getfield objects : Ljava/util/Stack;
/*     */     //   666: aload #4
/*     */     //   668: instanceof java/lang/Boolean
/*     */     //   671: ifeq -> 693
/*     */     //   674: aload #4
/*     */     //   676: checkcast java/lang/Boolean
/*     */     //   679: astore #5
/*     */     //   681: aload #5
/*     */     //   683: invokevirtual booleanValue : ()Z
/*     */     //   686: ifne -> 693
/*     */     //   689: iconst_1
/*     */     //   690: goto -> 694
/*     */     //   693: iconst_0
/*     */     //   694: invokestatic valueOf : (Z)Ljava/lang/Boolean;
/*     */     //   697: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   700: pop
/*     */     //   701: goto -> 948
/*     */     //   704: aload_0
/*     */     //   705: getfield objects : Ljava/util/Stack;
/*     */     //   708: invokevirtual pop : ()Ljava/lang/Object;
/*     */     //   711: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   714: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   719: astore #4
/*     */     //   721: aload_0
/*     */     //   722: getfield objects : Ljava/util/Stack;
/*     */     //   725: invokevirtual pop : ()Ljava/lang/Object;
/*     */     //   728: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   731: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   736: astore #5
/*     */     //   738: aload_0
/*     */     //   739: getfield objects : Ljava/util/Stack;
/*     */     //   742: aload #5
/*     */     //   744: aload #4
/*     */     //   746: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   751: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   754: pop
/*     */     //   755: goto -> 948
/*     */     //   758: aload_0
/*     */     //   759: getfield objects : Ljava/util/Stack;
/*     */     //   762: invokevirtual pop : ()Ljava/lang/Object;
/*     */     //   765: astore #4
/*     */     //   767: aload_0
/*     */     //   768: getfield objects : Ljava/util/Stack;
/*     */     //   771: invokevirtual pop : ()Ljava/lang/Object;
/*     */     //   774: astore #5
/*     */     //   776: aload_0
/*     */     //   777: getfield objects : Ljava/util/Stack;
/*     */     //   780: aload_0
/*     */     //   781: aload #4
/*     */     //   783: invokevirtual tryCoerceToNum : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   786: astore #8
/*     */     //   788: aload #8
/*     */     //   790: instanceof java/lang/Number
/*     */     //   793: ifeq -> 843
/*     */     //   796: aload #8
/*     */     //   798: checkcast java/lang/Number
/*     */     //   801: astore #7
/*     */     //   803: aload_0
/*     */     //   804: aload #5
/*     */     //   806: invokevirtual tryCoerceToNum : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   809: astore #8
/*     */     //   811: aload #8
/*     */     //   813: instanceof java/lang/Number
/*     */     //   816: ifeq -> 843
/*     */     //   819: aload #8
/*     */     //   821: checkcast java/lang/Number
/*     */     //   824: astore #6
/*     */     //   826: aload #7
/*     */     //   828: invokevirtual doubleValue : ()D
/*     */     //   831: aload #6
/*     */     //   833: invokevirtual doubleValue : ()D
/*     */     //   836: dadd
/*     */     //   837: invokestatic valueOf : (D)Ljava/lang/Double;
/*     */     //   840: goto -> 849
/*     */     //   843: ldc2_w NaN
/*     */     //   846: invokestatic valueOf : (D)Ljava/lang/Double;
/*     */     //   849: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   852: pop
/*     */     //   853: goto -> 948
/*     */     //   856: aload_0
/*     */     //   857: getfield objects : Ljava/util/Stack;
/*     */     //   860: invokevirtual pop : ()Ljava/lang/Object;
/*     */     //   863: astore #4
/*     */     //   865: aload_0
/*     */     //   866: getfield objects : Ljava/util/Stack;
/*     */     //   869: aload #4
/*     */     //   871: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   874: pop
/*     */     //   875: aload_0
/*     */     //   876: getfield objects : Ljava/util/Stack;
/*     */     //   879: aload #4
/*     */     //   881: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   884: pop
/*     */     //   885: goto -> 948
/*     */     //   888: aload_0
/*     */     //   889: getfield objects : Ljava/util/Stack;
/*     */     //   892: aload_0
/*     */     //   893: getfield objects : Ljava/util/Stack;
/*     */     //   896: invokevirtual pop : ()Ljava/lang/Object;
/*     */     //   899: astore #5
/*     */     //   901: aload #5
/*     */     //   903: instanceof java/lang/String
/*     */     //   906: ifeq -> 925
/*     */     //   909: aload #5
/*     */     //   911: checkcast java/lang/String
/*     */     //   914: astore #4
/*     */     //   916: aload_0
/*     */     //   917: aload #4
/*     */     //   919: invokevirtual fetch : (Ljava/lang/String;)Ljava/lang/Object;
/*     */     //   922: goto -> 926
/*     */     //   925: aconst_null
/*     */     //   926: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   929: pop
/*     */     //   930: goto -> 948
/*     */     //   933: new java/lang/UnsupportedOperationException
/*     */     //   936: dup
/*     */     //   937: aload_1
/*     */     //   938: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   943: aconst_null
/*     */     //   944: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   947: athrow
/*     */     //   948: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #19	-> 0
/*     */     //   #22	-> 296
/*     */     //   #23	-> 305
/*     */     //   #24	-> 314
/*     */     //   #25	-> 390
/*     */     //   #27	-> 393
/*     */     //   #28	-> 402
/*     */     //   #29	-> 411
/*     */     //   #30	-> 429
/*     */     //   #32	-> 432
/*     */     //   #33	-> 449
/*     */     //   #34	-> 466
/*     */     //   #35	-> 484
/*     */     //   #37	-> 487
/*     */     //   #38	-> 496
/*     */     //   #39	-> 505
/*     */     //   #40	-> 567
/*     */     //   #42	-> 570
/*     */     //   #43	-> 579
/*     */     //   #44	-> 588
/*     */     //   #45	-> 650
/*     */     //   #47	-> 653
/*     */     //   #48	-> 662
/*     */     //   #49	-> 701
/*     */     //   #51	-> 704
/*     */     //   #52	-> 721
/*     */     //   #53	-> 738
/*     */     //   #54	-> 755
/*     */     //   #56	-> 758
/*     */     //   #57	-> 767
/*     */     //   #58	-> 776
/*     */     //   #59	-> 853
/*     */     //   #61	-> 856
/*     */     //   #62	-> 865
/*     */     //   #63	-> 875
/*     */     //   #64	-> 885
/*     */     //   #65	-> 888
/*     */     //   #66	-> 933
/*     */     //   #68	-> 948
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   364	18	6	n2	Ljava/lang/Number;
/*     */     //   341	41	7	n	Ljava/lang/Number;
/*     */     //   305	85	4	pop	Ljava/lang/Object;
/*     */     //   314	76	5	pop2	Ljava/lang/Object;
/*     */     //   402	27	4	second	Ljava/lang/Object;
/*     */     //   411	18	5	first	Ljava/lang/Object;
/*     */     //   449	35	4	second	Ljava/lang/String;
/*     */     //   466	18	5	first	Ljava/lang/String;
/*     */     //   539	20	6	b2	Ljava/lang/Boolean;
/*     */     //   524	35	7	b	Ljava/lang/Boolean;
/*     */     //   496	71	4	pop	Ljava/lang/Object;
/*     */     //   505	62	5	pop2	Ljava/lang/Object;
/*     */     //   622	20	6	b2	Ljava/lang/Boolean;
/*     */     //   607	35	7	b	Ljava/lang/Boolean;
/*     */     //   579	71	4	pop	Ljava/lang/Object;
/*     */     //   588	62	5	pop2	Ljava/lang/Object;
/*     */     //   681	12	5	b	Ljava/lang/Boolean;
/*     */     //   662	39	4	pop	Ljava/lang/Object;
/*     */     //   721	34	4	second	Ljava/lang/String;
/*     */     //   738	17	5	first	Ljava/lang/String;
/*     */     //   826	17	6	n2	Ljava/lang/Number;
/*     */     //   803	40	7	n	Ljava/lang/Number;
/*     */     //   767	86	4	pop	Ljava/lang/Object;
/*     */     //   776	77	5	pop2	Ljava/lang/Object;
/*     */     //   865	20	4	pop	Ljava/lang/Object;
/*     */     //   916	9	4	str	Ljava/lang/String;
/*     */     //   0	949	0	this	Ldev/jab125/minimega/mod/util/state/AbstractState;
/*     */     //   0	949	1	func	Ljava/lang/String;
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
/*     */   private Object tryCoerceToNum(Object obj) {
/*  71 */     if (obj instanceof CharSequence) { CharSequence c = (CharSequence)obj;
/*     */       
/*  73 */       try { return Double.valueOf(Double.parseDouble(c.toString())); }
/*  74 */       catch (NumberFormatException e) { return obj; }
/*     */        }
/*  76 */      return obj;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean retrieveFinalResult() throws State.InvalidResultException {
/*     */     try {
/*  82 */       return ((Boolean)this.objects.pop()).booleanValue();
/*  83 */     } catch (EmptyStackException|NullPointerException|ClassCastException e) {
/*  84 */       throw new State.InvalidResultException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> T retrieveFinalResult(Class<T> t) throws State.InvalidResultException {
/*     */     try {
/*  91 */       return t.cast(this.objects.pop());
/*  92 */     } catch (EmptyStackException|NullPointerException|ClassCastException e) {
/*  93 */       throw new State.InvalidResultException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int popInt() {
/*  98 */     return ((Number)this.objects.pop()).intValue();
/*     */   }
/*     */   
/*     */   public boolean popBool() {
/* 102 */     return ((Boolean)this.objects.pop()).booleanValue();
/*     */   }
/*     */   
/*     */   public String popStr() {
/* 106 */     return (String)this.objects.pop();
/*     */   }
/*     */   
/*     */   public Object pop() {
/* 110 */     return this.objects.pop();
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\state\AbstractState.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */