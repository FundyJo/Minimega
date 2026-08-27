/*    */ package dev.jab125.minimega.grf.newelements.mxml.gui;
/*    */ 
/*    */ import com.mojang.datafixers.util.Pair;
/*    */ import com.mojang.serialization.DataResult;
/*    */ import com.mojang.serialization.Decoder;
/*    */ import com.mojang.serialization.Dynamic;
/*    */ import com.mojang.serialization.DynamicOps;
/*    */ import dev.jab125.minimega.grf.newelements.mxml.IMXml;
/*    */ import java.util.List;
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
/*    */   implements Decoder<Unfinished>
/*    */ {
/*    */   public <T> DataResult<Pair<Unfinished, T>> decode(DynamicOps<T> ops, T input) {
/* 25 */     return ops.get(input, "childRules").flatMap(a -> GuiCodecs.CODEC.listOf().decode(ops, a)).flatMap(a -> ops.get(input, "__$INTERNAL_ID$__").flatMap(())).map(a -> Pair.of(a, ops.empty()));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\gui\Unfinished$2.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */