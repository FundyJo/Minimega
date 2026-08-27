/*     */ package dev.jab125.minimega.mod.client.gui.widget;
/*     */ 
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.hash.Hashing;
/*     */ import com.mojang.blaze3d.platform.NativeImage;
/*     */ import dev.jab125.minimega.mod.Minimega;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.texture.AbstractTexture;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.resources.Identifier;
/*     */ import net.minecraft.server.packs.PackResources;
/*     */ import net.minecraft.server.packs.repository.Pack;
/*     */ import net.minecraft.server.packs.resources.IoSupplier;
/*     */ import net.minecraft.util.Util;
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
/*     */ public interface IEntry
/*     */ {
/* 114 */   public static final Identifier DEFAULT_ICON = Identifier.withDefaultNamespace("textures/misc/unknown_pack.png");
/* 115 */   public static final Map<String, Identifier> packIcons = Maps.newHashMap();
/*     */   
/*     */   private static Identifier loadPackIcon(TextureManager textureManager, Pack pack) {
/*     */     try {
/*     */       Identifier var9;
/* 120 */       PackResources packResources = pack.open(); 
/* 121 */       try { IoSupplier<InputStream> ioSupplier = packResources.getRootResource(new String[] { "pack.png" });
/* 122 */         if (ioSupplier == null)
/* 123 */         { Identifier identifier = DEFAULT_ICON;
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
/* 151 */           if (packResources != null) packResources.close();  return identifier; }  String string = pack.getId(); Identifier resourceLocation = Identifier.withDefaultNamespace("pack/" + Util.sanitizeName(string, Identifier::validPathChar) + "/" + String.valueOf(Hashing.sha1().hashUnencodedChars(string)) + "/icon"); InputStream inputStream = (InputStream)ioSupplier.get(); try { NativeImage nativeImage = NativeImage.read(inputStream); Objects.requireNonNull(resourceLocation); textureManager.register(resourceLocation, (AbstractTexture)new DynamicTexture(resourceLocation::toString, nativeImage)); var9 = resourceLocation; } catch (Throwable var12) { if (inputStream != null) try { inputStream.close(); } catch (Throwable var11) { var12.addSuppressed(var11); }   throw var12; }  if (inputStream != null) inputStream.close();  if (packResources != null) packResources.close();  } catch (Throwable throwable) { if (packResources != null)
/*     */           try { packResources.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }
/* 153 */        return var9;
/* 154 */     } catch (Exception var14) {
/* 155 */       Identifier var9; Minimega.LOGGER.warn("Failed to load icon from pack {}", pack.getId(), var9);
/* 156 */       return DEFAULT_ICON;
/*     */     } 
/*     */   }
/*     */   
/*     */   static Identifier getPackIcon(Pack pack) {
/* 161 */     return packIcons.computeIfAbsent(pack.getId(), string -> loadPackIcon(getTheClient().getTextureManager(), pack));
/*     */   }
/*     */   
/*     */   static Identifier getInternalPackIcon(String id) {
/* 165 */     return packIcons.computeIfAbsent(id, string -> getInternalIcon(getTheClient().getTextureManager(), id));
/*     */   }
/*     */   
/*     */   static Minecraft getTheClient() {
/* 169 */     return Minecraft.getInstance();
/*     */   }
/*     */   
/* 172 */   public static final Map<String, Identifier> internalPackIcons = Maps.newHashMap();
/*     */   
/*     */   private static Identifier getInternalIcon(TextureManager textureManager, String id) {
/* 175 */     if (id.contains("..")) throw new RuntimeException("no"); 
/* 176 */     if (id.startsWith("/")) throw new RuntimeException("no"); 
/*     */     try {
/*     */       Identifier var9;
/* 179 */       InputStream stream = MapSelectionList.class.getResourceAsStream("/" + id + "pack.png"); 
/* 180 */       try { IoSupplier<InputStream> ioSupplier = () -> stream;
/* 181 */         if (ioSupplier == null)
/* 182 */         { Identifier identifier = DEFAULT_ICON;
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
/* 210 */           if (stream != null) stream.close();  return identifier; }  String string = id; Identifier resourceLocation = Identifier.withDefaultNamespace("pack/" + Util.sanitizeName(string, Identifier::validPathChar) + "/" + String.valueOf(Hashing.sha1().hashUnencodedChars(string)) + "/icon"); InputStream inputStream = (InputStream)ioSupplier.get(); try { NativeImage nativeImage = NativeImage.read(inputStream); Objects.requireNonNull(resourceLocation); textureManager.register(resourceLocation, (AbstractTexture)new DynamicTexture(resourceLocation::toString, nativeImage)); var9 = resourceLocation; } catch (Throwable var12) { if (inputStream != null) try { inputStream.close(); } catch (Throwable var11) { var12.addSuppressed(var11); }   throw var12; }  if (inputStream != null) inputStream.close();  if (stream != null) stream.close();  } catch (Throwable throwable) { if (stream != null)
/*     */           try { stream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }
/* 212 */        return var9;
/* 213 */     } catch (Exception var14) {
/* 214 */       Identifier var9; Minimega.LOGGER.warn("Failed to load internal icon {}", id, var9);
/* 215 */       return DEFAULT_ICON;
/*     */     } 
/*     */   }
/*     */   
/*     */   static Identifier resourcePack(String resourcepack) {
/* 220 */     return "vanilla".equals(resourcepack) ? getPackIcon(getTheClient().getResourcePackRepository().getPack(resourcepack)) : getInternalPackIcon(resourcepack);
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\widget\MapSelectionList$IEntry.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */