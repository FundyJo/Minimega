/*    */ package dev.jab125.minimega.call;
/*    */ 
/*    */ import java.util.Optional;
/*    */ import java.util.function.Consumer;
/*    */ import java.util.function.Function;
/*    */ import java.util.function.Supplier;
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface Result<T, E extends Throwable>
/*    */ {
/*    */   static Result<Unit, ? extends Exception> error(String text) {
/* 13 */     return (Result)Error.ofText(text);
/*    */   }
/*    */   
/* 16 */   public static final Unit UNIT = new Unit();
/*    */   @SafeVarargs
/*    */   static <E extends Throwable> Result<Unit, E> wrapRun(ThrowableRunnable<? extends E> runnable, E... emptyArray) {
/*    */     try {
/* 20 */       runnable.run();
/* 21 */     } catch (Throwable e) {
/* 22 */       if (emptyArray.getClass().componentType().isInstance(e)) return new Error<>((E)e); 
/* 23 */       return sneaky(e);
/*    */     } 
/* 25 */     return ok();
/*    */   }
/*    */   public static class Unit {}
/*    */   @SafeVarargs
/*    */   static <T, E extends Throwable> Result<T, E> wrapGet(ThrowableSupplier<T, ? extends E> runnable, E... emptyArray) {
/*    */     try {
/* 31 */       return new Ok<>(runnable.get());
/* 32 */     } catch (Throwable e) {
/* 33 */       if (emptyArray.getClass().componentType().isInstance(e)) return new Error<>((E)e); 
/* 34 */       return sneaky(e);
/*    */     } 
/*    */   }
/*    */   
/*    */   private static <T extends Throwable, R> R sneaky(Throwable throwable) throws T {
/*    */     try {
/* 40 */       throw (T)throwable;
/* 41 */     } catch (Throwable e) {
/* 42 */       throw (T)e;
/*    */     } 
/*    */   }
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
/*    */   default T orElseThrow(String error) throws RuntimeException {
/* 59 */     return orElseThrowException(ex -> {
/*    */           TextException cause = new TextException(error);
/*    */           cause.addSuppressed(ex);
/*    */           return new RuntimeException(cause);
/*    */         });
/*    */   }
/*    */   
/*    */   default T orElseThrow(Supplier<String> error) throws RuntimeException {
/* 67 */     return orElseThrowException(ex -> {
/*    */           TextException cause = new TextException(error.get());
/*    */           cause.addSuppressed(ex);
/*    */           return new RuntimeException(cause);
/*    */         });
/*    */   }
/*    */   
/*    */   @Deprecated(forRemoval = true)
/*    */   default T getOrThrowTemporary() {
/* 76 */     return orElseThrow("TODO!");
/*    */   }
/*    */   
/*    */   static <E extends Throwable> Ok<Unit, E> ok() {
/* 80 */     return new Ok<>(UNIT);
/*    */   }
/*    */   
/*    */   <U> Result<U, E> map(Function<? super T, ? extends U> paramFunction);
/*    */   
/*    */   <U> Result<U, E> flatMap(Function<? super T, ? extends Result<? extends U, ? extends E>> paramFunction);
/*    */   
/*    */   Optional<T> opt();
/*    */   
/*    */   Optional<T> opt(Consumer<E> paramConsumer);
/*    */   
/*    */   T getOrThrow() throws E;
/*    */   
/*    */   <R extends Throwable> T orElseThrowException(Function<E, R> paramFunction) throws R;
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\call\Result.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */