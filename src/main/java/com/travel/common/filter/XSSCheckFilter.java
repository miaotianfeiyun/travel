package com.travel.common.filter;

import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/** 
* <p>Title: XSSCheckFilter.java</p>
* <p>Package Name: com.drolay.common</p>  
* <p>Description:Xss防注入和sql注入过滤器, </p> 
* <p>Company: liantuobank.com</p> 
* @author liujq
* @date  :2015年6月4日 
* @version :1.0
*/ 
public class XSSCheckFilter implements Filter {
	Logger log=Logger.getLogger(this.getClass().getName());
	@SuppressWarnings("unused")
	private FilterConfig config;
	private static String errorPath="";// 出错跳转的目的地
	private static String[] excludePaths;// 不进行拦截的url
	private static String[] safeless = {
			"<script", 
			"</script", "<iframe", "</iframe", "<frame", "</frame",
			"set-cookie", "%3cscript", "%3c/script", "%3ciframe", "%3c/iframe",
			"%3cframe", "%3c/frame", "src=\"javascript:", "<body", "</body",
			"%3cbody", "%3c/body",
            "drop",
            "truncate","exec","declare","net user","xp_cmdshell","execl","net"};// 需要拦截的关键字

	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain filterChain) {
		log.info("过滤web请求中的不安全信息开始");
		try{
			Enumeration<?> params = req.getParameterNames();
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) resp;
			boolean isSafe = true;
			String requestUrl = request.getRequestURI();
			log.info("params:" + params + " , requestUrl:" + requestUrl+ " , queryUrl" +  request.getQueryString());
			if (isSafe(requestUrl)) {
				requestUrl = requestUrl.substring(requestUrl.indexOf("/"));
				if (!excludeUrl(requestUrl)) {
					while (params.hasMoreElements()) {
						String cache = req.getParameter((String) params.nextElement());
						if (StringUtils.isNotBlank(cache)) {
							if (!isSafe(cache)) {
								isSafe = false;
								break;
							}
						}
					}
				}
			} else {
				isSafe = false;
			}
			if (!isSafe) {
				request.setAttribute("err", "您输入的参数有非法字符，请输入正确的参数！");
				request.getRequestDispatcher(errorPath).forward(request, response);
				return;
			}
			filterChain.doFilter(req, resp);
			log.info("过滤web请求中的不安全信息完成");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private  boolean isSafe(String str) {
		if (StringUtils.isNotBlank(str)) {
			for (String s : safeless) {
				if (str.toLowerCase().contains(s)) {
					log.info("疑似有程序注入，请求url:"+str);
					return false;
				}
			}
		}
		return true;
	}
	private boolean excludeUrl(String url) {
		if (excludePaths != null && excludePaths.length > 0) {
			for (String path : excludePaths) {
				if (url.toLowerCase().equals(path)) {
					return true;
				}
			}
		}
		return false;
	}
	public void destroy() {
	}
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		errorPath = config.getInitParameter("errorPath");
		String excludePath = config.getInitParameter("excludePaths");
		if (StringUtils.isNotBlank(excludePath)) {
			excludePaths = excludePath.split(",");
		}
	}
}
