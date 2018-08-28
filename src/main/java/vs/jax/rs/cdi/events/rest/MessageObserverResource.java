package vs.jax.rs.cdi.events.rest;

import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import vs.jax.rs.cdi.events.observer.MessageObserver;

/**
 *
 * @author vasouv
 */
@Path("observed")
public class MessageObserverResource {

    private static final Logger LOG = Logger.getLogger(MessageObserverResource.class.getName());

    @Inject
    private MessageObserver dummyObserver;

    @GET
    public List<String> createdMessages() {
        LOG.info("Observed REST: Retrieving created messages");
        return dummyObserver.getCreatedMessages();
    }

}
