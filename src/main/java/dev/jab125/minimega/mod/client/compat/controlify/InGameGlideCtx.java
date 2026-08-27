/*    */ package dev.jab125.minimega.mod.client.compat.controlify;
/*    */ 
/*    */ import dev.isxander.controlify.api.guide.InGameCtx;
/*    */ 
/*    */ public final class InGameGlideCtx extends Record implements FactCtx {
/*    */   private final InGameCtx inGameCtx;
/*    */   
/*  8 */   public InGameGlideCtx(InGameCtx inGameCtx) { this.inGameCtx = inGameCtx; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/client/compat/controlify/InGameGlideCtx;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  8 */     //   0	7	0	this	Ldev/jab125/minimega/mod/client/compat/controlify/InGameGlideCtx; } public InGameCtx inGameCtx() { return this.inGameCtx; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/client/compat/controlify/InGameGlideCtx;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/client/compat/controlify/InGameGlideCtx; } public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/client/compat/controlify/InGameGlideCtx;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/client/compat/controlify/InGameGlideCtx;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   } public ControllerEntity controller() {
/* 12 */     return this.inGameCtx.controller();
/*    */   }
/*    */ 
/*    */   
/*    */   public GuideVerbosity verbosity() {
/* 17 */     return this.inGameCtx.verbosity();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\compat\controlify\InGameGlideCtx.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */