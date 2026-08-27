package dev.jab125.minimega.mod.client.gui.widget.leaderboard;

import java.time.Duration;
import java.util.Optional;

public interface IPlayerTracker {
  String getPlayerName();
  
  int getPlayerPosition();
  
  @Deprecated
  Optional<Duration> getPlayerTime();
  
  Optional<Integer> getPlayerScore();
  
  int minimegaProtocolVersion();
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\widget\leaderboard\IPlayerTracker.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */