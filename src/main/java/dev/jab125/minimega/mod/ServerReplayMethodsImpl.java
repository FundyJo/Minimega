/*    */ package dev.jab125.minimega.mod;
/*    */ 
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ 
/*    */ public class ServerReplayMethodsImpl {
/*    */   public ServerReplayMethodsImpl() {
/*  7 */     setup();
/*    */   }
/*    */   
/*    */   private void setup() {
/* 11 */     ServerReplayMethods.startRecording = (player -> Boolean.valueOf(false));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\ServerReplayMethodsImpl.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */