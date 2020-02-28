package haitang.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.naming.Name;

@Repository
public interface UserProductTravellerDao {

    @Insert("insert into users_product_traveller values ('0120',#{productid},#{travellerid})")
    void add(@Param("productid") String productid, @Param("travellerid") String travellerid);
}
