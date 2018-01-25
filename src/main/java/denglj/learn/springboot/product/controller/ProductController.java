package denglj.learn.springboot.product.controller;

import denglj.learn.springboot.product.domain.Product;
import denglj.learn.springboot.product.domain.ProductMapper;
import denglj.learn.springboot.sys.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductMapper productMapper;
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public RestResult save(@RequestBody Product product){
        productMapper.insert(product.getId(), product.getName(), product.getAddress());
        return new RestResult("11","success");
    }
}
