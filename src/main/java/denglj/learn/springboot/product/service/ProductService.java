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

    /**
     * 新增产品信息
     * @param product
     * @return
     */
    public int saveProduct(Product product){
        return productMapper.insertSelective(product);
    }

    /**
     * 修改
     * @param product
     */
    public void updateProduct(Product product){
        productMapper.updateByPrimaryKeySelective(product);
    }

    /**
     * 删除
     * @param id
     */
    public void deleteProduct(int id){
        productMapper.deleteByPrimaryKey(id);
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Product> findProductPage(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Product> lst = productMapper.selectAllProduct();
        PageInfo<Product> result = new PageInfo<>(lst);
        return result;
    }
}
