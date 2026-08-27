/*    */ package dev.jab125.minimega.mod.client.mixin.grf;
/*    */ 
/*    */ import dev.jab125.minimega.grf.GrfContainer;
/*    */ import dev.jab125.minimega.grf.newelements.mxml.grf.__ROOT__;
/*    */ import dev.jab125.minimega.mod.client.MinimegaClient;
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({ClientLevel.class})
/*    */ public class ClientLevelMixin
/*    */   implements GrfContainer
/*    */ {
/*    */   public __ROOT__ getGrf() {
/* 20 */     return MinimegaClient.currentDimensionGrf;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\grf\ClientLevelMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */