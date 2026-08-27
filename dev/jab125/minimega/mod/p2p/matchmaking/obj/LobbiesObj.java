/*    */ package dev.jab125.minimega.mod.p2p.matchmaking.obj;
/*    */ 
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ 
/*    */ public final class LobbiesObj extends Record implements CodecObj<LobbiesObj> {
/*    */   private final List<Lobby> lobbies;
/*    */   public static final Codec<LobbiesObj> CODEC;
/*    */   
/* 11 */   public LobbiesObj(List<Lobby> lobbies) { this.lobbies = lobbies; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/LobbiesObj;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/LobbiesObj; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/LobbiesObj;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/LobbiesObj; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/LobbiesObj;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/LobbiesObj;
/* 11 */     //   0	8	1	o	Ljava/lang/Object; } public List<Lobby> lobbies() { return this.lobbies; } static {
/* 12 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Lobby.CODEC.listOf().fieldOf("lobbies").forGetter(LobbiesObj::lobbies)).apply((Applicative)instance, LobbiesObj::new));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Codec<LobbiesObj> codec() {
/* 18 */     return CODEC;
/*    */   } public static final class Lobby extends Record {
/*    */     private final UUID host; private final String ip; private final int port; private final String minecraftVersion; private final String minimegaVersion; private final int minecraftProtocolVersion; private final int minimegaProtocolVersion;
/* 21 */     public Lobby(UUID host, String ip, int port, String minecraftVersion, String minimegaVersion, int minecraftProtocolVersion, int minimegaProtocolVersion, boolean legacy4j, boolean _public, int minigame, int mode, int playersOnline, int maxPlayers) { this.host = host; this.ip = ip; this.port = port; this.minecraftVersion = minecraftVersion; this.minimegaVersion = minimegaVersion; this.minecraftProtocolVersion = minecraftProtocolVersion; this.minimegaProtocolVersion = minimegaProtocolVersion; this.legacy4j = legacy4j; this._public = _public; this.minigame = minigame; this.mode = mode; this.playersOnline = playersOnline; this.maxPlayers = maxPlayers; } private final boolean legacy4j; private final boolean _public; private final int minigame; private final int mode; private final int playersOnline; private final int maxPlayers; private static final Codec<UUID> STRING_CODEC; public static final Codec<Lobby> CODEC; public final String toString() { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/LobbiesObj$Lobby;)Ljava/lang/String;
/*    */       //   6: areturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #21	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/LobbiesObj$Lobby; } public final int hashCode() { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/LobbiesObj$Lobby;)I
/*    */       //   6: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #21	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/LobbiesObj$Lobby; } public final boolean equals(Object o) { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: aload_1
/*    */       //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/LobbiesObj$Lobby;Ljava/lang/Object;)Z
/*    */       //   7: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #21	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	8	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/LobbiesObj$Lobby;
/* 21 */       //   0	8	1	o	Ljava/lang/Object; } public UUID host() { return this.host; } public String ip() { return this.ip; } public int port() { return this.port; } public String minecraftVersion() { return this.minecraftVersion; } public String minimegaVersion() { return this.minimegaVersion; } public int minecraftProtocolVersion() { return this.minecraftProtocolVersion; } public int minimegaProtocolVersion() { return this.minimegaProtocolVersion; } public boolean legacy4j() { return this.legacy4j; } public boolean _public() { return this._public; } public int minigame() { return this.minigame; } public int mode() { return this.mode; } public int playersOnline() { return this.playersOnline; } public int maxPlayers() { return this.maxPlayers; }
/*    */     
/*    */     static {
/* 24 */       STRING_CODEC = Codec.STRING.comapFlatMap(string -> {
/*    */             try {
/*    */               return DataResult.success(UUID.fromString(string), Lifecycle.stable());
/* 27 */             } catch (IllegalArgumentException var2) {
/*    */               return DataResult.error(());
/*    */             } 
/*    */           }UUID::toString);
/* 31 */       CODEC = RecordCodecBuilder.create(instance -> instance.group((App)STRING_CODEC.fieldOf("host").forGetter(Lobby::host), (App)Codec.STRING.fieldOf("ip").forGetter(Lobby::ip), (App)Codec.INT.fieldOf("port").forGetter(Lobby::port), (App)Codec.STRING.fieldOf("minecraft_version").forGetter(Lobby::minecraftVersion), (App)Codec.STRING.fieldOf("minimega_version").forGetter(Lobby::minimegaVersion), (App)Codec.INT.fieldOf("minecraft_protocol_version").forGetter(Lobby::minecraftProtocolVersion), (App)Codec.INT.fieldOf("minimega_protocol_version").forGetter(Lobby::minimegaProtocolVersion), (App)Codec.BOOL.fieldOf("legacy4j").forGetter(Lobby::legacy4j), (App)Codec.BOOL.fieldOf("public").forGetter(Lobby::_public), (App)Codec.INT.fieldOf("minigame").forGetter(Lobby::minigame), (App)Codec.INT.fieldOf("mode").forGetter(Lobby::mode), (App)Codec.INT.fieldOf("players").forGetter(Lobby::playersOnline), (App)Codec.INT.fieldOf("max_players").forGetter(Lobby::maxPlayers)).apply((Applicative)instance, Lobby::new));
/*    */     }
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
/*    */     public boolean isGlide() {
/* 48 */       return (this.minigame == 3);
/*    */     }
/*    */     
/*    */     public boolean isTimeAttack() {
/* 52 */       return (isGlide() && this.mode == 0);
/*    */     }
/*    */     
/*    */     public boolean isScoreAttack() {
/* 56 */       return (isGlide() && this.mode == 1);
/*    */     }
/*    */     
/*    */     public boolean isValid() {
/* 60 */       return (isGlide() && (isTimeAttack() || isScoreAttack()) && (this.maxPlayers == 16 || this.maxPlayers == 8));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\p2p\matchmaking\obj\LobbiesObj.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */