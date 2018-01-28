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

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public void add(@RequestBody Product product){
        productService.saveProduct(product);
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public void update(@PathVariable("id") Integer id, @RequestBody Product product){
        product.setId(id);
        productService.updateProduct(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id){
        productService.deleteProduct(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public PageInfo<Product> list(@RequestParam(name = "pageNum") int pageNum,
                                  @RequestParam(name = "pageSize") int PageSize){
        PageInfo<Product> p = productService.findProductPage(pageNum, PageSize);
        return p;
    }


}
