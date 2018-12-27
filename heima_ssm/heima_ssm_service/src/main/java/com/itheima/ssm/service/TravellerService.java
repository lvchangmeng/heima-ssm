package com.itheima.ssm.service;

import com.itheima.ssm.domain.Traveller;

import java.util.List;

public interface TravellerService {

    public List<Traveller> findById(String id);
}
