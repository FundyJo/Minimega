/*    */ package dev.jab125.minimega.mod.client.gui.overlay;
/*    */ 
/*    */ import java.util.Optional;
/*    */ import java.util.function.Consumer;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.screens.LoadingOverlay;
/*    */ import net.minecraft.server.packs.resources.ReloadInstance;
/*    */ 
/*    */ public class CheapMapLoadingOverlay
/*    */   extends LoadingOverlay {
/*    */   public CheapMapLoadingOverlay(Minecraft minecraft, ReloadInstance reloadInstance, Consumer<Optional<Throwable>> consumer, boolean bl) {
/* 12 */     super(minecraft, reloadInstance, consumer, bl);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\overlay\CheapMapLoadingOverlay.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */