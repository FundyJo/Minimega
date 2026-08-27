/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ 
/*    */ import java.util.function.Function;
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.core.Registry;
/*    */ import net.minecraft.world.level.biome.Biome;
/*    */ import net.minecraft.world.level.chunk.ChunkAccess;
/*    */ import net.minecraft.world.level.levelgen.NoiseChunk;
/*    */ import net.minecraft.world.level.levelgen.RandomState;
/*    */ import net.minecraft.world.level.levelgen.SurfaceRules;
/*    */ import net.minecraft.world.level.levelgen.SurfaceSystem;
/*    */ import net.minecraft.world.level.levelgen.WorldGenerationContext;
/*    */ import org.spongepowered.asm.mixin.Dynamic;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.gen.Accessor;
/*    */ import org.spongepowered.asm.mixin.gen.Invoker;
/*    */ import org.spongepowered.asm.mixin.injection.Coerce;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class duck
/*    */   extends SurfaceRules
/*    */ {
/*    */   @Mixin(targets = {"net/minecraft/world/level/levelgen/SurfaceRules$Context"})
/*    */   public static interface SurfaceRulesContextAccessor
/*    */   {
/*    */     @Invoker("<init>")
/*    */     @Dynamic
/*    */     @Coerce
/*    */     static SurfaceRules.Context init(SurfaceSystem surfaceSystem, RandomState randomState, ChunkAccess chunkAccess, NoiseChunk noiseChunk, Function<BlockPos, Holder<Biome>> function, Registry<Biome> registry, WorldGenerationContext worldGenerationContext) {
/* 42 */       return null;
/*    */     }
/*    */     
/*    */     @Accessor
/*    */     void setBlockY(int param1Int);
/*    */     
/*    */     @Accessor
/*    */     void setBlockZ(int param1Int);
/*    */     
/*    */     @Accessor
/*    */     void setBlockX(int param1Int);
/*    */     
/*    */     @Accessor
/*    */     void setLastUpdateXZ(long param1Long);
/*    */     
/*    */     @Accessor
/*    */     void setLastUpdateY(long param1Long);
/*    */     
/*    */     @Accessor
/*    */     long getLastUpdateXZ();
/*    */     
/*    */     @Accessor
/*    */     long getLastUpdateY();
/*    */     
/*    */     @Accessor
/*    */     void setStoneDepthBelow(int param1Int);
/*    */     
/*    */     @Accessor
/*    */     void setStoneDepthAbove(int param1Int);
/*    */     
/*    */     @Accessor
/*    */     void setSurfaceDepth(int param1Int);
/*    */     
/*    */     @Accessor
/*    */     void setBiome(Supplier<Holder<Biome>> param1Supplier);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\duck.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */