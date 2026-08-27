/*     */ package dev.jab125.minimega.grf;
/*     */ 
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonPrimitive;
/*     */ import dev.jab125.minimega.call.Result;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.StringWriter;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.nio.file.Path;
/*     */ import java.util.Map;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import javax.xml.stream.XMLOutputFactory;
/*     */ import javax.xml.stream.XMLStreamException;
/*     */ import javax.xml.stream.XMLStreamWriter;
/*     */ import javax.xml.transform.Transformer;
/*     */ import javax.xml.transform.TransformerException;
/*     */ import javax.xml.transform.TransformerFactory;
/*     */ import javax.xml.transform.dom.DOMSource;
/*     */ import javax.xml.transform.stream.StreamResult;
/*     */ import javax.xml.xpath.XPath;
/*     */ import javax.xml.xpath.XPathConstants;
/*     */ import javax.xml.xpath.XPathExpressionException;
/*     */ import javax.xml.xpath.XPathFactory;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.xml.sax.InputSource;
/*     */ import org.xml.sax.SAXException;
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
/*     */ public class Json2XmlConverter
/*     */ {
/*     */   public static void main(String[] args) throws XMLStreamException, IOException, ParserConfigurationException, SAXException {
/*  47 */     toXML("battle");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void readOut(String minigame) throws XMLStreamException, IOException, ParserConfigurationException, SAXException {
/*  52 */     Path path = Path.of("src/main/resources/data/minimega/minimega_minigames/%s/gamerules".formatted(new Object[] { minigame }, ), new String[0]);
/*  53 */     for (File file : path.toFile().listFiles()) {
/*  54 */       Path path1 = file.toPath();
/*  55 */       System.out.println(path1);
/*  56 */       if (!path1.toString().endsWith(".xml")) {
/*  57 */         System.out.println(String.valueOf(path1) + " does not end with .xml");
/*     */       }
/*     */     } 
/*     */   }
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
/*     */   public static Result<Result.Unit, ? extends Exception> toXML(String minigame) {
/*     */     // Byte code:
/*     */     //   0: ldc 'src/main/resources/data/minimega/minimega_minigames/%s/gamerules'
/*     */     //   2: iconst_1
/*     */     //   3: anewarray java/lang/Object
/*     */     //   6: dup
/*     */     //   7: iconst_0
/*     */     //   8: aload_0
/*     */     //   9: aastore
/*     */     //   10: invokevirtual formatted : ([Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   13: iconst_0
/*     */     //   14: anewarray java/lang/String
/*     */     //   17: invokestatic of : (Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;
/*     */     //   20: astore_1
/*     */     //   21: aload_1
/*     */     //   22: invokeinterface toFile : ()Ljava/io/File;
/*     */     //   27: invokevirtual listFiles : ()[Ljava/io/File;
/*     */     //   30: astore_2
/*     */     //   31: aload_2
/*     */     //   32: arraylength
/*     */     //   33: istore_3
/*     */     //   34: iconst_0
/*     */     //   35: istore #4
/*     */     //   37: iload #4
/*     */     //   39: iload_3
/*     */     //   40: if_icmpge -> 714
/*     */     //   43: aload_2
/*     */     //   44: iload #4
/*     */     //   46: aaload
/*     */     //   47: astore #5
/*     */     //   49: aload #5
/*     */     //   51: invokevirtual toPath : ()Ljava/nio/file/Path;
/*     */     //   54: astore #6
/*     */     //   56: getstatic java/lang/System.out : Ljava/io/PrintStream;
/*     */     //   59: aload #6
/*     */     //   61: invokevirtual println : (Ljava/lang/Object;)V
/*     */     //   64: aload #6
/*     */     //   66: invokeinterface toString : ()Ljava/lang/String;
/*     */     //   71: ldc '.json'
/*     */     //   73: invokevirtual endsWith : (Ljava/lang/String;)Z
/*     */     //   76: ifne -> 98
/*     */     //   79: getstatic java/lang/System.out : Ljava/io/PrintStream;
/*     */     //   82: aload #6
/*     */     //   84: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   87: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   92: invokevirtual println : (Ljava/lang/String;)V
/*     */     //   95: goto -> 708
/*     */     //   98: invokestatic newInstance : ()Ljavax/xml/stream/XMLOutputFactory;
/*     */     //   101: astore #7
/*     */     //   103: new java/io/ByteArrayOutputStream
/*     */     //   106: dup
/*     */     //   107: invokespecial <init> : ()V
/*     */     //   110: astore #8
/*     */     //   112: aload #7
/*     */     //   114: aload #8
/*     */     //   116: <illegal opcode> get : (Ljavax/xml/stream/XMLOutputFactory;Ljava/io/ByteArrayOutputStream;)Ldev/jab125/minimega/call/ThrowableSupplier;
/*     */     //   121: iconst_0
/*     */     //   122: anewarray javax/xml/stream/XMLStreamException
/*     */     //   125: invokestatic wrapGet : (Ldev/jab125/minimega/call/ThrowableSupplier;[Ljava/lang/Throwable;)Ldev/jab125/minimega/call/Result;
/*     */     //   128: dup
/*     */     //   129: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   132: pop
/*     */     //   133: astore #10
/*     */     //   135: iconst_0
/*     */     //   136: istore #11
/*     */     //   138: aload #10
/*     */     //   140: iload #11
/*     */     //   142: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/call/Result;I)I
/*     */     //   147: lookupswitch default -> 172, 0 -> 182, 1 -> 210
/*     */     //   172: new java/lang/MatchException
/*     */     //   175: dup
/*     */     //   176: aconst_null
/*     */     //   177: aconst_null
/*     */     //   178: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   181: athrow
/*     */     //   182: aload #10
/*     */     //   184: checkcast dev/jab125/minimega/call/Ok
/*     */     //   187: astore #12
/*     */     //   189: aload #12
/*     */     //   191: invokevirtual val : ()Ljava/lang/Object;
/*     */     //   194: checkcast javax/xml/stream/XMLStreamWriter
/*     */     //   197: astore #14
/*     */     //   199: aload #14
/*     */     //   201: astore #13
/*     */     //   203: aload #13
/*     */     //   205: astore #9
/*     */     //   207: goto -> 241
/*     */     //   210: aload #10
/*     */     //   212: checkcast dev/jab125/minimega/call/Error
/*     */     //   215: astore #14
/*     */     //   217: aload #14
/*     */     //   219: invokevirtual val : ()Ljava/lang/Throwable;
/*     */     //   222: checkcast javax/xml/stream/XMLStreamException
/*     */     //   225: astore #16
/*     */     //   227: aload #16
/*     */     //   229: astore #15
/*     */     //   231: new dev/jab125/minimega/call/Error
/*     */     //   234: dup
/*     */     //   235: aload #15
/*     */     //   237: invokespecial <init> : (Ljava/lang/Throwable;)V
/*     */     //   240: areturn
/*     */     //   241: new com/google/gson/Gson
/*     */     //   244: dup
/*     */     //   245: invokespecial <init> : ()V
/*     */     //   248: aload #6
/*     */     //   250: invokestatic readString : (Ljava/nio/file/Path;)Ljava/lang/String;
/*     */     //   253: ldc com/google/gson/JsonObject
/*     */     //   255: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
/*     */     //   258: checkcast com/google/gson/JsonObject
/*     */     //   261: aload #9
/*     */     //   263: invokestatic toXML : (Lcom/google/gson/JsonObject;Ljavax/xml/stream/XMLStreamWriter;)Ldev/jab125/minimega/call/Result;
/*     */     //   266: dup
/*     */     //   267: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   270: pop
/*     */     //   271: astore #10
/*     */     //   273: iconst_0
/*     */     //   274: istore #11
/*     */     //   276: aload #10
/*     */     //   278: iload #11
/*     */     //   280: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/call/Result;I)I
/*     */     //   285: lookupswitch default -> 312, 0 -> 322, 1 -> 353
/*     */     //   312: new java/lang/MatchException
/*     */     //   315: dup
/*     */     //   316: aconst_null
/*     */     //   317: aconst_null
/*     */     //   318: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   321: athrow
/*     */     //   322: aload #10
/*     */     //   324: checkcast dev/jab125/minimega/call/Error
/*     */     //   327: astore #12
/*     */     //   329: aload #12
/*     */     //   331: invokevirtual val : ()Ljava/lang/Throwable;
/*     */     //   334: checkcast javax/xml/stream/XMLStreamException
/*     */     //   337: astore #14
/*     */     //   339: aload #14
/*     */     //   341: astore #13
/*     */     //   343: new dev/jab125/minimega/call/Error
/*     */     //   346: dup
/*     */     //   347: aload #13
/*     */     //   349: invokespecial <init> : (Ljava/lang/Throwable;)V
/*     */     //   352: areturn
/*     */     //   353: aload #10
/*     */     //   355: checkcast dev/jab125/minimega/call/Ok
/*     */     //   358: astore #14
/*     */     //   360: aload #14
/*     */     //   362: invokevirtual val : ()Ljava/lang/Object;
/*     */     //   365: checkcast dev/jab125/minimega/call/Result$Unit
/*     */     //   368: astore #15
/*     */     //   370: goto -> 390
/*     */     //   373: astore #10
/*     */     //   375: new java/lang/MatchException
/*     */     //   378: dup
/*     */     //   379: aload #10
/*     */     //   381: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   384: aload #10
/*     */     //   386: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   389: athrow
/*     */     //   390: goto -> 405
/*     */     //   393: astore #10
/*     */     //   395: new dev/jab125/minimega/call/Error
/*     */     //   398: dup
/*     */     //   399: aload #10
/*     */     //   401: invokespecial <init> : (Ljava/lang/Throwable;)V
/*     */     //   404: areturn
/*     */     //   405: aload #9
/*     */     //   407: dup
/*     */     //   408: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   411: pop
/*     */     //   412: <illegal opcode> run : (Ljavax/xml/stream/XMLStreamWriter;)Ldev/jab125/minimega/call/ThrowableRunnable;
/*     */     //   417: iconst_0
/*     */     //   418: anewarray javax/xml/stream/XMLStreamException
/*     */     //   421: invokestatic wrapRun : (Ldev/jab125/minimega/call/ThrowableRunnable;[Ljava/lang/Throwable;)Ldev/jab125/minimega/call/Result;
/*     */     //   424: dup
/*     */     //   425: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   428: pop
/*     */     //   429: astore #10
/*     */     //   431: iconst_0
/*     */     //   432: istore #11
/*     */     //   434: aload #10
/*     */     //   436: iload #11
/*     */     //   438: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/call/Result;I)I
/*     */     //   443: lookupswitch default -> 468, 0 -> 478, 1 -> 498
/*     */     //   468: new java/lang/MatchException
/*     */     //   471: dup
/*     */     //   472: aconst_null
/*     */     //   473: aconst_null
/*     */     //   474: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   477: athrow
/*     */     //   478: aload #10
/*     */     //   480: checkcast dev/jab125/minimega/call/Ok
/*     */     //   483: astore #12
/*     */     //   485: aload #12
/*     */     //   487: invokevirtual val : ()Ljava/lang/Object;
/*     */     //   490: checkcast dev/jab125/minimega/call/Result$Unit
/*     */     //   493: astore #13
/*     */     //   495: goto -> 529
/*     */     //   498: aload #10
/*     */     //   500: checkcast dev/jab125/minimega/call/Error
/*     */     //   503: astore #13
/*     */     //   505: aload #13
/*     */     //   507: invokevirtual val : ()Ljava/lang/Throwable;
/*     */     //   510: checkcast javax/xml/stream/XMLStreamException
/*     */     //   513: astore #15
/*     */     //   515: aload #15
/*     */     //   517: astore #14
/*     */     //   519: new dev/jab125/minimega/call/Error
/*     */     //   522: dup
/*     */     //   523: aload #14
/*     */     //   525: invokespecial <init> : (Ljava/lang/Throwable;)V
/*     */     //   528: areturn
/*     */     //   529: aload #8
/*     */     //   531: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   534: iconst_2
/*     */     //   535: invokestatic toPrettyString : (Ljava/lang/String;I)Ldev/jab125/minimega/call/Result;
/*     */     //   538: dup
/*     */     //   539: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   542: pop
/*     */     //   543: astore #11
/*     */     //   545: iconst_0
/*     */     //   546: istore #12
/*     */     //   548: aload #11
/*     */     //   550: iload #12
/*     */     //   552: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/call/Result;I)I
/*     */     //   557: lookupswitch default -> 584, 0 -> 594, 1 -> 622
/*     */     //   584: new java/lang/MatchException
/*     */     //   587: dup
/*     */     //   588: aconst_null
/*     */     //   589: aconst_null
/*     */     //   590: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   593: athrow
/*     */     //   594: aload #11
/*     */     //   596: checkcast dev/jab125/minimega/call/Ok
/*     */     //   599: astore #13
/*     */     //   601: aload #13
/*     */     //   603: invokevirtual val : ()Ljava/lang/Object;
/*     */     //   606: checkcast java/lang/String
/*     */     //   609: astore #15
/*     */     //   611: aload #15
/*     */     //   613: astore #14
/*     */     //   615: aload #14
/*     */     //   617: astore #10
/*     */     //   619: goto -> 653
/*     */     //   622: aload #11
/*     */     //   624: checkcast dev/jab125/minimega/call/Error
/*     */     //   627: astore #15
/*     */     //   629: aload #15
/*     */     //   631: invokevirtual val : ()Ljava/lang/Throwable;
/*     */     //   634: checkcast java/lang/Exception
/*     */     //   637: astore #17
/*     */     //   639: aload #17
/*     */     //   641: astore #16
/*     */     //   643: new dev/jab125/minimega/call/Error
/*     */     //   646: dup
/*     */     //   647: aload #16
/*     */     //   649: invokespecial <init> : (Ljava/lang/Throwable;)V
/*     */     //   652: areturn
/*     */     //   653: aload #6
/*     */     //   655: aload #6
/*     */     //   657: invokeinterface getFileName : ()Ljava/nio/file/Path;
/*     */     //   662: invokeinterface toString : ()Ljava/lang/String;
/*     */     //   667: ldc '.json'
/*     */     //   669: ldc '.xml'
/*     */     //   671: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
/*     */     //   674: invokeinterface resolveSibling : (Ljava/lang/String;)Ljava/nio/file/Path;
/*     */     //   679: astore #11
/*     */     //   681: aload #11
/*     */     //   683: aload #10
/*     */     //   685: iconst_0
/*     */     //   686: anewarray java/nio/file/OpenOption
/*     */     //   689: invokestatic writeString : (Ljava/nio/file/Path;Ljava/lang/CharSequence;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;
/*     */     //   692: pop
/*     */     //   693: goto -> 708
/*     */     //   696: astore #12
/*     */     //   698: new dev/jab125/minimega/call/Error
/*     */     //   701: dup
/*     */     //   702: aload #12
/*     */     //   704: invokespecial <init> : (Ljava/lang/Throwable;)V
/*     */     //   707: areturn
/*     */     //   708: iinc #4, 1
/*     */     //   711: goto -> 37
/*     */     //   714: invokestatic ok : ()Ldev/jab125/minimega/call/Ok;
/*     */     //   717: areturn
/*     */     //   718: astore_2
/*     */     //   719: new java/lang/MatchException
/*     */     //   722: dup
/*     */     //   723: aload_2
/*     */     //   724: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   727: aload_2
/*     */     //   728: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   731: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #69	-> 0
/*     */     //   #70	-> 21
/*     */     //   #71	-> 49
/*     */     //   #72	-> 56
/*     */     //   #73	-> 64
/*     */     //   #74	-> 79
/*     */     //   #75	-> 95
/*     */     //   #77	-> 98
/*     */     //   #78	-> 103
/*     */     //   #80	-> 112
/*     */     //   #81	-> 182
/*     */     //   #82	-> 210
/*     */     //   #83	-> 231
/*     */     //   #88	-> 241
/*     */     //   #89	-> 322
/*     */     //   #90	-> 343
/*     */     //   #92	-> 353
/*     */     //   #96	-> 390
/*     */     //   #94	-> 393
/*     */     //   #95	-> 395
/*     */     //   #97	-> 405
/*     */     //   #98	-> 478
/*     */     //   #99	-> 498
/*     */     //   #100	-> 519
/*     */     //   #103	-> 529
/*     */     //   #104	-> 594
/*     */     //   #105	-> 622
/*     */     //   #106	-> 643
/*     */     //   #109	-> 653
/*     */     //   #113	-> 681
/*     */     //   #116	-> 693
/*     */     //   #114	-> 696
/*     */     //   #115	-> 698
/*     */     //   #70	-> 708
/*     */     //   #118	-> 714
/*     */     //   #105	-> 718
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   207	3	9	xmlStreamWriter	Ljavax/xml/stream/XMLStreamWriter;
/*     */     //   203	7	13	writer	Ljavax/xml/stream/XMLStreamWriter;
/*     */     //   231	10	15	exception	Ljavax/xml/stream/XMLStreamException;
/*     */     //   343	10	13	e	Ljavax/xml/stream/XMLStreamException;
/*     */     //   395	10	10	e	Ljava/io/IOException;
/*     */     //   519	10	14	exception	Ljavax/xml/stream/XMLStreamException;
/*     */     //   619	3	10	output	Ljava/lang/String;
/*     */     //   615	7	14	string	Ljava/lang/String;
/*     */     //   643	10	16	error	Ljava/lang/Exception;
/*     */     //   698	10	12	e	Ljava/io/IOException;
/*     */     //   56	652	6	path1	Ljava/nio/file/Path;
/*     */     //   103	605	7	factory	Ljavax/xml/stream/XMLOutputFactory;
/*     */     //   112	596	8	byteArrayOutputStream	Ljava/io/ByteArrayOutputStream;
/*     */     //   241	467	9	xmlStreamWriter	Ljavax/xml/stream/XMLStreamWriter;
/*     */     //   653	55	10	output	Ljava/lang/String;
/*     */     //   681	27	11	path2	Ljava/nio/file/Path;
/*     */     //   49	659	5	file	Ljava/io/File;
/*     */     //   21	697	1	path	Ljava/nio/file/Path;
/*     */     //   0	732	0	minigame	Ljava/lang/String;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   191	194	718	java/lang/Throwable
/*     */     //   219	222	718	java/lang/Throwable
/*     */     //   241	352	393	java/io/IOException
/*     */     //   331	334	373	java/lang/Throwable
/*     */     //   353	390	393	java/io/IOException
/*     */     //   362	365	373	java/lang/Throwable
/*     */     //   487	490	718	java/lang/Throwable
/*     */     //   507	510	718	java/lang/Throwable
/*     */     //   603	606	718	java/lang/Throwable
/*     */     //   631	634	718	java/lang/Throwable
/*     */     //   681	693	696	java/io/IOException
/*     */   }
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
/*     */   public static Result<Result.Unit, XMLStreamException> toXML(JsonObject object, XMLStreamWriter writer) {
/* 122 */     return Result.wrapRun(() -> { JsonPrimitive name = object.getAsJsonPrimitive("name"); writer.writeStartElement(name.getAsString()); JsonObject parameters = object.getAsJsonObject("parameters"); for (Map.Entry<String, JsonElement> stringJsonElementEntry : (Iterable<Map.Entry<String, JsonElement>>)parameters.entrySet()) writer.writeAttribute(stringJsonElementEntry.getKey(), ((JsonElement)stringJsonElementEntry.getValue()).getAsString());  if (object.has("childRules")) for (JsonElement stringJsonElementEntry : object.getAsJsonArray("childRules")) toXML(stringJsonElementEntry.getAsJsonObject(), writer);   writer.writeEndElement(); }(Throwable[])new XMLStreamException[0]);
/*     */   }
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
/*     */   public static Result<String, ? extends Exception> toPrettyString(String xml, int indent) {
/* 137 */     return Result.wrapGet(() -> toPrettyString0(xml, indent), (Throwable[])new Exception[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String toPrettyString0(String xml, int indent) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException, TransformerException {
/* 144 */     Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8))));
/*     */ 
/*     */     
/* 147 */     document.normalize();
/* 148 */     XPath xPath = XPathFactory.newInstance().newXPath();
/* 149 */     NodeList nodeList = (NodeList)xPath.evaluate("//text()[normalize-space()='']", document, XPathConstants.NODESET);
/*     */ 
/*     */ 
/*     */     
/* 153 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 154 */       Node node = nodeList.item(i);
/* 155 */       node.getParentNode().removeChild(node);
/*     */     } 
/*     */ 
/*     */     
/* 159 */     TransformerFactory transformerFactory = TransformerFactory.newInstance();
/* 160 */     transformerFactory.setAttribute("indent-number", Integer.valueOf(indent));
/* 161 */     Transformer transformer = transformerFactory.newTransformer();
/* 162 */     transformer.setOutputProperty("encoding", "UTF-8");
/* 163 */     transformer.setOutputProperty("omit-xml-declaration", "yes");
/* 164 */     transformer.setOutputProperty("indent", "yes");
/*     */ 
/*     */     
/* 167 */     StringWriter stringWriter = new StringWriter();
/* 168 */     transformer.transform(new DOMSource(document), new StreamResult(stringWriter));
/* 169 */     return stringWriter.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\Json2XmlConverter.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */