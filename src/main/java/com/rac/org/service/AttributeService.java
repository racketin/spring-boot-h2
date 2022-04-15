package com.rac.halodoc.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.rac.halodoc.model.Attribute;
import com.rac.halodoc.util.AttributeType;
import com.rac.halodoc.util.AttributeValidator;
import com.rac.halodoc.util.Validator;

public class AttributeService {
	private Map<String, AttributeType> attributeStore = new ConcurrentHashMap<String, AttributeType>();
	private Validator validator = new AttributeValidator(attributeStore);

	public void addAttribute(List<Attribute> attributes) {
		attributes.stream().forEach((attribute) -> attributeStore.put(attribute.getName(), attribute.getType()));
	}

	public boolean validate(Attribute attribute) {
		return validator.validate(attribute);
	}

}
