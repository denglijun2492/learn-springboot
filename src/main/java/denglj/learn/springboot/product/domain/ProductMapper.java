package denglj.learn.springboot.product.domain;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductMapper {
    @Select("select * from product where id=#{id}")
    Product findById(@Param("id") String id);

    @Insert("insert into product(id, name, address) values(#{id}, #{name}, #{address})")
    int insert(@Param("id")Integer id, @Param("name")String name, @Param("address")String address);
}
