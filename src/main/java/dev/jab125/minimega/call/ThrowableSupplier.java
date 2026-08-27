/*    */ package dev.jab125.minimega.call;
/*    */ 
/*    */ import com.google.common.base.Supplier;
/*    */ 
/*    */ public interface ThrowableSupplier<T, E extends Throwable>
/*    */ {
/*    */   T get() throws Throwable;
/*    */   
/*    */   default Supplier<T> unsafeConvertToRunnable() {
/* 10 */     return () -> {
/*    */         try {
/*    */           return (Supplier)get();
/* 13 */         } catch (Throwable e) {
/*    */           throw new RuntimeException(e);
/*    */         } 
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\call\ThrowableSupplier.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */