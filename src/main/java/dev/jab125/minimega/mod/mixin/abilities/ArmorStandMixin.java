/*    */ package dev.jab125.minimega.mod.mixin.abilities;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.InteractionResult;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.decoration.ArmorStand;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ 
/*    */ @Mixin({ArmorStand.class})
/*    */ public abstract class ArmorStandMixin extends LivingEntity {
/*    */   protected ArmorStandMixin(EntityType<? extends LivingEntity> type, Level level) {
/* 19 */     super(type, level);
/*    */   }
/*    */   
/*    */   @WrapMethod(method = {"interact"})
/*    */   InteractionResult interact(Player player, InteractionHand hand, Vec3 location, Operation<InteractionResult> original) {
/* 24 */     if (!(MinigamesController.getMinigameController(level()).minigameAbilities()).canInteractWithArmorStands) return (InteractionResult)InteractionResult.FAIL; 
/* 25 */     return (InteractionResult)original.call(new Object[] { player, hand, location });
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\abilities\ArmorStandMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */