package denglj.test;

import denglj.learn.springboot.sys.RestResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
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
//        RestTemplate rt = new RestTemplate();
//        Product p1 = new Product();
//        p1.setId(1);
//        p1.setName("tv");
//        p1.setAddress("bejing");
//        RestResult r = rt.postForObject("http://localhost:8082/demo/product", p1, RestResult.class);
//        System.out.println(r);
    }
}
