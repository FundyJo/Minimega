/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import net.minecraft.server.level.ChunkHolder;
/*    */ import net.minecraft.server.level.FullChunkStatus;
/*    */ import net.minecraft.server.level.GenerationChunkHolder;
/*    */ import net.minecraft.world.level.ChunkPos;
/*    */ import net.minecraft.world.level.LevelHeightAccessor;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ @Mixin({ChunkHolder.class})
/*    */ public abstract class ChunkHolderMixin extends GenerationChunkHolder {
/*    */   @Shadow
/*    */   @Final
/*    */   private LevelHeightAccessor levelHeightAccessor;
/*    */   
/*    */   public ChunkHolderMixin(ChunkPos chunkPos) {
/* 22 */     super(chunkPos);
/*    */   }
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
/*    */   @WrapOperation(method = {"updateFutures"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/server/level/ChunkLevel;fullStatus(I)Lnet/minecraft/server/level/FullChunkStatus;")})
/*    */   FullChunkStatus updateFutures(int i, Operation<FullChunkStatus> original) {
/* 49 */     return (FullChunkStatus)original.call(new Object[] { Integer.valueOf(i) });
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\ChunkHolderMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */