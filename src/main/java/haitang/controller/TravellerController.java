package haitang.controller;

import haitang.domain.Traveller;
import haitang.service.TravellerService;
import haitang.service.UserProductTravellerService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @RequestMapping("/add")
    public String add (Traveller traveller , String productid,Model model){

        /*添加游客*/
        String travellerid= UUID.randomUUID().toString();
        traveller.setId(travellerid);
        travellerService.add(traveller);

        userProductTravellerService.add(productid,travellerid);
        String userid="0120";
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
