/*    */ package dev.jab125.minimega.call;
/*    */ public final class Ok<T, E extends Throwable> extends Record implements Result<T, E> { private final T val;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/call/Ok;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/call/Ok;
/*    */     // Local variable type table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	7	0	this	Ldev/jab125/minimega/call/Ok<TT;TE;>;
/*    */   }
/*    */   
/*  8 */   public T val() { return this.val; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/call/Ok;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/call/Ok;
/*    */     // Local variable type table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	7	0	this	Ldev/jab125/minimega/call/Ok<TT;TE;>; }
/*    */   public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/call/Ok;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/call/Ok;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */     // Local variable type table:
/*    */     //   start	length	slot	name	signature
/* 10 */     //   0	8	0	this	Ldev/jab125/minimega/call/Ok<TT;TE;>; } public Ok(T val) { Objects.requireNonNull(val);
/*    */     this.val = val; }
/*    */   
/*    */   public <U> Result<U, E> map(Function<? super T, ? extends U> mapper) {
/* 14 */     Objects.requireNonNull(mapper);
/* 15 */     return new Ok((T)mapper.apply(this.val));
/*    */   }
/*    */ 
/*    */   
/*    */   public <U> Result<U, E> flatMap(Function<? super T, ? extends Result<? extends U, ? extends E>> mapper) {
/* 20 */     Objects.requireNonNull(mapper);
/* 21 */     return (Result<U, E>)mapper.apply(this.val);
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<T> opt() {
/* 26 */     Objects.requireNonNull(this.val);
/* 27 */     return Optional.of(this.val);
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<T> opt(Consumer<E> exception) {
/* 32 */     Objects.requireNonNull(this.val);
/* 33 */     return Optional.of(this.val);
/*    */   }
/*    */ 
/*    */   
/*    */   public T getOrThrow() {
/* 38 */     return this.val;
/*    */   }
/*    */ 
/*    */   
/*    */   public <R extends Throwable> T orElseThrowException(Function<E, R> exception) {
/* 43 */     return this.val;
/*    */   } }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\call\Ok.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */