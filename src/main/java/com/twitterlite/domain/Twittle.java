package com.twitterlite.domain;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
public class Twittle {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private final Long id;
    private final String message;
    private final Date time;
    private Double latitude;
    private Double longtitude;
	public Twittle(Long id, String message, Date time, Double latitude, Double longtitude) {
		super();
		this.id = id;
		this.message = message;
		this.time = time;
		this.latitude = latitude;
		this.longtitude = longtitude;
	}
	public Long getId() {
		return id;
	}
	public String getMessage() {
		return message;
	}
	public Date getTime() {
		return time;
	}
	public Double getLatitude() {
		return latitude;
	}
	public Double getLongtitude() {
		return longtitude;
	}
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		String[] exclude=new String[2];
	     exclude[0]="id";
	     exclude[1]="time";
		return HashCodeBuilder.reflectionHashCode(this, exclude);
	}
	@Override
	public boolean equals(Object that) {
		// TODO Auto-generated method stub
		String[] exclude=new String[2];
	     exclude[0]="id";
	     exclude[1]="time";
		return EqualsBuilder.reflectionEquals(this, that, exclude);
	}
    
}
