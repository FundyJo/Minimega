/*    */ package dev.jab125.minimega.mod.mixin.abilities;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import java.util.Map;
/*    */ import net.minecraft.world.entity.Avatar;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EntityDimensions;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.Pose;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ 
/*    */ @Mixin({Avatar.class})
/*    */ public abstract class AvatarMixin
/*    */   extends Entity
/*    */ {
/*    */   public AvatarMixin(EntityType<?> type, Level level) {
/* 23 */     super(type, level);
/*    */   }
/*    */   
/*    */   @WrapOperation(method = {"getDefaultDimensions"}, at = {@At(value = "INVOKE", target = "Ljava/util/Map;getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;")})
/*    */   <K, V> V dajk(Map<K, V> instance, K key, V defaultValue, Operation<V> original) {
/* 28 */     return (V)dajk((Map)instance, (Pose)key, (EntityDimensions)defaultValue, (Operation)original);
/*    */   }
/*    */   
/*    */   @Unique
/*    */   EntityDimensions dajk(Map<Pose, EntityDimensions> instance, Pose key, EntityDimensions defaultValue, Operation<EntityDimensions> original) {
/* 33 */     EntityDimensions call = (EntityDimensions)original.call(new Object[] { instance, key, defaultValue });
/* 34 */     if (key == Pose.CROUCHING && (MinigamesController.getMinigameController(level()).minigameAbilities()).oldCrouch) {
/* 35 */       return call.scale(1.0F, 1.65F / call.height()).withEyeHeight(call.eyeHeight());
/*    */     }
/* 37 */     return call;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\abilities\AvatarMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */