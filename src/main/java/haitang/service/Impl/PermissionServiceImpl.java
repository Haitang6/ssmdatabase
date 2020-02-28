package haitang.service.Impl;

import haitang.dao.PermissionDao;
import haitang.domain.Permission;
import haitang.service.PermissionServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionServer {
    @Autowired
    PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {

        return permissionDao.findAll();
    }
}
