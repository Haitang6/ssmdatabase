package haitang.dao;
import haitang.domain.Role;
import haitang.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    @Select("select * from users where username=#{username}")
    @Results( id = "user", value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property="email",column ="email" ),
            @Result(property="username",column ="username" ),
            @Result(property="password",column ="password" ),
            @Result(property="phoneNum",column ="phonenum" ),
            @Result(property="status",column ="status" ),
            @Result(property="roles",column ="id",javaType = java.util.List.class,
                    many = @Many(select = "haitang.dao.RoleDao.findRoleByUserId"))
    })
    UserInfo findByusername(String username);

    @Insert("insert into users (email,username,password,phonenum,status) " +
            "values (#{email},#{username},#{password},#{phoneNum},#{status})")
    void register (UserInfo userInfo);

    @Select("select * from users")
    List<UserInfo> findAll();

    @Delete("delete from users where id = #{id}")
    void deleteUser (String id);

    @Select("select * from users where id = #{id}")
    @ResultMap(value = "user")
    UserInfo findById (String id);

    @Update("update users set email=#{email}, username=#{username},phonenum=#{phoneNum},status=#{status} where id = #{id}")
    void updateById(UserInfo userInfo);

    @Select("select * from users order by ${order}")
    List<UserInfo> findAllByOrder(@Param("order")  String order);

    @Update("update users set password = #{password} where username = #{username}")
    void resetpwd (@Param("password") String password, @Param("username") String username);

    @Select("select  * from role where id not in (select roleid from users_role where userid = #{id})")
    List<Role> notrole (String id);

    @Insert("insert into users_role (userid,roleid ) values （#{userid}, #{roleid})")
    void addRoleToUser(@Param("userid") String userid,@Param("roleid") String roleid);

    @Select("select productid from orders where userid=#{userid}")
    List<String> findProductidByuserid (@Param("userid") String userid);
 }
