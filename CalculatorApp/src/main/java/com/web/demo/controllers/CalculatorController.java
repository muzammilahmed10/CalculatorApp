package com.web.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.demo.service.CalculatorService;

@Controller
@RequestMapping("/api")
public class CalculatorController {

	@Autowired
	 CalculatorService calculatorService;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	
	@RequestMapping("/calculate")
	public String calculate(@RequestParam int num1, @RequestParam int num2, @RequestParam String operation, Model model) {
		
		int finalresult;
		
		switch(operation) {
		case "add"->finalresult = calculatorService.add(num1,num2);
			
		case "sub"->finalresult = calculatorService.sub(num1, num2);
		
		case "mul"-> finalresult = calculatorService.mul(num1, num2);
		
		case "div"->{
			if(num2==0) {
				finalresult = 0;
			}
			else {
			finalresult = calculatorService.div(num1, num2);
			}
		}
		default->{finalresult = 0;
		return "result";
		}
		}
	
	model.addAttribute("num1",num1);
	model.addAttribute("num2",num2);
	model.addAttribute("operation",operation);
	model.addAttribute("finalresult",finalresult);
	return "result";
	}
}
