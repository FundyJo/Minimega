/*   */ package dev.jab125.minimega.mod.data;public final class MapData extends Record { private final MapInfo mapInfo; private final MapVariants mapFile;
/*   */   
/* 3 */   public MapData(MapInfo mapInfo, MapVariants mapFile) { this.mapInfo = mapInfo; this.mapFile = mapFile; } public final String toString() { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/data/MapData;)Ljava/lang/String;
/*   */     //   6: areturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #3	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/* 3 */     //   0	7	0	this	Ldev/jab125/minimega/mod/data/MapData; } public MapInfo mapInfo() { return this.mapInfo; } public final int hashCode() { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/data/MapData;)I
/*   */     //   6: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #3	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	7	0	this	Ldev/jab125/minimega/mod/data/MapData; } public final boolean equals(Object o) { // Byte code:
/*   */     //   0: aload_0
/*   */     //   1: aload_1
/*   */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/data/MapData;Ljava/lang/Object;)Z
/*   */     //   7: ireturn
/*   */     // Line number table:
/*   */     //   Java source line number -> byte code offset
/*   */     //   #3	-> 0
/*   */     // Local variable table:
/*   */     //   start	length	slot	name	descriptor
/*   */     //   0	8	0	this	Ldev/jab125/minimega/mod/data/MapData;
/* 3 */     //   0	8	1	o	Ljava/lang/Object; } public MapVariants mapFile() { return this.mapFile; }
/*   */    }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\data\MapData.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */