package dev.jab125.minimega.mod.extension;

import dev.jab125.minimega.mod.party.MinigameParty;
import dev.jab125.minimega.mod.util.joindata.CreateOrJoin;

public interface PrepareSpawnTaskExtension {
  void mm$setMinigameData(CreateOrJoin paramCreateOrJoin);
  
  CreateOrJoin mm$getMinigameData();
  
  MinigameParty.PlayerSlot mm$playerSlot();
  
  MinigameParty mm$getParty();
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\extension\PrepareSpawnTaskExtension.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */