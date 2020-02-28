package haitang.service;

import haitang.domain.Permission;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PermissionServer {

    List<Permission> findAll();
}
