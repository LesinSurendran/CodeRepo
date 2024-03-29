package com.myretail.controller;

import java.util.Date;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.constants.MyRetailConstants;
import com.myretail.exceptions.ProductServiceException;
import com.myretail.model.Offer;
import com.myretail.model.ProductResponse;
import com.myretail.model.ServiceException;
import com.myretail.service.ProductService;

/**
 * Product Controller for product related CRUD actions.
 * 
 * @author lesin
 *
 */
@RestController
@RequestMapping("/v1/products")
public class ProductController {

	// Logger for specific logging
	private static final Logger log = LogManager.getLogger(ProductController.class);

	// Product response object variable
	@Autowired
	private ProductResponse product;

	// Product service variable
	@Autowired
	private ProductService productService;

	@Autowired
	ProductController(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * Get product details based on the product identifier
	 * 
	 * @param id - item identifier
	 * @return
	 */
	@GetMapping(value = "{id}")
	public ProductResponse findProductById(@PathVariable("id") Integer id) throws ProductServiceException {

		log.info("findProductById () " + id);

		long startTime = new Date().getTime();

		// Getting the product details based on the product id.
		product = productService.findProductById(id);

		// Setting the response time for the service
		long responseTime = System.currentTimeMillis() - startTime;

		product.setResponseTime(responseTime + "ms");
		log.info("Response time is " + responseTime + " ms");

		return product;
	}

	/**
	 * This method is used to update price for a given product identifier.
	 * 
	 * @param id
	 * @param offer
	 * @return
	 * @throws ProductServiceException
	 */
	@PutMapping(value = "{id}")
	public ProductResponse updatePrice(@PathVariable("id") Integer id, @RequestBody @Valid Offer offer)
			throws ProductServiceException {

		log.info("updatePrice() " + id);

		long startTime = new Date().getTime();

		offer.setId(id);
		// Updating the price for the product
		product = productService.updatePrice(offer);

		// Setting the response time for the service
		long responseTime = System.currentTimeMillis() - startTime;
		product.setResponseTime(responseTime + "ms");

		log.info("Response time is " + responseTime + " ms");

		return product;
	}

	/**
	 * This method is used to have a common exception handling.
	 * 
	 * @param ex
	 * @return
	 */

	@ExceptionHandler(ProductServiceException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ServiceException handleProductNotFound(ProductServiceException ex) {
		// Building exception object.
		ServiceException serviceException = new ServiceException();
		serviceException.setExceptionCode(MyRetailConstants.NOT_FOUND_CODE);
		serviceException.setExceptionMessage(MyRetailConstants.PRODUCT_NOT_FOUND);
		serviceException.setStatus(MyRetailConstants.FAILURE);
		return serviceException;

	}

}
