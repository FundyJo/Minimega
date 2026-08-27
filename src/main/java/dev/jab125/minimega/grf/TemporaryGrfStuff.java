/*    */ package dev.jab125.minimega.grf;
/*    */ 
/*    */ import dev.jab125.minimega.grf.networking.GameRuleFilePayload;
/*    */ import java.util.Optional;
/*    */ import net.fabricmc.fabric.api.entity.event.v1.ServerEntityLevelChangeEvents;
/*    */ import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
/*    */ import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
/*    */ import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ 
/*    */ public class TemporaryGrfStuff {
/*    */   public static void sendGrfToPlayer(ServerPlayer serverPlayer) {
/* 15 */     sendGrfToPlayer(serverPlayer, serverPlayer.level());
/*    */   }
/*    */   public static void sendGrfToPlayer(ServerPlayer serverPlayer, ServerLevel level) {
/* 18 */     if (ServerPlayNetworking.canSend(serverPlayer, GameRuleFilePayload.TYPE)) {
/* 19 */       serverPlayer.connection.send(ServerPlayNetworking.createClientboundPacket((CustomPacketPayload)new GameRuleFilePayload(Optional.ofNullable(((GrfContainer)level).getGrf()))));
/*    */     }
/*    */   }
/*    */   
/*    */   public static void init() {
/* 24 */     PayloadTypeRegistry.clientboundPlay().register(GameRuleFilePayload.TYPE, GameRuleFilePayload.STREAM_CODEC);
/*    */     
/* 26 */     ServerEntityLevelChangeEvents.AFTER_PLAYER_CHANGE_LEVEL.register((player, origin, destination) -> sendGrfToPlayer(player, destination));
/*    */ 
/*    */     
/* 29 */     ServerPlayerEvents.JOIN.register(TemporaryGrfStuff::sendGrfToPlayer);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\TemporaryGrfStuff.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */