package vs.jax.rs.cdi.events.rest;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
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

    @GET
    @Path("{id}")
    public Message find(@PathParam("id") Long id) {
        Message found = messageService.find(id);
        if (found == null) {
            LOG.warning("Message was not found... Throwing exception");
            throw new NotFoundException("ID was incorrect, no Message was found");
        }
        return found;
    }

    @GET
    @Path("exception")
    public Response notFound() {
        Message found = messageService.find(0L);
        if (found == null) {
            LOG.warning("Message was not found... Throwing exception");
            throw new NotFoundException("Message was not found... Check the ID");
        }
        return Response.ok(found).build();
    }

    @POST
    public void create(Message message) {
        messageService.create(message);

        LOG.info("REST: Firing the create message event");
        messageEvent.fire(message.getTitle());
    }

}
