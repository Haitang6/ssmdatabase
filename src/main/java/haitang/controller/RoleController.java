package haitang.controller;

import com.github.pagehelper.PageInfo;
import haitang.domain.Role;
import haitang.service.RoleServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleServer roleServer;

    @RequestMapping("/findAll")
    public String findAll(Model model,@RequestParam(name = "page",required = true,defaultValue = "1") int page ,
                          @RequestParam(name = "size",required = true,defaultValue = "6") int size){
        List<Role> roles = roleServer.findAll(page,size);
        PageInfo pageInfo = new PageInfo(roles);
        model.addAttribute("pageInfo",pageInfo);
        return "roleList";
    }

    @RequestMapping("/findById")
    public String findById (Model model,String id){

        Role role = roleServer.findById(id);
        model.addAttribute("role",role);
        return "roleDetail";
    }
}
