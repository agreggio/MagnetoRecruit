package api;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Dna;
import com.google.gson.*;
import controler.Mutant;


@Path("/isMutant")
public class MutantResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.TEXT_PLAIN)
    public String get() {

        return "Solo se reciben metodo post";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response isMutant(String dnaStr) {
        Gson gson = new Gson();
        Dna dna = gson.fromJson(dnaStr, Dna.class);
        String[] Auxdna = new String[dna.getDna().length];
        System.arraycopy(dna.getDna(), 0, Auxdna, 0, dna.getDna().length);

        if (Mutant.isMutant(Auxdna)) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

    }
}
