/*    */ package dev.jab125.minimega.mod.extension;
/*    */ 
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import dev.jab125.minimega.mod.party.MinigameParty;
/*    */ import dev.jab125.minimega.mod.util.HostingMethod;
/*    */ import dev.jab125.minimega.mod.util.minigamedata.MinigameData;
/*    */ import java.util.List;
/*    */ import java.util.Optional;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import org.jetbrains.annotations.Nullable;
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
/*    */ public interface MinecraftServerExtension
/*    */ {
/*    */   default Optional<MinigameParty> getLevelParty(ServerLevel level) {
/* 38 */     return getMinigamePartyList().stream().filter(party -> (party.getPartyLevel() == level)).findFirst();
/*    */   }
/*    */   
/*    */   default Optional<MinigameParty> getPartyFromPlayerUUID(UUID uuid) {
/* 42 */     return getMinigamePartyList().stream().filter(a -> a.contains(uuid)).findFirst();
/*    */   }
/*    */   
/*    */   void mm$setMMIP(String paramString, int paramInt);
/*    */   
/*    */   String mm$getIp();
/*    */   
/*    */   int mm$getPort();
/*    */   
/*    */   void mm$clearMMIP();
/*    */   
/*    */   boolean mm$p2p();
/*    */   
/*    */   @Nullable
/*    */   MinigameData mm$getData();
/*    */   
/*    */   void mm$setData(MinigameData paramMinigameData);
/*    */   
/*    */   HostingMethod mm$getHostingMethod(Minimega.WWWTicket paramWWWTicket);
/*    */   
/*    */   List<MinigameParty> getMinigamePartyList();
/*    */   
/*    */   MinigameParty createMinigameParty(MinigameData paramMinigameData);
/*    */   
/*    */   MinigameParty createMinigamePartyBasedInLobby(MinigameData paramMinigameData);
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\extension\MinecraftServerExtension.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */