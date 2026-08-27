/*     */ package dev.jab125.minimega.mod.client.gui.screen;
/*     */ import dev.jab125.minimega.mod.networking.payload.C2SLinkPayload;
/*     */ import dev.jab125.minimega.mod.networking.payload.S2CLinkPayload;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.function.Supplier;
/*     */ import net.fabricmc.fabric.api.client.networking.v1.ClientConfigurationNetworking;
/*     */ import net.minecraft.ChatFormatting;
/*     */ import net.minecraft.client.gui.GuiGraphicsExtractor;
/*     */ import net.minecraft.client.gui.components.Button;
/*     */ import net.minecraft.client.gui.components.EditBox;
/*     */ import net.minecraft.client.gui.components.events.GuiEventListener;
/*     */ import net.minecraft.client.gui.screens.ConfirmLinkScreen;
/*     */ import net.minecraft.client.gui.screens.Screen;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.network.chat.FormattedText;
/*     */ import net.minecraft.network.chat.MutableComponent;
/*     */ import net.minecraft.network.chat.Style;
/*     */ import net.minecraft.network.chat.TextColor;
/*     */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*     */ import net.minecraft.util.FormattedCharSequence;
/*     */ 
/*     */ public class LinkScreen extends Screen {
/*     */   private final PayloadUtil payload;
/*     */   private final Screen parent;
/*     */   private EditBox code;
/*     */   private Button done;
/*     */   private boolean shouldClose;
/*     */   
/*     */   public LinkScreen(ClientConfigurationNetworking.Context context, S2CLinkPayload payload, Screen parent, Minecraft client) {
/*  33 */     this(new PayloadUtil(payload, context)
/*     */         {
/*     */           public String code() {
/*  36 */             return payload.code();
/*     */           }
/*     */ 
/*     */           
/*     */           public void respond(String newCode) {
/*  41 */             context.responseSender().sendPacket((CustomPacketPayload)new C2SLinkPayload(newCode));
/*     */           }
/*     */ 
/*     */           
/*     */           public void disconnect() {
/*  46 */             context.responseSender().disconnect((Component)Component.translatable("minimega.cancelledLogin"));
/*     */           }
/*     */         }parent);
/*  49 */     this.shouldClose = true;
/*     */   }
/*     */   
/*     */   public LinkScreen(Supplier<String> code, Consumer<String> newCode, Runnable disconnect, Screen parent) {
/*  53 */     this(new PayloadUtil(code, newCode, disconnect)
/*     */         {
/*     */           public String code() {
/*  56 */             return code.get();
/*     */           }
/*     */ 
/*     */           
/*     */           public void respond(String code) {
/*  61 */             newCode.accept(code);
/*     */           }
/*     */ 
/*     */           
/*     */           public void disconnect() {
/*  66 */             disconnect.run();
/*     */           }
/*     */         }parent);
/*     */   }
/*     */   
/*     */   private static interface PayloadUtil {
/*     */     String code();
/*     */     
/*     */     void respond(String param1String);
/*     */     
/*     */     void disconnect();
/*     */   }
/*     */   
/*     */   private LinkScreen(PayloadUtil util, Screen parent) {
/*  80 */     super((Component)Component.empty());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 195 */     this.shouldClose = false; this.payload = util; this.parent = parent;
/*     */   }
/*     */   protected void init() { super.init(); this.code = new EditBox(this.font, this.width / 2 - 100, 66, 200, 20, (Component)Component.translatable("minimega.link.entercode")); this.code.setMaxLength(30); this.code.setResponder(s -> { this.done.setMessage((Component)Component.translatable("minimega.link.submit")); this.done.active = true; }); addWidget((GuiEventListener)this.code); addRenderableWidget((GuiEventListener)Button.builder((Component)Component.translatable("chat.copy"), button -> copyToClipboard()).bounds(this.width / 2 - 100, this.height / 4 + 96 + 18 + -66, 200, 20).build()); addRenderableWidget((GuiEventListener)Button.builder((Component)Component.translatable("minimega.link.joindiscordserver"), button -> joinServer()).bounds(this.width / 2 - 100, this.height / 4 + 96 + 18 + -44, 200, 20).build()); addRenderableWidget((GuiEventListener)Button.builder(CommonComponents.GUI_CANCEL, button -> cancel()).bounds(this.width / 2 - 100, this.height / 4 + 96 + 18 - 20 - 2, 200, 20).build()); this.done = (Button)addRenderableWidget((GuiEventListener)Button.builder((Component)Component.translatable("minimega.link.submit"), button -> submit()).bounds(this.width / 2 - 100, this.height / 4 + 96 + 18, 200, 20).build()); }
/* 198 */   private void copyToClipboard() { this.minecraft.keyboardHandler.setClipboard(this.payload.code()); } private void joinServer() { allowClose(); ConfirmLinkScreen.confirmLinkNow(this, "https://discord.gg/KhvKCKJX9w", true); } private void cancel() { onClose(); this.payload.disconnect(); } public void invalidCode() { this.done.active = false; this.done.setMessage((Component)Component.translatable("minimega.invalidCode")); } public void allowClose() { this.shouldClose = true; }
/*     */   private void submit() { this.payload.respond(this.code.getValue()); }
/*     */   public void extractRenderState(GuiGraphicsExtractor guiGraphics, int i, int j, float f) { super.extractRenderState(guiGraphics, i, j, f); MutableComponent s = Component.translatable("minimega.linkScreenSequence.0", new Object[] { Component.translatable("minimega.linkScreenSequence.1").withStyle(ChatFormatting.AQUA), Component.translatable("minimega.linkScreenSequence.2", new Object[] { this.payload.code() }).withStyle(ChatFormatting.GOLD), Component.translatable("minimega.linkScreenSequence.3").withColor(-65794).withStyle(a -> a.withShadowColor(16711422)) }); List<FormattedCharSequence> formattedText = this.font.split((FormattedText)s, (int)(this.width / 1.5D)); Objects.requireNonNull(this.font); int offset = 61 - 9 * formattedText.size(); for (Iterator<FormattedCharSequence> iterator = formattedText.iterator(); iterator.hasNext(); ) { FormattedCharSequence component = iterator.next(); int x = this.width / 2 - this.font.width(component) / 2; int finalOffset = offset; int[] q = new int[1]; component.accept((i1, style, j1) -> { if (style != null && style.getColor() != null && style.getColor().equals(TextColor.fromRgb(-65794))) { int width1 = this.font.width(FormattedText.of(Character.toString(j1), style)); Objects.requireNonNull(this.font); guiGraphics.fill(q[0] + x - 1, finalOffset - 1, q[0] + x + width1 + 1, finalOffset + 9, -10983950); }  q[0] = q[0] + this.font.width(FormattedText.of(Character.toString(j1), style)); return true; }); guiGraphics.centeredText(this.font, component, this.width / 2, offset, -1); Objects.requireNonNull(this.font); offset += 9; }  this.code.extractRenderState(guiGraphics, i, j, f); }
/*     */   public boolean shouldCloseOnEsc() { return false; }
/* 202 */   protected boolean shouldNarrateNavigation() { return false; } public void removed() { super.removed(); if (!shouldClose()) throw new IllegalArgumentException("what?!?!");  } public void onClose() { assert this.minecraft != null; Screen parent = this.parent; if (!shouldClose()) { System.out.println("Suppressed screen closure!"); return; }  System.out.println(parent); if (ModLoader.isLegacy4jInstalled()) parent = null;  this.minecraft.setScreen(parent); } private boolean shouldClose() { return this.shouldClose; }
/*     */ 
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\gui\screen\LinkScreen.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */