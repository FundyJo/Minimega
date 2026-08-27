/*    */ package dev.jab125.minimega.mod.client.worldgen;
/*    */ 
/*    */ import it.unimi.dsi.fastutil.Pair;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.world.level.chunk.LevelChunk;
/*    */ import xyz.nucleoid.map_templates.MapTemplate;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends ClientsideChunkGenerator
/*    */ {
/*    */   null(ClientLevel level, MapTemplate template) {
/* 55 */     super(level, template);
/*    */   }
/*    */   public Pair<List<LevelChunk>, ClientsideChunkGenerator.ProgressIndicator> getEntireMap() {
/* 58 */     return Pair.of(List.of(), () -> 1.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\worldgen\ClientsideChunkGenerator$1.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */