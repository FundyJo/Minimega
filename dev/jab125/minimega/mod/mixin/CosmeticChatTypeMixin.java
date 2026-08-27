/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import dev.jab125.minimega.mod.extension.PlayerExtension;
/*    */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.S2CPlayerInfoObj;
/*    */ import dev.jab125.minimega.mod.util.ColorUtil;
/*    */ import java.awt.Color;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Optional;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.ChatFormatting;
/*    */ import net.minecraft.commands.CommandSourceStack;
/*    */ import net.minecraft.network.chat.ChatType;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.network.chat.MutableComponent;
/*    */ import net.minecraft.network.chat.Style;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({ChatType.class})
/*    */ public class CosmeticChatTypeMixin {
/*    */   @WrapOperation(method = {"bind(Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/world/entity/Entity;)Lnet/minecraft/network/chat/ChatType$Bound;"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;getDisplayName()Lnet/minecraft/network/chat/Component;")})
/*    */   private static Component b(Entity instance, Operation<Component> original) {
/* 32 */     Component call = (Component)original.call(new Object[] { instance });
/* 33 */     if (instance != null) { Level level = instance.level(); if (level instanceof Level) { Level level1 = level; MinecraftServer minecraftServer = level1.getServer(); if (minecraftServer instanceof MinecraftServer) { MinecraftServer server = minecraftServer; if (Minimega.isMinigameServer(server))
/* 34 */           { if (call == null) return call; 
/* 35 */             if (instance instanceof Player) { Player player = (Player)instance;
/* 36 */               PlayerExtension player1 = (PlayerExtension)player;
/* 37 */               Optional<S2CPlayerInfoObj.CosmeticColor> cosmeticColor = Optional.<S2CPlayerInfoObj>ofNullable(player1.mm$getMatchmakingServerInfo()).flatMap(S2CPlayerInfoObj::displayColor);
/* 38 */               MutableComponent newComponent = null;
/* 39 */               if (UUID.fromString("2fdb9174-c6d7-4842-8172-7d009a30fe6a").equals(player.getUUID())) {
/* 40 */                 newComponent = call.copy().withColor(13076540);
/*    */               }
/* 42 */               if (cosmeticColor.isPresent())
/*    */               {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */                 
/* 52 */                 newComponent = call.copy().visit((style, string) -> { List<Integer> list = string.codePoints().boxed().toList(); MutableComponent component = Component.empty(); int j = 0; Iterator<Integer> i$ = list.iterator(); while (i$.hasNext()) { int i = ((Integer)i$.next()).intValue(); component.append((Component)Component.literal(Character.toString(i)).withStyle(style).withColor(color(cosmeticColor.get(), j / list.size()).getRGB())); j++; }  return Optional.of(component); }Style.EMPTY).orElseThrow();
/*    */               }
/*    */               
/* 55 */               if (server.isSingleplayerOwner(player.nameAndId())) {
/* 56 */                 newComponent = Component.empty().append((Component)Component.literal("👑 ").withStyle(ChatFormatting.GOLD)).append((newComponent == null) ? (Component)call.copy() : (Component)newComponent);
/*    */               }
/* 58 */               if (newComponent != null) return (Component)newComponent;  }
/*    */             
/* 60 */             return call; }  }  }
/*    */        }
/* 62 */      return call;
/*    */   }
/*    */   
/*    */   @Unique
/*    */   private static Color color(S2CPlayerInfoObj.CosmeticColor color, float progress) {
/* 67 */     if (color.secondaryColor().isEmpty()) return color.primaryColor(); 
/* 68 */     return ColorUtil.lerpGamma(color.primaryColor(), color.secondaryColor().get(), progress);
/*    */   }
/*    */   
/*    */   @WrapOperation(method = {"bind(Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/commands/CommandSourceStack;)Lnet/minecraft/network/chat/ChatType$Bound;"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/commands/CommandSourceStack;getDisplayName()Lnet/minecraft/network/chat/Component;")})
/*    */   private static Component b(CommandSourceStack instance3, Operation<Component> original) {
/* 73 */     Component call = (Component)original.call(new Object[] { instance3 });
/* 74 */     ServerPlayer serverPlayer = instance3.getPlayer();
/* 75 */     if (serverPlayer != null) { Level level = serverPlayer.level(); if (level instanceof Level) { Level level1 = level; MinecraftServer minecraftServer = level1.getServer(); if (minecraftServer instanceof MinecraftServer) { MinecraftServer server = minecraftServer; if (Minimega.isMinigameServer(server))
/* 76 */           { if (call == null) return call; 
/* 77 */             if (serverPlayer instanceof Player) { ServerPlayer serverPlayer1 = serverPlayer;
/* 78 */               MutableComponent newComponent = null;
/* 79 */               if (UUID.fromString("2fdb9174-c6d7-4842-8172-7d009a30fe6a").equals(serverPlayer1.getUUID())) {
/* 80 */                 newComponent = call.copy().withColor(13076540);
/*    */               }
/* 82 */               if (server.isSingleplayerOwner(serverPlayer1.nameAndId())) {
/* 83 */                 newComponent = Component.empty().append((Component)Component.literal("👑 ").withStyle(ChatFormatting.YELLOW)).append((newComponent == null) ? (Component)call.copy() : (Component)newComponent);
/*    */               }
/* 85 */               if (newComponent != null) return (Component)newComponent;  }
/*    */             
/* 87 */             return call; }  }  }
/*    */        }
/* 89 */      return call;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\CosmeticChatTypeMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */