/*     */ package dev.jab125.minimega.mod.tools;
/*     */ 
/*     */ import net.fabricmc.fabric.api.event.player.ItemEvents;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.world.InteractionResult;
/*     */ import net.minecraft.world.item.context.UseOnContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements ItemEvents.UseOnCallback
/*     */ {
/*     */   public InteractionResult useOn(UseOnContext useOnContext) {
/*  90 */     BlockPos clickedPos1 = useOnContext.getClickedPos();
/*  91 */     Direction clickedFace = useOnContext.getClickedFace();
/*  92 */     MinimegaModTools.WandType wandType = MinimegaModTools.getWandType(useOnContext.getItemInHand());
/*  93 */     if (wandType == MinimegaModTools.WandType.NONE) return null; 
/*  94 */     if (useOnContext.getLevel().isClientSide()) return (InteractionResult)InteractionResult.SUCCESS; 
/*  95 */     switch (wandType.ordinal()) { case 5:
/*  96 */         MinimegaModTools.addSpawnPosition(useOnContext, clickedFace, clickedPos1, Integer.valueOf(0)); break;
/*  97 */       case 6: MinimegaModTools.addSpawnPosition(useOnContext, clickedFace, clickedPos1, Integer.valueOf(1)); break;
/*  98 */       case 7: MinimegaModTools.addSpawnPosition(useOnContext, clickedFace, clickedPos1, null); break;
/*  99 */       case 1: MinimegaModTools.addChest(useOnContext, clickedPos1, "StartItems"); break;
/* 100 */       case 2: MinimegaModTools.addChest(useOnContext, clickedPos1, "OuterItems"); break;
/* 101 */       case 3: MinimegaModTools.addChest(useOnContext, clickedPos1, "HVItems"); break;
/* 102 */       case 8: MinimegaModTools.addSpawnPosition(useOnContext, clickedFace, clickedPos1, Integer.valueOf(-1)); break;
/* 103 */       case 4: MinimegaModTools.addChest(useOnContext, clickedPos1, null); break;
/*     */       case 9:
/* 105 */         MinimegaModTools.addSpawnPosition(useOnContext, clickedFace, clickedPos1, null);
/* 106 */         MinimegaModTools.addSpawnPosition(useOnContext, clickedFace, clickedPos1, Integer.valueOf(-2));
/* 107 */         MinimegaModTools.addChest(useOnContext, clickedPos1, null);
/*     */         break; }
/*     */     
/* 110 */     return (InteractionResult)InteractionResult.SUCCESS;
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\tools\MinimegaModTools$1.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */