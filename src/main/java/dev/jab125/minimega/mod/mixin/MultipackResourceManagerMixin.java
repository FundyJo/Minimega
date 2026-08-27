/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ 
/*    */ import dev.jab125.minimega.mod.extension.MultipackResourceManagerExtension;
/*    */ import java.util.List;
/*    */ import net.minecraft.server.packs.PackType;
/*    */ import net.minecraft.server.packs.resources.MultiPackResourceManager;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({MultiPackResourceManager.class})
/*    */ public class MultipackResourceManagerMixin
/*    */   implements MultipackResourceManagerExtension {
/*    */   @Unique
/*    */   private boolean misMnigameServer;
/*    */   private Throwable throwable;
/*    */   
/*    */   public void mm$setMinigameServer() {
/* 21 */     this.misMnigameServer = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean mm$isMinigameServer() {
/* 26 */     return this.misMnigameServer;
/*    */   }
/*    */ 
/*    */   
/*    */   public Throwable getT() {
/* 31 */     return this.throwable;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @Inject(method = {"<init>"}, at = {@At("CTOR_HEAD")})
/*    */   void init(PackType packType, List list, CallbackInfo ci) {
/*    */     try {
/* 39 */       throw new Throwable();
/* 40 */     } catch (Throwable t) {
/* 41 */       this.throwable = t;
/*    */       return;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\MultipackResourceManagerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */