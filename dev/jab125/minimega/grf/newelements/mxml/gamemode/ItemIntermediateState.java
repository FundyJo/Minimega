/*    */ package dev.jab125.minimega.grf.newelements.mxml.gamemode;
/*    */ 
/*    */ 
/*    */ public final class ItemIntermediateState extends Record {
/*    */   private final String id;
/*    */   private final Optional<Integer> dataTag;
/*    */   private final Optional<Integer> slot;
/*    */   private final Optional<Integer> damage;
/*    */   private final int count;
/*    */   private final int dfu;
/*    */   
/* 12 */   public String id() { return this.id; } private final List<Dynamic<?>> childRules; public static final Codec<ItemIntermediateState> CODEC; public static final Codec<ItemIntermediateState> CODEC2; public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/ItemIntermediateState;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/ItemIntermediateState; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/ItemIntermediateState;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/ItemIntermediateState; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/grf/newelements/mxml/gamemode/ItemIntermediateState;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/grf/newelements/mxml/gamemode/ItemIntermediateState;
/* 12 */     //   0	8	1	o	Ljava/lang/Object; } public Optional<Integer> dataTag() { return this.dataTag; } public Optional<Integer> slot() { return this.slot; } public Optional<Integer> damage() { return this.damage; } public int count() { return this.count; } public int dfu() { return this.dfu; } public List<Dynamic<?>> childRules() { return this.childRules; } static {
/* 13 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)LenientParsers.STRING.fieldOf("id").forGetter(ItemIntermediateState::id), (App)MapCodec.unit(Optional.empty()).forGetter(ItemIntermediateState::dataTag), (App)MapCodec.unit(Optional.empty()).forGetter(ItemIntermediateState::slot), (App)LenientParsers.INT.optionalFieldOf("aux").forGetter(ItemIntermediateState::damage), (App)LenientParsers.INT.optionalFieldOf("qty", Integer.valueOf(1)).forGetter(ItemIntermediateState::count), (App)LenientParsers.INT.optionalFieldOf("dfu", Integer.valueOf(100)).forGetter(ItemIntermediateState::dfu), (App)Codec.PASSTHROUGH.listOf().fieldOf("childRules").forGetter(ItemIntermediateState::childRules)).apply((Applicative)instance, ItemIntermediateState::new));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 23 */     CODEC2 = RecordCodecBuilder.create(instance -> instance.group((App)LenientParsers.STRING.fieldOf("itemId").forGetter(ItemIntermediateState::id), (App)LenientParsers.INT.optionalFieldOf("dataTag").forGetter(ItemIntermediateState::dataTag), (App)LenientParsers.INT.optionalFieldOf("slot").forGetter(ItemIntermediateState::slot), (App)LenientParsers.INT.optionalFieldOf("auxValue").forGetter(ItemIntermediateState::damage), (App)LenientParsers.INT.optionalFieldOf("quantity", Integer.valueOf(1)).forGetter(ItemIntermediateState::count), (App)LenientParsers.INT.optionalFieldOf("dfu", Integer.valueOf(100)).forGetter(ItemIntermediateState::dfu), (App)Codec.PASSTHROUGH.listOf().fieldOf("childRules").forGetter(ItemIntermediateState::childRules)).apply((Applicative)instance, ItemIntermediateState::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemIntermediateState(String id, Optional<Integer> dataTag, Optional<Integer> slot, Optional<Integer> damage, int count, int dfu, List<Dynamic<?>> childRules) {
/* 34 */     if (dfu >= 1451 && damage.isPresent()) throw new AssertionError("NO!!"); 
/*    */     this.id = id;
/*    */     this.dataTag = dataTag;
/*    */     this.slot = slot;
/*    */     this.damage = damage;
/*    */     this.count = count;
/*    */     this.dfu = dfu;
/*    */     this.childRules = childRules;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\gamemode\ItemIntermediateState.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */