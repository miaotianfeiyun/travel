package com.travel.common.util;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;
/** 
 * <p>Title: DateEditor.java</p>
 * <p>Package Name: com.drolay.common.util</p>  
 * <p>Description:时间转换 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年7月16日 
 * @version :1.0
 */

public class DateEditor extends PropertyEditorSupport {

	    private static final DateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");
	    private static final DateFormat TIMEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	    private DateFormat dateFormat;
	    private boolean allowEmpty = true;

	    public DateEditor() {
	    }

	    public DateEditor(DateFormat dateFormat) {
	        this.dateFormat = dateFormat;
	    }

	    public DateEditor(DateFormat dateFormat, boolean allowEmpty) {
	        this.dateFormat = dateFormat;
	        this.allowEmpty = allowEmpty;
	    }

	    /**
	     * Parse the Date from the given text, using the specified DateFormat.
	     */
	    @Override
	    public void setAsText(String text) throws IllegalArgumentException {
	        if (this.allowEmpty && !StringUtils.hasText(text)) {
	            // Treat empty String as null value.
	            setValue(null);
	        } else {
	            try {
	                if(this.dateFormat != null)
	                    setValue(this.dateFormat.parse(text));
	                else {
	                    if(text.contains(":"))
	                        setValue(TIMEFORMAT.parse(text));
	                    else
	                        setValue(DATEFORMAT.parse(text));
	                }
	            } catch (ParseException ex) {
	                throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex);
	            }
	        }
	    }

	    /**
	     * Format the Date as String, using the specified DateFormat.
	     */
	    @Override
	    public String getAsText() {
	        Date value = (Date) getValue();
	        DateFormat dateFormat = this.dateFormat;
	        if(dateFormat == null)
	            dateFormat = TIMEFORMAT;
	        return (value != null ? dateFormat.format(value) : "");
	    }
}