package com.barrosoc;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Consumes(MediaType.APPLICATION_JSON)
@Path("/juice-maker")
public class JuiceMakerResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response makeJuice(String fruit) {
        return Response.status(Status.CREATED).build();
    }

}
