package com.twitterlite.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.twitterlite.domain.Twittle;


public interface TwittleRepository extends CrudRepository<Twittle, Long>{
    List<Twittle> findAll();
    
}
