/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ import com.llamalad7.mixinextras.expression.Definition;
/*    */ import com.llamalad7.mixinextras.expression.Expression;
/*    */ import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
/*    */ import com.llamalad7.mixinextras.sugar.Local;
/*    */ import com.mojang.datafixers.util.Pair;
/*    */ import dev.jab125.minimega.mod.extension.MultipackResourceManagerExtension;
/*    */ import dev.jab125.minimega.mod.extension.WorldOptionsExtension;
/*    */ import net.minecraft.server.WorldLoader;
/*    */ import net.minecraft.server.packs.resources.CloseableResourceManager;
/*    */ import net.minecraft.world.level.WorldDataConfiguration;
/*    */ import net.minecraft.world.level.levelgen.WorldGenSettings;
/*    */ import net.minecraft.world.level.storage.LevelDataAndDimensions;
/*    */ import net.minecraft.world.level.storage.WorldData;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({WorldLoader.class})
/*    */ public class WorldLoaderMixin {
/*    */   @ModifyExpressionValue(method = {"lambda$load$2"}, at = {@At("MIXINEXTRAS:EXPRESSION")})
/*    */   @Definition(id = "worldDataAndRegistries", local = {@Local(type = WorldLoader.DataLoadOutput.class, name = {"worldDataAndRegistries"})})
/*    */   @Expression({"worldDataAndRegistries = @(?)"})
/*    */   private static <D> WorldLoader.DataLoadOutput<D> ioa(WorldLoader.DataLoadOutput<D> original, @Local(argsOnly = true) Pair<WorldDataConfiguration, CloseableResourceManager> packsAndResourceManager) {
/* 24 */     Object object = original.cookie(); if (object instanceof LevelDataAndDimensions.WorldDataAndGenSettings) { LevelDataAndDimensions.WorldDataAndGenSettings worldDataAndGenSettings = (LevelDataAndDimensions.WorldDataAndGenSettings)object; try { WorldData worldData = worldDataAndGenSettings.data(); WorldGenSettings worldGenSettings1 = worldDataAndGenSettings.genSettings(), settings = worldGenSettings1; if (((WorldOptionsExtension)settings.options()).mm$getMinigameData() != null) {
/* 25 */           ((MultipackResourceManagerExtension)packsAndResourceManager.getSecond()).mm$setMinigameServer();
/*    */         }
/* 27 */         return original; } catch (Throwable throwable) { throw new MatchException(throwable.toString(), throwable); }  }  return original;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\WorldLoaderMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */