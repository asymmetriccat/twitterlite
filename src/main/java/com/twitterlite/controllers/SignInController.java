package com.twitterlite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.twitterlite.domain.Twitter;
import com.twitterlite.service.TwitterService;

@Controller

public class SignInController {
	@Autowired
   TwitterService twitterService;
	
	@RequestMapping(value="/signIn", method=RequestMethod.GET)
	public String showLoginPage(Model model) {
		return "signIn";
	}
	
	@RequestMapping(value="/signIn", method=RequestMethod.POST)
	public String signIn(@RequestParam String username, @RequestParam String password, Model model) {
		Twitter twitter=twitterService.findByUsername(username);
		if (twitter!=null){
			
			if(twitter.getPassword()==password) {
				model.addAttribute("username", username);
				model.addAttribute("password", password);
			return "redirect:/home";
			}
		}
		return "redirect:/register";
	}
}
