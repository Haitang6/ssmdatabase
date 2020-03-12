package haitang.service.Impl;

import com.github.pagehelper.PageHelper;
import haitang.dao.RoleDao;
import haitang.domain.Role;
import haitang.service.RoleServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleServer {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> findAll(int page ,int size) {
        PageHelper.startPage(page,size);
        return roleDao.findAll();
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }
}
