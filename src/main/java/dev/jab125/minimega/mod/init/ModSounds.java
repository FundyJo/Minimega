/*    */ package dev.jab125.minimega.mod.init;
/*    */ 
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.resources.Identifier;
/*    */ import net.minecraft.sounds.Music;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.sounds.SoundEvents;
/*    */ 
/*    */ public class ModSounds {
/* 11 */   public static final Holder<SoundEvent> GLIDE_THEME_2 = variableSoundRangeEvent("glide_theme_2");
/* 12 */   public static final Holder<SoundEvent> GLIDE_SHRUNK = variableSoundRangeEvent("glide_shrunk");
/* 13 */   public static final Holder<SoundEvent> GLIDE_CANYON = variableSoundRangeEvent("glide_canyon");
/* 14 */   public static final Holder<SoundEvent> GLIDE_DRAGON = variableSoundRangeEvent("glide_dragon");
/* 15 */   public static final Holder<SoundEvent> GLIDE_VANILLA = variableSoundRangeEvent("glide_vanilla");
/* 16 */   public static final Holder<SoundEvent> GLIDE_ICARUS = variableSoundRangeEvent("glide_icarus");
/* 17 */   public static final Holder<SoundEvent> GLIDE_EXCALIBUR = variableSoundRangeEvent("glide_excalibur");
/* 18 */   public static final Holder<SoundEvent> GLIDE_CELTS = variableSoundRangeEvent("glide_celts");
/* 19 */   public static final Holder<SoundEvent> GLIDE_BODY = variableSoundRangeEvent("glide_body");
/* 20 */   public static final Holder<SoundEvent> CHECKPOINT = variableSoundRangeEvent("glide_checkpoint");
/* 21 */   public static final Holder<SoundEvent> BOOST = variableSoundRangeEvent("glide_boost");
/* 22 */   public static final Holder<SoundEvent> THERMAL = variableSoundRangeEvent("glide_thermal");
/* 23 */   public static final Holder<SoundEvent> DEATH = variableSoundRangeEvent("glide_death");
/* 24 */   public static final Holder<SoundEvent> SCORE = variableSoundRangeEvent("glide_score");
/* 25 */   public static final Holder<SoundEvent> CHEST = variableSoundRangeEvent("battle_chest");
/* 26 */   public static final Holder<SoundEvent> SCORE_GOLD = variableSoundRangeEvent("glide_score_gold");
/* 27 */   public static final Holder<SoundEvent> SCORE_DIAMOND = variableSoundRangeEvent("glide_score_diamond");
/* 28 */   public static final Holder<SoundEvent> FISTFIGHT_THEME = variableSoundRangeEvent("fistfight_theme");
/* 29 */   public static final Holder<SoundEvent> BATTLE_C418 = variableSoundRangeEvent("battle_c418");
/* 30 */   public static final Holder<SoundEvent> BATTLE_SHRUNK = variableSoundRangeEvent("battle_shrunk");
/* 31 */   public static final Holder<SoundEvent> BATTLE_FESTIVE = variableSoundRangeEvent("battle_festive");
/* 32 */   public static final Music GLIDE_THEME_2_MUSIC = new Music(GLIDE_THEME_2, 0, 0, true);
/* 33 */   public static final Music GLIDE_SHRUNK_MUSIC = new Music(GLIDE_SHRUNK, 0, 0, true);
/* 34 */   public static final Music GLIDE_CANYON_MUSIC = new Music(GLIDE_CANYON, 0, 0, true);
/* 35 */   public static final Music GLIDE_DRAGON_MUSIC = new Music(GLIDE_DRAGON, 0, 0, true);
/* 36 */   public static final Music GLIDE_VANILLA_MUSIC = new Music(GLIDE_VANILLA, 0, 0, true);
/* 37 */   public static final Music GLIDE_ICARUS_MUSIC = new Music(GLIDE_ICARUS, 0, 0, true);
/* 38 */   public static final Music GLIDE_EXCALIBUR_MUSIC = new Music(GLIDE_EXCALIBUR, 0, 0, true);
/* 39 */   public static final Music GLIDE_CELTS_MUSIC = new Music(GLIDE_CELTS, 0, 0, true);
/* 40 */   public static final Music GLIDE_BODY_MUSIC = new Music(GLIDE_BODY, 0, 0, true);
/* 41 */   public static final Music FISTFIGHT_MUSIC = new Music(FISTFIGHT_THEME, 0, 0, true);
/* 42 */   public static final Music BATTLE_C418_MUSIC = new Music(BATTLE_C418, 0, 0, true);
/* 43 */   public static final Music BATTLE_SHRUNK_MUSIC = new Music(BATTLE_SHRUNK, 0, 0, true);
/* 44 */   public static final Music BATTLE_FESTIVE_MUSIC = new Music(BATTLE_FESTIVE, 0, 0, true);
/* 45 */   public static final Music SWEET_SILENCE = new Music(Holder.direct(SoundEvents.EMPTY), 0, 0, true);
/*    */   
/*    */   private static Holder<SoundEvent> variableSoundRangeEvent(String id) {
/* 48 */     Identifier rid = Minimega.id(id);
/* 49 */     return Holder.direct(SoundEvent.createVariableRangeEvent(rid));
/*    */   }
/*    */   
/*    */   public static void init() {}
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\init\ModSounds.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */