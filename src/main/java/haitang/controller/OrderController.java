package haitang.controller;

import com.github.pagehelper.PageInfo;
import haitang.dao.OrderDao;
import haitang.domain.Orders;
import haitang.service.OrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderServer orderServer;

    @RequestMapping("/findAll")
    public String findAll(Model model,
                          @RequestParam(name = "page" , defaultValue = "1",required = true) int page,
                          @RequestParam(name = "size" ,defaultValue ="1",required = true) int size ){
        List<Orders> orders = orderServer.findAll(page,size);
        PageInfo pageInfo = new PageInfo(orders);
        model.addAttribute("pageInfo",pageInfo);
        return "orderList";
    }

    @RequestMapping("/findAllByOrder")
    public String findAllByOrder(Model model,String order){
        List<Orders> orders = orderServer.findAllByOrder(order);
        model.addAttribute("orderList",orders);
        return "orderList";
    }

    @RequestMapping("/findById")
    public String findById (String id,Model model){
        Orders orders = orderServer.findById(id);
        model.addAttribute("orders",orders);
        return "orderDetail";
    }

    @RequestMapping("/add")
    public String add (Orders orders,String productid,String traveller[]){

        String id=UUID.randomUUID().toString();
        String ordernum=UUID.randomUUID().toString();

        Date ordertime = new Date();// 获取当前时间
        int  peoplecount=traveller.length;
        String orderdesc=orders.getOrderDesc();
        int  paytype=orders.getPayType();
        int orderstatus=1;
        orderServer.add(id,ordernum, ordertime,peoplecount,orderdesc,paytype,orderstatus,productid);

        for (String traverllerid:traveller){
            System.out.println(traverllerid);
            orderServer.addtraveller(id,traverllerid);
        }

        return "redirect:/index/travel-index";
    }

}
