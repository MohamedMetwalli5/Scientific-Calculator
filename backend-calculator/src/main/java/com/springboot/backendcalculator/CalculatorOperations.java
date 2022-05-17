package com.springboot.backendcalculator;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //jason
@CrossOrigin // accept requests from any domain
public class CalculatorOperations {
	
	@RequestMapping("/inverse") 
	public String inverse(double data) {
		if(data == 0) {
			return "Can't divide over zero";
		}
		return (1/data)+"";	
	}
	
	@RequestMapping("/square") 
	public String square(double data) {
		return (data*data)+"";
	}
	
	@RequestMapping("/squareroot") 
	public String squareroot(double data) {
		if(data < 0) {
			return "Can't have square root of negative";
		}
		return (Math.sqrt(data))+"";
	}
	
	
	@RequestMapping("/signinverter") 
	public String signinverter(double data) {
		return (data * -1)+"";
	}
	
	@RequestMapping("/add") 
	public String add(double x,double y) {
		return (x+y)+"";
	}
	
	
	@RequestMapping("/subtract") 
	public String subtract(double x,double y) {
		return (x-y)+"";
	}
	
	@RequestMapping("/multiply") 
	public String multiply(double x,double y) {
		return (x*y)+"";
	}
	
	@RequestMapping("/divide") 
	public String divide(double x,double y) {
		if(y == 0) {
			return "Can't divide over zero";
		}
		return (x/y)+"";
	}
	
	@RequestMapping("/percent") 
	public String percent(double data) {
		return (data/100)+"";
	}
	
	
}
