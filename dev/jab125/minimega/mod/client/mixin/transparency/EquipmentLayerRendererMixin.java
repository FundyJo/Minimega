/*    */ package dev.jab125.minimega.mod.client.mixin.transparency;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import com.llamalad7.mixinextras.sugar.Local;
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import dev.jab125.minimega.mod.client.extension.LayerTypeExtension;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.model.Model;
/*    */ import net.minecraft.client.renderer.OrderedSubmitNodeCollector;
/*    */ import net.minecraft.client.renderer.entity.layers.EquipmentLayerRenderer;
/*    */ import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
/*    */ import net.minecraft.client.renderer.rendertype.RenderType;
/*    */ import net.minecraft.client.renderer.rendertype.RenderTypes;
/*    */ import net.minecraft.client.renderer.texture.TextureAtlasSprite;
/*    */ import net.minecraft.client.resources.model.EquipmentClientInfo;
/*    */ import net.minecraft.resources.Identifier;
/*    */ import net.minecraft.util.Mth;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({EquipmentLayerRenderer.class})
/*    */ public class EquipmentLayerRendererMixin {
/*    */   @WrapOperation(method = {"renderLayers(Lnet/minecraft/client/resources/model/EquipmentClientInfo$LayerType;Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/client/model/Model;Ljava/lang/Object;Lnet/minecraft/world/item/ItemStack;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;ILnet/minecraft/resources/Identifier;II)V"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/rendertype/RenderTypes;armorCutoutNoCull(Lnet/minecraft/resources/Identifier;)Lnet/minecraft/client/renderer/rendertype/RenderType;")})
/*    */   RenderType lol(Identifier resourceLocation, Operation<RenderType> original, @Local(argsOnly = true) EquipmentClientInfo.LayerType type) {
/* 27 */     if (((LayerTypeExtension)type).mm$getPos0() == null) return (RenderType)original.call(new Object[] { resourceLocation }); 
/* 28 */     return RenderTypes.entityTranslucent(resourceLocation);
/*    */   }
/*    */   
/*    */   @WrapOperation(method = {"renderLayers(Lnet/minecraft/client/resources/model/EquipmentClientInfo$LayerType;Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/client/model/Model;Ljava/lang/Object;Lnet/minecraft/world/item/ItemStack;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;ILnet/minecraft/resources/Identifier;II)V"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/OrderedSubmitNodeCollector;submitModel(Lnet/minecraft/client/model/Model;Ljava/lang/Object;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/rendertype/RenderType;IIILnet/minecraft/client/renderer/texture/TextureAtlasSprite;ILnet/minecraft/client/renderer/feature/ModelFeatureRenderer$CrumblingOverlay;)V")})
/*    */   void r(OrderedSubmitNodeCollector instance, Model model, Object s, PoseStack poseStack, RenderType renderType, int i, int j, int k, @Nullable TextureAtlasSprite textureAtlasSprite, int l, @Nullable ModelFeatureRenderer.CrumblingOverlay crumblingOverlay, Operation<Void> original, @Local(argsOnly = true) EquipmentClientInfo.LayerType type) {
/* 33 */     EquipmentLayerRenderer equipmentLayerRenderer = (EquipmentLayerRenderer)this;
/* 34 */     double[] doubles = ((LayerTypeExtension)type).mm$getPos();
/* 35 */     if (doubles == null) {
/* 36 */       original.call(new Object[] { instance, model, s, poseStack, renderType, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), textureAtlasSprite, Integer.valueOf(l), crumblingOverlay });
/*    */ 
/*    */ 
/*    */       
/*    */       return;
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 45 */     int v1 = (int)Mth.clampedMap((Minecraft.getInstance()).gameRenderer.getMainCamera().position().distanceToSqr(doubles[0], doubles[1], doubles[2]), 5.0D, 25.0D, 0.0D, 255.0D);
/* 46 */     original.call(new Object[] { instance, model, s, poseStack, renderType, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(v1 << 24 | k & 0xFFFFFF), textureAtlasSprite, Integer.valueOf(l), crumblingOverlay });
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\transparency\EquipmentLayerRendererMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */