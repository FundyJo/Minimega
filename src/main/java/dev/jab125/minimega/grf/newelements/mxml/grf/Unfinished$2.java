/*    */ package dev.jab125.minimega.grf.newelements.mxml.grf;
/*    */ 
/*    */ import com.mojang.datafixers.util.Pair;
/*    */ import com.mojang.serialization.DataResult;
/*    */ import com.mojang.serialization.Decoder;
/*    */ import com.mojang.serialization.Dynamic;
/*    */ import com.mojang.serialization.DynamicOps;
/*    */ import dev.jab125.minimega.grf.newelements.mxml.IMXml;
/*    */ import java.util.List;
/*    */ import java.util.Objects;
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
/*    */ class null
/*    */   implements Decoder<Unfinished>
/*    */ {
/*    */   public <T> DataResult<Pair<Unfinished, T>> decode(DynamicOps<T> ops, T input) {
/* 25 */     return ops.get(input, "childRules").flatMap(a -> GrfCodecs.CODEC.listOf().decode(ops, a)).map(a -> Pair.of(a, ops.get(input, "__$INTERNAL_ID$__"))).map(a -> a.mapSecond(())).map(q -> q.mapSecond(())).flatMap(a -> ((DataResult)a.getSecond()).map(()));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\grf\Unfinished$2.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */