/**
 * 
 */
package com.myretail.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Price object for response
 * 
 * @author lesin
 *
 */
@Component
@JsonInclude(Include.NON_NULL)
public class Price {

	private Double value;

	@JsonProperty("currency_code")
	private String currencyCode;

	/**
	 * @return the value
	 */
	public Double getValue() {
		return value;
	}

	/**
	 * @param bigDecimal the value to set
	 */
	public void setValue(Double value) {
		this.value = value;
	}

	/**
	 * @return the currency_code
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @param currency_code the currency_code to set
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

}
