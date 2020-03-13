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
    public void add(String userid,String productid, String travellerid) {
        userProductTravellerDao.add(userid,productid,travellerid);
    }
}
