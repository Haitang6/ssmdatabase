package haitang.service;

import haitang.domain.Orders;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface OrderServer {

    List <Orders> findAll(int page,int size);
    List <Orders> findAllByOrder(String order);
    Orders findById (String id);
    void add(String id,String ordernum, Date ordertime, int peoplecount, String orderdesc, int paytype, int orderstatus, String productid);
    void addtraveller(String orderid,String travellerid);
}
