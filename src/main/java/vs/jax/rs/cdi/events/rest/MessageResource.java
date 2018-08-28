package vs.jax.rs.cdi.events.rest;

import java.util.List;
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
public class MessageResource {

    @Inject
    private MessageService messageService;

    @GET
    public List<Message> findAll() {
        return messageService.findAll();
    }

    @POST
    public void create(Message message) {
        messageService.create(message);
    }

}
