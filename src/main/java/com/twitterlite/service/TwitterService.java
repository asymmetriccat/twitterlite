package com.twitterlite.service;


import java.util.List;

import com.twitterlite.domain.Twitter;



public interface TwitterService {
	List<Twitter> findAll();
	Twitter findByUsername(String username);
	Twitter findByEmail(String email);
	void save(Twitter twitter);

}
