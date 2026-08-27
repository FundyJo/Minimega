package dev.jab125.minimega.mod.abstractions.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public interface PayloadRegistry {
  Type<FriendlyByteBuf> configurationC2S();
  
  Type<FriendlyByteBuf> configurationS2C();
  
  Type<RegistryFriendlyByteBuf> playC2S();
  
  Type<RegistryFriendlyByteBuf> playS2C();
  
  public static interface Type<B extends FriendlyByteBuf> {
    <T extends CustomPacketPayload> CustomPacketPayload.TypeAndCodec<? super B, T> register(CustomPacketPayload.Type<T> param1Type, StreamCodec<? super B, T> param1StreamCodec);
  }
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\abstractions\networking\PayloadRegistry.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */