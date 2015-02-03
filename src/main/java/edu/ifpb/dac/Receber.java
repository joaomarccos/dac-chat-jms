package edu.ifpb.dac;

import java.util.Enumeration;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSRuntimeException;
import javax.jms.Queue;

/**
 *
 * @author Ricardo Job
 */
@Stateless
@LocalBean
public class Receber {

    @Inject
    @JMSConnectionFactory("java:global/jms/demoConnectionFactory") 
    private JMSContext context;
    @Resource(lookup = "java:global/jms/demoQueue")
    Queue inboundQueue;

    public String receberMensagem() {
        try {
            JMSConsumer consumer = context.createConsumer(inboundQueue);
            try {
                return "recebida " + consumer.receiveBody(String.class, 1000)
                        + "\n" + quantidade();
            } catch (JMSException ex) {
//                Logger.getLogger(Receber.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JMSRuntimeException ex) {
            // Logger.getLogger(JavaEESyncReceiverOld.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String quantidade() throws JMSException {
        int numMessages = 0;
        for (Enumeration queueEnumeration = context.createBrowser(inboundQueue).getEnumeration(); queueEnumeration.hasMoreElements();) {
            System.out.println("Recebendo: "+queueEnumeration.nextElement());
            numMessages++;
        }
        return "Foram recebidas: " + numMessages ;

    }
}
