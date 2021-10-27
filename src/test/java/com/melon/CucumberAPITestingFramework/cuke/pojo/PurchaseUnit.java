package com.melon.CucumberAPITestingFramework.cuke.pojo;

import java.util.HashMap;
import java.util.Map;

public class PurchaseUnit {

	private Amount amount;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public PurchaseUnit() {
	}

	public PurchaseUnit(Amount amount) {
		super();
		this.amount = amount;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
