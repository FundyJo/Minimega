/*    */ package dev.jab125.minimega.mod.client.mixin;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import dev.jab125.minimega.mod.client.MinimegaClient;
/*    */ import net.minecraft.client.DeltaTracker;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.Font;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin(value = {Gui.class}, priority = 900)
/*    */ public abstract class GuiMixin
/*    */ {
/*    */   @Shadow
/*    */   @Final
/*    */   private Minecraft minecraft;
/*    */   
/*    */   @Shadow
/*    */   @Nullable
/*    */   protected abstract Player getCameraPlayer();
/*    */   
/*    */   @Shadow
/*    */   public abstract Font getFont();
/*    */   
/*    */   @WrapMethod(method = {"extractRenderState"})
/*    */   void rM(GuiGraphicsExtractor guiGraphics, DeltaTracker deltaTracker, Operation<Void> original) {
/* 42 */     if (this.minecraft.screen instanceof dev.jab125.minimega.mod.client.gui.screen.MapTransitionScreen)
/* 43 */       return;  original.call(new Object[] { guiGraphics, deltaTracker });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Inject(method = {"extractHotbarAndDecorations"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void r(GuiGraphicsExtractor guiGraphics, DeltaTracker deltaTracker, CallbackInfo ci) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield minecraft : Lnet/minecraft/client/Minecraft;
/*    */     //   4: getfield gameMode : Lnet/minecraft/client/multiplayer/MultiPlayerGameMode;
/*    */     //   7: invokevirtual getPlayerMode : ()Lnet/minecraft/world/level/GameType;
/*    */     //   10: getstatic net/minecraft/world/level/GameType.SPECTATOR : Lnet/minecraft/world/level/GameType;
/*    */     //   13: if_acmpne -> 17
/*    */     //   16: return
/*    */     //   17: invokestatic getMinigame : ()Ldev/jab125/minimega/mod/util/Minigame;
/*    */     //   20: getstatic dev/jab125/minimega/mod/util/Minigame.NONE : Ldev/jab125/minimega/mod/util/Minigame;
/*    */     //   23: if_acmpne -> 27
/*    */     //   26: return
/*    */     //   27: getstatic dev/jab125/minimega/mod/client/gui/bar/FourJBar.payload : Ldev/jab125/minimega/mod/party/PlayerSlotObjs;
/*    */     //   30: astore #4
/*    */     //   32: iconst_0
/*    */     //   33: istore #5
/*    */     //   35: aload #4
/*    */     //   37: iload #5
/*    */     //   39: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/mod/party/PlayerSlotObjs;I)I
/*    */     //   44: lookupswitch default -> 140, -1 -> 140, 0 -> 72
/*    */     //   72: aload #4
/*    */     //   74: astore #6
/*    */     //   76: aload #6
/*    */     //   78: invokevirtual list : ()Ljava/util/List;
/*    */     //   81: astore #9
/*    */     //   83: aload #9
/*    */     //   85: astore #7
/*    */     //   87: aload #6
/*    */     //   89: invokevirtual slotsMetadata : ()Ldev/jab125/minimega/mod/party/SlotsMetadata;
/*    */     //   92: astore #9
/*    */     //   94: aload #9
/*    */     //   96: instanceof dev/jab125/minimega/mod/party/GlideSlotsMetadata
/*    */     //   99: ifeq -> 112
/*    */     //   102: aload #9
/*    */     //   104: checkcast dev/jab125/minimega/mod/party/GlideSlotsMetadata
/*    */     //   107: astore #8
/*    */     //   109: goto -> 118
/*    */     //   112: iconst_1
/*    */     //   113: istore #5
/*    */     //   115: goto -> 35
/*    */     //   118: aload_0
/*    */     //   119: checkcast net/minecraft/client/gui/Gui
/*    */     //   122: aload_0
/*    */     //   123: invokevirtual getCameraPlayer : ()Lnet/minecraft/world/entity/player/Player;
/*    */     //   126: aload #8
/*    */     //   128: aload_1
/*    */     //   129: aload_2
/*    */     //   130: invokestatic renderGlideHotbar : (Lnet/minecraft/client/gui/Gui;Lnet/minecraft/world/entity/player/Player;Ldev/jab125/minimega/mod/party/GlideSlotsMetadata;Lnet/minecraft/client/gui/GuiGraphicsExtractor;Lnet/minecraft/client/DeltaTracker;)V
/*    */     //   133: aload_3
/*    */     //   134: invokevirtual cancel : ()V
/*    */     //   137: goto -> 143
/*    */     //   140: goto -> 143
/*    */     //   143: goto -> 163
/*    */     //   146: astore #4
/*    */     //   148: new java/lang/MatchException
/*    */     //   151: dup
/*    */     //   152: aload #4
/*    */     //   154: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   157: aload #4
/*    */     //   159: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*    */     //   162: athrow
/*    */     //   163: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #48	-> 0
/*    */     //   #49	-> 17
/*    */     //   #50	-> 27
/*    */     //   #51	-> 72
/*    */     //   #52	-> 118
/*    */     //   #53	-> 133
/*    */     //   #54	-> 137
/*    */     //   #55	-> 140
/*    */     //   #51	-> 146
/*    */     //   #58	-> 163
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   109	3	8	slotsMetadata	Ldev/jab125/minimega/mod/party/GlideSlotsMetadata;
/*    */     //   87	53	7	ignored	Ljava/util/List;
/*    */     //   118	22	8	slotsMetadata	Ldev/jab125/minimega/mod/party/GlideSlotsMetadata;
/*    */     //   0	164	0	this	Ldev/jab125/minimega/mod/client/mixin/GuiMixin;
/*    */     //   0	164	1	guiGraphics	Lnet/minecraft/client/gui/GuiGraphicsExtractor;
/*    */     //   0	164	2	deltaTracker	Lnet/minecraft/client/DeltaTracker;
/*    */     //   0	164	3	ci	Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfo;
/*    */     // Local variable type table:
/*    */     //   start	length	slot	name	signature
/*    */     //   87	53	7	ignored	Ljava/util/List<Ldev/jab125/minimega/mod/party/PlayerSlotObj;>;
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   78	81	146	java/lang/Throwable
/*    */     //   89	92	146	java/lang/Throwable
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @WrapMethod(method = {"extractPlayerHealth"})
/*    */   void renderHearts(GuiGraphicsExtractor guiGraphics, Operation<Void> original) {
/* 62 */     if (!(MinimegaClient.getMinigameController().minigameAbilities()).bareHotbar) original.call(new Object[] { guiGraphics }); 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\GuiMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */