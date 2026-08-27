package dev.jab125.minimega.mod.client.gui.widget;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

interface GuiGraphicsWrapper {
  void fill(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  void blit(RenderPipeline paramRenderPipeline, Identifier paramIdentifier, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  void blitSprite(RenderPipeline paramRenderPipeline, Identifier paramIdentifier, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  void text(Font paramFont, Component paramComponent, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\widget\MinigameSelectionList$Entry$1GuiGraphicsWrapper.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */