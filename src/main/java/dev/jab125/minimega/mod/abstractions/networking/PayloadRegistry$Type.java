package dev.jab125.minimega.mod.abstractions.networking;

import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public interface Type<B extends net.minecraft.network.FriendlyByteBuf> {
  <T extends CustomPacketPayload> CustomPacketPayload.TypeAndCodec<? super B, T> register(CustomPacketPayload.Type<T> paramType, StreamCodec<? super B, T> paramStreamCodec);
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\abstractions\networking\PayloadRegistry$Type.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */