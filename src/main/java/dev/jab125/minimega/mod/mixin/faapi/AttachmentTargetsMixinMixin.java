/*    */ package dev.jab125.minimega.mod.mixin.faapi;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import com.llamalad7.mixinextras.sugar.Local;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.block.entity.BlockEntity;
/*    */ import net.minecraft.world.level.chunk.ChunkAccess;
/*    */ import org.spongepowered.asm.mixin.Dynamic;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin(value = {BlockEntity.class, Entity.class, Level.class, ChunkAccess.class}, priority = 1100)
/*    */ public class AttachmentTargetsMixinMixin
/*    */ {
/*    */   @WrapOperation(method = {"setAttached"}, at = {@At(value = "INVOKE", target = "Ljava/util/Objects;equals(Ljava/lang/Object;Ljava/lang/Object;)Z")}, remap = false)
/*    */   @Dynamic
/*    */   <T> boolean mm$setAttached(Object a, Object b, Operation<Boolean> operation, @Local(argsOnly = true) AttachmentType<T> attachmentType) {
/* 25 */     if (attachmentType == MinigamesController.ATTACHMENT_TYPE) return false; 
/* 26 */     return ((Boolean)operation.call(new Object[] { a, b })).booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\faapi\AttachmentTargetsMixinMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */