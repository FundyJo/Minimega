/*    */ package dev.jab125.minimega.mod;
/*    */ 
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import com.mojang.datafixers.util.Pair;
/*    */ import java.awt.Color;
/*    */ import java.io.IOException;
/*    */ import java.util.OptionalLong;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import org.jetbrains.annotations.ApiStatus.Experimental;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ public interface IDiscordHandler
/*    */ {
/* 15 */   public static final Color GOOD = Color.GREEN;
/* 16 */   public static final Color BAD = Color.RED;
/* 17 */   public static final Color BLUE = Color.CYAN;
/* 18 */   public static final Color NEUTRAL = Color.GRAY;
/* 19 */   public static final Color SYSTEM = Color.DARK_GRAY;
/* 20 */   public static final Color VICTORY = Color.ORANGE;
/*    */   
/*    */   default boolean isActive() {
/* 23 */     return false;
/*    */   }
/*    */   
/*    */   default String initialCode(GameProfile profile) {
/* 27 */     return "lolthisisnotimplemented";
/*    */   }
/*    */   
/*    */   default String loginCode(Pair<Long, GameProfile> profile) {
/* 31 */     return "lolthisisnotimplemented";
/*    */   }
/*    */   @Nullable
/*    */   default GameProfile gameProfileFromInitialCode(String code) {
/* 35 */     return null;
/*    */   }
/*    */   
/*    */   default GameProfile getGameProfileFromDiscordId(long id) {
/* 39 */     return null;
/*    */   }
/*    */   
/*    */   default OptionalLong discordIdFromGameProfile(GameProfile profile) {
/* 43 */     return OptionalLong.empty();
/*    */   }
/*    */ 
/*    */   
/*    */   default void linkDiscordAndGameProfile(long id, GameProfile profile) {}
/*    */ 
/*    */   
/*    */   default String loginCode(GameProfile gameProfile) {
/* 51 */     return "lolthisisnotimplemented";
/*    */   }
/*    */   @Nullable
/*    */   default Pair<Long, GameProfile> discordIdAndgameProfileFromLoginCode(String code) {
/* 55 */     return null;
/*    */   }
/*    */   @Nullable
/*    */   default GameProfile gameProfileFromLoginCode(String code) {
/* 59 */     return null;
/*    */   }
/*    */   
/*    */   default void savePersistentData() throws IOException {}
/*    */   
/*    */   default void loadPersistentData() throws IOException {}
/*    */   
/*    */   default void relaySystemMessageToDiscord(Color color, Component component) {}
/*    */   
/*    */   @Experimental
/*    */   default void relayDiscordMessageToServer(String userNicknameOrDisplayName, String actualUsername, @Nullable Color roleColor, long userId, String text) {}
/*    */   
/*    */   default void accept(MinecraftServer server) {}
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\IDiscordHandler.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */