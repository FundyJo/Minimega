/*   */ package dev.jab125.minimega.mod.data;public final class BattleVariants extends Record implements MapVariants { private final MapVariant small; private final MapVariant large; private final MapVariant huge;
/*   */   
/* 3 */   public BattleVariants(MapVariant small, MapVariant large, MapVariant huge) { this.small = small; this.large = large; this.huge = huge; } public final String toString() { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/data/BattleVariants;)Ljava/lang/String;
/*   */     //   6: areturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #3	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/* 3 */     //   0	7	0	this	Ldev/jab125/minimega/mod/data/BattleVariants; } public MapVariant small() { return this.small; } public final int hashCode() { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/data/BattleVariants;)I
/*   */     //   6: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #3	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	7	0	this	Ldev/jab125/minimega/mod/data/BattleVariants; } public final boolean equals(Object o) { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: aload_1
/*   */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/data/BattleVariants;Ljava/lang/Object;)Z
/*   */     //   7: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #3	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	8	0	this	Ldev/jab125/minimega/mod/data/BattleVariants;
/* 3 */     //   0	8	1	o	Ljava/lang/Object; } public MapVariant large() { return this.large; } public MapVariant huge() { return this.huge; }
/*   */    }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\data\BattleVariants.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */