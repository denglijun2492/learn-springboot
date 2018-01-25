package denglj.learn.springboot.product.domain;

import com.github.pagehelper.PageInfo;
import denglj.learn.springboot.product.mapper.ProductMapper;
import denglj.learn.springboot.product.model.Product;
import denglj.learn.springboot.product.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductService productService;

    @Test
    public void testInsert(){
        for(int i=0; i<10; i++){
            Product p = new Product();
            p.setId(i);
            p.setName("电视" + i);
            productMapper.insertSelective(p);
        }
    }

    @Test
    public void testPager(){
        PageInfo<Product> pageInfo = productService.findAllProduct(3, 3);
        for (Product product : pageInfo.getList()) {
            System.out.println(product.getId()+ "\t" + product.getName());
        }
    }
}
