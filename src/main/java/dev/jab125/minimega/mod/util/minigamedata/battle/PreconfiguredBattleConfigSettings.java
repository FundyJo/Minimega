/*    */ package dev.jab125.minimega.mod.util.minigamedata.battle;
/*    */ 
/*    */ public interface PreconfiguredBattleConfigSettings
/*    */   extends BattleConfigSettings {
/*    */   default Lives livesPerRound() {
/*  6 */     return new Lives.Numbered(1);
/*    */   }
/*    */ 
/*    */   
/*    */   default ItemSet itemSet() {
/* 11 */     return ItemSet.NORMAL;
/*    */   }
/*    */ 
/*    */   
/*    */   default HungerSettings hungerSettings() {
/* 16 */     return HungerSettings.NORMAL;
/*    */   }
/*    */ 
/*    */   
/*    */   default int roundCount() {
/* 21 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   default boolean naturalRegeneration() {
/* 26 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   default boolean smallInventory() {
/* 31 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   default boolean takeEverything() {
/* 36 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   default boolean chestRefill() {
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\minigamedata\battle\PreconfiguredBattleConfigSettings.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */