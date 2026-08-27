/*    */ package dev.jab125.minimega.mod.client.compat.controlify;
/*    */ 
/*    */ import dev.isxander.controlify.api.ControlifyApi;
/*    */ import dev.isxander.controlify.api.entrypoint.ControlifyEntrypoint;
/*    */ import dev.isxander.controlify.api.entrypoint.InitContext;
/*    */ import dev.isxander.controlify.api.entrypoint.PreInitContext;
/*    */ import dev.isxander.controlify.api.guide.Fact;
/*    */ import dev.isxander.controlify.api.guide.InGameCtx;
/*    */ import dev.isxander.controlify.gui.guide.GuideDomains;
/*    */ import dev.isxander.controlify.platform.client.PlatformClientUtil;
/*    */ import dev.isxander.controlify.platform.client.resource.ControlifyReloadListener;
/*    */ import dev.isxander.controlify.screenop.ScreenProcessorFactory;
/*    */ import dev.isxander.controlify.screenop.ScreenProcessorProvider;
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import dev.jab125.minimega.mod.client.MinimegaClient;
/*    */ import dev.jab125.minimega.mod.client.extension.MinecraftExtension;
/*    */ import dev.jab125.minimega.mod.client.gui.screen.minigame.MinigamesLandingScreen;
/*    */ import dev.jab125.minimega.mod.client.gui.screen.minigame.NewDataScreen;
/*    */ import dev.jab125.minimega.mod.client.gui.screen.minigame.SelectMapsScreen;
/*    */ import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
/*    */ import dev.jab125.minimega.mod.util.controller.battle.BattleMinigameController;
/*    */ import dev.jab125.minimega.mod.util.minigamedata.BattleConfig;
/*    */ import dev.jab125.minimega.mod.util.minigamedata.MinigameSpecificConfig;
/*    */ import dev.jab125.minimega.mod.util.minigamedata.battle.BattleConfigSettings;
/*    */ 
/*    */ 
/*    */ public class MinimegaControlifyEntrypoint
/*    */   implements ControlifyEntrypoint
/*    */ {
/*    */   public void onControlifyPreInit(PreInitContext preInitContext) {
/* 31 */     ScreenProcessorProvider.registerProvider(NewDataScreen.class, dev.jab125.minimega.mod.client.compat.controlify.screen.DataScreenProcessor::new);
/* 32 */     ScreenProcessorProvider.registerProvider(SelectMapsScreen.class, dev.jab125.minimega.mod.client.compat.controlify.screen.CancelButtonScreenProcessor::new);
/* 33 */     ScreenProcessorProvider.registerProvider(MinigamesLandingScreen.class, dev.jab125.minimega.mod.client.compat.controlify.screen.CancelButtonScreenProcessor::new);
/*    */ 
/*    */     
/* 36 */     MinimegaDomains.IN_GAME_LOBBY.registerFact(Fact.of(Minimega.id("ready"), inGameCtx -> ((MinecraftExtension)inGameCtx.inGameCtx().client()).mm$isReady()));
/* 37 */     MinimegaDomains.IN_GAME_GLIDE.registerFact(Fact.of(Minimega.id("axalxefox"), this::handle));
/* 38 */     GuideDomains.IN_GAME.registerFact(Fact.of(Minimega.id("aeeeeee"), this::canSqueak));
/* 39 */     MinimegaDomains.freeze();
/* 40 */     PlatformClientUtil.registerAssetReloadListener((ControlifyReloadListener)MinimegaDomains.IN_GAME_GLIDE);
/* 41 */     PlatformClientUtil.registerAssetReloadListener((ControlifyReloadListener)MinimegaDomains.IN_GAME_LOBBY);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean handle(InGameGlideCtx inGameCtx) {
/*    */     // Byte code:
/*    */     //   0: invokestatic getMinigameController : ()Ldev/jab125/minimega/mod/util/controller/AbstractMinigameController;
/*    */     //   3: astore_3
/*    */     //   4: aload_3
/*    */     //   5: instanceof dev/jab125/minimega/mod/util/controller/glide/GlideMinigameController
/*    */     //   8: ifeq -> 142
/*    */     //   11: aload_3
/*    */     //   12: checkcast dev/jab125/minimega/mod/util/controller/glide/GlideMinigameController
/*    */     //   15: astore_2
/*    */     //   16: aload_2
/*    */     //   17: invokevirtual getMinigameData : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameData;
/*    */     //   20: invokevirtual config : ()Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;
/*    */     //   23: dup
/*    */     //   24: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*    */     //   27: pop
/*    */     //   28: astore #5
/*    */     //   30: iconst_0
/*    */     //   31: istore #6
/*    */     //   33: aload #5
/*    */     //   35: iload #6
/*    */     //   37: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/mod/util/minigamedata/MinigameSpecificConfig;I)I
/*    */     //   42: lookupswitch default -> 108, 0 -> 60
/*    */     //   60: aload #5
/*    */     //   62: checkcast dev/jab125/minimega/mod/util/minigamedata/GlideConfig
/*    */     //   65: astore #4
/*    */     //   67: aload #4
/*    */     //   69: invokevirtual type : ()Ldev/jab125/minimega/mod/util/controller/glide/GlideGameType;
/*    */     //   72: astore #7
/*    */     //   74: aload #4
/*    */     //   76: invokevirtual solo : ()Z
/*    */     //   79: istore #7
/*    */     //   81: iload #7
/*    */     //   83: istore #8
/*    */     //   85: iconst_1
/*    */     //   86: ifeq -> 95
/*    */     //   89: iload #7
/*    */     //   91: istore_3
/*    */     //   92: goto -> 101
/*    */     //   95: iconst_1
/*    */     //   96: istore #6
/*    */     //   98: goto -> 33
/*    */     //   101: iload_3
/*    */     //   102: ifeq -> 140
/*    */     //   105: goto -> 111
/*    */     //   108: goto -> 140
/*    */     //   111: aload_2
/*    */     //   112: invokevirtual getStage : ()I
/*    */     //   115: iconst_2
/*    */     //   116: if_icmpne -> 140
/*    */     //   119: invokestatic getInstance : ()Lnet/minecraft/client/Minecraft;
/*    */     //   122: getfield player : Lnet/minecraft/client/player/LocalPlayer;
/*    */     //   125: checkcast dev/jab125/minimega/mod/extension/EntityExtension
/*    */     //   128: invokeinterface mm$finishedMap : ()Z
/*    */     //   133: ifne -> 140
/*    */     //   136: iconst_1
/*    */     //   137: goto -> 141
/*    */     //   140: iconst_0
/*    */     //   141: ireturn
/*    */     //   142: iconst_0
/*    */     //   143: ireturn
/*    */     //   144: astore_2
/*    */     //   145: new java/lang/MatchException
/*    */     //   148: dup
/*    */     //   149: aload_2
/*    */     //   150: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   153: aload_2
/*    */     //   154: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*    */     //   157: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #45	-> 0
/*    */     //   #46	-> 16
/*    */     //   #48	-> 142
/*    */     //   #45	-> 144
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   92	3	3	solo	Z
/*    */     //   101	7	3	solo	Z
/*    */     //   111	29	3	solo	Z
/*    */     //   16	126	2	controller	Ldev/jab125/minimega/mod/util/controller/glide/GlideMinigameController;
/*    */     //   0	158	0	this	Ldev/jab125/minimega/mod/client/compat/controlify/MinimegaControlifyEntrypoint;
/*    */     //   0	158	1	inGameCtx	Ldev/jab125/minimega/mod/client/compat/controlify/InGameGlideCtx;
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   69	72	144	java/lang/Throwable
/*    */     //   76	79	144	java/lang/Throwable
/*    */   }
/*    */ 
/*    */   
/*    */   private boolean canSqueak(InGameCtx inGameCtx) {
/* 52 */     AbstractMinigameController abstractMinigameController = MinimegaClient.getMinigameController(); if (abstractMinigameController instanceof BattleMinigameController) { BattleMinigameController controller = (BattleMinigameController)abstractMinigameController; MinigameSpecificConfig minigameSpecificConfig = controller.getMinigameData().config(); if (minigameSpecificConfig instanceof BattleConfig) { BattleConfig battleConfig = (BattleConfig)minigameSpecificConfig; try { BattleConfigSettings battleConfigSettings1 = battleConfig.settings(), settings = battleConfigSettings1; if (settings.spectatorMode().canSqueak() && inGameCtx.player().isSpectator() && inGameCtx.client().getCameraEntity() == inGameCtx.player()); return false; } catch (Throwable throwable) { throw new MatchException(throwable.toString(), throwable); }  }  }  return false;
/*    */   }
/*    */   
/*    */   public void onControlifyInit(InitContext initContext) {}
/*    */   
/*    */   public void onControllersDiscovered(ControlifyApi controlifyApi) {}
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\compat\controlify\MinimegaControlifyEntrypoint.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */