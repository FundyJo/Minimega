/*    */ package dev.jab125.minimega.mod.util;
/*    */ 
/*    */ public class Scoped {
/*    */   public static boolean THIN_TEXT = false;
/*    */   
/*    */   public static <T extends Throwable> void runWithThinText(RunnableWithException<T> runnable) throws T {
/*  7 */     boolean prevVal = THIN_TEXT;
/*  8 */     THIN_TEXT = true;
/*  9 */     runnable.run();
/* 10 */     THIN_TEXT = prevVal;
/*    */   }
/*    */   
/*    */   public static interface RunnableWithException<T extends Throwable> {
/*    */     void run() throws T;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\Scoped.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */