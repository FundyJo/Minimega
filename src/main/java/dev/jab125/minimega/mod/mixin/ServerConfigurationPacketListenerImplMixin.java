/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.extension.PlayerExtension;
/*    */ import dev.jab125.minimega.mod.extension.PrepareSpawnTaskExtension;
/*    */ import dev.jab125.minimega.mod.extension.ServerConfigurationPacketListenerImplExtension;
/*    */ import dev.jab125.minimega.mod.util.UnableToJoinWorldException;
/*    */ import dev.jab125.minimega.mod.util.joindata.CreateOrJoin;
/*    */ import net.minecraft.network.Connection;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.server.network.CommonListenerCookie;
/*    */ import net.minecraft.server.network.ServerConfigurationPacketListenerImpl;
/*    */ import net.minecraft.server.network.config.PrepareSpawnTask;
/*    */ import net.minecraft.server.players.NameAndId;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({ServerConfigurationPacketListenerImpl.class})
/*    */ public class ServerConfigurationPacketListenerImplMixin
/*    */   implements ServerConfigurationPacketListenerImplExtension {
/*    */   @Unique
/*    */   private CreateOrJoin minigameData;
/*    */   
/*    */   public void mm$setMinigameData(CreateOrJoin data) {
/* 29 */     this.minigameData = data;
/*    */   }
/*    */ 
/*    */   
/*    */   public CreateOrJoin mm$getMinigameData() {
/* 34 */     return this.minigameData;
/*    */   }
/*    */   
/*    */   @WrapOperation(method = {"returnToWorld"}, at = {@At(value = "NEW", target = "(Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/server/players/NameAndId;)Lnet/minecraft/server/network/config/PrepareSpawnTask;")})
/*    */   PrepareSpawnTask create(MinecraftServer minecraftServer, NameAndId nameAndId, Operation<PrepareSpawnTask> original) {
/* 39 */     PrepareSpawnTask call = (PrepareSpawnTask)original.call(new Object[] { minecraftServer, nameAndId });
/* 40 */     ((PrepareSpawnTaskExtension)call).mm$setMinigameData(this.minigameData);
/* 41 */     return call;
/*    */   }
/*    */   
/*    */   @WrapOperation(method = {"handleConfigurationFinished"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/server/network/config/PrepareSpawnTask;spawnPlayer(Lnet/minecraft/network/Connection;Lnet/minecraft/server/network/CommonListenerCookie;)Lnet/minecraft/server/level/ServerPlayer;")})
/*    */   ServerPlayer mm$handleConfigurationFinished(PrepareSpawnTask instance, Connection connection, CommonListenerCookie commonListenerCookie, Operation<ServerPlayer> original) {
/*    */     try {
/* 47 */       ((PrepareSpawnTaskExtension)instance).mm$setMinigameData(this.minigameData);
/* 48 */       ServerPlayer call = (ServerPlayer)original.call(new Object[] { instance, connection, commonListenerCookie });
/* 49 */       ((PlayerExtension)call).mm$setMinigameData(this.minigameData);
/* 50 */       return call;
/* 51 */     } catch (UnableToJoinWorldException e) {
/* 52 */       ((ServerConfigurationPacketListenerImpl)this).disconnect((Component)Component.literal(e.getMessage()));
/* 53 */       throw e;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\ServerConfigurationPacketListenerImplMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */