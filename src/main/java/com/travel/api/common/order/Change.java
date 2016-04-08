package com.travel.api.common.order;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;

/**
 * @author liujq
 * 变更的信息
 */
@Root
public class Change {
	
	/**
	 * 变更字段名
	 */
	@Element(required=false)
	private String Element;
	
	/**
	 * 原字段值
	 */
	@Element(required=false)
	private String OriginalValue;
	
	/**
	 * 当前字段值
	 */
	@Element(required=false)
	private String CurrentValue;

	public String getCurrentValue() {
		return CurrentValue;
	}

	public void setCurrentValue(String currentValue) {
		CurrentValue = currentValue;
	}

	public String getElement() {
		return Element;
	}

	public void setElement(String element) {
		Element = element;
	}

	public String getOriginalValue() {
		return OriginalValue;
	}

	public void setOriginalValue(String originalValue) {
		OriginalValue = originalValue;
	}

}
