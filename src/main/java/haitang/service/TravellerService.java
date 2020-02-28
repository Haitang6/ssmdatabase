package haitang.service;

import haitang.domain.Traveller;

import java.util.List;

public interface TravellerService {
    void add(Traveller traveller);

    List<Traveller> findAll();

    List<Traveller> findByProductidUserid(String userid,String productid);

}
