/*     */ package dev.jab125.minimega.mod.client.join;
/*     */ 
/*     */ import dev.jab125.minimega.call.Result;
/*     */ import dev.jab125.minimega.mod.Minimega;
/*     */ import dev.jab125.minimega.mod.abstractions.modloader.ModLoader;
/*     */ import dev.jab125.minimega.mod.util.minigamedata.MinigameData;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.components.toasts.SystemToast;
/*     */ import net.minecraft.client.gui.screens.ConnectScreen;
/*     */ import net.minecraft.client.gui.screens.Screen;
/*     */ import net.minecraft.client.gui.screens.TitleScreen;
/*     */ import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
/*     */ import net.minecraft.client.multiplayer.ServerData;
/*     */ import net.minecraft.client.multiplayer.ServerList;
/*     */ import net.minecraft.client.multiplayer.resolver.ServerAddress;
/*     */ import net.minecraft.client.resources.language.I18n;
/*     */ import net.minecraft.core.HolderLookup;
/*     */ import net.minecraft.world.level.biome.Biomes;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ import net.minecraft.world.level.chunk.ChunkGenerator;
/*     */ import net.minecraft.world.level.levelgen.FlatLevelSource;
/*     */ import net.minecraft.world.level.levelgen.WorldDimensions;
/*     */ import net.minecraft.world.level.levelgen.flat.FlatLevelGeneratorSettings;
/*     */ import net.minecraft.world.level.levelgen.presets.WorldPresets;
/*     */ import net.minecraft.world.level.storage.LevelStorageSource;
/*     */ import org.apache.commons.lang3.function.TriFunction;
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
/*     */ public class Joiner
/*     */ {
/*     */   public static <T> T handle(Minecraft minecraft, MinigameData data, Screen previous, TriFunction<Minecraft, MinigameData, Screen, T> dataScreenTriFunction) {
/*  55 */     return (T)dataScreenTriFunction.apply(minecraft, data, previous);
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
/*     */   public static Result<Result.Unit, ? extends Exception> handle(Minecraft minecraft, MinigameData data, Screen previous) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: invokestatic createLobby : (Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;)V
/*     */     //   4: aload_1
/*     */     //   5: invokevirtual online : ()Z
/*     */     //   8: ifeq -> 153
/*     */     //   11: invokestatic token : ()Ldev/jab125/minimega/call/Result;
/*     */     //   14: dup
/*     */     //   15: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   18: pop
/*     */     //   19: astore_3
/*     */     //   20: iconst_0
/*     */     //   21: istore #4
/*     */     //   23: aload_3
/*     */     //   24: iload #4
/*     */     //   26: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/call/Result;I)I
/*     */     //   31: tableswitch default -> 56, 0 -> 66, 1 -> 104, 2 -> 123
/*     */     //   56: new java/lang/MatchException
/*     */     //   59: dup
/*     */     //   60: aconst_null
/*     */     //   61: aconst_null
/*     */     //   62: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   65: athrow
/*     */     //   66: aload_3
/*     */     //   67: checkcast dev/jab125/minimega/call/Ok
/*     */     //   70: astore #5
/*     */     //   72: aload #5
/*     */     //   74: invokevirtual val : ()Ljava/lang/Object;
/*     */     //   77: checkcast java/lang/Boolean
/*     */     //   80: astore #7
/*     */     //   82: aload #7
/*     */     //   84: astore #6
/*     */     //   86: aload #6
/*     */     //   88: invokevirtual booleanValue : ()Z
/*     */     //   91: ifeq -> 100
/*     */     //   94: iconst_1
/*     */     //   95: istore #4
/*     */     //   97: goto -> 23
/*     */     //   100: invokestatic ok : ()Ldev/jab125/minimega/call/Ok;
/*     */     //   103: areturn
/*     */     //   104: aload_3
/*     */     //   105: checkcast dev/jab125/minimega/call/Ok
/*     */     //   108: astore #7
/*     */     //   110: aload #7
/*     */     //   112: invokevirtual val : ()Ljava/lang/Object;
/*     */     //   115: checkcast java/lang/Boolean
/*     */     //   118: astore #8
/*     */     //   120: goto -> 153
/*     */     //   123: aload_3
/*     */     //   124: checkcast dev/jab125/minimega/call/Error
/*     */     //   127: astore #8
/*     */     //   129: aload #8
/*     */     //   131: invokevirtual val : ()Ljava/lang/Throwable;
/*     */     //   134: checkcast java/lang/Exception
/*     */     //   137: astore #10
/*     */     //   139: aload #10
/*     */     //   141: astore #9
/*     */     //   143: new dev/jab125/minimega/call/Error
/*     */     //   146: dup
/*     */     //   147: aload #9
/*     */     //   149: invokespecial <init> : (Ljava/lang/Throwable;)V
/*     */     //   152: areturn
/*     */     //   153: aload_0
/*     */     //   154: invokestatic yeet : (Lnet/minecraft/client/Minecraft;)V
/*     */     //   157: aload_0
/*     */     //   158: invokevirtual createWorldOpenFlows : ()Lnet/minecraft/client/gui/screens/worldselection/WorldOpenFlows;
/*     */     //   161: astore_3
/*     */     //   162: new net/minecraft/world/level/LevelSettings
/*     */     //   165: dup
/*     */     //   166: ldc '_mm_minigamesXX'
/*     */     //   168: getstatic net/minecraft/world/level/GameType.SURVIVAL : Lnet/minecraft/world/level/GameType;
/*     */     //   171: new net/minecraft/world/level/LevelSettings$DifficultySettings
/*     */     //   174: dup
/*     */     //   175: getstatic net/minecraft/world/Difficulty.PEACEFUL : Lnet/minecraft/world/Difficulty;
/*     */     //   178: iconst_0
/*     */     //   179: iconst_1
/*     */     //   180: invokespecial <init> : (Lnet/minecraft/world/Difficulty;ZZ)V
/*     */     //   183: iconst_0
/*     */     //   184: new net/minecraft/world/level/WorldDataConfiguration
/*     */     //   187: dup
/*     */     //   188: getstatic net/minecraft/world/level/DataPackConfig.DEFAULT : Lnet/minecraft/world/level/DataPackConfig;
/*     */     //   191: getstatic net/minecraft/world/flag/FeatureFlags.DEFAULT_FLAGS : Lnet/minecraft/world/flag/FeatureFlagSet;
/*     */     //   194: invokespecial <init> : (Lnet/minecraft/world/level/DataPackConfig;Lnet/minecraft/world/flag/FeatureFlagSet;)V
/*     */     //   197: invokespecial <init> : (Ljava/lang/String;Lnet/minecraft/world/level/GameType;Lnet/minecraft/world/level/LevelSettings$DifficultySettings;ZLnet/minecraft/world/level/WorldDataConfiguration;)V
/*     */     //   200: astore #4
/*     */     //   202: invokestatic defaultWithRandomSeed : ()Lnet/minecraft/world/level/levelgen/WorldOptions;
/*     */     //   205: astore #5
/*     */     //   207: aload #5
/*     */     //   209: invokestatic from : (Lnet/minecraft/world/level/levelgen/WorldOptions;)Ldev/jab125/minimega/mod/extension/WorldOptionsExtension;
/*     */     //   212: astore #6
/*     */     //   214: aload #6
/*     */     //   216: new dev/jab125/minimega/mod/util/MinigameMarker
/*     */     //   219: dup
/*     */     //   220: iconst_1
/*     */     //   221: invokespecial <init> : (Z)V
/*     */     //   224: invokeinterface mm$markWithMinigameData : (Ldev/jab125/minimega/mod/util/MinigameMarker;)V
/*     */     //   229: getstatic dev/jab125/minimega/mod/Minimega._DONT_USE_THIS : Ljava/lang/ThreadLocal;
/*     */     //   232: iconst_1
/*     */     //   233: invokestatic valueOf : (Z)Ljava/lang/Boolean;
/*     */     //   236: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   239: aload_3
/*     */     //   240: ldc 'minigames'
/*     */     //   242: aload #4
/*     */     //   244: aload #5
/*     */     //   246: ldc2_w 195
/*     */     //   249: invokestatic of : (J)Ljava/util/OptionalLong;
/*     */     //   252: invokevirtual withSeed : (Ljava/util/OptionalLong;)Lnet/minecraft/world/level/levelgen/WorldOptions;
/*     */     //   255: <illegal opcode> apply : ()Ljava/util/function/Function;
/*     */     //   260: aload_2
/*     */     //   261: invokevirtual createFreshLevel : (Ljava/lang/String;Lnet/minecraft/world/level/LevelSettings;Lnet/minecraft/world/level/levelgen/WorldOptions;Ljava/util/function/Function;Lnet/minecraft/client/gui/screens/Screen;)V
/*     */     //   264: getstatic dev/jab125/minimega/mod/Minimega._DONT_USE_THIS : Ljava/lang/ThreadLocal;
/*     */     //   267: invokevirtual remove : ()V
/*     */     //   270: invokestatic ok : ()Ldev/jab125/minimega/call/Ok;
/*     */     //   273: areturn
/*     */     //   274: astore #7
/*     */     //   276: new java/lang/MatchException
/*     */     //   279: dup
/*     */     //   280: aload #7
/*     */     //   282: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   285: aload #7
/*     */     //   287: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   290: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #58	-> 0
/*     */     //   #59	-> 4
/*     */     //   #60	-> 11
/*     */     //   #61	-> 66
/*     */     //   #62	-> 100
/*     */     //   #63	-> 104
/*     */     //   #64	-> 123
/*     */     //   #65	-> 143
/*     */     //   #69	-> 153
/*     */     //   #70	-> 157
/*     */     //   #71	-> 158
/*     */     //   #72	-> 162
/*     */     //   #73	-> 202
/*     */     //   #74	-> 207
/*     */     //   #75	-> 214
/*     */     //   #76	-> 229
/*     */     //   #77	-> 239
/*     */     //   #78	-> 249
/*     */     //   #84	-> 264
/*     */     //   #85	-> 270
/*     */     //   #64	-> 274
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   86	18	6	b	Ljava/lang/Boolean;
/*     */     //   143	10	9	val	Ljava/lang/Exception;
/*     */     //   162	112	3	worldOpenFlows	Lnet/minecraft/client/gui/screens/worldselection/WorldOpenFlows;
/*     */     //   202	72	4	miniGames	Lnet/minecraft/world/level/LevelSettings;
/*     */     //   207	67	5	worldOptions	Lnet/minecraft/world/level/levelgen/WorldOptions;
/*     */     //   214	60	6	extension	Ldev/jab125/minimega/mod/extension/WorldOptionsExtension;
/*     */     //   0	291	0	minecraft	Lnet/minecraft/client/Minecraft;
/*     */     //   0	291	1	data	Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;
/*     */     //   0	291	2	previous	Lnet/minecraft/client/gui/screens/Screen;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   74	77	274	java/lang/Throwable
/*     */     //   112	115	274	java/lang/Throwable
/*     */     //   131	134	274	java/lang/Throwable
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
/*     */   public static void joinMultiplayerWorld(Minecraft minecraft, String string) {
/*  89 */     ServerList serverList = new ServerList(minecraft);
/*  90 */     serverList.load();
/*  91 */     ServerData serverData = serverList.get(string);
/*  92 */     if (serverData == null) {
/*  93 */       serverData = new ServerData(I18n.get("selectServer.defaultName", new Object[0]), string, ServerData.Type.OTHER);
/*  94 */       serverList.add(serverData, true);
/*  95 */       serverList.save();
/*     */     } 
/*     */     
/*  98 */     ServerAddress serverAddress = ServerAddress.parseString(string);
/*  99 */     ConnectScreen.startConnecting((Screen)new JoinMultiplayerScreen((Screen)new TitleScreen()), minecraft, serverAddress, serverData, true, null);
/*     */   }
/*     */   
/*     */   private static void yeet(Minecraft minecraft) {
/* 103 */     LevelStorageSource levelSource = minecraft.getLevelSource();
/* 104 */     if (!levelSource.levelExists("minigames"))
/* 105 */       return;  try { LevelStorageSource.LevelStorageAccess levelStorageAccess = levelSource.createAccess("minigames"); 
/* 106 */       try { levelStorageAccess.deleteLevel();
/* 107 */         if (levelStorageAccess != null) levelStorageAccess.close();  } catch (Throwable throwable) { if (levelStorageAccess != null) try { levelStorageAccess.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (IOException var7)
/* 108 */     { SystemToast.onWorldDeleteFailure(minecraft, "minigames");
/* 109 */       Minimega.LOGGER.warn("Failed to delete minigames world", var7); }
/*     */   
/*     */   }
/*     */   
/*     */   public static String getServerIp() {
/* 114 */     return ModLoader.getInstance().isDevelopmentEnvironment() ? "localhost:25565" : "gold.jab125.dev";
/*     */   }
/*     */   
/*     */   public static Result<Result.Unit, ? extends Exception> joinMultiplayerWorld(Minecraft minecraft) {
/*     */     // Byte code:
/*     */     //   0: getstatic dev/jab125/minimega/mod/client/MinimegaClient.toServeToServer : Ldev/jab125/minimega/mod/util/joindata/CreateOrJoin;
/*     */     //   3: astore_1
/*     */     //   4: aload_1
/*     */     //   5: instanceof dev/jab125/minimega/mod/util/joindata/JoinParty
/*     */     //   8: ifeq -> 28
/*     */     //   11: aload_1
/*     */     //   12: checkcast dev/jab125/minimega/mod/util/joindata/JoinParty
/*     */     //   15: astore_3
/*     */     //   16: aload_3
/*     */     //   17: invokevirtual minigame : ()Ldev/jab125/minimega/mod/util/Minigame;
/*     */     //   20: astore #4
/*     */     //   22: aload #4
/*     */     //   24: astore_2
/*     */     //   25: goto -> 35
/*     */     //   28: ldc_w 'Not join party data'
/*     */     //   31: invokestatic error : (Ljava/lang/String;)Ldev/jab125/minimega/call/Result;
/*     */     //   34: areturn
/*     */     //   35: invokestatic hasMatchmakingClient : ()Z
/*     */     //   38: ifne -> 88
/*     */     //   41: aload_0
/*     */     //   42: new net/minecraft/client/gui/screens/DisconnectedScreen
/*     */     //   45: dup
/*     */     //   46: new net/minecraft/client/gui/screens/TitleScreen
/*     */     //   49: dup
/*     */     //   50: invokespecial <init> : ()V
/*     */     //   53: invokestatic createMinigamesLandingScreen : (Lnet/minecraft/client/gui/screens/Screen;)Lnet/minecraft/client/gui/screens/Screen;
/*     */     //   56: ldc_w 'disconnect.lost'
/*     */     //   59: invokestatic translatable : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*     */     //   62: new net/minecraft/network/DisconnectionDetails
/*     */     //   65: dup
/*     */     //   66: ldc_w 'Error connecting to matchmaking server.'
/*     */     //   69: invokestatic literal : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*     */     //   72: invokespecial <init> : (Lnet/minecraft/network/chat/Component;)V
/*     */     //   75: invokespecial <init> : (Lnet/minecraft/client/gui/screens/Screen;Lnet/minecraft/network/chat/Component;Lnet/minecraft/network/DisconnectionDetails;)V
/*     */     //   78: invokevirtual setScreen : (Lnet/minecraft/client/gui/screens/Screen;)V
/*     */     //   81: ldc_w 'Error connecting to matchmaking server.'
/*     */     //   84: invokestatic error : (Ljava/lang/String;)Ldev/jab125/minimega/call/Result;
/*     */     //   87: areturn
/*     */     //   88: invokestatic isauthed : ()Z
/*     */     //   91: ifne -> 244
/*     */     //   94: invokestatic token : ()Ldev/jab125/minimega/call/Result;
/*     */     //   97: dup
/*     */     //   98: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   101: pop
/*     */     //   102: astore #4
/*     */     //   104: iconst_0
/*     */     //   105: istore #5
/*     */     //   107: aload #4
/*     */     //   109: iload #5
/*     */     //   111: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/call/Result;I)I
/*     */     //   116: tableswitch default -> 144, 0 -> 154, 1 -> 185, 2 -> 224
/*     */     //   144: new java/lang/MatchException
/*     */     //   147: dup
/*     */     //   148: aconst_null
/*     */     //   149: aconst_null
/*     */     //   150: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   153: athrow
/*     */     //   154: aload #4
/*     */     //   156: checkcast dev/jab125/minimega/call/Error
/*     */     //   159: astore #6
/*     */     //   161: aload #6
/*     */     //   163: invokevirtual val : ()Ljava/lang/Throwable;
/*     */     //   166: checkcast java/lang/Exception
/*     */     //   169: astore #8
/*     */     //   171: aload #8
/*     */     //   173: astore #7
/*     */     //   175: new dev/jab125/minimega/call/Error
/*     */     //   178: dup
/*     */     //   179: aload #7
/*     */     //   181: invokespecial <init> : (Ljava/lang/Throwable;)V
/*     */     //   184: areturn
/*     */     //   185: aload #4
/*     */     //   187: checkcast dev/jab125/minimega/call/Ok
/*     */     //   190: astore #8
/*     */     //   192: aload #8
/*     */     //   194: invokevirtual val : ()Ljava/lang/Object;
/*     */     //   197: checkcast java/lang/Boolean
/*     */     //   200: astore #10
/*     */     //   202: aload #10
/*     */     //   204: astore #9
/*     */     //   206: aload #9
/*     */     //   208: invokevirtual booleanValue : ()Z
/*     */     //   211: ifeq -> 220
/*     */     //   214: iconst_2
/*     */     //   215: istore #5
/*     */     //   217: goto -> 107
/*     */     //   220: invokestatic ok : ()Ldev/jab125/minimega/call/Ok;
/*     */     //   223: areturn
/*     */     //   224: aload #4
/*     */     //   226: checkcast dev/jab125/minimega/call/Ok
/*     */     //   229: astore #10
/*     */     //   231: aload #10
/*     */     //   233: invokevirtual val : ()Ljava/lang/Object;
/*     */     //   236: checkcast java/lang/Boolean
/*     */     //   239: astore #11
/*     */     //   241: goto -> 244
/*     */     //   244: aload_2
/*     */     //   245: invokestatic searchForLobby : (Ldev/jab125/minimega/mod/util/Minigame;)Ldev/jab125/minimega/call/Result;
/*     */     //   248: dup
/*     */     //   249: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   252: pop
/*     */     //   253: astore #5
/*     */     //   255: iconst_0
/*     */     //   256: istore #6
/*     */     //   258: aload #5
/*     */     //   260: iload #6
/*     */     //   262: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/call/Result;I)I
/*     */     //   267: tableswitch default -> 292, 0 -> 302, 1 -> 348, 2 -> 418
/*     */     //   292: new java/lang/MatchException
/*     */     //   295: dup
/*     */     //   296: aconst_null
/*     */     //   297: aconst_null
/*     */     //   298: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   301: athrow
/*     */     //   302: aload #5
/*     */     //   304: checkcast dev/jab125/minimega/call/Ok
/*     */     //   307: astore #7
/*     */     //   309: aload #7
/*     */     //   311: invokevirtual val : ()Ljava/lang/Object;
/*     */     //   314: checkcast java/util/Optional
/*     */     //   317: astore #9
/*     */     //   319: aload #9
/*     */     //   321: astore #8
/*     */     //   323: aload #8
/*     */     //   325: invokevirtual isEmpty : ()Z
/*     */     //   328: ifne -> 337
/*     */     //   331: iconst_1
/*     */     //   332: istore #6
/*     */     //   334: goto -> 258
/*     */     //   337: ldc_w 'No suitable game can be found to join.'
/*     */     //   340: invokestatic literal : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*     */     //   343: astore #4
/*     */     //   345: goto -> 451
/*     */     //   348: aload #5
/*     */     //   350: checkcast dev/jab125/minimega/call/Error
/*     */     //   353: astore #9
/*     */     //   355: aload #9
/*     */     //   357: invokevirtual val : ()Ljava/lang/Throwable;
/*     */     //   360: checkcast java/io/IOException
/*     */     //   363: astore #11
/*     */     //   365: aload #11
/*     */     //   367: astore #10
/*     */     //   369: new java/io/ByteArrayOutputStream
/*     */     //   372: dup
/*     */     //   373: invokespecial <init> : ()V
/*     */     //   376: astore #11
/*     */     //   378: aload #10
/*     */     //   380: new java/io/PrintWriter
/*     */     //   383: dup
/*     */     //   384: aload #11
/*     */     //   386: iconst_0
/*     */     //   387: getstatic java/nio/charset/StandardCharsets.UTF_8 : Ljava/nio/charset/Charset;
/*     */     //   390: invokespecial <init> : (Ljava/io/OutputStream;ZLjava/nio/charset/Charset;)V
/*     */     //   393: invokevirtual printStackTrace : (Ljava/io/PrintWriter;)V
/*     */     //   396: ldc_w 'Error connecting to matchmaking server.\\n'
/*     */     //   399: invokestatic literal : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*     */     //   402: aload #11
/*     */     //   404: getstatic java/nio/charset/StandardCharsets.UTF_8 : Ljava/nio/charset/Charset;
/*     */     //   407: invokevirtual toString : (Ljava/nio/charset/Charset;)Ljava/lang/String;
/*     */     //   410: invokevirtual append : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*     */     //   413: astore #4
/*     */     //   415: goto -> 451
/*     */     //   418: aload #5
/*     */     //   420: checkcast dev/jab125/minimega/call/Ok
/*     */     //   423: astore #11
/*     */     //   425: aload #11
/*     */     //   427: invokevirtual val : ()Ljava/lang/Object;
/*     */     //   430: checkcast java/util/Optional
/*     */     //   433: astore #13
/*     */     //   435: aload #13
/*     */     //   437: astore #12
/*     */     //   439: aload #12
/*     */     //   441: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   444: checkcast java/lang/String
/*     */     //   447: astore_3
/*     */     //   448: goto -> 498
/*     */     //   451: aload_0
/*     */     //   452: new net/minecraft/client/gui/screens/DisconnectedScreen
/*     */     //   455: dup
/*     */     //   456: new net/minecraft/client/gui/screens/TitleScreen
/*     */     //   459: dup
/*     */     //   460: invokespecial <init> : ()V
/*     */     //   463: invokestatic createMinigamesLandingScreen : (Lnet/minecraft/client/gui/screens/Screen;)Lnet/minecraft/client/gui/screens/Screen;
/*     */     //   466: ldc_w 'disconnect.lost'
/*     */     //   469: invokestatic translatable : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*     */     //   472: new net/minecraft/network/DisconnectionDetails
/*     */     //   475: dup
/*     */     //   476: aload #4
/*     */     //   478: invokespecial <init> : (Lnet/minecraft/network/chat/Component;)V
/*     */     //   481: invokespecial <init> : (Lnet/minecraft/client/gui/screens/Screen;Lnet/minecraft/network/chat/Component;Lnet/minecraft/network/DisconnectionDetails;)V
/*     */     //   484: invokevirtual setScreen : (Lnet/minecraft/client/gui/screens/Screen;)V
/*     */     //   487: aload #4
/*     */     //   489: invokeinterface getString : ()Ljava/lang/String;
/*     */     //   494: invokestatic error : (Ljava/lang/String;)Ldev/jab125/minimega/call/Result;
/*     */     //   497: areturn
/*     */     //   498: new net/minecraft/client/multiplayer/ServerData
/*     */     //   501: dup
/*     */     //   502: ldc_w 'Temporary minigame server'
/*     */     //   505: aload_3
/*     */     //   506: getstatic net/minecraft/client/multiplayer/ServerData$Type.OTHER : Lnet/minecraft/client/multiplayer/ServerData$Type;
/*     */     //   509: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Lnet/minecraft/client/multiplayer/ServerData$Type;)V
/*     */     //   512: astore #4
/*     */     //   514: aload_3
/*     */     //   515: invokestatic parseString : (Ljava/lang/String;)Lnet/minecraft/client/multiplayer/resolver/ServerAddress;
/*     */     //   518: astore #5
/*     */     //   520: new net/minecraft/client/gui/screens/TitleScreen
/*     */     //   523: dup
/*     */     //   524: invokespecial <init> : ()V
/*     */     //   527: invokestatic createMinigamesLandingScreen : (Lnet/minecraft/client/gui/screens/Screen;)Lnet/minecraft/client/gui/screens/Screen;
/*     */     //   530: aload_0
/*     */     //   531: aload #5
/*     */     //   533: aload #4
/*     */     //   535: iconst_1
/*     */     //   536: aconst_null
/*     */     //   537: invokestatic startConnecting : (Lnet/minecraft/client/gui/screens/Screen;Lnet/minecraft/client/Minecraft;Lnet/minecraft/client/multiplayer/resolver/ServerAddress;Lnet/minecraft/client/multiplayer/ServerData;ZLnet/minecraft/client/multiplayer/TransferState;)V
/*     */     //   540: invokestatic ok : ()Ldev/jab125/minimega/call/Ok;
/*     */     //   543: areturn
/*     */     //   544: astore #6
/*     */     //   546: new java/lang/MatchException
/*     */     //   549: dup
/*     */     //   550: aload #6
/*     */     //   552: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   555: aload #6
/*     */     //   557: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   560: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #118	-> 0
/*     */     //   #119	-> 4
/*     */     //   #121	-> 35
/*     */     //   #122	-> 41
/*     */     //   #123	-> 81
/*     */     //   #125	-> 88
/*     */     //   #126	-> 94
/*     */     //   #127	-> 154
/*     */     //   #128	-> 175
/*     */     //   #130	-> 185
/*     */     //   #131	-> 220
/*     */     //   #133	-> 224
/*     */     //   #138	-> 244
/*     */     //   #139	-> 302
/*     */     //   #140	-> 348
/*     */     //   #141	-> 369
/*     */     //   #142	-> 378
/*     */     //   #143	-> 396
/*     */     //   #144	-> 415
/*     */     //   #145	-> 418
/*     */     //   #146	-> 439
/*     */     //   #147	-> 448
/*     */     //   #150	-> 451
/*     */     //   #151	-> 487
/*     */     //   #154	-> 498
/*     */     //   #155	-> 514
/*     */     //   #156	-> 520
/*     */     //   #157	-> 540
/*     */     //   #145	-> 544
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   25	3	2	minigame	Ldev/jab125/minimega/mod/util/Minigame;
/*     */     //   175	10	7	e	Ljava/lang/Exception;
/*     */     //   206	18	9	b	Ljava/lang/Boolean;
/*     */     //   345	3	4	error	Lnet/minecraft/network/chat/Component;
/*     */     //   323	25	8	o	Ljava/util/Optional;
/*     */     //   378	37	11	out	Ljava/io/ByteArrayOutputStream;
/*     */     //   415	3	4	error	Lnet/minecraft/network/chat/Component;
/*     */     //   369	49	10	err	Ljava/io/IOException;
/*     */     //   448	3	3	serverIp	Ljava/lang/String;
/*     */     //   439	12	12	o	Ljava/util/Optional;
/*     */     //   451	47	4	error	Lnet/minecraft/network/chat/Component;
/*     */     //   4	540	1	right	Ldev/jab125/minimega/mod/util/joindata/CreateOrJoin;
/*     */     //   35	509	2	minigame	Ldev/jab125/minimega/mod/util/Minigame;
/*     */     //   498	46	3	serverIp	Ljava/lang/String;
/*     */     //   514	30	4	serverData	Lnet/minecraft/client/multiplayer/ServerData;
/*     */     //   520	24	5	serverAddress	Lnet/minecraft/client/multiplayer/resolver/ServerAddress;
/*     */     //   0	561	0	minecraft	Lnet/minecraft/client/Minecraft;
/*     */     // Local variable type table:
/*     */     //   start	length	slot	name	signature
/*     */     //   25	3	2	minigame	Ldev/jab125/minimega/mod/util/Minigame<*>;
/*     */     //   323	25	8	o	Ljava/util/Optional<Ljava/lang/String;>;
/*     */     //   439	12	12	o	Ljava/util/Optional<Ljava/lang/String;>;
/*     */     //   35	509	2	minigame	Ldev/jab125/minimega/mod/util/Minigame<*>;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   17	20	544	java/lang/Throwable
/*     */     //   163	166	544	java/lang/Throwable
/*     */     //   194	197	544	java/lang/Throwable
/*     */     //   233	236	544	java/lang/Throwable
/*     */     //   311	314	544	java/lang/Throwable
/*     */     //   357	360	544	java/lang/Throwable
/*     */     //   427	430	544	java/lang/Throwable
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\join\Joiner.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */