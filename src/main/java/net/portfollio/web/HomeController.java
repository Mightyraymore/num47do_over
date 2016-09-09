package net.portfollio.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.portfollio.dao.MessageDao;
import net.portfollio.domain.Message;
import net.portfollio.domain.User;


@Controller
@RequestMapping("/app")
public class HomeController 
{
	@Autowired
	MessageDao messageDao;
	
	@RequestMapping(value="home", method=RequestMethod.GET)
	public String homeGet(ModelMap model)
	{										
		List<Message> messages = messageDao.getMessages();
		
		Message message = new Message();
		
		model.put("message", message);
		model.put("messages", messages);
		return "app/home";
	}
	
	@RequestMapping(value="home", method=RequestMethod.POST)
	public String homePost(@ModelAttribute("message")Message message, ModelMap model, HttpServletRequest request)
	{
		User user = (User)request.getSession().getAttribute("user");
		
		message.setUser(user);
		messageDao.save(message);
		
		message = new Message();
		List<Message> messages = messageDao.getMessages();
		
		model.put("message", message);
		model.put("messages", messages);
		
		return "app/home";
	}
	
	@RequestMapping(value="home/{messageID}", method=RequestMethod.GET)
	public String homeGetByMessageId(@PathVariable("messageId") Long messageId, ModelMap model)
	{
		Message messageById = messageDao.getMessageById(messageId);
		List<Message> messages = new ArrayList<Message>();
		messages.add(messageById);
		model.put("messages", messages);
		return "app/home";
	}
	
}
