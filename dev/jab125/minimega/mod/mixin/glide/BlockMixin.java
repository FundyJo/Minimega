/*    */ package dev.jab125.minimega.mod.mixin.glide;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import net.minecraft.core.DefaultedRegistry;
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({Block.class})
/*    */ public class BlockMixin
/*    */ {
/*    */   @WrapOperation(method = {"<init>"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/core/DefaultedRegistry;createIntrusiveHolder(Ljava/lang/Object;)Lnet/minecraft/core/Holder$Reference;")})
/*    */   Holder.Reference ini(DefaultedRegistry instance, Object object, Operation<Holder.Reference> original) {
/* 16 */     if (object instanceof dev.jab125.minimega.mod.block.UnregisteredBlock)
/*    */     {
/* 18 */       return null;
/*    */     }
/*    */ 
/*    */     
/* 22 */     return (Holder.Reference)original.call(new Object[] { instance, object });
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\glide\BlockMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */