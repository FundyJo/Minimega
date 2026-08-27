/*    */ package dev.jab125.minimega.mod.p2p.matchmaking.obj;
/*    */ 
/*    */ import java.awt.Color;
/*    */ 
/*    */ public final class S2CPlayerInfoObj extends Record implements CodecObj<S2CPlayerInfoObj> {
/*    */   private final UUID uuid;
/*    */   private final Optional<CosmeticColor> displayColor;
/*    */   private final boolean chatEnabled;
/*    */   private static final Codec<UUID> STRING_CODEC;
/*    */   public static final Codec<S2CPlayerInfoObj> CODEC;
/*    */   
/* 12 */   public S2CPlayerInfoObj(UUID uuid, Optional<CosmeticColor> displayColor, boolean chatEnabled) { this.uuid = uuid; this.displayColor = displayColor; this.chatEnabled = chatEnabled; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/S2CPlayerInfoObj;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 12 */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/S2CPlayerInfoObj; } public UUID uuid() { return this.uuid; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/S2CPlayerInfoObj;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/S2CPlayerInfoObj; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/S2CPlayerInfoObj;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/S2CPlayerInfoObj;
/* 12 */     //   0	8	1	o	Ljava/lang/Object; } public Optional<CosmeticColor> displayColor() { return this.displayColor; } public boolean chatEnabled() { return this.chatEnabled; } static {
/* 13 */     STRING_CODEC = Codec.STRING.comapFlatMap(string -> {
/*    */           try {
/*    */             return DataResult.success(UUID.fromString(string), Lifecycle.stable());
/* 16 */           } catch (IllegalArgumentException var2) {
/*    */             return DataResult.error(());
/*    */           } 
/*    */         }UUID::toString);
/*    */     
/* 21 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)STRING_CODEC.fieldOf("uuid").forGetter(S2CPlayerInfoObj::uuid), (App)CosmeticColor.CODEC.optionalFieldOf("display_color").forGetter(S2CPlayerInfoObj::displayColor), (App)Codec.BOOL.fieldOf("chat_enabled").forGetter(S2CPlayerInfoObj::chatEnabled)).apply((Applicative)instance, S2CPlayerInfoObj::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Codec<S2CPlayerInfoObj> codec() {
/* 29 */     return CODEC;
/*    */   }
/*    */   public static final class CosmeticColor extends Record { private final Color primaryColor; private final Optional<Color> secondaryColor; private final Optional<Color> tertiaryColor; public static final Codec<CosmeticColor> CODEC;
/*    */     
/* 33 */     public CosmeticColor(Color primaryColor, Optional<Color> secondaryColor, Optional<Color> tertiaryColor) { this.primaryColor = primaryColor; this.secondaryColor = secondaryColor; this.tertiaryColor = tertiaryColor; } public final String toString() { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/S2CPlayerInfoObj$CosmeticColor;)Ljava/lang/String;
/*    */       //   6: areturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #33	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/S2CPlayerInfoObj$CosmeticColor; } public final int hashCode() { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/S2CPlayerInfoObj$CosmeticColor;)I
/*    */       //   6: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #33	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/S2CPlayerInfoObj$CosmeticColor; } public final boolean equals(Object o) { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: aload_1
/*    */       //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/S2CPlayerInfoObj$CosmeticColor;Ljava/lang/Object;)Z
/*    */       //   7: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #33	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	8	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/S2CPlayerInfoObj$CosmeticColor;
/* 33 */       //   0	8	1	o	Ljava/lang/Object; } public Color primaryColor() { return this.primaryColor; } public Optional<Color> secondaryColor() { return this.secondaryColor; } public Optional<Color> tertiaryColor() { return this.tertiaryColor; } static {
/* 34 */       CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.INT.xmap(Color::new, Color::getRGB).fieldOf("primary_color").forGetter(CosmeticColor::primaryColor), (App)Codec.INT.xmap(Color::new, Color::getRGB).optionalFieldOf("secondary_color").forGetter(CosmeticColor::secondaryColor), (App)Codec.INT.xmap(Color::new, Color::getRGB).optionalFieldOf("tertiary_color").forGetter(CosmeticColor::tertiaryColor)).apply((Applicative)instance, CosmeticColor::new));
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public CosmeticColor(Color primaryColor) {
/* 41 */       this(primaryColor, Optional.empty(), Optional.empty());
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\p2p\matchmaking\obj\S2CPlayerInfoObj.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */