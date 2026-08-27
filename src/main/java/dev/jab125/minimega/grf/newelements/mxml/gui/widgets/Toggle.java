/*    */ package dev.jab125.minimega.grf.newelements.mxml.gui.widgets;
/*    */ 
/*    */ public final class Toggle extends Record implements IMXml, Widgets<Boolean> {
/*    */   private final Optional<String> id;
/*    */   private final Optional<String> loc;
/*    */   private final int loctype;
/*    */   private final Boolean defaultValue;
/*    */   public static final Codec<Toggle> CODEC;
/*    */   
/* 10 */   public Toggle(Optional<String> id, Optional<String> loc, int loctype, Boolean defaultValue) { this.id = id; this.loc = loc; this.loctype = loctype; this.defaultValue = defaultValue; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/Toggle;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 10 */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/Toggle; } public Optional<String> id() { return this.id; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/Toggle;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/Toggle; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/Toggle;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/Toggle;
/* 10 */     //   0	8	1	o	Ljava/lang/Object; } public Optional<String> loc() { return this.loc; } public int loctype() { return this.loctype; } public Boolean defaultValue() { return this.defaultValue; } static {
/* 11 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Widgets.id(Toggle::id), (App)Widgets.loc(Toggle::loc), (App)Widgets.loctype(Toggle::loctype), (App)Widgets.defaultValue(LenientParsers.BOOL, Toggle::defaultValue)).apply((Applicative)instance, Toggle::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String serializedId() {
/* 20 */     return "Toggle";
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\gui\widgets\Toggle.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */