/*     */ package dev.jab125.minimega.mod.client.gui.screen.minigame;
/*     */ 
/*     */ import dev.jab125.minimega.grf.newelements.mxml.gui.widgets.Widgets;
/*     */ import dev.jab125.minimega.mod.util.state.State;
/*     */ import java.util.function.Predicate;
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
/*     */ public final class ButtonData<T>
/*     */   extends Record
/*     */ {
/*     */   private final Predicate<State> statePredicate;
/*     */   private final Widgets<T> widgets;
/*     */   private final NewDataScreen.GetterAndSetter<T> getterAndSetter;
/*     */   
/*     */   public final String toString() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/client/gui/screen/minigame/NewDataScreen$ButtonData;)Ljava/lang/String;
/*     */     //   6: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #171	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	7	0	this	Ldev/jab125/minimega/mod/client/gui/screen/minigame/NewDataScreen$ButtonData;
/*     */     // Local variable type table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	7	0	this	Ldev/jab125/minimega/mod/client/gui/screen/minigame/NewDataScreen$ButtonData<TT;>;
/*     */   }
/*     */   
/*     */   public final int hashCode() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/client/gui/screen/minigame/NewDataScreen$ButtonData;)I
/*     */     //   6: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #171	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	7	0	this	Ldev/jab125/minimega/mod/client/gui/screen/minigame/NewDataScreen$ButtonData;
/*     */     // Local variable type table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	7	0	this	Ldev/jab125/minimega/mod/client/gui/screen/minigame/NewDataScreen$ButtonData<TT;>;
/*     */   }
/*     */   
/*     */   public final boolean equals(Object o) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_1
/*     */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/client/gui/screen/minigame/NewDataScreen$ButtonData;Ljava/lang/Object;)Z
/*     */     //   7: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #171	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	8	0	this	Ldev/jab125/minimega/mod/client/gui/screen/minigame/NewDataScreen$ButtonData;
/*     */     //   0	8	1	o	Ljava/lang/Object;
/*     */     // Local variable type table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	8	0	this	Ldev/jab125/minimega/mod/client/gui/screen/minigame/NewDataScreen$ButtonData<TT;>;
/*     */   }
/*     */   
/*     */   public ButtonData(Predicate<State> statePredicate, Widgets<T> widgets, NewDataScreen.GetterAndSetter<T> getterAndSetter) {
/* 171 */     this.statePredicate = statePredicate; this.widgets = widgets; this.getterAndSetter = getterAndSetter; } public Predicate<State> statePredicate() { return this.statePredicate; } public Widgets<T> widgets() { return this.widgets; } public NewDataScreen.GetterAndSetter<T> getterAndSetter() { return this.getterAndSetter; }
/*     */ 
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\screen\minigame\NewDataScreen$ButtonData.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */