/*     */ package dev.jab125.minimega.grf;
/*     */ 
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonPrimitive;
/*     */ import com.siemens.ct.exi.core.EXIFactory;
/*     */ import com.siemens.ct.exi.core.exceptions.EXIException;
/*     */ import com.siemens.ct.exi.core.helpers.DefaultEXIFactory;
/*     */ import com.siemens.ct.exi.main.api.sax.EXISource;
/*     */ import dev.jab125.minimega.call.Result;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Map;
/*     */ import javax.xml.stream.XMLStreamException;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import javax.xml.stream.XMLStreamWriter;
/*     */ import javax.xml.transform.Result;
/*     */ import javax.xml.transform.Source;
/*     */ import javax.xml.transform.Transformer;
/*     */ import javax.xml.transform.TransformerException;
/*     */ import javax.xml.transform.TransformerFactory;
/*     */ import javax.xml.transform.stream.StreamResult;
/*     */ import org.xml.sax.InputSource;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Xml2Json2Xml
/*     */ {
/*     */   private static final String INTERNAL_ID_KEY = "__$INTERNAL_ID$__";
/*     */   private static final String CHILD_RULES_KEY = "childRules";
/*     */   public static final String SPECIAL_TEXT_ELEMENT_NAME = "SPECIAL:TEXT";
/*     */   public static final String TEXT_CONTENT_ATTRIBUTE = "content";
/*     */   
/*     */   public static void toXML(JsonObject object, XMLStreamWriter writer) throws XMLStreamException {
/*  41 */     JsonPrimitive name = object.getAsJsonPrimitive("__$INTERNAL_ID$__");
/*  42 */     writer.writeStartElement(name.getAsString());
/*     */     
/*  44 */     for (Map.Entry<String, JsonElement> entry : (Iterable<Map.Entry<String, JsonElement>>)object.entrySet()) {
/*  45 */       String key = entry.getKey();
/*  46 */       if (key.equals("__$INTERNAL_ID$__") || key.equals("childRules"))
/*  47 */         continue;  JsonElement value = entry.getValue();
/*  48 */       if (value.isJsonPrimitive() && value.getAsJsonPrimitive().isString()) {
/*  49 */         String strValue = value.getAsString();
/*  50 */         if (strValue.isBlank())
/*  51 */           continue;  writer.writeAttribute(key, strValue); continue;
/*     */       } 
/*  53 */       writer.writeAttribute(key, value.getAsString());
/*     */     } 
/*     */     
/*  56 */     if (object.has("childRules")) {
/*  57 */       JsonArray children = object.getAsJsonArray("childRules");
/*  58 */       for (JsonElement child : children) {
/*  59 */         JsonObject childObj = child.getAsJsonObject();
/*  60 */         if (childObj.get("__$INTERNAL_ID$__").getAsString().equals("SPECIAL:TEXT")) {
/*  61 */           String textContent = childObj.get("content").getAsString();
/*  62 */           if (textContent != null && !textContent.isBlank())
/*  63 */             writer.writeCharacters(textContent); 
/*     */           continue;
/*     */         } 
/*  66 */         toXML(childObj, writer);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  71 */     writer.writeEndElement();
/*     */   }
/*     */   
/*     */   public static String stripPrologJunk(String xml) {
/*  75 */     int start = 0;
/*  76 */     while (start < xml.length() && !xml.startsWith("<", start)) {
/*  77 */       start++;
/*     */     }
/*  79 */     return xml.substring(start);
/*     */   }
/*     */   
/*     */   public static Result<JsonObject, XMLStreamException> fromXML(String text) {
/*  83 */     return Result.wrapGet(() -> { // Byte code:
/*     */           //   0: <illegal opcode> get : ()Ldev/jab125/minimega/call/ThrowableSupplier;
/*     */           //   5: iconst_0
/*     */           //   6: anewarray javax/xml/stream/FactoryConfigurationError
/*     */           //   9: invokestatic wrapGet : (Ldev/jab125/minimega/call/ThrowableSupplier;[Ljava/lang/Throwable;)Ldev/jab125/minimega/call/Result;
/*     */           //   12: ldc_w 'Factory configuration error!? That shouldn't happen!'
/*     */           //   15: invokeinterface orElseThrow : (Ljava/lang/String;)Ljava/lang/Object;
/*     */           //   20: checkcast javax/xml/stream/XMLInputFactory
/*     */           //   23: astore_1
/*     */           //   24: new java/io/StringReader
/*     */           //   27: dup
/*     */           //   28: aload_0
/*     */           //   29: invokespecial <init> : (Ljava/lang/String;)V
/*     */           //   32: astore #4
/*     */           //   34: aload_1
/*     */           //   35: aload #4
/*     */           //   37: invokevirtual createXMLStreamReader : (Ljava/io/Reader;)Ljavax/xml/stream/XMLStreamReader;
/*     */           //   40: dup
/*     */           //   41: astore_3
/*     */           //   42: dup
/*     */           //   43: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */           //   46: pop
/*     */           //   47: <illegal opcode> close : (Ljavax/xml/stream/XMLStreamReader;)Ljava/lang/AutoCloseable;
/*     */           //   52: astore #5
/*     */           //   54: aload_3
/*     */           //   55: invokestatic fromXML : (Ljavax/xml/stream/XMLStreamReader;)Ldev/jab125/minimega/call/Result;
/*     */           //   58: dup
/*     */           //   59: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */           //   62: pop
/*     */           //   63: astore #6
/*     */           //   65: iconst_0
/*     */           //   66: istore #7
/*     */           //   68: aload #6
/*     */           //   70: iload #7
/*     */           //   72: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/call/Result;I)I
/*     */           //   77: lookupswitch default -> 104, 0 -> 114, 1 -> 141
/*     */           //   104: new java/lang/MatchException
/*     */           //   107: dup
/*     */           //   108: aconst_null
/*     */           //   109: aconst_null
/*     */           //   110: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */           //   113: athrow
/*     */           //   114: aload #6
/*     */           //   116: checkcast dev/jab125/minimega/call/Ok
/*     */           //   119: astore #8
/*     */           //   121: aload #8
/*     */           //   123: invokevirtual val : ()Ljava/lang/Object;
/*     */           //   126: checkcast com/google/gson/JsonObject
/*     */           //   129: astore #10
/*     */           //   131: aload #10
/*     */           //   133: astore #9
/*     */           //   135: aload #9
/*     */           //   137: astore_2
/*     */           //   138: goto -> 165
/*     */           //   141: aload #6
/*     */           //   143: checkcast dev/jab125/minimega/call/Error
/*     */           //   146: astore #10
/*     */           //   148: aload #10
/*     */           //   150: invokevirtual val : ()Ljava/lang/Throwable;
/*     */           //   153: checkcast javax/xml/stream/XMLStreamException
/*     */           //   156: astore #12
/*     */           //   158: aload #12
/*     */           //   160: astore #11
/*     */           //   162: aload #11
/*     */           //   164: athrow
/*     */           //   165: goto -> 185
/*     */           //   168: astore #6
/*     */           //   170: new java/lang/MatchException
/*     */           //   173: dup
/*     */           //   174: aload #6
/*     */           //   176: invokevirtual toString : ()Ljava/lang/String;
/*     */           //   179: aload #6
/*     */           //   181: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */           //   184: athrow
/*     */           //   185: aload #5
/*     */           //   187: ifnull -> 229
/*     */           //   190: aload #5
/*     */           //   192: invokeinterface close : ()V
/*     */           //   197: goto -> 229
/*     */           //   200: astore #6
/*     */           //   202: aload #5
/*     */           //   204: ifnull -> 226
/*     */           //   207: aload #5
/*     */           //   209: invokeinterface close : ()V
/*     */           //   214: goto -> 226
/*     */           //   217: astore #7
/*     */           //   219: aload #6
/*     */           //   221: aload #7
/*     */           //   223: invokevirtual addSuppressed : (Ljava/lang/Throwable;)V
/*     */           //   226: aload #6
/*     */           //   228: athrow
/*     */           //   229: aload #4
/*     */           //   231: invokevirtual close : ()V
/*     */           //   234: goto -> 259
/*     */           //   237: astore #5
/*     */           //   239: aload #4
/*     */           //   241: invokevirtual close : ()V
/*     */           //   244: goto -> 256
/*     */           //   247: astore #6
/*     */           //   249: aload #5
/*     */           //   251: aload #6
/*     */           //   253: invokevirtual addSuppressed : (Ljava/lang/Throwable;)V
/*     */           //   256: aload #5
/*     */           //   258: athrow
/*     */           //   259: aload_2
/*     */           //   260: areturn
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #84	-> 0
/*     */           //   #87	-> 24
/*     */           //   #88	-> 54
/*     */           //   #89	-> 114
/*     */           //   #90	-> 141
/*     */           //   #92	-> 185
/*     */           //   #87	-> 200
/*     */           //   #92	-> 229
/*     */           //   #87	-> 237
/*     */           //   #93	-> 259
/*     */           // Local variable table:
/*     */           //   start	length	slot	name	descriptor
/*     */           //   131	4	10	patt4$temp	Lcom/google/gson/JsonObject;
/*     */           //   138	3	2	x	Lcom/google/gson/JsonObject;
/*     */           //   121	20	8	$b$0	Ldev/jab125/minimega/call/Ok;
/*     */           //   135	6	9	object	Lcom/google/gson/JsonObject;
/*     */           //   158	4	12	patt5$temp	Ljavax/xml/stream/XMLStreamException;
/*     */           //   148	17	10	$b$1	Ldev/jab125/minimega/call/Error;
/*     */           //   162	3	11	e	Ljavax/xml/stream/XMLStreamException;
/*     */           //   65	100	6	selector2$temp	Ldev/jab125/minimega/call/Result;
/*     */           //   68	97	7	index$3	I
/*     */           //   165	3	2	x	Lcom/google/gson/JsonObject;
/*     */           //   185	15	2	x	Lcom/google/gson/JsonObject;
/*     */           //   219	7	7	x2	Ljava/lang/Throwable;
/*     */           //   202	27	6	t$	Ljava/lang/Throwable;
/*     */           //   229	8	2	x	Lcom/google/gson/JsonObject;
/*     */           //   42	195	3	streamReader	Ljavax/xml/stream/XMLStreamReader;
/*     */           //   249	7	6	x2	Ljava/lang/Throwable;
/*     */           //   239	20	5	t$	Ljava/lang/Throwable;
/*     */           //   34	225	4	stringReader	Ljava/io/StringReader;
/*     */           //   0	261	0	text	Ljava/lang/String;
/*     */           //   24	237	1	factory	Ljavax/xml/stream/XMLInputFactory;
/*     */           //   259	2	2	x	Lcom/google/gson/JsonObject;
/*     */           //   259	2	3	streamReader	Ljavax/xml/stream/XMLStreamReader;
/*     */           // Exception table:
/*     */           //   from	to	target	type
/*     */           //   34	229	237	java/lang/Throwable
/*     */           //   54	185	200	java/lang/Throwable
/*     */           //   123	126	168	java/lang/Throwable
/*     */           //   150	153	168	java/lang/Throwable
/*     */           //   207	214	217	java/lang/Throwable
/*  83 */           //   239	244	247	java/lang/Throwable }(Throwable[])new XMLStreamException[0]);
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
/*     */   public static Result<JsonObject, XMLStreamException> fromXML(XMLStreamReader reader) {
/*  98 */     return Result.wrapGet(() -> { // Byte code:
/*     */           //   0: aload_0
/*     */           //   1: invokeinterface hasNext : ()Z
/*     */           //   6: ifeq -> 54
/*     */           //   9: aload_0
/*     */           //   10: invokeinterface getEventType : ()I
/*     */           //   15: iconst_1
/*     */           //   16: if_icmpeq -> 54
/*     */           //   19: aload_0
/*     */           //   20: invokeinterface next : ()I
/*     */           //   25: istore_1
/*     */           //   26: iload_1
/*     */           //   27: bipush #7
/*     */           //   29: if_icmpne -> 35
/*     */           //   32: goto -> 0
/*     */           //   35: iload_1
/*     */           //   36: bipush #8
/*     */           //   38: if_icmpne -> 51
/*     */           //   41: new javax/xml/stream/XMLStreamException
/*     */           //   44: dup
/*     */           //   45: ldc 'No root element found'
/*     */           //   47: invokespecial <init> : (Ljava/lang/String;)V
/*     */           //   50: athrow
/*     */           //   51: goto -> 0
/*     */           //   54: new com/google/gson/JsonObject
/*     */           //   57: dup
/*     */           //   58: invokespecial <init> : ()V
/*     */           //   61: astore_1
/*     */           //   62: aload_1
/*     */           //   63: ldc '__$INTERNAL_ID$__'
/*     */           //   65: aload_0
/*     */           //   66: invokeinterface getLocalName : ()Ljava/lang/String;
/*     */           //   71: invokevirtual addProperty : (Ljava/lang/String;Ljava/lang/String;)V
/*     */           //   74: iconst_0
/*     */           //   75: istore_2
/*     */           //   76: iload_2
/*     */           //   77: aload_0
/*     */           //   78: invokeinterface getAttributeCount : ()I
/*     */           //   83: if_icmpge -> 110
/*     */           //   86: aload_1
/*     */           //   87: aload_0
/*     */           //   88: iload_2
/*     */           //   89: invokeinterface getAttributeLocalName : (I)Ljava/lang/String;
/*     */           //   94: aload_0
/*     */           //   95: iload_2
/*     */           //   96: invokeinterface getAttributeValue : (I)Ljava/lang/String;
/*     */           //   101: invokevirtual addProperty : (Ljava/lang/String;Ljava/lang/String;)V
/*     */           //   104: iinc #2, 1
/*     */           //   107: goto -> 76
/*     */           //   110: new com/google/gson/JsonArray
/*     */           //   113: dup
/*     */           //   114: invokespecial <init> : ()V
/*     */           //   117: astore_2
/*     */           //   118: new java/lang/StringBuilder
/*     */           //   121: dup
/*     */           //   122: invokespecial <init> : ()V
/*     */           //   125: astore_3
/*     */           //   126: iconst_0
/*     */           //   127: istore #4
/*     */           //   129: aload_0
/*     */           //   130: invokeinterface hasNext : ()Z
/*     */           //   135: ifeq -> 326
/*     */           //   138: aload_0
/*     */           //   139: invokeinterface next : ()I
/*     */           //   144: istore #5
/*     */           //   146: iload #5
/*     */           //   148: iconst_1
/*     */           //   149: if_icmpne -> 270
/*     */           //   152: aload_0
/*     */           //   153: invokestatic fromXML : (Ljavax/xml/stream/XMLStreamReader;)Ldev/jab125/minimega/call/Result;
/*     */           //   156: dup
/*     */           //   157: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */           //   160: pop
/*     */           //   161: astore #6
/*     */           //   163: iconst_0
/*     */           //   164: istore #7
/*     */           //   166: aload #6
/*     */           //   168: iload #7
/*     */           //   170: <illegal opcode> typeSwitch : (Ldev/jab125/minimega/call/Result;I)I
/*     */           //   175: lookupswitch default -> 200, 0 -> 210, 1 -> 240
/*     */           //   200: new java/lang/MatchException
/*     */           //   203: dup
/*     */           //   204: aconst_null
/*     */           //   205: aconst_null
/*     */           //   206: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */           //   209: athrow
/*     */           //   210: aload #6
/*     */           //   212: checkcast dev/jab125/minimega/call/Ok
/*     */           //   215: astore #8
/*     */           //   217: aload #8
/*     */           //   219: invokevirtual val : ()Ljava/lang/Object;
/*     */           //   222: checkcast com/google/gson/JsonObject
/*     */           //   225: astore #10
/*     */           //   227: aload #10
/*     */           //   229: astore #9
/*     */           //   231: aload_2
/*     */           //   232: aload #9
/*     */           //   234: invokevirtual add : (Lcom/google/gson/JsonElement;)V
/*     */           //   237: goto -> 264
/*     */           //   240: aload #6
/*     */           //   242: checkcast dev/jab125/minimega/call/Error
/*     */           //   245: astore #10
/*     */           //   247: aload #10
/*     */           //   249: invokevirtual val : ()Ljava/lang/Throwable;
/*     */           //   252: checkcast javax/xml/stream/XMLStreamException
/*     */           //   255: astore #12
/*     */           //   257: aload #12
/*     */           //   259: astore #11
/*     */           //   261: aload #11
/*     */           //   263: athrow
/*     */           //   264: iconst_1
/*     */           //   265: istore #4
/*     */           //   267: goto -> 323
/*     */           //   270: iload #5
/*     */           //   272: iconst_4
/*     */           //   273: if_icmpeq -> 283
/*     */           //   276: iload #5
/*     */           //   278: bipush #12
/*     */           //   280: if_icmpne -> 314
/*     */           //   283: aload_0
/*     */           //   284: invokeinterface getText : ()Ljava/lang/String;
/*     */           //   289: astore #6
/*     */           //   291: aload #6
/*     */           //   293: ifnull -> 311
/*     */           //   296: aload #6
/*     */           //   298: invokevirtual isBlank : ()Z
/*     */           //   301: ifne -> 311
/*     */           //   304: aload_3
/*     */           //   305: aload #6
/*     */           //   307: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */           //   310: pop
/*     */           //   311: goto -> 323
/*     */           //   314: iload #5
/*     */           //   316: iconst_2
/*     */           //   317: if_icmpne -> 323
/*     */           //   320: goto -> 326
/*     */           //   323: goto -> 129
/*     */           //   326: aload_3
/*     */           //   327: invokevirtual length : ()I
/*     */           //   330: ifgt -> 343
/*     */           //   333: aload_1
/*     */           //   334: ldc 'childRules'
/*     */           //   336: aload_2
/*     */           //   337: invokevirtual add : (Ljava/lang/String;Lcom/google/gson/JsonElement;)V
/*     */           //   340: goto -> 406
/*     */           //   343: aload_3
/*     */           //   344: invokevirtual length : ()I
/*     */           //   347: ifle -> 406
/*     */           //   350: new com/google/gson/JsonObject
/*     */           //   353: dup
/*     */           //   354: invokespecial <init> : ()V
/*     */           //   357: astore #5
/*     */           //   359: aload #5
/*     */           //   361: ldc '__$INTERNAL_ID$__'
/*     */           //   363: ldc 'SPECIAL:TEXT'
/*     */           //   365: invokevirtual addProperty : (Ljava/lang/String;Ljava/lang/String;)V
/*     */           //   368: aload #5
/*     */           //   370: ldc 'content'
/*     */           //   372: aload_3
/*     */           //   373: invokevirtual toString : ()Ljava/lang/String;
/*     */           //   376: invokevirtual trim : ()Ljava/lang/String;
/*     */           //   379: invokevirtual addProperty : (Ljava/lang/String;Ljava/lang/String;)V
/*     */           //   382: new com/google/gson/JsonArray
/*     */           //   385: dup
/*     */           //   386: invokespecial <init> : ()V
/*     */           //   389: astore #6
/*     */           //   391: aload #6
/*     */           //   393: aload #5
/*     */           //   395: invokevirtual add : (Lcom/google/gson/JsonElement;)V
/*     */           //   398: aload_1
/*     */           //   399: ldc 'childRules'
/*     */           //   401: aload #6
/*     */           //   403: invokevirtual add : (Ljava/lang/String;Lcom/google/gson/JsonElement;)V
/*     */           //   406: aload_1
/*     */           //   407: areturn
/*     */           //   408: astore #5
/*     */           //   410: new java/lang/MatchException
/*     */           //   413: dup
/*     */           //   414: aload #5
/*     */           //   416: invokevirtual toString : ()Ljava/lang/String;
/*     */           //   419: aload #5
/*     */           //   421: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */           //   424: athrow
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #99	-> 0
/*     */           //   #100	-> 19
/*     */           //   #101	-> 26
/*     */           //   #102	-> 32
/*     */           //   #104	-> 35
/*     */           //   #105	-> 41
/*     */           //   #107	-> 51
/*     */           //   #108	-> 54
/*     */           //   #111	-> 62
/*     */           //   #114	-> 74
/*     */           //   #115	-> 86
/*     */           //   #116	-> 89
/*     */           //   #117	-> 96
/*     */           //   #115	-> 101
/*     */           //   #114	-> 104
/*     */           //   #121	-> 110
/*     */           //   #122	-> 118
/*     */           //   #123	-> 126
/*     */           //   #125	-> 129
/*     */           //   #126	-> 138
/*     */           //   #128	-> 146
/*     */           //   #129	-> 152
/*     */           //   #130	-> 210
/*     */           //   #131	-> 240
/*     */           //   #133	-> 264
/*     */           //   #135	-> 270
/*     */           //   #136	-> 283
/*     */           //   #137	-> 291
/*     */           //   #138	-> 304
/*     */           //   #140	-> 311
/*     */           //   #141	-> 314
/*     */           //   #142	-> 320
/*     */           //   #144	-> 323
/*     */           //   #146	-> 326
/*     */           //   #147	-> 333
/*     */           //   #148	-> 343
/*     */           //   #149	-> 350
/*     */           //   #150	-> 359
/*     */           //   #151	-> 368
/*     */           //   #152	-> 382
/*     */           //   #153	-> 391
/*     */           //   #154	-> 398
/*     */           //   #157	-> 406
/*     */           //   #131	-> 408
/*     */           // Local variable table:
/*     */           //   start	length	slot	name	descriptor
/*     */           //   26	25	1	event	I
/*     */           //   76	34	2	i	I
/*     */           //   227	4	10	patt4$temp	Lcom/google/gson/JsonObject;
/*     */           //   217	23	8	$b$0	Ldev/jab125/minimega/call/Ok;
/*     */           //   231	9	9	object1	Lcom/google/gson/JsonObject;
/*     */           //   257	4	12	patt5$temp	Ljavax/xml/stream/XMLStreamException;
/*     */           //   247	17	10	$b$1	Ldev/jab125/minimega/call/Error;
/*     */           //   261	3	11	e	Ljavax/xml/stream/XMLStreamException;
/*     */           //   163	101	6	selector2$temp	Ldev/jab125/minimega/call/Result;
/*     */           //   166	98	7	index$3	I
/*     */           //   291	20	6	text	Ljava/lang/String;
/*     */           //   146	177	5	event	I
/*     */           //   359	47	5	textPlaceholder	Lcom/google/gson/JsonObject;
/*     */           //   391	15	6	placeholderArray	Lcom/google/gson/JsonArray;
/*     */           //   62	346	1	object	Lcom/google/gson/JsonObject;
/*     */           //   118	290	2	children	Lcom/google/gson/JsonArray;
/*     */           //   126	282	3	textContent	Ljava/lang/StringBuilder;
/*     */           //   129	279	4	hasChildren	Z
/*     */           //   0	425	0	reader	Ljavax/xml/stream/XMLStreamReader;
/*     */           // Exception table:
/*     */           //   from	to	target	type
/*     */           //   219	222	408	java/lang/Throwable
/*  98 */           //   249	252	408	java/lang/Throwable }(Throwable[])new XMLStreamException[0]);
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
/*     */   public static JsonObject exiToJson(InputStream stream) throws XMLStreamException, IOException, TransformerException, EXIException {
/* 162 */     EXIFactory exiFactory = DefaultEXIFactory.newInstance();
/* 163 */     ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
/* 164 */     Result result = new StreamResult(arrayOutputStream);
/* 165 */     InputSource is = new InputSource(stream);
/* 166 */     EXISource eXISource = new EXISource(exiFactory);
/* 167 */     eXISource.setInputSource(is);
/* 168 */     TransformerFactory tf = TransformerFactory.newInstance();
/* 169 */     Transformer transformer = tf.newTransformer();
/* 170 */     transformer.transform((Source)eXISource, result);
/* 171 */     arrayOutputStream.close();
/* 172 */     stream.close();
/* 173 */     return (JsonObject)fromXML(arrayOutputStream.toString()).getOrThrow();
/*     */   }
/*     */   
/*     */   public static JsonObject xmlToJson(InputStream stream) throws XMLStreamException, IOException {
/* 177 */     return (JsonObject)fromXML(stripPrologJunk(new String(stream.readAllBytes()))).getOrThrow();
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\Xml2Json2Xml.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */