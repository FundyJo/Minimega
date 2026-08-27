/*    */ package dev.jab125.minimega.mod.mixin.abilities;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.damagesource.DamageSource;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.decoration.BlockAttachedEntity;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ 
/*    */ @Mixin({BlockAttachedEntity.class})
/*    */ public abstract class PaintingMixin
/*    */   extends Entity {
/*    */   public PaintingMixin(EntityType<?> type, Level level) {
/* 18 */     super(type, level);
/*    */   }
/*    */   
/*    */   @WrapMethod(method = {"hurtServer"})
/*    */   boolean fixed(ServerLevel level, DamageSource source, float damage, Operation<Boolean> original) {
/* 23 */     return ((!(source.getEntity() instanceof net.minecraft.world.entity.player.Player) || (MinigamesController.getMinigameController(level()).minigameAbilities()).canInteractWithPaintings) && ((Boolean)original.call(new Object[] { level, source, Float.valueOf(damage) })).booleanValue());
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\abilities\PaintingMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */