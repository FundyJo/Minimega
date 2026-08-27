package dev.jab125.minimega.mod.util.controller.glide;

import java.time.Duration;
import java.util.Optional;

import com.mojang.datafixers.util.Function3;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import com.mojang.serialization.Codec;
import dev.jab125.minimega.mod.util.controller.obj.UpdatePlayer;
import java.util.UUID;
import com.mojang.datafixers.util.Function4;
import java.util.ArrayList;
import java.util.List;
public class GlideMinigameController {

   static record PlayerProgression(String playerName, Optional<Duration> finishTime, Optional<Integer> score) {}

   static public record BeaconBeam(BlockPos blockPos, int beamLength, Direction beamDirection) {
      private static final StreamCodec<ByteBuf, BeaconBeam> STREAM_CODEC = StreamCodec.composite(BlockPos.STREAM_CODEC, BeaconBeam::blockPos, ByteBufCodecs.INT, BeaconBeam::beamLength, Direction.STREAM_CODEC, BeaconBeam::beamDirection, BeaconBeam::new);
   }

   public static class Checkpoint
   {
     public int id;
     public double x0;
     public double y0;
     public double z0;
     public double x1;
     public double y1;
     public double z1;
     public Optional<UpdatePlayer> updatePlayer = Optional.empty(); static {
       STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, a -> Integer.valueOf(a.id), ByteBufCodecs.DOUBLE, a -> Double.valueOf(a.x0), ByteBufCodecs.DOUBLE, a -> Double.valueOf(a.y0), ByteBufCodecs.DOUBLE, a -> Double.valueOf(a.z0), ByteBufCodecs.DOUBLE, a -> Double.valueOf(a.x1), ByteBufCodecs.DOUBLE, a -> Double.valueOf(a.y1), ByteBufCodecs.DOUBLE, a -> Double.valueOf(a.z1), 
   
   
   
   
   
   
           
           ByteBufCodecs.optional(ByteBufCodecs.fromCodec(UpdatePlayer.CODEC)), a -> a.updatePlayer, Checkpoint::make);
     }
     private static final StreamCodec<ByteBuf, Checkpoint> STREAM_CODEC;
     private static final Codec<Checkpoint> CODEC = GlideMinigameController.codecFromStreamCodec(STREAM_CODEC);
     
     private static Checkpoint make(int id, double x0, double y0, double z0, double x1, double y1, double z1, Optional<UpdatePlayer> updatePlayer) {
       Checkpoint checkpoint = new Checkpoint();
       checkpoint.id = id;
       checkpoint.x0 = Math.min(x0, x1);
       checkpoint.y0 = Math.min(y0, y1);
       checkpoint.z0 = Math.min(z0, z1);
       checkpoint.x1 = Math.max(x0, x1);
       checkpoint.y1 = Math.max(y0, y1);
       checkpoint.z1 = Math.max(z0, z1);
       checkpoint.updatePlayer = updatePlayer;
       return checkpoint;
     }
   }

   static record FinishedPlayers(UUID player, Duration time) {}

   static public record PlayerInformation(String playerName, int ordinal, Optional<Duration> finishTime, Optional<Integer> score) {
      private static final StreamCodec<ByteBuf, Duration> DURATION_STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.LONG, Duration::getSeconds, ByteBufCodecs.INT, Duration::getNano, Duration::ofSeconds);
     public static final StreamCodec<ByteBuf, PlayerInformation> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, PlayerInformation::playerName, ByteBufCodecs.VAR_INT, PlayerInformation::ordinal,
         ByteBufCodecs.optional(DURATION_STREAM_CODEC), PlayerInformation::finishTime,
         ByteBufCodecs.optional(ByteBufCodecs.INT), PlayerInformation::score, PlayerInformation::new);
  }

   final static class Data
     implements Cloneable
   {
     List<String> caught = new ArrayList<>();
     int points = 0;
   
   
   
   
   
     
     public Data clone() {
       Data data = new Data();
       data.caught = new ArrayList<>(this.caught);
       data.points = this.points;
       return data;
     }
   }

   static class ScoreRingData
   {
     Data current = new Data();
     Data snapshot = new Data();
   
   
     
     static final class Data
       implements Cloneable
     {
       List<String> caught = new ArrayList<>();
       int points = 0;
   
   
   
   
   
       
       public Data clone() {
         Data data = new Data();
         data.caught = new ArrayList<>(this.caught);
         data.points = this.points;
         return data;
       }
     }
   }
}
