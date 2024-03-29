package com.myretail.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myretail.model.Offer;

/**
 * Junit test class used to validate the repository layer of the my retail
 * application
 * 
 * @author lesin
 *
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * This method is used to test all offer retrieval
	 */
	@Test
	public void findAllOffers() {
		List<Offer> offerList = productRepository.findAll();
		assertNotNull(offerList);
		assertTrue(!offerList.isEmpty());
	}

	/**
	 * This method is used to test find offer by id
	 */
	@Test
	public void testFindByOfferId() {
		// given
		Offer offerTest = new Offer(123, 10.00, "USD");
		productRepository.save(offerTest);
		// when
		Offer offerDB = productRepository.findById(offerTest.getId()).get();

		// Validate data
		assertNotNull(offerDB);
		assertThat(offerDB.getId()).isEqualTo(offerTest.getId());
		assertEquals(offerTest.getPrice(), offerDB.getPrice());
		assertEquals(offerTest.getCurrencyCode(), offerDB.getCurrencyCode());

	}

	/**
	 * This method is used to test updating an offer record
	 */
	@Test
	public void testUpdateOffer() {
		// given
		Offer offerTest = new Offer(123, 10.00, "USD");
		productRepository.save(offerTest);

		Offer offerDB = productRepository.findById(offerTest.getId()).get();
		offerDB.setPrice(123.00);
		// when
		Offer offerUpdated = productRepository.save(offerDB);

		// Validate data
		assertNotNull(offerUpdated);
		assertThat(offerUpdated.getId()).isEqualTo(offerDB.getId());
		assertEquals(offerDB.getPrice(), offerUpdated.getPrice());

	}

}
