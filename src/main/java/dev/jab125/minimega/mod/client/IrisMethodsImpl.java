/*    */ package dev.jab125.minimega.mod.client;
/*    */ 
/*    */ import net.irisshaders.iris.Iris;
/*    */ 
/*    */ public class IrisMethodsImpl {
/*    */   public IrisMethodsImpl() {
/*  7 */     setup();
/*    */   }
/*    */   
/*    */   private void setup() {
/* 11 */     IrisMethods.areShadersOn = Iris::isPackInUseQuick;
/* 12 */     IrisMethods.getShaderName = Iris::getCurrentPackName;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\IrisMethodsImpl.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */