/*   */ package dev.jab125.minimega.mod.util.controller.event;
/*   */ public final class PlayerDiedEvent extends Record implements Event { private final MinigameParty.PlayerSlot playerSlot;
/*   */   private final boolean eliminated;
/*   */   
/* 5 */   public PlayerDiedEvent(MinigameParty.PlayerSlot playerSlot, boolean eliminated) { this.playerSlot = playerSlot; this.eliminated = eliminated; } public final String toString() { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/controller/event/PlayerDiedEvent;)Ljava/lang/String;
/*   */     //   6: areturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #5	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/* 5 */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/event/PlayerDiedEvent; } public MinigameParty.PlayerSlot playerSlot() { return this.playerSlot; } public final int hashCode() { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/controller/event/PlayerDiedEvent;)I
/*   */     //   6: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #5	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/event/PlayerDiedEvent; } public final boolean equals(Object o) { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: aload_1
/*   */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/controller/event/PlayerDiedEvent;Ljava/lang/Object;)Z
/*   */     //   7: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #5	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/controller/event/PlayerDiedEvent;
/* 5 */     //   0	8	1	o	Ljava/lang/Object; } public boolean eliminated() { return this.eliminated; }
/*   */    }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\controller\event\PlayerDiedEvent.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */