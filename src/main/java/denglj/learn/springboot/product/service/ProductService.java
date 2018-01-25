package denglj.learn.springboot.product.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import denglj.learn.springboot.product.mapper.ProductMapper;
import denglj.learn.springboot.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;
    public int addProduct(Product product){
        return productMapper.insertSelective(product);
    }

    public PageInfo<Product> findAllProduct(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Product> lst = productMapper.selectAllProduct();
        PageInfo<Product> result = new PageInfo<>(lst);
        return result;
    }
}
