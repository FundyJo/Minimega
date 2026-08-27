/*     */ package dev.jab125.minimega.mod.util.state;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class PushInvoke
/*     */   extends Record
/*     */   implements ConditionParser.Instruction
/*     */ {
/*     */   private final String func;
/*     */   
/*     */   PushInvoke(String func) {
/*  94 */     this.func = func; } public final String toString() { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushInvoke;)Ljava/lang/String;
/*     */     //   6: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #94	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*  94 */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushInvoke; } public String func() { return this.func; }
/*     */   public final int hashCode() { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushInvoke;)I
/*     */     //   6: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #94	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushInvoke; }
/*     */   public final boolean equals(Object o) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_1
/*     */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushInvoke;Ljava/lang/Object;)Z
/*     */     //   7: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #94	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushInvoke;
/*     */     //   0	8	1	o	Ljava/lang/Object; } public void execute(State state) {
/*  97 */     state.execute(func());
/*     */   }
/*     */ 
/*     */   
/*     */   public String srcDec() {
/* 102 */     return func() + "!";
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\state\ConditionParser$1PushInvoke.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */