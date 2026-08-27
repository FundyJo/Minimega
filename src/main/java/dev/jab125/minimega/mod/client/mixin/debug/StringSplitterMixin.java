/*    */ package dev.jab125.minimega.mod.client.mixin.debug;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.util.Scoped;
/*    */ import net.minecraft.client.StringSplitter;
/*    */ import net.minecraft.network.chat.Style;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({StringSplitter.class})
/*    */ public class StringSplitterMixin {
/*    */   @WrapOperation(method = {"*"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/StringSplitter$WidthProvider;getWidth(ILnet/minecraft/network/chat/Style;)F")})
/*    */   float w(StringSplitter.WidthProvider instance, int i, Style style, Operation<Float> original) {
/* 15 */     return ((Float)original.call(new Object[] { instance, Integer.valueOf(i), style })).floatValue() - (Scoped.THIN_TEXT ? 0.5F : 0.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\debug\StringSplitterMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */