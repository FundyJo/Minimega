/*    */ package dev.jab125.minimega.grf;
/*    */ 
/*    */ import com.mojang.datafixers.DataFixer;
/*    */ import com.mojang.serialization.Dynamic;
/*    */ import com.mojang.serialization.DynamicOps;
/*    */ import com.mojang.serialization.JavaOps;
/*    */ import java.util.Map;
/*    */ import net.minecraft.SharedConstants;
/*    */ import net.minecraft.util.datafix.DataFixers;
/*    */ import net.minecraft.util.datafix.fixes.References;
/*    */ 
/*    */ public class ItemMapper {
/*    */   public static void main() {
/* 14 */     SharedConstants.tryDetectVersion();
/* 15 */     DataFixer dataFixer = DataFixers.getDataFixer();
/*    */     while (true) {
/* 17 */       String readln = IO.readln("Item: ");
/*    */       try {
/* 19 */         (new int[1])[0] = Integer.parseInt(readln); (new int[2])[0] = Integer.parseInt(readln.split(":")[0]); (new int[2])[1] = Integer.parseInt(readln.split(":")[1]); int[] itemId = ((readln.split(":")).length == 1) ? new int[1] : new int[2];
/* 20 */         Map<Object, Object> id1 = Map.of("id", Integer.valueOf(itemId[0]), "Damage", Integer.valueOf((itemId.length == 1) ? 0 : itemId[1]));
/* 21 */         Dynamic<Object> dynamic = new Dynamic((DynamicOps)JavaOps.INSTANCE, JavaOps.INSTANCE.createMap(id1));
/* 22 */         Dynamic<Object> update = dataFixer.update(References.ITEM_STACK, dynamic, 100, 9999);
/* 23 */         IO.println("New item: " + String.valueOf(update));
/* 24 */       } catch (NumberFormatException e) {
/* 25 */         IO.println("not a number");
/*    */       } 
/*    */     } 
/*    */   }
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
/*    */   public static <T> Dynamic<T> fixItem(Dynamic<T> in, int dfu, DataFixer dataFixer) {
/* 42 */     return dataFixer.update(References.ITEM_STACK, in, dfu, 99999);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\ItemMapper.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */