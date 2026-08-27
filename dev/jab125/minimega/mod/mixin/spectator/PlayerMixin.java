/*    */ package dev.jab125.minimega.mod.mixin.spectator;
/*    */ 
/*    */ import com.llamalad7.mixinextras.expression.Definition;
/*    */ import com.llamalad7.mixinextras.expression.Definitions;
/*    */ import com.llamalad7.mixinextras.expression.Expression;
/*    */ import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({Player.class})
/*    */ public abstract class PlayerMixin extends Entity {
/*    */   public PlayerMixin(EntityType<?> type, Level level) {
/* 18 */     super(type, level);
/*    */   }
/*    */ 
/*    */   
/*    */   @ModifyExpressionValue(method = {"tick"}, at = {@At("MIXINEXTRAS:EXPRESSION")})
/*    */   @Definitions({@Definition(id = "noPhysics", field = {"Lnet/minecraft/world/entity/player/Player;noPhysics:Z"}), @Definition(id = "isSpectator", method = {"Lnet/minecraft/world/entity/player/Player;isSpectator()Z"})})
/*    */   @Expression({"this.noPhysics = @(this.isSpectator())"})
/*    */   boolean tick(boolean original) {
/* 26 */     return (original && !(MinigamesController.getMinigameController(level()).minigameAbilities()).fjs);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\spectator\PlayerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */