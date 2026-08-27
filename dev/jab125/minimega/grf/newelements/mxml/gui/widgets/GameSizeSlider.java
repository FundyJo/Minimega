/*    */ package dev.jab125.minimega.grf.newelements.mxml.gui.widgets;
/*    */ 
/*    */ public final class GameSizeSlider extends Record implements Slider {
/*    */   private final Optional<String> id;
/*    */   private final Optional<String> loc;
/*    */   private final int loctype;
/*    */   public static final Codec<Slider> CODEC;
/*    */   
/*  9 */   public GameSizeSlider(Optional<String> id, Optional<String> loc, int loctype) { this.id = id; this.loc = loc; this.loctype = loctype; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/GameSizeSlider;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  9 */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/GameSizeSlider; } public Optional<String> id() { return this.id; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/GameSizeSlider;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/GameSizeSlider; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/GameSizeSlider;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gui/widgets/GameSizeSlider;
/*  9 */     //   0	8	1	o	Ljava/lang/Object; } public Optional<String> loc() { return this.loc; } public int loctype() { return this.loctype; } static {
/* 10 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Widgets.id(Widgets::id), (App)Widgets.loc(Widgets::loc), (App)Widgets.loctype(Widgets::loctype)).apply((Applicative)instance, GameSizeSlider::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String serializedId() {
/* 18 */     return "GameSizeSlider";
/*    */   }
/*    */ 
/*    */   
/*    */   public Integer defaultValue() {
/* 23 */     return values()[(values()).length - 1];
/*    */   }
/*    */ 
/*    */   
/*    */   public Integer[] values() {
/* 28 */     switch (Minimega.getPower()) { default: throw new MatchException(null, null);
/* 29 */       case STRONG: (new Integer[2])[0] = 
/* 30 */           Integer.valueOf(8); (new Integer[2])[1] = Integer.valueOf(16);
/*    */       case WEAK:
/* 32 */         (new Integer[2])[0] = 
/* 33 */           Integer.valueOf(4); (new Integer[2])[1] = Integer.valueOf(8);
/*    */       case VERY_WEAK:
/* 35 */         break; }  return new Integer[] {
/* 36 */         Integer.valueOf(4)
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\gui\widgets\GameSizeSlider.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */