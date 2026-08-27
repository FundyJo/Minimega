/*    */ package dev.jab125.minimega.mod.p2p.matchmaking.obj;
/*    */ 
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.datafixers.kinds.Applicative;
/*    */ import com.mojang.datafixers.util.Function3;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import java.awt.Color;
/*    */ import java.util.Optional;
/*    */ import java.util.function.Function;
/*    */ 
/*    */ public final class CosmeticColor
/*    */   extends Record
/*    */ {
/*    */   private final Color primaryColor;
/*    */   private final Optional<Color> secondaryColor;
/*    */   private final Optional<Color> tertiaryColor;
/*    */   public static final Codec<CosmeticColor> CODEC;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/S2CPlayerInfoObj$CosmeticColor;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #33	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/S2CPlayerInfoObj$CosmeticColor;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/S2CPlayerInfoObj$CosmeticColor;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #33	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/S2CPlayerInfoObj$CosmeticColor;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/S2CPlayerInfoObj$CosmeticColor;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #33	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/S2CPlayerInfoObj$CosmeticColor;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/*    */   
/*    */   public CosmeticColor(Color primaryColor, Optional<Color> secondaryColor, Optional<Color> tertiaryColor) {
/* 33 */     this.primaryColor = primaryColor; this.secondaryColor = secondaryColor; this.tertiaryColor = tertiaryColor; } public Color primaryColor() { return this.primaryColor; } public Optional<Color> secondaryColor() { return this.secondaryColor; } public Optional<Color> tertiaryColor() { return this.tertiaryColor; } static {
/* 34 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.INT.xmap(Color::new, Color::getRGB).fieldOf("primary_color").forGetter(CosmeticColor::primaryColor), (App)Codec.INT.xmap(Color::new, Color::getRGB).optionalFieldOf("secondary_color").forGetter(CosmeticColor::secondaryColor), (App)Codec.INT.xmap(Color::new, Color::getRGB).optionalFieldOf("tertiary_color").forGetter(CosmeticColor::tertiaryColor)).apply((Applicative)instance, CosmeticColor::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CosmeticColor(Color primaryColor) {
/* 41 */     this(primaryColor, Optional.empty(), Optional.empty());
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\p2p\matchmaking\obj\S2CPlayerInfoObj$CosmeticColor.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */