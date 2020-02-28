package haitang.controller;

import com.github.pagehelper.PageInfo;
import haitang.domain.Product;
import haitang.domain.Role;
import haitang.domain.UserInfo;
import haitang.service.ProductService;
import haitang.service.UserServer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServer userServer;

    @Autowired
    ProductService productService;

    @RequestMapping("/add")
    public String add(UserInfo userInfo){
        userServer.register(userInfo);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/register")
    public String register(UserInfo userInfo){
        userServer.register(userInfo);
        return "login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/reg")
    public String reg(){
        return "register";
    }

    @GetMapping("/failer")
    public String failer (){
        return "failer";
    }

    @GetMapping("/resetpwd")
    public String resetpwd(){
        return "resetpwd";
    }

    @PostMapping("/resetpassword")
    public String resetpassword(String password,String username){
        userServer.resetpwd(password, username);
        return "login";
    }

    @RequestMapping("/findAll")
    public String findAll (Model model , @RequestParam(name = "page",required = true,defaultValue = "1") int page,
                           @RequestParam(name = "size",required = true,defaultValue = "6") int size){
        List<UserInfo> users = userServer.findAll(page, size);
        PageInfo pageInfo = new PageInfo(users);
        model.addAttribute("pageInfo",pageInfo);
        return "userList";
    }

    @RequestMapping("/findAllByOrder")
    public String findAllByOrder (Model model , @RequestParam(name = "page",required = true,defaultValue = "1") int page,
                           @RequestParam(name = "size",required = true,defaultValue = "6") int size,String order){
        List<UserInfo> users = userServer.findAllByOrder(page, size, order);
        PageInfo pageInfo = new PageInfo(users);
        model.addAttribute("pageInfo",pageInfo);
        return "userList";
    }

    @RequestMapping("/addview")
    public String addview(){
        return "userAdd";
    }

    @RequestMapping("/del")
    public String deleteUser(String id){
        userServer.deleteUser(id);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/findById")
    public String findById (String id,Model model){
        UserInfo userInfo = userServer.findById(id);
        model.addAttribute("user",userInfo);
        return "userDetail";
    }

    @RequestMapping("/findById2")
    public String findById2 (String id,Model model){
        UserInfo userInfo = userServer.findById(id);
        model.addAttribute("user",userInfo);
        return "userChange";
    }

    @RequestMapping("/updateById")
    public String updateById(UserInfo userInfo){
        userServer.updateById(userInfo);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/updateById2")
    public String updateById2(UserInfo userInfo){
        userServer.updateById(userInfo);
        return "redirect:/user/myself";
    }

    @RequestMapping("/addRole")
    public String addRole(String id , Model model){
        UserInfo userInfo = userServer.findById(id);
        List<Role> roles = userServer.notrole(id);
        model.addAttribute("userInfo",userInfo);
        model.addAttribute("roles",roles);
        return "roleAdd";
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userid" ,required = true) String userid ,
                                @RequestParam(name = "roleidlist",required = true) String[] roleidlist){

        System.out.println(roleidlist);
        userServer.addRoleToUser(userid , roleidlist);

        return "redirect:/user/findAll";
    }

    @RequestMapping("/addTraveller")
    public String addpermission (String productid,Model model){

        model.addAttribute("productid",productid);
        return "travellerAdd";
    }

    @RequestMapping("/myself")
    public String myself( Model model){


        UserInfo userInfo = userServer.findById("0120");
        model.addAttribute("user",userInfo);

        List<String> productids = userServer.findProductidByuserid();

        List<Product> products=new ArrayList<Product>();

        for(String productid :productids){
            Product product = productService.findById(productid);
            products.add(product);
        }
        model.addAttribute("products",products);

        return "myself";
    }








}
