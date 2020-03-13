package haitang.service;

import org.springframework.stereotype.Service;

@Service
public interface UserProductTravellerService {

    void add(String userid,String productid,String travellerid);
}
