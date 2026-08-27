/*    */ package dev.jab125.minimega.grf.newelements.mxml.gui.widgets;
/*    */ 
/*    */ 
/*    */ public final class Button extends Record implements IMXml, Widgets<Void> {
/*    */   private final Optional<String> loc;
/*    */   private final String action;
/*    */   private final int loctype;
/*    */   public static final Codec<Button> CODEC;
/*    */   
/* 10 */   public Button(Optional<String> loc, String action, int loctype) { this.loc = loc; this.action = action; this.loctype = loctype; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/Button;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 10 */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/Button; } public Optional<String> loc() { return this.loc; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/Button;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/Button; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/Button;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/Button;
/* 10 */     //   0	8	1	o	Ljava/lang/Object; } public String action() { return this.action; } public int loctype() { return this.loctype; } static {
/* 11 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Widgets.loc(Button::loc), (App)LenientParsers.STRING.fieldOf("action").forGetter(Button::action), (App)Widgets.loctype(Button::loctype)).apply((Applicative)instance, Button::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String serializedId() {
/* 19 */     return "Button";
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<String> id() {
/* 24 */     return Optional.empty();
/*    */   }
/*    */ 
/*    */   
/*    */   public Void defaultValue() {
/* 29 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\gui\widgets\Button.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */