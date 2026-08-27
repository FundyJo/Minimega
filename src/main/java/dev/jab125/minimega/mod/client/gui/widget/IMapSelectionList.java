/*    */ package dev.jab125.minimega.mod.client.gui.widget;
/*    */ 
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import dev.jab125.minimega.mod.data.MapInfo;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import java.util.List;
/*    */ import java.util.Optional;
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IMapSelectionList
/*    */ {
/*    */   default void addDefaultMapInfos(Minigame<?> minigame) {
/* 14 */     mapInfos().stream().filter(a -> (a.minigame() == minigame)).forEach(this::putMapInfo);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static List<MapInfo> leaderboardGlideMaps() {
/* 53 */     return List.of(new MapInfo[] { new MapInfo(
/* 54 */             Minimega.id("celts"), Minigame.GLIDE, "vanilla", Optional.empty()), new MapInfo(
/* 55 */             Minimega.id("icarus"), Minigame.GLIDE, "greek_mythology", Optional.empty()), new MapInfo(
/* 56 */             Minimega.id("excalibur"), Minigame.GLIDE, "fantasy", Optional.empty()), new MapInfo(
/* 57 */             Minimega.id("canyon"), Minigame.GLIDE, "vanilla", Optional.empty()), new MapInfo(
/* 58 */             Minimega.id("mobs"), Minigame.GLIDE, "vanilla", Optional.empty()), new MapInfo(
/* 59 */             Minimega.id("body"), Minigame.GLIDE, "vanilla", Optional.empty()), new MapInfo(
/* 60 */             Minimega.id("shrunk"), Minigame.GLIDE, "plastic", Optional.empty()), new MapInfo(
/* 61 */             Minimega.id("dragon"), Minigame.GLIDE, "chinese_mythology", Optional.empty()), new MapInfo(
/* 62 */             Minimega.id("kraken"), Minigame.GLIDE, "vanilla", Optional.empty()), new MapInfo(
/* 63 */             Minimega.id("yeti"), Minigame.GLIDE, "vanilla", Optional.empty()), new MapInfo(
/* 64 */             Minimega.id("temple"), Minigame.GLIDE, "vanilla", Optional.empty()), new MapInfo(
/* 65 */             Minimega.id("cavern"), Minigame.GLIDE, "vanilla", Optional.empty()), new MapInfo(
/* 66 */             Minimega.id("lighthouse"), Minigame.GLIDE, "vanilla", Optional.empty()) });
/*    */   }
/*    */   
/*    */   void putMapInfo(MapInfo paramMapInfo);
/*    */   
/*    */   void selectAll();
/*    */   
/*    */   void deselectAll();
/*    */   
/*    */   List<MapInfo> mapInfos();
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\widget\IMapSelectionList.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */