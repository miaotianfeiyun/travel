package com.travel.api.common.util;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author QG
 * @since 2010-3-10 09:54:20
 * @version FileUtil.java version 1.0 2010-3-10
 */
public class FileUtil {

    final static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    static Map<String, PropertiesHold> propertiesCache = new ConcurrentHashMap<String, PropertiesHold>();

    public static File getWebAppDirectory() {
        String currenFilePath = FileUtil.class.getResource("").getPath();
        logger.debug("WebAppDirectory path is ", currenFilePath);
        File file = new File(currenFilePath);
        while (!file.getName().toUpperCase().equals("WEB-INF")) {
            file = file.getParentFile();
        }
        File webAppDirFile = file.getParentFile();
        return webAppDirFile;
    }
    //获取服务器绝对路径到 web-inf
    public static File getWebAppDirectoryWebInf() {
        String currenFilePath = FileUtil.class.getResource("").getPath();
        logger.debug("WebAppDirectory path is ", currenFilePath);
        File file = new File(currenFilePath);
        while (!file.getName().toUpperCase().equals("WEB-INF")) {
            file = file.getParentFile();
        }
        return file;
    }
    public static File getProjectDataDirectory() {
        File webAppDirectory = getWebAppDirectory();
        logger.debug(webAppDirectory.getPath());
        File projectDirectoryFile = webAppDirectory.getParentFile();
        logger.debug(projectDirectoryFile.getPath());
        return new File(projectDirectoryFile, "data");
    }
    /**
     * 
     * @param fileName
     * @return
     */
    public static File getFileInDataDirectory(String fileName) {
        return new File(getProjectDataDirectory(), fileName);
    }

    public static String getBaseUploadfilePath() {
        return getWebAppDirectory().getPath() + File.separator;
    }
    //带webinf add by zhangqh  2015-07-31
    public static String getFileUploadPath() {
        return getWebAppDirectoryWebInf().getPath() + File.separator;
    }

    /**
     * @param path
     *            path from classes dir.
     *            <p>
     *            like "config/properties/system.properties",
     *            "com/liantuo/util/price/ZHFlyingAlone.properties"
     * @param expirateSeconds
     *            expiration in seconds,after that properties will be
     *            auto-reloaded
     * @return
     */
    public static Properties loadProperties(String path, long expirateSeconds) {
        PropertiesHold ph = propertiesCache.get(path);
        if (ph == null || expirateSeconds * 1000 < System.currentTimeMillis() - ph.birth) {
            logger.info("{} reloaded with the expiration:{}s", path, expirateSeconds);
            final ClassPathResource rs = new ClassPathResource(path);
            final Properties p = new Properties();
            try {
                p.load(rs.getInputStream());
            } catch (IOException e) {
                logger.warn(path + " load failed", e);
                throw new IllegalStateException(e.getMessage());
            }
            ph = new PropertiesHold(System.currentTimeMillis(), p);
            FileUtil.propertiesCache.put(path, ph);
        }
        return ph.properties;
    }

    static class PropertiesHold {
        public PropertiesHold(long birth, Properties properties) {
            super();
            this.birth = birth;
            this.properties = properties;
        }

        long birth;

        Properties properties;
    }
    public static String getAbsFileName(String fileName) {
    	int indx = fileName.lastIndexOf("/");
    	String absName = null;
    	if (indx != -1) 
    		absName = fileName.substring(indx);
    	return absName;
    }
    /**
     * 获取项目在tomcat的路径到classes 目录下
     * @return 项目在tomcat 的classes的真实路径
     */
    public static String getClassPath() {
    	String currenFilePath = FileUtil.class.getResource("").getPath();
    	File file = new File(currenFilePath);
        while (!file.getName().toUpperCase().equals("CLASSES")) {
            file = file.getParentFile();
        }
    	return file.getAbsolutePath();
    }
}
