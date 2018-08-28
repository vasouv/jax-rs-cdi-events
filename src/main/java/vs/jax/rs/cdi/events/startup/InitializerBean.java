package vs.jax.rs.cdi.events.startup;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import vs.jax.rs.cdi.events.entity.Message;
import vs.jax.rs.cdi.events.service.MessageService;

/**
 *
 * @author vasouv
 */
@Startup
@Singleton
public class InitializerBean {

    @Inject
    private MessageService messageService;

    @PostConstruct
    public void init() {

        Message first = new Message("I am the first message!");
        Message second = new Message("Second message here we go!!!");
        Message third = new Message("Anyone called?");

        messageService.create(first);
        messageService.create(second);
        messageService.create(third);

    }

}
