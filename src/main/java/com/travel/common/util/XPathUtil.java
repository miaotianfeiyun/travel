package com.travel.common.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

/** 
 * <p>Title: XPathUtil.java</p>
 * <p>Package Name: com.drolay.common.util</p>  
 * <p>Description:TODO </p> 
 *  
 * @author liujq
 * @date  :2015年11月13日 
 * @version :1.0
 */

public class XPathUtil {
	public static String getResult(String xmlStr,String expression) throws XPathExpressionException{
		XPath xpath = XPathFactory.newInstance().newXPath();
		return xpath.evaluate(expression, new InputSource(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(xmlStr.getBytes(Charset.forName("utf8"))), Charset.forName("utf8")))));
	}
}
