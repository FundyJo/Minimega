/*    */ package dev.jab125.minimega.grf.newelements.mxml;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Objects;
/*    */ import java.util.Optional;
/*    */ import java.util.stream.Stream;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public interface HasChildren
/*    */   extends Iterable<IMXml>, IMXml {
/*    */   List<? extends IMXml> childRules();
/*    */   
/*    */   @NotNull
/*    */   default Iterator<IMXml> iterator() {
/* 16 */     return (Iterator)childRules().iterator();
/*    */   }
/*    */   
/*    */   default Stream<? extends IMXml> stream() {
/* 20 */     return childRules().stream();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   default Stream<? extends IMXml> flatten(IMXml root) {
/* 26 */     HasChildren c = (HasChildren)root; return Stream.concat(Stream.of(root), (root instanceof HasChildren) ? ((c.childRules() == null) ? 
/* 27 */         Stream.<IMXml>empty() : 
/* 28 */         c.childRules().stream().flatMap(this::flatten)) : Stream.<IMXml>empty());
/*    */   }
/*    */ 
/*    */   
/*    */   default <T extends IMXml> Stream<T> streamOf(Class<T> clazz) {
/* 33 */     Objects.requireNonNull(clazz); Objects.requireNonNull(clazz); return stream().filter(clazz::isInstance).map(clazz::cast);
/*    */   }
/*    */   
/*    */   default <T extends IMXml> Stream<T> flatStreamOf(Class<T> clazz) {
/* 37 */     Objects.requireNonNull(clazz); Objects.requireNonNull(clazz); return stream().flatMap(this::flatten).filter(clazz::isInstance).map(clazz::cast);
/*    */   }
/*    */   
/*    */   default <T extends IMXml> Optional<T> getFirstOf(Class<T> clazz) {
/* 41 */     return streamOf(clazz).findFirst();
/*    */   }
/*    */   
/*    */   default <T extends IMXml> Optional<T> getFirstOfFlat(Class<T> clazz) {
/* 45 */     return flatStreamOf(clazz).findFirst();
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\HasChildren.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */