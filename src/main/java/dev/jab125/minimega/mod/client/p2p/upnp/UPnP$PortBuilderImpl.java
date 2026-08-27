/*     */ package dev.jab125.minimega.mod.client.p2p.upnp;
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
/*     */ class PortBuilderImpl
/*     */   implements UPnP.PortBuilder
/*     */ {
/*     */   private int internalPort;
/*     */   private boolean setInternalPort;
/*     */   private int externalPort;
/*     */   private boolean setExternalPort;
/*     */   private boolean mode;
/*     */   private boolean setMode;
/*     */   
/*     */   public UPnP.PortBuilder internalPort(int port) {
/* 115 */     this.setInternalPort = true;
/* 116 */     this.internalPort = port;
/* 117 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public UPnP.PortBuilder externalPort(int port) {
/* 122 */     this.setExternalPort = true;
/* 123 */     this.externalPort = port;
/* 124 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public UPnP.PortBuilder udp() {
/* 129 */     this.setMode = true;
/* 130 */     this.mode = true;
/* 131 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public UPnP.PortBuilder tcp() {
/* 136 */     this.setMode = true;
/* 137 */     this.mode = false;
/* 138 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean open() {
/* 144 */     if (!this.setMode || !this.setInternalPort || !this.setExternalPort) throw new NullPointerException(); 
/* 145 */     return UPnP.defaultGW.openPort(this.internalPort, this.externalPort, this.mode);
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\p2\\upnp\UPnP$PortBuilderImpl.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */