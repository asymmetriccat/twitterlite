package com.twitterlite.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.twitterlite.domain.Twitter;



public interface TwitterRepository extends CrudRepository<Twitter, Long>{
	
	List<Twitter> findAll();

	Twitter findByUsername(String username);

	static Twitter findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
