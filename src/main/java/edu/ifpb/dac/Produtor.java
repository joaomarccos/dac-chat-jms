package edu.ifpb.dac;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSRuntimeException;
import javax.jms.Message;
import javax.jms.Queue;

/**
 *
 * @author Ricardo Job
 */
@Stateless
@LocalBean
public class Produtor {

    @Inject
    private JMSContext context;

    @Resource(lookup = "java:global/jms/demoQueue")
    Queue queue;

    public void enviarMensagem(String body) {
        try {
            Message mensagem = context.createTextMessage(body);
            mensagem.setStringProperty("MessageFormat", "Version 3.4");
            context.createProducer().send(queue, mensagem);
        } catch (JMSRuntimeException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (JMSException ex) {
            Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
