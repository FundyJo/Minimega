/*    */ package dev.jab125.minimega.grf.newelements.mxml.gamemode;
/*    */ 
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ 
/*    */ public final class GameMode extends Record implements IMXml, HasChildren {
/*    */   private final String version;
/*    */   private final String name;
/*    */   private final int id;
/*    */   private final List<IMXml> childRules;
/*    */   public static final Codec<GameMode> CODEC;
/*    */   
/* 12 */   public GameMode(String version, String name, int id, List<IMXml> childRules) { this.version = version; this.name = name; this.id = id; this.childRules = childRules; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/GameMode;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 12 */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/GameMode; } public String version() { return this.version; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/GameMode;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/GameMode; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/GameMode;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/GameMode;
/* 12 */     //   0	8	1	o	Ljava/lang/Object; } public String name() { return this.name; } public int id() { return this.id; } public List<IMXml> childRules() { return this.childRules; } static {
/* 13 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)LenientParsers.STRING.fieldOf("version").forGetter(GameMode::version), (App)LenientParsers.STRING.fieldOf("name").forGetter(GameMode::name), (App)LenientParsers.INT.fieldOf("id").forGetter(GameMode::id), (App)MXmlCodecs.CODEC.listOf().fieldOf("childRules").forGetter(GameMode::childRules)).apply((Applicative)instance, GameMode::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String serializedId() {
/* 22 */     return "GameMode";
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\gamemode\GameMode.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */