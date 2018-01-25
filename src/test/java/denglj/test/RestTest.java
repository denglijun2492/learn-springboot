package denglj.test;

import denglj.learn.springboot.rest.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
public class RestTest {
    @Test
    public void test1(){
        RestTemplate rt = new RestTemplate();
        String r = rt.getForObject("http://localhost:8082/demo/greeting?name=denglj", String.class);
        System.out.println(r);
    }

    @Test
    public void test2(){
        RestTemplate rt = new RestTemplate();
        Product p1 = new Product("iphone7", 5999.0);
        String r = rt.postForObject("http://localhost:8082/demo/receiveMessage", p1, String.class);
        System.out.println(r);
    }
}
