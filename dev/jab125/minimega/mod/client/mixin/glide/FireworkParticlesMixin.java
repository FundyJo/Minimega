/*    */ package dev.jab125.minimega.mod.client.mixin.glide;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import com.llamalad7.mixinextras.sugar.Local;
/*    */ import com.llamalad7.mixinextras.sugar.ref.LocalDoubleRef;
/*    */ import dev.jab125.minimega.mod.client.extension.FireworkParticlesStarterExtension;
/*    */ import it.unimi.dsi.fastutil.ints.IntList;
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.client.particle.FireworkParticles;
/*    */ import net.minecraft.client.particle.NoRenderParticle;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.sounds.SoundSource;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({FireworkParticles.Starter.class})
/*    */ public abstract class FireworkParticlesMixin extends NoRenderParticle implements FireworkParticlesStarterExtension {
/*    */   protected FireworkParticlesMixin(ClientLevel clientLevel, double d, double e, double f) {
/* 23 */     super(clientLevel, d, e, f);
/*    */   }
/*    */ 
/*    */   
/*    */   @Unique
/*    */   private FireworkParticlesStarterExtension.Data data;
/*    */   
/*    */   public void mm$setMMData(FireworkParticlesStarterExtension.Data data) {
/* 31 */     this.data = data;
/*    */   }
/*    */   
/*    */   @WrapOperation(method = {"tick"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ClientLevel;playLocalSound(DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V")})
/*    */   void pls(ClientLevel instance, double d, double e, double f, SoundEvent soundEvent, SoundSource soundSource, float g, float h, boolean bl, Operation<Void> original) {
/* 36 */     if (this.data != null)
/* 37 */       return;  original.call(new Object[] { instance, Double.valueOf(d), Double.valueOf(e), Double.valueOf(f), soundEvent, soundSource, Float.valueOf(g), Float.valueOf(h), Boolean.valueOf(bl) });
/*    */   }
/*    */   
/*    */   @Inject(method = {"createParticleBall"}, at = {@At("HEAD")})
/*    */   void d(double d, int i, IntList intList, IntList intList2, boolean bl, boolean bl2, CallbackInfo ci, @Local(argsOnly = true) LocalDoubleRef d1) {
/* 42 */     if (this.data != null) {
/* 43 */       d1.set(1.0D);
/*    */     }
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
/*    */   @WrapOperation(method = {"createParticleBall"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/particle/FireworkParticles$Starter;createParticle(DDDDDDLit/unimi/dsi/fastutil/ints/IntList;Lit/unimi/dsi/fastutil/ints/IntList;ZZ)V")})
/*    */   void cpb(FireworkParticles.Starter instance, double x, double y, double z, double xa, double ya, double za, IntList rgbColors, IntList fadeColors, boolean trail, boolean twinkle, Operation<Void> original) {
/* 59 */     if (this.data != null) {
/* 60 */       xa += this.data.deltaMovement().x();
/* 61 */       ya += this.data.deltaMovement().y();
/* 62 */       za += this.data.deltaMovement().z();
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 67 */     original.call(new Object[] { instance, Double.valueOf(x), Double.valueOf(y), Double.valueOf(z), Double.valueOf(xa), Double.valueOf(ya), Double.valueOf(za), rgbColors, fadeColors, Boolean.valueOf(trail), Boolean.valueOf(twinkle) });
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\glide\FireworkParticlesMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */