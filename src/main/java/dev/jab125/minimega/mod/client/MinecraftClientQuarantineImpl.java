/*    */ package dev.jab125.minimega.mod.client;
/*    */ import dev.jab125.minimega.mod.util.MinecraftClientQuarantine;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ 
/*    */ public class MinecraftClientQuarantineImpl {
/*    */   public static void setup() {
/*  8 */     MinecraftClientQuarantine.isClientEntity = (key -> (key.level().isClientSide() && Minecraft.getInstance().getCameraEntity() == key));
/*  9 */     MinecraftClientQuarantine.isClientEntityIntegratedServerPerspective = (entity -> entity.level().isClientSide() ? false : (
/*    */       
/* 11 */       (Minecraft.getInstance().getCameraEntity() != null && Minecraft.getInstance().getCameraEntity().getUUID().equals(entity.getUUID()))));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\MinecraftClientQuarantineImpl.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */