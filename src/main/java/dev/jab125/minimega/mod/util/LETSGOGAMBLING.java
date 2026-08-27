/*    */ package dev.jab125.minimega.mod.util;
/*    */ 
/*    */ import com.google.common.collect.Lists;
/*    */ import dev.jab125.minimega.mod.Minimega;
/*    */ import it.unimi.dsi.fastutil.objects.ObjectArrayList;
/*    */ import it.unimi.dsi.fastutil.objects.ObjectListIterator;
/*    */ import java.util.List;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.util.RandomSource;
/*    */ import net.minecraft.util.Util;
/*    */ import net.minecraft.world.Container;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ 
/*    */ public class LETSGOGAMBLING
/*    */ {
/*    */   private static List<Integer> getAvailableSlots(Container container, RandomSource random) {
/* 17 */     ObjectArrayList<Integer> slots = new ObjectArrayList();
/*    */     
/* 19 */     for (int i = 0; i < container.getContainerSize(); i++) {
/* 20 */       if (container.getItem(i).isEmpty()) {
/* 21 */         slots.add(Integer.valueOf(i));
/*    */       }
/*    */     } 
/*    */     
/* 25 */     Util.shuffle((List)slots, random);
/* 26 */     return (List<Integer>)slots;
/*    */   }
/*    */   public static void fill(Container container, ObjectArrayList<ItemStack> itemStacks, RandomSource source) {
/* 29 */     RandomSource random = source;
/* 30 */     List<Integer> availableSlots = getAvailableSlots(container, random);
/* 31 */     shuffleAndSplitItems(itemStacks, availableSlots.size(), random);
/*    */     
/* 33 */     for (ObjectListIterator<ItemStack> objectListIterator = itemStacks.iterator(); objectListIterator.hasNext(); ) { ItemStack itemStack = objectListIterator.next();
/* 34 */       if (availableSlots.isEmpty()) {
/* 35 */         Minimega.LOGGER.warn("Tried to over-fill a container");
/*    */         
/*    */         return;
/*    */       } 
/* 39 */       if (itemStack.isEmpty()) {
/* 40 */         container.setItem(((Integer)availableSlots.remove(availableSlots.size() - 1)).intValue(), ItemStack.EMPTY); continue;
/*    */       } 
/* 42 */       container.setItem(((Integer)availableSlots.remove(availableSlots.size() - 1)).intValue(), itemStack); }
/*    */   
/*    */   }
/*    */   
/*    */   public static void shuffleAndSplitItems(ObjectArrayList<ItemStack> result, int availableSlots, RandomSource random) {
/* 47 */     List<ItemStack> splittableItems = Lists.newArrayList();
/* 48 */     ObjectListIterator<ItemStack> objectListIterator = result.iterator();
/*    */     
/* 50 */     while (objectListIterator.hasNext()) {
/* 51 */       ItemStack itemStack = objectListIterator.next();
/* 52 */       if (itemStack.isEmpty()) {
/* 53 */         objectListIterator.remove(); continue;
/* 54 */       }  if (itemStack.getCount() > 1) {
/* 55 */         splittableItems.add(itemStack);
/* 56 */         objectListIterator.remove();
/*    */       } 
/*    */     } 
/*    */     
/* 60 */     while (availableSlots - result.size() - splittableItems.size() > 0 && !splittableItems.isEmpty()) {
/* 61 */       ItemStack itemStack = splittableItems.remove(Mth.nextInt(random, 0, splittableItems.size() - 1));
/* 62 */       int remove = Mth.nextInt(random, 1, itemStack.getCount() / 2);
/* 63 */       ItemStack copy = itemStack.split(remove);
/* 64 */       if (itemStack.getCount() > 1 && random.nextBoolean()) {
/* 65 */         splittableItems.add(itemStack);
/*    */       } else {
/* 67 */         result.add(itemStack);
/*    */       } 
/*    */       
/* 70 */       if (copy.getCount() > 1 && random.nextBoolean()) {
/* 71 */         splittableItems.add(copy); continue;
/*    */       } 
/* 73 */       result.add(copy);
/*    */     } 
/*    */ 
/*    */     
/* 77 */     result.addAll(splittableItems);
/* 78 */     Util.shuffle((List)result, random);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\LETSGOGAMBLING.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */