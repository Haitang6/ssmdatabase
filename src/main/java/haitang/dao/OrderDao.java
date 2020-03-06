package haitang.dao;
import haitang.domain.Orders;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderDao {

    @Select("select * from orders")
    @Results(id = "order" ,
            value = {
                    @Result(id = true,column = "id",property = "id"),
                    @Result(column = "ordernum",property = "orderNum"),
                    @Result(column = "ordertime",property = "orderTime"),
                    @Result(column = "orderstatus",property = "orderStatus"),
                    @Result(column = "peoplecount",property = "peopleCount"),
                    @Result(column = "paytype",property = "payType"),
                    @Result(column = "orderdesc",property = "orderDesc"),
                    @Result(column = "productid",property = "product",one = @One(select =
                            "haitang.dao.ProductDao.findById")),
                    @Result(column = "userid",property = "userInfo",one = @One(select =
                            "haitang.dao.UserDao.findById")),
                    @Result(column = "id",property = "travellers",javaType = java.util.List.class,
                            many = @Many(select = "haitang.dao.TravellerDao.findById"))
    })
    List <Orders> findAll();

    @Select("select * from orders order by ${order}")
    @ResultMap(value = "order")
    List <Orders> findAllByOrder(@Param("order") String order);

    @Select("select * from orders where id = #{id}")
    @ResultMap(value = "order")
    Orders findById( @Param("id") String id);

    @Insert("insert into orders (id,ordernum,ordertime,peoplecount,orderdesc,paytype,orderstatus,productid,memberid,userid) " +
            "values (#{id},#{ordernum},#{ordertime},#{peoplecount},#{orderdesc},#{paytype},#{orderstatus},#{productid},'E61D65F673D54F68B0861025C69773DB',#{userid})")
    void add(@Param("id")String id,@Param("ordernum") String ordernum, @Param("ordertime") Date ordertime, @Param("peoplecount") int peoplecount, @Param("orderdesc") String orderdesc, @Param("paytype") int paytype, @Param("orderstatus") int orderstatus, @Param("productid") String productid,@Param("userid") String userid);


    @Insert("insert into order_traveller (orderid,travellerid) values (#{orderid},#{travellerid})")
    void addtraveller(@Param("orderid") String orderid,@Param("travellerid") String travellerid);


}
