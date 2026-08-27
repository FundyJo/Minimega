package dev.jab125.minimega.mod.util.controller;

import io.netty.buffer.ByteBuf;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.network.codec.StreamCodec;

public class MinigameAbilities {
  public record Patcher<T>(Supplier<StreamCodec<ByteBuf, T>> streamCodec, BiConsumer<MinigameAbilities, T> setter, Function<MinigameAbilities, T> getter) {
    public Patcher(StreamCodec<ByteBuf, T> streamCodec, BiConsumer<MinigameAbilities, T> setter, Function<MinigameAbilities, T> getter) {
      this(() -> streamCodec, setter, getter);
    }
  }
}
