package com.melon.CucumberAPITestingFramework.cuke.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orders {

	private String intent;
	private List<PurchaseUnit>  purchase_units = null;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Orders() {
	}

	public Orders(String intent, List<PurchaseUnit>  purchase_units) {
		super();
		this.intent = intent;
		this. purchase_units =  purchase_units;
	}

	public String getIntent() {
		return intent;
	}

	public void setIntent(String intent) {
		this.intent = intent;
	}


	public List<PurchaseUnit> getPurchase_units() {
		return purchase_units;
	}

	public void setPurchase_units(List<PurchaseUnit> purchase_units) {
		this.purchase_units = purchase_units;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
