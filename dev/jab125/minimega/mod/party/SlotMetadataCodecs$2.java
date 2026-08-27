/*    */ package dev.jab125.minimega.mod.party;
/*    */ 
/*    */ import com.mojang.datafixers.util.Pair;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.DataResult;
/*    */ import com.mojang.serialization.DynamicOps;
/*    */ import com.mojang.serialization.MapLike;
/*    */ import java.util.Map;
/*    */ import java.util.function.Function;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements Codec<T>
/*    */ {
/*    */   public <T1> DataResult<Pair<T, T1>> decode(DynamicOps<T1> ops, T1 input) {
/* 51 */     return ops.getMap(input).flatMap(mapLike -> ops.getNumberValue(mapLike.get("type")).flatMap(()));
/*    */   }
/*    */ 
/*    */   
/*    */   public <T1> DataResult<T1> encode(T input, DynamicOps<T1> ops, T1 prefix) {
/* 56 */     Integer apply = typeResolver.apply(input);
/* 57 */     return codecs[apply.intValue()].encode(input, ops, prefix).map(val -> ops.createMap(Map.of(ops.createString("type"), ops.createInt(apply.intValue()), ops.createString("value"), val)));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\party\SlotMetadataCodecs$2.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */