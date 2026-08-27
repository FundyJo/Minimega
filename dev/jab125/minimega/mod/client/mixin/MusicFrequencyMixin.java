/*    */ package dev.jab125.minimega.mod.client.mixin;
/*    */ 
/*    */ import dev.jab125.minimega.mod.init.ModSounds;
/*    */ import net.minecraft.client.sounds.MusicManager;
/*    */ import net.minecraft.sounds.Music;
/*    */ import net.minecraft.util.RandomSource;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({MusicManager.MusicFrequency.class})
/*    */ public class MusicFrequencyMixin {
/*    */   @Inject(method = {"getNextSongDelay"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void getNextSongDelay(Music music, RandomSource randomSource, CallbackInfoReturnable<Integer> cir) {
/* 16 */     if (music == ModSounds.GLIDE_CANYON_MUSIC || music == ModSounds.GLIDE_SHRUNK_MUSIC || music == ModSounds.GLIDE_THEME_2_MUSIC || music == ModSounds.GLIDE_DRAGON_MUSIC || music == ModSounds.GLIDE_VANILLA_MUSIC || music == ModSounds.GLIDE_ICARUS_MUSIC || music == ModSounds.GLIDE_EXCALIBUR_MUSIC || music == ModSounds.GLIDE_CELTS_MUSIC || music == ModSounds.GLIDE_BODY_MUSIC || music == ModSounds.FISTFIGHT_MUSIC || music == ModSounds.BATTLE_C418_MUSIC || music == ModSounds.BATTLE_SHRUNK_MUSIC || music == ModSounds.BATTLE_FESTIVE_MUSIC)
/* 17 */       cir.setReturnValue(Integer.valueOf(0)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\MusicFrequencyMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */