/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ 
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import dev.jab125.minimega.mod.util.controller.obj.MinigameRules;
/*    */ import net.minecraft.core.registries.BuiltInRegistries;
/*    */ import net.minecraft.world.InteractionResult;
/*    */ import net.minecraft.world.item.BlockItem;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.context.UseOnContext;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({ItemStack.class})
/*    */ public abstract class ItemStackMixin {
/*    */   @Shadow
/*    */   public abstract Item getItem();
/*    */   
/*    */   @Inject(method = {"useOn"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void useOn(UseOnContext useOnContext, CallbackInfoReturnable<InteractionResult> cir) {
/* 25 */     Item item = getItem();
/* 26 */     Level level = useOnContext.getLevel();
/* 27 */     MinigamesController minigameController = MinigamesController.getMinigameController(level);
/* 28 */     MinigameRules rules = minigameController.getRules();
/* 29 */     if (item instanceof BlockItem) { BlockItem blockItem = (BlockItem)item; if (rules.placePermissions().mode() == MinigameRules.Mode.WHITELIST) {
/* 30 */         cir.setReturnValue(InteractionResult.PASS); return;
/*    */       }  }
/*    */     
/* 33 */     MinigameRules.UsePermissions usePermissions = rules.usePermissions();
/* 34 */     if (usePermissions.mode() == MinigameRules.Mode.WHITELIST && !usePermissions.exceptions().contains(BuiltInRegistries.ITEM.getKey(item)))
/* 35 */       cir.setReturnValue(InteractionResult.PASS); 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\ItemStackMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */