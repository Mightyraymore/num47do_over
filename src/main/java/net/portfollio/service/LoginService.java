package net.portfollio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.portfollio.dao.LoginDao;
import net.portfollio.domain.User;

@Service
public class LoginService 
{
	@Autowired
	private LoginDao loginDao;
	public User isUsernameAndPasswordValid (User user)
	{
		// Avoid a trip to the database since I know these credentials are not valid
		if ("".equals(user.getUsername()) || "".equals(user.getPassword()))
		{
			return null;
		}
		
		User userFromDatabase = loginDao.getUser(user);
		
		return userFromDatabase;
	}
	
	public void createUser(User user)
	{
		loginDao.createUser(user);
	}	

}
