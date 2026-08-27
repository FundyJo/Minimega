package dev.jab125.minimega.mod.client.p2p.upnp;

public interface PortBuilder {
  PortBuilder internalPort(int paramInt);
  
  PortBuilder externalPort(int paramInt);
  
  PortBuilder udp();
  
  PortBuilder tcp();
  
  boolean open();
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\p2\\upnp\UPnP$PortBuilder.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */