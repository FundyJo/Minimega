/*     */ package dev.jab125.minimega.mod.mixin;
/*     */ 
/*     */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*     */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*     */ import dev.jab125.minimega.mod.Minimega;
/*     */ import dev.jab125.minimega.mod.abstractions.modloader.ModLoader;
/*     */ import dev.jab125.minimega.mod.extension.MinecraftServerExtension;
/*     */ import dev.jab125.minimega.mod.extension.MultipackResourceManagerExtension;
/*     */ import dev.jab125.minimega.mod.party.MinigameParty;
/*     */ import dev.jab125.minimega.mod.util.HostingMethod;
/*     */ import dev.jab125.minimega.mod.util.minigamedata.MinigameData;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.function.BooleanSupplier;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.packs.PackResources;
/*     */ import net.minecraft.server.packs.PackType;
/*     */ import net.minecraft.server.packs.resources.MultiPackResourceManager;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.Unique;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ 
/*     */ @Mixin({MinecraftServer.class})
/*     */ public class MinecraftServerMixin
/*     */   implements MinecraftServerExtension
/*     */ {
/*     */   @Shadow
/*     */   private int ticksUntilAutosave;
/*     */   @Unique
/*     */   @Nullable
/*     */   private String ip;
/*     */   @Unique
/*     */   private int port;
/*     */   @Unique
/*     */   private MinigameData data;
/*     */   
/*     */   public void mm$setMMIP(String ip, int port) {
/*  42 */     this.ip = ip;
/*  43 */     this.port = port;
/*     */   }
/*     */ 
/*     */   
/*     */   public String mm$getIp() {
/*  48 */     return this.ip;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mm$getPort() {
/*  53 */     return this.port;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mm$clearMMIP() {
/*  58 */     this.ip = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mm$p2p() {
/*  63 */     return (this.ip != null);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public MinigameData mm$getData() {
/*  68 */     return this.data;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mm$setData(MinigameData data) {
/*  73 */     this.data = data;
/*     */   }
/*     */   
/*     */   @WrapOperation(method = {"lambda$reloadResources$1"}, at = {@At(value = "NEW", target = "net/minecraft/server/packs/resources/MultiPackResourceManager")})
/*     */   MultiPackResourceManager rlr(PackType packType, List<PackResources> list, Operation<MultiPackResourceManager> original) {
/*  78 */     MultiPackResourceManager call = (MultiPackResourceManager)original.call(new Object[] { packType, list });
/*  79 */     if (Minimega.isMinigameServer((MinecraftServer)this))
/*     */     {
/*  81 */       ((MultipackResourceManagerExtension)call).mm$setMinigameServer();
/*     */     }
/*     */ 
/*     */     
/*  85 */     return call;
/*     */   }
/*     */   
/*     */   @Inject(method = {"tickServer"}, at = {@At("HEAD")})
/*     */   void tick(BooleanSupplier booleanSupplier, CallbackInfo ci) {
/*  90 */     if (Minimega.isMinigameServer((MinecraftServer)this)) {
/*  91 */       this.ticksUntilAutosave = 99999999;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public HostingMethod mm$getHostingMethod(Minimega.WWWTicket ticket) {
/*  97 */     if (!ticket.global()) return HostingMethod.LAN; 
/*  98 */     if (ModLoader.getInstance().isModLoaded("e4mc") || ModLoader.getInstance().isModLoaded("e4mc_minecraft")) return HostingMethod.E4MC; 
/*  99 */     return HostingMethod.MINIMEGA;
/*     */   }
/*     */   @Unique
/* 102 */   private final ArrayList<MinigameParty> minigameParties = new ArrayList<>();
/*     */ 
/*     */ 
/*     */   
/*     */   public List<MinigameParty> getMinigamePartyList() {
/* 107 */     return this.minigameParties;
/*     */   }
/*     */ 
/*     */   
/*     */   public MinigameParty createMinigameParty(MinigameData data) {
/* 112 */     MinigameParty minigameParty = new MinigameParty((MinecraftServer)this, data);
/* 113 */     this.minigameParties.add(minigameParty);
/* 114 */     return minigameParty;
/*     */   }
/*     */ 
/*     */   
/*     */   public MinigameParty createMinigamePartyBasedInLobby(MinigameData data) {
/* 119 */     MinigameParty minigameParty = createMinigameParty(data);
/* 120 */     minigameParty.transferToLevel(Minimega.createLobbyWithMinigame((MinecraftServer)this, data));
/* 121 */     return minigameParty;
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\MinecraftServerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */