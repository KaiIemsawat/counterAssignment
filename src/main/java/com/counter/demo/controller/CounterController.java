package com.counter.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CounterController {

	@GetMapping("")
	public String index(HttpSession ss) {
//		System.out.println("From index" + ss.getAttribute("counter"));
		if (ss.getAttribute("counter")==null) {
			ss.setAttribute("counter", 0);
		} 
		return "index.jsp";
	}
	
	@GetMapping("/counter")
	public String counter(HttpSession ss) {
		int count = (int) ss.getAttribute("counter");
//		System.out.println("From counter (Top)"+ count);
		count++;
		ss.setAttribute("counter", count);
//		System.out.println("From counter (bottom)"+ count);
		return "counter.jsp";
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession ss) {
		ss.invalidate();
		return "redirect:/";
	}
}