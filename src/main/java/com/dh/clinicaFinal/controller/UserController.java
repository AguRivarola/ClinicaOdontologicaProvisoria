package com.dh.clinicaFinal.controller;

import com.dh.clinicaFinal.service.implementation.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class UserController {

    private AppUserService appUserService;
    @Autowired
    public UserController(AppUserService appUserService){
        this.appUserService = appUserService;
    }

    @RequestMapping(value = "/authentication", method = RequestMethod.GET)
    public ResponseEntity<?> toRegister() throws Exception{
        return null;
    }

}
