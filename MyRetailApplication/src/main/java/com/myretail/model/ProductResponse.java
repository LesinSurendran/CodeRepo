package com.myretail.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * ProductReponse main object.
 * 
 * @author lesin
 *
 */

@Component
@JsonInclude(Include.NON_NULL)
public class ProductResponse {

	private Product product;

	private ServiceException serviceException;

	private String responseTime;

	private String status;

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the serviceException
	 */
	public ServiceException getServiceException() {
		return serviceException;
	}

	/**
	 * @param serviceException the serviceException to set
	 */
	public void setServiceException(ServiceException serviceException) {
		this.serviceException = serviceException;
	}

	/**
	 * @return the responseTime
	 */
	public String getResponseTime() {
		return responseTime;
	}

	/**
	 * @param responseTime the responseTime to set
	 */
	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
