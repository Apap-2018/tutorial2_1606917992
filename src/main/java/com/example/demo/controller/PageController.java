package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	//Latihan project viral
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	//Latihan request parameter
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	//Latihan path variable
	@RequestMapping(value = {"/challenge", "challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	//Latihan viral generator
	@RequestMapping("/generator")
	public String viralGenerator(@RequestParam(value = "a", required = false, defaultValue = "0") String a, @RequestParam(value = "b", required = false, defaultValue = "0") String b, Model model) {		
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		
		//membuat banyaknya m pada hm sesuai value a
		String hm = "hm";
		int intA = Integer.parseInt(a);
		if (intA > 1) {
			for (int i = 0; i < intA-1; i++) {
				hm += 'm';
			}
		}
		hm += " ";	//menambahkan spasi untuk mempermudah tahap selanjutnya
		
		//membuat hm berulang sebanyak b kali
		String nissaSabyan = hm;
		int intB = Integer.parseInt(b);
		if (intB > 1) {
			for (int i = 0; i < intB-1; i++) {
				nissaSabyan += hm;
			}
		}
		
		model.addAttribute("nissaSabyan", nissaSabyan);
		return "ViralGenerator";
	}
	
}