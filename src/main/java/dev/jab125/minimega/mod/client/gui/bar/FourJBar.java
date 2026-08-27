/*     */ package dev.jab125.minimega.mod.client.gui.bar;
/*     */ 
/*     */ import dev.jab125.minimega.mod.party.PlayerSlotObj;
/*     */ import dev.jab125.minimega.mod.party.PlayerSlotObjs;
/*     */ import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.DeltaTracker;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*     */ import net.minecraft.client.gui.contextualbar.ContextualBarRenderer;
/*     */ import net.minecraft.client.gui.contextualbar.ExperienceBarRenderer;
/*     */ import net.minecraft.util.Mth;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FourJBar
/*     */   extends ExperienceBarRenderer
/*     */   implements ContextualBarRenderer
/*     */ {
/*     */   private final Minecraft minecraft;
/*     */   public static Object MINIGAME_CONTEXTUAL_INFO;
/*     */   @Nullable
/*  26 */   public static volatile PlayerSlotObjs payload = null;
/*     */   
/*     */   public static Object getMinigameContextualInfo() {
/*  29 */     if (MINIGAME_CONTEXTUAL_INFO == null) {
/*  30 */       Gui gui = (Minecraft.getInstance()).gui;
/*     */     }
/*  32 */     if (MINIGAME_CONTEXTUAL_INFO == null) throw new RuntimeException("AAAAAAAAA"); 
/*  33 */     return MINIGAME_CONTEXTUAL_INFO;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FourJBar(Minecraft minecraft) {
/*  39 */     super(minecraft);
/*  40 */     this.minecraft = minecraft;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void extractBackground(GuiGraphicsExtractor guiGraphics, DeltaTracker deltaTracker) {
/*  51 */     if (FourJBar.payload == null)
/*     */       return;  PlayerSlotObjs payload;
/*  53 */     if ((payload = FourJBar.payload) == null)
/*     */       return; 
/*  55 */     int i = left(this.minecraft.getWindow());
/*  56 */     int j = top(this.minecraft.getWindow());
/*     */     
/*  58 */     List<PlayerSlotObj> list = payload.list();
/*  59 */     int length = list.size();
/*  60 */     boolean small = (length >= 11);
/*     */     
/*  62 */     int indivWidth = small ? 10 : 17;
/*     */     
/*  64 */     int left = i;
/*  65 */     int right = left + 182 - indivWidth;
/*  66 */     int l = 0;
/*     */ 
/*     */     
/*  69 */     boolean centered = (length == 9 || length == 10 || payload.slotsMetadata() instanceof dev.jab125.minimega.mod.party.BattleSlotsMetadata);
/*  70 */     Float2FloatFunction div = !small ? (f -> f / Math.max(7.0F, (length - 1))) : (f -> f / 15.0F);
/*  71 */     if (centered) {
/*     */ 
/*     */       
/*  74 */       int slotCount = (int)list.stream().filter(PlayerSlotObj::exists).count();
/*     */       
/*  76 */       if (slotCount > 0) {
/*  77 */         float first = Mth.lerp(0.0F, left, right);
/*  78 */         float last = Mth.lerp(div.get((slotCount - 1)), left, right);
/*     */ 
/*     */         
/*  81 */         float usedCenter = (first + last + indivWidth) / 2.0F;
/*     */ 
/*     */         
/*  84 */         float barCenter = (left + right + indivWidth) / 2.0F;
/*     */         
/*  86 */         int offset = (int)(barCenter - usedCenter);
/*     */         
/*  88 */         guiGraphics.pose().pushMatrix();
/*  89 */         guiGraphics.pose().translate(offset, 0.0F);
/*     */       } 
/*     */     } 
/*  92 */     boolean usesFloatLerp = (length > 8);
/*  93 */     Iterator<PlayerSlotObj> iterator = list.iterator(); while (true) { if (iterator.hasNext()) { PlayerSlotObj playerSlotObj = iterator.next();
/*  94 */         if (playerSlotObj instanceof PlayerSlotObj) { PlayerSlotObj playerSlotObj1 = playerSlotObj; try { int k = playerSlotObj1.slotIndex();
/*  95 */             int m = k; if (true) { int slotIndex = k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*     */               continue; }
/*     */              }
/*     */           catch (Throwable throwable)
/* 106 */           { throw new MatchException(throwable.toString(), throwable); }
/*     */            }
/*     */ 
/*     */         
/*     */         continue; }
/*     */       
/* 112 */       if (centered)
/* 113 */         guiGraphics.pose().popMatrix(); 
/*     */       break;
/*     */       bool1 = SYNTHETIC_LOCAL_VARIABLE_23.active();
/*     */       bool2 = bool1; }
/*     */   
/*     */   }
/*     */   
/*     */   public void extractRenderState(GuiGraphicsExtractor guiGraphics, DeltaTracker deltaTracker) {}
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\bar\FourJBar.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */