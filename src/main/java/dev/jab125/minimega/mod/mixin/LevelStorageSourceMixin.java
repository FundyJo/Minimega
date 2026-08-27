/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import java.nio.file.Path;
/*    */ import java.util.Objects;
/*    */ import java.util.function.Predicate;
/*    */ import java.util.stream.Stream;
/*    */ import net.minecraft.world.level.storage.LevelStorageSource;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({LevelStorageSource.class})
/*    */ public class LevelStorageSourceMixin {
/*    */   @WrapOperation(method = {"findLevelCandidates"}, at = {@At(value = "INVOKE", target = "Ljava/nio/file/Files;list(Ljava/nio/file/Path;)Ljava/util/stream/Stream;")})
/*    */   Stream<Path> hideMinigames(Path dir, Operation<Stream<Path>> original) {
/* 17 */     Objects.requireNonNull(dir.resolve("minigames")); return ((Stream<Path>)original.call(new Object[] { dir })).filter(Predicate.not(dir.resolve("minigames")::equals));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\LevelStorageSourceMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */