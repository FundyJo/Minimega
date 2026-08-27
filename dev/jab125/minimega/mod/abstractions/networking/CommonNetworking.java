package dev.jab125.minimega.mod.abstractions.networking;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public interface CommonNetworking {
  Packet<?> play(CustomPacketPayload paramCustomPacketPayload);
  
  Packet<?> configuration(CustomPacketPayload paramCustomPacketPayload);
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\abstractions\networking\CommonNetworking.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */