package edu.ifpb.dac.mdb.topic;

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
import javax.jms.Topic;

/**
 *
 * @author job
 */
@Stateless
@LocalBean
public class ProdutorTopic {

    @Inject
    private JMSContext context;

    @Resource(lookup = "java:global/jms/demoTopic")
    Topic canalDeDestino;

    public void enviarMensagem(String body) {
        try {
            Message mensagem = context.createTextMessage(body);
            mensagem.setStringProperty("MessageFormat", "Version 3.4");
            context.createProducer().send(canalDeDestino, mensagem);
        } catch (JMSRuntimeException ex) {
            Logger.getLogger(ProdutorTopic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JMSException ex) {
            Logger.getLogger(ProdutorTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
