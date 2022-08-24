package com.br.devForTech.ApiAngular.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.devForTech.ApiAngular.models.Home;

@RestController
public class HomeController {
    @GetMapping("/")
    public Home index(){
        return new Home();
    }
}
