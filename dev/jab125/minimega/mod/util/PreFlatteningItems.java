/*    */ package dev.jab125.minimega.mod.util;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import org.jetbrains.annotations.ApiStatus.Internal;
/*    */ 
/*    */ public class PreFlatteningItems
/*    */ {
/*    */   @Internal
/*    */   public static JsonObject obj;
/*    */   
/*    */   public static String minecraftIdFor(int id, int damage) {
/* 13 */     JsonElement jsonElement = obj.get(String.valueOf(id));
/* 14 */     if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString())
/* 15 */       return jsonElement.getAsString(); 
/* 16 */     return jsonElement.getAsJsonObject().get(String.valueOf(damage)).getAsString();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\PreFlatteningItems.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */