/*     */ package dev.jab125.minimega.mod.util.minigamedata.battle;
/*     */ 
/*     */ import com.mojang.datafixers.util.Function14;
/*     */ import java.util.function.Function;
/*     */ import net.minecraft.network.codec.StreamCodec;
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
/*     */   implements StreamCodec<B, C>
/*     */ {
/*     */   public C decode(B input) {
/* 116 */     T1 v1 = (T1)codec1.decode(input);
/* 117 */     T2 v2 = (T2)codec2.decode(input);
/* 118 */     T3 v3 = (T3)codec3.decode(input);
/* 119 */     T4 v4 = (T4)codec4.decode(input);
/* 120 */     T5 v5 = (T5)codec5.decode(input);
/* 121 */     T6 v6 = (T6)codec6.decode(input);
/* 122 */     T7 v7 = (T7)codec7.decode(input);
/* 123 */     T8 v8 = (T8)codec8.decode(input);
/* 124 */     T9 v9 = (T9)codec9.decode(input);
/* 125 */     T10 v10 = (T10)codec10.decode(input);
/* 126 */     T11 v11 = (T11)codec11.decode(input);
/* 127 */     T12 v12 = (T12)codec12.decode(input);
/* 128 */     T13 v13 = (T13)codec13.decode(input);
/* 129 */     T14 v14 = (T14)codec14.decode(input);
/* 130 */     return (C)constructor.apply(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14);
/*     */   }
/*     */ 
/*     */   
/*     */   public void encode(B output, C value) {
/* 135 */     codec1.encode(output, getter1.apply(value));
/* 136 */     codec2.encode(output, getter2.apply(value));
/* 137 */     codec3.encode(output, getter3.apply(value));
/* 138 */     codec4.encode(output, getter4.apply(value));
/* 139 */     codec5.encode(output, getter5.apply(value));
/* 140 */     codec6.encode(output, getter6.apply(value));
/* 141 */     codec7.encode(output, getter7.apply(value));
/* 142 */     codec8.encode(output, getter8.apply(value));
/* 143 */     codec9.encode(output, getter9.apply(value));
/* 144 */     codec10.encode(output, getter10.apply(value));
/* 145 */     codec11.encode(output, getter11.apply(value));
/* 146 */     codec12.encode(output, getter12.apply(value));
/* 147 */     codec13.encode(output, getter13.apply(value));
/* 148 */     codec14.encode(output, getter14.apply(value));
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\minigamedata\battle\CustomBattleConfigSettings$1.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */