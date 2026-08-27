/*    */ package dev.jab125.minimega.mod.client.gui.widget.leaderboard;
/*    */ 
/*    */ import dev.jab125.minimega.mod.util.controller.glide.GlideMinigameController;
/*    */ import java.time.Duration;
/*    */ import java.util.Optional;
/*    */ 
/*    */ 
/*    */ public class RemotePlayerTracker
/*    */   implements IPlayerTracker
/*    */ {
/*    */   private final String playerName;
/*    */   private final int ordinal;
/*    */   private final Optional<Duration> duration;
/*    */   private final Optional<Integer> score;
/*    */   
/*    */   public RemotePlayerTracker(GlideMinigameController.PlayerInformation position) {
/* 17 */     this.playerName = position.playerName();
/* 18 */     this.ordinal = position.ordinal();
/* 19 */     this.duration = position.finishTime();
/* 20 */     this.score = position.score();
/*    */   }
/*    */   
/*    */   public String getPlayerName() {
/* 24 */     return this.playerName;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getPlayerPosition() {
/* 29 */     return this.ordinal;
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<Duration> getPlayerTime() {
/* 34 */     return this.duration;
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<Integer> getPlayerScore() {
/* 39 */     return this.score;
/*    */   }
/*    */ 
/*    */   
/*    */   public int minimegaProtocolVersion() {
/* 44 */     return 60503200;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\widget\leaderboard\RemotePlayerTracker.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */