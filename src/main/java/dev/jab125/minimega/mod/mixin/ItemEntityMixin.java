/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import dev.jab125.minimega.mod.util.controller.fistfight.FistfightMinigameController;
/*    */ import net.minecraft.world.entity.item.ItemEntity;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({ItemEntity.class})
/*    */ public class ItemEntityMixin {
/*    */   @WrapOperation(method = {"tick"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/entity/item/ItemEntity;isInWater()Z")})
/*    */   boolean isInWater(ItemEntity instance, Operation<Boolean> original) {
/* 16 */     AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController(instance.level()).getController(Minigame.FISTFIGHT); if (abstractMinigameController instanceof FistfightMinigameController) { FistfightMinigameController controller = (FistfightMinigameController)abstractMinigameController; if (controller.getFistfightFlag() == 45)
/*    */       {
/* 18 */         return false;
/*    */       } }
/*    */     
/*    */     return ((Boolean)original.call(new Object[] { instance })).booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\ItemEntityMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */