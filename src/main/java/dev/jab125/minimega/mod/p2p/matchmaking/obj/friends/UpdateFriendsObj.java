/*    */ package dev.jab125.minimega.mod.p2p.matchmaking.obj.friends;
/*    */ 
/*    */ import com.mojang.serialization.DataResult;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import java.util.UUID;
/*    */ 
/*    */ public final class UpdateFriendsObj extends Record implements CodecObj<UpdateFriendsObj> {
/*    */   private final List<UUID> friends;
/*    */   private static final Codec<UUID> STRING_CODEC;
/*    */   public static final Codec<UpdateFriendsObj> CODEC;
/*    */   
/* 12 */   public UpdateFriendsObj(List<UUID> friends) { this.friends = friends; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/friends/UpdateFriendsObj;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 12 */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/friends/UpdateFriendsObj; } public List<UUID> friends() { return this.friends; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/friends/UpdateFriendsObj;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/friends/UpdateFriendsObj; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Ldev/jab125/minimega/mod/p2p/matchmaking/obj/friends/UpdateFriendsObj;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Ldev/jab125/minimega/mod/p2p/matchmaking/obj/friends/UpdateFriendsObj;
/* 13 */     //   0	8	1	o	Ljava/lang/Object; } static { STRING_CODEC = Codec.STRING.comapFlatMap(string -> {
/*    */           try {
/*    */             return DataResult.success(UUID.fromString(string), Lifecycle.stable());
/* 16 */           } catch (IllegalArgumentException var2) {
/*    */             return DataResult.error(());
/*    */           } 
/*    */         }UUID::toString);
/*    */     
/* 21 */     CODEC = RecordCodecBuilder.create(instance -> instance.group((App)STRING_CODEC.listOf(0, 32767).fieldOf("friends").forGetter(UpdateFriendsObj::friends)).apply((Applicative)instance, UpdateFriendsObj::new)); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Codec<UpdateFriendsObj> codec() {
/* 27 */     return CODEC;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\p2p\matchmaking\obj\friends\UpdateFriendsObj.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */