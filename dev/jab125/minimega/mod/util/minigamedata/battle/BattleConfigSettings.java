package dev.jab125.minimega.mod.util.minigamedata.battle;

public interface BattleConfigSettings {
  RoundLength roundLength();
  
  boolean centralSpawn();
  
  Lives livesPerRound();
  
  SpectatorMode spectatorMode();
  
  boolean allowAllSkins();
  
  ItemSet itemSet();
  
  HungerSettings hungerSettings();
  
  int roundCount();
  
  MapSize mapSize();
  
  boolean naturalRegeneration();
  
  boolean smallInventory();
  
  boolean takeEverything();
  
  boolean chestRefill();
  
  boolean shortSneaking();
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\minigamedata\battle\BattleConfigSettings.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */