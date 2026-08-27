/*    */ package dev.jab125.minimega.mod.extension;
/*    */ 
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.datafixers.kinds.Applicative;
/*    */ import com.mojang.datafixers.util.Pair;
/*    */ import com.mojang.serialization.MapCodec;
/*    */ import com.mojang.serialization.codecs.PairMapCodec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import dev.jab125.minimega.mod.util.MinigameMarker;
/*    */ import java.util.Optional;
/*    */ import net.minecraft.world.level.levelgen.WorldOptions;
/*    */ 
/*    */ public interface WorldOptionsExtension {
/*    */   static WorldOptionsExtension from(WorldOptions worldOptions) {
/* 15 */     return (WorldOptionsExtension)worldOptions;
/*    */   } public static final MapCodec<Optional<MinigameMarker>> MM_MAPS;
/*    */   static {
/* 18 */     MM_MAPS = RecordCodecBuilder.mapCodec(instance -> instance.group((App)MinigameMarker.CODEC.optionalFieldOf("minimega:minigame_marker").forGetter(())).apply((Applicative)instance, ()));
/*    */   }
/*    */ 
/*    */   
/*    */   static <O extends WorldOptions> MapCodec<O> extendCodec(MapCodec<O> originalCodec) {
/* 23 */     return (new PairMapCodec(originalCodec, MM_MAPS)).xmap(worldOptionsPair -> {
/*    */           from((WorldOptions)worldOptionsPair.getFirst()).mm$markWithMinigameData(((Optional<MinigameMarker>)worldOptionsPair.getSecond()).orElse(null));
/*    */           return (WorldOptions)worldOptionsPair.getFirst();
/*    */         }worldOptions -> {
/*    */           MinigameMarker value = from(worldOptions).mm$getMinigameData();
/*    */           System.out.println("Selected maps " + String.valueOf(value));
/*    */           return Pair.of(worldOptions, Optional.ofNullable(value));
/*    */         });
/*    */   }
/*    */   
/*    */   void mm$markWithMinigameData(MinigameMarker paramMinigameMarker);
/*    */   
/*    */   MinigameMarker mm$getMinigameData();
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\extension\WorldOptionsExtension.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */