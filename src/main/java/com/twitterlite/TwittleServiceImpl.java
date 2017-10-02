package com.twitterlite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitterlite.Repositories.TwittleRepository;
import com.twitterlite.domain.Twittle;

@Service
public class TwittleServiceImpl implements TwittleService{
    
	@Autowired
	TwittleRepository twittleRepository;
	
	@Override
	public List<Twittle> findAll() {
		// TODO Auto-generated method stub
		return twittleRepository.findAll();
	}

	
}
