package haitang.controller;
import haitang.domain.Permission;
import haitang.service.PermissionServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    PermissionServer permissionServer;

    @RequestMapping("/findAll")
    public String findAll(Model model){

        List<Permission> permissions = permissionServer.findAll();
        model.addAttribute("permissions",permissions);
        return "permissionList";
    }


}
