package com.props.ocean.service;

import com.props.ocean.model.Prop;
import com.props.ocean.repository.PropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropService {

    @Autowired
    private PropRepository repo;

    public Prop init(Prop p){
       return  repo.save(p);
    }
}
