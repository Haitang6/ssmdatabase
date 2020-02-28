package haitang.dao;

import haitang.domain.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao {

    @Select("select * from permission where id in(select permissionid from role_permission where roleid = #{roleid})")
    List<Permission> findByRoleId(@Param("roleid") String roleid);

    @Select("select * from permission")
    List<Permission> findAll();

}
