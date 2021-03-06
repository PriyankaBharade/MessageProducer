package com.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Billing Address Info Model")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingAddress {// implements Serializable
	@ApiModelProperty("unique id")
	int id;
	// @JacksonXmlProperty(localName = "contact")
	@ApiModelProperty("Contact Details")
	public Contact contact;

	@Override
	public String toString() {
		return "BillingAddress {id=" + id + ", contact=" + contact + "}";
	}

	public BillingAddress() {
		super();
	}

	public BillingAddress(int id, Contact contact) {
		super();
		this.id = id;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
