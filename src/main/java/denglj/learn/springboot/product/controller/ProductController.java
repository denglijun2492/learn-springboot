package denglj.learn.springboot.product.controller;

import com.github.pagehelper.PageInfo;
import denglj.learn.springboot.product.mapper.ProductMapper;
import denglj.learn.springboot.product.model.Product;
import denglj.learn.springboot.product.service.ProductService;
import denglj.learn.springboot.sys.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping(value = "/save")
    public RestResult save(@RequestBody Product product){
        productService.addProduct(product);
        return new RestResult("00","success");
    }

    @RequestMapping(value = "/find")
    public PageInfo<Product> find(@RequestParam(name = "pageNum") int pageNum, @RequestParam(name = "pageSize") int PageSize){
        PageInfo<Product> r = productService.findAllProduct(pageNum, PageSize);
        return r;
    }
}
