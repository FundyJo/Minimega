/*    */ package dev.jab125.minimega.mod.util.controller;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.function.BiConsumer;
/*    */ import java.util.function.Function;
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.network.codec.StreamCodec;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Patcher<T>
/*    */   extends Record
/*    */ {
/*    */   private final Supplier<StreamCodec<ByteBuf, T>> streamCodec;
/*    */   private final BiConsumer<MinigameAbilities, T> setter;
/*    */   private final Function<MinigameAbilities, T> getter;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/controller/MinigameAbilities$Patcher;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #86	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/MinigameAbilities$Patcher;
/*    */     // Local variable type table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/MinigameAbilities$Patcher<TT;>;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/controller/MinigameAbilities$Patcher;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #86	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/MinigameAbilities$Patcher;
/*    */     // Local variable type table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/MinigameAbilities$Patcher<TT;>;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/controller/MinigameAbilities$Patcher;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #86	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/controller/MinigameAbilities$Patcher;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */     // Local variable type table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/controller/MinigameAbilities$Patcher<TT;>;
/*    */   }
/*    */   
/*    */   public Patcher(Supplier<StreamCodec<ByteBuf, T>> streamCodec, BiConsumer<MinigameAbilities, T> setter, Function<MinigameAbilities, T> getter) {
/* 86 */     this.streamCodec = streamCodec; this.setter = setter; this.getter = getter; } public Supplier<StreamCodec<ByteBuf, T>> streamCodec() { return this.streamCodec; } public BiConsumer<MinigameAbilities, T> setter() { return this.setter; } public Function<MinigameAbilities, T> getter() { return this.getter; }
/*    */    public Patcher(StreamCodec<ByteBuf, T> streamCodec, BiConsumer<MinigameAbilities, T> setter, Function<MinigameAbilities, T> getter) {
/* 88 */     this(() -> streamCodec, setter, getter);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\controller\MinigameAbilities$Patcher.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */