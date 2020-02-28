package haitang.service;

import haitang.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleServer {
    List<Role> findAll(int page,int size);

    Role findById(String id);
}
