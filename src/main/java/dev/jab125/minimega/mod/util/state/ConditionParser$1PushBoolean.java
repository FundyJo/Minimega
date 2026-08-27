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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class PushBoolean
/*    */   extends Record
/*    */   implements ConditionParser.Instruction
/*    */ {
/*    */   private final boolean value;
/*    */   
/*    */   PushBoolean(boolean value) {
/* 48 */     this.value = value; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushBoolean;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #48	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 48 */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushBoolean; } public boolean value() { return this.value; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushBoolean;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #48	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushBoolean; }
/*    */   public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushBoolean;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #48	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushBoolean;
/*    */     //   0	8	1	o	Ljava/lang/Object; } public void execute(State state) {
/* 51 */     state.push(Boolean.valueOf(value()));
/*    */   }
/*    */ 
/*    */   
/*    */   public String srcDec() {
/* 56 */     return Boolean.toString(value());
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\state\ConditionParser$1PushBoolean.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */