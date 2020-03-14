package haitang.service.Impl;

import com.github.pagehelper.PageHelper;
import haitang.dao.UserDao;
import haitang.domain.Role;
import haitang.domain.UserInfo;
import haitang.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userServer")
@Transactional
public class UserServerImpl implements UserServer {

    @Autowired
    UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo =userDao.findByusername(username);
//        User user = new User(userInfo.getUsername(), "{noop}"+userInfo.getPassword(), getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), getAuthority(userInfo.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List <Role> roles){
        List <SimpleGrantedAuthority> list=new ArrayList<>();
        for(Role role:roles) {
            list.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return list;
    }

    @Override
    public void register(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userDao.register(userInfo);
}

    @Override
    public List<UserInfo> findAll(int page,int size) {

        PageHelper.startPage(page,size);

        return userDao.findAll();
    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void updateById(UserInfo userInfo) {
        userDao.updateById(userInfo);
    }

    @Override
    public List<UserInfo> findAllByOrder(int page, int size, String order) {

        PageHelper.startPage(page,size);
        return userDao.findAllByOrder(order);
    }

    @Override
    public void resetpwd(String password, String username) {

        password=passwordEncoder.encode(password);

        userDao.resetpwd(password, username);
    }

    @Override
    public List<Role> notrole(String id) {
        return userDao.notrole(id);
    }

    @Override
    public void addRoleToUser(String userid, String[] roleidlist) {

        for (String roleid:roleidlist){
            userDao.addRoleToUser(userid,roleid);
        }

    }

    @Override
    public List<String> findProductidByuserid(String userid) {

        return userDao.findProductidByuserid(userid);
    }


}
