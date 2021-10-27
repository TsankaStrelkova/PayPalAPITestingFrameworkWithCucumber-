package com.melon.CucumberAPITestingFramework.cuke.pojo;

import java.util.HashMap;
import java.util.Map;

public class Amount {

	private String currency_code;
	private String value;

	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Amount() {
	}

	public Amount(String currency_code, String value) {
		super();
		this.currency_code = currency_code;
		this.value = value;
	}

	

	public String getCurrency_code() {
		return currency_code;
	}

	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}