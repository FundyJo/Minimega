/*    */ package dev.jab125.minimega.mod.client.mixin.transparency;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import com.llamalad7.mixinextras.sugar.Local;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import java.util.Optional;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.model.EntityModel;
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.client.renderer.entity.LivingEntityRenderer;
/*    */ import net.minecraft.client.renderer.entity.state.AvatarRenderState;
/*    */ import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
/*    */ import net.minecraft.client.renderer.rendertype.RenderType;
/*    */ import net.minecraft.client.renderer.rendertype.RenderTypes;
/*    */ import net.minecraft.resources.Identifier;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({LivingEntityRenderer.class})
/*    */ public abstract class LivingEntityRendererMixin<T extends LivingEntity, S extends LivingEntityRenderState, M extends EntityModel<? super S>> {
/*    */   @Shadow
/*    */   public abstract Identifier getTextureLocation(S paramS);
/*    */   
/*    */   @WrapOperation(method = {"Lnet/minecraft/client/renderer/entity/LivingEntityRenderer;submit(Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;Lnet/minecraft/client/renderer/state/level/CameraRenderState;)V"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/LivingEntityRenderer;getRenderType(Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;ZZZ)Lnet/minecraft/client/renderer/rendertype/RenderType;")})
/*    */   private RenderType mm$renderToBuffon(LivingEntityRenderer<T, S, M> instance, S livingEntityRenderState, boolean bl, boolean bl2, boolean bl3, Operation<RenderType> original) {
/* 33 */     ClientLevel level = (Minecraft.getInstance()).level;
/* 34 */     if (level != null && MinigamesController.getMinigameController((Level)level).hideNearbyPlayers()) {
/* 35 */       return RenderTypes.entityTranslucentCullItemTarget(getTextureLocation(livingEntityRenderState));
/*    */     }
/* 37 */     return (RenderType)original.call(new Object[] { instance, livingEntityRenderState, Boolean.valueOf(bl), Boolean.valueOf(bl2), Boolean.valueOf(bl3) });
/*    */   }
/*    */   
/*    */   @WrapOperation(method = {"Lnet/minecraft/client/renderer/entity/LivingEntityRenderer;submit(Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;Lnet/minecraft/client/renderer/state/level/CameraRenderState;)V"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/util/ARGB;multiply(II)I")})
/*    */   private int mm$renderToBuffon2(int i, int j, Operation<Integer> original, @Local(argsOnly = true) S s) {
/* 42 */     ClientLevel level = (Minecraft.getInstance()).level;
/* 43 */     int id = ((Integer)Optional.<Entity>ofNullable(Minecraft.getInstance().getCameraEntity()).map(Entity::getId).orElse(Integer.valueOf(-1000))).intValue();
/* 44 */     if (level != null && MinigamesController.getMinigameController((Level)level).hideNearbyPlayers() && s instanceof AvatarRenderState) { AvatarRenderState ss = (AvatarRenderState)s; if (ss.id != id) {
/* 45 */         Vec3 cameraPos = (Minecraft.getInstance()).gameRenderer.getMainCamera().position();
/* 46 */         LivingEntityRenderer<T, S, M> renderer = (LivingEntityRenderer<T, S, M>)this;
/* 47 */         double x = ((LivingEntityRenderState)s).x;
/* 48 */         double y = ((LivingEntityRenderState)s).y;
/* 49 */         double z = ((LivingEntityRenderState)s).z;
/* 50 */         double v = cameraPos.distanceToSqr(x, y, z);
/* 51 */         int v1 = (int)Mth.clampedMap(v, 5.0D, 25.0D, 0.0D, 255.0D);
/* 52 */         return ((Integer)original.call(new Object[] { Integer.valueOf(16777215 + (v1 << 24)), Integer.valueOf(j) })).intValue();
/*    */       }  }
/* 54 */      return ((Integer)original.call(new Object[] { Integer.valueOf(i), Integer.valueOf(j) })).intValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\transparency\LivingEntityRendererMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */