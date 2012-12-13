package org.linagora.webservice;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.linagora.dao.CarDAO;
import org.linagora.dao.InMemoryCarDAO;
import org.linagora.dto.Car;


@Path("/")
public class RentCar {
    private static CarDAO carDAO = new InMemoryCarDAO();

    @POST
    @Path("/create/{param}")
    public Response createCars(@PathParam("param") Integer numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            Car car = new Car();
            carDAO.add(car);
        }

        return Response.status(201).build();
    }

    @POST
    @Path("/rent")
    public Response rentCar() {
        Car car = carDAO.findAvailableCar();
        if(car!=null) carDAO.rent(car);
        return Response.status(200).build();
    }

    @GET
    @Path("/availableCars")
    public Response getAvailableCars() {
        int availableCars = carDAO.getNumberOfAvailableCars();
        return Response.status(200).entity("" + availableCars).build();
    }
}
