package com.twitterlite.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;



@Entity
public class Twitter {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
   private Long twitterId;
   
   @NotNull
   @Size(min=2, max=30, message="{firstName.size")
   private String firstName;
   
   @NotNull
   @Size(min=2, max=30, message="{lastName.size")
   private String lastName;
   
   @NotNull
   @Email(message="email.valid")
   private String email;
   
   @NotNull
   @Size(min=5, max=25, message="{password.size")
   private String password;
   
   @NotNull
   @Size(min=5,max=16, message="{username.size")
   private String username;
   
   @OneToMany(mappedBy="author", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
   private List<Twittle> twittle;


public List<Twittle> getTwittle() {
	return twittle;
}
public void setTwittle(List<Twittle> twittle) {
	this.twittle = twittle;
}
public Long getTwitterId() {
	return twitterId;
}
public void setTwitterId(Long twitterId) {
	this.twitterId = twitterId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
   
   
}
