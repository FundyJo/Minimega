/*    */ package dev.jab125.minimega.grf.newelements.mxml;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import com.mojang.datafixers.DataFixer;
/*    */ import com.mojang.serialization.Dynamic;
/*    */ import com.mojang.serialization.DynamicOps;
/*    */ import com.mojang.serialization.JavaOps;
/*    */ import com.mojang.serialization.JsonOps;
/*    */ import com.siemens.ct.exi.core.exceptions.EXIException;
/*    */ import dev.jab125.minimega.grf.Json2XmlConverter;
/*    */ import dev.jab125.minimega.grf.Xml2Json2Xml;
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Path;
/*    */ import java.util.HashMap;
/*    */ import javax.xml.stream.XMLOutputFactory;
/*    */ import javax.xml.stream.XMLStreamException;
/*    */ import javax.xml.transform.TransformerException;
/*    */ import net.minecraft.SharedConstants;
/*    */ import net.minecraft.resources.Identifier;
/*    */ import net.minecraft.util.datafix.DataFixers;
/*    */ import net.minecraft.util.datafix.fixes.BlockStateData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BLest
/*    */ {
/*    */   public static class Num2Str
/*    */   {
/* 37 */     private final HashMap<Integer, Identifier> map = new HashMap<>();
/*    */ 
/*    */     
/*    */     public String getStrId(int id) {
/*    */       // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: getfield map : Ljava/util/HashMap;
/*    */       //   4: iload_1
/*    */       //   5: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */       //   8: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
/*    */       //   11: checkcast net/minecraft/resources/Identifier
/*    */       //   14: astore_2
/*    */       //   15: iconst_0
/*    */       //   16: istore_3
/*    */       //   17: aload_2
/*    */       //   18: iload_3
/*    */       //   19: <illegal opcode> typeSwitch : (Lnet/minecraft/resources/Identifier;I)I
/*    */       //   24: lookupswitch default -> 52, -1 -> 73, 0 -> 62
/*    */       //   52: new java/lang/MatchException
/*    */       //   55: dup
/*    */       //   56: aconst_null
/*    */       //   57: aconst_null
/*    */       //   58: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*    */       //   61: athrow
/*    */       //   62: aload_2
/*    */       //   63: astore #4
/*    */       //   65: aload #4
/*    */       //   67: invokevirtual toString : ()Ljava/lang/String;
/*    */       //   70: goto -> 74
/*    */       //   73: aconst_null
/*    */       //   74: areturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #39	-> 0
/*    */       //   #40	-> 62
/*    */       //   #41	-> 73
/*    */       //   #39	-> 74
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   65	8	4	identifier	Lnet/minecraft/resources/Identifier;
/*    */       //   0	75	0	this	Ldev/jab125/minimega/grf/newelements/mxml/BLest$Num2Str;
/*    */       //   0	75	1	id	I
/*    */     }
/*    */   }
/*    */   
/*    */   public static Num2Str createBlockNum2Str() {
/* 46 */     Num2Str num2Str = new Num2Str(); 
/* 47 */     try { InputStream resourceAsStream = Tester.class.getResourceAsStream("/blockidmap.dat"); 
/* 48 */       try { assert resourceAsStream != null;
/* 49 */         byte[] bytes = resourceAsStream.readAllBytes();
/* 50 */         ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
/* 51 */         while (byteArrayInputStream.available() > 0) {
/* 52 */           int numericId = byteArrayInputStream.read();
/* 53 */           byte length = (byte)byteArrayInputStream.read();
/* 54 */           String id = new String(byteArrayInputStream.readNBytes(Byte.toUnsignedInt(length)), StandardCharsets.UTF_8);
/* 55 */           num2Str.map.put(Integer.valueOf(numericId), Identifier.parse(id));
/*    */         } 
/* 57 */         if (resourceAsStream != null) resourceAsStream.close();  } catch (Throwable throwable) { if (resourceAsStream != null) try { resourceAsStream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (IOException e)
/* 58 */     { throw new RuntimeException(e); }
/*    */     
/* 60 */     return num2Str;
/*    */   }
/*    */   public static void main2() {
/* 63 */     SharedConstants.tryDetectVersion();
/* 64 */     Num2Str blockNum2Str = createBlockNum2Str();
/* 65 */     DataFixer dataFixer = DataFixers.getDataFixer();
/* 66 */     Dynamic<Object> objectDynamic = new Dynamic((DynamicOps)JavaOps.INSTANCE);
/* 67 */     objectDynamic = objectDynamic.createInt(15);
/* 68 */     int tag = 574;
/*    */     
/* 70 */     Dynamic<?> tag1 = BlockStateData.getTag(tag);
/*    */     
/* 72 */     System.out.println(tag1);
/*    */   }
/*    */   
/*    */   void main() throws IOException, XMLStreamException, EXIException, TransformerException {
/* 76 */     SharedConstants.tryDetectVersion();
/* 77 */     JsonObject x = Xml2Json2Xml.exiToJson(Tester.class.getResourceAsStream("/data/minimega/minimega_minigames/tumble/gamerules/basic_arena.grf"));
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 82 */     x = ((JsonElement)Tester.<T>fix(new Dynamic((DynamicOps)JsonOps.INSTANCE, x), DataFixers.getDataFixer(), new Tester.Config(false, true, true)).getValue()).getAsJsonObject();
/*    */ 
/*    */     
/* 85 */     ByteArrayOutputStream stream = new ByteArrayOutputStream();
/* 86 */     Xml2Json2Xml.toXML(x, XMLOutputFactory.newInstance().createXMLStreamWriter(stream, StandardCharsets.UTF_8.name()));
/* 87 */     String str = stream.toString(StandardCharsets.UTF_8);
/* 88 */     Files.writeString(Path.of("testexport.xml", new String[0]), (CharSequence)Json2XmlConverter.toPrettyString(str, 2).orElseThrow("?????"), new java.nio.file.OpenOption[0]);
/* 89 */     System.out.println(stream.toString(StandardCharsets.UTF_8));
/*    */   }
/*    */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\BLest.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */