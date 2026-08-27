/*    */ package dev.jab125.minimega.mod.client.mixin.spectator;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.components.debug.DebugEntryPosition;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Redirect;
/*    */ 
/*    */ @Mixin({DebugEntryPosition.class})
/*    */ public class DebugEntityPositionMixin
/*    */ {
/*    */   @Redirect(method = {"display"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;getCameraEntity()Lnet/minecraft/world/entity/Entity;"))
/*    */   Entity a(Minecraft instance) {
/* 15 */     return (Entity)instance.player;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\spectator\DebugEntityPositionMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */