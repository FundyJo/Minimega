/*    */ package dev.jab125.minimega.mod.util;
/*    */ 
/*    */ import it.unimi.dsi.fastutil.objects.Object2IntMap;
/*    */ import java.util.Set;
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.core.component.DataComponents;
/*    */ import net.minecraft.world.entity.EquipmentSlot;
/*    */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*    */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.component.ItemAttributeModifiers;
/*    */ import net.minecraft.world.item.enchantment.Enchantment;
/*    */ import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
/*    */ import net.minecraft.world.item.enchantment.EnchantmentHelper;
/*    */ import net.minecraft.world.item.enchantment.ItemEnchantments;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArmorComparer
/*    */ {
/*    */   public static boolean canReplaceCurrentItem(Player player, ItemStack newItemStack, ItemStack currentItemStack, EquipmentSlot slot) {
/* 51 */     if (!player.isEquippableInSlot(newItemStack, slot)) return false; 
/* 52 */     if (currentItemStack.isEmpty())
/* 53 */       return true; 
/* 54 */     if (slot.isArmor()) {
/* 55 */       return compareArmor(player, newItemStack, currentItemStack, slot);
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   private static boolean compareArmor(Player player, ItemStack newItemStack, ItemStack currentItemStack, EquipmentSlot slot) {
/* 62 */     if (EnchantmentHelper.has(currentItemStack, EnchantmentEffectComponents.PREVENT_ARMOR_CHANGE)) {
/* 63 */       return false;
/*    */     }
/* 65 */     double newDefense = getApproximateAttributeWith(player, newItemStack, Attributes.ARMOR, slot);
/* 66 */     double oldDefense = getApproximateAttributeWith(player, currentItemStack, Attributes.ARMOR, slot);
/* 67 */     double newToughness = getApproximateAttributeWith(player, newItemStack, Attributes.ARMOR_TOUGHNESS, slot);
/* 68 */     double oldToughness = getApproximateAttributeWith(player, currentItemStack, Attributes.ARMOR_TOUGHNESS, slot);
/* 69 */     if (newDefense != oldDefense) {
/* 70 */       return (newDefense > oldDefense);
/*    */     }
/* 72 */     return (newToughness != oldToughness) ? ((newToughness > oldToughness)) : canReplaceEqualItem(newItemStack, currentItemStack);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static double getApproximateAttributeWith(Player player, ItemStack itemStack, Holder<Attribute> attribute, EquipmentSlot slot) {
/* 78 */     double baseValue = player.getAttributes().hasAttribute(attribute) ? player.getAttributeBaseValue(attribute) : 0.0D;
/* 79 */     ItemAttributeModifiers attributeModifiers = (ItemAttributeModifiers)itemStack.getOrDefault(DataComponents.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.EMPTY);
/* 80 */     return attributeModifiers.compute(attribute, baseValue, slot);
/*    */   }
/*    */   
/*    */   public static boolean canReplaceEqualItem(ItemStack newItemStack, ItemStack currentItemStack) {
/* 84 */     Set<Object2IntMap.Entry<Holder<Enchantment>>> currentEnchantments = ((ItemEnchantments)currentItemStack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY)).entrySet();
/* 85 */     Set<Object2IntMap.Entry<Holder<Enchantment>>> newEnchantments = ((ItemEnchantments)newItemStack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY)).entrySet();
/* 86 */     if (newEnchantments.size() != currentEnchantments.size()) {
/* 87 */       return (newEnchantments.size() > currentEnchantments.size());
/*    */     }
/* 89 */     int newDamageValue = newItemStack.getDamageValue();
/* 90 */     int currentDamageValue = currentItemStack.getDamageValue();
/* 91 */     return (newDamageValue != currentDamageValue) ? (
/* 92 */       (newDamageValue < currentDamageValue)) : (
/* 93 */       (newItemStack.has(DataComponents.CUSTOM_NAME) && !currentItemStack.has(DataComponents.CUSTOM_NAME)));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\ArmorComparer.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */