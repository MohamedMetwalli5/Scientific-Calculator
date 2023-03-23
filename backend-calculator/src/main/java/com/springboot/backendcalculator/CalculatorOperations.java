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
	
	@RequestMapping("/sin") 
	public String sin(double data) {
		double angleInRadian = Math.toRadians(data);  
        return Math.sin(angleInRadian)+"";
	}
	
	@RequestMapping("/cos") 
	public String cos(double data) {
		double angleInRadian = Math.toRadians(data);  
        return Math.cos(angleInRadian)+"";
	}
	
	@RequestMapping("/tan") 
	public String tan(double data) {
		double angleInRadian = Math.toRadians(data);  
        return Math.tan(angleInRadian)+"";
	}
	
	@RequestMapping("/sininverse") 
	public String sininverse(double data) {
        return Math.toDegrees(Math.asin(data))+"°";
	}
	
	@RequestMapping("/cosinverse") 
	public String cosinverse(double data) {
        return Math.toDegrees(Math.acos(data))+"°";
	}
	
	@RequestMapping("/taninverse") 
	public String taninverse(double data) {
        return Math.toDegrees(Math.atan(data))+"°";
	}
	
	@RequestMapping("/abs") 
	public String abs(double data) {
        return Math.abs(data)+"";
	}
	
	@RequestMapping("/pi") 
	public String pi() {
        return Math.PI+"";
	}
	
	@RequestMapping("/ln") 
	public String ln(double data) {
        return Math.log(data)+"";
	}
	
	@RequestMapping("/exponent") 
	public String exponent(double base, double power) {
		System.out.println("jppppppppppppppppppppssssssssssssssssssssssssssssssssss");
        return "";
	}
	
	private static double factorial(double n){
		double f=1;
		for(int i=1;i<=n;i++){
		  f=f*i;
		}
		return f;	 
	}
	
	@RequestMapping("/npr") 
	public String npr(double n, double r) {
		return factorial(n)/factorial(n-r)+"";
	}
	
	@RequestMapping("/ncr") 
	public String ncr(double n, double r) {
		return factorial(n)/(factorial(n-r)*factorial(r))+"";
	}
	
}
