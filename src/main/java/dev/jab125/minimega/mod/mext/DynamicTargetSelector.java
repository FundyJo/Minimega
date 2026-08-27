/*     */ package dev.jab125.minimega.mod.mext;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import org.objectweb.asm.tree.AbstractInsnNode;
/*     */ import org.objectweb.asm.tree.AnnotationNode;
/*     */ import org.objectweb.asm.tree.MethodInsnNode;
/*     */ import org.objectweb.asm.tree.MethodNode;
/*     */ import org.spongepowered.asm.mixin.injection.selectors.ElementNode;
/*     */ import org.spongepowered.asm.mixin.injection.selectors.ISelectorContext;
/*     */ import org.spongepowered.asm.mixin.injection.selectors.ITargetSelector;
/*     */ import org.spongepowered.asm.mixin.injection.selectors.ITargetSelectorDynamic;
/*     */ import org.spongepowered.asm.mixin.injection.selectors.ITargetSelectorDynamic.SelectorId;
/*     */ import org.spongepowered.asm.mixin.injection.selectors.InvalidSelectorException;
/*     */ import org.spongepowered.asm.mixin.injection.selectors.MatchResult;
/*     */ import org.spongepowered.asm.mixin.transformer.meta.MixinMerged;
/*     */ import org.spongepowered.asm.util.Annotations;
/*     */ 
/*     */ @SelectorId("InvInit")
/*     */ public class DynamicTargetSelector implements ITargetSelectorDynamic {
/*     */   public ITargetSelector next() {
/*  22 */     return null;
/*     */   }
/*     */   private static final boolean disabled = false;
/*     */   
/*     */   public ITargetSelector configure(ITargetSelector.Configure request, String... args) {
/*  27 */     return (ITargetSelector)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ITargetSelector validate() throws InvalidSelectorException {
/*  32 */     return (ITargetSelector)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ITargetSelector attach(ISelectorContext context) throws InvalidSelectorException {
/*  37 */     return (ITargetSelector)this;
/*     */   }
/*     */   
/*     */   public static DynamicTargetSelector parse(String input, ISelectorContext context) {
/*  41 */     return new DynamicTargetSelector();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMinMatchCount() {
/*  46 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxMatchCount() {
/*  51 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <TNode> MatchResult match(ElementNode<TNode> node) {
/*  59 */     MethodNode method = node.getMethod();
/*  60 */     AnnotationNode visible = Annotations.getVisible(method, MixinMerged.class);
/*  61 */     if (visible == null) return MatchResult.NONE; 
/*  62 */     if (visible.values == null) return MatchResult.NONE; 
/*  63 */     String mixin = getMixin(visible.values);
/*  64 */     if ("link.e4mc.mixin.ServerConnectionListenerMixin".equals(mixin) && method.name.contains("interceptGroup") && method.desc.startsWith("(Ljava/net/InetAddress;")) return MatchResult.EXACT_MATCH; 
/*  65 */     if ("net.caffeinemc.mods.sodium.mixin.features.textures.animations.tracking.SpriteContentsTickerMixin".equals(mixin) && method.name.contains("preTick")) return MatchResult.EXACT_MATCH; 
/*  66 */     if ("io.github.gaming32.worldhost.mixin.MixinIntegratedServer".equals(mixin) && method.name.contains("shareWorldOnLoad") && "(Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfo;)V".equals(method.desc))
/*  67 */       return MatchResult.EXACT_MATCH; 
/*  68 */     if ("mod.bluestaggo.modernerbeta.mixin.client.MixinClientWorld".equals(mixin) && method.name.contains("init") && method.desc.endsWith("Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfo;)V"))
/*  69 */       return MatchResult.EXACT_MATCH; 
/*  70 */     if (mixin.equals("wily.legacy.mixin.base.client.ClientPacketListenerMixin") && method.name.contains("handleRespawn") && !method.name.contains("handleRespawnMusic"))
/*  71 */       return MatchResult.EXACT_MATCH; 
/*  72 */     if (mixin.equals("wily.legacy.mixin.base.client.AbstractContainerScreenMixin") && method.name.contains("keyPressed"))
/*  73 */       return MatchResult.EXACT_MATCH; 
/*  74 */     if (mixin.equals("wily.legacy.mixin.base.client.DeathScreenMixin") && method.name.contains("init")) return MatchResult.EXACT_MATCH; 
/*  75 */     if (mixin.equals("wily.legacy.mixin.base.client.MinecraftMixin") && method.name.contains("legacy$handleDropKey")) return MatchResult.EXACT_MATCH; 
/*  76 */     if (mixin.equals("wily.legacy.mixin.base.PlayerMixin") && method.name.contains("legacy$stopFallFlyingInWater")) return MatchResult.EXACT_MATCH; 
/*  77 */     if (!"wily.legacy.mixin.base.client.title.TitleScreenMixin".equals(mixin) && !"wily.legacy.mixin.base.client.inventory.InventoryScreenMixin".equals(mixin) && !"wily.legacy.mixin.base.client.container.ContainerScreenMixin".equals(mixin))
/*  78 */       return MatchResult.NONE; 
/*  79 */     if (mixin.equals("wily.legacy.mixin.base.client.title.TitleScreenMixin")) {
/*     */ 
/*     */ 
/*     */       
/*  83 */       ListIterator<AbstractInsnNode> listIterator = (node.getMethod()).instructions.iterator(); while (true) { if (listIterator.hasNext()) { AbstractInsnNode instruction = listIterator.next();
/*  84 */           if (instruction instanceof MethodInsnNode) { MethodInsnNode node1 = (MethodInsnNode)instruction;
/*  85 */             if (node1.name.equals("addRenderable") && node1.owner.equals("wily/legacy/client/screen/RenderableVList"))
/*     */               break;  }
/*     */            continue; }
/*     */         
/*  89 */         return MatchResult.NONE; }
/*     */     
/*     */     } 
/*  92 */     if (method.name.contains("init") || method.name.contains("method_25426") || method.name.contains("rebuildMenuButtons")) {
/*  93 */       return MatchResult.EXACT_MATCH;
/*     */     }
/*  95 */     return MatchResult.NONE;
/*     */   }
/*     */ 
/*     */   
/*     */   private String getMixin(List<Object> val) {
/* 100 */     String name = null;
/* 101 */     Object value = null;
/* 102 */     for (int i = 0; i < val.size(); i++) {
/* 103 */       if (name == null) { name = (String)val.get(i); }
/*     */       else
/* 105 */       { value = val.get(i);
/* 106 */         if (name.equals("mixin")) return (String)value;  }
/*     */     
/*     */     } 
/* 109 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mext\DynamicTargetSelector.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */