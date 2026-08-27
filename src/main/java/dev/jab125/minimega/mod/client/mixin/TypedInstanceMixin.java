/*    */ package dev.jab125.minimega.mod.client.mixin;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import java.util.stream.Stream;
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.core.TypedInstance;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.tags.TagKey;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ 
/*    */ @Mixin({TypedInstance.class})
/*    */ public interface TypedInstanceMixin<T>
/*    */ {
/*    */   @Shadow
/*    */   Holder<T> typeHolder();
/*    */   
/*    */   @WrapMethod(method = {"is(Ljava/lang/Object;)Z"})
/*    */   default boolean is(T rawType, Operation<Boolean> original) {
/* 21 */     if (typeHolder() == null) return false; 
/* 22 */     return ((Boolean)original.call(new Object[] { rawType })).booleanValue();
/*    */   }
/*    */   
/*    */   @WrapMethod(method = {"is(Lnet/minecraft/tags/TagKey;)Z"})
/*    */   default boolean is(TagKey<T> tag, Operation<Boolean> original) {
/* 27 */     if (typeHolder() == null) return false; 
/* 28 */     return ((Boolean)original.call(new Object[] { tag })).booleanValue();
/*    */   }
/*    */   
/*    */   @WrapMethod(method = {"is(Lnet/minecraft/core/Holder;)Z"})
/*    */   default boolean is(Holder<T> type, Operation<Boolean> original) {
/* 33 */     if (typeHolder() == null) return false; 
/* 34 */     return ((Boolean)original.call(new Object[] { type })).booleanValue();
/*    */   }
/*    */   
/*    */   @WrapMethod(method = {"is(Lnet/minecraft/resources/ResourceKey;)Z"})
/*    */   default boolean is(ResourceKey<T> type, Operation<Boolean> original) {
/* 39 */     if (typeHolder() == null) return false; 
/* 40 */     return ((Boolean)original.call(new Object[] { type })).booleanValue();
/*    */   }
/*    */   
/*    */   @WrapMethod(method = {"tags"})
/*    */   default Stream<TagKey<T>> tags(Operation<Stream<TagKey<T>>> original) {
/* 45 */     if (typeHolder() == null) return (Stream<TagKey<T>>)original.call(new Object[0]); 
/* 46 */     return Stream.empty();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\TypedInstanceMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */