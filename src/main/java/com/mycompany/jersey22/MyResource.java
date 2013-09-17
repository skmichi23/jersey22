package com.mycompany.jersey22;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("myresource")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    /**
     * In this case method accepts String and then parses it into Reservation
     * object using ObjectMapper
     *
     * @param s
     * @return
     * @throws IOException
     */
    @POST
    @Path("working")
    @Consumes(MediaType.APPLICATION_JSON)
    public String process1(String s) throws IOException {

        ObjectMapper om = new ObjectMapper();
        Reservation r = om.readValue(s, Reservation.class);

        Map<String, Object> params = r.getParams();
        return String.valueOf(params.size());
    }

    /**
     * In this case I expect the data sent in POST request will be parsed into
     * Reservation object automatically. This is true for the "name" property of
     * Reservation, but "params" map remains empty.
     *
     * @param r
     * @return
     */
    @POST
    @Path("notworking")
    @Consumes(MediaType.APPLICATION_JSON)
    public String process1(Reservation r) {

        Map<String, Object> params = r.getParams();
        if (params != null) {
            return String.valueOf(params.size());
        } else {
            return "EMPTY!!";
        }
    }
}
