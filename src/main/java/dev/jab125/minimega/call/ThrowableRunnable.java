/*   */ package dev.jab125.minimega.call;
/*   */ 
/*   */ public interface ThrowableRunnable<E extends Throwable>
/*   */ {
/*   */   void run() throws E;
/*   */   
/*   */   default Runnable unsafeConvertToRunnable() {
/* 8 */     return () -> {
/*   */         try {
/*   */           run();
/* ; */         } catch (Throwable e) {
/*   */           throw new RuntimeException(e);
/*   */         } 
/*   */       };
/*   */   }
/*   */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\call\ThrowableRunnable.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */