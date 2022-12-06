package com.barrosoc.fruit.gateway;

import javax.ws.rs.Consumes;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/juice-maker")
@RegisterRestClient(configKey = "juice-maker")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface JuiceMakerGateway {

    @POST
    void makeJuice(@RequestBody String fruit);

}
