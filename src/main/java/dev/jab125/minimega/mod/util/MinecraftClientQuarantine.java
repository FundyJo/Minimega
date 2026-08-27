/*   */ package dev.jab125.minimega.mod.util;
/*   */ 
/*   */ import java.util.function.Predicate;
/*   */ import net.minecraft.world.entity.LivingEntity;
/*   */ 
/*   */ public class MinecraftClientQuarantine {
/*   */   public static Predicate<LivingEntity> isClientEntity = e -> false;
/*   */   public static Predicate<LivingEntity> isClientEntityIntegratedServerPerspective = e -> false;
/*   */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\MinecraftClientQuarantine.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */