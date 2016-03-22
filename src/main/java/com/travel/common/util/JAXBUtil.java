package com.travel.common.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
/** 
 * <p>Title: JAXBUtil.java</p>
 * <p>Package Name: com.drolay.common.util</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年7月22日 
 * @version :1.0
 */
	public class JAXBUtil<T> {

		@SuppressWarnings("unchecked")
		public T unmarshal(Class<T> clazz, InputStream is) throws JAXBException {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Unmarshaller un = context.createUnmarshaller();
			return (T) un.unmarshal(is);
		}
		
		public T unmarshal(Class<T> clazz, File file) throws JAXBException, FileNotFoundException {
			return unmarshal(clazz,new FileInputStream(file));
		}
		
		public void marshal(T element,OutputStream os) throws JAXBException{
			JAXBContext jc = JAXBContext.newInstance(element.getClass());
			Marshaller m = jc.createMarshaller();
			m.marshal(element, os);
		}
		
		public void marshal(T element, File output) throws FileNotFoundException, JAXBException{
			marshal(element,new FileOutputStream(output));
		}
}
