# learn-springboot
springboot学习示例

## 异常解决
### HttpMediaTypeNotSupportedException
解决：请检查contentType类型，如果想用springmvc @RequestBody注解做提交json字符串自动绑定到pojo入参时，类型需要是"application/json;charset=UTF-8"
Content-Type : application/json;charset=UTF-8


### org.apache.ibatis.binding.BindingException: Invalid bound statement (not found)
这个问题,通常情况下,这是xml文件与接口mapper不对应导致的.  但我仔细检查了一遍,没有发现错误.
在查阅过相关资料后发现,IDEA对xml文件处理的方式不同. mapper.xml文件需要放置在resource这个文件夹下.
而eclipse只要mapper接口文件与mapper.xml放置在同一平级目录就行