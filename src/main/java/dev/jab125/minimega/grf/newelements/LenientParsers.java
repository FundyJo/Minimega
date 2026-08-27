/*    */ package dev.jab125.minimega.grf.newelements;
/*    */ 
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.datafixers.kinds.Applicative;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import dev.jab125.minimega.grf.newelements.mxml.grf.ScoreRingSize;
/*    */ import dev.jab125.minimega.grf.newelements.mxml.grf.SpeedDirection;
/*    */ import java.util.List;
/*    */ import java.util.Locale;
/*    */ import net.minecraft.core.Direction;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LenientParsers
/*    */ {
/* 25 */   public static final Codec<Integer> INT = Codec.STRING.xmap(LenientParsers::parseInt, Object::toString);
/* 26 */   public static final Codec<Double> DOUBLE = Codec.STRING.xmap(Double::parseDouble, Object::toString);
/* 27 */   public static final Codec<Float> FLOAT = DOUBLE.xmap(Double::floatValue, Float::doubleValue);
/* 28 */   public static final Codec<Boolean> BOOL = Codec.STRING.xmap(Boolean::parseBoolean, Object::toString);
/* 29 */   public static final Codec<String> STRING = (Codec<String>)Codec.STRING;
/* 30 */   public static final Codec<Direction> DIRECTION = Codec.STRING.xmap(LenientParsers::parseDirection, LenientParsers::unparseDirection);
/* 31 */   public static final Codec<Direction.Axis> AXIS = Codec.STRING.xmap(Direction.Axis::byName, Direction.Axis::getSerializedName); public static final Codec<ScoreRingSize> SIZE; static {
/* 32 */     SIZE = Codec.STRING.xmap(size -> ScoreRingSize.valueOf(size.toUpperCase(Locale.ROOT)), Enum::name);
/* 33 */   } public static final Codec<SpeedDirection> SPEED_DIRECTION = Codec.STRING.xmap(LenientParsers::decode, LenientParsers::undecode); public static final Codec<String> CHILD_STRING;
/*    */   
/*    */   static {
/* 36 */     CHILD_STRING = RecordCodecBuilder.create(instance -> instance.group((App)STRING.fieldOf("content").forGetter(())).apply((Applicative)instance, ())).listOf().xmap(List::getFirst, List::of);
/*    */   } public static int parseInt(String str) {
/* 38 */     if (str.endsWith(".0")) str = str.substring(0, str.length() - 2); 
/* 39 */     if (str.endsWith(".5")) {
/* 40 */       return (int)Math.floor(Double.parseDouble(str));
/*    */     }
/* 42 */     return Integer.parseInt(str);
/*    */   }
/*    */   
/*    */   private static Direction parseDirection(String direction) {
/* 46 */     switch (direction) { case "plus_y": 
/*    */       case "minus_y": 
/*    */       case "plus_x": 
/*    */       case "minus_x": 
/*    */       case "plus_z":
/*    */       
/*    */       case "minus_z":
/* 53 */        }  throw new IllegalStateException("Unexpected value: " + direction);
/*    */   }
/*    */ 
/*    */   
/*    */   private static String unparseDirection(Direction direction) {
/* 58 */     switch (direction) { default: throw new MatchException(null, null);case EAST: case WEST: case SOUTH: case NORTH: case OMNI_EAST: case OMNI_WEST: break; }  return 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 64 */       "minus_z";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static SpeedDirection decode(String boostDirection) {
/* 70 */     switch (boostDirection) { case "plus_x": 
/*    */       case "minus_x": 
/*    */       case "plus_z": 
/*    */       case "minus_z": 
/*    */       case "omni_plus_x": 
/*    */       case "omni_minus_x": 
/*    */       case "omni_plus_z": 
/*    */       case "omni_minus_z": 
/*    */       case "_static":
/*    */       
/*    */       case "_natural":
/* 81 */        }  throw new IllegalStateException("Unexpected value: " + boostDirection);
/*    */   }
/*    */ 
/*    */   
/*    */   private static String undecode(SpeedDirection boostDirection) {
/* 86 */     switch (boostDirection) { default: throw new MatchException(null, null);case EAST: case WEST: case SOUTH: case NORTH: case OMNI_EAST: case OMNI_WEST: case OMNI_SOUTH: case OMNI_NORTH: case STATIC: case NATURAL: break; }  return 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 96 */       "_natural";
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\LenientParsers.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */