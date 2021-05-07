package com.heasyapp;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.heasyapp.beans.User;

import org.bson.types.ObjectId;

@Path("/user")
public class UserResource {

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll() {
        return User.findAll().list();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getById(@PathParam("id") String id) {
        return Optional.<User>ofNullable(User.findById(new ObjectId(id))).orElseThrow(NotFoundException::new);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createUser(User usr, @Context UriInfo uri) {
        Optional<User> ul = User.find("email=?1 and cpf=?2", usr.email, usr.cpf).firstResultOptional();
        if(ul.isEmpty()) {
            usr.persist();
            return Response.ok(usr.id.toHexString()).build();
        }
        return Response.status(Status.CONFLICT).location(
            uri.getAbsolutePathBuilder().path(ul.get().id.toHexString()).build()
        ).build();
    }
    
}