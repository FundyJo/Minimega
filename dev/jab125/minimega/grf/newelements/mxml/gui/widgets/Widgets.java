/*    */ package dev.jab125.minimega.grf.newelements.mxml.gui.widgets;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import dev.jab125.minimega.grf.newelements.LenientParsers;
/*    */ import dev.jab125.minimega.grf.newelements.mxml.IMXml;
/*    */ import java.util.Optional;
/*    */ import java.util.function.Function;
/*    */ 
/*    */ public interface Widgets<T> extends IMXml {
/*    */   Optional<String> id();
/*    */   
/*    */   Optional<String> loc();
/*    */   
/*    */   default String localization() {
/* 15 */     if (loc().isPresent())
/* 16 */     { if (!((String)loc().get()).isBlank()) return loc().get();  }
/* 17 */     else if (id().isPresent() && 
/* 18 */       !((String)id().get()).isBlank()) { return id().get(); }
/*    */     
/* 20 */     return "missingno";
/*    */   }
/*    */   int loctype();
/*    */   
/*    */   static <T> RecordCodecBuilder<T, Optional<String>> id(Function<T, Optional<String>> getter) {
/* 25 */     return LenientParsers.STRING.optionalFieldOf("id").forGetter(getter);
/*    */   }
/*    */   T defaultValue();
/*    */   static <T> RecordCodecBuilder<T, Optional<String>> loc(Function<T, Optional<String>> getter) {
/* 29 */     return LenientParsers.STRING.optionalFieldOf("loc").forGetter(getter);
/*    */   }
/*    */   
/*    */   static <T> RecordCodecBuilder<T, Integer> loctype(Function<T, Integer> getter) {
/* 33 */     return LenientParsers.INT.optionalFieldOf("loctype", Integer.valueOf(0)).forGetter(getter);
/*    */   }
/*    */   
/*    */   static <T, U> RecordCodecBuilder<T, U> defaultValue(Codec<U> codec, Function<T, U> getter) {
/* 37 */     return codec.fieldOf("default").forGetter(getter);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\gui\widgets\Widgets.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */