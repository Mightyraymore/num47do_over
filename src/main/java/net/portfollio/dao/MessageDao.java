package net.portfollio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.portfollio.domain.Message;

@Repository
@Transactional
public class MessageDao 
{
	@PersistenceContext
	//@Autowired
	EntityManager em;
	@SuppressWarnings("unchecked")
	public List<Message> getMessages()
	{
		Session session = (Session) em.getDelegate();
		
		return session.createCriteria(Message.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public Message getMessageById(Long messageId) 
	{
		Session session = (Session) em.getDelegate();
		
		List<Message> messages = session.createCriteria(Message.class).add(Restrictions.eqOrIsNull("id", messageId)).list();
		
		if (messages.size() == 0)
		{
			return null;	
		}
		else
		{
			return messages.get(0);
		}
	}

	public void save(Message message) 
	{
		Session session = (Session) em.getDelegate();
		
		session.save(message);
		session.flush();
	}
}
