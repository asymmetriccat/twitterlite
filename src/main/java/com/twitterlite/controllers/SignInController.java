package com.twitterlite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.twitterlite.Repositories.TwitterRepository;
import com.twitterlite.domain.Twitter;
import com.twitterlite.service.TwitterService;

@Controller
@SessionAttributes("username")
public class SignInController {
	@Autowired
   TwitterService twitterService;
	
	@Autowired
	TwitterRepository twitterRepository;
	
	@RequestMapping(value="/signIn", method=RequestMethod.GET)
	
	public String showLoginPage(Model model) {
		return "signIn";
	}
	
	@RequestMapping(value="/signIn", method=RequestMethod.POST)
	public String signIn(@RequestParam String username, @RequestParam String password, Model model) {
		Twitter twitter=twitterRepository.findByUsername(username);
		if (twitter!=null){
			
			if(twitter.getPassword()==password) {
				model.addAttribute("username", username);
				model.addAttribute("password", password);
			return "redirect:/welcomepage";
			}
		}
		return "redirect:/register";
	}
}
