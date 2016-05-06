package com.travel.common.util;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
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
import org.apache.commons.httpclient.params.HttpClientParams;
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
     public static String doPostByStream(String url, String params, String charset,String contentType) throws UnsupportedEncodingException{
    	 String result="";
    	 HttpClient httpClient = new HttpClient();  
         //httpClient.getState().setCookiePolicy(CookiePolicy.COMPATIBILITY);  
         PostMethod postMethod = new PostMethod(url);  
         InputStream  in = new ByteArrayInputStream(params.getBytes(charset));  
         postMethod.setRequestEntity(new InputStreamRequestEntity(in,contentType));  
         HttpClientParams clientParams = new HttpClientParams();  
         clientParams.setConnectionManagerTimeout(10000L);  
         clientParams.setContentCharset(charset);
         clientParams.setCredentialCharset(charset);
         httpClient.setParams(clientParams);  
         try {  
             httpClient.executeMethod(postMethod);  
             //获取二进制的byte流  
             result =postMethod.getResponseBodyAsString();  
             logger.debug("client:"+result);  
         }catch (Exception e) {  
             // TODO: handle exception  
        	 logger.info(e.getMessage());  
         }finally{  
             postMethod.releaseConnection();  
         }
		return result;  
     }
     @Deprecated
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
	 * @throws UnsupportedEncodingException 
	 * @Date	2015年11月3日 下午6:41:37 
	 */
	public static String retryReqest(String params,String url,String contentType) throws UnsupportedEncodingException{
		int retryTimes=Integer.valueOf(PropertyUtil.getSystemProperty("retry_times")).intValue();
		String rsp=HttpTookit.doPostByStream(url, params, CHARSET,contentType);
		int temp=1;
		while("F".equals(rsp) && temp<retryTimes){
			rsp=HttpTookit.doPostByStream(url, params, CHARSET,contentType);
			temp++;
		}
		return rsp;
	}
	/**
	 * 携程返回的比较特别 用此方法获取携程返回的数据
	 * @param request
	 * @return
	 * @throws IOException
	 */
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

