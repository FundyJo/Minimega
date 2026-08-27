/*     */ package dev.jab125.minimega.mod.util;
/*     */ 
/*     */ import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*     */ import dev.jab125.minimega.mod.util.controller.battle.BattleMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.fistfight.FistfightMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.glide.GlideMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.lobby.LobbyMinigameController;
/*     */ import dev.jab125.minimega.mod.util.controller.tumble.TumbleMinigameController;
/*     */ import java.util.List;
/*     */ import java.util.function.Function;
/*     */ 
/*     */ public class Minigame<T extends AbstractMinigameController<T>>
/*     */ {
/*  15 */   public static final Minigame<AbstractMinigameController.NoneMinigameController> NONE = new Minigame(0, dev.jab125.minimega.mod.util.controller.AbstractMinigameController.NoneMinigameController::new, 1.0F, true);
/*  16 */   public static final Minigame<BattleMinigameController> BATTLE = new Minigame(1, BattleMinigameController::new, 0.67F, true);
/*  17 */   public static final Minigame<TumbleMinigameController> TUMBLE = new Minigame(2, TumbleMinigameController::new, 0.32F, false);
/*  18 */   public static final Minigame<GlideMinigameController> GLIDE = new Minigame(3, GlideMinigameController::new, 0.93F, true);
/*  19 */   public static final Minigame<FistfightMinigameController> FISTFIGHT = new Minigame(70, FistfightMinigameController::new, 1.0F, true);
/*  20 */   public static final Minigame<LobbyMinigameController> LOBBY = new Minigame(99, LobbyMinigameController::new, 0.75F, true);
/*     */   
/*     */   private final int id;
/*     */   private final Function<MinigamesController, T> controllerSupplier;
/*     */   private final float progress;
/*     */   private final boolean playable;
/*     */   
/*     */   Minigame(int id, Function<MinigamesController, T> controllerSupplier, float progress, boolean playable) {
/*  28 */     this.id = id;
/*  29 */     this.controllerSupplier = controllerSupplier;
/*  30 */     this.progress = progress;
/*  31 */     this.playable = playable;
/*     */   }
/*     */   
/*     */   public int getId() {
/*  35 */     return this.id;
/*     */   }
/*     */   
/*     */   public float getProgress() {
/*  39 */     return this.progress;
/*     */   }
/*     */   
/*     */   public boolean isPlayable() {
/*  43 */     return this.playable;
/*     */   }
/*     */ 
/*     */   
/*     */   public static <T extends AbstractMinigameController<T>> Minigame<T> fromId(int id) {
/*  48 */     switch (id) { case 0: 
/*     */       case 1: 
/*     */       case 2: 
/*     */       case 3: 
/*     */       case 70:
/*     */       
/*     */       case 99:
/*  55 */        }  throw new IllegalStateException("Unexpected value: " + id);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends AbstractMinigameController<T>> Minigame<T> fromId(String id) {
/*  61 */     switch (id) { case "none": 
/*     */       case "battle": 
/*     */       case "tumble": 
/*     */       case "glide": 
/*     */       case "fistfight":
/*     */       
/*     */       case "lobby":
/*  68 */        }  throw new IllegalStateException("Unexpected value: " + id);
/*     */   }
/*     */ 
/*     */   
/*     */   public T newController(MinigamesController controller) {
/*  73 */     return this.controllerSupplier.apply(controller);
/*     */   }
/*     */   
/*     */   public String getName() {
/*  77 */     switch (this.id) { case 0: 
/*     */       case 1: 
/*     */       case 2: 
/*     */       case 3: 
/*     */       case 70:
/*     */       
/*     */       case 99:
/*  84 */        }  throw new IllegalStateException("Unexpected value: " + this.id);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  90 */     return "Minigame[" + getName() + "]";
/*     */   }
/*     */   
/*     */   public boolean isActualMinigame() {
/*  94 */     return (this != NONE && this != LOBBY);
/*     */   }
/*     */   
/*     */   public String tId() {
/*  98 */     switch (this.id) { case 0: 
/*     */       case 1: 
/*     */       case 2: 
/*     */       case 3: 
/*     */       case 70:
/*     */       
/*     */       case 99:
/* 105 */        }  throw new IllegalStateException("Unexpected value: " + this.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Iterable<Minigame<? extends AbstractMinigameController<?>>> iterable() {
/* 110 */     return (Iterable)List.of(BATTLE, GLIDE, FISTFIGHT, LOBBY);
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\Minigame.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */