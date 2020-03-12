package haitang.controller;

import com.github.pagehelper.PageInfo;
import haitang.domain.Product;
import haitang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/index")
@Controller
public class IndexController {

    @Autowired
    ProductService productService;


    @RequestMapping
    public String toIndex() {

        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        String ordertime= sdf.format(date);
        System.out.println(ordertime);
        return "index";
    }

    @RequestMapping("/travel-index")
    public String travelindex(Model model){
        int page=1;
        int size=6;
        List<Product> products = productService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(products);
        model.addAttribute("pageInfo",pageInfo);
        return "travel-index";
    }

    @RequestMapping("/travel-indexpage")
    public String travelindexpage(Model model, @RequestParam(name = "page",required = true,defaultValue = "1") int page,
                                  @RequestParam(name = "size",required = true,defaultValue = "6") int size){
        List<Product> products = productService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(products);
        model.addAttribute("pageInfo",pageInfo);
        return "travel-index";
    }
}
