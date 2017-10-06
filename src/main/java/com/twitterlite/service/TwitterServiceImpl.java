package com.twitterlite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitterlite.Repositories.TwitterRepository;
import com.twitterlite.domain.Twitter;

@Service
public class TwitterServiceImpl implements TwitterService{
	@Autowired
	TwitterRepository twitterRepository;

	
	public List<Twitter> findAll() {
		// TODO Auto-generated method stub
		return twitterRepository.findAll();
	}

	@Override
	public Twitter findByUsername(String username) {
		// TODO Auto-generated method stub
		return twitterRepository.findByUsername(username);
	}

	@Override
	public Twitter findByEmail(String email) {
		// TODO Auto-generated method stub
		return TwitterRepository.findByEmail(email);
	}

	@Override
	public void save(Twitter twitter) {
		// TODO Auto-generated method stub
		twitterRepository.save(twitter);
	}

	
}
