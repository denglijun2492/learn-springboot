## 搭建springboot开发框架说明


### springboot

### mybatis

### reset接口

### 常见问题处理
* HttpMediaTypeNotSupportedException

**解决办法：**
请检查contentType类型，如果想用springmvc @RequestBody注解做提交json字符串自动绑定到pojo入参时，类型需要是"application/json;charset=UTF-8"

* BindingException
>org.apache.ibatis.binding.BindingException: Invalid bound statement (not found)

**解决办法：**

这个问题,通常情况下,这是xml文件与接口mapper不对应导致的，IDEA对xml文件处理的方式不同. mapper.xml文件需要放置在resource这个文件夹下,而eclipse只要mapper接口文件与mapper.xml放置在同一平级目录就行



