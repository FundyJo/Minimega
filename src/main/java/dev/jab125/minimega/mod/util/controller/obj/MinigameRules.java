package dev.jab125.minimega.mod.util.controller.obj;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import java.util.function.BiFunction;
import net.minecraft.resources.Identifier;

import java.util.function.Function;
import com.mojang.serialization.MapCodec;
public class MinigameRules {

   static public record BlockUsePermissions(MinigameRules.Mode mode, List<Identifier> exceptions) {
     public static final Codec<BlockUsePermissions> CODEC;
   }

   static public record DestroyPermissions(MinigameRules.Mode mode) {
     public static final Codec<DestroyPermissions> CODEC;
   }

   static public record PlacePermissions(MinigameRules.Mode mode) {
     public static final Codec<PlacePermissions> CODEC;
   }

   static public record Sounds() {
     public static final Codec<Sounds> CODEC = MapCodec.unitCodec(new Sounds());
   }

   static public record Timers() {
     public static final Codec<Timers> CODEC = MapCodec.unitCodec(new Timers());
   }

   static public record UsePermissions(MinigameRules.Mode mode, List<Identifier> exceptions) {
     public static final Codec<UsePermissions> CODEC;
   }
}
