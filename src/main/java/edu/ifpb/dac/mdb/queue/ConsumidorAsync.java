package edu.ifpb.dac.mdb.queue;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Ricardo Job
 */
<<<<<<< HEAD:src/main/java/edu/ifpb/dac/ReceberAsync.java
//@MessageDriven(mappedName = "java:global/jms/demoQueue")
@MessageDriven(
        mappedName = "java:global/jms/demoQueue",
        activationConfig = {
            @ActivationConfigProperty(propertyName = "destinationType",
                    propertyValue = "javax.jms.Queue")
        })
public class ReceberAsync implements MessageListener {
=======
@MessageDriven(mappedName = "java:global/jms/demoQueue")
//@MessageDriven(
//        mappedName = "java:global/jms/demoQueue",
//        activationConfig = {
//            @ActivationConfigProperty(propertyName = "destinationType",
//                    propertyValue = "javax.jms.Queue"),
//            @ActivationConfigProperty(propertyName = "messageSelector",
//                    propertyValue = "MessageFormat = 'Version 3.4'")
//        })
public class ConsumidorAsync implements MessageListener {
>>>>>>> 5d854149af3ab55895d13004358865462326f03a:src/main/java/edu/ifpb/dac/mdb/queue/ConsumidorAsync.java

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage tm = (TextMessage) message;
            System.out.println("Mensagem Recebida: " + tm.getText());
        } catch (JMSException ex) {
            Logger.getLogger(ConsumidorAsync.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
