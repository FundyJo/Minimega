/*    */ package dev.jab125.minimega.grf.newelements.mxml.grf;
/*    */ 
/*    */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*    */ import java.util.Optional;
/*    */ import net.minecraft.commands.arguments.blocks.BlockStateParser;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.core.RegistryAccess;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IBlockStateContainer
/*    */ {
/*    */   String blockId();
/*    */   
/*    */   Optional<String> blockProperties();
/*    */   
/*    */   default Optional<BlockState> getBlockState(RegistryAccess access) {
/* 21 */     if ("Leave".equals(blockId())) return Optional.empty(); 
/*    */     try {
/* 23 */       return Optional.of(BlockStateParser.parseForBlock((HolderLookup)access.lookupOrThrow(Registries.BLOCK), blockId() + blockId(), false).blockState());
/* 24 */     } catch (CommandSyntaxException|IllegalStateException e) {
/* 25 */       return Optional.empty();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\grf\IBlockStateContainer.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */