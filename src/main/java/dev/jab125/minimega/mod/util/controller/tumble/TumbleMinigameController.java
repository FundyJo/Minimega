/*     */ package dev.jab125.minimega.mod.util.controller.tumble;
/*     */ 
/*     */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.NamedArea;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.UpdatePlayer;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.__ROOT__;
/*     */ import dev.jab125.minimega.mod.party.MinigameParty;
/*     */ import dev.jab125.minimega.mod.util.Minigame;
/*     */ import dev.jab125.minimega.mod.util.controller.MinigameAbilities;
/*     */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*     */ import it.unimi.dsi.fastutil.doubles.DoubleList;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import net.minecraft.commands.arguments.blocks.BlockStateParser;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Position;
/*     */ import net.minecraft.core.Vec3i;
/*     */ import net.minecraft.core.registries.Registries;
/*     */ import net.minecraft.network.protocol.Packet;
/*     */ import net.minecraft.network.protocol.game.ClientboundSetHeldSlotPacket;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.level.GameType;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.levelgen.synth.PerlinNoise;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class TumbleMinigameController extends AbstractMinigameController<TumbleMinigameController> {
/*     */   private List<UpdatePlayer> updatePlayers;
/*     */   private PerlinNoise perlinNoise;
/*     */   private boolean doneit;
/*     */   
/*  44 */   public TumbleMinigameController(MinigamesController controller) { super(controller);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 120 */     this.perlinNoise = PerlinNoise.create(RandomSource.create(), -3, DoubleList.of(2.0D));
/* 121 */     this.doneit = false; }
/*     */   public Minigame<TumbleMinigameController> getMinigame() { return Minigame.TUMBLE; }
/*     */   private SparseMatrix<Boolean> ofLength(BlockPos pos, int length) { length /= 2; SparseMatrix<Boolean> cells = new SparseMatrix<>(); BlockPos.betweenClosedStream(pos.subtract(new Vec3i(length / 2 + 1, 0, length / 2 + 1)), pos.offset(new Vec3i(length / 2, 0, length / 2))).forEach(a -> cells.on(a.getX(), a.getZ()));
/* 124 */     return cells; } public static double[] linspace(double start, double end, int points) { double[] result = new double[points];
/* 125 */     double step = (end - start) / (points - 1);
/*     */     
/* 127 */     for (int i = 0; i < points; i++) {
/* 128 */       result[i] = start + i * step;
/*     */     }
/*     */     
/* 131 */     return result; }
/*     */   private SparseMatrix<Boolean> ofCircle(BlockPos pos, int length) { length /= 2; int finalLength = length / 2; SparseMatrix<Boolean> cells = new SparseMatrix<>(); BlockPos.betweenClosedStream(pos.subtract(new Vec3i(length / 2 + 1, 0, length / 2 + 1)), pos.offset(new Vec3i(length / 2, 0, length / 2))).filter(p -> (p.distSqr((Vec3i)pos) < finalLength * finalLength)).forEach(a -> cells.on(a.getX(), a.getZ())); return cells; }
/*     */   private SparseMatrix<Boolean> ofStar(BlockPos pos, int length) { length /= 2; double outerRadius = length / 2.0D; double innerRadius = outerRadius * 0.65D; double roundness = 2.0D; SparseMatrix<Boolean> cells = new SparseMatrix<>(); int minX = pos.getX() - length; int maxX = pos.getX() + length; int minZ = pos.getZ() - length; int maxZ = pos.getZ() + length; for (int x = minX; x <= maxX; x++) { for (int z = minZ; z <= maxZ; z++) { double dx = (x - pos.getX()); double dz = (z - pos.getZ()); double dist = Math.sqrt(dx * dx + dz * dz); double angle = Math.atan2(dz, dx); double radius = starRadius6(angle, outerRadius, innerRadius, roundness); if (dist <= radius)
/*     */           cells.on(x, z);  }  }
/*     */      return cells; }
/* 136 */   private double starRadius6(double angle, double outer, double inner, double roundness) { int points = 6; angle = (angle + 6.283185307179586D) % 6.283185307179586D; double sector = 6.283185307179586D / points; double local = Math.abs(angle % sector - sector / 2.0D); double t = Math.cos(local / sector / 2.0D * Math.PI); t = Math.max(0.0D, t); return inner + (outer - inner) * Math.pow(t, roundness); } protected void tick() { Document doc; super.tick();
/* 137 */     for (ServerPlayer serverPlayer : this.controller.getPlayersFor(level())) {
/* 138 */       (serverPlayer.getAbilities()).instabuild = true;
/* 139 */       (serverPlayer.getAbilities()).invulnerable = true;
/* 140 */       serverPlayer.onUpdateAbilities();
/* 141 */       serverPlayer.getInventory().setSelectedSlot(0);
/* 142 */       serverPlayer.connection.send((Packet)new ClientboundSetHeldSlotPacket(0));
/* 143 */       serverPlayer.getInventory().setItem(0, new ItemStack((ItemLike)Items.SNOWBALL, 16));
/*     */     } 
/*     */     
/* 146 */     if (this.doneit)
/* 147 */       return;  NamedArea namedArea = getGameRules().streamOf(NamedArea.class).filter(a -> "LevelGeneration".equals(a.name())).findFirst().orElseThrow();
/* 148 */     Vec3 center = namedArea.toAABB().getCenter();
/* 149 */     BlockPos containing = BlockPos.containing((Position)center);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 156 */     String xml = "<RainbowTheme>\n    <BlockDef blockId=\"minecraft:red_wool\"/>\n    <BlockDef blockId=\"minecraft:orange_wool\"/>\n    <BlockDef blockId=\"minecraft:yellow_wool\"/>\n    <BlockDef blockId=\"minecraft:lime_wool\"/>\n    <BlockDef blockId=\"minecraft:light_blue_wool\"/>\n    <BlockDef blockId=\"minecraft:cyan_wool\"/>\n    <BlockDef blockId=\"minecraft:blue_wool\"/>\n    <BlockDef blockId=\"minecraft:purple_wool\"/>\n    <BlockDef blockId=\"minecraft:magenta_wool\"/>\n    <BlockDef blockId=\"minecraft:pink_wool\"/>\n    <BlockDef blockId=\"minecraft:white_wool\"/>\n    <BlockDef blockId=\"minecraft:light_gray_wool\"/>\n    <BlockDef blockId=\"minecraft:gray_wool\"/>\n    <BlockDef blockId=\"minecraft:black_wool\"/>\n    <BlockDef blockId=\"minecraft:green_wool\"/>\n    <BlockDef blockId=\"minecraft:brown_wool\"/>\n</RainbowTheme>";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 177 */       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/*     */ 
/*     */       
/* 180 */       factory.setIgnoringElementContentWhitespace(true);
/*     */ 
/*     */       
/* 183 */       DocumentBuilder builder = factory.newDocumentBuilder();
/*     */ 
/*     */ 
/*     */       
/* 187 */       doc = builder.parse(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
/* 188 */     } catch (Throwable t) {
/* 189 */       throw new RuntimeException(t);
/*     */     } 
/* 191 */     NodeList childNodes = doc.getDocumentElement().getChildNodes();
/* 192 */     static final class BlockDef extends Record { private final String blockId; private final Optional<String> blockAux; BlockDef(String blockId, Optional<String> blockAux) { this.blockId = blockId; this.blockAux = blockAux; } public final String toString() { // Byte code:
/*     */         //   0: aload_0
/*     */         //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/controller/tumble/TumbleMinigameController$1BlockDef;)Ljava/lang/String;
/*     */         //   6: areturn
/*     */         // Line number table:
/*     */         //   Java source line number -> byte code offset
/*     */         //   #192	-> 0
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	descriptor
/*     */         //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/tumble/TumbleMinigameController$1BlockDef; } public final int hashCode() { // Byte code:
/*     */         //   0: aload_0
/*     */         //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/controller/tumble/TumbleMinigameController$1BlockDef;)I
/*     */         //   6: ireturn
/*     */         // Line number table:
/*     */         //   Java source line number -> byte code offset
/*     */         //   #192	-> 0
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	descriptor
/*     */         //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/tumble/TumbleMinigameController$1BlockDef; } public final boolean equals(Object o) { // Byte code:
/*     */         //   0: aload_0
/*     */         //   1: aload_1
/*     */         //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/controller/tumble/TumbleMinigameController$1BlockDef;Ljava/lang/Object;)Z
/*     */         //   7: ireturn
/*     */         // Line number table:
/*     */         //   Java source line number -> byte code offset
/*     */         //   #192	-> 0
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	descriptor
/*     */         //   0	8	0	this	Ldev/jab125/minimega/mod/util/controller/tumble/TumbleMinigameController$1BlockDef;
/* 192 */         //   0	8	1	o	Ljava/lang/Object; } public String blockId() { return this.blockId; } public Optional<String> blockAux() { return this.blockAux; } };
/* 193 */     List<BlockDef> list1 = new ArrayList<>();
/* 194 */     for (int j = 0; j < childNodes.getLength(); j++) {
/* 195 */       Node item1 = childNodes.item(j);
/* 196 */       if (item1.getNodeType() == 1) {
/* 197 */         Element item = (Element)childNodes.item(j);
/* 198 */         if ("BlockDef".equals(item.getNodeName())) {
/* 199 */           String blockAux = item.getAttribute("blockAux");
/* 200 */           list1.add(new BlockDef(item.getAttribute("blockId"), blockAux.isBlank() ? Optional.<String>empty() : Optional.<String>of(blockAux)));
/*     */         } 
/*     */       } 
/* 203 */     }  double[] arrayOfDouble1 = linspace(-1.0D, 1.2D, list1.size());
/* 204 */     SparseTensor<BlockState> tensor = new SparseTensor<>();
/*     */     
/* 206 */     label126: for (SparseMatrix.Cell<?> cell : ofCircle(containing, 44)) {
/* 207 */       BlockPos blockPos = new BlockPos(cell.x(), containing.getY(), cell.z());
/* 208 */       double value = this.perlinNoise.getValue(blockPos.getX(), blockPos.getY(), blockPos.getZ());
/*     */       
/* 210 */       int m = -1;
/* 211 */       for (double v : arrayOfDouble1) {
/* 212 */         m++;
/* 213 */         if (value > -v || m == list1.size() - 1) {
/* 214 */           String str1 = ((BlockDef)list1.get(m)).blockId() + ((BlockDef)list1.get(m)).blockId();
/*     */           try {
/* 216 */             BlockState blockState = BlockStateParser.parseForBlock(level().holderLookup(Registries.BLOCK), str1, false).blockState();
/*     */             
/* 218 */             tensor.set(blockPos.getX(), blockPos.getY(), blockPos.getZ(), blockState);
/*     */           }
/* 220 */           catch (CommandSyntaxException e) {
/* 221 */             throw new RuntimeException(e);
/*     */           } 
/*     */           continue label126;
/*     */         } 
/*     */       } 
/* 226 */       String str = ((BlockDef)list1.getLast()).blockId() + ((BlockDef)list1.getLast()).blockId();
/*     */       try {
/* 228 */         BlockState blockState = BlockStateParser.parseForBlock(level().holderLookup(Registries.BLOCK), str, false).blockState();
/*     */         
/* 230 */         tensor.set(blockPos.getX(), blockPos.getY(), blockPos.getZ(), blockState);
/* 231 */       } catch (CommandSyntaxException e) {
/* 232 */         throw new RuntimeException(e);
/*     */       } 
/*     */     } 
/*     */     
/* 236 */     List<SparseTensor.Cell<BlockState>> list = new ArrayList<>();
/* 237 */     for (int k = 0; k < 5; k++) {
/* 238 */       list.add(tensor.getRandomElement(level().getRandom()));
/*     */     }
/* 240 */     for (SparseTensor.Cell<BlockState> randomElement : list) {
/* 241 */       int quota = 10;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 246 */       if (!((BlockState)randomElement.value()).isAir()) {
/* 247 */         int x = randomElement.x();
/* 248 */         int y = randomElement.y();
/* 249 */         int z = randomElement.z();
/* 250 */         if (tensor.replace(x, y, z, Blocks.GRAVEL.defaultBlockState())) {
/* 251 */           tensor.set(x, y + 1, z, Blocks.STONE_PRESSURE_PLATE.defaultBlockState());
/* 252 */           tensor.set(x, y - 1, z, Blocks.TNT.defaultBlockState());
/*     */         } 
/*     */         
/* 255 */         while (quota > 0) {
/* 256 */           int tX = x + level().getRandom().nextIntBetweenInclusive(-3, 3);
/* 257 */           int tZ = z + level().getRandom().nextIntBetweenInclusive(-3, 3);
/* 258 */           if (tensor.replace(tX, y, tZ, Blocks.GRAVEL.defaultBlockState())) {
/* 259 */             tensor.set(tX, y + 1, tZ, Blocks.STONE_PRESSURE_PLATE.defaultBlockState());
/* 260 */             tensor.set(tX, y - 1, tZ, Blocks.TNT.defaultBlockState());
/* 261 */             quota--;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 268 */     for (SparseTensor.Cell<BlockState> blockStateCell : tensor) {
/* 269 */       level().setBlockAndUpdate(new BlockPos(blockStateCell.x(), blockStateCell.y(), blockStateCell.z()), blockStateCell.value());
/*     */     }
/*     */ 
/*     */     
/* 273 */     containing = containing.below(10);
/*     */     
/* 275 */     xml = "<RainbowTheme>\n    <BlockDef blockId=\"minecraft:redstone_ore\"/>\n    <BlockDef blockId=\"minecraft:lapis_block\"/>\n    <BlockDef blockId=\"minecraft:diamond_block\"/>\n    <BlockDef blockId=\"minecraft:emerald_block\"/>\n    <BlockDef blockId=\"minecraft:gold_block\"/>\n    <BlockDef blockId=\"minecraft:iron_block\"/>\n    <BlockDef blockId=\"minecraft:quartz_block\"/>\n</RainbowTheme>";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 288 */       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/*     */ 
/*     */       
/* 291 */       factory.setIgnoringElementContentWhitespace(true);
/*     */ 
/*     */       
/* 294 */       DocumentBuilder builder = factory.newDocumentBuilder();
/*     */ 
/*     */ 
/*     */       
/* 298 */       doc = builder.parse(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
/* 299 */     } catch (Throwable t) {
/* 300 */       throw new RuntimeException(t);
/*     */     } 
/* 302 */     childNodes = doc.getDocumentElement().getChildNodes();
/* 303 */     static final class BlockDef extends Record { private final String blockId; private final Optional<String> blockAux; BlockDef(String blockId, Optional<String> blockAux) { this.blockId = blockId; this.blockAux = blockAux; } public final String toString() { // Byte code:
/*     */         //   0: aload_0
/*     */         //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/util/controller/tumble/TumbleMinigameController$2BlockDef;)Ljava/lang/String;
/*     */         //   6: areturn
/*     */         // Line number table:
/*     */         //   Java source line number -> byte code offset
/*     */         //   #303	-> 0
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	descriptor
/*     */         //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/tumble/TumbleMinigameController$2BlockDef; } public final int hashCode() { // Byte code:
/*     */         //   0: aload_0
/*     */         //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/util/controller/tumble/TumbleMinigameController$2BlockDef;)I
/*     */         //   6: ireturn
/*     */         // Line number table:
/*     */         //   Java source line number -> byte code offset
/*     */         //   #303	-> 0
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	descriptor
/*     */         //   0	7	0	this	Ldev/jab125/minimega/mod/util/controller/tumble/TumbleMinigameController$2BlockDef; } public final boolean equals(Object o) { // Byte code:
/*     */         //   0: aload_0
/*     */         //   1: aload_1
/*     */         //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/util/controller/tumble/TumbleMinigameController$2BlockDef;Ljava/lang/Object;)Z
/*     */         //   7: ireturn
/*     */         // Line number table:
/*     */         //   Java source line number -> byte code offset
/*     */         //   #303	-> 0
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	descriptor
/*     */         //   0	8	0	this	Ldev/jab125/minimega/mod/util/controller/tumble/TumbleMinigameController$2BlockDef;
/* 303 */         //   0	8	1	o	Ljava/lang/Object; } public String blockId() { return this.blockId; } public Optional<String> blockAux() { return this.blockAux; } };
/* 304 */     List<BlockDef> blockDefs = new ArrayList<>();
/* 305 */     for (int i = 0; i < childNodes.getLength(); i++) {
/* 306 */       Node item1 = childNodes.item(i);
/* 307 */       if (item1.getNodeType() == 1) {
/* 308 */         Element item = (Element)childNodes.item(i);
/* 309 */         if ("BlockDef".equals(item.getNodeName())) {
/* 310 */           String blockAux = item.getAttribute("blockAux");
/* 311 */           blockDefs.add(new BlockDef(item.getAttribute("blockId"), blockAux.isBlank() ? Optional.<String>empty() : Optional.<String>of(blockAux)));
/*     */         } 
/*     */       } 
/* 314 */     }  double[] space = linspace(-1.0D, 1.2D, blockDefs.size());
/*     */     
/* 316 */     label127: for (SparseMatrix.Cell<?> cell : ofStar(containing, 56)) {
/* 317 */       BlockPos blockPos = new BlockPos(cell.x(), containing.getY(), cell.z());
/* 318 */       double value = this.perlinNoise.getValue(blockPos.getX(), blockPos.getY(), blockPos.getZ());
/*     */       
/* 320 */       int m = -1;
/* 321 */       for (double v : space) {
/* 322 */         m++;
/* 323 */         if (value > -v || m == blockDefs.size() - 1) {
/* 324 */           String str1 = ((BlockDef)blockDefs.get(m)).blockId() + ((BlockDef)blockDefs.get(m)).blockId();
/*     */           try {
/* 326 */             BlockState blockState = BlockStateParser.parseForBlock(level().holderLookup(Registries.BLOCK), str1, false).blockState();
/* 327 */             level().setBlockAndUpdate(blockPos, blockState);
/*     */           }
/* 329 */           catch (CommandSyntaxException e) {
/* 330 */             throw new RuntimeException(e);
/*     */           } 
/*     */           continue label127;
/*     */         } 
/*     */       } 
/* 335 */       String str = ((BlockDef)blockDefs.getLast()).blockId() + ((BlockDef)blockDefs.getLast()).blockId();
/*     */       try {
/* 337 */         BlockState blockState = BlockStateParser.parseForBlock(level().holderLookup(Registries.BLOCK), str, false).blockState();
/* 338 */         level().setBlockAndUpdate(blockPos, blockState);
/* 339 */       } catch (CommandSyntaxException e) {
/* 340 */         throw new RuntimeException(e);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 346 */     containing = containing.below(10);
/*     */     
/* 348 */     for (SparseMatrix.Cell<?> cell : ofCircle(containing, 74)) {
/* 349 */       level().setBlockAndUpdate(new BlockPos(cell.x(), containing.getY(), cell.z()), Blocks.GRASS_BLOCK.defaultBlockState());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 437 */     this.doneit = true; }
/*     */ 
/*     */   
/*     */   private ServerLevel level() {
/* 441 */     return this.controller.getLevel();
/*     */   }
/*     */ 
/*     */   
/*     */   public void accept(__ROOT__ obj) {
/* 446 */     super.accept(obj);
/* 447 */     this.updatePlayers = obj.getLevelRules().streamOf(UpdatePlayer.class).toList();
/*     */   }
/*     */ 
/*     */   
/*     */   public MinigameAbilities minigameAbilities() {
/* 452 */     MinigameAbilities minigameAbilities = super.minigameAbilities();
/* 453 */     minigameAbilities.pvpEnabled = true;
/* 454 */     return minigameAbilities;
/*     */   }
/*     */ 
/*     */   
/*     */   public void acceptPlayer(MinigameParty.PlayerSlot slot) {
/* 459 */     ServerPlayer player = slot.getParty().player(slot).orElseThrow();
/* 460 */     player.getInventory().clearContent();
/* 461 */     player.setGameMode(GameType.SURVIVAL);
/*     */   }
/*     */   
/*     */   public Vec3i spawnPos(int player) {
/* 465 */     int index = player % this.updatePlayers.size();
/* 466 */     return (Vec3i)BlockPos.containing(0.0D, ((UpdatePlayer)this.updatePlayers.get(index)).spawnY(), 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public float yRot() {
/* 471 */     return ((UpdatePlayer)this.updatePlayers.getFirst()).yRot();
/*     */   }
/*     */   
/*     */   public float xRot() {
/* 475 */     return ((UpdatePlayer)this.updatePlayers.getFirst()).xRot();
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\controller\tumble\TumbleMinigameController.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */