package com.example.firstservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FirstServiceController {

	@GetMapping("")
	public String home(){
		return "redirect:/welcome";
	}


	@GetMapping("/welcome")
	public String welcome(){
		return "welcome to the First service";
	}
}
