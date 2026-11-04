package com.example.jpa;

import com.example.jpa.Repositories.ProductRepository;
import com.example.jpa.entities.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaApplicationTests {

	@Autowired
    ProductRepository productRepository;

	@Test
	void contextLoads() {
	}
@Test
	void testRepository(){
	ProductEntity productEntity = ProductEntity.builder()
			.sku("sku-002")
			.title("product 2")
			.price(BigDecimal.valueOf(200))
			.quantity(20)
			.build();
ProductEntity savedProductEntity=productRepository.save(productEntity);
System.out.println(savedProductEntity);
}

@Test
	void getRepository(){
//	List<ProductEntity>entities=productRepository.findAll();
//	System.out.println(entities);

//	List<ProductEntity>en=productRepository.findByTitle("product 1");
//	System.out.println(en);

	Optional<ProductEntity> productEntity = productRepository.findByTitleAndPrice("product 1",100);
	System.out.println(productEntity);


}
}
