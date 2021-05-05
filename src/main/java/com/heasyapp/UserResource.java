package com.heasyapp;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.heasyapp.beans.User;

@Path("/user")
public class UserResource {

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> hello() {
        return User.findAll().list();
    }

}