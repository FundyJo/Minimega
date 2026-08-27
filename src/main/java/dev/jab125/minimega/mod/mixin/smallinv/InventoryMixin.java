/*    */ package dev.jab125.minimega.mod.mixin.smallinv;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import com.llamalad7.mixinextras.sugar.Local;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.minecraft.world.entity.player.Inventory;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({Inventory.class})
/*    */ public abstract class InventoryMixin {
/*    */   @Shadow
/*    */   public static boolean isHotbarSlot(int i) {
/* 19 */     return false;
/*    */   }
/*    */   
/*    */   @Shadow
/*    */   @Final
/*    */   public Player player;
/*    */   
/*    */   @WrapOperation(method = {"getFreeSlot"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isEmpty()Z")})
/*    */   boolean getFreeSlot(ItemStack instance, Operation<Boolean> original, @Local int i) {
/* 28 */     if (!MinigamesController.getMinigameController(this.player.level()).isSmallInventory())
/* 29 */       return ((Boolean)original.call(new Object[] { instance })).booleanValue(); 
/* 30 */     if (i == 40) return ((Boolean)original.call(new Object[] { instance })).booleanValue(); 
/* 31 */     if (!isHotbarSlot(i)) return false; 
/* 32 */     return ((Boolean)original.call(new Object[] { instance })).booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\smallinv\InventoryMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */