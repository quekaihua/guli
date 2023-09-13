package com.qkh.gulimall.product;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.qkh.gulimall.product.entity.BrandEntity;
import com.qkh.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    void testUpload() throws FileNotFoundException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI5tJxmVdwSEpGf38DivDa";
        String accessKeySecret = "DIzG8fUuz5bhlCd3PtST15vIL8QKnm";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传文件流
        InputStream inputStream = new FileInputStream("/Users/mywife/Pictures/红酒.jpeg");
        ossClient.putObject("gulimall-qkh", "red.jpeg", inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    @Test
    void contextLoads() {

        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setDescript("hello");
        brandEntity.setName("华为--小米");
        brandService.save(brandEntity);
        System.out.println("保存成功");
    }

}
