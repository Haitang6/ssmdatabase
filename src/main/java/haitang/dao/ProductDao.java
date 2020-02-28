/*遗留问题
* 01-17 最先添加的元素，排在最前面，和数据库中数据顺序相反 rowid desc 不是很可靠
*
* */
package haitang.dao;
import haitang.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {

    @Select("select * from product order by rowid desc")
    List<Product> findAll();

    @Select("select * from product order by  ${order} ")
    List<Product> findAllByOrder(@Param("order") String order );

    @Select("select  * from product where id=#{pid}")
    Product findById(String pid);

    @Insert("insert into product (productNum,productName ,cityName, departureTime, productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void add(Product product);

    @Delete("delete from product where id=#{id}")
    void  del(String id);

    @Update("update product set id=#{id} ,productNum=#{productNum} ,productName=#{productName},cityName=#{cityName}," +
            "departureTime=#{departureTime}, productPrice=#{productPrice} ,productDesc=#{productDesc},productStatus=#{productStatus} where id=#{id}")
    void updateById(Product product);

}
