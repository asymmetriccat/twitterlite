package com.twitterlite.domain;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Twittle {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private  Long id;
    private  String message;
    private  Date time;
    private Double latitude;
    private Double longtitude;
    @ManyToOne
    @JoinColumn(name="twitterId")
    @JsonIgnore
    private Twitter author;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(Double longtitude) {
		this.longtitude = longtitude;
	}
	public Twitter getAuthor() {
		return author;
	}
	public void setAuthor(Twitter author) {
		this.author = author;
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
