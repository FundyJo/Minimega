/*    */ package dev.jab125.minimega.grf.newelements.mxml.gamemode;
/*    */ 
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import dev.jab125.minimega.grf.newelements.LenientParsers;
/*    */ 
/*    */ public final class LootGroup extends Record implements IMXml, HasChildren {
/*    */   private final String name;
/*    */   private final int kpScore;
/*    */   private final String distributionMethod;
/*    */   private final List<IMXml> childRules;
/*    */   public static final Codec<LootGroup> CODEC;
/*    */   
/* 13 */   public LootGroup(String name, int kpScore, String distributionMethod, List<IMXml> childRules) { this.name = name; this.kpScore = kpScore; this.distributionMethod = distributionMethod; this.childRules = childRules; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/LootGroup;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 13 */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/LootGroup; } public String name() { return this.name; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/LootGroup;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/LootGroup; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/LootGroup;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/LootGroup;
/* 13 */     //   0	8	1	o	Ljava/lang/Object; } public int kpScore() { return this.kpScore; } public String distributionMethod() { return this.distributionMethod; } public List<IMXml> childRules() { return this.childRules; } static {
/* 14 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)LenientParsers.STRING.fieldOf("name").forGetter(LootGroup::name), (App)LenientParsers.INT.fieldOf("kpScore").forGetter(LootGroup::kpScore), (App)LenientParsers.STRING.fieldOf("distributionMethod").forGetter(LootGroup::distributionMethod), (App)MXmlCodecs.CODEC.listOf().fieldOf("childRules").forGetter(LootGroup::childRules)).apply((Applicative)instance, LootGroup::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String serializedId() {
/* 23 */     return "LootGroup";
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\gamemode\LootGroup.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */