/*    */ package dev.jab125.minimega.mod.client.mixin.smallinv;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import com.llamalad7.mixinextras.sugar.Local;
/*    */ import com.llamalad7.mixinextras.sugar.ref.LocalDoubleRef;
/*    */ import dev.jab125.minimega.mod.abstractions.modloader.ModLoader;
/*    */ import dev.jab125.minimega.mod.abstractions.networking.ClientNetworking;
/*    */ import dev.jab125.minimega.mod.client.MinimegaClient;
/*    */ import dev.jab125.minimega.mod.client.SmallInvConstants;
/*    */ import dev.jab125.minimega.mod.networking.payload.C2STakeAllPayload;
/*    */ import net.minecraft.client.gui.components.Button;
/*    */ import net.minecraft.client.gui.components.events.GuiEventListener;
/*    */ import net.minecraft.client.gui.screens.Screen;
/*    */ import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
/*    */ import net.minecraft.client.gui.screens.inventory.ContainerScreen;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ import net.minecraft.world.entity.player.Inventory;
/*    */ import net.minecraft.world.inventory.Slot;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.ModifyVariable;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({AbstractContainerScreen.class})
/*    */ public abstract class AbstractContainerScreenMixin
/*    */   extends Screen
/*    */ {
/*    */   @Shadow
/*    */   protected int topPos;
/*    */   @Shadow
/*    */   protected int leftPos;
/*    */   @Shadow
/*    */   protected int imageWidth;
/*    */   
/*    */   protected AbstractContainerScreenMixin(Component component) {
/* 41 */     super(component);
/*    */   }
/*    */   
/*    */   @Inject(method = {"init"}, at = {@At("RETURN")})
/*    */   void init(CallbackInfo ci) {
/* 46 */     if (MinimegaClient.getController().isSmallInventory() && SmallInvConstants.supportsSmallInventory(this) && !ModLoader.isLegacy4jInstalled()) {
/* 47 */       this.topPos += 29;
/*    */     }
/* 49 */     if (!ModLoader.isLegacy4jInstalled()) { AbstractContainerScreenMixin abstractContainerScreenMixin = this; if (abstractContainerScreenMixin instanceof ContainerScreen) { ContainerScreen screen = (ContainerScreen)abstractContainerScreenMixin; if (MinimegaClient.getController().takeAllEnabled())
/* 50 */           addRenderableWidget((GuiEventListener)Button.builder((Component)Component.translatable("minimega.takeAll"), b -> this.minecraft.getConnection().send(ClientNetworking.getInstance().play((CustomPacketPayload)new C2STakeAllPayload())))
/*    */               
/* 52 */               .size(65, 12).pos(this.leftPos + this.imageWidth - 65 - 4, this.topPos + 4).build());  }
/*    */        }
/*    */   
/*    */   }
/*    */   @Inject(method = {"isHovering(Lnet/minecraft/world/inventory/Slot;DD)Z"}, at = {@At("HEAD")})
/*    */   private void getHoveredSlot(Slot slot, double d, double e, CallbackInfoReturnable<Boolean> cir, @Local(argsOnly = true, ordinal = 1) LocalDoubleRef r) {
/* 58 */     if (MinimegaClient.getController().isSmallInventory() && SmallInvConstants.supportsSmallInventory(this) && 
/* 59 */       slot.container instanceof Inventory && Inventory.isHotbarSlot(slot.getContainerSlot())) {
/* 60 */       r.set(r.get() + 58.0D);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @WrapOperation(method = {"extractSlotHighlightFront", "extractSlotHighlightBack"}, at = {@At(value = "FIELD", target = "Lnet/minecraft/world/inventory/Slot;y:I")})
/*    */   private int renderSlotHighlight(Slot slot, Operation<Integer> original) {
/* 67 */     if (MinimegaClient.getController().isSmallInventory() && SmallInvConstants.supportsSmallInventory(this) && 
/* 68 */       slot.container instanceof Inventory && Inventory.isHotbarSlot(slot.getContainerSlot())) {
/* 69 */       return ((Integer)original.call(new Object[] { slot })).intValue() - 58;
/*    */     }
/*    */     
/* 72 */     return ((Integer)original.call(new Object[] { slot })).intValue();
/*    */   }
/*    */   
/*    */   @ModifyVariable(method = {"extractSlot"}, at = @At(value = "STORE", ordinal = 0), ordinal = 3)
/*    */   private int renderSlot(int value, @Local(argsOnly = true) Slot slot) {
/* 77 */     if (MinimegaClient.getController().isSmallInventory() && SmallInvConstants.supportsSmallInventory(this) && 
/* 78 */       slot.container instanceof Inventory && Inventory.isHotbarSlot(slot.getContainerSlot()))
/* 79 */       return value - 58; 
/* 80 */     return value;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\mixin\smallinv\AbstractContainerScreenMixin.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */