package haitang.controller;
import com.github.pagehelper.PageInfo;
import haitang.domain.Permission;
import haitang.service.PermissionServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    PermissionServer permissionServer;

    @RequestMapping("/findAll")
    public String findAll(Model model,
                          @RequestParam(name="page" ,defaultValue = "6") int page,
                          @RequestParam(name = "size",defaultValue = "6") int size){

        List<Permission> permissions = permissionServer.findAll(page, size);
        PageInfo pageInfo=new PageInfo(permissions);
        model.addAttribute("pageInfo",pageInfo);
        return "permissionList";
    }


}
