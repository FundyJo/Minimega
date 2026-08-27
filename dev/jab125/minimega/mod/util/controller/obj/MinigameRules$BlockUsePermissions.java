/*    */ package dev.jab125.minimega.mod.util.controller.obj;
/*    */ 
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.datafixers.kinds.Applicative;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import java.util.List;
/*    */ import java.util.function.BiFunction;
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
/*    */ public final class BlockUsePermissions
/*    */   extends Record
/*    */ {
/*    */   private final MinigameRules.Mode mode;
/*    */   private final List<Identifier> exceptions;
/*    */   public static final Codec<BlockUsePermissions> CODEC;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/controller/obj/MinigameRules$BlockUsePermissions;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #56	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/obj/MinigameRules$BlockUsePermissions;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/controller/obj/MinigameRules$BlockUsePermissions;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #56	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/obj/MinigameRules$BlockUsePermissions;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/controller/obj/MinigameRules$BlockUsePermissions;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #56	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/util/controller/obj/MinigameRules$BlockUsePermissions;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/*    */   
/*    */   public BlockUsePermissions(MinigameRules.Mode mode, List<Identifier> exceptions) {
/* 56 */     this.mode = mode; this.exceptions = exceptions; } public MinigameRules.Mode mode() { return this.mode; } public List<Identifier> exceptions() { return this.exceptions; } static {
/* 57 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)MinigameRules.Mode.CODEC.fieldOf("mode").forGetter(BlockUsePermissions::mode), (App)Identifier.CODEC.listOf().optionalFieldOf("exceptions", List.of()).forGetter(BlockUsePermissions::exceptions)).apply((Applicative)instance, BlockUsePermissions::new));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\controller\obj\MinigameRules$BlockUsePermissions.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */