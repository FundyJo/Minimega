/*    */ package dev.jab125.minimega.mod.client.mixin.nametag;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.minecraft.client.renderer.entity.LivingEntityRenderer;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ 
/*    */ @Mixin({LivingEntityRenderer.class})
/*    */ public class LivingEntityRendererMixin
/*    */ {
/*    */   @WrapMethod(method = {"shouldShowName(Lnet/minecraft/world/entity/LivingEntity;D)Z"})
/*    */   <T extends net.minecraft.world.entity.LivingEntity> boolean render(T entity, double distanceToCameraSq, Operation<Boolean> original) {
/* 14 */     if (entity != null && entity.level() != null && !MinigamesController.getMinigameController(entity.level()).getRules().showNametags()) return false; 
/* 15 */     return ((Boolean)original.call(new Object[] { entity, Double.valueOf(distanceToCameraSq) })).booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\nametag\LivingEntityRendererMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */