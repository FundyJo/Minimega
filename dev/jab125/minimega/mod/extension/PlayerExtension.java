package dev.jab125.minimega.mod.extension;

import dev.jab125.minimega.mod.annotations.ServerSide;
import dev.jab125.minimega.mod.p2p.matchmaking.obj.S2CPlayerInfoObj;
import dev.jab125.minimega.mod.util.joindata.CreateOrJoin;
import net.minecraft.world.phys.AABB;

public interface PlayerExtension {
  void mm$setGlideHealth(int paramInt);
  
  int mm$getGlideHealth();
  
  @ServerSide
  S2CPlayerInfoObj mm$getMatchmakingServerInfo();
  
  @ServerSide
  void mm$setMatchmakingServerInfo(S2CPlayerInfoObj paramS2CPlayerInfoObj);
  
  CreateOrJoin mm$getMinigameData();
  
  void mm$setMinigameData(CreateOrJoin paramCreateOrJoin);
  
  void mm$setFirstMarker();
  
  boolean mm$firstPop();
  
  AABB mm$getCurrentPlayerBoundsVolume();
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\extension\PlayerExtension.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */