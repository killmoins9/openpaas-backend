package com.linagora.openpaas.backend.webservice;


import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.linagora.openpaas.backend.dao.InMemoryMessageDAO;
import com.linagora.openpaas.backend.dao.MessageDAO;
import com.linagora.openpaas.backend.dto.Message;
import com.linagora.openpaas.backend.dto.User;


@Path("/messageService")
public class MessageService{
   
    private static MessageDAO messageDAO = new InMemoryMessageDAO();

    @POST
    @Path("/message")
    public void createMessage(@FormParam(value="body") String body, @FormParam(value="subject")String subject) {
    	Message message = new Message();
    	message.setBody(body);
    	message.setSubject(subject);
    	User u = getCurrentUser();
    	messageDAO.create(message,u);
    }

    @GET
    @Path("/messages")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAvailableMessages() {
    	User u = getCurrentUser();
        return  messageDAO.findAvailableMessage(u);
    }
    
    @GET
    @Path("/messages/number")
    @Produces(MediaType.APPLICATION_JSON)
    public int getMessagesNumber() {
    	User u = getCurrentUser();
        return  messageDAO.getMessagesNumber(u);
    }
    
    
    
    private static User myUser ;
    
    private User getCurrentUser(){
    	
    	if(myUser==null){
	    	myUser = new User();
	    	myUser.setFirstname("prenom1");
	    	myUser.setLastname("nom1");
	    	myUser.setMail("prenom1.nom1@openpaas.com");
	    	myUser.setLogin("login1");
    	}
    	
    	return  myUser;
    }
    
    
    @GET
    @Path("/message/{mesgid}")
    public Message findMessage(@PathParam("mesgid") String id) {
    	User u = getCurrentUser();
        Message m =  messageDAO.getMessage(id,u);
        if (m == null) 
        	throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity("message id not found").build());
        
        return m;
    }
	
    
}
