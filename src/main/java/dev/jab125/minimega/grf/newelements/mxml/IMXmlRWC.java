/*    */ package dev.jab125.minimega.grf.newelements.mxml;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.function.UnaryOperator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IMXmlRWC<T extends IMXmlRWC<T>>
/*    */   extends IMXml, HasChildren
/*    */ {
/*    */   default T rewrite(UnaryOperator<IMXml> transformer) {
/* 19 */     List<? extends IMXml> rewritten = childRules().stream().map(child -> { if (child instanceof IMXmlRWC) { IMXmlRWC<?> elementRWC = (IMXmlRWC)child; return (IMXml)elementRWC.rewrite(transformer); }  return child; }).toList();
/*    */     
/* 21 */     T updated = withChildren((List)rewritten);
/*    */     
/* 23 */     return (T)transformer.apply((IMXml)updated);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   default T appendChild(IMXml child) {
/* 29 */     ArrayList<IMXml> list = new ArrayList<>(childRules());
/* 30 */     list.add(child);
/* 31 */     return withChildren(list);
/*    */   }
/*    */   
/*    */   T withChildren(List<IMXml> paramList);
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\IMXmlRWC.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */