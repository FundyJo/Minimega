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
/*    */ final class PushStringLiteral
/*    */   extends Record
/*    */   implements ConditionParser.Instruction
/*    */ {
/*    */   private final String value;
/*    */   
/*    */   PushStringLiteral(String value) {
/* 70 */     this.value = value; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushStringLiteral;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #70	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 70 */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushStringLiteral; } public String value() { return this.value; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushStringLiteral;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #70	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushStringLiteral; }
/*    */   public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushStringLiteral;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #70	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/state/ConditionParser$1PushStringLiteral;
/*    */     //   0	8	1	o	Ljava/lang/Object; } public void execute(State state) {
/* 73 */     state.push(value());
/*    */   }
/*    */ 
/*    */   
/*    */   public String srcDec() {
/* 78 */     String escaped = value().replace("\\", "\\\\").replace("\"", "\\\"");
/* 79 */     String quotedInputString = "\"" + escaped + "\"";
/* 80 */     return quotedInputString;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\state\ConditionParser$1PushStringLiteral.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */