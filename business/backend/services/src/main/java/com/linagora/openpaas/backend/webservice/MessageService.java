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

import org.apache.shiro.SecurityUtils;

import com.linagora.openpaas.backend.dto.MessageVO;
import com.linagora.openpaas.backend.dto.UserVO;
import com.linagora.openpaas.backend.service.ManageMessageService;
import com.linagora.openpaas.backend.service.ManageMessageServiceImpl;
import com.linagora.openpaas.backend.service.ManageUserService;
import com.linagora.openpaas.backend.service.ManageUserServiceImpl;


@Path("/messageService")
public class MessageService{
   
    private static ManageMessageService manageMessage = new ManageMessageServiceImpl();
    private static ManageUserService manageUser = new ManageUserServiceImpl();

    @POST
    @Path("/message")
    public void createMessage(@FormParam(value="body") String body, @FormParam(value="subject")String subject) {
    	MessageVO message = new MessageVO();
    	message.setBody(body);
    	message.setSubject(subject);
    	UserVO u =  manageUser.getUser(SecurityUtils.getSubject().getPrincipal().toString());
    	manageMessage.create(message,u);
    }

    @GET
    @Path("/messages")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MessageVO> getAvailableMessages() {
    	UserVO u =  manageUser.getUser(SecurityUtils.getSubject().getPrincipal().toString());
        return  manageMessage.findAvailableMessage(u);
    }
    
    @GET
    @Path("/messages/number")
    @Produces(MediaType.APPLICATION_JSON)
    public int getMessagesNumber() {
    	UserVO u =  manageUser.getUser(SecurityUtils.getSubject().getPrincipal().toString());
        return  manageMessage.getMessagesNumber(u);
    }
    
    @GET
    @Path("/message/{mesgid}")
    public MessageVO findMessage(@PathParam("mesgid") String id) {
    	UserVO u =  manageUser.getUser(SecurityUtils.getSubject().getPrincipal().toString());
        MessageVO m =  manageMessage.getMessage(id,u);
        if (m == null) {
        	throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity("message id not found").build());
        }
        
        return m;
    }
    
}
