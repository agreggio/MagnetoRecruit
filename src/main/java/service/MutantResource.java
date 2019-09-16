package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Dna;
import com.google.gson.*;
import controller.Mutant;
import utils.ValidDna;

@Path("/isMutant")
public class MutantResource {

    @GET
    public Response get() {

        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response isMutant(String dnaStr) {

        try {

            Gson gson = new Gson();
            //String to Dna  
            Dna dna = gson.fromJson(dnaStr, Dna.class);

            String[] Auxdna = new String[dna.getDna().length];
            //Dna to StringArray
            System.arraycopy(dna.getDna(), 0, Auxdna, 0, dna.getDna().length);

            if (ValidDna.isValidDna(Auxdna)) {

                if (Mutant.isMutant(Auxdna)) {
                    return Response.status(Response.Status.OK).build();
                } else {
                    return Response.status(Response.Status.FORBIDDEN).build();
                }

            } else {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        
        } catch (RuntimeException e) {

            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
}
