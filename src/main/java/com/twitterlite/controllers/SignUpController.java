package com.twitterlite.controllers;



import javax.validation.Valid;

import org.elasticsearch.common.inject.internal.Errors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.twitterlite.Repositories.TwitterRepository;
import com.twitterlite.domain.Twitter;
import com.twitterlite.service.TwitterService;


@Controller

public class SignUpController {
	
	@Autowired
	TwitterService twitterService;
	@Autowired
	TwitterRepository twitterRepository;
   
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(Model model) {
		Twitter twitter=new Twitter();
		model.addAttribute("twitter", twitter);
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerForm(@Valid Twitter twitter, Errors errors, RedirectAttributes model) {
		if(errors.hasErrors()) return "register";
		if(null==twitterRepository.findByUsername(twitter.getUsername())) {
		twitterRepository.save(twitter);
		model.addAttribute("username", twitter.getUsername());
		model.addFlashAttribute("twitter", twitter);
		return "redirect:/{username}";
		}
		return "register";
	}
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String twitterProfile(@PathVariable String username, Model model) {
		if(!model.containsAttribute("twitter")) {
		
		model.addAttribute(twitterRepository.findByUsername(username));
		}
		return "profile";
	}
}
