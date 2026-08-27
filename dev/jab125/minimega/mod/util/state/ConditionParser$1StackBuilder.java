/*     */ package dev.jab125.minimega.mod.util.state;
/*     */ 
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
/*     */ class StackBuilder
/*     */ {
/* 106 */   private final List<ConditionParser.Instruction> instructions = new ArrayList<>();
/*     */ 
/*     */   
/*     */   void push(ConditionParser.Instruction instruction) throws ParseException {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: instanceof dev/jab125/minimega/mod/util/state/ConditionParser$1CommaMarker
/*     */     //   4: ifeq -> 37
/*     */     //   7: aload_0
/*     */     //   8: getfield instructions : Ljava/util/List;
/*     */     //   11: invokeinterface isEmpty : ()Z
/*     */     //   16: ifne -> 64
/*     */     //   19: aload_0
/*     */     //   20: getfield instructions : Ljava/util/List;
/*     */     //   23: invokeinterface getLast : ()Ljava/lang/Object;
/*     */     //   28: instanceof dev/jab125/minimega/mod/util/state/ConditionParser$1CommaMarker
/*     */     //   31: ifeq -> 84
/*     */     //   34: goto -> 64
/*     */     //   37: aload_0
/*     */     //   38: getfield instructions : Ljava/util/List;
/*     */     //   41: invokeinterface isEmpty : ()Z
/*     */     //   46: ifne -> 84
/*     */     //   49: aload_0
/*     */     //   50: getfield instructions : Ljava/util/List;
/*     */     //   53: invokeinterface getLast : ()Ljava/lang/Object;
/*     */     //   58: instanceof dev/jab125/minimega/mod/util/state/ConditionParser$1CommaMarker
/*     */     //   61: ifne -> 84
/*     */     //   64: new java/text/ParseException
/*     */     //   67: dup
/*     */     //   68: aload_1
/*     */     //   69: invokeinterface srcDec : ()Ljava/lang/String;
/*     */     //   74: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   79: iconst_0
/*     */     //   80: invokespecial <init> : (Ljava/lang/String;I)V
/*     */     //   83: athrow
/*     */     //   84: aload_0
/*     */     //   85: getfield instructions : Ljava/util/List;
/*     */     //   88: invokeinterface isEmpty : ()Z
/*     */     //   93: ifne -> 121
/*     */     //   96: aload_0
/*     */     //   97: getfield instructions : Ljava/util/List;
/*     */     //   100: invokeinterface getLast : ()Ljava/lang/Object;
/*     */     //   105: instanceof dev/jab125/minimega/mod/util/state/ConditionParser$1CommaMarker
/*     */     //   108: ifeq -> 121
/*     */     //   111: aload_0
/*     */     //   112: getfield instructions : Ljava/util/List;
/*     */     //   115: invokeinterface removeLast : ()Ljava/lang/Object;
/*     */     //   120: pop
/*     */     //   121: aload_0
/*     */     //   122: getfield instructions : Ljava/util/List;
/*     */     //   125: aload_1
/*     */     //   126: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   131: pop
/*     */     //   132: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #108	-> 0
/*     */     //   #109	-> 84
/*     */     //   #110	-> 121
/*     */     //   #111	-> 132
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	133	0	this	Ldev/jab125/minimega/mod/util/state/ConditionParser$1StackBuilder;
/*     */     //   0	133	1	instruction	Ldev/jab125/minimega/mod/util/state/ConditionParser$1Instruction;
/*     */   }
/*     */ 
/*     */   
/*     */   void bang() throws ParseException {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield instructions : Ljava/util/List;
/*     */     //   4: invokeinterface isEmpty : ()Z
/*     */     //   9: ifeq -> 16
/*     */     //   12: aconst_null
/*     */     //   13: goto -> 28
/*     */     //   16: aload_0
/*     */     //   17: getfield instructions : Ljava/util/List;
/*     */     //   20: invokeinterface removeLast : ()Ljava/lang/Object;
/*     */     //   25: checkcast dev/jab125/minimega/mod/util/state/ConditionParser$1Instruction
/*     */     //   28: dup
/*     */     //   29: astore_1
/*     */     //   30: astore #4
/*     */     //   32: aload #4
/*     */     //   34: instanceof dev/jab125/minimega/mod/util/state/ConditionParser$1PushFetch
/*     */     //   37: ifeq -> 82
/*     */     //   40: aload #4
/*     */     //   42: checkcast dev/jab125/minimega/mod/util/state/ConditionParser$1PushFetch
/*     */     //   45: astore_3
/*     */     //   46: aload_3
/*     */     //   47: invokevirtual value : ()Ljava/lang/String;
/*     */     //   50: astore #5
/*     */     //   52: aload #5
/*     */     //   54: astore_2
/*     */     //   55: ldc 'true'
/*     */     //   57: aload_2
/*     */     //   58: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   61: ifne -> 82
/*     */     //   64: ldc 'false'
/*     */     //   66: aload_2
/*     */     //   67: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   70: ifne -> 82
/*     */     //   73: ldc 'null'
/*     */     //   75: aload_2
/*     */     //   76: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   79: ifeq -> 111
/*     */     //   82: new java/text/ParseException
/*     */     //   85: dup
/*     */     //   86: aload_1
/*     */     //   87: ifnonnull -> 95
/*     */     //   90: ldc '<empty>'
/*     */     //   92: goto -> 101
/*     */     //   95: aload_1
/*     */     //   96: invokeinterface srcDec : ()Ljava/lang/String;
/*     */     //   101: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   106: iconst_0
/*     */     //   107: invokespecial <init> : (Ljava/lang/String;I)V
/*     */     //   110: athrow
/*     */     //   111: aload_0
/*     */     //   112: getfield instructions : Ljava/util/List;
/*     */     //   115: new dev/jab125/minimega/mod/util/state/ConditionParser$1PushInvoke
/*     */     //   118: dup
/*     */     //   119: aload_2
/*     */     //   120: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   123: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   128: pop
/*     */     //   129: goto -> 146
/*     */     //   132: astore_3
/*     */     //   133: new java/lang/MatchException
/*     */     //   136: dup
/*     */     //   137: aload_3
/*     */     //   138: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   141: aload_3
/*     */     //   142: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   145: athrow
/*     */     //   146: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #114	-> 0
/*     */     //   #115	-> 111
/*     */     //   #116	-> 146
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   55	27	2	value	Ljava/lang/String;
/*     */     //   30	102	1	i	Ldev/jab125/minimega/mod/util/state/ConditionParser$1Instruction;
/*     */     //   111	21	2	value	Ljava/lang/String;
/*     */     //   0	147	0	this	Ldev/jab125/minimega/mod/util/state/ConditionParser$1StackBuilder;
/*     */     //   146	1	1	i	Ldev/jab125/minimega/mod/util/state/ConditionParser$1Instruction;
/*     */     //   146	1	2	value	Ljava/lang/String;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   47	50	132	java/lang/Throwable
/*     */   }
/*     */   
/*     */   Consumer<State> build() throws ParseException {
/* 119 */     Objects.requireNonNull(ConditionParser.CommaMarker.class); if (this.instructions.stream().anyMatch(ConditionParser.CommaMarker.class::isInstance)) throw new ParseException("trailing comma", 0); 
/* 120 */     List<ConditionParser.Instruction> program = List.copyOf(this.instructions);
/* 121 */     return state -> {
/*     */         for (ConditionParser.Instruction instruction : program)
/*     */           instruction.execute(state); 
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\state\ConditionParser$1StackBuilder.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */