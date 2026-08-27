/*     */ package dev.jab125.minimega.mod.client.gui.screen.minigame;
/*     */ 
/*     */ import com.mojang.blaze3d.pipeline.RenderPipeline;
/*     */ import dev.jab125.minimega.mod.client.gui.widget.ISelectMapsScreen;
/*     */ import dev.jab125.minimega.mod.client.gui.widget.MapSelectionList;
/*     */ import dev.jab125.minimega.mod.data.MapInfo;
/*     */ import dev.jab125.minimega.mod.util.Minigame;
/*     */ import dev.jab125.minimega.mod.util.Ref;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import java.util.function.BinaryOperator;
/*     */ import java.util.function.UnaryOperator;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*     */ import net.minecraft.client.gui.components.Button;
/*     */ import net.minecraft.client.gui.components.FittingMultiLineTextWidget;
/*     */ import net.minecraft.client.gui.components.events.GuiEventListener;
/*     */ import net.minecraft.client.gui.screens.Screen;
/*     */ import net.minecraft.client.renderer.RenderPipelines;
/*     */ import net.minecraft.locale.Language;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.resources.Identifier;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ 
/*     */ public class SelectMapsScreen
/*     */   extends Screen
/*     */   implements ISelectMapsScreen<SelectMapsScreen>
/*     */ {
/*     */   private final Screen parent;
/*     */   private final ArrayList<Identifier> selectedMaps;
/*     */   private final List<MapInfo> mapInfos;
/*     */   private MapSelectionList list;
/*     */   private boolean isVotingScreen;
/*     */   private final Ref<Identifier> selectedMap;
/*     */   private final List<Identifier> enabledMaps;
/*     */   @Nullable
/*     */   private final Minigame<?> minigame;
/*     */   private FittingMultiLineTextWidget textWidget;
/*     */   private MapInfo currentMapInfo;
/*     */   
/*     */   public SelectMapsScreen(Screen parent, ArrayList<Identifier> selectedMaps, List<MapInfo> mapInfos) {
/*  45 */     super((Component)Component.translatable("minimega.selectMaps"));
/*  46 */     this.parent = parent;
/*  47 */     this.selectedMaps = selectedMaps;
/*  48 */     this.selectedMap = null;
/*  49 */     this.enabledMaps = null;
/*  50 */     this.isVotingScreen = false;
/*  51 */     this.minigame = null;
/*  52 */     this.mapInfos = mapInfos;
/*     */   }
/*     */   
/*     */   private SelectMapsScreen(Minigame<?> minigame, @Nullable Screen parent, Ref<Identifier> selectedMap, List<Identifier> enabledMaps, List<MapInfo> mapInfos) {
/*  56 */     super((Component)Component.translatable("minimega.selectMap"));
/*  57 */     this.parent = parent;
/*  58 */     this.selectedMap = selectedMap;
/*  59 */     this.selectedMaps = null;
/*  60 */     this.enabledMaps = enabledMaps;
/*  61 */     this.isVotingScreen = true;
/*  62 */     this.minigame = minigame;
/*  63 */     this.mapInfos = mapInfos;
/*     */   }
/*     */ 
/*     */   
/*     */   public Minecraft getMinecraftClient() {
/*  68 */     return getClient();
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<Identifier> getSelectedMaps() {
/*  73 */     return this.selectedMaps;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public Ref<Identifier> selectedMap() {
/*  78 */     return this.selectedMap;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public List<Identifier> enabledMaps() {
/*  83 */     return this.enabledMaps;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isVotingScreen() {
/*  88 */     return this.isVotingScreen;
/*     */   }
/*     */ 
/*     */   
/*     */   public Minigame<?> getMinigame() {
/*  93 */     Screen screen1 = this.parent; NewDataScreen screen = (NewDataScreen)screen1; return isVotingScreen() ? this.minigame : ((screen1 instanceof NewDataScreen) ? screen.getMinigame() : null);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<MapInfo> mapInfos() {
/*  98 */     return this.mapInfos;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void init() {
/* 103 */     boolean rtl = Language.getInstance().isDefaultRightToLeft();
/* 104 */     UnaryOperator<Integer> processor = rtl ? (t -> Integer.valueOf(this.width - t.intValue())) : UnaryOperator.<Integer>identity();
/* 105 */     BinaryOperator<Integer> processorWithWidth = rtl ? ((t, u) -> Integer.valueOf(this.width - t.intValue() - u.intValue())) : ((t, paramInteger1) -> t);
/* 106 */     super.init();
/* 107 */     switch (false) {
/*     */     
/* 109 */     }  MapSelectionList mapSelectionList = new MapSelectionList(this, this.minecraft, this.width / 3 * 2 - 8, this.height - 70, 32, 36);
/* 110 */     mapSelectionList.setX(((Integer)processorWithWidth.apply(Integer.valueOf(6), Integer.valueOf(mapSelectionList.getWidth()))).intValue());
/* 111 */     mapSelectionList.setScrollAmount(0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int getImageWidth() {
/* 128 */     return this.width / 3 - 8;
/*     */   }
/*     */   
/*     */   private int getImageHeight() {
/* 132 */     return (int)(getImageWidth() / 2.013888888888889D);
/*     */   }
/*     */ 
/*     */   
/*     */   private Optional<MapInfo> getCurrentlyFocusedMapInfo() {
/* 137 */     GuiEventListener focused = getFocused();
/* 138 */     if (focused instanceof MapSelectionList) { MapSelectionList list = (MapSelectionList)focused;
/* 139 */       MapSelectionList.Entry focused1 = (MapSelectionList.Entry)list.getSelected();
/* 140 */       if (focused1 != null) return Optional.ofNullable(this.currentMapInfo = focused1.getMapInfo());  }
/*     */     
/* 142 */     if (focused instanceof MapSelectionList.Entry) { MapSelectionList.Entry entry = (MapSelectionList.Entry)focused;
/* 143 */       return Optional.ofNullable(this.currentMapInfo = entry.getMapInfo()); }
/*     */     
/* 145 */     if (focused == this.textWidget) return Optional.ofNullable(this.currentMapInfo); 
/* 146 */     return Optional.empty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFocused(GuiEventListener focused) {
/* 151 */     super.setFocused(focused);
/* 152 */     Component description = (Component)getCurrentlyFocusedMapInfo().map(MapInfo::description).orElse(Component.literal("missingno"));
/* 153 */     if (this.textWidget != null && 
/* 154 */       !description.equals(this.textWidget.getMessage())) this.textWidget.setMessage(description);
/*     */   
/*     */   }
/*     */   
/*     */   public void mapSelected() {
/* 159 */     Component description = (Component)getCurrentlyFocusedMapInfo().map(MapInfo::description).orElse(Component.literal("missingno"));
/* 160 */     if (this.textWidget != null && 
/* 161 */       !description.equals(this.textWidget.getMessage())) this.textWidget.setMessage(description);
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void extractBackground(GuiGraphicsExtractor guiGraphics, int i, int j, float f) {
/* 167 */     boolean rtl = Language.getInstance().isDefaultRightToLeft();
/*     */ 
/*     */ 
/*     */     
/* 171 */     Objects.requireNonNull(guiGraphics); GuiGraphicsWrapper wrapper = !rtl ? guiGraphics::blit : ((renderPipeline, texture, x, y, u, v, width, height, textureWidth, textureHeight) -> guiGraphics.blit(renderPipeline, texture, this.width - x - width, y, u, v, width, height, textureWidth, textureHeight));
/* 172 */     super.extractBackground(guiGraphics, i, j, f);
/* 173 */     guiGraphics.centeredText(this.font, (Component)Component.translatable(isVotingScreen() ? "minimega.selectMap" : "minimega.selectMaps"), this.width / 2, 10, -1);
/* 174 */     getCurrentlyFocusedMapInfo().map(a -> a.id().withPrefix("textures/gui/" + getMinigame().tId() + "/maps/").withSuffix(".png")).ifPresent(identifier -> wrapper.blit(RenderPipelines.GUI_TEXTURED, identifier, this.width / 3 * 2 + 2, 32 + this.height - 70 - getImageHeight(), 0.0F, 0.0F, getImageWidth(), getImageHeight(), getImageWidth(), getImageHeight()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInGameUi() {
/* 181 */     return super.isInGameUi();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onClose() {
/* 186 */     this.minecraft.setScreen(this.parent);
/*     */   }
/*     */   
/*     */   public Minecraft getClient() {
/* 190 */     return this.minecraft;
/*     */   }
/*     */   
/*     */   public static Screen createMapVotingScreen(Minigame<?> minigame, @Nullable Screen parent, Ref<Identifier> selectedMap, List<Identifier> enabledMaps, List<MapInfo> mapInfos) {
/* 194 */     return new SelectMapsScreen(minigame, parent, selectedMap, enabledMaps, mapInfos);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPauseScreen() {
/* 199 */     return (!isVotingScreen() && super.isPauseScreen());
/*     */   }
/*     */   
/*     */   public void selectAll() {
/* 203 */     if (this.list != null) this.list.selectAll(); 
/*     */   }
/*     */   
/*     */   public void deselectAll() {
/* 207 */     if (this.list != null) this.list.deselectAll(); 
/*     */   }
/*     */

   interface GuiGraphicsWrapper {
     void blit(RenderPipeline paramRenderPipeline, Identifier paramIdentifier, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
   }
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\screen\minigame\SelectMapsScreen.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */