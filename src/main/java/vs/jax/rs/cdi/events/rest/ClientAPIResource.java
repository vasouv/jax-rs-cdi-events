package vs.jax.rs.cdi.events.rest;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import vs.jax.rs.cdi.events.service.ClientAPIExample;

/**
 *
 * @author vasouv
 */
@Path("clientapi")
public class ClientAPIResource {

    @Inject
    private ClientAPIExample clientAPIExample;

    @GET
    public JsonArray fetchTodos() {
        return clientAPIExample.fetchTodos();
    }

}
