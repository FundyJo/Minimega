/*    */ package dev.jab125.minimega.grf;
/*    */ 
/*    */ import dev.jab125.minimega.grf.newelements.mxml.grf.__ROOT__;
/*    */ import java.util.function.Consumer;
/*    */ import java.util.function.Supplier;
/*    */ 
/*    */ public interface RootHolder
/*    */ {
/*    */   __ROOT__ getRoot();
/*    */   
/*    */   void setRoot(__ROOT__ param__ROOT__);
/*    */   
/*    */   static RootHolder of(final Supplier<__ROOT__> rootGetter, final Consumer<__ROOT__> rootSetter) {
/* 14 */     return new RootHolder()
/*    */       {
/*    */         public __ROOT__ getRoot() {
/* 17 */           return rootGetter.get();
/*    */         }
/*    */ 
/*    */         
/*    */         public void setRoot(__ROOT__ root) {
/* 22 */           rootSetter.accept(root);
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\RootHolder.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */