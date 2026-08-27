/*     */ package dev.jab125.minimega.mod.client.p2p.upnp;
/*     */ 
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.Inet4Address;
/*     */ import java.net.InetAddress;
/*     */ import java.net.URL;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.StringTokenizer;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.w3c.dom.traversal.DocumentTraversal;
/*     */ import org.w3c.dom.traversal.NodeIterator;
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
/*     */ public class Gateway
/*     */ {
/*     */   private final Inet4Address iface;
/*     */   private final InetAddress routerip;
/*  47 */   private String serviceType = null, controlURL = null;
/*     */   
/*     */   public Gateway(byte[] data, Inet4Address ip, InetAddress gatewayip) throws Exception {
/*  50 */     this.iface = ip;
/*  51 */     this.routerip = gatewayip;
/*  52 */     String location = null;
/*  53 */     StringTokenizer st = new StringTokenizer(new String(data), "\n");
/*  54 */     while (st.hasMoreTokens()) {
/*  55 */       String s = st.nextToken().trim();
/*  56 */       if (s.isEmpty() || s.startsWith("HTTP/1.") || s.startsWith("NOTIFY *")) {
/*     */         continue;
/*     */       }
/*  59 */       String name = s.substring(0, s.indexOf(':')), val = (s.length() >= name.length()) ? s.substring(name.length() + 1).trim() : null;
/*  60 */       if (name.equalsIgnoreCase("location")) {
/*  61 */         location = val;
/*     */       }
/*     */     } 
/*  64 */     if (location == null) {
/*  65 */       throw new Exception("Unsupported Gateway");
/*     */     }
/*     */     
/*  68 */     Document d = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(location);
/*  69 */     NodeList services = d.getElementsByTagName("service");
/*  70 */     for (int i = 0; i < services.getLength(); i++) {
/*  71 */       Node service = services.item(i);
/*  72 */       NodeList n = service.getChildNodes();
/*  73 */       String serviceType = null, controlURL = null;
/*  74 */       for (int j = 0; j < n.getLength(); j++) {
/*  75 */         Node x = n.item(j);
/*  76 */         if (x.getNodeName().trim().equalsIgnoreCase("serviceType")) {
/*  77 */           serviceType = x.getFirstChild().getNodeValue();
/*  78 */         } else if (x.getNodeName().trim().equalsIgnoreCase("controlURL")) {
/*  79 */           controlURL = x.getFirstChild().getNodeValue();
/*     */         } 
/*     */       } 
/*  82 */       if (serviceType != null && controlURL != null)
/*     */       {
/*     */         
/*  85 */         if (serviceType.trim().toLowerCase(Locale.ROOT).contains(":wanipconnection:") || serviceType.trim().toLowerCase(Locale.ROOT).contains(":wanpppconnection:")) {
/*  86 */           this.serviceType = serviceType.trim();
/*  87 */           this.controlURL = controlURL.trim();
/*     */         }  } 
/*     */     } 
/*  90 */     if (this.controlURL == null) {
/*  91 */       throw new Exception("Unsupported Gateway");
/*     */     }
/*  93 */     int slash = location.indexOf("/", 7);
/*  94 */     if (slash == -1) {
/*  95 */       throw new Exception("Unsupported Gateway");
/*     */     }
/*  97 */     location = location.substring(0, slash);
/*  98 */     if (!this.controlURL.startsWith("/")) {
/*  99 */       this.controlURL = "/" + this.controlURL;
/*     */     }
/* 101 */     this.controlURL = location + location;
/*     */   }
/*     */   
/*     */   private Map<String, String> command(String action, Map<String, String> params) throws Exception {
/* 105 */     Map<String, String> ret = new HashMap<>();
/* 106 */     String soap = "<?xml version=\"1.0\"?>\r\n<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\"><SOAP-ENV:Body><m:" + action + " xmlns:m=\"" + this.serviceType + "\">";
/*     */ 
/*     */     
/* 109 */     if (params != null) {
/* 110 */       for (Map.Entry<String, String> entry : params.entrySet()) {
/* 111 */         soap = soap + "<" + soap + ">" + (String)entry.getKey() + "</" + (String)entry.getValue() + ">";
/*     */       }
/*     */     }
/* 114 */     soap = soap + "</m:" + soap + "></SOAP-ENV:Body></SOAP-ENV:Envelope>";
/* 115 */     byte[] req = soap.getBytes();
/* 116 */     HttpURLConnection conn = (HttpURLConnection)(new URL(this.controlURL)).openConnection();
/* 117 */     conn.setRequestMethod("POST");
/* 118 */     conn.setDoOutput(true);
/* 119 */     conn.setRequestProperty("Content-Type", "text/xml");
/* 120 */     conn.setRequestProperty("SOAPAction", "\"" + this.serviceType + "#" + action + "\"");
/* 121 */     conn.setRequestProperty("Connection", "Close");
/* 122 */     conn.setRequestProperty("Content-Length", "" + req.length);
/* 123 */     conn.getOutputStream().write(req);
/* 124 */     Document d = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(conn.getInputStream());
/* 125 */     NodeIterator iter = ((DocumentTraversal)d).createNodeIterator(d.getDocumentElement(), 1, null, true);
/*     */     Node n;
/* 127 */     while ((n = iter.nextNode()) != null) {
/*     */       try {
/* 129 */         if (n.getFirstChild().getNodeType() == 3) {
/* 130 */           ret.put(n.getNodeName(), n.getTextContent());
/*     */         }
/* 132 */       } catch (Throwable throwable) {}
/*     */     } 
/*     */     
/* 135 */     conn.disconnect();
/* 136 */     return ret;
/*     */   }
/*     */   
/*     */   public String getGatewayIP() {
/* 140 */     return this.routerip.getHostAddress();
/*     */   }
/*     */   
/*     */   public String getLocalIP() {
/* 144 */     return this.iface.getHostAddress();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getExternalIP() {
/*     */     try {
/* 150 */       Map<String, String> r = command("GetExternalIPAddress", null);
/* 151 */       return r.get("NewExternalIPAddress");
/* 152 */     } catch (Throwable t) {
/* 153 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public boolean openPort(int internalPort, int externalPort, boolean udp) {
/* 159 */     if (internalPort < 0 || internalPort > 65535) {
/* 160 */       throw new IllegalArgumentException("Invalid internal port");
/*     */     }
/* 162 */     if (externalPort < 0 || externalPort > 65535) {
/* 163 */       throw new IllegalArgumentException("Invalid external port");
/*     */     }
/* 165 */     Map<String, String> params = new HashMap<>();
/* 166 */     params.put("NewRemoteHost", "");
/* 167 */     params.put("NewProtocol", udp ? "UDP" : "TCP");
/* 168 */     params.put("NewInternalClient", this.iface.getHostAddress());
/* 169 */     params.put("NewExternalPort", "" + externalPort);
/* 170 */     params.put("NewInternalPort", "" + internalPort);
/* 171 */     params.put("NewEnabled", "1");
/* 172 */     params.put("NewPortMappingDescription", "WaifUPnP");
/* 173 */     params.put("NewLeaseDuration", "0");
/*     */     try {
/* 175 */       Map<String, String> r = command("AddPortMapping", params);
/* 176 */       return (r.get("errorCode") == null);
/* 177 */     } catch (Exception ex) {
/* 178 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public boolean openPort(int port, boolean udp) {
/* 184 */     return openPort(port, port, udp);
/*     */   }
/*     */   
/*     */   public boolean closePort(int port, boolean udp) {
/* 188 */     if (port < 0 || port > 65535) {
/* 189 */       throw new IllegalArgumentException("Invalid port");
/*     */     }
/* 191 */     Map<String, String> params = new HashMap<>();
/* 192 */     params.put("NewRemoteHost", "");
/* 193 */     params.put("NewProtocol", udp ? "UDP" : "TCP");
/* 194 */     params.put("NewExternalPort", "" + port);
/*     */     try {
/* 196 */       command("DeletePortMapping", params);
/* 197 */       return true;
/* 198 */     } catch (Exception ex) {
/* 199 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isMapped(int port, boolean udp) {
/* 204 */     if (port < 0 || port > 65535) {
/* 205 */       throw new IllegalArgumentException("Invalid port");
/*     */     }
/* 207 */     Map<String, String> params = new HashMap<>();
/* 208 */     params.put("NewRemoteHost", "");
/* 209 */     params.put("NewProtocol", udp ? "UDP" : "TCP");
/* 210 */     params.put("NewExternalPort", "" + port);
/*     */     try {
/* 212 */       Map<String, String> r = command("GetSpecificPortMappingEntry", params);
/* 213 */       if (r.get("errorCode") != null) {
/* 214 */         throw new Exception();
/*     */       }
/* 216 */       return (r.get("NewInternalPort") != null);
/* 217 */     } catch (Exception ex) {
/* 218 */       return false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mod\client\p2\\upnp\Gateway.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */