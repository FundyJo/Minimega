/*   */ package dev.jab125.minimega.mod.client.compat;
/*   */ 
/*   */ import com.terraformersmc.modmenu.api.ConfigScreenFactory;
/*   */ import com.terraformersmc.modmenu.api.ModMenuApi;
/*   */ 
/*   */ public class ModMenuCompat
/*   */   implements ModMenuApi {
/*   */   public ConfigScreenFactory<?> getModConfigScreenFactory() {
/* 9 */     return super.getModConfigScreenFactory();
/*   */   }
/*   */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\compat\ModMenuCompat.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */