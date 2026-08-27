/*    */ package dev.jab125.minimega.mod.client.mixin.bar;
/*    */ 
/*    */ import com.google.common.collect.ImmutableMap;
/*    */ import com.llamalad7.mixinextras.expression.Definition;
/*    */ import com.llamalad7.mixinextras.expression.Expression;
/*    */ import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
/*    */ import dev.jab125.minimega.mod.client.MinimegaClient;
/*    */ import dev.jab125.minimega.mod.client.gui.bar.FourJBar;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.Map;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.contextualbar.ContextualBarRenderer;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ @Mixin({Gui.class})
/*    */ public class GuiMixin
/*    */ {
/*    */   @Shadow
/*    */   @Final
/*    */   private Minecraft minecraft;
/*    */   
/*    */   @ModifyExpressionValue(method = {"<init>"}, at = {@At("MIXINEXTRAS:EXPRESSION")})
/*    */   @Definition(id = "contextualInfoBarRenderers", field = {"Lnet/minecraft/client/gui/Gui;contextualInfoBarRenderers:Ljava/util/Map;"})
/*    */   @Expression({"this.contextualInfoBarRenderers = @(?)"})
/*    */   <K, V> ImmutableMap<K, V> constructor(ImmutableMap<K, V> original) {
/* 34 */     LinkedHashMap<K, V> kvLinkedHashMap = new LinkedHashMap<>((Map<? extends K, ? extends V>)original);
/* 35 */     kvLinkedHashMap.put((K)FourJBar.getMinigameContextualInfo(), (V)(() -> new FourJBar(this.minecraft)));
/* 36 */     return ImmutableMap.copyOf(kvLinkedHashMap);
/*    */   }
/*    */   
/*    */   @Inject(method = {"nextContextualInfoState"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void test(CallbackInfoReturnable cir) {
/* 41 */     if (MinimegaClient.getMinigame() != Minigame.NONE) cir.setReturnValue(FourJBar.getMinigameContextualInfo()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\bar\GuiMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */