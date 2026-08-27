/*    */ package dev.jab125.minimega.grf.newelements.mxml;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import net.minecraft.resources.Identifier;
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
/*    */ public class Num2Str
/*    */ {
/* 37 */   private final HashMap<Integer, Identifier> map = new HashMap<>();
/*    */   
/*    */   public String getStrId(int id) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield map : Ljava/util/HashMap;
/*    */     //   4: iload_1
/*    */     //   5: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */     //   8: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
/*    */     //   11: checkcast net/minecraft/resources/Identifier
/*    */     //   14: astore_2
/*    */     //   15: iconst_0
/*    */     //   16: istore_3
/*    */     //   17: aload_2
/*    */     //   18: iload_3
/*    */     //   19: <illegal opcode> typeSwitch : (Lnet/minecraft/resources/Identifier;I)I
/*    */     //   24: lookupswitch default -> 52, -1 -> 73, 0 -> 62
/*    */     //   52: new java/lang/MatchException
/*    */     //   55: dup
/*    */     //   56: aconst_null
/*    */     //   57: aconst_null
/*    */     //   58: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*    */     //   61: athrow
/*    */     //   62: aload_2
/*    */     //   63: astore #4
/*    */     //   65: aload #4
/*    */     //   67: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   70: goto -> 74
/*    */     //   73: aconst_null
/*    */     //   74: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #39	-> 0
/*    */     //   #40	-> 62
/*    */     //   #41	-> 73
/*    */     //   #39	-> 74
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   65	8	4	identifier	Lnet/minecraft/resources/Identifier;
/*    */     //   0	75	0	this	Ldev/jab125/minimega/grf/newelements/mxml/BLest$Num2Str;
/*    */     //   0	75	1	id	I
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\BLest$Num2Str.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */