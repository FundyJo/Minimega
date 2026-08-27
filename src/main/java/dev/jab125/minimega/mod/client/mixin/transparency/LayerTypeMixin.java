/*    */ package dev.jab125.minimega.mod.client.mixin.transparency;
/*    */ 
/*    */ import dev.jab125.minimega.mod.client.extension.LayerTypeExtension;
/*    */ import net.minecraft.client.resources.model.EquipmentClientInfo;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ 
/*    */ @Mixin({EquipmentClientInfo.LayerType.class})
/*    */ public class LayerTypeMixin
/*    */   implements LayerTypeExtension
/*    */ {
/*    */   @Unique
/*    */   private double[] coords;
/*    */   
/*    */   public void mm$setPos(double x, double y, double z) {
/* 16 */     this.coords = new double[] { x, y, z };
/*    */   }
/*    */ 
/*    */   
/*    */   public double[] mm$getPos() {
/* 21 */     double[] coords1 = mm$getPos0();
/* 22 */     this.coords = null;
/* 23 */     return coords1;
/*    */   }
/*    */ 
/*    */   
/*    */   public double[] mm$getPos0() {
/* 28 */     return this.coords;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\transparency\LayerTypeMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */