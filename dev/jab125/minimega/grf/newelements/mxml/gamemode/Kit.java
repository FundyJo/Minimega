/*    */ package dev.jab125.minimega.grf.newelements.mxml.gamemode;
/*    */ 
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import dev.jab125.minimega.grf.newelements.mxml.IMXml;
/*    */ import java.util.Optional;
/*    */ 
/*    */ public final class Kit extends Record implements IMXml, HasChildren, HasWeight {
/*    */   private final Optional<Integer> weight;
/*    */   private final int kpScore;
/*    */   private final List<IMXml> childRules;
/*    */   public static final Codec<Kit> CODEC;
/*    */   
/* 14 */   public Kit(Optional<Integer> weight, int kpScore, List<IMXml> childRules) { this.weight = weight; this.kpScore = kpScore; this.childRules = childRules; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/Kit;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 14 */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/Kit; } public Optional<Integer> weight() { return this.weight; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/Kit;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/Kit; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/Kit;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/Kit;
/* 14 */     //   0	8	1	o	Ljava/lang/Object; } public int kpScore() { return this.kpScore; } public List<IMXml> childRules() { return this.childRules; } static {
/* 15 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)LenientParsers.INT.fieldOf("weight").xmap(Optional::of, Optional::get).forGetter(Kit::weight), (App)LenientParsers.INT.fieldOf("kpScore").forGetter(Kit::kpScore), (App)MXmlCodecs.CODEC.listOf().fieldOf("childRules").forGetter(Kit::childRules)).apply((Applicative)instance, Kit::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String serializedId() {
/* 23 */     return "Kit";
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\gamemode\Kit.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */