package vs.jax.rs.cdi.events.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import vs.jax.rs.cdi.events.entity.Message;

/**
 *
 * @author vasouv
 */
@Stateless
public class MessageService {

    @PersistenceContext
    private EntityManager em;

    public List<Message> findAll() {
        return em.createNamedQuery("Message.findAll").getResultList();
    }

    public Message find(Long id) {
        return em.find(Message.class, id);
    }

    public void create(Message m) {
        em.persist(m);
    }

}
