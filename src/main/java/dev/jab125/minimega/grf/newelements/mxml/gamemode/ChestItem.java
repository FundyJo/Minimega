/*    */ package dev.jab125.minimega.grf.newelements.mxml.gamemode;
/*    */ 
/*    */ import java.util.Optional;
/*    */ 
/*    */ public final class ChestItem extends Record implements IMXml, HasChildren, HasWeight {
/*    */   private final Optional<Integer> minCount;
/*    */   private final Optional<Integer> maxCount;
/*    */   private final Optional<Integer> weight;
/*    */   private final Optional<Integer> kpScore;
/*    */   private final List<IMXml> childRules;
/*    */   public static final Codec<ChestItem> CODEC;
/*    */   
/* 13 */   public ChestItem(Optional<Integer> minCount, Optional<Integer> maxCount, Optional<Integer> weight, Optional<Integer> kpScore, List<IMXml> childRules) { this.minCount = minCount; this.maxCount = maxCount; this.weight = weight; this.kpScore = kpScore; this.childRules = childRules; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/ChestItem;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 13 */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/ChestItem; } public Optional<Integer> minCount() { return this.minCount; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/ChestItem;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/ChestItem; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/ChestItem;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/ChestItem;
/* 13 */     //   0	8	1	o	Ljava/lang/Object; } public Optional<Integer> maxCount() { return this.maxCount; } public Optional<Integer> weight() { return this.weight; } public Optional<Integer> kpScore() { return this.kpScore; } public List<IMXml> childRules() { return this.childRules; } static {
/* 14 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)LenientParsers.INT.optionalFieldOf("minCount").forGetter(ChestItem::minCount), (App)LenientParsers.INT.optionalFieldOf("maxCount").forGetter(ChestItem::maxCount), (App)LenientParsers.INT.optionalFieldOf("weight").forGetter(ChestItem::weight), (App)LenientParsers.INT.optionalFieldOf("kpScore").forGetter(ChestItem::kpScore), (App)MXmlCodecs.CODEC.listOf().fieldOf("childRules").forGetter(ChestItem::childRules)).apply((Applicative)instance, ChestItem::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String serializedId() {
/* 24 */     return "ChestItem";
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\gamemode\ChestItem.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */