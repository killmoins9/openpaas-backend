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


@Path("/messageService")
public class MessageService {
    private static MessageDAO messageDAO = new InMemoryMessageDAO();

    @POST
    @Path("/message")
    public void createMessage(@FormParam(value="body") String body, @FormParam(value="subject")String subject) {
    	Message message = new Message();
    	message.setBody(body);
    	message.setSubject(subject);
    	messageDAO.create(message);
    }

    @GET
    @Path("/messages")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAvailableMessages() {
        return  messageDAO.findAvailableMessage();
    }
    
    @GET
    @Path("/messages/number")
    @Produces(MediaType.APPLICATION_JSON)
    public int getMessagesNumber() {
        return  messageDAO.getMessagesNumber();
    }
    
    
    
//    @PUT
//    @Path("/message/{mesgid}")
//    public void modifyMessage(@PathParam("mesgid") String id) {
//    }
    
}
