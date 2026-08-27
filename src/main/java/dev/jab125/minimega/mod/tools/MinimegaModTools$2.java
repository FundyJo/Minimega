/*     */ package dev.jab125.minimega.mod.tools;
/*     */ 
/*     */ import com.mojang.brigadier.Command;
/*     */ import com.mojang.brigadier.context.CommandContext;
/*     */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*     */ import dev.jab125.minimega.grf.RootHolder;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.DistributeItems;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.LevelRules;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.MapOptions;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.OnGameStartSpawnPositions;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.OnInitialiseWorld;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.SpawnPositionSet;
/*     */ import dev.jab125.minimega.grf.newelements.mxml.grf.__ROOT__;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import net.minecraft.commands.CommandSourceStack;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.server.level.ServerLevel;
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
/*     */ class null
/*     */   implements Command<CommandSourceStack>
/*     */ {
/*     */   public int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
/* 170 */     ServerLevel level = ((CommandSourceStack)context.getSource()).getLevel();
/* 171 */     RootHolder level1 = (RootHolder)level;
/* 172 */     if (level1.getRoot() != null) {
/* 173 */       ((CommandSourceStack)context.getSource()).sendFailure((Component)Component.literal("GRF already exists, cannot override an existing one!"));
/* 174 */       return -1;
/*     */     } 
/* 176 */     level1.setRoot(new __ROOT__(List.of(new MapOptions(0, Optional.empty(), 0.0D, List.of()), new LevelRules(1, List.of(new OnGameStartSpawnPositions(List.of(new SpawnPositionSet(0, List.of()), new SpawnPositionSet(1, List.of()))), new OnInitialiseWorld(List.of(new DistributeItems("StartItems", List.of()), new DistributeItems("OuterItems", List.of()), new DistributeItems("HVItems", List.of()))))))));
/*     */     
/* 178 */     ((CommandSourceStack)context.getSource()).sendSuccess(() -> Component.literal("GRF successfully initialized!"), true);
/* 179 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\tools\MinimegaModTools$2.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */