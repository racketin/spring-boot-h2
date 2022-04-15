package com.rac.halodoc.util;

import com.rac.halodoc.model.Attribute;

public class AttributeBuilder {
	public static Attribute buildAttribute(String name, String value) {
		Attribute attribute = new Attribute();
		attribute.setName(name);
		attribute.setValue(value);
		return attribute;
	}
}
