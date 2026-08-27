/*    */ package dev.jab125.minimega.mod.client;
/*    */ 
/*    */ import dev.isxander.controlify.Controlify;
/*    */ 
/*    */ public class ControlifyMethodsImpl {
/*    */   public ControlifyMethodsImpl() {
/*  7 */     setup();
/*    */   }
/*    */   
/*    */   private void setup() {
/* 11 */     ControlifyMethods.isControlifyHandled = (() -> Controlify.instance().currentInputMode().isController());
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\ControlifyMethodsImpl.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */