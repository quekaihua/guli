package com.qkh.gulimall.product;

import com.qkh.gulimall.product.entity.BrandEntity;
import com.qkh.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallProductApplicationTests {

	@Autowired
	BrandService brandService;

	@Test
	void contextLoads() {

		BrandEntity brandEntity = new BrandEntity();
		brandEntity.setDescript("hello");
		brandEntity.setName("华为--小米");
		brandService.save(brandEntity);
		System.out.println("保存成功");
	}

}
