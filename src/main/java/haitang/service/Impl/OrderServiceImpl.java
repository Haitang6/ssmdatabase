package haitang.service.Impl;

import com.github.pagehelper.PageHelper;
import haitang.dao.OrderDao;
import haitang.domain.Orders;
import haitang.service.OrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderServer {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Orders> findAll(int page ,int size) {

        PageHelper.startPage(page,size);
        return orderDao.findAll();
    }

    @Override
    public List<Orders> findAllByOrder(String order ,int page,int size) {
        PageHelper.startPage(page,size);
        return orderDao.findAllByOrder(order);
    }

    @Override
    public Orders findById(String id) {
        return orderDao.findById(id);
    }

    @Override
    public void add(String id,String ordernum, Date ordertime, int peoplecount, String orderdesc, int paytype, int orderstatus, String productid,String userid) {
        orderDao.add(id,ordernum,ordertime,peoplecount,orderdesc,paytype,orderstatus,productid,userid);

    }

    @Override
    public void addtraveller(String orderid, String travellerid) {
        orderDao.addtraveller(orderid, travellerid);
    }
}
