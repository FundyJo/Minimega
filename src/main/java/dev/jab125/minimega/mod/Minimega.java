package dev.jab125.minimega.mod;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import dev.jab125.minimega.mod.abstractions.modloader.Environment;
import dev.jab125.minimega.mod.abstractions.modloader.ModLoader;
import dev.jab125.minimega.mod.abstractions.networking.ServerNetworking;
import dev.jab125.minimega.mod.block.entity.BeaconBeamBlockEntity;
import dev.jab125.minimega.mod.block.entity.SpeedBoostBlockEntity;
import dev.jab125.minimega.mod.extension.MinecraftServerExtension;
import dev.jab125.minimega.mod.extension.ServerConfigurationPacketListenerImplExtension;
import dev.jab125.minimega.mod.extension.WorldOptionsExtension;
import dev.jab125.minimega.mod.init.ModBlockEntityTypes;
import dev.jab125.minimega.mod.init.ModBlocks;
import dev.jab125.minimega.mod.init.ModSounds;
import dev.jab125.minimega.mod.networking.payload.C2S2CMinimegaProtocolVersionPayload;
import dev.jab125.minimega.mod.networking.payload.C2SFinishedMapLoadingPayload;
import dev.jab125.minimega.mod.networking.payload.C2SJoiningChoicePayload;
import dev.jab125.minimega.mod.networking.payload.C2SLinkPayload;
import dev.jab125.minimega.mod.networking.payload.C2SLinkScreenClosedPayload;
import dev.jab125.minimega.mod.networking.payload.C2SPacksDownloadedPayload;
import dev.jab125.minimega.mod.networking.payload.C2SReadyPayload;
import dev.jab125.minimega.mod.networking.payload.MinimegaPackObj;
import dev.jab125.minimega.mod.networking.payload.S2CColorIdPayload;
import dev.jab125.minimega.mod.networking.payload.S2CDisplayTextPayload;
import dev.jab125.minimega.mod.networking.payload.S2CDownloadResourcePacksPayload;
import dev.jab125.minimega.mod.networking.payload.S2CJoiningChoicePayload;
import dev.jab125.minimega.mod.networking.payload.S2CLinkPayload;
import dev.jab125.minimega.mod.networking.payload.S2CLinkScreenUpdatePayload;
import dev.jab125.minimega.mod.networking.payload.S2CMapTransitionStartPayload;
import dev.jab125.minimega.mod.networking.payload.S2CStatusPayload;
import dev.jab125.minimega.mod.p2p.matchmaking.obj.S2CPlayerInfoObj;
import dev.jab125.minimega.mod.util.ExtraServerConfigurationConnectionEvents;
import dev.jab125.minimega.mod.util.Minigame;
import dev.jab125.minimega.mod.util.MinigameData;
import dev.jab125.minimega.mod.util.PreFlatteningItems;
import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
import dev.jab125.minimega.mod.util.controller.MinigamesController;
import dev.jab125.minimega.mod.util.controller.glide.GlideMinigameController;
import dev.jab125.minimega.mod.util.controller.lobby.LobbyMinigameController;
import dev.jab125.minimega.mod.worldgen.MinigameChunkGenerator;
import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents.Load;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.ServerStarting;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.ServerStopped;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents.EndTick;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents.EndWorldTick;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerConfigurationNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerConfigurationConnectionEvents.Configure;
import net.fabricmc.fabric.api.networking.v1.ServerConfigurationNetworking.Context;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.GameRules;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.network.ServerConfigurationPacketListenerImpl;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.network.ConfigurationTask;
import net.minecraft.server.network.ConfigurationTask.Type;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.nucleoid.fantasy.Fantasy;
import xyz.nucleoid.fantasy.RuntimeWorldConfig;
import xyz.nucleoid.fantasy.RuntimeWorldHandle;
import xyz.nucleoid.map_templates.MapTemplate;
import xyz.nucleoid.map_templates.MapTemplateSerializer;

public class Minimega implements ModInitializer {
   public static final String MOD_ID = "minimega";
   public static final Logger LOGGER = LoggerFactory.getLogger("minimega");
   public static final Type CONFIGURE = new Type("minimega:configure");
   public static final Type PACKS = new Type("minimega:packs");
   public static final Type CHOICE = new Type("minimega:choice");
   public static final Type LINK = new Type("minimega:link");
   public static final Type CLOSELINKSCREEN = new Type("minimega:closelinkscreen");
   private static IDiscordHandler DISCORD_HANDLER = new IDiscordHandler() {};
   public static BiFunction<MinecraftServer, GameProfile, Boolean> isSingleplayerOwner = (a, b) -> false;
   public static Function<UUID, S2CPlayerInfoObj> getPlayerInfo = a -> null;
   public static boolean www;
   private static Minimega.Power power;
   private static final List<Consumer<ServerLevel>> tempevents = new CopyOnWriteArrayList<>();

   public static IDiscordHandler getDiscordHandler() {
      return DISCORD_HANDLER;
   }

   public static Identifier id(String path) {
      return Identifier.of("minimega", path);
   }

   public static void scheduleWWW() {
      www = true;
   }

   public static Minimega.Power getPower() {
      if (power == null) {
         long l = Runtime.getRuntime().maxMemory();
         power = l <= 536870912L ? Minimega.Power.VERY_WEAK : (l <= 2147483648L ? Minimega.Power.WEAK : Minimega.Power.STRONG);
      }

      return power;
   }

   public void onInitialize() {
      this.startupDiscordHandler();
      PayloadTypeRegistry.configurationS2C().register(S2CJoiningChoicePayload.TYPE, S2CJoiningChoicePayload.STREAM_CODEC);
      PayloadTypeRegistry.configurationC2S().register(C2SJoiningChoicePayload.TYPE, C2SJoiningChoicePayload.STREAM_CODEC);
      PayloadTypeRegistry.configurationS2C().register(S2CLinkScreenUpdatePayload.TYPE, S2CLinkScreenUpdatePayload.STREAM_CODEC);
      PayloadTypeRegistry.configurationC2S().register(C2SLinkScreenClosedPayload.TYPE, C2SLinkScreenClosedPayload.STREAM_CODEC);
      PayloadTypeRegistry.configurationS2C().register(S2CLinkPayload.TYPE, S2CLinkPayload.STREAM_CODEC);
      PayloadTypeRegistry.configurationC2S().register(C2SLinkPayload.TYPE, C2SLinkPayload.STREAM_CODEC);
      PayloadTypeRegistry.playC2S().register(C2SFinishedMapLoadingPayload.TYPE, C2SFinishedMapLoadingPayload.STREAM_CODEC);
      PayloadTypeRegistry.playS2C().register(S2CDisplayTextPayload.TYPE, S2CDisplayTextPayload.STREAM_CODEC);
      PayloadTypeRegistry.playS2C().register(S2CStatusPayload.TYPE, S2CStatusPayload.STREAM_CODEC);
      PayloadTypeRegistry.playS2C().register(S2CColorIdPayload.TYPE, S2CColorIdPayload.STREAM_CODEC);
      PayloadTypeRegistry.playS2C().register(S2CMapTransitionStartPayload.TYPE, S2CMapTransitionStartPayload.STREAM_CODEC);
      PayloadTypeRegistry.playC2S().register(C2SReadyPayload.TYPE, C2SReadyPayload.CODEC);
      PayloadTypeRegistry.configurationS2C().register(C2S2CMinimegaProtocolVersionPayload.TYPE, C2S2CMinimegaProtocolVersionPayload.STREAM_CODEC);
      PayloadTypeRegistry.configurationS2C().register(S2CDownloadResourcePacksPayload.TYPE, S2CDownloadResourcePacksPayload.STREAM_CODEC);
      PayloadTypeRegistry.configurationC2S().register(C2S2CMinimegaProtocolVersionPayload.TYPE, C2S2CMinimegaProtocolVersionPayload.STREAM_CODEC);
      PayloadTypeRegistry.configurationC2S().register(C2SPacksDownloadedPayload.TYPE, C2SPacksDownloadedPayload.STREAM_CODEC);
      ExtraServerConfigurationConnectionEvents.BEFORE_BEFORE_CONFIGURE.register((Configure)(handler, server) -> {
         if (isMinigameServer(server)) {
            if (ServerConfigurationNetworking.canSend(handler, C2S2CMinimegaProtocolVersionPayload.TYPE)) {
               handler.addTask(new ConfigurationTask() {
                  public void start(Consumer<Packet<?>> consumer) {
                     consumer.accept(ServerNetworking.getInstance().configuration(new C2S2CMinimegaProtocolVersionPayload(56)));
                  }

                  public Type type() {
                     return Minimega.CONFIGURE;
                  }
               });
            } else {
               handler.disconnect(Component.literal("Minimega " + C2S2CMinimegaProtocolVersionPayload.getFriendlyVersion() + " is required to join!"));
            }
         }
      });
      ServerConfigurationNetworking.registerGlobalReceiver(
         C2S2CMinimegaProtocolVersionPayload.TYPE,
         (payload, context) -> {
            if (!isMinigameServer(context.server())) {
               context.networkHandler().disconnect(Component.literal("Minigame packet sent whilst not in a minigame server."));
            } else {
               if (payload.version() != 56 && !Arrays.stream(C2S2CMinimegaProtocolVersionPayload.CURRENT_WORKING).anyMatch(a -> a == payload.version())) {
                  context.networkHandler()
                     .disconnect(
                        Component.literal(
                           "Minimega "
                              + C2S2CMinimegaProtocolVersionPayload.getFriendlyVersion()
                              + " is required to join, but you have "
                              + C2S2CMinimegaProtocolVersionPayload.getFriendlyVersion(payload.version())
                              + "!"
                        )
                     );
               } else {
                  final GameProfile owner = context.networkHandler().getOwner();
                  if (DISCORD_HANDLER.isActive() && !DISCORD_HANDLER.discordIdFromGameProfile(owner).isPresent()) {
                     ServerConfigurationNetworking.registerReceiver(
                        context.networkHandler(),
                        C2SLinkPayload.TYPE,
                        (payload2, context2) -> {
                           Optional<Pair<Long, GameProfile>> gameProfile = Optional.ofNullable(
                              DISCORD_HANDLER.discordIdAndgameProfileFromLoginCode(payload2.code())
                           );
                           if (owner.equals(gameProfile.map(Pair::getSecond).orElse(null))) {
                              ServerConfigurationNetworking.registerReceiver(
                                 context.networkHandler(),
                                 C2SLinkScreenClosedPayload.TYPE,
                                 (payload1, context1) -> context.networkHandler().completeTask(CLOSELINKSCREEN)
                              );
                              context.networkHandler().addTask(new ConfigurationTask() {
                                 public void start(Consumer<Packet<?>> consumer) {
                                    consumer.accept(ServerNetworking.getInstance().configuration(new S2CLinkScreenUpdatePayload(true)));
                                 }

                                 public Type type() {
                                    return Minimega.CLOSELINKSCREEN;
                                 }
                              });
                              context2.server()
                                 .executeBlocking(
                                    context2.server()
                                       .wrapRunnable(
                                          () -> {
                                             try {
                                                DISCORD_HANDLER.linkDiscordAndGameProfile(
                                                   (Long)gameProfile.orElseThrow().getFirst(), (GameProfile)gameProfile.orElseThrow().getSecond()
                                                );
                                                DISCORD_HANDLER.savePersistentData();
                                             } catch (IOException var2x) {
                                                throw new RuntimeException(var2x);
                                             }
                                          }
                                       )
                                 );
                              completeLogin(context2);
                              context.networkHandler().completeTask(LINK);
                           } else {
                              context.networkHandler().send(ServerNetworking.getInstance().configuration(new S2CLinkScreenUpdatePayload(false)));
                           }
                        }
                     );
                     context.networkHandler().addTask(new ConfigurationTask() {
                        public void start(Consumer<Packet<?>> consumer) {
                           consumer.accept(ServerNetworking.getInstance().configuration(new S2CLinkPayload(Minimega.DISCORD_HANDLER.initialCode(owner))));
                        }

                        public Type type() {
                           return Minimega.LINK;
                        }
                     });
                     context.networkHandler().completeTask(CONFIGURE);
                  } else {
                     completeLogin(context);
                     context.networkHandler().completeTask(CONFIGURE);
                  }
               }
            }
         }
      );
      ServerPlayNetworking.registerGlobalReceiver(C2SFinishedMapLoadingPayload.TYPE, (payload, context) -> {
         ServerLevel level = context.player().level();
         if (level == null) {
            context.responseSender().disconnect(Component.literal("...what"));
         } else {
            MinigamesController.getMinigameController(level).playerLoadedIn(context.player());
         }
      });
      ServerPlayNetworking.registerGlobalReceiver(C2SReadyPayload.TYPE, (payload, context) -> {
         ServerLevel level = context.player().level();
         if (level == null) {
            context.responseSender().disconnect(Component.literal("...what"));
         } else {
            MinigamesController.getMinigameController(level).playerReady(context.player(), payload.ready());
         }
      });

      try {
         JsonObject object = (JsonObject)new Gson().fromJson(new String(Minimega.class.getResourceAsStream("/ids.json").readAllBytes()), JsonObject.class);
         PreFlatteningItems.obj = object;
         ArrayList<String> invalidIds = new ArrayList<>();

         for (String s : object.keySet()) {
            JsonElement jsonElement = object.get(s);
            if (!jsonElement.isJsonPrimitive() || !jsonElement.getAsJsonPrimitive().isString()) {
               for (Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                  if (BuiltInRegistries.ITEM.getOptional(Identifier.parse(entry.getValue().getAsString())).isEmpty()) {
                     invalidIds.add(s + "/" + entry.getKey() + ": " + entry.getValue().getAsString());
                  }
               }
            } else if (BuiltInRegistries.ITEM.getOptional(Identifier.parse(jsonElement.getAsString())).isEmpty()) {
               invalidIds.add(s + ": " + jsonElement.getAsString());
            }
         }

         if (!invalidIds.isEmpty()) {
            System.out.println("Invalid ids!: " + invalidIds);
         }
      } catch (IOException | NullPointerException var8) {
         throw new RuntimeException(var8);
      }

      LOGGER.info("Hello Fabric world!");
      ModBlocks.init();
      ModBlockEntityTypes.init();
      ModSounds.init();
      CommandRegistrationCallback.EVENT
         .register(
            (CommandRegistrationCallback)(dispatcher, context, selection) -> {
               LiteralArgumentBuilder<CommandSourceStack> trevor = (LiteralArgumentBuilder<CommandSourceStack>)Commands.literal("trevor").executes(context_ -> {
                  Minigame<?> activeMinigame = MinigamesController.getMinigameController(((CommandSourceStack)context_.getSource()).getLevel()).getActiveMinigame();
                  ((CommandSourceStack)context_.getSource()).sendSuccess(() -> Component.literal(activeMinigame + ""), true);
                  return 0;
               });
               dispatcher.register(trevor);
               LiteralArgumentBuilder<CommandSourceStack> testrp = (LiteralArgumentBuilder<CommandSourceStack>)Commands.literal("testrp")
                  .executes(
                     context_ -> {
                        ((CommandSourceStack)context_.getSource())
                           .getPlayerOrException()
                           .connection
                           .send(
                              new ServerConfigurationPacketListenerImpl(
                                 UUID.randomUUID(),
                                 "https://cdn.modrinth.com/data/meEXwbr9/versions/Ve69UVut/Plastic%20Texture%20Pack.zip",
                                 "4898194d8e419f4aff1c23cd57271a9a6ccfdb1c",
                                 true,
                                 Optional.of(Component.literal("Pack required to join"))
                              )
                           );
                        return 0;
                     }
                  );
               dispatcher.register(testrp);
            }
         );
      ServerEntityEvents.ENTITY_LOAD.register((Load)(entity, world) -> {
         if (entity instanceof ServerPlayer player) {
            MinigamesController.getMinigameController(world).dirty();
         }
      });
      ServerTickEvents.END_WORLD_TICK
         .register(
            (EndWorldTick)level -> {
               MinigamesController minigameController = MinigamesController.getMinigameController(level);
               AbstractMinigameController<?> controller = minigameController.getController(
                  (Minigame<AbstractMinigameController<?>>)minigameController.getActiveMinigame()
               );

               assert controller != null;

               controller.callTick();
            }
         );
      if (ModLoader.getInstance().isModLoaded("legacy")) {
         new Legacy4JMethodsImpl();
      }

      if (ModLoader.getInstance().isModLoaded("server-replay")) {
         new ServerReplayMethodsImpl();
      }

      ServerTickEvents.END_SERVER_TICK.register((EndTick)world -> {
         for (Consumer<ServerLevel> tempevent : tempevents) {
            for (ServerLevel allLevel : world.getAllLevels()) {
               tempevent.accept(allLevel);
            }

            tempevents.remove(tempevent);
         }
      });
      ServerLifecycleEvents.SERVER_STARTING.register((ServerStarting)server -> DISCORD_HANDLER.accept(server));
      ServerLifecycleEvents.SERVER_STOPPED.register((ServerStopped)server -> DISCORD_HANDLER.accept(null));
   }

   private void startupDiscordHandler() {
      try {
         Class<?> aClass = Class.forName("dev.jab125.minimega.mod.server.discord.MinimegaDiscord");
         MethodHandle init = MethodHandles.publicLookup().findStatic(aClass, "init", MethodType.methodType(IDiscordHandler.class, IDiscordHandler.class));
         IDiscordHandler o = (IDiscordHandler)init.invokeExact((IDiscordHandler)DISCORD_HANDLER);
         DISCORD_HANDLER = o;
      } catch (ClassNotFoundException var4) {
      } catch (Throwable var5) {
         throw new RuntimeException("Failed to setup Discord!", var5);
      }
   }

   private static void completeLogin(Context context) {
      ServerConfigurationNetworking.registerReceiver(
         context.networkHandler(), C2SPacksDownloadedPayload.TYPE, (payload2, context2) -> context.networkHandler().completeTask(PACKS)
      );
      if (shouldAcceptChoices(context.server(), context.networkHandler().getOwner())) {
         ServerConfigurationNetworking.registerReceiver(context.networkHandler(), C2SJoiningChoicePayload.TYPE, (payload2, context2) -> {
            ((ServerConfigurationPacketListenerImplExtension)context2.networkHandler()).mm$setMinigameData(wrap(payload2.data()));
            context.networkHandler().completeTask(CHOICE);
         });
      }

      context.networkHandler()
         .addTask(
            new ConfigurationTask() {
               public void start(Consumer<Packet<?>> consumer) {
                  consumer.accept(
                     ServerNetworking.getInstance()
                        .configuration(
                           new S2CDownloadResourcePacksPayload(
                              List.of(
                                 new MinimegaPackObj(
                                    Minimega.id("plastic"),
                                    "https://cdn.modrinth.com/data/meEXwbr9/versions/Ve69UVut/Plastic%20Texture%20Pack.zip",
                                    "4898194d8e419f4aff1c23cd57271a9a6ccfdb1c"
                                 )
                              )
                           )
                        )
                  );
               }

               public Type type() {
                  return Minimega.PACKS;
               }
            }
         );
      if (shouldAcceptChoices(context.server(), context.networkHandler().getOwner())) {
         context.networkHandler().addTask(new ConfigurationTask() {
            public void start(Consumer<Packet<?>> consumer) {
               consumer.accept(ServerNetworking.getInstance().configuration(new S2CJoiningChoicePayload()));
            }

            public Type type() {
               return Minimega.CHOICE;
            }
         });
      }
   }

   public static boolean shouldAcceptChoices(MinecraftServer server, GameProfile profile) {
      return isDedicatedServer() || isSingleplayerOwner.apply(server, profile);
   }

   public static MinigameData getData(MinecraftServer server) {
      return ((MinecraftServerExtension)server).mm$getData();
   }

   private static Either<MinigameData, Either<Minigame<?>, C2SJoiningChoicePayload.FriendData>> wrap(
      Either<MinigameData, Either<Minigame<?>, C2SJoiningChoicePayload.FriendData>> data
   ) {
      if (!isDedicatedServer()) {
         return data;
      } else if (data == null) {
         return null;
      } else {
         if (data.left().isPresent()) {
            MinigameData minigameData = (MinigameData)data.left().get();
            if (minigameData.glideSolo().orElse(false)) {
               return Either.left(minigameData.noSolo());
            }
         }

         return data;
      }
   }

   public static void worldEvent(Consumer<ServerLevel> serverWorld) {
      tempevents.add(serverWorld);
   }

   public static boolean isDedicatedServer() {
      return ModLoader.getInstance().getEnvironment() == Environment.DEDICATED_SERVER;
   }

   @Deprecated(
      forRemoval = true
   )
   public static GlideMinigameController openGlideMap(MinecraftServer server, Identifier map, MinigameData data) {
      boolean isCanyon = "canyon".equals(map);
      JsonObject grf = getGlideGRF(map, server);
      Fantasy fantasy = Fantasy.get(server);

      MapTemplate mapTemplate;
      try {
         String namespace = map.getNamespace();
         String path = map.getPath();
         mapTemplate = MapTemplateSerializer.loadFrom(
            ((Resource)server.getResourceManager()
                  .getResource(Identifier.of(namespace, "minimega_minigames/glide/maps/" + path + "/" + path + ".nbt"))
                  .orElseThrow())
               .open(),
            server.registryAccess()
         );
      } catch (IOException var12) {
         throw new RuntimeException(var12);
      }

      RuntimeWorldHandle runtimeWorldHandle = fantasy.openTemporaryWorld(
         new RuntimeWorldConfig()
            .setGenerator(new MinigameChunkGenerator(server, mapTemplate, GlideMinigameController.getForceBiome(grf)))
            .setGameRule(GameRules.RULE_DOFIRETICK, false)
            .setGameRule(GameRules.RULE_DOMOBSPAWNING, false)
            .setGameRule(GameRules.RULE_DOMOBLOOT, false)
            .setGameRule(GameRules.RULE_DOBLOCKDROPS, false)
            .setGameRule(GameRules.RULE_WEATHER_CYCLE, false)
            .setGameRule(GameRules.RULE_DAYLIGHT, false)
            .setGameRule(GameRules.RULE_KEEPINVENTORY, false)
            .setGameRule(GameRules.RULE_GLOBAL_SOUND_EVENTS, false)
            .setGameRule(GameRules.RULE_MOBGRIEFING, false)
            .setGameRule(GameRules.RULE_SPAWN_RADIUS, 0)
            .setDifficulty(Difficulty.PEACEFUL)
      );
      ServerLevel world = runtimeWorldHandle.asWorld();

      try {
         MinigamesController minigameController = MinigamesController.getMinigameController(world);
         GlideMinigameController glideMinigameController = minigameController.setActiveMinigame(Minigame.GLIDE);
         glideMinigameController.setCosmeticId(map);
         glideMinigameController.acceptMinigameData(data);
         glideMinigameController.accept(grf);
         glideMinigameController.setStage(0);
         return glideMinigameController;
      } catch (Throwable var11) {
         var11.printStackTrace();
         throw var11;
      }
   }

   public static <T extends AbstractMinigameController<T>> T openMap(MinecraftServer server, Identifier map, MinigameData data) {
      return openMap(server, map, data, null);
   }

   public static <T extends AbstractMinigameController<T>> T openMap(MinecraftServer server, Identifier map, MinigameData data, Minigame<T> minigameOverride) {
      Minigame<T> minigame = minigameOverride != null ? minigameOverride : data.minigame();
      JsonObject grf = getGRF(map, minigame.tId(), server);
      Fantasy fantasy = Fantasy.get(server);

      MapTemplate mapTemplate;
      try {
         String namespace = map.getNamespace();
         String path = map.getPath();
         mapTemplate = MapTemplateSerializer.loadFrom(
            ((Resource)server.getResourceManager()
                  .getResource(Identifier.of(namespace, "minimega_minigames/" + minigame.tId() + "/maps/" + path + ".nbt"))
                  .orElseThrow())
               .open(),
            server.registryAccess()
         );
      } catch (IOException var13) {
         throw new RuntimeException(var13);
      }

      RuntimeWorldHandle runtimeWorldHandle = fantasy.openTemporaryWorld(
         new RuntimeWorldConfig()
            .setGenerator(new MinigameChunkGenerator(server, mapTemplate, GlideMinigameController.getForceBiome(grf)))
            .setGameRule(GameRules.RULE_DOFIRETICK, false)
            .setGameRule(GameRules.RULE_DOMOBSPAWNING, minigame == Minigame.FISTFIGHT)
            .setGameRule(GameRules.RULE_DOMOBLOOT, minigame == Minigame.FISTFIGHT)
            .setGameRule(GameRules.RULE_DOBLOCKDROPS, minigame == Minigame.FISTFIGHT)
            .setGameRule(GameRules.RULE_WEATHER_CYCLE, false)
            .setGameRule(GameRules.RULE_DAYLIGHT, false)
            .setGameRule(GameRules.RULE_KEEPINVENTORY, false)
            .setGameRule(GameRules.RULE_GLOBAL_SOUND_EVENTS, false)
            .setGameRule(GameRules.RULE_MOBGRIEFING, minigame == Minigame.FISTFIGHT)
            .setGameRule(GameRules.RULE_SPAWN_RADIUS, minigame == Minigame.FISTFIGHT ? 3 : 0)
            .setDifficulty(minigame == Minigame.FISTFIGHT ? Difficulty.NORMAL : Difficulty.PEACEFUL)
      );
      ServerLevel world = runtimeWorldHandle.asWorld();

      try {
         MinigamesController minigameController = MinigamesController.getMinigameController(world);
         T controller = minigameController.setActiveMinigame(minigame);
         controller.setCosmeticId(map);
         controller.acceptMinigameData(data);
         controller.accept(grf);
         return controller;
      } catch (Throwable var12) {
         var12.printStackTrace();
         throw var12;
      }
   }

   private static int openGlideMap(CommandContext<CommandSourceStack> context_, Identifier map) {
      GlideMinigameController glideMinigameController = openMap(((CommandSourceStack)context_.getSource()).getServer(), map, null);

      for (ServerPlayer player : ((CommandSourceStack)context_.getSource()).getLevel().getPlayers().toArray(ServerPlayer[]::new)) {
         glideMinigameController.sendToMap(((CommandSourceStack)context_.getSource()).getEntity(), player);
      }

      return 0;
   }

   @Deprecated(
      forRemoval = true
   )
   public static LobbyMinigameController openLobbyMap(MinecraftServer server, Identifier map, MinigameData data) {
      return openMap(server, map, data, Minigame.LOBBY);
   }

   private Command<CommandSourceStack> fix(Identifier map, BiFunction<Identifier, CommandContext<CommandSourceStack>, Integer> biFunction) {
      return f -> {
         try {
            return biFunction.apply(map, f);
         } catch (Throwable var4) {
            var4.printStackTrace();
            throw var4;
         }
      };
   }

   private int map(Identifier map, CommandContext<CommandSourceStack> context) {
      ServerLevel level = ((CommandSourceStack)context.getSource()).getLevel();
      JsonObject object = getGRF(map, "glide", context);
      JsonObject levelRules = object.getAsJsonArray("childRules")
         .asList()
         .stream()
         .filter(a -> a instanceof JsonObject jsonObjectx && "LevelRules".equals(jsonObjectx.getAsJsonPrimitive("name").getAsString()))
         .findFirst()
         .orElseThrow()
         .getAsJsonObject();

      for (JsonElement jsonElement : levelRules.getAsJsonArray("childRules")) {
         if (jsonElement instanceof JsonObject jsonObject) {
            if ("ThermalArea".equals(jsonObject.getAsJsonPrimitive("name").getAsString())) {
               JsonObject parameters = jsonObject.getAsJsonObject("parameters");
               int x0 = parameters.get("x0").getAsNumber().intValue();
               int y0 = parameters.get("y0").getAsNumber().intValue();
               int z0 = parameters.get("z0").getAsNumber().intValue();
               int x1 = parameters.get("x1").getAsNumber().intValue();
               int y1 = parameters.get("y1").getAsNumber().intValue();
               int z1 = parameters.get("z1").getAsNumber().intValue();
               BlockPos blockPos = new BlockPos(x0, y0, z0);
               level.setBlock(blockPos, ModBlocks.ABSOLUTE_SPEED_BOOST.defaultBlockState(), 0);
               SpeedBoostBlockEntity speedBoostBlockEntity = (SpeedBoostBlockEntity)level.getBlockEntity(blockPos, ModBlockEntityTypes.SPEED_BOOST).orElseThrow();
               speedBoostBlockEntity.setOffset(BlockPos.ZERO);
               speedBoostBlockEntity.setBoundingBox(new Vec3i(x1 - x0, y1 - y0, z1 - z0));
               if (parameters.has("staticLift")) {
                  speedBoostBlockEntity.setSpeedBoost(parameters.get("staticLift").getAsDouble());
                  double targetHeight;
                  if (parameters.has("targetHeight")) {
                     targetHeight = parameters.get("targetHeight").getAsDouble();
                  } else {
                     targetHeight = 0.0;
                  }

                  speedBoostBlockEntity.setTargetHeight(targetHeight);
                  speedBoostBlockEntity.setDirection(SpeedBoostBlockEntity.SpeedDirection.STATIC);
               } else if (parameters.has("speedBoost")) {
                  speedBoostBlockEntity.setSpeedBoost(parameters.get("speedBoost").getAsDouble());
                  speedBoostBlockEntity.setDirection(this.decode(parameters.get("boostDirection").getAsString()));
               } else if (parameters.has("liftForceModifier")) {
                  speedBoostBlockEntity.setDirection(SpeedBoostBlockEntity.SpeedDirection.NATURAL);
                  speedBoostBlockEntity.setSpeedBoost(parameters.get("liftForceModifier").getAsDouble());
               } else {
                  System.err.println("WHATTTTT");
                  System.err.println(parameters);
               }
            } else if ("Checkpoint".equals(jsonObject.getAsJsonPrimitive("name").getAsString())) {
               for (JsonElement element : this.iterable(
                  jsonObject.getAsJsonArray("childRules")
                     .asList()
                     .stream()
                     .filter(a -> a instanceof JsonObject objx && "CustomBeacon".equals(objx.getAsJsonPrimitive("name").getAsString()))
                     .iterator()
               )) {
                  if (element instanceof JsonObject obj) {
                     JsonObject parameters = obj.getAsJsonObject("parameters");
                     int x = parameters.get("spawnX").getAsInt();
                     int y = parameters.get("spawnY").getAsInt();
                     int z = parameters.get("spawnZ").getAsInt();
                     Direction beamDirection = this.decodeB(parameters.get("beam_direction").getAsString());
                     int beamLength = parameters.get("beam_length").getAsInt();
                     BlockPos blockPos = new BlockPos(x, y, z).relative(beamDirection);
                     level.setBlock(blockPos, ModBlocks.BEACON_BEAM.defaultBlockState(), 0);
                     BeaconBeamBlockEntity beaconBeamBlockEntity = (BeaconBeamBlockEntity)level.getBlockEntity(blockPos, ModBlockEntityTypes.BEACON_BEAM)
                        .orElseThrow();
                     beaconBeamBlockEntity.setSize(beamLength);
                     beaconBeamBlockEntity.setDirection(beamDirection);
                  }
               }
            }
         }
      }

      return 0;
   }

   private static JsonObject getGlideGRF(Identifier map, CommandContext<CommandSourceStack> context) {
      return getGRF(map, "glide", context);
   }

   public static JsonObject getGlideGRF(Identifier map, MinecraftServer server) {
      return getGRF(map, "glide", server);
   }

   private static JsonObject getGRF(Identifier map, String type, CommandContext<CommandSourceStack> context) {
      return getGRF(map, type, ((CommandSourceStack)context.getSource()).getServer());
   }

   private static <T extends Throwable> JsonObject getGRF(Identifier map, String type, MinecraftServer server) throws T {
      try {
         String s = new String(
            ((Resource)server.getResourceManager().getResource(map.withPrefix("minimega_minigames/" + type + "/gamerules/").withSuffix(".json")).orElseThrow())
               .open()
               .readAllBytes()
         );
         return (JsonObject)new Gson().fromJson(s, JsonObject.class);
      } catch (Throwable var5) {
         throw var5;
      }
   }

   private <T> Iterable<T> iterable(Iterator<T> iterator) {
      return () -> iterator;
   }

   private Direction decodeB(String direction) {
      return switch (direction) {
         case "plus_y" -> Direction.UP;
         case "minus_y" -> Direction.DOWN;
         case "plus_x" -> Direction.EAST;
         case "minus_x" -> Direction.WEST;
         case "plus_z" -> Direction.SOUTH;
         case "minus_z" -> Direction.NORTH;
         default -> throw new IllegalStateException("Unexpected value: " + direction);
      };
   }

   private SpeedBoostBlockEntity.SpeedDirection decode(String boostDirection) {
      return switch (boostDirection) {
         case "plus_x" -> SpeedBoostBlockEntity.SpeedDirection.EAST;
         case "minus_x" -> SpeedBoostBlockEntity.SpeedDirection.WEST;
         case "plus_z" -> SpeedBoostBlockEntity.SpeedDirection.SOUTH;
         case "minus_z" -> SpeedBoostBlockEntity.SpeedDirection.NORTH;
         case "omni_plus_x" -> SpeedBoostBlockEntity.SpeedDirection.OMNI_EAST;
         case "omni_minus_x" -> SpeedBoostBlockEntity.SpeedDirection.OMNI_WEST;
         case "omni_plus_z" -> SpeedBoostBlockEntity.SpeedDirection.OMNI_SOUTH;
         case "omni_minus_z" -> SpeedBoostBlockEntity.SpeedDirection.OMNI_NORTH;
         default -> throw new IllegalStateException("Unexpected value: " + boostDirection);
      };
   }

   public static boolean isMinigameServer(MinecraftServer server) {
      return WorldOptionsExtension.from(server.getWorldData().worldGenOptions()).mm$getMinigameData() != null;
   }

   @Deprecated(
      forRemoval = true
   )
   public static ServerLevel getOrCreateLobby(MinecraftServer server) {
      Iterator lobbyController = server.getAllLevels().iterator();

      ServerLevel lobby;
      while (true) {
         if (lobbyController.hasNext()) {
            ServerLevel level = (ServerLevel)lobbyController.next();
            if (!MinigamesController.getMinigameController(level).isLobby()) {
               continue;
            }

            lobby = level;
            break;
         }

         LobbyMinigameController lobbyControllerx = openMap(server, id("lobby"), null, Minigame.LOBBY);
         lobby = lobbyControllerx.getLevel();
         break;
      }

      return lobby;
   }

   public static ServerLevel createLobbyWithMinigame(MinecraftServer server, MinigameData data) {
      LobbyMinigameController lobbyController = openMap(server, id("lobby"), data, Minigame.LOBBY);
      return lobbyController.getLevel();
   }

   public static <T, R extends Throwable> T getWithLegacy4J(Supplier<Supplier<Minimega.ThrowableSupplier<T, R>>> r) throws R {
      return ModLoader.getInstance().isModLoaded("legacy") ? r.get().get().get() : null;
   }

   public static <R extends Throwable> void runWithLegacy4J(Supplier<Supplier<Minimega.ThrowableRunnable<R>>> r) throws R {
      if (ModLoader.getInstance().isModLoaded("legacy")) {
         r.get().get().run();
      }
   }

   public static void sendTopMessage(ServerPlayer player, Component component) {
      player.connection.send(ServerNetworking.getInstance().play(new S2CDisplayTextPayload(component)));
   }

   public static void sendStatus(ServerPlayer player, S2CStatusPayload.Status status) {
      player.connection.send(ServerNetworking.getInstance().play(new S2CStatusPayload(status)));
   }

   public static enum Power {
      STRONG,
      WEAK,
      VERY_WEAK;

      public boolean cannotSupport16Players() {
         return this != STRONG;
      }

      public int maxPlayerCount() {
         return switch (this) {
            case STRONG -> 16;
            case WEAK -> 8;
            case VERY_WEAK -> 4;
         };
      }
   }

   public static enum Reason {
   }

   public interface ThrowableRunnable<R extends Throwable> {
      void run() throws R;
   }

   public interface ThrowableSupplier<T, R extends Throwable> {
      T get() throws R;
   }
}
