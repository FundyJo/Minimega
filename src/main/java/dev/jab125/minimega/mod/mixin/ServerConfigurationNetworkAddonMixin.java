/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ 
/*    */ import dev.jab125.minimega.mod.util.ExtraServerConfigurationConnectionEvents;
/*    */ import net.fabricmc.fabric.api.networking.v1.ServerConfigurationConnectionEvents;
/*    */ import net.fabricmc.fabric.impl.networking.server.ServerConfigurationNetworkAddon;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.server.network.ServerConfigurationPacketListenerImpl;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({ServerConfigurationNetworkAddon.class})
/*    */ public class ServerConfigurationNetworkAddonMixin {
/*    */   @Shadow
/*    */   @Final
/*    */   private ServerConfigurationPacketListenerImpl listener;
/*    */   @Shadow
/*    */   @Final
/*    */   private MinecraftServer server;
/*    */   
/*    */   @Inject(method = {"preConfiguration"}, at = {@At("HEAD")}, remap = false)
/*    */   void mm$preConfiguration(CallbackInfo ci) {
/* 26 */     ((ServerConfigurationConnectionEvents.Configure)ExtraServerConfigurationConnectionEvents.BEFORE_BEFORE_CONFIGURE.invoker()).onSendConfiguration(this.listener, this.server);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\ServerConfigurationNetworkAddonMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */