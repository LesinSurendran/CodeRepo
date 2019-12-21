/**
 * 
 */
package com.myretail.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Product object for response
 * 
 * @author lesin
 *
 */
@Component
@JsonInclude(Include.NON_NULL)
public class Product {

	private Integer id;
	private String name;

	@JsonProperty("current_price")
	private Price currentPrice;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the currentPrice
	 */
	public Price getCurrentPrice() {
		return currentPrice;
	}

	/**
	 * @param currentPrice the currentPrice to set
	 */
	public void setCurrentPrice(Price currentPrice) {
		this.currentPrice = currentPrice;
	}

}
