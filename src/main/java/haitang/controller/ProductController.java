package haitang.controller;

import com.github.pagehelper.PageInfo;
import haitang.domain.Comment;
import haitang.domain.Product;
import haitang.service.CommentService;
import haitang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    public CommentService commentService;

    @Autowired
    private ProductService productService;
    public Model model;
    public HttpServletRequest request;

    //查询所有，完成旅游的表单显示页面
    @RequestMapping("/findAll")
    @PreAuthorize("authentication.principal.username == 'linker'")
    public String findAll(Model model,@RequestParam(name = "page",defaultValue = "1") int page ,
                          @RequestParam(name = "size",defaultValue = "6") int size){
        List<Product> products = productService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(products);
        model.addAttribute("pageInfo",pageInfo);
        return "productList";
    }

    //根据条件，排序
    @RequestMapping("/findAllByOrder")
    public String findAllByOrder(Model model,String order,@RequestParam(name = "page" ,defaultValue = "1") int page ,
                                 @RequestParam(name = "size", defaultValue = "1") int size){
        List<Product> products = productService.findAllByOrder(order,page,size);
        PageInfo pageInfo = new PageInfo(products);
        model.addAttribute("pageInfo",pageInfo);
        return "productList";
    }

    //根据id查找，完成旅游列表的详情页面
    @RequestMapping("/findById")
    public String findById(String pid,Model model){
        Product product = productService.findById(pid);
        model.addAttribute("product",product);
        return "productDetail";
    }

    @RequestMapping("/findByIdtravel")
    public String findByIdtravel(String pid,Model model){
        Product product = productService.findById(pid);
        model.addAttribute("product",product);
        List<Comment> comments = commentService.findByParentId(pid);

        int count = comments.size();
        model.addAttribute("comments",comments);
        model.addAttribute("count",count);
        return "travelDetail";
    }

    //跳转到添加页面
    @RequestMapping("/addview")
    public String addview(){
        return "productAdd";
    }

    //提交表单，将数据加入数据库，再次执行查询所有
    @PostMapping("/add")
    public String add(Product product){
        productService.add(product);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/del")
    public String del(String id){
        productService.del(id);
        return "redirect:/product/findAll";
    }

//    跳转到详情页面
    @RequestMapping("/detail")
    public String detailview(){
        return "productdetail";
    }

//   根据ID更新用户
    @PostMapping("/updateById")
    public String updateById(Product product){
        productService.updateById(product);
        return "redirect:/product/findAll";
    }


}
