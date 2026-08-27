/*    */ package dev.jab125.minimega.mod.mixin.grf;
/*    */ 
/*    */ import dev.jab125.minimega.grf.GrfContainer;
/*    */ import dev.jab125.minimega.grf.RootHolder;
/*    */ import dev.jab125.minimega.grf.TemporaryGrfStuff;
/*    */ import dev.jab125.minimega.grf.newelements.mxml.grf.__ROOT__;
/*    */ import dev.jab125.minimega.mod.extension.ServerLevelExtension;
/*    */ import dev.jab125.minimega.mod.tools.MinimegaModTools;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.Executor;
/*    */ import javax.xml.parsers.ParserConfigurationException;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.dimension.LevelStem;
/*    */ import net.minecraft.world.level.storage.LevelStorageSource;
/*    */ import net.minecraft.world.level.storage.ServerLevelData;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Mutable;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.xml.sax.SAXException;
/*    */ 
/*    */ @Mixin({ServerLevel.class})
/*    */ public class ServerLevelMixin implements GrfContainer, RootHolder, ServerLevelExtension {
/*    */   @Unique
/*    */   @Final
/*    */   @Mutable
/*    */   private __ROOT__ grf;
/*    */   
/*    */   @Inject(method = {"<init>"}, at = {@At("RETURN")})
/*    */   void init(MinecraftServer server, Executor executor, LevelStorageSource.LevelStorageAccess levelStorage, ServerLevelData levelData, ResourceKey<Level> dimension, LevelStem levelStem, boolean isDebug, long biomeZoomSeed, List customSpawners, boolean tickTime, CallbackInfo ci) throws IOException, ParserConfigurationException, SAXException {
/* 40 */     this.grf = null;
/* 41 */     this.grf = MinimegaModTools.getFrom(dimension, levelStorage);
/* 42 */     this.grfPath = levelStorage.getDimensionPath(dimension).resolve("gamerulefile.xml");
/*    */   } @Final
/*    */   @Mutable
/*    */   private Path grfPath;
/*    */   public __ROOT__ getGrf() {
/* 47 */     return this.grf;
/*    */   }
/*    */ 
/*    */   
/*    */   public __ROOT__ getRoot() {
/* 52 */     return this.grf;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setRoot(__ROOT__ root) {
/* 57 */     this.grf = root;
/* 58 */     for (ServerPlayer player : ((ServerLevel)this).players()) {
/* 59 */       TemporaryGrfStuff.sendGrfToPlayer(player, (ServerLevel)this);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public Path getGrfPath() {
/* 65 */     return this.grfPath;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\grf\ServerLevelMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */