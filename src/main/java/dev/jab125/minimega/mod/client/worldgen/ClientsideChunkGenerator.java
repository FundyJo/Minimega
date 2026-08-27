package dev.jab125.minimega.mod.client.worldgen;

import it.unimi.dsi.fastutil.Pair;
import java.util.List;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.chunk.LevelChunk;
import xyz.nucleoid.map_templates.MapTemplate;

public class ClientsideChunkGenerator {
  protected final ClientLevel level;
  protected final MapTemplate template;

  public ClientsideChunkGenerator(ClientLevel level, MapTemplate template) {
    this.level = level;
    this.template = template;
  }

  public static ClientsideChunkGenerator create(ClientLevel level, Identifier map) {
    return new ClientsideChunkGenerator(level, null) {
      public Pair<List<LevelChunk>, ProgressIndicator> getEntireMap() {
        return Pair.of(List.of(), () -> 1.0F);
      }
    };
  }

  public Pair<List<LevelChunk>, ProgressIndicator> getEntireMap() {
    return Pair.of(List.of(), () -> 1.0F);
  }

  public interface ProgressIndicator {
    float progress();
  }
}
