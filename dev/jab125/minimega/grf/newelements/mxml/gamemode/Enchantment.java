/*    */ package dev.jab125.minimega.grf.newelements.mxml.gamemode;
/*    */ public final class Enchantment extends Record implements CanBeContainedInItem {
/*    */   private final String id;
/*    */   private final int level;
/*    */   public static final Codec<Enchantment> CODEC;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/Enchantment;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #15	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/Enchantment;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/Enchantment;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #15	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/Enchantment;
/*    */   }
/*    */   
/* 15 */   public Enchantment(String id, int level) { this.id = id; this.level = level; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/Enchantment;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #15	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/Enchantment;
/* 15 */     //   0	8	1	o	Ljava/lang/Object; } public String id() { return this.id; } public int level() { return this.level; } static {
/* 16 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)LenientParsers.STRING.fieldOf("id").forGetter(Enchantment::id), (App)LenientParsers.INT.fieldOf("level").forGetter(Enchantment::level)).apply((Applicative)instance, Enchantment::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String serializedId() {
/* 23 */     return "Enchantment";
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\gamemode\Enchantment.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */