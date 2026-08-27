/*    */ package dev.jab125.minimega.mod.mixin.smallinv;
/*    */ 
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.minecraft.world.Container;
/*    */ import net.minecraft.world.entity.player.Inventory;
/*    */ import net.minecraft.world.inventory.Slot;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({Slot.class})
/*    */ public class SlotMixin {
/*    */   @Shadow
/*    */   @Final
/*    */   public Container container;
/*    */   @Shadow
/*    */   @Final
/*    */   private int slot;
/*    */   
/*    */   @Inject(method = {"mayPlace"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void mayPlace(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
/*    */     Inventory inventory;
/* 27 */     Container container = this.container; if (container instanceof Inventory) { inventory = (Inventory)container; } else { return; }
/* 28 */      if (!MinigamesController.getMinigameController(inventory.player.level()).isSmallInventory())
/* 29 */       return;  if (Inventory.isHotbarSlot(this.slot))
/* 30 */       return;  if (this.slot == 40)
/* 31 */       return;  cir.setReturnValue(Boolean.valueOf(false));
/*    */   }
/*    */   @Inject(method = {"mayPlace"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void mayTake(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
/*    */     Inventory inventory;
/* 36 */     Container container = this.container; if (container instanceof Inventory) { inventory = (Inventory)container; } else { return; }
/* 37 */      if (!MinigamesController.getMinigameController(inventory.player.level()).isSmallInventory())
/* 38 */       return;  if (Inventory.isHotbarSlot(this.slot))
/* 39 */       return;  if (this.slot == 40)
/* 40 */       return;  cir.setReturnValue(Boolean.valueOf(false));
/*    */   }
/*    */   @Inject(method = {"isActive"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void isActive(CallbackInfoReturnable<Boolean> cir) {
/*    */     Inventory inventory;
/* 45 */     Container container = this.container; if (container instanceof Inventory) { inventory = (Inventory)container; } else { return; }
/* 46 */      if (!MinigamesController.getMinigameController(inventory.player.level()).isSmallInventory())
/* 47 */       return;  if (Inventory.isHotbarSlot(this.slot))
/* 48 */       return;  if (this.slot >= 36 && this.slot <= 39)
/* 49 */       return;  if (this.slot == 40)
/* 50 */       return;  cir.setReturnValue(Boolean.valueOf(false));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\smallinv\SlotMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */