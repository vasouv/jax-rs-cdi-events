package vs.jax.rs.cdi.events.rest;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import vs.jax.rs.cdi.events.entity.Message;
import vs.jax.rs.cdi.events.service.MessageService;

/**
 *
 * @author vasouv
 */
@Path("messages")
public class MessageResource implements Serializable {

    private static final Logger LOG = Logger.getLogger(MessageResource.class.getName());

    @Inject
    private MessageService messageService;

    @Inject
    private Event<String> messageEvent;

    @GET
    public List<Message> findAll() {
        return messageService.findAll();
    }

    @POST
    public void create(Message message) {
        messageService.create(message);
        
        LOG.info("REST: Firing the create message event");
        messageEvent.fire(message.getTitle());
    }

}
