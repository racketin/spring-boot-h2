package com.rac.halodoc.util;

import java.util.List;
import java.util.Map;

import com.rac.halodoc.model.Attribute;

public class AttributeValidator implements Validator {

	private Map<String, AttributeType> attributeStore;

	public AttributeValidator(Map<String, AttributeType> attribStore) {
		this.attributeStore = attribStore;
	}

	public boolean validate(Attribute attribute) {
		boolean validate = false;
		if (attributeStore.get(attribute.getName()) != null) {
			validate = attributeStore.get(attribute.getName()) == attribute.getType();
		} else {
			validate = true;
		}
		return validate;
	}
}
