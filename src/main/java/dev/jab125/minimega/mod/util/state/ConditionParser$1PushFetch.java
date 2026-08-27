/*    */ package dev.jab125.minimega.mod.util.state;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class PushFetch
/*    */   extends Record
/*    */   implements ConditionParser.Instruction
/*    */ {
/*    */   private final String value;
/*    */   
/*    */   PushFetch(String value) {
/* 26 */     this.value = value; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushFetch;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #26	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 26 */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushFetch; } public String value() { return this.value; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushFetch;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #26	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushFetch; }
/*    */   public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushFetch;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #26	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushFetch;
/*    */     //   0	8	1	o	Ljava/lang/Object; } public void execute(State state) {
/* 29 */     state.push(state.fetch(value()));
/*    */   }
/*    */ 
/*    */   
/*    */   public String srcDec() {
/* 34 */     return value();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\state\ConditionParser$1PushFetch.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */