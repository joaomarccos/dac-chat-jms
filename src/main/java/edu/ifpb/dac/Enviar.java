package edu.ifpb.dac;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSRuntimeException;
import javax.jms.Queue;

/**
 *
 * @author Ricardo Job
 */
@Stateless
@LocalBean
public class Enviar {

    @Inject
    private JMSContext context;

    @Resource(lookup = "java:global/jms/demoQueue")
    Queue queue;

    public void enviarMensagem(String body) {
        try {
            context.createProducer().send(queue, body);
        } catch (JMSRuntimeException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
}
