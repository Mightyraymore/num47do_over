package net.portfollio.domain;

import java.util.Set;

//import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;


//@Table(name="users")
public class User 
{	
	private Long id;
	private String username;
	private String password;
	private String accountType;
	private Boolean termsOfService;
	private Set<Message> messages;
	
	// User ----> Message
	// 1 (one)     *(many)
	
	// many to many
	// table A  <----> table A

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) 
	{
		this.accountType = accountType;
	}
	public Boolean getTermsOfService() 
	{
		return termsOfService;
	}
	public void setTermsOfService(Boolean termsOfService) 
	{
		this.termsOfService = termsOfService;
	}
	public Set<Message> getMessages() {
		return messages;
	}
	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
}
