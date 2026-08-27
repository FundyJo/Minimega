/*    */ package dev.jab125.minimega.mod.client.mixin.transparency;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import com.llamalad7.mixinextras.sugar.Local;
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import dev.jab125.minimega.mod.client.extension.LayerTypeExtension;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import java.util.Optional;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.model.Model;
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.client.renderer.SubmitNodeCollector;
/*    */ import net.minecraft.client.renderer.entity.layers.EquipmentLayerRenderer;
/*    */ import net.minecraft.client.renderer.entity.layers.WingsLayer;
/*    */ import net.minecraft.client.renderer.entity.state.AvatarRenderState;
/*    */ import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
/*    */ import net.minecraft.client.resources.model.EquipmentClientInfo;
/*    */ import net.minecraft.resources.Identifier;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.equipment.EquipmentAsset;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({WingsLayer.class})
/*    */ public class ElytraRendererMixin<S extends HumanoidRenderState> {
/*    */   @WrapOperation(method = {"submit(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;ILnet/minecraft/client/renderer/entity/state/HumanoidRenderState;FF)V"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/layers/EquipmentLayerRenderer;renderLayers(Lnet/minecraft/client/resources/model/EquipmentClientInfo$LayerType;Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/client/model/Model;Ljava/lang/Object;Lnet/minecraft/world/item/ItemStack;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;ILnet/minecraft/resources/Identifier;II)V")})
/*    */   void r(EquipmentLayerRenderer instance, EquipmentClientInfo.LayerType layerType, ResourceKey<EquipmentAsset> resourceKey, Model<? super S> model, Object object, ItemStack itemStack, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int i, @Nullable Identifier resourceLocation, int j, int k, Operation<Void> original, @Local(argsOnly = true) S humanoidRenderState) {
/* 33 */     ClientLevel level = (Minecraft.getInstance()).level;
/* 34 */     int id = ((Integer)Optional.<Entity>ofNullable(Minecraft.getInstance().getCameraEntity()).map(Entity::getId).orElse(Integer.valueOf(-1000))).intValue();
/* 35 */     if (level != null && MinigamesController.getMinigameController((Level)level).hideNearbyPlayers() && humanoidRenderState instanceof AvatarRenderState) { AvatarRenderState ss = (AvatarRenderState)humanoidRenderState; if (ss.id != id) {
/* 36 */         double x = ((HumanoidRenderState)humanoidRenderState).x;
/* 37 */         double y = ((HumanoidRenderState)humanoidRenderState).y;
/* 38 */         double z = ((HumanoidRenderState)humanoidRenderState).z;
/* 39 */         ((LayerTypeExtension)layerType).mm$setPos(x, y, z);
/*    */       }  }
/* 41 */      original.call(new Object[] { instance, layerType, resourceKey, model, object, itemStack, poseStack, submitNodeCollector, Integer.valueOf(i), resourceLocation, Integer.valueOf(j), Integer.valueOf(k) });
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\transparency\ElytraRendererMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */