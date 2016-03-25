package com.travel.api.third.ctrip.SDK;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.travel.common.util.PropertyUtil;

public class SDKCore {
	private static String _root = PropertyUtil.getSystemProperty("ctrip_api_url");
	
	public static <T> T XMLStringToObj(Class<T> cls , String str) throws Exception
	{
		Serializer serializer = new Persister();
		T res = (T) serializer.read(cls, str);
		
		return res;
	}
	public static <T> String ObjToXMLString(T entity) throws Exception
	{
		Serializer serializer = new Persister();
        
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        serializer.write(entity, bos);
		
		return bos.toString("UTF-8");
	}
	
	public static String PostRequest(String request, String method)
	{
		String responseString = "";
		
		String url = _root + method;
		
		try 
		{
			HttpURLConnection urlConn;
			URL mUrl = new URL(url);
			urlConn = (HttpURLConnection) mUrl.openConnection();
			urlConn.setDoOutput(true);
			
			urlConn.addRequestProperty("Content-Type", "application/" + "POST");
			if (request != null) {
				urlConn.setRequestProperty("Content-Length", Integer.toString(request.length()));
				urlConn.getOutputStream().write(request.getBytes("UTF8"));
			}
			
			int responseCode = urlConn.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
	 
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream(),"UTF-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	 
			responseString = response.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseString;
	}
}
