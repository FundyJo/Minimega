/*    */ package dev.jab125.minimega.mod.mext;
/*    */ 
/*    */ import java.util.Set;
/*    */ import javax.annotation.processing.AbstractProcessor;
/*    */ import javax.annotation.processing.ProcessingEnvironment;
/*    */ import javax.annotation.processing.RoundEnvironment;
/*    */ import javax.annotation.processing.SupportedAnnotationTypes;
/*    */ import javax.lang.model.element.TypeElement;
/*    */ 
/*    */ @SupportedAnnotationTypes({})
/*    */ public class MinimegaAnnotationProcessor
/*    */   extends AbstractProcessor {
/*    */   public synchronized void init(ProcessingEnvironment processingEnv) {
/* 14 */     super.init(processingEnv);
/* 15 */     MixinExtensionBootstrap.init();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
/* 20 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\mext\MinimegaAnnotationProcessor.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */