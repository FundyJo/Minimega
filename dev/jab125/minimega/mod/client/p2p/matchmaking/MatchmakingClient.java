/*     */ package dev.jab125.minimega.mod.client.p2p.matchmaking;
/*     */ 
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.mojang.authlib.HttpAuthenticationService;
/*     */ import com.mojang.authlib.exceptions.AuthenticationException;
/*     */ import com.mojang.authlib.exceptions.MinecraftClientException;
/*     */ import com.mojang.serialization.DynamicOps;
/*     */ import com.mojang.serialization.JsonOps;
/*     */ import dev.jab125.minimega.call.Error;
/*     */ import dev.jab125.minimega.call.Ok;
/*     */ import dev.jab125.minimega.call.Result;
/*     */ import dev.jab125.minimega.mod.Minimega;
/*     */ import dev.jab125.minimega.mod.client.gui.screen.AccessScreen;
/*     */ import dev.jab125.minimega.mod.client.gui.screen.LinkScreen;
/*     */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.AccessTokenObj;
/*     */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.C2SPlayerInfoObj;
/*     */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.ErrorObj;
/*     */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.LobbiesObj;
/*     */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.S2CPlayerInfoObj;
/*     */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.SupportedObj;
/*     */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.featureflags.FeatureFlagsObj;
/*     */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.featureflags.SubmitCodeObj;
/*     */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.friends.FriendsObj;
/*     */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.friends.UpdateFriendsObj;
/*     */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.leaderboards.GlideMatchRecordObj;
/*     */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.leaderboards.c2s.FetchGlideMatchesObj;
/*     */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.leaderboards.c2s.SubmitGlideMatchObj;
/*     */ import dev.jab125.minimega.mod.p2p.matchmaking.obj.leaderboards.s2c.ReceivedGlideMatchesObj;
/*     */ import dev.jab125.minimega.mod.util.controller.glide.GlideGameType;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.ProtocolException;
/*     */ import java.net.Proxy;
/*     */ import java.net.URL;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.security.SecureRandom;
/*     */ import java.time.Duration;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.CompletableFuture;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.components.toasts.SystemToast;
/*     */ import net.minecraft.client.gui.screens.DisconnectedScreen;
/*     */ import net.minecraft.client.gui.screens.Screen;
/*     */ import net.minecraft.client.gui.screens.TitleScreen;
/*     */ import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
/*     */ import net.minecraft.network.DisconnectionDetails;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.resources.Identifier;
/*     */ import net.minecraft.server.players.NameAndId;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MatchmakingClient
/*     */ {
/*     */   private final String serverBaseUrl;
/*     */   private final URL adUrl;
/*     */   private final URL tokenUrl;
/*     */   private final URL linkUrl;
/*     */   private final URL pullAdUrl;
/*     */   private final URL lobbiesUrl;
/*     */   private final URL playableUrl;
/*     */   private final URL playerInfoUrl;
/*     */   private final URL submitToLeaderboardsUrl;
/*     */   private final URL fetchFromLeaderboardsUrl;
/*     */   private final URL fetchFeatureFlagsUrl;
/*     */   private final URL updateFriendsUrl;
/*     */   private final URL fetchFriendsUrl;
/*     */   private final URL submitFeatureFlagsUrl;
/*     */   
/*     */   @Nullable
/*     */   public static MatchmakingClient create() {
/*  96 */     String figureoutmatchmakingserverbaseurl = figureoutmatchmakingserverbaseurl();
/*  97 */     if (figureoutmatchmakingserverbaseurl == null) return null; 
/*  98 */     return new MatchmakingClient(figureoutmatchmakingserverbaseurl);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String figureoutmatchmakingserverbaseurl() {
/*     */     try {
/* 124 */       URL url = HttpAuthenticationService.constantURL("https://raw.githubusercontent.com/Jab125/Jab125/refs/heads/main/minimegamatchmaking2");
/* 125 */       String strip = (new String(createUrlConnection(url).getInputStream().readAllBytes())).strip();
/* 126 */       strip = strip.replace("\r\n", "").replace("\n", "").strip();
/* 127 */       return strip;
/* 128 */     } catch (Throwable t) {
/* 129 */       t.printStackTrace();
/* 130 */       return null;
/*     */     } 
/*     */   }
/*     */   public static void sslsetup() {}
/*     */   public boolean isAuthted() {
/*     */     return (this.token != null);
/*     */   }
/*     */   public boolean authing() {
/*     */     return isInAuthScreen;
/*     */   }
/*     */   public static <T> CompletableFuture<T> async(Sup<T> sup) {
/*     */     if (isInAuthScreen)
/*     */       return CompletableFuture.failedFuture(new RuntimeException(":(")); 
/*     */     return CompletableFuture.supplyAsync(() -> {
/*     */           try {
/*     */             return sup.get();
/*     */           } catch (Throwable e) {
/*     */             throw new RuntimeException(e);
/*     */           } 
/*     */         });
/*     */   }
/*     */   public static CompletableFuture<Void> asyncG(Rup rup) {
/*     */     if (isInAuthScreen)
/*     */       return CompletableFuture.failedFuture(new RuntimeException(":(")); 
/*     */     return CompletableFuture.runAsync(() -> {
/*     */           try {
/*     */             rup.run();
/*     */           } catch (Throwable e) {
/*     */             throw new RuntimeException(e);
/*     */           } 
/*     */         });
/*     */   }
/*     */   public Result<Result.Unit, IOException> advertiseServer() {
/*     */     return Result.wrapRun(() -> {
/*     */           // Byte code:
/*     */           //   0: invokestatic getInstance : ()Lnet/minecraft/client/Minecraft;
/*     */           //   3: invokevirtual getSingleplayerServer : ()Lnet/minecraft/client/server/IntegratedServer;
/*     */           //   6: astore_1
/*     */           //   7: aload_1
/*     */           //   8: ifnonnull -> 12
/*     */           //   11: return
/*     */           //   12: aload_1
/*     */           //   13: checkcast dev/jab125/minimega/mod/extension/MinecraftServerExtension
/*     */           //   16: astore_2
/*     */           //   17: aload_2
/*     */           //   18: invokeinterface mm$p2p : ()Z
/*     */           //   23: ifne -> 27
/*     */           //   26: return
/*     */           //   27: aload_2
/*     */           //   28: invokeinterface mm$getData : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;
/*     */           //   33: astore_3
/*     */           //   34: aload_3
/*     */           //   35: ifnonnull -> 39
/*     */           //   38: return
/*     */           //   39: new dev/jab125/minimega/mod/p2p/matchmaking/obj/AdInfoObj
/*     */           //   42: dup
/*     */           //   43: aload_2
/*     */           //   44: invokeinterface mm$getIp : ()Ljava/lang/String;
/*     */           //   49: aload_2
/*     */           //   50: invokeinterface mm$getPort : ()I
/*     */           //   55: aload_1
/*     */           //   56: invokevirtual getServerVersion : ()Ljava/lang/String;
/*     */           //   59: invokestatic getFriendlyVersion : ()Ljava/lang/String;
/*     */           //   62: invokestatic getProtocolVersion : ()I
/*     */           //   65: ldc_w 60503200
/*     */           //   68: invokestatic isLegacy4jInstalled : ()Z
/*     */           //   71: aload_3
/*     */           //   72: invokevirtual public_ : ()Z
/*     */           //   75: aload_3
/*     */           //   76: invokevirtual minigame : ()Ldev/jab125/minimega/mod/util/Minigame;
/*     */           //   79: invokevirtual getId : ()I
/*     */           //   82: aload_3
/*     */           //   83: invokevirtual config : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;
/*     */           //   86: dup
/*     */           //   87: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */           //   90: pop
/*     */           //   91: astore #5
/*     */           //   93: iconst_0
/*     */           //   94: istore #6
/*     */           //   96: aload #5
/*     */           //   98: iload #6
/*     */           //   100: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;I)I
/*     */           //   105: lookupswitch default -> 254, 0 -> 132, 1 -> 165
/*     */           //   132: aload #5
/*     */           //   134: checkcast dev/jab125/minimega/mod/util/minigamedata/GlideConfig
/*     */           //   137: astore #7
/*     */           //   139: aload #7
/*     */           //   141: invokevirtual type : ()Ldev/jab125/minimega/mod/util/controller/glide/GlideGameType;
/*     */           //   144: astore #9
/*     */           //   146: aload #9
/*     */           //   148: astore #8
/*     */           //   150: aload #7
/*     */           //   152: invokevirtual solo : ()Z
/*     */           //   155: istore #9
/*     */           //   157: aload #8
/*     */           //   159: invokevirtual ordinal : ()I
/*     */           //   162: goto -> 255
/*     */           //   165: aload #5
/*     */           //   167: checkcast dev/jab125/minimega/mod/util/minigamedata/BattleConfig
/*     */           //   170: astore #9
/*     */           //   172: aload #9
/*     */           //   174: invokevirtual settings : ()Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*     */           //   177: astore #11
/*     */           //   179: aload #11
/*     */           //   181: astore #10
/*     */           //   183: aload #10
/*     */           //   185: dup
/*     */           //   186: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */           //   189: pop
/*     */           //   190: astore #11
/*     */           //   192: iconst_0
/*     */           //   193: istore #12
/*     */           //   195: aload #11
/*     */           //   197: iload #12
/*     */           //   199: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;I)I
/*     */           //   204: tableswitch default -> 232, 0 -> 242, 1 -> 246, 2 -> 250
/*     */           //   232: new java/lang/MatchException
/*     */           //   235: dup
/*     */           //   236: aconst_null
/*     */           //   237: aconst_null
/*     */           //   238: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */           //   241: athrow
/*     */           //   242: iconst_0
/*     */           //   243: goto -> 251
/*     */           //   246: iconst_1
/*     */           //   247: goto -> 251
/*     */           //   250: iconst_2
/*     */           //   251: goto -> 255
/*     */           //   254: iconst_0
/*     */           //   255: aload_1
/*     */           //   256: invokevirtual getPlayerCount : ()I
/*     */           //   259: aload_3
/*     */           //   260: invokevirtual maxPlayers : ()I
/*     */           //   263: invokespecial <init> : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIZZIIII)V
/*     */           //   266: astore #4
/*     */           //   268: aload_0
/*     */           //   269: getfield adUrl : Ljava/net/URL;
/*     */           //   272: invokestatic createUrlConnection : (Ljava/net/URL;)Ljava/net/HttpURLConnection;
/*     */           //   275: astore #5
/*     */           //   277: aload #5
/*     */           //   279: iconst_1
/*     */           //   280: invokevirtual setDoOutput : (Z)V
/*     */           //   283: getstatic dev/jab125/minimega/mod/p2p/matchmaking/obj/AdInfoObj.CODEC : Lcom/mojang/serialization/Codec;
/*     */           //   286: getstatic com/mojang/serialization/JsonOps.INSTANCE : Lcom/mojang/serialization/JsonOps;
/*     */           //   289: aload #4
/*     */           //   291: invokeinterface encodeStart : (Lcom/mojang/serialization/DynamicOps;Ljava/lang/Object;)Lcom/mojang/serialization/DataResult;
/*     */           //   296: getstatic dev/jab125/minimega/mod/Minimega.LOGGER : Lorg/slf4j/Logger;
/*     */           //   299: dup
/*     */           //   300: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */           //   303: pop
/*     */           //   304: <illegal opcode> accept : (Lorg/slf4j/Logger;)Ljava/util/function/Consumer;
/*     */           //   309: invokeinterface resultOrPartial : (Ljava/util/function/Consumer;)Ljava/util/Optional;
/*     */           //   314: invokevirtual orElseThrow : ()Ljava/lang/Object;
/*     */           //   317: checkcast com/google/gson/JsonElement
/*     */           //   320: invokevirtual getAsJsonObject : ()Lcom/google/gson/JsonObject;
/*     */           //   323: astore #6
/*     */           //   325: aload_0
/*     */           //   326: aload #6
/*     */           //   328: invokevirtual writeAuth : (Lcom/google/gson/JsonObject;)V
/*     */           //   331: aload #6
/*     */           //   333: invokevirtual toString : ()Ljava/lang/String;
/*     */           //   336: astore #7
/*     */           //   338: iconst_1
/*     */           //   339: anewarray java/lang/Object
/*     */           //   342: dup
/*     */           //   343: iconst_0
/*     */           //   344: aload #6
/*     */           //   346: aastore
/*     */           //   347: invokestatic println : ([Ljava/lang/Object;)V
/*     */           //   350: aload #7
/*     */           //   352: getstatic java/nio/charset/StandardCharsets.UTF_8 : Ljava/nio/charset/Charset;
/*     */           //   355: invokevirtual getBytes : (Ljava/nio/charset/Charset;)[B
/*     */           //   358: astore #8
/*     */           //   360: aload #5
/*     */           //   362: ldc_w 'Content-Length'
/*     */           //   365: aload #8
/*     */           //   367: arraylength
/*     */           //   368: <illegal opcode> makeConcatWithConstants : (I)Ljava/lang/String;
/*     */           //   373: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
/*     */           //   376: aload #5
/*     */           //   378: ldc_w 'POST'
/*     */           //   381: invokevirtual setRequestMethod : (Ljava/lang/String;)V
/*     */           //   384: aload #5
/*     */           //   386: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
/*     */           //   389: aload #8
/*     */           //   391: invokevirtual write : ([B)V
/*     */           //   394: aload #5
/*     */           //   396: invokevirtual getResponseCode : ()I
/*     */           //   399: istore #9
/*     */           //   401: goto -> 421
/*     */           //   404: astore #10
/*     */           //   406: new java/lang/MatchException
/*     */           //   409: dup
/*     */           //   410: aload #10
/*     */           //   412: invokevirtual toString : ()Ljava/lang/String;
/*     */           //   415: aload #10
/*     */           //   417: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */           //   420: athrow
/*     */           //   421: return
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #200	-> 0
/*     */           //   #201	-> 7
/*     */           //   #202	-> 12
/*     */           //   #203	-> 17
/*     */           //   #204	-> 27
/*     */           //   #205	-> 34
/*     */           //   #206	-> 39
/*     */           //   #207	-> 268
/*     */           //   #208	-> 277
/*     */           //   #209	-> 283
/*     */           //   #210	-> 325
/*     */           //   #211	-> 331
/*     */           //   #212	-> 338
/*     */           //   #213	-> 350
/*     */           //   #214	-> 360
/*     */           //   #215	-> 376
/*     */           //   #216	-> 384
/*     */           //   #217	-> 394
/*     */           //   #206	-> 404
/*     */           //   #218	-> 421
/*     */           // Local variable table:
/*     */           //   start	length	slot	name	descriptor
/*     */           //   146	4	9	patt4$temp	Ldev/jab125/minimega/mod/util/controller/glide/GlideGameType;
/*     */           //   139	26	7	$b$0	Ldev/jab125/minimega/mod/util/minigamedata/GlideConfig;
/*     */           //   150	15	8	type	Ldev/jab125/minimega/mod/util/controller/glide/GlideGameType;
/*     */           //   179	4	11	patt6$temp	Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*     */           //   192	59	11	selector7$temp	Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*     */           //   195	56	12	index$8	I
/*     */           //   172	82	9	$b$1	Ldev/jab125/minimega/mod/util/minigamedata/BattleConfig;
/*     */           //   183	71	10	settings	Ldev/jab125/minimega/mod/util/minigamedata/battle/BattleConfigSettings;
/*     */           //   93	162	5	selector2$temp	Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;
/*     */           //   96	159	6	index$3	I
/*     */           //   7	397	1	singleplayerServer	Lnet/minecraft/client/server/IntegratedServer;
/*     */           //   17	387	2	extension	Ldev/jab125/minimega/mod/extension/MinecraftServerExtension;
/*     */           //   34	370	3	minigameData	Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;
/*     */           //   268	136	4	adInfo	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/AdInfoObj;
/*     */           //   277	127	5	urlConnection	Ljava/net/HttpURLConnection;
/*     */           //   325	79	6	jsonElement	Lcom/google/gson/JsonObject;
/*     */           //   338	66	7	string	Ljava/lang/String;
/*     */           //   360	44	8	bytes	[B
/*     */           //   401	3	9	responseCode	I
/*     */           //   0	422	0	this	Ldev/jab125/minimega/mod/client/p2p/matchmaking/MatchmakingClient;
/*     */           //   421	1	1	singleplayerServer	Lnet/minecraft/client/server/IntegratedServer;
/*     */           //   421	1	2	extension	Ldev/jab125/minimega/mod/extension/MinecraftServerExtension;
/*     */           //   421	1	3	minigameData	Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;
/*     */           //   421	1	4	adInfo	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/AdInfoObj;
/*     */           //   421	1	5	urlConnection	Ljava/net/HttpURLConnection;
/*     */           //   421	1	6	jsonElement	Lcom/google/gson/JsonObject;
/*     */           //   421	1	7	string	Ljava/lang/String;
/*     */           //   421	1	8	bytes	[B
/*     */           //   421	1	9	responseCode	I
/*     */           // Exception table:
/*     */           //   from	to	target	type
/*     */           //   141	144	404	java/lang/Throwable
/*     */           //   152	155	404	java/lang/Throwable
/*     */           //   174	177	404	java/lang/Throwable
/*     */         }(Throwable[])new IOException[0]);
/*     */   }
/*     */   public Result<LobbiesObj, IOException> getPublicServers() {
/*     */     return Result.wrapGet(() -> {
/*     */           HttpURLConnection urlConnection = createUrlConnection(this.lobbiesUrl);
/*     */           urlConnection.setDoOutput(true);
/*     */           JsonObject jsonElement = new JsonObject();
/*     */           writeAuth(jsonElement);
/*     */           String string = jsonElement.toString();
/*     */           DEBUG.println(new Object[] { jsonElement }, );
/*     */           byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
/*     */           urlConnection.setRequestProperty("Content-Length", "" + bytes.length);
/*     */           urlConnection.setRequestMethod("POST");
/*     */           urlConnection.getOutputStream().write(bytes);
/*     */           int responseCode = urlConnection.getResponseCode();
/*     */           Minimega.LOGGER.debug("response code: " + responseCode);
/*     */           byte[] bytes2 = urlConnection.getInputStream().readAllBytes();
/*     */           String s = new String(bytes2);
/*     */           JsonElement jsonElement2 = (JsonElement)(new Gson()).fromJson(s, JsonElement.class);
/*     */           Objects.requireNonNull(Minimega.LOGGER);
/*     */           return LobbiesObj.CODEC.parse((DynamicOps)JsonOps.INSTANCE, jsonElement2).resultOrPartial(Minimega.LOGGER::error).orElseThrow();
/*     */         }(Throwable[])new IOException[0]);
/*     */   }
/*     */   public Result<FeatureFlagsObj, IOException> fetchFeatureFlags() {
/*     */     return Result.wrapGet(() -> {
/*     */           HttpURLConnection urlConnection = createUrlConnection(this.fetchFeatureFlagsUrl);
/*     */           urlConnection.setDoOutput(true);
/*     */           JsonObject jsonElement = new JsonObject();
/*     */           writeAuth(jsonElement, false);
/*     */           String string = jsonElement.toString();
/*     */           DEBUG.println(new Object[] { jsonElement });
/*     */           byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
/*     */           urlConnection.setRequestProperty("Content-Length", "" + bytes.length);
/*     */           urlConnection.setRequestMethod("POST");
/*     */           urlConnection.getOutputStream().write(bytes);
/*     */           int responseCode = urlConnection.getResponseCode();
/*     */           Minimega.LOGGER.debug("response code: " + responseCode);
/*     */           if (responseCode == 403)
/*     */             return new FeatureFlagsObj(List.of()); 
/*     */           byte[] bytes2 = urlConnection.getInputStream().readAllBytes();
/*     */           String s = new String(bytes2);
/*     */           JsonElement jsonElement2 = (JsonElement)(new Gson()).fromJson(s, JsonElement.class);
/*     */           Objects.requireNonNull(Minimega.LOGGER);
/*     */           return FeatureFlagsObj.CODEC.parse((DynamicOps)JsonOps.INSTANCE, jsonElement2).resultOrPartial(Minimega.LOGGER::error).orElseThrow();
/*     */         }(Throwable[])new IOException[0]);
/*     */   }
/*     */   public Result<Result.Unit, ? extends Exception> submitFeatureFlags(SubmitCodeObj submitCodeObj) {
/*     */     return Result.wrapRun(() -> {
/*     */           String serverId = randomId();
/*     */           Minecraft.getInstance().services().sessionService().joinServer(Minecraft.getInstance().getGameProfile().id(), Minecraft.getInstance().getUser().getAccessToken(), serverId);
/*     */           HttpURLConnection urlConnection = createUrlConnection(this.submitFeatureFlagsUrl);
/*     */           Objects.requireNonNull(Minimega.LOGGER);
/*     */           JsonObject jsonElement = ((JsonElement)SubmitCodeObj.CODEC.encodeStart((DynamicOps)JsonOps.INSTANCE, submitCodeObj).resultOrPartial(Minimega.LOGGER::error).orElseThrow()).getAsJsonObject();
/*     */           writeAuth(jsonElement);
/*     */           byte[] bytes = jsonElement.toString().getBytes(StandardCharsets.UTF_8);
/*     */           urlConnection.setRequestProperty("Content-Length", "" + bytes.length);
/*     */           urlConnection.setRequestMethod("POST");
/*     */           urlConnection.setDoOutput(true);
/*     */           urlConnection.getOutputStream().write(bytes);
/*     */           int responseCode = urlConnection.getResponseCode();
/*     */           Screen patt0$temp = (Minecraft.getInstance()).screen;
/*     */           if (patt0$temp instanceof AccessScreen) {
/*     */             AccessScreen screen = (AccessScreen)patt0$temp;
/*     */             if (responseCode == 200) {
/*     */               screen.success();
/*     */             } else if (responseCode == 402) {
/*     */               screen.invalidCode();
/*     */             } else if (responseCode == 429) {
/*     */               screen.ratelimit();
/*     */             } else {
/*     */               screen.error();
/*     */             } 
/*     */           } 
/*     */         }(Throwable[])new Exception[0]);
/*     */   }
/*     */   public Result<Integer, ? extends Exception> updateFriendsList(UpdateFriendsObj updateFriendsObj) {
/*     */     return Result.wrapGet(() -> {
/*     */           String serverId = randomId();
/*     */           Minecraft.getInstance().services().sessionService().joinServer(Minecraft.getInstance().getGameProfile().id(), Minecraft.getInstance().getUser().getAccessToken(), serverId);
/*     */           HttpURLConnection urlConnection = createUrlConnection(this.updateFriendsUrl);
/*     */           Objects.requireNonNull(Minimega.LOGGER);
/*     */           JsonObject jsonElement = ((JsonElement)UpdateFriendsObj.CODEC.encodeStart((DynamicOps)JsonOps.INSTANCE, updateFriendsObj).resultOrPartial(Minimega.LOGGER::error).orElseThrow()).getAsJsonObject();
/*     */           writeAuth(jsonElement, false);
/*     */           byte[] bytes = jsonElement.toString().getBytes(StandardCharsets.UTF_8);
/*     */           urlConnection.setRequestProperty("Content-Length", "" + bytes.length);
/*     */           urlConnection.setRequestMethod("POST");
/*     */           urlConnection.setDoOutput(true);
/*     */           urlConnection.getOutputStream().write(bytes);
/*     */           int responseCode = urlConnection.getResponseCode();
/*     */           if (responseCode == 500)
/*     */             Minecraft.getInstance().execute(()); 
/*     */           return Integer.valueOf(responseCode);
/*     */         }(Throwable[])new Exception[0]);
/*     */   }
/*     */   public Result<FriendsObj, IOException> fetchFriendsList() {
/*     */     return Result.wrapGet(() -> {
/*     */           HttpURLConnection urlConnection = createUrlConnection(this.fetchFriendsUrl);
/*     */           urlConnection.setDoOutput(true);
/*     */           JsonObject jsonElement = new JsonObject();
/*     */           writeAuth(jsonElement, false);
/*     */           String string = jsonElement.toString();
/*     */           DEBUG.println(new Object[] { jsonElement });
/*     */           byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
/*     */           urlConnection.setRequestProperty("Content-Length", "" + bytes.length);
/*     */           urlConnection.setRequestMethod("POST");
/*     */           urlConnection.getOutputStream().write(bytes);
/*     */           int responseCode = urlConnection.getResponseCode();
/*     */           Minimega.LOGGER.debug("response code: " + responseCode);
/*     */           if (responseCode == 403)
/*     */             return new FriendsObj(List.of()); 
/*     */           if (responseCode == 500)
/*     */             return new FriendsObj(List.of()); 
/*     */           byte[] bytes2 = urlConnection.getInputStream().readAllBytes();
/*     */           String s = new String(bytes2);
/*     */           JsonElement jsonElement2 = (JsonElement)(new Gson()).fromJson(s, JsonElement.class);
/*     */           Objects.requireNonNull(Minimega.LOGGER);
/*     */           return FriendsObj.CODEC.parse((DynamicOps)JsonOps.INSTANCE, jsonElement2).resultOrPartial(Minimega.LOGGER::error).orElseThrow();
/*     */         }(Throwable[])new IOException[0]);
/*     */   }
/*     */   public S2CPlayerInfoObj getPlayerInfoNullable(UUID player) {
/*     */     return ((Optional<S2CPlayerInfoObj>)getPlayerInfo(player).opt(ex -> Minimega.LOGGER.error("Failed to fetch player info", ex)).orElseGet(Optional::empty)).orElse(null);
/*     */   }
/*     */   public Result<Optional<S2CPlayerInfoObj>, ? extends Throwable> getPlayerInfo(UUID player) {
/*     */     Result<Boolean, ? extends Exception> result;
/*     */     if (isInAuthScreen)
/*     */       return (Result<Optional<S2CPlayerInfoObj>, ? extends Throwable>)Error.ofText("Player is in auth screen"); 
/*     */     Ok ok = new Ok(Boolean.valueOf(true));
/*     */     if (this.token == null) {
/*     */       result = refreshToken(true);
/*     */       Ok ok1 = (Ok)Objects.requireNonNull(result);
/*     */       if (ok1 instanceof Ok) {
/*     */         Ok ok2 = ok1;
/*     */         try {
/*     */           Boolean bool1 = (Boolean)ok2.val(), b = bool1;
/*     */           if (b.equals(Boolean.valueOf(false)))
/*     */             return (Result<Optional<S2CPlayerInfoObj>, ? extends Throwable>)new Ok(Optional.empty()); 
/*     */           return result.flatMap(paramBoolean -> {
/*     */                 C2SPlayerInfoObj obj = new C2SPlayerInfoObj(player);
/*     */                 HttpURLConnection urlConnection = createUrlConnection(this.playerInfoUrl);
/*     */                 urlConnection.setDoOutput(true);
/*     */                 Objects.requireNonNull(Minimega.LOGGER);
/*     */                 JsonObject jsonElement = ((JsonElement)C2SPlayerInfoObj.CODEC.encodeStart((DynamicOps)JsonOps.INSTANCE, obj).resultOrPartial(Minimega.LOGGER::error).orElseThrow()).getAsJsonObject();
/*     */                 writeAuth(jsonElement);
/*     */                 String string = jsonElement.toString();
/*     */                 DEBUG.println(new Object[] { jsonElement });
/*     */                 byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
/*     */                 urlConnection.setRequestProperty("Content-Length", "" + bytes.length);
/*     */                 Result.wrapRun((), (Throwable[])new ProtocolException[0]).orElseThrow(());
/*     */                 Objects.requireNonNull(urlConnection);
/*     */                 return Result.wrapGet(urlConnection::getOutputStream, new Throwable[0]).flatMap(()).flatMap(()).flatMap(()).flatMap(()).flatMap(()).flatMap(()).flatMap(());
/*     */               });
/*     */         } catch (Throwable throwable) {
/*     */           throw new MatchException(throwable.toString(), throwable);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     return result.flatMap(paramBoolean -> {
/*     */           C2SPlayerInfoObj obj = new C2SPlayerInfoObj(player);
/*     */           HttpURLConnection urlConnection = createUrlConnection(this.playerInfoUrl);
/*     */           urlConnection.setDoOutput(true);
/*     */           Objects.requireNonNull(Minimega.LOGGER);
/*     */           JsonObject jsonElement = ((JsonElement)C2SPlayerInfoObj.CODEC.encodeStart((DynamicOps)JsonOps.INSTANCE, obj).resultOrPartial(Minimega.LOGGER::error).orElseThrow()).getAsJsonObject();
/*     */           writeAuth(jsonElement);
/*     */           String string = jsonElement.toString();
/*     */           DEBUG.println(new Object[] { jsonElement });
/*     */           byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
/*     */           urlConnection.setRequestProperty("Content-Length", "" + bytes.length);
/*     */           Result.wrapRun((), (Throwable[])new ProtocolException[0]).orElseThrow(());
/*     */           Objects.requireNonNull(urlConnection);
/*     */           return Result.wrapGet(urlConnection::getOutputStream, new Throwable[0]).flatMap(()).flatMap(()).flatMap(()).flatMap(()).flatMap(()).flatMap(()).flatMap(());
/*     */         });
/*     */   }
/*     */   private static final Object mutex = new Object();
/*     */   private ReceivedGlideMatchesObj internaltesting(FetchGlideMatchesObj obj) {
/*     */     synchronized (mutex) {
/*     */       GlideGameType type = obj.type();
/*     */       Identifier resourceLocation = obj.mapId();
/*     */       String key = String.valueOf(resourceLocation) + String.valueOf(resourceLocation);
/*     */       if (type == GlideGameType.SCORE_ATTACK) {
/*     */         List<GlideRecordObj> tempList = records.stream().filter(a -> a.map().equals(resourceLocation)).sorted(Comparator.comparing(GlideRecordObj::duration)).toList();
/*     */         List<GlideMatchRecordObj> list = new ArrayList<>();
/*     */         for (int i = 0; i < tempList.size(); i++) {
/*     */           GlideRecordObj glideRecordObj = tempList.get(i);
/*     */           Objects.requireNonNull(glideRecordObj.minecraftUUID);
/*     */           list.add(new GlideMatchRecordObj(i, Minecraft.getInstance().services().nameToIdCache().get(glideRecordObj.minecraftUUID()).map(NameAndId::name).orElseGet(glideRecordObj.minecraftUUID::toString), Optional.of(glideRecordObj.duration()), glideRecordObj.score(), glideRecordObj.legacy4j(), glideRecordObj.protocolVersion()));
/*     */         } 
/*     */         return new ReceivedGlideMatchesObj(list, obj.offset(), list.size());
/*     */       } 
/*     */       return new ReceivedGlideMatchesObj(List.of(), obj.offset(), 0);
/*     */     } 
/*     */   }
/*     */   public Result<Optional<ReceivedGlideMatchesObj>, IOException> getGlideLeaderboard(FetchGlideMatchesObj obj) {
/*     */     return Result.wrapGet(() -> {
/*     */           if (isInAuthScreen)
/*     */             return Optional.empty(); 
/*     */           HttpURLConnection urlConnection = createUrlConnection(this.fetchFromLeaderboardsUrl);
/*     */           urlConnection.setDoOutput(true);
/*     */           Objects.requireNonNull(Minimega.LOGGER);
/*     */           JsonObject jsonElement = ((JsonElement)FetchGlideMatchesObj.CODEC.encodeStart((DynamicOps)JsonOps.INSTANCE, obj).resultOrPartial(Minimega.LOGGER::error).orElseThrow()).getAsJsonObject();
/*     */           writeProtocolVersion(jsonElement);
/*     */           String string = jsonElement.toString();
/*     */           DEBUG.println(new Object[] { jsonElement });
/*     */           byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
/*     */           urlConnection.setRequestProperty("Content-Length", "" + bytes.length);
/*     */           urlConnection.setRequestMethod("POST");
/*     */           urlConnection.getOutputStream().write(bytes);
/*     */           int responseCode = urlConnection.getResponseCode();
/*     */           if (responseCode != 200)
/*     */             return Optional.empty(); 
/*     */           Minimega.LOGGER.debug("response code: " + responseCode);
/*     */           byte[] bytes2 = urlConnection.getInputStream().readAllBytes();
/*     */           String s = new String(bytes2);
/*     */           System.out.println(s);
/*     */           JsonElement jsonElement2 = (JsonElement)(new Gson()).fromJson(s, JsonElement.class);
/*     */           Objects.requireNonNull(Minimega.LOGGER);
/*     */           return Optional.of(ReceivedGlideMatchesObj.CODEC.parse((DynamicOps)JsonOps.INSTANCE, jsonElement2).resultOrPartial(Minimega.LOGGER::error).orElseThrow());
/*     */         }(Throwable[])new IOException[0]);
/*     */   }
/*     */   public static interface Sup<T> {
/*     */     T get() throws Throwable; }
/*     */   
/*     */   public static interface Rup {
/*     */     void run() throws Throwable; }
/*     */   
/*     */   private static final class GlideRecordObj extends Record {
/*     */     private final Identifier map;
/*     */     private final UUID minecraftUUID;
/*     */     private final Duration duration;
/*     */     private final Optional<Integer> score;
/*     */     private final boolean legacy4j;
/*     */     private final int protocolVersion;
/*     */     
/*     */     private GlideRecordObj(Identifier map, UUID minecraftUUID, Duration duration, Optional<Integer> score, boolean legacy4j, int protocolVersion) {
/*     */       this.map = map;
/*     */       this.minecraftUUID = minecraftUUID;
/*     */       this.duration = duration;
/*     */       this.score = score;
/*     */       this.legacy4j = legacy4j;
/*     */       this.protocolVersion = protocolVersion;
/*     */     }
/*     */     
/*     */     public final String toString() {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/client/p2p/matchmaking/MatchmakingClient$GlideRecordObj;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #438	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Ldev/jab125/minimega/mod/client/p2p/matchmaking/MatchmakingClient$GlideRecordObj;
/*     */     }
/*     */     
/*     */     public final int hashCode() {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/client/p2p/matchmaking/MatchmakingClient$GlideRecordObj;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #438	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Ldev/jab125/minimega/mod/client/p2p/matchmaking/MatchmakingClient$GlideRecordObj;
/*     */     }
/*     */     
/*     */     public final boolean equals(Object o) {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/client/p2p/matchmaking/MatchmakingClient$GlideRecordObj;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #438	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Ldev/jab125/minimega/mod/client/p2p/matchmaking/MatchmakingClient$GlideRecordObj;
/*     */       //   0	8	1	o	Ljava/lang/Object;
/*     */     }
/*     */     
/*     */     public Identifier map() {
/*     */       return this.map;
/*     */     }
/*     */     
/*     */     public UUID minecraftUUID() {
/*     */       return this.minecraftUUID;
/*     */     }
/*     */     
/*     */     public Duration duration() {
/*     */       return this.duration;
/*     */     }
/*     */     
/*     */     public Optional<Integer> score() {
/*     */       return this.score;
/*     */     }
/*     */     
/*     */     public boolean legacy4j() {
/*     */       return this.legacy4j;
/*     */     }
/*     */     
/*     */     public int protocolVersion() {
/*     */       return this.protocolVersion;
/*     */     } }
/*     */   private static final List<GlideRecordObj> records = new CopyOnWriteArrayList<>();
/*     */   private boolean playable;
/*     */   private boolean fetchedPlayable;
/*     */   public static final boolean P_DEV = false;
/*     */   private String token;
/*     */   public static boolean isInAuthScreen;
/*     */   private long nextAttemptRefresh;
/*     */   
/*     */   public Result<Result.Unit, ? extends Exception> uploadMatchResult(SubmitGlideMatchObj obj) {
/*     */     return Result.wrapRun(() -> {
/*     */           refreshToken(false);
/*     */           HttpURLConnection urlConnection = createUrlConnection(this.submitToLeaderboardsUrl);
/*     */           urlConnection.setDoOutput(true);
/*     */           Objects.requireNonNull(Minimega.LOGGER);
/*     */           JsonObject jsonElement = ((JsonElement)SubmitGlideMatchObj.CODEC.encodeStart((DynamicOps)JsonOps.INSTANCE, obj).resultOrPartial(Minimega.LOGGER::error).orElseThrow()).getAsJsonObject();
/*     */           scramble(jsonElement);
/*     */           writeAuth(jsonElement);
/*     */           String string = jsonElement.toString();
/*     */           DEBUG.println(new Object[] { jsonElement });
/*     */           byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
/*     */           urlConnection.setRequestProperty("Content-Length", "" + bytes.length);
/*     */           urlConnection.setRequestMethod("POST");
/*     */           urlConnection.getOutputStream().write(bytes);
/*     */           int responseCode = urlConnection.getResponseCode();
/*     */           Minimega.LOGGER.info("response code: " + responseCode);
/*     */           if (responseCode >= 400)
/*     */             throw new IllegalArgumentException("Error " + responseCode + "!"); 
/*     */         }(Throwable[])new IOException[0]);
/*     */   }
/*     */   
/*     */   private static String scramble(String input, String with) {
/*     */     if (input == null || with == null || with.isEmpty())
/*     */       throw new IllegalArgumentException("Input and key must not be null or empty"); 
/*     */     char[] chars = input.toCharArray();
/*     */     Random random = new Random(seedFromKey(with));
/*     */     for (int i = chars.length - 1; i > 0; i--) {
/*     */       int j = random.nextInt(i + 1);
/*     */       char tmp = chars[i];
/*     */       chars[i] = chars[j];
/*     */       chars[j] = tmp;
/*     */     } 
/*     */     return new String(chars);
/*     */   }
/*     */   
/*     */   private static long seedFromKey(String key) {
/*     */     long seed = 0L;
/*     */     for (char c : key.toCharArray())
/*     */       seed = seed * 31L + c; 
/*     */     return seed;
/*     */   }
/*     */   
/*     */   private void scramble(JsonObject jsonElement) {
/*     */     Set<String> strings = Set.copyOf(jsonElement.keySet());
/*     */     int loc = 0;
/*     */     for (String str1 : strings) {
/*     */       JsonElement jsonElement1 = jsonElement.get(str1);
/*     */       jsonElement.remove(str1);
/*     */       JsonObject object = (JsonObject)jsonElement1;
/*     */       String asString = (jsonElement1 instanceof JsonObject) ? String.valueOf(object) : jsonElement1.getAsString();
/*     */       loc += asString.hashCode() + asString.length();
/*     */       jsonElement.add(scramble(str1, asString), jsonElement1);
/*     */     } 
/*     */     String string = f(loc);
/*     */     jsonElement.addProperty(scramble("specialId", string), string);
/*     */   }
/*     */   
/* 507 */   private MatchmakingClient(String serverBaseUrl) { this.fetchedPlayable = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 620 */     this.nextAttemptRefresh = -1L; this.serverBaseUrl = serverBaseUrl; this.adUrl = HttpAuthenticationService.constantURL(serverBaseUrl + "v1/lobbies/advertise"); this.pullAdUrl = HttpAuthenticationService.constantURL(serverBaseUrl + "v1/lobbies/pull-lobby"); this.tokenUrl = HttpAuthenticationService.constantURL(serverBaseUrl + "v1/auth"); this.linkUrl = HttpAuthenticationService.constantURL(serverBaseUrl + "v1/auth/link"); this.lobbiesUrl = HttpAuthenticationService.constantURL(serverBaseUrl + "v1/lobbies/fetch-lobbies"); this.playableUrl = HttpAuthenticationService.constantURL(serverBaseUrl + "v1/playable"); this.playerInfoUrl = HttpAuthenticationService.constantURL(serverBaseUrl + "v1/auth/player-info"); this.submitToLeaderboardsUrl = HttpAuthenticationService.constantURL(serverBaseUrl + "v1/leaderboards/submit"); this.fetchFromLeaderboardsUrl = HttpAuthenticationService.constantURL(serverBaseUrl + "v1/leaderboards/fetch"); this.fetchFeatureFlagsUrl = HttpAuthenticationService.constantURL(serverBaseUrl + "v1/feature-flags"); this.submitFeatureFlagsUrl = HttpAuthenticationService.constantURL(serverBaseUrl + "v1/feature-flags/submit"); this.updateFriendsUrl = HttpAuthenticationService.constantURL(serverBaseUrl + "v1/friends/update"); this.fetchFriendsUrl = HttpAuthenticationService.constantURL(serverBaseUrl + "v1/friends/get"); }
/*     */   private String f(int i) { Random random = new Random(i); return (new UUID(random.nextLong(), random.nextLong())).toString(); }
/* 622 */   public <T extends Throwable> boolean isPlayable() throws T { if (this.fetchedPlayable) return this.playable;  try { HttpURLConnection urlConnection = createUrlConnection(this.playableUrl); urlConnection.setDoOutput(true); urlConnection.setRequestMethod("POST"); String version = "60503200"; byte[] bytes1 = version.getBytes(StandardCharsets.UTF_8); urlConnection.setRequestProperty("Content-Length", "" + bytes1.length); urlConnection.getOutputStream().write(bytes1); int responseCode = urlConnection.getResponseCode(); DEBUG.println(new Object[] { "responded with " + responseCode }); byte[] bytes = urlConnection.getInputStream().readAllBytes(); Objects.requireNonNull(Minimega.LOGGER); return this.playable = ((SupportedObj)SupportedObj.CODEC.parse((DynamicOps)JsonOps.INSTANCE, (new Gson()).fromJson(new String(bytes), JsonElement.class)).resultOrPartial(Minimega.LOGGER::error).orElseThrow()).supported(); } catch (Throwable t) { t.printStackTrace(); this.fetchedPlayable = true; return this.playable = false; }  } public Result<Result.Unit, IOException> pullServer() { return Result.wrapRun(() -> { HttpURLConnection urlConnection = createUrlConnection(this.pullAdUrl); urlConnection.setDoOutput(true); JsonObject jsonElement = new JsonObject(); writeAuth(jsonElement, false); String string = jsonElement.toString(); DEBUG.println(new Object[] { jsonElement }); byte[] bytes = string.getBytes(StandardCharsets.UTF_8); urlConnection.setRequestProperty("Content-Length", "" + bytes.length); urlConnection.setRequestMethod("POST"); urlConnection.getOutputStream().write(bytes); int responseCode = urlConnection.getResponseCode(); Minimega.LOGGER.debug("response code for pull: " + responseCode); }(Throwable[])new IOException[0]); } private void writeAuth(JsonObject jsonElement, boolean gui) { if (this.token == null) refreshToken(gui);  jsonElement.addProperty("authtoken", this.token); jsonElement.addProperty("authuuid", Minecraft.getInstance().getGameProfile().id().toString()); writeProtocolVersion(jsonElement); } private void writeProtocolVersion(JsonObject jsonElement) { jsonElement.addProperty("authversion", Integer.valueOf(60503200)); } public Result<Boolean, ? extends Exception> refreshToken(boolean gui) { return Result.wrapGet(() -> {
/*     */           if (isInAuthScreen) {
/*     */             return Boolean.valueOf(false);
/*     */           }
/*     */           
/*     */           if (System.currentTimeMillis() < this.nextAttemptRefresh) {
/*     */             return Boolean.valueOf(true);
/*     */           }
/*     */           String serverId = randomId();
/*     */           Minecraft.getInstance().services().sessionService().joinServer(Minecraft.getInstance().getGameProfile().id(), Minecraft.getInstance().getUser().getAccessToken(), serverId);
/*     */           HttpURLConnection urlConnection = createUrlConnection(this.tokenUrl);
/*     */           JsonObject object = new JsonObject();
/*     */           String name = Minecraft.getInstance().getGameProfile().name();
/*     */           object.addProperty("profile_name", name);
/*     */           object.addProperty("server_id", serverId);
/*     */           byte[] bytes = object.toString().getBytes(StandardCharsets.UTF_8);
/*     */           urlConnection.setRequestProperty("Content-Length", "" + bytes.length);
/*     */           urlConnection.setRequestMethod("POST");
/*     */           urlConnection.setDoOutput(true);
/*     */           urlConnection.getOutputStream().write(bytes);
/*     */           int responseCode = urlConnection.getResponseCode();
/*     */           if (responseCode != 200) {
/*     */             Minimega.LOGGER.debug("?????");
/*     */           }
/*     */           if (responseCode == 403) {
/*     */             
/*     */             try { String s = new String(urlConnection.getErrorStream().readAllBytes(), StandardCharsets.UTF_8);
/*     */               Objects.requireNonNull(Minimega.LOGGER);
/*     */               String error = ((ErrorObj)ErrorObj.CODEC.parse((DynamicOps)JsonOps.INSTANCE, (new Gson()).fromJson(s, JsonElement.class)).resultOrPartial(Minimega.LOGGER::error).orElseThrow()).error();
/*     */               if (error.contains("Discord account is not in the discord server!")) {
/*     */                 Minimega.LOGGER.error("Failed to authenticate because {} left the Discord server!", name);
/*     */                 Minecraft.getInstance().execute(());
/*     */               } else if (error.contains("You are banned.")) {
/*     */                 Minimega.LOGGER.error("Failed to authenticate because {} is banned!", name);
/*     */                 Minecraft.getInstance().execute(());
/*     */               } else if (error.contains("Using banned skin.")) {
/*     */                 Minimega.LOGGER.error("Failed to authenticate because {} is using a banned skin!", name);
/*     */                 Minecraft.getInstance().execute(());
/*     */               } else {
/*     */                 Minimega.LOGGER.error("Failed to authenticate!");
/*     */                 Minimega.LOGGER.error(error);
/*     */                 Minecraft.getInstance().execute(());
/*     */               }  }
/* 665 */             catch (Throwable t) { t.printStackTrace(); }
/*     */              return Boolean.valueOf(false);
/*     */           }  if (responseCode == 418) { DEBUG.println(new Object[] { "i am a teapot" }); String s = new String(urlConnection.getErrorStream().readAllBytes(), StandardCharsets.UTF_8); Objects.requireNonNull(Minimega.LOGGER); String error = ((ErrorObj)ErrorObj.CODEC.parse((DynamicOps)JsonOps.INSTANCE, (new Gson()).fromJson(s, JsonElement.class)).resultOrPartial(Minimega.LOGGER::error).orElseThrow()).error(); if (gui)
/*     */               attemptDiscordAccountLinking(error.substring(error.indexOf("->") + 2));  return Boolean.valueOf(false); }
/*     */            String str = new String(urlConnection.getInputStream().readAllBytes()); JsonElement jsonElement = (JsonElement)(new Gson()).fromJson(str, JsonElement.class); Objects.requireNonNull(Minimega.LOGGER); AccessTokenObj accessTokenObj = AccessTokenObj.CODEC.parse((DynamicOps)JsonOps.INSTANCE, jsonElement).resultOrPartial(Minimega.LOGGER::error).orElseThrow(); this.token = accessTokenObj.token(); this.nextAttemptRefresh = System.currentTimeMillis() + 30000L; return Boolean.valueOf(true);
/*     */         }(Throwable[])new Exception[0]); }
/*     */   private void writeAuth(JsonObject jsonElement) { writeAuth(jsonElement, true); }
/*     */   private void attemptDiscordAccountLinking(String code) { isInAuthScreen = true; Minecraft.getInstance().execute(() -> Minecraft.getInstance().setScreen((Screen)new LinkScreen((), this::sendCode, this::falseDisconnect, (Minecraft.getInstance()).screen))); }
/*     */   private void falseDisconnect() { Screen screen = (Minecraft.getInstance()).screen; if (screen instanceof LinkScreen) { LinkScreen linkScreen = (LinkScreen)screen; linkScreen.allowClose(); }
/*     */      if (Minecraft.getInstance().getConnection() == null) { Minecraft.getInstance().setScreen((Screen)new DisconnectedScreen((Screen)new JoinMultiplayerScreen((Screen)new TitleScreen()), (Component)Component.translatable("disconnect.lost"), new DisconnectionDetails((Component)Component.literal("Cancelled login.")))); }
/*     */     else { Minecraft.getInstance().getConnection().getConnection().disconnect((Component)Component.literal("Cancelled login.")); }
/*     */      isInAuthScreen = false; }
/*     */   private void sendCode(String code) { try { String serverId = randomId(); Minecraft.getInstance().services().sessionService().joinServer(Minecraft.getInstance().getGameProfile().id(), Minecraft.getInstance().getUser().getAccessToken(), serverId); HttpURLConnection urlConnection = createUrlConnection(this.linkUrl); JsonObject object = new JsonObject(); object.addProperty("profile_name", Minecraft.getInstance().getGameProfile().name()); object.addProperty("server_id", serverId); object.addProperty("code", code); byte[] bytes = object.toString().getBytes(StandardCharsets.UTF_8); urlConnection.setRequestProperty("Content-Length", "" + bytes.length); urlConnection.setRequestMethod("POST"); urlConnection.setDoOutput(true); urlConnection.getOutputStream().write(bytes); int responseCode = urlConnection.getResponseCode(); Screen screen = (Minecraft.getInstance()).screen; if (screen instanceof LinkScreen) { LinkScreen linkScreen = (LinkScreen)screen; if (responseCode == 200) { linkScreen.allowClose(); linkScreen.onClose(); isInAuthScreen = false; refreshToken(false); }
/*     */         else
/*     */         { linkScreen.invalidCode(); }
/*     */          }
/*     */        }
/*     */     catch (AuthenticationException e)
/*     */     { throw new RuntimeException(e); }
/*     */     catch (IOException e)
/*     */     { throw new RuntimeException(e); }
/*     */      }
/* 687 */   public Result<Boolean, ? extends Exception> refreshToken() { return refreshToken(true); } private static final char[] validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ132435465768790".toCharArray();
/*     */   
/*     */   private String randomId() {
/* 690 */     SecureRandom secureRandom = new SecureRandom();
/* 691 */     StringBuilder builder = new StringBuilder();
/* 692 */     for (int i = 0; i < 20; i++) {
/* 693 */       builder.append(validChars[secureRandom.nextInt(validChars.length)]);
/*     */     }
/* 695 */     return builder.toString();
/*     */   }
/*     */   
/*     */   private static HttpURLConnection createUrlConnection(URL url) {
/*     */     try {
/* 700 */       Minimega.LOGGER.debug("Connecting to {}", url);
/* 701 */       HttpURLConnection connection = (HttpURLConnection)url.openConnection(Proxy.NO_PROXY);
/* 702 */       connection.setConnectTimeout(10000);
/* 703 */       connection.setReadTimeout(10000);
/* 704 */       connection.setUseCaches(false);
/* 705 */       DEBUG.println(new Object[] { url });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 712 */       return connection;
/* 713 */     } catch (IOException io) {
/* 714 */       throw new MinecraftClientException(MinecraftClientException.ErrorType.SERVICE_UNAVAILABLE, "Failed connecting to " + String.valueOf(url), io);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static class DEBUG {
/*     */     public static void println(Object... obj) {
/* 720 */       Minimega.LOGGER.debug("{}", obj);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\p2p\matchmaking\MatchmakingClient.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */