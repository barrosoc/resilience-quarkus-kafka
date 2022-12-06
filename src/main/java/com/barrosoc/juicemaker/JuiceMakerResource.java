package com.barrosoc.juicemaker;

import javax.inject.Inject;
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

    @Inject
    JuiceMakerService juiceMakerService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response makeJuice(String fruit) {
        juiceMakerService.makeJuice(fruit);
        return Response.status(Status.CREATED).build();
    }

}
