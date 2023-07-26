package com.onlinebanking.springrest.model;

import jakarta.persistence.Entity;

import jakarta.persistence.*;


@Entity
@Table(name="member")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    
    @Column(name = "UserName")
    private String username;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "AccountNumber")
    private long savingsAccountNumber;
    
    @Column(name = "Balance")
    private long balance;
    
    @Column(name = "Password")
    private String password;
  
    public User() {
		
	}
	
	public User(String username, String email, long accnum,long balance,String pw ) {
		super();
		this.username = username;
		this.email = email;
		this.savingsAccountNumber = accnum;
		this.balance = balance;
		this.password = pw;
	}
	
	
	public long getSavingsAccountNumber() {
		return savingsAccountNumber;
	}
	public void setSavingsAccountNumber(long savingsAccountNumber) {
		this.savingsAccountNumber = savingsAccountNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String name) {
		this.email = name;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	

}
