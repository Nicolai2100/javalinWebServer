package resources;

import server.rmi.IGalgelegRMI;


import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

//@Path("/galgeleg")
public class GalgelegResource {
    private static IGalgelegRMI server;

    /*@POST
    @Path("/{brugernavn}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)*/
  /*  public String startGalgeleg(@PathParam("brugernavn") String brugernavn) {
        try {
            System.out.println("Forbinder til " + IGalgelegRMI.URL);
            server = (IGalgelegRMI) Naming.lookup(IGalgelegRMI.URL);
            System.out.println("Forbundet til serveren");
            String spilStatus = server.startSpil(brugernavn);
            return Response.ok().entity(spilStatus).build();
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            return Response.status(404).build();
        }
    }
*/
 /*   @GET
    @Path("/{brugernavn}/{bogstav}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response gaetPaaBogstav(@PathParam("brugernavn") String brugernavn, @PathParam("bogstav") String bogstav) {
        try {
            String spilStatus = server.gaetBogstav(bogstav.charAt(0), brugernavn);
            return Response.ok().entity(spilStatus).build();
        } catch (IOException | IllegalArgumentException e) {
            return Response.status(404).entity("Key: bogstav findes ikke").build();
        }
    }
*/

    public static List<String> getHighscoreListe() {
        List<String> highscore = null;
        try {
            if (server == null) connectToServer();
            highscore = server.getHighscoreList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return highscore;
    }

    private static void connectToServer() {
        try {
            server = (IGalgelegRMI) Naming.lookup(IGalgelegRMI.URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
