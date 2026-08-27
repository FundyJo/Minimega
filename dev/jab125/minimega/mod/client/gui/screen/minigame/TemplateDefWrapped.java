/*   */ package dev.jab125.minimega.mod.client.gui.screen.minigame;
/*   */ 
/*   */ 
/*   */ public final class TemplateDefWrapped extends Record {
/*   */   private final Predicate<State> enabled;
/*   */   private final TemplateDef templateDef;
/*   */   
/* 8 */   public TemplateDefWrapped(Predicate<State> enabled, TemplateDef templateDef) { this.enabled = enabled; this.templateDef = templateDef; } public final String toString() { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/client/gui/screen/minigame/TemplateDefWrapped;)Ljava/lang/String;
/*   */     //   6: areturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #8	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/* 8 */     //   0	7	0	this	Ldev/jab125/minimega/mod/client/gui/screen/minigame/TemplateDefWrapped; } public Predicate<State> enabled() { return this.enabled; } public final int hashCode() { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/client/gui/screen/minigame/TemplateDefWrapped;)I
/*   */     //   6: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #8	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	7	0	this	Ldev/jab125/minimega/mod/client/gui/screen/minigame/TemplateDefWrapped; } public final boolean equals(Object o) { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: aload_1
/*   */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/client/gui/screen/minigame/TemplateDefWrapped;Ljava/lang/Object;)Z
/*   */     //   7: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #8	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	8	0	this	Ldev/jab125/minimega/mod/client/gui/screen/minigame/TemplateDefWrapped;
/* 8 */     //   0	8	1	o	Ljava/lang/Object; } public TemplateDef templateDef() { return this.templateDef; }
/*   */ 
/*   */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\screen\minigame\TemplateDefWrapped.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */