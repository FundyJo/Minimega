/*    */ package dev.jab125.minimega.mod.client.mixin.spectator;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.client.MinimegaClient;
/*    */ import net.minecraft.client.Camera;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({Camera.class})
/*    */ public class CameraMixin
/*    */ {
/*    */   @WrapOperation(method = {"alignWithEntity"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;getViewYRot(F)F")})
/*    */   float setup(Entity instance, float f, Operation<Float> original) {
/* 17 */     return (MinimegaClient.getController().minigameAbilities()).fjs ? (Minecraft.getInstance()).player.getViewYRot(f) : ((Float)original.call(new Object[] { instance, Float.valueOf(f) })).floatValue();
/*    */   }
/*    */   
/*    */   @WrapOperation(method = {"alignWithEntity"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;getViewXRot(F)F")})
/*    */   float setup2(Entity instance, float f, Operation<Float> original) {
/* 22 */     return (MinimegaClient.getController().minigameAbilities()).fjs ? (Minecraft.getInstance()).player.getViewXRot(f) : ((Float)original.call(new Object[] { instance, Float.valueOf(f) })).floatValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\spectator\CameraMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */