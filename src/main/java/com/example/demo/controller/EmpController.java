package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Customer;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.CustService;
@Controller
public class EmpController {
	
	@Autowired
	private CustService service;
	
	@GetMapping("/")
	public String home(Model m) {
		List<Customer> cust=service.getAllCust();
		m.addAttribute("cust",cust);
		return "index";
	}
	@GetMapping("addCust")
	public String addCustForm() {
		return "add_cust";
	}
	
	@PostMapping("/register")
	public String custRegister(@ModelAttribute Customer c, HttpSession session)
	{
		System.out.println(c);
		service.addCust(c);
		session.setAttribute("msg", "Customer details added sucessfully");
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		Customer c= service.getCustById(id);
		m.addAttribute("cust",c);
		return "edit";
	}
}
