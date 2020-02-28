package haitang.dao;

import haitang.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.rmi.CORBA.Util;
import java.util.List;

@Repository
public interface RoleDao {

    //根据用户id查询角色集合
    @Select("select * from role where id in (select roleid from users_role where userid=#{userId})")
    @Results(id = "aaa",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "rolename",property = "roleName"),
            @Result(column = "roledesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = java.util.List.class,
                    many = @Many(select = "haitang.dao.PermissionDao.findByRoleId"))
    })
    public List<Role> findRoleByUserId (@Param("userId") String userId);


    @Select("select * from role")
    List<Role> findAll();

    @Select("select * from role where id = #{id}")
    @ResultMap(value = "aaa")
    Role findById (@Param("id") String id);
}
