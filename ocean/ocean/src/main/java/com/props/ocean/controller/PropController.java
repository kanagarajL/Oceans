package com.props.ocean.controller;

import com.props.ocean.model.Prop;
import com.props.ocean.service.PropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prop")
public class PropController {



    private PropService service;

    @Autowired
    public PropController(PropService service) {
        this.service = service;
    }

    @PostMapping("/init")
    public ResponseEntity<Prop> init(@RequestBody Prop prop){
        Prop p = service.init(prop);
        return  ResponseEntity.ok(p);
    }



}
