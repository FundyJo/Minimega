/*    */ package dev.jab125.minimega.call;
/*    */ 
/*    */ import java.util.function.Function;
/*    */ 
/*    */ public final class Error<T, E extends Throwable> extends Record implements Result<T, E> {
/*    */   private final E val;
/*    */   
/*  8 */   public Error(E val) { this.val = val; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/call/Error;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/call/Error;
/*    */     // Local variable type table:
/*    */     //   start	length	slot	name	signature
/*  8 */     //   0	7	0	this	Ldev/jab125/minimega/call/Error<TT;TE;>; } public E val() { return this.val; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/call/Error;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/call/Error;
/*    */     // Local variable type table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	7	0	this	Ldev/jab125/minimega/call/Error<TT;TE;>; }
/*    */   public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/call/Error;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/call/Error;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */     // Local variable type table:
/*    */     //   start	length	slot	name	signature
/* 10 */     //   0	8	0	this	Ldev/jab125/minimega/call/Error<TT;TE;>; } public static <T> Error<T, TextException> ofText(String text) { return new Error<>(new TextException(text)); }
/*    */ 
/*    */   
/*    */   public <U> Result<U, E> map(Function<? super T, ? extends U> mapper) {
/* 14 */     Objects.requireNonNull(mapper);
/* 15 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public <U> Result<U, E> flatMap(Function<? super T, ? extends Result<? extends U, ? extends E>> mapper) {
/* 20 */     Objects.requireNonNull(mapper);
/* 21 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<T> opt() {
/* 26 */     return Optional.empty();
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<T> opt(Consumer<E> exception) {
/* 31 */     exception.accept(this.val);
/* 32 */     return Optional.empty();
/*    */   }
/*    */ 
/*    */   
/*    */   public T getOrThrow() throws E {
/* 37 */     throw this.val;
/*    */   }
/*    */ 
/*    */   
/*    */   public <E1 extends Throwable> T orElseThrowException(Function<E, E1> exception) throws E1 {
/* 42 */     throw (E1)exception.apply(this.val);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\call\Error.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */