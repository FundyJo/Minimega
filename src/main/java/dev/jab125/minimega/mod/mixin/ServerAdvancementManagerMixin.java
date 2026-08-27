/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ 
/*    */ import com.google.common.collect.ImmutableMap;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import com.llamalad7.mixinextras.sugar.Local;
/*    */ import dev.jab125.minimega.mod.extension.MultipackResourceManagerExtension;
/*    */ import net.minecraft.resources.Identifier;
/*    */ import net.minecraft.server.ServerAdvancementManager;
/*    */ import net.minecraft.server.packs.resources.ResourceManager;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({ServerAdvancementManager.class})
/*    */ public class ServerAdvancementManagerMixin
/*    */ {
/*    */   @WrapOperation(method = {"apply(Ljava/util/Map;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V"}, at = {@At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableMap$Builder;buildOrThrow()Lcom/google/common/collect/ImmutableMap;")})
/*    */   <K, V> ImmutableMap<K, V> apply(ImmutableMap.Builder<K, V> instance, Operation<ImmutableMap<K, V>> original, @Local(argsOnly = true) ResourceManager manager) {
/* 19 */     if (manager instanceof MultipackResourceManagerExtension) { MultipackResourceManagerExtension manager1 = (MultipackResourceManagerExtension)manager;
/*    */       
/* 21 */       if (manager1.mm$isMinigameServer()) {
/* 22 */         ImmutableMap<K, V> call = (ImmutableMap<K, V>)original.call(new Object[] { instance });
/* 23 */         ImmutableMap.Builder<K, V> builder = ImmutableMap.builder();
/* 24 */         call.forEach((k, v) -> {
/*    */               if ("minimega".equals(((Identifier)k).getNamespace()))
/*    */                 builder.put(k, v); 
/* 27 */             }); return builder.build();
/*    */       }  }
/*    */     
/* 30 */     return (ImmutableMap<K, V>)original.call(new Object[] { instance });
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\ServerAdvancementManagerMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */