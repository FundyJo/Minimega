/*    */ package dev.jab125.minimega.mod.client.gui.widget.leaderboard;
/*    */ 
/*    */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.leaderboards.GlideMatchRecordObj;
/*    */ import java.time.Duration;
/*    */ import java.util.Optional;
/*    */ 
/*    */ public class LeaderboardPlayerTracker
/*    */   implements IPlayerTracker
/*    */ {
/*    */   private final GlideMatchRecordObj obj;
/*    */   
/*    */   public LeaderboardPlayerTracker(GlideMatchRecordObj obj) {
/* 13 */     this.obj = obj;
/*    */   }
/*    */   
/*    */   public String getPlayerName() {
/* 17 */     return this.obj.displayName();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getPlayerPosition() {
/* 22 */     return this.obj.place();
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<Duration> getPlayerTime() {
/* 27 */     return this.obj.duration();
/*    */   }
/*    */ 
/*    */   
/*    */   public Optional<Integer> getPlayerScore() {
/* 32 */     return this.obj.score();
/*    */   }
/*    */ 
/*    */   
/*    */   public int minimegaProtocolVersion() {
/* 37 */     return this.obj.protocolVersion();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\widget\leaderboard\LeaderboardPlayerTracker.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */