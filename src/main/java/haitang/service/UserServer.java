package haitang.service;

import haitang.domain.Role;
import haitang.domain.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServer extends UserDetailsService {

    void register (UserInfo userInfo);

    List<UserInfo> findAll (int page,int size);

    void deleteUser (String id);

    UserInfo findById (String id);

    void updateById (UserInfo userInfo);

    List<UserInfo> findAllByOrder(int page,int size ,String order);

    void resetpwd (String password,String username);

    List<Role> notrole(String id);

    void addRoleToUser(String userid,String[] roleidlist);

    List<String> findProductidByuserid();



}


