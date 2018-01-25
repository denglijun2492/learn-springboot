package denglj.learn.springboot.product.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testInsert(){
        productMapper.insert(1, "denglj", "xiamen");
    }

    @Test
    public void testSelect(){
        Product p = productMapper.findById("1");
        System.out.println(p);
    }
}
