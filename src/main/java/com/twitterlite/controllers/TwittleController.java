package com.twitterlite.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.twitterlite.TwittleService;
import com.twitterlite.Repositories.TwittleRepository;
import com.twitterlite.domain.Twittle;

@Controller
public class TwittleController {
   private TwittleService twittleService;
   
   @Autowired
   public TwittleController(TwittleService twittleService) {
	   this.twittleService=twittleService;
   }
   
   @RequestMapping(value="/twittles")
   public String twittles(Model model) {
	  List<Twittle> twittles=twittleService.findAll();
	  model.addAttribute("twittleList", twittles);
	  return "twittles";
   }
}
