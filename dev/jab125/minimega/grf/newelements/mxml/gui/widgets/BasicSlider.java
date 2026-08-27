/*    */ package dev.jab125.minimega.grf.newelements.mxml.gui.widgets;
/*    */ 
/*    */ public final class BasicSlider extends Record implements Slider {
/*    */   private final Optional<String> id;
/*    */   private final Optional<String> loc;
/*    */   private final int loctype;
/*    */   private final Integer defaultValue;
/*    */   private final Integer[] values;
/*    */   public static final Codec<Slider> CODEC;
/*    */   
/* 11 */   public BasicSlider(Optional<String> id, Optional<String> loc, int loctype, Integer defaultValue, Integer[] values) { this.id = id; this.loc = loc; this.loctype = loctype; this.defaultValue = defaultValue; this.values = values; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/BasicSlider;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 11 */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/BasicSlider; } public Optional<String> id() { return this.id; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/BasicSlider;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/BasicSlider; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/BasicSlider;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/BasicSlider;
/* 11 */     //   0	8	1	o	Ljava/lang/Object; } public Optional<String> loc() { return this.loc; } public int loctype() { return this.loctype; } public Integer defaultValue() { return this.defaultValue; } public Integer[] values() { return this.values; } static {
/* 12 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Widgets.id(Widgets::id), (App)Widgets.loc(Widgets::loc), (App)Widgets.loctype(Widgets::loctype), (App)Widgets.defaultValue(LenientParsers.INT, Slider::defaultValue), (App)LenientParsers.CHILD_STRING.fieldOf("childRules").xmap((), ()).forGetter(Slider::values)).apply((Applicative)instance, BasicSlider::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String serializedId() {
/* 22 */     return "BasicSlider";
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\gui\widgets\BasicSlider.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */