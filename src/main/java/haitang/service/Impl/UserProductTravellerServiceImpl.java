package haitang.service.Impl;

import haitang.dao.UserProductTravellerDao;
import haitang.service.UserProductTravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProductTravellerServiceImpl implements UserProductTravellerService {

    @Autowired
    UserProductTravellerDao userProductTravellerDao;

    @Override
    public void add(String productid, String travellerid) {
        System.out.println(productid);
        System.out.println(travellerid);
        userProductTravellerDao.add(productid,travellerid);
    }
}
