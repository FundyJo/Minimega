/*     */ package dev.jab125.minimega.mod.client;
/*     */ import dev.jab125.minimega.mod.Minimega;
/*     */ import dev.jab125.minimega.mod.abstractions.modloader.ModLoader;
/*     */ import dev.jab125.minimega.mod.client.gui.bar.FourJBar;
/*     */ import dev.jab125.minimega.mod.client.gui.overlay.GlideCheckpointMarkerHud;
/*     */ import dev.jab125.minimega.mod.extension.PlayerExtension;
/*     */ import dev.jab125.minimega.mod.party.GlideSlotMetadata;
/*     */ import dev.jab125.minimega.mod.party.GlideSlotsMetadata;
/*     */ import dev.jab125.minimega.mod.party.PlayerSlotObj;
/*     */ import dev.jab125.minimega.mod.party.PlayerSlotObjs;
/*     */ import dev.jab125.minimega.mod.party.ReducedCheckpoint;
/*     */ import dev.jab125.minimega.mod.party.SlotMetadata;
/*     */ import net.minecraft.client.DeltaTracker;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Font;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*     */ import net.minecraft.client.renderer.RenderPipelines;
/*     */ import net.minecraft.resources.Identifier;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ 
/*     */ public class GlideHudHelpers {
/*     */   public static int getTextRightMargin() {
/*  24 */     return ModLoader.isLegacy4jInstalled() ? 54 : 32;
/*     */   } public static final float TEXT_SCALE = 1.0F;
/*     */   public static int getIconMargin() {
/*  27 */     return ModLoader.isLegacy4jInstalled() ? 48 : 26;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float textScale(float legacyScale) {
/*  32 */     return ModLoader.isLegacy4jInstalled() ? legacyScale : 1.0F;
/*     */   }
/*     */   
/*     */   public static void renderScaledText(GuiGraphicsExtractor graphics, Font font, String text, int color, int x, int y, float scale) {
/*  36 */     graphics.pose().pushMatrix();
/*  37 */     graphics.pose().translate(x, y);
/*  38 */     graphics.pose().scale(scale);
/*  39 */     graphics.text(font, text, 0, 0, color);
/*  40 */     graphics.pose().popMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void mm$renderHeart(GuiGraphicsExtractor guiGraphics, boolean yes, int x, int y) {
/*  45 */     guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Identifier.withDefaultNamespace("hud/heart/container"), x, y, 9, 9);
/*  46 */     if (yes) {
/*  47 */       guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Identifier.withDefaultNamespace("hud/heart/full"), x, y, 9, 9);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void renderGlideHotbar(Gui gui, Player player, GlideSlotsMetadata slotsMetadata, GuiGraphicsExtractor guiGraphics, DeltaTracker deltaTracker) {
/*  52 */     if (player != null) {
/*  53 */       int halfScreenWidth = guiGraphics.guiWidth() / 2;
/*     */       
/*  55 */       int progressBarWidth = 312;
/*  56 */       int progressBarHeight = 10;
/*  57 */       int progressBarX = halfScreenWidth - progressBarWidth / 2;
/*  58 */       int progressBarY = guiGraphics.guiHeight() - 10;
/*  59 */       guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Minimega.id("glide/race_progress_bar"), progressBarX, progressBarY, progressBarWidth, progressBarHeight);
/*     */ 
/*     */       
/*  62 */       int size = ((ReducedCheckpoint)slotsMetadata.checkpointInfo().stream().sorted((a, b) -> b.id() - a.id()).findFirst().get()).id() + 1;
/*  63 */       for (ReducedCheckpoint reducedCheckpoint : slotsMetadata.checkpointInfo()) {
/*  64 */         int i = reducedCheckpoint.id();
/*  65 */         int x = progressBarX + (int)(i / size * progressBarWidth);
/*  66 */         if (i != 0 && reducedCheckpoint.respawn()) {
/*  67 */           GlideCheckpointMarkerHud.render(guiGraphics, i, x, progressBarY, progressBarHeight);
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  76 */       PlayerSlotObj me = null;
/*  77 */       PlayerSlotObjs payload = FourJBar.payload;
/*  78 */       if (payload == null)
/*  79 */         return;  for (PlayerSlotObj playerSlotObj : payload.list()) {
/*  80 */         if (playerSlotObj.isMe()) {
/*  81 */           me = playerSlotObj;
/*     */           continue;
/*     */         } 
/*  84 */         SlotMetadata slotMetadata = playerSlotObj.metadata(); if (slotMetadata instanceof GlideSlotMetadata) { GlideSlotMetadata metadata = (GlideSlotMetadata)slotMetadata;
/*  85 */           renderPlayerIcon(guiGraphics, metadata, progressBarX, size, progressBarWidth, playerSlotObj.slotIndex(), progressBarY, progressBarHeight, false); }
/*     */       
/*     */       } 
/*  88 */       if (me != null) {
/*  89 */         SlotMetadata slotMetadata = me.metadata(); if (slotMetadata instanceof GlideSlotMetadata) { GlideSlotMetadata metadata = (GlideSlotMetadata)slotMetadata;
/*  90 */           renderPlayerIcon(guiGraphics, metadata, progressBarX, size, progressBarWidth, me.slotIndex(), progressBarY, progressBarHeight, true); }
/*     */       
/*     */       } 
/*     */       
/*  94 */       guiGraphics.text(gui.getFont(), "%s/%s".formatted(new Object[] { Integer.valueOf(slotsMetadata.round()), Integer.valueOf(slotsMetadata.maxRounds()) }, ), progressBarX + progressBarWidth + 6, progressBarY + 1, -1);
/*     */       
/*  96 */       int lives = player.isDeadOrDying() ? 0 : ((PlayerExtension)player).mm$getGlideHealth();
/*  97 */       mm$renderHeart(guiGraphics, (lives >= 3), guiGraphics.guiWidth() / 2 - 4 + 8, progressBarY - 11);
/*  98 */       mm$renderHeart(guiGraphics, (lives >= 2), guiGraphics.guiWidth() / 2 - 4, progressBarY - 11);
/*  99 */       mm$renderHeart(guiGraphics, (lives >= 1), guiGraphics.guiWidth() / 2 - 4 - 8, progressBarY - 11);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void renderPlayerIcon(GuiGraphicsExtractor guiGraphics, GlideSlotMetadata playerRaceProgress, int progressBarX, int size, int progressBarWidth, int colorId, int progressBarY, int progressBarHeight, boolean isCurrentPlayer) {
/* 104 */     if (playerRaceProgress != null) {
/* 105 */       int checkpoint = playerRaceProgress.checkpoint();
/* 106 */       double progressToNextCheckpoint = playerRaceProgress.progressToNextCheckpoint();
/*     */       
/* 108 */       double progress = Math.max(0.0D, Math.min(size, checkpoint + progressToNextCheckpoint));
/* 109 */       double x = progressBarX + progress * progressBarWidth / size;
/* 110 */       guiGraphics.pose().pushMatrix();
/* 111 */       int guiScale = Minecraft.getInstance().getWindow().getGuiScale();
/*     */       
/* 113 */       guiGraphics.pose().translate((int)(x * guiScale) / guiScale, 0.0F);
/* 114 */       guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Minimega.id("bar/glide/player" + String.valueOf(playerRaceProgress.dead() ? "dead" : Integer.valueOf(colorId))), -3, progressBarY, 6, progressBarHeight);
/* 115 */       if (isCurrentPlayer) {
/* 116 */         guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Minimega.id("bar/glide/alivedead_outline"), -3, progressBarY, 6, progressBarHeight);
/*     */       }
/* 118 */       guiGraphics.pose().popMatrix();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\GlideHudHelpers.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */