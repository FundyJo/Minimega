/*    */ package dev.jab125.minimega.mod.util.state;
/*    */ 
/*    */ public interface State
/*    */ {
/*    */   Object fetch(String paramString);
/*    */   
/*    */   void push(Object paramObject);
/*    */   
/*    */   void execute(String paramString);
/*    */   
/*    */   boolean retrieveFinalResult() throws InvalidResultException;
/*    */   
/*    */   <T> T retrieveFinalResult(Class<T> paramClass) throws InvalidResultException;
/*    */   
/*    */   public static class InvalidResultException
/*    */     extends Exception {
/*    */     public InvalidResultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
/* 18 */       super(message, cause, enableSuppression, writableStackTrace);
/*    */     }
/*    */     
/*    */     public InvalidResultException(Throwable cause) {
/* 22 */       super(cause);
/*    */     }
/*    */     
/*    */     public InvalidResultException(String message, Throwable cause) {
/* 26 */       super(message, cause);
/*    */     }
/*    */     
/*    */     public InvalidResultException(String message) {
/* 30 */       super(message);
/*    */     }
/*    */     
/*    */     public InvalidResultException() {}
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\state\State.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */