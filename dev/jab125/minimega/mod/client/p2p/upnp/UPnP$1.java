/*    */ package dev.jab125.minimega.mod.client.p2p.upnp;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GatewayFinder
/*    */ {
/*    */   public void gatewayFound(Gateway g) {
/* 43 */     synchronized (UPnP.finder) {
/* 44 */       if (UPnP.defaultGW == null)
/* 45 */         UPnP.defaultGW = g; 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\p2\\upnp\UPnP$1.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */