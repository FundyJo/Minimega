/*     */ package dev.jab125.minimega.mod.client.mixin;
/*     */ 
/*     */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*     */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*     */ import com.llamalad7.mixinextras.sugar.Local;
/*     */ import dev.jab125.minimega.mod.abstractions.modloader.ModLoader;
/*     */ import dev.jab125.minimega.mod.abstractions.networking.ClientNetworking;
/*     */ import dev.jab125.minimega.mod.client.ControlifyMethods;
/*     */ import dev.jab125.minimega.mod.client.MinimegaClient;
/*     */ import dev.jab125.minimega.mod.client.VoteRef;
/*     */ import dev.jab125.minimega.mod.client.extension.MinecraftExtension;
/*     */ import dev.jab125.minimega.mod.client.gui.screen.minigame.SelectMapsScreen;
/*     */ import dev.jab125.minimega.mod.extension.EntityExtension;
/*     */ import dev.jab125.minimega.mod.init.ModSounds;
/*     */ import dev.jab125.minimega.mod.networking.payload.C2SReadyPayload;
/*     */ import dev.jab125.minimega.mod.networking.payload.C2SRestartPayload;
/*     */ import dev.jab125.minimega.mod.networking.payload.C2SSqueakPayload;
/*     */ import dev.jab125.minimega.mod.util.Minigame;
/*     */ import dev.jab125.minimega.mod.util.Ref;
/*     */ import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*     */ import dev.jab125.minimega.mod.util.controller.battle.BattleMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.fistfight.FistfightMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.glide.GlideMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.lobby.LobbyMinigameController;
/*     */ import dev.jab125.minimega.mod.util.minigamedata.MinigameData;
/*     */ import net.minecraft.client.CameraType;
/*     */ import net.minecraft.client.KeyMapping;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.Options;
/*     */ import net.minecraft.client.multiplayer.ClientLevel;
/*     */ import net.minecraft.client.player.LocalPlayer;
/*     */ import net.minecraft.client.renderer.GameRenderer;
/*     */ import net.minecraft.client.renderer.LevelRenderer;
/*     */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*     */ import net.minecraft.resources.Identifier;
/*     */ import net.minecraft.sounds.Music;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.level.Level;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import org.spongepowered.asm.mixin.Final;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.Unique;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mixin({Minecraft.class})
/*     */ public abstract class MinecraftMixin
/*     */   implements MinecraftExtension
/*     */ {
/*     */   @Shadow
/*     */   @Nullable
/*     */   public LocalPlayer player;
/*     */   @Shadow
/*     */   @Nullable
/*     */   public ClientLevel level;
/*     */   @Shadow
/*     */   @Final
/*     */   public Options options;
/*     */   @Shadow
/*     */   @Final
/*     */   public GameRenderer gameRenderer;
/*     */   @Shadow
/*     */   @Final
/*     */   public LevelRenderer levelRenderer;
/*     */   @Unique
/*     */   private CameraType prev;
/*     */   @Unique
/*     */   private boolean ready;
/*     */   
/*     */   @Inject(method = {"getMusicVolume"}, at = {@At("HEAD")}, cancellable = true)
/*     */   void mm$getMusicVolume(CallbackInfoReturnable<Float> cir) {
/*  79 */     if (this.level == null)
/*  80 */       return;  if (this.player == null)
/*  81 */       return;  MinigamesController minigameController = MinigamesController.getMinigameController((Level)this.level);
/*  82 */     AbstractMinigameController abstractMinigameController = minigameController.getController(Minigame.BATTLE); if (abstractMinigameController instanceof BattleMinigameController) { BattleMinigameController controller = (BattleMinigameController)abstractMinigameController; if (controller.getStage() == 5) {
/*  83 */         cir.setReturnValue(Float.valueOf(0.0F)); return;
/*     */       }  }
/*     */     
/*  86 */     abstractMinigameController = minigameController.getController(Minigame.FISTFIGHT); if (abstractMinigameController instanceof FistfightMinigameController) { FistfightMinigameController controller = (FistfightMinigameController)abstractMinigameController; if (controller.getStage() == 2) {
/*  87 */         cir.setReturnValue(Float.valueOf(0.0F)); return;
/*     */       }  }
/*     */     
/*  90 */     abstractMinigameController = minigameController.getController(Minigame.GLIDE); if (abstractMinigameController instanceof GlideMinigameController) { GlideMinigameController controller = (GlideMinigameController)abstractMinigameController; if (controller.getStage() == 4) {
/*  91 */         cir.setReturnValue(Float.valueOf(0.0F));
/*     */         return;
/*     */       }  }
/*     */   
/*     */   }
/*     */   
/*     */   @Inject(method = {"getSituationalMusic"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;level()Lnet/minecraft/world/level/Level;", shift = At.Shift.BY, by = 2)}, cancellable = true)
/*     */   void mm$getSituationalMusic(CallbackInfoReturnable<Music> cir, @Local(ordinal = 0) Level level) {
/*  99 */     MinigamesController minigameController = MinigamesController.getMinigameController(level);
/* 100 */     AbstractMinigameController abstractMinigameController = minigameController.getController(Minigame.BATTLE); if (abstractMinigameController instanceof BattleMinigameController) { BattleMinigameController battleMinigameController = (BattleMinigameController)abstractMinigameController;
/* 101 */       if (battleMinigameController.getTheme() == 15) {
/* 102 */         if (battleMinigameController.pvpEnabled() || battleMinigameController.getStage() == 2) {
/* 103 */           cir.setReturnValue(ModSounds.BATTLE_SHRUNK_MUSIC);
/* 104 */         } else if (battleMinigameController.getStage() == 5) {
/* 105 */           cir.setReturnValue(ModSounds.BATTLE_SHRUNK_MUSIC);
/*     */         } else {
/* 107 */           cir.setReturnValue(ModSounds.SWEET_SILENCE);
/*     */         } 
/* 109 */       } else if (battleMinigameController.getTheme() == 19) {
/* 110 */         if (battleMinigameController.pvpEnabled() || battleMinigameController.getStage() == 2) {
/* 111 */           cir.setReturnValue(ModSounds.BATTLE_FESTIVE_MUSIC);
/* 112 */         } else if (battleMinigameController.getStage() == 5) {
/* 113 */           cir.setReturnValue(ModSounds.BATTLE_FESTIVE_MUSIC);
/*     */         } else {
/* 115 */           cir.setReturnValue(ModSounds.SWEET_SILENCE);
/*     */         }
/*     */       
/* 118 */       } else if (battleMinigameController.pvpEnabled() || battleMinigameController.getStage() == 2) {
/* 119 */         cir.setReturnValue(ModSounds.BATTLE_C418_MUSIC);
/* 120 */       } else if (battleMinigameController.getStage() == 5) {
/* 121 */         cir.setReturnValue(ModSounds.BATTLE_C418_MUSIC);
/*     */       } else {
/* 123 */         cir.setReturnValue(ModSounds.SWEET_SILENCE);
/*     */       }  }
/*     */ 
/*     */     
/* 127 */     abstractMinigameController = minigameController.getController(Minigame.FISTFIGHT); if (abstractMinigameController instanceof FistfightMinigameController) { FistfightMinigameController fistfightMinigameController = (FistfightMinigameController)abstractMinigameController;
/* 128 */       if (fistfightMinigameController.getStage() == 1) {
/* 129 */         cir.setReturnValue(ModSounds.FISTFIGHT_MUSIC);
/* 130 */       } else if (fistfightMinigameController.getStage() == 2) {
/* 131 */         cir.setReturnValue(ModSounds.FISTFIGHT_MUSIC);
/*     */       } else {
/* 133 */         cir.setReturnValue(ModSounds.SWEET_SILENCE);
/*     */       }  }
/*     */     
/* 136 */     GlideMinigameController controller = (GlideMinigameController)minigameController.getController(Minigame.GLIDE);
/* 137 */     if (controller == null)
/* 138 */       return;  if (controller.getTheme() == 2 || controller.getTheme() == 3) {
/* 139 */       if (controller.isPlaying()) {
/* 140 */         cir.setReturnValue(ModSounds.GLIDE_THEME_2_MUSIC);
/* 141 */       } else if (((EntityExtension)this.player).mm$finishedMap()) {
/* 142 */         cir.setReturnValue(ModSounds.GLIDE_THEME_2_MUSIC);
/*     */       } else {
/* 144 */         cir.setReturnValue(ModSounds.SWEET_SILENCE);
/*     */       } 
/* 146 */     } else if (controller.getTheme() == 9) {
/* 147 */       if (controller.isPlaying()) {
/* 148 */         cir.setReturnValue(ModSounds.GLIDE_SHRUNK_MUSIC);
/* 149 */       } else if (((EntityExtension)this.player).mm$finishedMap()) {
/* 150 */         cir.setReturnValue(ModSounds.GLIDE_SHRUNK_MUSIC);
/*     */       } else {
/* 152 */         cir.setReturnValue(ModSounds.SWEET_SILENCE);
/*     */       } 
/* 154 */     } else if (controller.getTheme() == 12) {
/* 155 */       if (controller.isPlaying()) {
/* 156 */         cir.setReturnValue(ModSounds.GLIDE_CANYON_MUSIC);
/* 157 */       } else if (((EntityExtension)this.player).mm$finishedMap()) {
/* 158 */         cir.setReturnValue(ModSounds.GLIDE_CANYON_MUSIC);
/*     */       } else {
/* 160 */         cir.setReturnValue(ModSounds.SWEET_SILENCE);
/*     */       } 
/* 162 */     } else if (controller.getTheme() == 7) {
/* 163 */       if (controller.isPlaying()) {
/* 164 */         cir.setReturnValue(ModSounds.GLIDE_DRAGON_MUSIC);
/* 165 */       } else if (((EntityExtension)this.player).mm$finishedMap()) {
/* 166 */         cir.setReturnValue(ModSounds.GLIDE_DRAGON_MUSIC);
/*     */       } else {
/* 168 */         cir.setReturnValue(ModSounds.SWEET_SILENCE);
/*     */       } 
/* 170 */     } else if (controller.getTheme() == 4 || controller.getTheme() == 6 || controller.getTheme() == 10) {
/* 171 */       if (controller.isPlaying()) {
/* 172 */         cir.setReturnValue(ModSounds.GLIDE_VANILLA_MUSIC);
/* 173 */       } else if (((EntityExtension)this.player).mm$finishedMap()) {
/* 174 */         cir.setReturnValue(ModSounds.GLIDE_VANILLA_MUSIC);
/*     */       } else {
/* 176 */         cir.setReturnValue(ModSounds.SWEET_SILENCE);
/*     */       } 
/* 178 */     } else if (controller.getTheme() == 13) {
/* 179 */       if (controller.isPlaying()) {
/* 180 */         cir.setReturnValue(ModSounds.GLIDE_EXCALIBUR_MUSIC);
/* 181 */       } else if (((EntityExtension)this.player).mm$finishedMap()) {
/* 182 */         cir.setReturnValue(ModSounds.GLIDE_EXCALIBUR_MUSIC);
/*     */       } else {
/* 184 */         cir.setReturnValue(ModSounds.SWEET_SILENCE);
/*     */       } 
/* 186 */     } else if (controller.getTheme() == 14) {
/* 187 */       if (controller.isPlaying()) {
/* 188 */         cir.setReturnValue(ModSounds.GLIDE_ICARUS_MUSIC);
/* 189 */       } else if (((EntityExtension)this.player).mm$finishedMap()) {
/* 190 */         cir.setReturnValue(ModSounds.GLIDE_ICARUS_MUSIC);
/*     */       } else {
/* 192 */         cir.setReturnValue(ModSounds.SWEET_SILENCE);
/*     */       } 
/* 194 */     } else if (controller.getTheme() == 15) {
/* 195 */       if (controller.isPlaying()) {
/* 196 */         cir.setReturnValue(ModSounds.GLIDE_CELTS_MUSIC);
/* 197 */       } else if (((EntityExtension)this.player).mm$finishedMap()) {
/* 198 */         cir.setReturnValue(ModSounds.GLIDE_CELTS_MUSIC);
/*     */       } else {
/* 200 */         cir.setReturnValue(ModSounds.SWEET_SILENCE);
/*     */       } 
/* 202 */     } else if (controller.getTheme() == 11) {
/* 203 */       if (controller.isPlaying()) {
/* 204 */         cir.setReturnValue(ModSounds.GLIDE_BODY_MUSIC);
/* 205 */       } else if (((EntityExtension)this.player).mm$finishedMap()) {
/* 206 */         cir.setReturnValue(ModSounds.GLIDE_BODY_MUSIC);
/*     */       } else {
/* 208 */         cir.setReturnValue(ModSounds.SWEET_SILENCE);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @Inject(method = {"setLevel"}, at = {@At("HEAD")})
/*     */   private void setLevel(ClientLevel clientLevel, CallbackInfo ci) {
/* 215 */     MinigamesController minigameController = MinigamesController.getMinigameController((Level)this.level);
/* 216 */     if (minigameController.getActiveMinigame() != Minigame.LOBBY) {
/* 217 */       MinimegaClient.score = 0;
/* 218 */       mm$resetReady();
/* 219 */       mm$resetVote();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Unique
/* 227 */   private Ref<Identifier> vote = (Ref<Identifier>)new VoteRef((Minecraft)this);
/*     */ 
/*     */ 
/*     */   
/*     */   public CameraType mm$prev() {
/* 232 */     return this.prev;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mm$prev(CameraType type) {
/* 237 */     this.prev = type;
/*     */   }
/*     */   
/*     */   @WrapOperation(method = {"handleKeybinds"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/KeyMapping;consumeClick()Z")})
/*     */   private boolean mm$handleKeybinds(KeyMapping instance, Operation<Boolean> original) {
/* 242 */     if (instance == this.options.keyAttack)
/* 243 */     { Minigame<?> activeMinigame = MinigamesController.getMinigameController((Level)this.level).getActiveMinigame();
/* 244 */       if (ModLoader.isLegacy4jInstalled() && (activeMinigame == Minigame.BATTLE || (activeMinigame == Minigame.LOBBY && ModLoader.getInstance().isDevelopmentEnvironment())) && this.player != null && this.player.isSpectator()) {
/* 245 */         while (instance.consumeClick()) {
/* 246 */           this.player.connection.send(ClientNetworking.getInstance().play((CustomPacketPayload)new C2SSqueakPayload()));
/*     */         }
/* 248 */         return false;
/*     */       }  }
/* 250 */     else if (instance == this.options.keyInventory)
/* 251 */     { Minigame<?> activeMinigame = MinigamesController.getMinigameController((Level)this.level).getActiveMinigame();
/* 252 */       if (activeMinigame == Minigame.GLIDE && ControlifyMethods.isControlifyHandled.getAsBoolean()) {
/* 253 */         instance.consumeClick();
/* 254 */         return false;
/*     */       } 
/* 256 */       if (this.level != null)
/* 257 */       { if (activeMinigame == Minigame.GLIDE) {
/* 258 */           if (instance.isDown() && this.prev == null) {
/* 259 */             CameraType cameraType = this.options.getCameraType();
/* 260 */             this.prev = cameraType;
/* 261 */             this.options.setCameraType(CameraType.THIRD_PERSON_FRONT);
/* 262 */             if (cameraType.isFirstPerson() != this.options.getCameraType().isFirstPerson()) {
/* 263 */               this.gameRenderer.checkEntityPostEffect(this.options.getCameraType().isFirstPerson() ? getCameraEntity() : null);
/*     */             }
/*     */             
/* 266 */             this.levelRenderer.needsUpdate();
/* 267 */           } else if (!instance.isDown() && this.prev != null) {
/* 268 */             CameraType cameraType = this.options.getCameraType();
/* 269 */             CameraType prev1 = this.prev;
/* 270 */             this.prev = null;
/* 271 */             this.options.setCameraType(prev1);
/* 272 */             if (cameraType.isFirstPerson() != this.options.getCameraType().isFirstPerson()) {
/* 273 */               this.gameRenderer.checkEntityPostEffect(this.options.getCameraType().isFirstPerson() ? getCameraEntity() : null);
/*     */             }
/*     */           } 
/* 276 */           return false;
/* 277 */         }  if (activeMinigame == Minigame.LOBBY && ModLoader.isLegacy4jInstalled())
/* 278 */           while (instance.consumeClick()) {
/* 279 */             this.ready = !this.ready;
/* 280 */             this.player.connection.send(ClientNetworking.getInstance().play((CustomPacketPayload)new C2SReadyPayload(this.ready)));
/*     */           }   }
/*     */       else
/* 283 */       { return ((Boolean)original.call(new Object[] { instance })).booleanValue(); }  }
/* 284 */     else if (instance == this.options.keyDrop)
/* 285 */     { Minigame<?> activeMinigame = MinigamesController.getMinigameController((Level)this.level).getActiveMinigame();
/* 286 */       if (this.level != null)
/* 287 */       { if (!ModLoader.isLegacy4jInstalled() && (activeMinigame == Minigame.BATTLE || (activeMinigame == Minigame.LOBBY && ModLoader.getInstance().isDevelopmentEnvironment())) && this.player != null && this.player.isSpectator()) {
/* 288 */           while (instance.consumeClick()) {
/* 289 */             this.player.connection.send(ClientNetworking.getInstance().play((CustomPacketPayload)new C2SSqueakPayload()));
/*     */           }
/* 291 */           return false;
/* 292 */         }  if (activeMinigame == Minigame.GLIDE) {
/* 293 */           if (ModLoader.isLegacy4jInstalled()) {
/* 294 */             while (instance.consumeClick()) {
/* 295 */               this.player.connection.send(ClientNetworking.getInstance().play((CustomPacketPayload)new C2SRestartPayload(true)));
/*     */             }
/*     */           } else {
/* 298 */             boolean fromStart = hasShiftDown();
/* 299 */             while (instance.consumeClick()) {
/* 300 */               this.player.connection.send(ClientNetworking.getInstance().play((CustomPacketPayload)new C2SRestartPayload(fromStart)));
/*     */             }
/*     */           }
/*     */         
/* 304 */         } else if (activeMinigame == Minigame.LOBBY && ModLoader.isLegacy4jInstalled()) {
/* 305 */           while (instance.consumeClick()) {
/* 306 */             ((Minecraft)this).execute(() -> {
/*     */                   MinigameData minigameData = ((LobbyMinigameController)MinimegaClient.getController().getController(Minigame.LOBBY)).getMinigameData();
/*     */                   
/*     */                   ((Minecraft)this).setScreen(SelectMapsScreen.createMapVotingScreen(minigameData.minigame(), null, mm$vote(), minigameData.selectedMaps(), MinimegaClient.getMapInfos()));
/*     */                 });
/*     */           } 
/*     */           
/* 313 */           return false;
/*     */         }  }
/* 315 */       else { return ((Boolean)original.call(new Object[] { instance })).booleanValue(); }  }
/* 316 */     else { return ((Boolean)original.call(new Object[] { instance })).booleanValue(); }
/* 317 */      return ((Boolean)original.call(new Object[] { instance })).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mm$isReady() {
/* 322 */     return this.ready;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mm$resetReady() {
/* 327 */     this.ready = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mm$ready(boolean bool) {
/* 332 */     this.ready = bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public Ref<Identifier> mm$vote() {
/* 337 */     return this.vote;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mm$resetVote() {
/* 342 */     this.vote = (Ref<Identifier>)new VoteRef((Minecraft)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mm$isValid(Ref<Identifier> ref) {
/* 347 */     if (MinimegaClient.getMinigame() != Minigame.LOBBY) return false; 
/* 348 */     return (this.vote == ref);
/*     */   }
/*     */   
/*     */   @Shadow
/*     */   @Nullable
/*     */   public abstract Entity getCameraEntity();
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean hasShiftDown();
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\MinecraftMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */