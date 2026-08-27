/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.serialization.MapCodec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import dev.jab125.minimega.mod.extension.WorldOptionsExtension;
/*    */ import dev.jab125.minimega.mod.util.MinigameMarker;
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.world.level.levelgen.WorldOptions;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({WorldOptions.class})
/*    */ public class WorldOptionsMixin implements WorldOptionsExtension {
/*    */   @Unique
/* 21 */   private MinigameMarker maps = null;
/*    */ 
/*    */ 
/*    */   
/*    */   @WrapOperation(method = {"<clinit>"}, at = {@At(value = "INVOKE", target = "Lcom/mojang/serialization/codecs/RecordCodecBuilder;mapCodec(Ljava/util/function/Function;)Lcom/mojang/serialization/MapCodec;")})
/*    */   private static <O extends WorldOptions> MapCodec<O> clinit(Function<RecordCodecBuilder.Instance<O>, ? extends App<RecordCodecBuilder.Mu<O>, O>> builder, Operation<MapCodec<O>> original) {
/* 27 */     return WorldOptionsExtension.extendCodec((MapCodec)original.call(new Object[] { builder }));
/*    */   }
/*    */   
/*    */   @Inject(method = {"withSeed", "withStructures", "withBonusChest"}, at = {@At("RETURN")})
/*    */   private void with(CallbackInfoReturnable<WorldOptions> cir) {
/* 32 */     WorldOptionsExtension.from((WorldOptions)cir.getReturnValue()).mm$markWithMinigameData(this.maps);
/*    */   }
/*    */ 
/*    */   
/*    */   public void mm$markWithMinigameData(MinigameMarker data) {
/* 37 */     this.maps = data;
/*    */   }
/*    */ 
/*    */   
/*    */   public MinigameMarker mm$getMinigameData() {
/* 42 */     return this.maps;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\WorldOptionsMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */