package com.codegym.controller;

import com.codegym.model.Motel;
import com.codegym.service.IMotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/motels")
public class MotelRestController {
    @Autowired
    private IMotelService motelService;

    @GetMapping("/detail/{id}")
    public ResponseEntity<Motel> viewDetail(@PathVariable int id){
        Motel motel = motelService.findById(id);
        return new ResponseEntity<>(motel,HttpStatus.OK);
    }
}
