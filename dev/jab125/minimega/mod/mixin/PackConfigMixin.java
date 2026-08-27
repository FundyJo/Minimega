/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ 
/*    */ import com.mojang.datafixers.util.Pair;
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import dev.jab125.minimega.mod.extension.MultipackResourceManagerExtension;
/*    */ import net.minecraft.server.WorldLoader;
/*    */ import net.minecraft.server.packs.resources.CloseableResourceManager;
/*    */ import net.minecraft.world.level.WorldDataConfiguration;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({WorldLoader.PackConfig.class})
/*    */ public class PackConfigMixin {
/*    */   @Inject(method = {"createResourceManager"}, at = {@At("RETURN")})
/*    */   void createResourceManager(CallbackInfoReturnable<Pair<WorldDataConfiguration, CloseableResourceManager>> cir) {
/* 18 */     Pair<WorldDataConfiguration, CloseableResourceManager> returnValue = (Pair<WorldDataConfiguration, CloseableResourceManager>)cir.getReturnValue();
/* 19 */     if (((Boolean)Minimega._DONT_USE_THIS.get()).booleanValue()) { Object object = returnValue.getSecond(); if (object instanceof MultipackResourceManagerExtension) { MultipackResourceManagerExtension extension = (MultipackResourceManagerExtension)object;
/* 20 */         extension.mm$setMinigameServer(); }
/*    */        }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\PackConfigMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */