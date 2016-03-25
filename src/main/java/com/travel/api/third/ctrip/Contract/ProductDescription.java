package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="ProductDescription")
public class ProductDescription {
@Element(required=false)
private String DescriptionType ;


public String getDescriptionType() {
	return DescriptionType;
 }

public void setDescriptionType(String descriptiontype) {
DescriptionType = descriptiontype;
}

@Element(required=false)
private String Content ;


public String getContent() {
	return Content;
 }

public void setContent(String content) {
Content = content;
}

}
