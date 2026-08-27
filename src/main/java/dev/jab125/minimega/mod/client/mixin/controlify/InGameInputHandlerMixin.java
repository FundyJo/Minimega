/*     */ package dev.jab125.minimega.mod.client.mixin.controlify;
/*     */ 
/*     */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*     */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*     */ import dev.isxander.controlify.api.bind.InputBinding;
/*     */ import dev.isxander.controlify.bindings.ControlifyBindings;
/*     */ import dev.isxander.controlify.controller.ControllerEntity;
/*     */ import dev.isxander.controlify.ingame.InGameInputHandler;
/*     */ import dev.jab125.minimega.mod.abstractions.modloader.ModLoader;
/*     */ import dev.jab125.minimega.mod.abstractions.networking.ClientNetworking;
/*     */ import dev.jab125.minimega.mod.client.MinimegaClient;
/*     */ import dev.jab125.minimega.mod.client.extension.MinecraftExtension;
/*     */ import dev.jab125.minimega.mod.client.gui.screen.minigame.SelectMapsScreen;
/*     */ import dev.jab125.minimega.mod.networking.payload.C2SReadyPayload;
/*     */ import dev.jab125.minimega.mod.networking.payload.C2SRestartPayload;
/*     */ import dev.jab125.minimega.mod.networking.payload.C2SSqueakPayload;
/*     */ import dev.jab125.minimega.mod.util.Minigame;
/*     */ import dev.jab125.minimega.mod.util.controller.lobby.LobbyMinigameController;
/*     */ import dev.jab125.minimega.mod.util.minigamedata.MinigameData;
/*     */ import net.minecraft.client.CameraType;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*     */ import org.spongepowered.asm.mixin.Dynamic;
/*     */ import org.spongepowered.asm.mixin.Final;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ 
/*     */ 
/*     */ @Mixin({InGameInputHandler.class})
/*     */ public class InGameInputHandlerMixin
/*     */ {
/*     */   @Shadow
/*     */   @Final
/*     */   private ControllerEntity controller;
/*     */   
/*     */   @Inject(method = {"handleKeybinds"}, at = {@At("HEAD")})
/*     */   void q(CallbackInfo ci) {
/*  41 */     if (ControlifyBindings.DROP_INGAME.on(this.controller).justPressed() && (MinimegaClient.getMinigame() == Minigame.BATTLE || (MinimegaClient.getMinigame() == Minigame.LOBBY && ModLoader.getInstance().isDevelopmentEnvironment())) && this.minecraft.player != null && this.minecraft.player.isSpectator())
/*  42 */       this.minecraft.execute(() -> this.minecraft.player.connection.send(ClientNetworking.getInstance().play((CustomPacketPayload)new C2SSqueakPayload()))); 
/*     */   }
/*     */   @Shadow
/*     */   @Final
/*     */   private Minecraft minecraft;
/*     */   @WrapOperation(method = {"handleKeybinds"}, at = {@At(value = "INVOKE", target = "Ldev/isxander/controlify/api/bind/InputBinding;justPressed()Z")}, remap = false)
/*     */   @Dynamic
/*     */   boolean a(InputBinding binding, Operation<Boolean> original) {
/*  50 */     MinecraftExtension extension = (MinecraftExtension)this.minecraft;
/*  51 */     if (binding == ControlifyBindings.SWAP_HANDS.on(this.controller) && MinimegaClient.getMinigame() == Minigame.LOBBY) {
/*  52 */       if (binding.justPressed()) {
/*  53 */         extension.mm$ready(!extension.mm$isReady());
/*  54 */         this.minecraft.player.connection.send(ClientNetworking.getInstance().play((CustomPacketPayload)new C2SReadyPayload(extension.mm$isReady())));
/*     */       } 
/*  56 */       return false;
/*     */     } 
/*  58 */     if (binding == ControlifyBindings.SWAP_HANDS.on(this.controller) && MinimegaClient.getMinigame() == Minigame.GLIDE) {
/*  59 */       if (binding.justPressed()) {
/*  60 */         this.minecraft.player.connection.send(ClientNetworking.getInstance().play((CustomPacketPayload)new C2SRestartPayload(false)));
/*     */       }
/*  62 */       return false;
/*     */     } 
/*  64 */     if (binding == ControlifyBindings.INVENTORY.on(this.controller) && MinimegaClient.getMinigame() == Minigame.GLIDE) {
/*  65 */       if (binding.digitalNow() && extension.mm$prev() == null) {
/*  66 */         CameraType cameraType = this.minecraft.options.getCameraType();
/*  67 */         extension.mm$prev(cameraType);
/*  68 */         this.minecraft.options.setCameraType(CameraType.THIRD_PERSON_FRONT);
/*  69 */         if (cameraType.isFirstPerson() != this.minecraft.options.getCameraType().isFirstPerson()) {
/*  70 */           this.minecraft.gameRenderer.checkEntityPostEffect(this.minecraft.options.getCameraType().isFirstPerson() ? this.minecraft.getCameraEntity() : null);
/*     */         }
/*     */         
/*  73 */         this.minecraft.levelRenderer.needsUpdate();
/*  74 */       } else if (!binding.digitalNow() && extension.mm$prev() != null) {
/*  75 */         CameraType cameraType = this.minecraft.options.getCameraType();
/*  76 */         CameraType prev1 = extension.mm$prev();
/*  77 */         extension.mm$prev(null);
/*  78 */         this.minecraft.options.setCameraType(prev1);
/*  79 */         if (cameraType.isFirstPerson() != this.minecraft.options.getCameraType().isFirstPerson()) {
/*  80 */           this.minecraft.gameRenderer.checkEntityPostEffect(this.minecraft.options.getCameraType().isFirstPerson() ? this.minecraft.getCameraEntity() : null);
/*     */         }
/*     */       } 
/*  83 */       return false;
/*     */     } 
/*  85 */     if (binding == ControlifyBindings.DROP_INGAME.on(this.controller) && MinimegaClient.getMinigame() == Minigame.LOBBY) {
/*  86 */       if (binding.justPressed()) {
/*  87 */         this.minecraft.execute(() -> {
/*     */               MinigameData minigameData = ((LobbyMinigameController)MinimegaClient.getController().getController(Minigame.LOBBY)).getMinigameData();
/*     */               
/*     */               this.minecraft.setScreen(SelectMapsScreen.createMapVotingScreen(minigameData.minigame(), null, extension.mm$vote(), minigameData.selectedMaps(), MinimegaClient.getMapInfos()));
/*     */             });
/*     */       }
/*     */       
/*  94 */       return false;
/*     */     } 
/*  96 */     if (binding == ControlifyBindings.DROP_INGAME.on(this.controller) && MinimegaClient.getMinigame() == Minigame.GLIDE) {
/*  97 */       if (binding.justPressed() && 
/*  98 */         binding.justPressed()) {
/*  99 */         this.minecraft.player.connection.send(ClientNetworking.getInstance().play((CustomPacketPayload)new C2SRestartPayload(true)));
/*     */       }
/*     */       
/* 102 */       return false;
/*     */     } 
/* 104 */     return ((Boolean)original.call(new Object[] { binding })).booleanValue();
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\controlify\InGameInputHandlerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */