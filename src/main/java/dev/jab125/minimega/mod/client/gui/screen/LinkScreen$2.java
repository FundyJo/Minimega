/*    */ package dev.jab125.minimega.mod.client.gui.screen;
/*    */ 
/*    */ import java.util.function.Consumer;
/*    */ import java.util.function.Supplier;
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
/*    */   implements LinkScreen.PayloadUtil
/*    */ {
/*    */   public String code() {
/* 56 */     return code.get();
/*    */   }
/*    */ 
/*    */   
/*    */   public void respond(String code) {
/* 61 */     newCode.accept(code);
/*    */   }
/*    */ 
/*    */   
/*    */   public void disconnect() {
/* 66 */     disconnect.run();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\screen\LinkScreen$2.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */