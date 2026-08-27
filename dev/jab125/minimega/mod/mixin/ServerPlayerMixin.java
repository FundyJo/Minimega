/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import dev.jab125.minimega.mod.extension.PlayerExtension;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import dev.jab125.minimega.mod.util.joindata.CreateOrJoin;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.server.level.ClientInformation;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.portal.TeleportTransition;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({ServerPlayer.class})
/*    */ public abstract class ServerPlayerMixin
/*    */   implements PlayerExtension
/*    */ {
/*    */   @Shadow
/*    */   @Final
/*    */   public MinecraftServer server;
/*    */   @Unique
/*    */   private CreateOrJoin data;
/*    */   
/*    */   @Unique
/*    */   private boolean isMinigameServer() {
/* 40 */     return Minimega.isMinigameServer(this.server);
/*    */   } @Unique
/*    */   private boolean first; @Shadow
/*    */   public abstract ClientInformation clientInformation(); @Inject(method = {"isPvpAllowed"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void mm$isPvpAllowed(CallbackInfoReturnable<Boolean> cir) {
/* 45 */     ServerLevel level = ((ServerPlayer)this).level();
/* 46 */     if (level != null && !MinigamesController.getMinigameController((Level)level).pvpEnabled()) cir.setReturnValue(Boolean.valueOf(false)); 
/*    */   }
/*    */   
/*    */   @WrapOperation(method = {"createCommonSpawnInfo"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;dimension()Lnet/minecraft/resources/ResourceKey;")})
/*    */   private ResourceKey<Level> mm$createCommonSpawnInfo(ServerLevel instance, Operation<ResourceKey<Level>> original) {
/* 51 */     MinigamesController minigameController = MinigamesController.getMinigameController((Level)instance);
/* 52 */     if (minigameController.isActive()) {
/* 53 */       return ResourceKey.create(Registries.DIMENSION, minigameController.getController(minigameController.getActiveMinigame()).getCosmeticId());
/*    */     }
/* 55 */     return (ResourceKey<Level>)original.call(new Object[] { instance });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CreateOrJoin mm$getMinigameData() {
/* 64 */     CreateOrJoin data1 = this.data;
/* 65 */     this.data = null;
/* 66 */     System.out.println("RETURNING " + String.valueOf(data1));
/* 67 */     return data1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void mm$setMinigameData(CreateOrJoin data) {
/* 72 */     this.data = data;
/*    */   }
/*    */   
/*    */   @Inject(method = {"teleport(Lnet/minecraft/world/level/portal/TeleportTransition;)Lnet/minecraft/server/level/ServerPlayer;"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void teleport(TeleportTransition teleportTransition, CallbackInfoReturnable<Entity> cir) {
/* 77 */     if (MinigamesController.getMinigameController(((Entity)this).level()).isActive() && "minecraft".equals(teleportTransition.newLevel().dimension().identifier().getNamespace())) {
/* 78 */       cir.cancel();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void mm$setFirstMarker() {
/* 85 */     this.first = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean mm$firstPop() {
/* 90 */     boolean first1 = this.first;
/* 91 */     this.first = false;
/* 92 */     return first1;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\ServerPlayerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */