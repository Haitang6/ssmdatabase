package haitang.service.Impl;

import haitang.dao.TravellerDao;
import haitang.domain.Traveller;
import haitang.service.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravellerServiceImpl implements TravellerService {

    @Autowired
    TravellerDao travellerDao;
    @Override
    public void add(Traveller traveller) {
        travellerDao.add(traveller);

    }

    @Override
    public List<Traveller> findAll() {

        return travellerDao.findAll();
    }

    @Override
    public List<Traveller> findByProductidUserid(String userid, String productid) {
        return travellerDao.findByProductidUserid(userid, productid);
    }
}
