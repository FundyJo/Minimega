/*    */ package dev.jab125.minimega.call;
/*    */ 
/*    */ import java.util.Objects;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface ThrowableFunction<T, R, E extends Throwable>
/*    */ {
/*    */   default <V> ThrowableFunction<V, R, E> compose(ThrowableFunction<? super V, ? extends T, E> before) {
/* 11 */     Objects.requireNonNull(before);
/* 12 */     return v -> apply((T)before.apply(v));
/*    */   }
/*    */ 
/*    */   
/*    */   default <V> ThrowableFunction<T, V, E> andThen(ThrowableFunction<? super R, ? extends V, E> after) {
/* 17 */     Objects.requireNonNull(after);
/* 18 */     return t -> after.apply(apply((T)t));
/*    */   }
/*    */   static <T> ThrowableFunction<T, T, ?> identity() {
/* 21 */     return t -> t;
/*    */   }
/*    */   
/*    */   R apply(T paramT) throws E;
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\call\ThrowableFunction.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */