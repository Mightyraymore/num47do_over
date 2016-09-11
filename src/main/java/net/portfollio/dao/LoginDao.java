package net.portfollio.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.portfollio.domain.User;

@Repository
@Transactional
public class LoginDao 
{
	@PersistenceContext
	EntityManager em;
	
	public void createUser (User user)
	{
		Session session = (Session) em.getDelegate();
		
		session.save(user);
	}
	
	@SuppressWarnings("unchecked")
	public User getUser (User user)
	{
		Session session = (Session) em.getDelegate();
		
		List<User> list = session.createCriteria(User.class)
				.add(Restrictions.eq("username", user.getUsername()))
				.add(Restrictions.eq("password", user.getPassword()))
				.list();
		
		if (list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
}
