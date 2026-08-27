/*     */ package dev.jab125.minimega.mod.client.p2p;
/*     */ 
/*     */ import dev.jab125.minimega.mod.Minimega;
/*     */ import dev.jab125.minimega.mod.client.MinimegaClient;
/*     */ import dev.jab125.minimega.mod.client.p2p.upnp.UPnP;
/*     */ import dev.jab125.minimega.mod.extension.MinecraftServerExtension;
/*     */ import dev.jab125.minimega.mod.util.HostingMethod;
/*     */ import java.io.IOException;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.Socket;
/*     */ import java.util.concurrent.CompletableFuture;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.network.chat.ComponentUtils;
/*     */ import net.minecraft.network.chat.MutableComponent;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.HttpUtil;
/*     */ import net.minecraft.world.level.GameType;
/*     */ 
/*     */ 
/*     */ public class Player2Player
/*     */ {
/*     */   private static final int PORT = 1501;
/*  23 */   public static CompletableFuture<Component> completableFuture = new CompletableFuture<>();
/*     */   
/*     */   public static CompletableFuture<Component> hostWorldToTheWorldWideWeb(MinecraftServer server, Minimega.WWWTicket ticket) {
/*  26 */     MinecraftServerExtension extension = (MinecraftServerExtension)server;
/*  27 */     if (server.isPublished()) throw new RuntimeException("bruh"); 
/*  28 */     HostingMethod hostingMethod = extension.mm$getHostingMethod(ticket);
/*  29 */     if (hostingMethod == HostingMethod.LAN) {
/*  30 */       int internalPort = HttpUtil.getAvailablePort();
/*  31 */       completableFuture = new CompletableFuture<>();
/*  32 */       if (!server.publishServer(GameType.SURVIVAL, false, internalPort)) {
/*  33 */         throw new RuntimeException("failed to open singleplayer world to multiplayer");
/*     */       }
/*  35 */       return completableFuture = CompletableFuture.completedFuture(getSuccessMessage("" + internalPort));
/*     */     } 
/*  37 */     if (hostingMethod == HostingMethod.E4MC) {
/*  38 */       int internalPort = HttpUtil.getAvailablePort();
/*  39 */       completableFuture = new CompletableFuture<>();
/*  40 */       if (!server.publishServer(GameType.SURVIVAL, false, internalPort)) {
/*  41 */         throw new RuntimeException("failed to open singleplayer world to multiplayer");
/*     */       }
/*  43 */       return completableFuture;
/*     */     } 
/*     */     try {
/*  46 */       assert MinimegaClient.internalPort == null || MinimegaClient.externalPort != null;
/*  47 */       if (MinimegaClient.internalPort != null) {
/*  48 */         if (!server.publishServer(GameType.SURVIVAL, false, MinimegaClient.internalPort.intValue())) {
/*  49 */           throw new RuntimeException("failed to open singleplayer world to multiplayer");
/*     */         }
/*  51 */         String ip = UPnP.unisGetExternalIP();
/*  52 */         extension.mm$setMMIP(ip, MinimegaClient.externalPort.intValue());
/*  53 */         return (CompletableFuture)CompletableFuture.completedFuture(getSuccessMessage(ip + ":" + ip));
/*     */       } 
/*  55 */       if (!UPnP.isUPnPAvailable()) throw new RuntimeException("UPnP not available!"); 
/*  56 */       int attempts = 10;
/*  57 */       int internalPort = HttpUtil.getAvailablePort();
/*  58 */       int externalPort = internalPort;
/*     */       
/*     */       while (true) {
/*  61 */         if (attempts > 0) {
/*  62 */           if (!UPnP.isMappedTCP(externalPort)) {
/*  63 */             System.out.println("found an actual working port!");
/*     */             break;
/*     */           } 
/*  66 */           System.err.println("port already mapped, trying again.");
/*  67 */           externalPort = HttpUtil.getAvailablePort();
/*     */           
/*  69 */           attempts--; continue;
/*     */         } 
/*  71 */         throw new RuntimeException("no port?!?");
/*     */       } 
/*  73 */       if (!server.publishServer(GameType.SURVIVAL, false, internalPort)) {
/*  74 */         throw new RuntimeException("failed to open singleplayer world to multiplayer");
/*     */       }
/*  76 */       if (UPnP.openPort().tcp().internalPort(internalPort).externalPort(externalPort).open()) {
/*  77 */         extension.mm$setMMIP(UPnP.getExternalIP(), externalPort);
/*  78 */         return (CompletableFuture)CompletableFuture.completedFuture(getSuccessMessage(UPnP.getExternalIP() + ":" + UPnP.getExternalIP()));
/*     */       } 
/*  80 */       throw new RuntimeException("failed to open port!");
/*     */     }
/*  82 */     catch (Throwable t) {
/*  83 */       return CompletableFuture.failedFuture(t);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static MutableComponent getSuccessMessage(String adrs) {
/*  88 */     MutableComponent mutableComponent = ComponentUtils.copyOnClickText(adrs);
/*  89 */     return Component.translatable("commands.publish.started", new Object[] { mutableComponent });
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws IOException {
/*  93 */     ServerSocket serverSocket = new ServerSocket(1501);
/*  94 */     n("socket", new Thread(() -> {
/*     */             while (true) {
/*     */               try {
/*     */                 while (true) {
/*     */                   Socket socket = serverSocket.accept(); String txt = "Received connection from " + String.valueOf(socket.getInetAddress()) + "!"; System.out.println(txt); socket.close();
/*     */                 } 
/*     */                 break;
/* 101 */               } catch (Throwable t) {
/*     */                 System.err.println("network error " + String.valueOf(t));
/*     */               } 
/*     */             } 
/* 105 */           })).start();
/* 106 */     if (!UPnP.isUPnPAvailable()) {
/* 107 */       System.err.println("UPnP is not available");
/*     */       return;
/*     */     } 
/* 110 */     if (UPnP.isMappedUDP(1501)) {
/* 111 */       System.err.println("Port already mapped");
/*     */       return;
/*     */     } 
/* 114 */     if (UPnP.openPortTCP(1501)) {
/* 115 */       System.out.println("successfully opened port");
/*     */     } else {
/* 117 */       System.err.println("port open failed.");
/*     */     } 
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
/*     */   private static Thread n(String socket, Thread thread) {
/* 130 */     thread.setName(socket);
/* 131 */     return thread;
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\p2p\Player2Player.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */