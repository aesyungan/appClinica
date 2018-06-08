package com.ayungan.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	 @RequestMapping("/")
	    public String home(){
	        return "{Hello server backend app clinica }";
	    }
}
