package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.TravellerDao;
import com.itheima.ssm.domain.Traveller;
import com.itheima.ssm.service.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravellerServiceImpl implements TravellerService {
    @Autowired
    private TravellerDao travellerDao;
    @Override
    public Traveller findById(String id) {
        return travellerDao.findById(id);
    }
}
