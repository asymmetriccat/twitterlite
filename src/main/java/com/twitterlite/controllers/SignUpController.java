package com.twitterlite.controllers;



import javax.validation.Valid;

import org.elasticsearch.common.inject.internal.Errors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.twitterlite.Repositories.TwitterRepository;
import com.twitterlite.domain.Twitter;
import com.twitterlite.service.TwitterService;


@Controller

public class SignUpController {
	
	@Autowired
	TwitterService twitterService;
   
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(Model model) {
		Twitter twitter=new Twitter();
		model.addAttribute("twitter", twitter);
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerForm(@Valid Twitter twitter, Errors errors) {
		if(errors.hasErrors()) return "register";
		twitterService.save(twitter);
		return "redirect:/" + twitter.getUsername();
	}
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String twitterProfile(@PathVariable String username, Model model) {
		Twitter twitter=twitterService.findByUsername(username);
		model.addAttribute(twitter);
		return "profile";
	}
}
