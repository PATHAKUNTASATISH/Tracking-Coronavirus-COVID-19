package io.springboot2.x.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.springboot2.x.service.ICoronavirus_COVID_19Service;

@Controller
public class Coronavirus_COVID_19_Controller {
	
	@Autowired
    private ICoronavirus_COVID_19Service service;
	
	@RequestMapping(value = "/getStatus", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("caselist", service.getMainList());
		return "index";
	}
}
