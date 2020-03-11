import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import javax.jws.Oneway;
import javax.xml.ws.Response;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class UserLogin {
    private static Brugeradmin ba;

    // @Path("brugerLogin")

    public static Bruger verificerLogin(String request) {

        JSONObject jsonObject = new JSONObject(request);
        String brugernavn = jsonObject.getString("brugernavn");
        String adgangskode = jsonObject.getString("adgangskode");
        try {
            ba = (Brugeradmin) Naming.lookup(Brugeradmin.URL);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Bruger bruger = null;
        try {
            bruger = ba.hentBruger(brugernavn, adgangskode);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return bruger;
    }
}
