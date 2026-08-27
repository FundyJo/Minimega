/*    */ package dev.jab125.minimega.mod.mixin;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import dev.jab125.minimega.mod.util.Minigame;
/*    */ import dev.jab125.minimega.mod.util.controller.AbstractMinigameController;
/*    */ import dev.jab125.minimega.mod.util.controller.MinigamesController;
/*    */ import dev.jab125.minimega.mod.util.controller.fistfight.FistfightMinigameController;
/*    */ import java.util.List;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.block.entity.ConduitBlockEntity;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ 
/*    */ @Mixin({ConduitBlockEntity.class})
/*    */ public class ConduitBlockEntityMixin {
/*    */   @WrapMethod(method = {"applyEffects"})
/*    */   private static void applyEffects(Level level, BlockPos blockPos, List<BlockPos> list, Operation<Void> original) {
/* 19 */     AbstractMinigameController abstractMinigameController = MinigamesController.getMinigameController(level).getController(Minigame.FISTFIGHT); if (abstractMinigameController instanceof FistfightMinigameController) { FistfightMinigameController controller = (FistfightMinigameController)abstractMinigameController; if (controller.getFistfightFlag() != 45)
/* 20 */       { original.call(new Object[] { level, blockPos, list }); return; }  return; }  original.call(new Object[] { level, blockPos, list });
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\ConduitBlockEntityMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */