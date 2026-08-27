/*    */ package dev.jab125.minimega.mod.util.controller.event;
/*    */ public final class TimerTickEvent extends Record implements Event {
/*    */   private final Identifier timerId;
/*    */   private final int ticksRemaining;
/*    */   
/*  6 */   public TimerTickEvent(Identifier timerId, int ticksRemaining) { this.timerId = timerId; this.ticksRemaining = ticksRemaining; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/controller/event/TimerTickEvent;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #6	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  6 */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/event/TimerTickEvent; } public Identifier timerId() { return this.timerId; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/controller/event/TimerTickEvent;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #6	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/event/TimerTickEvent; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/controller/event/TimerTickEvent;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #6	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/controller/event/TimerTickEvent;
/*  6 */     //   0	8	1	o	Ljava/lang/Object; } public int ticksRemaining() { return this.ticksRemaining; }
/*  7 */    public static final Identifier LOBBY_ROUND_START_TIMER = Minimega.id("lobby_round_start_timer");
/*  8 */   public static final Identifier ROUND_START_TIMER = Minimega.id("round_start_timer");
/*  9 */   public static final Identifier GRACE_PERIOD_END_TIMER = Minimega.id("grace_period_timer");
/* 10 */   public static final Identifier MAIN_GAME_TIMER = Minimega.id("main_game_timer");
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\controller\event\TimerTickEvent.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */