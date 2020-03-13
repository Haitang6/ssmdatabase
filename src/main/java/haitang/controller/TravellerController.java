package haitang.controller;

import haitang.dao.UserDao;
import haitang.domain.Traveller;
import haitang.domain.UserInfo;
import haitang.service.TravellerService;
import haitang.service.UserProductTravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/traveller")
public class TravellerController {

    @Autowired
    TravellerService travellerService;
    @Autowired
    UserProductTravellerService userProductTravellerService;
    @Autowired
    UserDao userDao;

    @RequestMapping("/add")
    public String add (Traveller traveller , String productid,Model model){


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        UserInfo userInfo = userDao.findByusername(name);
        String userid=userInfo.getId();

        /*添加游客*/
        String travellerid= UUID.randomUUID().toString();
        traveller.setId(travellerid);
        travellerService.add(traveller);
        userProductTravellerService.add(userid,productid,travellerid);

        List<Traveller> travellers = travellerService.findByProductidUserid(userid, productid);
        model.addAttribute("productid",productid);
        model.addAttribute("travellers",travellers);
        return "travellerAddList";
    }

    @RequestMapping("/findAll")
    public String findAll(Model model){

        List<Traveller> travellers = travellerService.findAll();
        model.addAttribute("travellers",travellers);
        return "travellerList";

    }
}
