/*    */ package dev.jab125.minimega.mod.mixin.chat;
/*    */ 
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import dev.jab125.minimega.mod.extension.PlayerExtension;
/*    */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.S2CPlayerInfoObj;
/*    */ import java.util.Collection;
/*    */ import java.util.Optional;
/*    */ import net.minecraft.commands.CommandSourceStack;
/*    */ import net.minecraft.network.chat.PlayerChatMessage;
/*    */ import net.minecraft.server.commands.MsgCommand;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({MsgCommand.class})
/*    */ public class MsgCommandMixin
/*    */ {
/*    */   @Inject(method = {"sendMessage"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private static void mm$sendMessage(CommandSourceStack source, Collection<ServerPlayer> players, PlayerChatMessage message, CallbackInfo ci) {
/* 22 */     if (Minimega.isMinigameServer(source.getServer())) { ServerPlayer serverPlayer = source.getPlayer(); if (serverPlayer instanceof PlayerExtension) { PlayerExtension e = (PlayerExtension)serverPlayer; if (!((Boolean)Optional.<S2CPlayerInfoObj>ofNullable(e.mm$getMatchmakingServerInfo()).map(S2CPlayerInfoObj::chatEnabled).orElse(Boolean.valueOf(true))).booleanValue()) ci.cancel();  }
/*    */        }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\chat\MsgCommandMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */