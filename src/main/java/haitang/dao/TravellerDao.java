package haitang.dao;

import haitang.domain.Traveller;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravellerDao {

    //根据订单id 查询乘客 id
    @Select("select * from traveller where id in (select travellerid from order_traveller where orderid = #{orderid})")
    List<Traveller> findById(String orderid);

    @Insert("insert into traveller (id,name,sex,phonenum,credentialsType,credentialsNum,travellerType) values (#{id},#{name},#{sex},#{phoneNum},#{credentialsType},#{credentialsNum},#{travellerType})")
    void add(Traveller traveller);

    @Select("select * from traveller")
    List<Traveller> findAll();

    @Select("select * from traveller where id in(select travellerid from users_product_traveller where userid=#{userid} and productid = #{productid})")
    List<Traveller> findByProductidUserid(@Param("userid") String userid, @Param("productid") String productid);
}
