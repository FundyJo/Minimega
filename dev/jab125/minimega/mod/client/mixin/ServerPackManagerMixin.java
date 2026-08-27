/*    */ package dev.jab125.minimega.mod.client.mixin;
/*    */ 
/*    */ import dev.jab125.minimega.mod.extension.ServerPackManagerExtension;
/*    */ import net.minecraft.client.resources.server.ServerPackManager;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ 
/*    */ @Mixin({ServerPackManager.class})
/*    */ public abstract class ServerPackManagerMixin
/*    */   implements ServerPackManagerExtension
/*    */ {
/*    */   @Shadow
/*    */   protected abstract boolean updateDownloads();
/*    */   
/*    */   @Shadow
/*    */   protected abstract void triggerReloadIfNeeded();
/*    */   
/*    */   @Shadow
/*    */   protected abstract void cleanupRemovedPacks();
/*    */   
/*    */   public void mm$downloadWithoutReloading() {
/* 22 */     boolean bl = updateDownloads();
/*    */   }
/*    */ 
/*    */   
/*    */   public void mm$reloadWithoutDownloading() {
/* 27 */     triggerReloadIfNeeded();
/* 28 */     cleanupRemovedPacks();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\ServerPackManagerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */