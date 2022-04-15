package com.rac.halodoc.model;

import com.rac.halodoc.util.AttributeType;

public class Attribute {
	private String name;
	private AttributeType type;
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.type = parseType(value);
		this.value = value;
	}

	private AttributeType parseType(String value) {
		AttributeType type = AttributeType.STRING;
		try {
			Integer.parseInt(value);
			type = AttributeType.INTEGER;
		} catch (NumberFormatException exception) {
			//log.warn
		}
		return type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AttributeType getType() {
		return type;
	}

	private void setType(AttributeType type) {
		this.type = type;
	}
}
