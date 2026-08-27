package dev.jab125.minimega.grf.newelements.mxml.gui;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Decoder;
import com.mojang.serialization.DynamicOps;
import dev.jab125.minimega.grf.newelements.mxml.IMXml;
import java.util.List;

public record Unfinished(List<IMXml> childRules, String serializedId) implements IMXml {
  public static final Decoder<Unfinished> CODEC = new Decoder<>() {
    public <T> DataResult<Pair<Unfinished, T>> decode(DynamicOps<T> ops, T input) {
      return ops.get(input, "childRules")
          .flatMap(childRules -> GuiCodecs.CODEC.listOf().decode(ops, childRules))
          .flatMap(children -> ops.get(input, "__$INTERNAL_ID$__")
              .flatMap(ops::getStringValue)
              .map(id -> Pair.of(new Unfinished(children.getFirst(), id), children.getSecond())));
    }
  };
}
