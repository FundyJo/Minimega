/*    */ package dev.jab125.minimega.mod.client.mixin.modernerbeta;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.client.server.IntegratedServer;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.spongepowered.asm.mixin.Dynamic;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin(value = {ClientLevel.class}, priority = 1100)
/*    */ public class ClientLevelMixin {
/*    */   @WrapOperation(method = {"@Minimega:InvInit"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/server/IntegratedServer;getLevel(Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/server/level/ServerLevel;")})
/*    */   @Dynamic
/*    */   ServerLevel init(IntegratedServer server, ResourceKey<Level> resourceKey, Operation<ServerLevel> operation) {
/* 22 */     if (Minimega.isMinigameServer((MinecraftServer)server)) {
/*    */       try {
/* 24 */         return server.getPlayerList().getPlayer((Minecraft.getInstance()).player.getUUID()).level();
/* 25 */       } catch (Throwable t) {
/* 26 */         return server.overworld();
/*    */       } 
/*    */     }
/* 29 */     return (ServerLevel)operation.call(new Object[] { server, resourceKey });
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\modernerbeta\ClientLevelMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */