/*    */ package dev.jab125.minimega.mod.mixin.abilities;
/*    */ import com.llamalad7.mixinextras.expression.Definition;
/*    */ import com.llamalad7.mixinextras.expression.Definitions;
/*    */ import com.llamalad7.mixinextras.expression.Expression;
/*    */ import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
/*    */ import com.llamalad7.mixinextras.sugar.Local;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.decoration.HangingEntity;
/*    */ import net.minecraft.world.entity.decoration.ItemFrame;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({ItemFrame.class})
/*    */ public abstract class ItemFrameMixin extends HangingEntity {
/*    */   protected ItemFrameMixin(EntityType<? extends HangingEntity> type, Level level) {
/* 19 */     super(type, level);
/*    */   }
/*    */ 
/*    */   
/*    */   @ModifyExpressionValue(method = {"interact"}, at = {@At("MIXINEXTRAS:EXPRESSION")})
/*    */   @Definitions({@Definition(id = "itemStack", local = {@Local(type = ItemStack.class, name = {"itemStack"})}), @Definition(id = "isEmpty", method = {"Lnet/minecraft/world/item/ItemStack;isEmpty()Z"})})
/*    */   @Expression({"itemStack.isEmpty()"})
/*    */   boolean a(boolean original) {
/* 27 */     return (original || !(MinigamesController.getMinigameController(level()).minigameAbilities()).canTakeItemsOutOfItemFrames);
/*    */   }
/*    */   
/*    */   @ModifyExpressionValue(method = {"hurtServer"}, at = {@At("MIXINEXTRAS:EXPRESSION")})
/*    */   @Definition(id = "fixed", field = {"Lnet/minecraft/world/entity/decoration/ItemFrame;fixed:Z"})
/*    */   @Expression({"this.fixed"})
/*    */   boolean fixed(boolean original) {
/* 34 */     return (original || !(MinigamesController.getMinigameController(level()).minigameAbilities()).canTakeItemsOutOfItemFrames);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\abilities\ItemFrameMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */