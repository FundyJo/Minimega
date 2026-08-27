/*     */ package dev.jab125.minimega.mod.client.gui.screen;
/*     */ 
/*     */ import dev.jab125.minimega.mod.Minimega;
/*     */ import dev.jab125.minimega.mod.abstractions.networking.ClientNetworking;
/*     */ import dev.jab125.minimega.mod.client.extension.LoadingOverlayExtension;
/*     */ import dev.jab125.minimega.mod.data.MapInfo;
/*     */ import dev.jab125.minimega.mod.networking.payload.C2SFinishedMapLoadingPayload;
/*     */ import dev.jab125.minimega.mod.util.Minigame;
/*     */ import net.minecraft.client.GameNarrator;
/*     */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*     */ import net.minecraft.client.gui.screens.Overlay;
/*     */ import net.minecraft.client.gui.screens.Screen;
/*     */ import net.minecraft.client.multiplayer.LevelLoadTracker;
/*     */ import net.minecraft.client.renderer.RenderPipelines;
/*     */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*     */ import net.minecraft.resources.Identifier;
/*     */ 
/*     */ public class MapTransitionScreen
/*     */   extends Screen
/*     */ {
/*     */   private final MapInfo mapInfo;
/*     */   public LevelLoadTracker loadTracker;
/*     */   
/*     */   public MapTransitionScreen(LevelLoadTracker loadTracker, MapInfo mapInfo) {
/*  25 */     super(GameNarrator.NO_TITLE);
/*  26 */     this.loadTracker = loadTracker;
/*  27 */     Minimega.LOGGER.info(":) :) :) :)");
/*  28 */     this.mapInfo = mapInfo;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldCloseOnEsc() {
/*  33 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean shouldNarrateNavigation() {
/*  38 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPauseScreen() {
/*  43 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void extractRenderState(GuiGraphicsExtractor guiGraphics, int i, int j, float f) {
/*  48 */     super.extractRenderState(guiGraphics, i, j, f);
/*  49 */     int xCenter = this.width / 2;
/*  50 */     int yCenter = this.height / 2;
/*  51 */     int textTop = yCenter - 50 + 40;
/*  52 */     guiGraphics.centeredText(this.font, this.mapInfo.displayName(), this.width / 2, textTop, -1);
/*     */     
/*  54 */     switch (false) {  }
/*  55 */      Overlay overlay = this.minecraft.getOverlay();
/*  56 */     LoadingOverlayExtension extension = (LoadingOverlayExtension)overlay; drawProgressBar(guiGraphics, xCenter - 100, textTop + 9 + 3, 200, 2, (overlay instanceof LoadingOverlayExtension) ? 
/*  57 */         extension.mm$getProgress() : 
/*     */         
/*  59 */         0.0F);
/*     */     
/*  61 */     Minigame<?> minigame = this.mapInfo.minigame();
/*  62 */     Identifier vanilla = Identifier.parse("minimega:textures/gui/sprites/" + minigame.tId() + "/" + minigame.tId() + ".png");
/*  63 */     guiGraphics.blit(RenderPipelines.GUI_TEXTURED, vanilla, this.width / 2 - 32, textTop - 70, 0.0F, 0.0F, 64, 64, 64, 64);
/*     */   }
/*     */ 
/*     */   
/*     */   public float progress() {
/*  68 */     switch (false) {  }
/*  69 */      Overlay overlay = this.minecraft.getOverlay();
/*  70 */     LoadingOverlayExtension extension = (LoadingOverlayExtension)overlay; return (overlay instanceof LoadingOverlayExtension) ? 
/*  71 */       extension.mm$getProgress() : 
/*     */       
/*  73 */       0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public MapInfo mapInfo() {
/*  78 */     return this.mapInfo;
/*     */   }
/*     */   
/*     */   private void drawProgressBar(GuiGraphicsExtractor graphics, int left, int top, int width, int height, float progress) {
/*  82 */     graphics.fill(left, top, left + width, top + height, -16777216);
/*  83 */     graphics.fill(left, top, left + Math.round(progress * width), top + height, -16711936);
/*     */   }
/*     */ 
/*     */   
/*     */   public void extractBackground(GuiGraphicsExtractor guiGraphics, int i, int j, float f) {
/*  88 */     extractPanorama(guiGraphics, f);
/*  89 */     extractBlurredBackground(guiGraphics);
/*  90 */     extractMenuBackground(guiGraphics);
/*     */   }
/*     */ 
/*     */   
/*     */   public void tick() {
/*  95 */     super.tick();
/*  96 */     if (this.loadTracker.isLevelReady()) {
/*  97 */       if (this.minecraft.getOverlay() instanceof net.minecraft.client.gui.screens.LoadingOverlay) {
/*  98 */         Minimega.LOGGER.error("Finished with the loading overlay open?");
/*     */         return;
/*     */       } 
/* 101 */       onClose();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onClose() {
/* 107 */     super.onClose();
/* 108 */     this.minecraft.getConnection().send(ClientNetworking.getInstance().play((CustomPacketPayload)new C2SFinishedMapLoadingPayload()));
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\screen\MapTransitionScreen.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */