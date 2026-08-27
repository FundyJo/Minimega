/*    */ package dev.jab125.minimega.mod.mixin.glide;
/*    */ 
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import java.util.function.Predicate;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EntitySelector;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({EntitySelector.class})
/*    */ public class EntitySelectorMixin
/*    */ {
/*    */   @Inject(method = {"pushableBy"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private static void mm$pushableBy(Entity entity, CallbackInfoReturnable<Predicate<Entity>> cir) {
/* 19 */     Level level = entity.level();
/* 20 */     if (level == null)
/* 21 */       return;  Minigame<?> activeMinigame = MinigamesController.getMinigameController(level).getActiveMinigame();
/* 22 */     if (activeMinigame == Minigame.GLIDE) cir.setReturnValue(e -> false); 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\glide\EntitySelectorMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */