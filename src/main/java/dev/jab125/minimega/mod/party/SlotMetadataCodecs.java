package dev.jab125.minimega.mod.party;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import io.netty.buffer.ByteBuf;
import java.util.Map;
import java.util.function.Function;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public class SlotMetadataCodecs {
  @SafeVarargs
  public static <T> StreamCodec<ByteBuf, T> ofInterface(Function<T, Integer> typeResolver, StreamCodec<? super ByteBuf, ? extends T>... codecs) {
    return new StreamCodec<>() {
      public T decode(ByteBuf input) {
        int type = ByteBufCodecs.VAR_INT.decode(input);
        return codecs[type].decode(input);
      }

      public void encode(ByteBuf output, T value) {
        int type = typeResolver.apply(value);
        ByteBufCodecs.VAR_INT.encode(output, type);
        ((StreamCodec<ByteBuf, T>)codecs[type]).encode(output, value);
      }
    };
  }

  @SafeVarargs
  public static <T> Codec<T> ofInterface(Function<T, Integer> typeResolver, Codec<? extends T>... codecs) {
    return new Codec<>() {
      public <T1> DataResult<Pair<T, T1>> decode(DynamicOps<T1> ops, T1 input) {
        return ops.getMap(input).flatMap(map -> ops.getNumberValue(map.get("type"))
            .flatMap(type -> codecs[type.intValue()].decode(ops, map.get("value")))
            .map(result -> Pair.of(result.getFirst(), input)));
      }

      public <T1> DataResult<T1> encode(T input, DynamicOps<T1> ops, T1 prefix) {
        int type = typeResolver.apply(input);
        return ((Codec<T>)codecs[type]).encode(input, ops, prefix)
            .map(value -> ops.createMap(Map.of(ops.createString("type"), ops.createInt(type), ops.createString("value"), value)));
      }
    };
  }
}
