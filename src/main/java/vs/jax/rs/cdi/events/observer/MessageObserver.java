package vs.jax.rs.cdi.events.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;

/**
 *
 * @author vasouv
 */
@Named
@ApplicationScoped
public class MessageObserver {

    private static final Logger LOG = Logger.getLogger(MessageObserver.class.getName());

    private List<String> createdMessages = new ArrayList<>();

    private void addToMessages(@Observes String messageTitle) {
        
        LOG.info("MessageObserver: Observed the event");
        
        createdMessages.add(messageTitle);
        
        LOG.info("MessageObserver: Added the message to the list");
    }

    public List<String> getCreatedMessages() {
        return createdMessages;
    }

}
