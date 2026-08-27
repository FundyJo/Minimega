/*    */ package dev.jab125.minimega.mod.client.mixin.chat;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import dev.jab125.minimega.mod.client.MinimegaClient;
/*    */ import java.util.stream.Stream;
/*    */ import net.minecraft.client.multiplayer.chat.ChatAbilities;
/*    */ import net.minecraft.client.multiplayer.chat.ChatRestriction;
/*    */ import net.minecraft.server.permissions.Permission;
/*    */ import net.minecraft.server.permissions.PermissionSet;
/*    */ import net.minecraft.server.permissions.Permissions;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ 
/*    */ @Mixin({ChatAbilities.class})
/*    */ public class ChatAbilitiesMixin
/*    */ {
/*    */   @WrapMethod(method = {"hasAnyRestrictions"})
/*    */   boolean a(Operation<Boolean> original) {
/* 19 */     if (!MinimegaClient.inMinigameServer()) return ((Boolean)original.call(new Object[0])).booleanValue(); 
/* 20 */     if (((Boolean)original.call(new Object[0])).booleanValue()) return true; 
/* 21 */     return !MinimegaClient.hasFeatureOrDefault("can_use_chat", true);
/*    */   }
/*    */   
/*    */   @WrapMethod(method = {"canSendMessages"})
/*    */   boolean b(Operation<Boolean> original) {
/* 26 */     if (!MinimegaClient.inMinigameServer()) return ((Boolean)original.call(new Object[0])).booleanValue(); 
/* 27 */     if (!((Boolean)original.call(new Object[0])).booleanValue()) return false; 
/* 28 */     return MinimegaClient.hasFeatureOrDefault("can_use_chat", true);
/*    */   }
/*    */   
/*    */   @WrapMethod(method = {"restrictions"})
/*    */   Stream<ChatRestriction> c(Operation<Stream<ChatRestriction>> original) {
/* 33 */     if (!MinimegaClient.inMinigameServer()) return (Stream<ChatRestriction>)original.call(new Object[0]); 
/* 34 */     return MinimegaClient.hasFeatureOrDefault("can_use_chat", true) ? (Stream<ChatRestriction>)original.call(new Object[0]) : Stream.<ChatRestriction>concat((Stream<? extends ChatRestriction>)original.call(new Object[0]), Stream.of(ChatRestriction.DISABLED_BY_PROFILE));
/*    */   }
/*    */   
/*    */   @WrapMethod(method = {"permissions"})
/*    */   PermissionSet d(Operation<PermissionSet> original) {
/* 39 */     if (!MinimegaClient.inMinigameServer()) return (PermissionSet)original.call(new Object[0]); 
/* 40 */     PermissionSet call = (PermissionSet)original.call(new Object[0]);
/* 41 */     return MinimegaClient.hasFeatureOrDefault("can_use_chat", true) ? call : (d -> (d != Permissions.CHAT_SEND_MESSAGES && call.hasPermission(d)));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\chat\ChatAbilitiesMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */