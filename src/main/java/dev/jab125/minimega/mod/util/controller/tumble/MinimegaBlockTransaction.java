/*    */ package dev.jab125.minimega.mod.util.controller.tumble;
/*    */ 
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import xyz.nucleoid.map_templates.MapTemplate;
/*    */ 
/*    */ public class MinimegaBlockTransaction {
/*  8 */   MapTemplate template = MapTemplate.createEmpty();
/*    */   
/*    */   public void setBlock(BlockPos pos, BlockState state) {
/* 11 */     this.template.setBlockState(pos, state);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\controller\tumble\MinimegaBlockTransaction.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */