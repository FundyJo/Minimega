/*    */ package dev.jab125.minimega.mod.networking;
/*    */ 
/*    */ import dev.jab125.minimega.mod.abstractions.networking.PayloadRegistry;
/*    */ import dev.jab125.minimega.mod.networking.payload.C2S2CMinimegaProtocolVersionPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.C2SFinishedMapLoadingPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.C2SJoiningChoicePayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.C2SLinkPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.C2SLinkScreenClosedPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.C2SPacksDownloadedPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.C2SReadyPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.C2SRecreationPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.C2SRestartPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.C2SSqueakPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.C2STakeAllPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.C2STimerSynchronizationPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.C2SVotePayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.S2CCheckpointsRespawnUpdatePayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.S2CDisplayShieldPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.S2CDisplayTextPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.S2CDownloadResourcePacksPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.S2CGlideFinishPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.S2CGlobalSoundPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.S2CJoiningChoicePayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.S2CLinkPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.S2CLinkScreenUpdatePayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.S2CMapTransitionStartPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.S2CMatchToSubmit;
/*    */ import dev.jab125.minimega.mod.networking.payload.S2COpenDataScreenPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.S2CPlayerPositionsPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.S2CPlayerSlotObjPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.S2CScoreRingCollisionPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.S2CStatusPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.S2CThermalsPayload;
/*    */ import dev.jab125.minimega.mod.networking.payload.S2CTimerSynchronizationPayload;
/*    */ 
/*    */ public class ModNetworking {
/*    */   public static void registerPayloads(PayloadRegistry registry) {
/* 38 */     registry.configurationS2C().register(S2CJoiningChoicePayload.TYPE, S2CJoiningChoicePayload.STREAM_CODEC);
/* 39 */     registry.configurationC2S().register(C2SJoiningChoicePayload.TYPE, C2SJoiningChoicePayload.STREAM_CODEC);
/* 40 */     registry.configurationS2C().register(S2CLinkScreenUpdatePayload.TYPE, S2CLinkScreenUpdatePayload.STREAM_CODEC);
/* 41 */     registry.configurationC2S().register(C2SLinkScreenClosedPayload.TYPE, C2SLinkScreenClosedPayload.STREAM_CODEC);
/* 42 */     registry.configurationS2C().register(S2CLinkPayload.TYPE, S2CLinkPayload.STREAM_CODEC);
/* 43 */     registry.configurationC2S().register(C2SLinkPayload.TYPE, C2SLinkPayload.STREAM_CODEC);
/* 44 */     registry.playC2S().register(C2SFinishedMapLoadingPayload.TYPE, C2SFinishedMapLoadingPayload.STREAM_CODEC);
/* 45 */     registry.playS2C().register(S2CDisplayTextPayload.TYPE, S2CDisplayTextPayload.STREAM_CODEC);
/* 46 */     registry.playS2C().register(S2CStatusPayload.TYPE, S2CStatusPayload.STREAM_CODEC);
/* 47 */     registry.playS2C().register(S2CMapTransitionStartPayload.TYPE, S2CMapTransitionStartPayload.STREAM_CODEC);
/* 48 */     registry.playS2C().register(S2CThermalsPayload.TYPE, S2CThermalsPayload.STREAM_CODEC);
/* 49 */     registry.playS2C().register(S2CScoreRingCollisionPayload.TYPE, S2CScoreRingCollisionPayload.STREAM_CODEC);
/* 50 */     registry.playS2C().register(S2CGlideFinishPayload.TYPE, S2CGlideFinishPayload.STREAM_CODEC);
/* 51 */     registry.playS2C().register(S2CTimerSynchronizationPayload.TYPE, S2CTimerSynchronizationPayload.STREAM_CODEC);
/* 52 */     registry.playS2C().register(S2CPlayerPositionsPayload.TYPE, S2CPlayerPositionsPayload.STREAM_CODEC);
/* 53 */     registry.playS2C().register(S2CCheckpointsRespawnUpdatePayload.TYPE, S2CCheckpointsRespawnUpdatePayload.STREAM_CODEC);
/* 54 */     registry.playS2C().register(S2CMatchToSubmit.TYPE, S2CMatchToSubmit.STREAM_CODEC);
/* 55 */     registry.playS2C().register(S2CPlayerSlotObjPayload.TYPE, S2CPlayerSlotObjPayload.STREAM_CODEC);
/* 56 */     registry.playS2C().register(S2CDisplayShieldPayload.TYPE, S2CDisplayShieldPayload.STREAM_CODEC);
/* 57 */     registry.playS2C().register(S2COpenDataScreenPayload.TYPE, S2COpenDataScreenPayload.STREAM_CODEC);
/* 58 */     registry.playS2C().register(S2CGlobalSoundPayload.TYPE, S2CGlobalSoundPayload.STREAM_CODEC);
/* 59 */     registry.playC2S().register(C2SReadyPayload.TYPE, C2SReadyPayload.CODEC);
/* 60 */     registry.playC2S().register(C2SVotePayload.TYPE, C2SVotePayload.CODEC);
/* 61 */     registry.playC2S().register(C2STimerSynchronizationPayload.TYPE, C2STimerSynchronizationPayload.STREAM_CODEC);
/* 62 */     registry.playC2S().register(C2SRestartPayload.TYPE, C2SRestartPayload.STREAM_CODEC);
/* 63 */     registry.playC2S().register(C2STakeAllPayload.TYPE, C2STakeAllPayload.STREAM_CODEC);
/* 64 */     registry.playC2S().register(C2SSqueakPayload.TYPE, C2SSqueakPayload.STREAM_CODEC);
/* 65 */     registry.playC2S().register(C2SRecreationPayload.TYPE, C2SRecreationPayload.STREAM_CODEC);
/* 66 */     registry.configurationS2C().register(C2S2CMinimegaProtocolVersionPayload.TYPE, C2S2CMinimegaProtocolVersionPayload.STREAM_CODEC);
/* 67 */     registry.configurationS2C().register(S2CDownloadResourcePacksPayload.TYPE, S2CDownloadResourcePacksPayload.STREAM_CODEC);
/* 68 */     registry.configurationC2S().register(C2S2CMinimegaProtocolVersionPayload.TYPE, C2S2CMinimegaProtocolVersionPayload.STREAM_CODEC);
/* 69 */     registry.configurationC2S().register(C2SPacksDownloadedPayload.TYPE, C2SPacksDownloadedPayload.STREAM_CODEC);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\networking\ModNetworking.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */