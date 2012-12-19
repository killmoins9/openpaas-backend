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

import com.linagora.openpaas.backend.dto.User;
import com.linagora.openpaas.backend.service.ManageUserService;
import com.linagora.openpaas.backend.service.ManageUserServiceImpl;


@Path("/userService")
public class UserService {
	
	private static ManageUserService manageUser = new ManageUserServiceImpl();
	
	
    @POST
    @Path("/user")
    public void createUser(@FormParam(value="login") String login, @FormParam(value="firstname")String firstname,
    		@FormParam(value="lastname") String lastname, @FormParam(value="mail") String mail) {
    	
    	User  u = new User();
    	u.setFirstname(firstname);
    	u.setLastname(lastname);
    	u.setLogin(login);
    	u.setMail(mail);
    	
    	manageUser.create(u);
    }

    
    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> findAll() {
        return  manageUser.findAll();
    }
    
    
    @GET
    @Path("/user/{userid}")
    public User findUser(@PathParam("userid") String id) {
    	User u  =  manageUser.getUser(id);
        if (u == null) {
        	throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity("user not found").build());
        }
        
        return u;
    }
    
}
