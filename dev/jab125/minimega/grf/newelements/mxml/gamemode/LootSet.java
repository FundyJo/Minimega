/*    */ package dev.jab125.minimega.grf.newelements.mxml.gamemode;
/*    */ 
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import dev.jab125.minimega.grf.newelements.mxml.IMXml;
/*    */ 
/*    */ public final class LootSet extends Record implements IMXml, HasChildren {
/*    */   private final String name;
/*    */   private final List<IMXml> childRules;
/*    */   public static final Codec<LootSet> CODEC;
/*    */   
/* 12 */   public LootSet(String name, List<IMXml> childRules) { this.name = name; this.childRules = childRules; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/LootSet;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 12 */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/LootSet; } public String name() { return this.name; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/LootSet;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/LootSet; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/LootSet;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/LootSet;
/* 12 */     //   0	8	1	o	Ljava/lang/Object; } public List<IMXml> childRules() { return this.childRules; } static {
/* 13 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)LenientParsers.STRING.fieldOf("name").forGetter(LootSet::name), (App)MXmlCodecs.CODEC.listOf().fieldOf("childRules").forGetter(LootSet::childRules)).apply((Applicative)instance, LootSet::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String serializedId() {
/* 20 */     return "LootSet";
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\gamemode\LootSet.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */