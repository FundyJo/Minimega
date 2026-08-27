/*    */ package dev.jab125.minimega.grf.newelements.mxml.gamemode;
/*    */ 
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import dev.jab125.minimega.grf.newelements.LenientParsers;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Objects;
/*    */ import java.util.Optional;
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.core.RegistryAccess;
/*    */ import net.minecraft.core.component.DataComponentPatch;
/*    */ import net.minecraft.core.component.DataComponents;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.resources.Identifier;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.world.effect.MobEffectInstance;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.alchemy.Potion;
/*    */ import net.minecraft.world.item.alchemy.PotionContents;
/*    */ import net.minecraft.world.item.enchantment.ItemEnchantments;
/*    */ 
/*    */ public final class Item extends Record implements IMXml, CanBeContainedInItem {
/*    */   private final String id;
/*    */   private final int count;
/*    */   private final List<CanBeContainedInItem> childRules;
/*    */   public static final Codec<Item> CODEC;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/Item;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #37	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/Item;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/Item;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #37	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/Item;
/*    */   }
/*    */   
/* 37 */   public Item(String id, int count, List<CanBeContainedInItem> childRules) { this.id = id; this.count = count; this.childRules = childRules; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/Item;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #37	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/Item;
/* 37 */     //   0	8	1	o	Ljava/lang/Object; } public String id() { return this.id; } public int count() { return this.count; } public List<CanBeContainedInItem> childRules() { return this.childRules; } static {
/* 38 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)LenientParsers.STRING.fieldOf("id").forGetter(Item::id), (App)LenientParsers.INT.optionalFieldOf("qty", Integer.valueOf(1)).forGetter(Item::count), (App)CanBeContainedInItemCodecs.CODEC.listOf().fieldOf("childRules").forGetter(Item::childRules)).apply((Applicative)instance, Item::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String serializedId() {
/* 46 */     return "Item";
/*    */   }
/*    */   
/*    */   public ItemStack createItemStack(RegistryAccess access, PotionBalancer balancer) {
/* 50 */     ResourceKey<net.minecraft.world.item.Item> itemResourceKey = ResourceKey.create(Registries.ITEM, Identifier.parse(this.id));
/* 51 */     Holder.Reference<net.minecraft.world.item.Item> value = access.getOrThrow(itemResourceKey);
/* 52 */     DataComponentPatch.Builder builder = DataComponentPatch.builder();
/*    */     
/* 54 */     Objects.requireNonNull(Damage.class); builder.set(DataComponents.DAMAGE, this.childRules.stream().filter(a -> a instanceof Damage).map(Damage.class::cast).findFirst().map(Damage::amount).orElse(Integer.valueOf(0)));
/*    */     
/* 56 */     if (itemResourceKey.equals(ResourceKey.create(Registries.ITEM, Identifier.parse("tnt")))) {
/* 57 */       builder.set(DataComponents.CAN_PLACE_ON, new AdventureModePredicate(
/* 58 */             List.of(BlockPredicate.Builder.block().build())));
/*    */     }
/*    */     
/* 61 */     if (itemResourceKey.equals(ResourceKey.create(Registries.ITEM, Identifier.parse("potion")))) {
/* 62 */       builder.remove(DataComponents.USE_REMAINDER);
/*    */     }
/* 64 */     Objects.requireNonNull(PotionContents.class); Optional<String> first = this.childRules.stream().filter(a -> a instanceof PotionContents).map(PotionContents.class::cast).map(PotionContents::potion).findFirst();
/* 65 */     first.ifPresent(potion -> {
/*    */           PotionContents value1 = new PotionContents((Holder)access.getOrThrow(ResourceKey.create(Registries.POTION, Identifier.parse(potion)))); Integer patt0$temp = balancer.potionLength(ResourceKey.create(Registries.POTION, Identifier.parse(potion)), value.is(Identifier.withDefaultNamespace("splash_potion"))); if (patt0$temp instanceof Integer) {
/*    */             Integer i = patt0$temp;
/*    */             ArrayList<MobEffectInstance> objects = new ArrayList<>();
/*    */             for (MobEffectInstance allEffect : value1.getAllEffects()) {
/*    */               MobEffectInstance mobEffectInstance = new MobEffectInstance(allEffect);
/*    */               ((MobEffectInstanceAccessor)mobEffectInstance).setDuration(i.intValue());
/*    */               objects.add(mobEffectInstance);
/*    */             } 
/*    */             value1 = new PotionContents(Optional.empty(), Optional.empty(), objects, Optional.of(((Potion)((Holder)value1.potion().orElseThrow()).value()).name()));
/*    */           } 
/*    */           builder.set(DataComponents.POTION_CONTENTS, value1);
/*    */         });
/* 78 */     Objects.requireNonNull(Enchantment.class); List<Enchantment> list = this.childRules.stream().filter(a -> a instanceof Enchantment).map(Enchantment.class::cast).toList();
/* 79 */     if (!list.isEmpty()) {
/* 80 */       ItemEnchantments.Mutable mutable = new ItemEnchantments.Mutable(ItemEnchantments.EMPTY);
/* 81 */       for (Enchantment enchantment : list) {
/* 82 */         mutable.set((Holder)access.getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse(enchantment.id()))), enchantment.level());
/*    */       }
/* 84 */       builder.set(DataComponents.ENCHANTMENTS, mutable.toImmutable());
/*    */     } 
/* 86 */     ItemStack itemStack = new ItemStack((Holder)value, count(), builder.build());
/* 87 */     if (value.is(ItemTags.SWORDS)) {
/* 88 */       FistfightMinigameController.bl(access, itemStack);
/*    */     }
/* 90 */     return itemStack;
/*    */   }
/*    */   
/*    */   public static interface PotionBalancer {
/*    */     Integer potionLength(ResourceKey<Potion> param1ResourceKey, boolean param1Boolean);
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\gamemode\Item.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */