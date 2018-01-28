package denglj.learn.springboot.product.controller;

import denglj.learn.springboot.product.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @Test
    public void testSave(){
        Product product = new Product();
        product.setId(100);
        product.setName("iphone6s plus");
        product.setDescr("好用的手机");
        product.setPrice(BigDecimal.valueOf(4299));
        productController.add(product);
    }
    @Test
    public void testBatchInsert(){
        for(Integer i=0; i<30; i++){
            Product product = new Product();
            product.setId(i);
            product.setName("iphone" + i);
            product.setDescr("好用的手机" + i);
            product.setPrice(BigDecimal.valueOf(200*i));
            productController.add(product);
        }
    }

    @Test
    public void testUpdate(){
        Product product = new Product();
        product.setId(1);
        product.setDescr("最好用的手机");
        productController.update(1, product);
    }

    @Test
    public void testDelete(){
        productController.delete(1);
    }
}
