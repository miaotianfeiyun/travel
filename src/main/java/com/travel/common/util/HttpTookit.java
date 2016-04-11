package com.travel.common.util;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


/** 
* <p>Title: Snippet.java</p>
* <p>Package Name: com.drolay.common.util</p>  
* <p>Description:TODO </p> 
*  
* @author liujq
* @date  :2015年6月11日 
* @version :1.0
*/ 

public class HttpTookit {
	private static final Logger logger=Logger.getLogger(HttpTookit.class);
	 
    /** 
     * 定义编码格式 UTF-8 
     */  
    public static final String CHARSET = "UTF-8";  
      
//    private static final String URL_PARAM_CONNECT_FLAG = "&";  
      
//    private static final String EMPTY = "";  
  
//    private static MultiThreadedHttpConnectionManager connectionManager = null;  
  
    private static int connectionTimeOut = 25000;  
  
    private static int socketTimeOut = 25000;  
  
//    private static int maxConnectionPerHost = 20;  
  
//    private static int maxTotalConnections = 20;  
  
//    private static HttpClient client;  
  
//    static{  
//        connectionManager = new MultiThreadedHttpConnectionManager();  
//        connectionManager.getParams().setConnectionTimeout(connectionTimeOut);  
//        connectionManager.getParams().setSoTimeout(socketTimeOut);  
//        connectionManager.getParams().setDefaultMaxConnectionsPerHost(maxConnectionPerHost);  
//        connectionManager.getParams().setMaxTotalConnections(maxTotalConnections);  
//        client = new HttpClient(connectionManager);  
//    }  
     /** 
      * 执行一个HTTP GET请求，返回请求响应的HTML 
      * 
      * @param url                 请求的URL地址 
      * @param queryString 请求的查询参数,可以为null 
      * @param charset         字符集 
      * @param pretty            是否美化 
      * @return 返回请求响应的HTML 
      */ 
     public static String doGet(String url, String queryString, String charset, boolean pretty) { 
             StringBuffer response = new StringBuffer(); 
             HttpMethod method = new GetMethod(url); 
             HttpClient client = new HttpClient(); 
             client.getParams().setConnectionManagerTimeout(connectionTimeOut);
             client.getParams().setSoTimeout(socketTimeOut);
             
             try { 
                     if (StringUtils.isNotBlank(queryString)) 
                             //对get请求参数做了http请求默认编码，好像没有任何问题，汉字编码后，就成为%式样的字符串 
                             method.setQueryString(URIUtil.encodeQuery(queryString)); 
                     client.executeMethod(method); 
                     if (method.getStatusCode() == HttpStatus.SC_OK) { 
                             BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), charset)); 
                             String line; 
                             while ((line = reader.readLine()) != null) { 
                                     if (pretty) 
                                             response.append(line).append(System.getProperty("line.separator")); 
                                     else 
                                             response.append(line); 
                             } 
                             reader.close(); 
                     } 
             } catch (URIException e) { 
            	 logger.error("执行HTTP Get请求时，编码查询字符串“" + queryString + "”发生异常！", e); 
             } catch (IOException e) { 
            	 logger.error("执行HTTP Get请求" + url + "时，发生异常！", e); 
             } finally { 
                     method.releaseConnection(); 
             } 
             return response.toString(); 
     } 

     /** 
      * 执行一个HTTP POST请求，返回请求响应的HTML 
      * @param url  请求的URL地址 
      * @param params 请求的查询参数,可以为null 
      * @param charset 字符集 
      * @param pretty  是否美化 
      * @return 返回请求响应的HTML 
      * @author	liujq
      * @Date	2015年6月17日 下午4:51:14 
      */ 
    public static String doPost(String url, Map<String, Object> params, String charset, boolean pretty) { 
             StringBuffer response = new StringBuffer(); 
             HttpClient client = new HttpClient(); 
             PostMethod method = new PostMethod(url); 
             method.getParams().setHttpElementCharset(charset);
     		 method.getParams().setContentCharset(charset);
     		 method.getParams().setCredentialCharset(charset);
             //设置Http Post数据 
             if (params != null) { 
                     for (Map.Entry<String, Object> entry : params.entrySet()) { 
                         method.addParameter(entry.getKey(), String.valueOf(entry.getValue())); 
                     } 
             } 
             try { 
                     client.executeMethod(method); 
                     if (method.getStatusCode() == HttpStatus.SC_OK) { 
                             BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), charset)); 
                             String line; 
                             while ((line = reader.readLine()) != null) { 
                                     if (pretty) 
                                             response.append(line).append(System.getProperty("line.separator")); 
                                     else 
                                             response.append(line); 
                             } 
                             reader.close(); 
                     } 
             } catch (IOException e) { 
                     logger.error("执行HTTP Post请求" + url + "时，发生异常！", e); 
             } finally { 
                     method.releaseConnection(); 
             } 
             return response.toString(); 
     } 

     public static void main(String[] args) { 
             String y = doGet("http://video.sina.com.cn/life/tips.html", "username=test", "GBK", true); 
             System.out.println(y); 
     } 
     /**
      * 向指定URL发送GET方法的请求
      * 
      * @param url
      *            发送请求的URL
      * @param param
      *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
      * @return URL 所代表远程资源的响应结果
      */
     public static String doStreamGet(String url, String param) {
         String result = "";
         BufferedReader in = null;
         try {
             String urlNameString = url + "?" + param;
             URL realUrl = new URL(urlNameString);
             // 打开和URL之间的连接
             URLConnection connection = realUrl.openConnection();
             // 设置通用的请求属性
             connection.setRequestProperty("accept", "*/*");
             connection.setRequestProperty("connection", "Keep-Alive");
             connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
             // 建立实际的连接
             connection.connect();
             // 获取所有响应头字段
             Map<String, List<String>> map = connection.getHeaderFields();
             // 遍历所有的响应头字段
             for (String key : map.keySet()) {
                logger.info(key + "--->" + map.get(key));
             }
             // 定义 BufferedReader输入流来读取URL的响应
             in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
             String line;
             while ((line = in.readLine()) != null) {
                 result += line;
             }
         } catch (Exception e) {
            logger.info("发送GET请求出现异常！" + e);
             e.printStackTrace();
         }
         finally {
             try {
                 if (in != null) {
                     in.close();
                 }
             } catch (Exception e2) {
                 e2.printStackTrace();
             }
         }
         return result;
     }
     /* 向指定 URL 发送POST方法的请求
     * @param url 发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String doStreamPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.info("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }  
    public static String postStream(String url, String params, String charset, boolean pretty){
    	String result="";
    	HttpClient client = new HttpClient();   
    	PostMethod method = new PostMethod(url); 
        method.getParams().setHttpElementCharset(charset);
  		method.getParams().setContentCharset(charset);
  		method.getParams().setCredentialCharset(charset);
  		try{
	  		ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(params);
	    	byte[] data = baos.toByteArray();
	    	ByteArrayInputStream bis = new ByteArrayInputStream(data);
	    	InputStreamRequestEntity entity=new InputStreamRequestEntity(bis);
	    	method.setRequestEntity(entity);
    	    client.executeMethod(method);
    	    result = method.getResponseBodyAsString();
    	    logger.info(result);
    	    return result;
    	 }catch (Throwable e){
    		 e.printStackTrace();
    	 }finally{
    		 method.releaseConnection();
    	 }
    	 return result;
    }
    public static String getFromStream(HttpServletRequest request) throws Exception{
    	InputStream is = request.getInputStream();
	    ObjectInputStream ois = new ObjectInputStream(is);
	    return ois.readObject().toString();
    }
	/** 
	 * @Description:	重试请求
	 * @param params
	 * @param url
	 * @return	String
	 * @author	liujq
	 * @Date	2015年11月3日 下午6:41:37 
	 */
	public static String retryReqest(String params,String url){
		int retryTimes=Integer.valueOf(PropertyUtil.getSystemProperty("retry_times")).intValue();
		String rsp=HttpTookit.postStream(url, params, CHARSET, false);
		int temp=1;
		while("F".equals(rsp) && temp<retryTimes){
			rsp=HttpTookit.postStream(url, params, CHARSET, false);
			temp++;
		}
		return rsp;
	}
	public static String getStrXmlFromStream(HttpServletRequest request) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(),CHARSET));
        String line = null;
        StringBuffer sb = new StringBuffer();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String strXml=sb.toString();
        return strXml;
	}
}

