/*    */ package dev.jab125.minimega.mod.mixin.battle;
/*    */ 
/*    */ import dev.jab125.minimega.mod.extension.AbstractContainerMenuExtension;
/*    */ import net.minecraft.world.Container;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.inventory.AbstractContainerMenu;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({AbstractContainerMenu.class})
/*    */ public abstract class AbstractContainerMenuMixin
/*    */   implements AbstractContainerMenuExtension
/*    */ {
/*    */   public void mm$takeAll(Player player, Container container) {
/* 22 */     for (int i = 0; i < container.getContainerSize(); i++) {
/* 23 */       container.setItem(i, tryToPlaceInInventory(player, container.getItem(i)));
/*    */     }
/* 25 */     player.inventoryMenu.sendAllDataToRemote();
/*    */   }
/*    */   
/*    */   @Unique
/*    */   private static ItemStack tryToPlaceInInventory(Player player, ItemStack itemStack) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: invokevirtual isRemoved : ()Z
/*    */     //   4: ifeq -> 21
/*    */     //   7: aload_0
/*    */     //   8: invokevirtual getRemovalReason : ()Lnet/minecraft/world/entity/Entity$RemovalReason;
/*    */     //   11: getstatic net/minecraft/world/entity/Entity$RemovalReason.CHANGED_DIMENSION : Lnet/minecraft/world/entity/Entity$RemovalReason;
/*    */     //   14: if_acmpeq -> 21
/*    */     //   17: iconst_1
/*    */     //   18: goto -> 22
/*    */     //   21: iconst_0
/*    */     //   22: istore_2
/*    */     //   23: aload_0
/*    */     //   24: instanceof net/minecraft/server/level/ServerPlayer
/*    */     //   27: ifeq -> 48
/*    */     //   30: aload_0
/*    */     //   31: checkcast net/minecraft/server/level/ServerPlayer
/*    */     //   34: astore #4
/*    */     //   36: aload #4
/*    */     //   38: invokevirtual hasDisconnected : ()Z
/*    */     //   41: ifeq -> 48
/*    */     //   44: iconst_1
/*    */     //   45: goto -> 49
/*    */     //   48: iconst_0
/*    */     //   49: istore_3
/*    */     //   50: iload_2
/*    */     //   51: ifne -> 58
/*    */     //   54: iload_3
/*    */     //   55: ifeq -> 68
/*    */     //   58: aload_0
/*    */     //   59: aload_1
/*    */     //   60: iconst_0
/*    */     //   61: invokevirtual drop : (Lnet/minecraft/world/item/ItemStack;Z)Lnet/minecraft/world/entity/item/ItemEntity;
/*    */     //   64: pop
/*    */     //   65: goto -> 149
/*    */     //   68: aload_0
/*    */     //   69: instanceof net/minecraft/server/level/ServerPlayer
/*    */     //   72: ifeq -> 149
/*    */     //   75: invokestatic values : ()[Lnet/minecraft/world/entity/EquipmentSlot;
/*    */     //   78: astore #4
/*    */     //   80: aload #4
/*    */     //   82: arraylength
/*    */     //   83: istore #5
/*    */     //   85: iconst_0
/*    */     //   86: istore #6
/*    */     //   88: iload #6
/*    */     //   90: iload #5
/*    */     //   92: if_icmpge -> 140
/*    */     //   95: aload #4
/*    */     //   97: iload #6
/*    */     //   99: aaload
/*    */     //   100: astore #7
/*    */     //   102: aload_0
/*    */     //   103: aload #7
/*    */     //   105: invokevirtual getItemBySlot : (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
/*    */     //   108: astore #8
/*    */     //   110: aload_0
/*    */     //   111: aload_1
/*    */     //   112: aload #8
/*    */     //   114: aload #7
/*    */     //   116: invokestatic canReplaceCurrentItem : (Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/EquipmentSlot;)Z
/*    */     //   119: ifeq -> 134
/*    */     //   122: aload_0
/*    */     //   123: aload #7
/*    */     //   125: aload_1
/*    */     //   126: invokevirtual setItemSlot : (Lnet/minecraft/world/entity/EquipmentSlot;Lnet/minecraft/world/item/ItemStack;)V
/*    */     //   129: aload #8
/*    */     //   131: astore_1
/*    */     //   132: aload_1
/*    */     //   133: areturn
/*    */     //   134: iinc #6, 1
/*    */     //   137: goto -> 88
/*    */     //   140: aload_0
/*    */     //   141: invokevirtual getInventory : ()Lnet/minecraft/world/entity/player/Inventory;
/*    */     //   144: aload_1
/*    */     //   145: invokevirtual add : (Lnet/minecraft/world/item/ItemStack;)Z
/*    */     //   148: pop
/*    */     //   149: aload_1
/*    */     //   150: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #30	-> 0
/*    */     //   #31	-> 23
/*    */     //   #32	-> 50
/*    */     //   #33	-> 58
/*    */     //   #34	-> 68
/*    */     //   #35	-> 75
/*    */     //   #36	-> 102
/*    */     //   #37	-> 110
/*    */     //   #38	-> 122
/*    */     //   #39	-> 129
/*    */     //   #40	-> 132
/*    */     //   #35	-> 134
/*    */     //   #44	-> 140
/*    */     //   #46	-> 149
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   36	12	4	serverPlayer	Lnet/minecraft/server/level/ServerPlayer;
/*    */     //   110	24	8	itemBySlot	Lnet/minecraft/world/item/ItemStack;
/*    */     //   102	32	7	value	Lnet/minecraft/world/entity/EquipmentSlot;
/*    */     //   0	151	0	player	Lnet/minecraft/world/entity/player/Player;
/*    */     //   0	151	1	itemStack	Lnet/minecraft/world/item/ItemStack;
/*    */     //   23	128	2	bl	Z
/*    */     //   50	101	3	bl2	Z
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mixin\battle\AbstractContainerMenuMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */