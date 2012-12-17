package com.linagora.openpaas.backend.webservice;


import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.linagora.openpaas.backend.dao.InMemoryMessageDAO;
import com.linagora.openpaas.backend.dao.MessageDAO;
import com.linagora.openpaas.backend.dto.Message;
import com.linagora.openpaas.backend.dto.User;


@Path("/messageService")
public class MessageService {
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
    
    
//    @PUT
//    @Path("/message/{mesgid}")
//    public void modifyMessage(@PathParam("mesgid") String id) {
//    }
    
}
