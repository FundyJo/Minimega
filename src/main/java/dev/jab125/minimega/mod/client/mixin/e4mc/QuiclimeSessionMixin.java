/*    */ package dev.jab125.minimega.mod.client.mixin.e4mc;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import com.llamalad7.mixinextras.sugar.Local;
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import dev.jab125.minimega.mod.client.p2p.Player2Player;
/*    */ import dev.jab125.minimega.mod.extension.MinecraftServerExtension;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.server.IntegratedServer;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import org.spongepowered.asm.mixin.Dynamic;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin(targets = {"link/e4mc/QuiclimeSession$2$1"})
/*    */ public class QuiclimeSessionMixin {
/*    */   @WrapOperation(method = {"channelRead0"}, at = {@At(value = "INVOKE", target = "Llink/e4mc/Mirror;addMessage(Lnet/minecraft/network/chat/Component;)V", ordinal = 0)})
/*    */   @Dynamic
/*    */   void onCall(Component component, Operation<Void> original, @Local(name = {"domain"}) String domain) {
/* 21 */     IntegratedServer integratedServer = Minecraft.getInstance().getSingleplayerServer(); if (integratedServer instanceof IntegratedServer) { IntegratedServer server = integratedServer; if (Minimega.isMinigameServer((MinecraftServer)server) && !Player2Player.completableFuture.isDone()) {
/*    */ 
/*    */ 
/*    */         
/* 25 */         Player2Player.completableFuture.complete(Player2Player.getSuccessMessage(domain));
/* 26 */         Minecraft.getInstance().getSingleplayerServer().execute(() -> ((MinecraftServerExtension)Minecraft.getInstance().getSingleplayerServer()).mm$setMMIP(domain, 25565));
/*    */         return;
/*    */       }  }
/*    */     
/*    */     original.call(new Object[] { component });
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\e4mc\QuiclimeSessionMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */