package dev.jab125.minimega.mod.client.gui.widget;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import com.google.common.collect.Maps;
import com.google.common.hash.Hashing;
import com.mojang.blaze3d.platform.NativeImage;
import dev.jab125.minimega.mod.Minimega;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.resources.IoSupplier;
import net.minecraft.util.Util;
public class MapSelectionList {

   interface GuiGraphicsWrapper {
     void blit(RenderPipeline paramRenderPipeline, Identifier paramIdentifier, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
     
     void text(Font paramFont, Component paramComponent, int paramInt1, int paramInt2, int paramInt3);
   }

   public interface IEntry
   {
     public static final Identifier DEFAULT_ICON = Identifier.withDefaultNamespace("textures/misc/unknown_pack.png");
     public static final Map<String, Identifier> packIcons = Maps.newHashMap();
     
     private static Identifier loadPackIcon(TextureManager textureManager, Pack pack) {
       try {
         Identifier var9;
         PackResources packResources = pack.open(); 
         try { IoSupplier<InputStream> ioSupplier = packResources.getRootResource(new String[] { "pack.png" });
           if (ioSupplier == null)
           { Identifier identifier = DEFAULT_ICON;
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
             
             if (packResources != null) packResources.close();  return identifier; }  String string = pack.getId(); Identifier resourceLocation = Identifier.withDefaultNamespace("pack/" + Util.sanitizeName(string, Identifier::validPathChar) + "/" + String.valueOf(Hashing.sha1().hashUnencodedChars(string)) + "/icon"); InputStream inputStream = (InputStream)ioSupplier.get(); try { NativeImage nativeImage = NativeImage.read(inputStream); Objects.requireNonNull(resourceLocation); textureManager.register(resourceLocation, (AbstractTexture)new DynamicTexture(resourceLocation::toString, nativeImage)); var9 = resourceLocation; } catch (Throwable var12) { if (inputStream != null) try { inputStream.close(); } catch (Throwable var11) { var12.addSuppressed(var11); }   throw var12; }  if (inputStream != null) inputStream.close();  if (packResources != null) packResources.close();  } catch (Throwable throwable) { if (packResources != null)
             try { packResources.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }
          return var9;
       } catch (Exception var14) {
         Identifier var9; Minimega.LOGGER.warn("Failed to load icon from pack {}", pack.getId(), var9);
         return DEFAULT_ICON;
       } 
     }
     
     static Identifier getPackIcon(Pack pack) {
       return packIcons.computeIfAbsent(pack.getId(), string -> loadPackIcon(getTheClient().getTextureManager(), pack));
     }
     
     static Identifier getInternalPackIcon(String id) {
       return packIcons.computeIfAbsent(id, string -> getInternalIcon(getTheClient().getTextureManager(), id));
     }
     
     static Minecraft getTheClient() {
       return Minecraft.getInstance();
     }
     
     public static final Map<String, Identifier> internalPackIcons = Maps.newHashMap();
     
     private static Identifier getInternalIcon(TextureManager textureManager, String id) {
       if (id.contains("..")) throw new RuntimeException("no"); 
       if (id.startsWith("/")) throw new RuntimeException("no"); 
       try {
         Identifier var9;
         InputStream stream = MapSelectionList.class.getResourceAsStream("/" + id + "pack.png"); 
         try { IoSupplier<InputStream> ioSupplier = () -> stream;
           if (ioSupplier == null)
           { Identifier identifier = DEFAULT_ICON;
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
             
             if (stream != null) stream.close();  return identifier; }  String string = id; Identifier resourceLocation = Identifier.withDefaultNamespace("pack/" + Util.sanitizeName(string, Identifier::validPathChar) + "/" + String.valueOf(Hashing.sha1().hashUnencodedChars(string)) + "/icon"); InputStream inputStream = (InputStream)ioSupplier.get(); try { NativeImage nativeImage = NativeImage.read(inputStream); Objects.requireNonNull(resourceLocation); textureManager.register(resourceLocation, (AbstractTexture)new DynamicTexture(resourceLocation::toString, nativeImage)); var9 = resourceLocation; } catch (Throwable var12) { if (inputStream != null) try { inputStream.close(); } catch (Throwable var11) { var12.addSuppressed(var11); }   throw var12; }  if (inputStream != null) inputStream.close();  if (stream != null) stream.close();  } catch (Throwable throwable) { if (stream != null)
             try { stream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }
          return var9;
       } catch (Exception var14) {
         Identifier var9; Minimega.LOGGER.warn("Failed to load internal icon {}", id, var9);
         return DEFAULT_ICON;
       } 
     }
     
     static Identifier resourcePack(String resourcepack) {
       return "vanilla".equals(resourcepack) ? getPackIcon(getTheClient().getResourcePackRepository().getPack(resourcepack)) : getInternalPackIcon(resourcepack);
     }
   }
}
