package com.guptaji.resource;

import com.guptaji.entity.BankEntity;
import com.guptaji.service.BankService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/bank")
public class BankResource {

    public static final Logger LOG = Logger.getLogger(BankResource.class);

    // imp. link for logging https://quarkus.io/guides/logging
    
    // Info -- we used this logging to print general msgs.
    // logs printing configurability
    // if error is configured then only error logs will printed
    // if warn is configured then both warn and error will be print.
    // if info is configured (default) then error, warn and info logs will print.
    // if debug is configured then all 4 error, warn, info and debug will printed.
    // debug -- we used this logging to track or debug our application so in this we also print some data in logs.

    @Inject
    BankService bankService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBankDetails(){
        LOG.info("API Resource::getBankDetails() Hit");
        List<BankEntity> bankEntities = bankService.sendAllBankDetails();
        LOG.info("returning from API Resource::getBankDetails() with some response");
        LOG.debug("returning from API Resource::getBankDetails() with some response :: "+ bankEntities);
        return Response.ok(bankEntities).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertAddBankDetails(BankEntity bankEntity){
        LOG.info("API Resource::insertAddBankDetails() Hit");
        LOG.debug("API Resource::insertAddBankDetails() get some request to complete :: "+ bankEntity);
        List<BankEntity> bankEntities = bankService.addNewBank(bankEntity);
        LOG.info("API Resource::insertAddBankDetails() sending the response");
        LOG.debug("returning from API Resource::insertAddBankDetails() with some response :: "+ bankEntities);
        return Response.ok(bankEntities).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteBankDetails(BankEntity bankEntity){
        List<BankEntity> bankEntities = bankService.deleteBankDetailsFromServer(bankEntity);
        return Response.ok(bankEntities).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBankDetailsById(@PathParam("id") int id){
        LOG.info("API Resource::getBankDetailsById() Hit");
        LOG.debug("API Resource::getBankDetailsById() get some request to complete :: "+ id);
        BankEntity bankEntity = bankService.findBankDetailsById(id);
        if (bankEntity != null){
            LOG.info("returning from API Resource::getBankDetailsById() with some response");
            LOG.debug("returning from API Resource::getBankDetails() with some response :: "+ bankEntity);
            return Response.ok(bankEntity).build();
        } else {
            LOG.info("returning from API Resource::getBankDetailsById() but data corresponding to that ID is not found");
            LOG.debug("returning from API Resource::getBankDetails() with NULL response");
            LOG.warn("Data corresponding to that ID not found");
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }
}
