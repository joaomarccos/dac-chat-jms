package edu.ifpb.dac.mdb.topic;

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
@MessageDriven(
        mappedName = "java:global/jms/demoTopic",
        activationConfig = {
            @ActivationConfigProperty(propertyName = "destinationType",
                    propertyValue = "javax.jms.Topic"),
//            @ActivationConfigProperty(propertyName = "subscriptionDurability",
//                    propertyValue = "Durable"),
            @ActivationConfigProperty(propertyName = "messageSelector",
//                    propertyValue = "MessageFormat = 'Version 3.1'")
                    propertyValue = "MessageFormat = 'Version 3.4'")
        })
public class SegundoConsumidorTopicAsync implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage tm = (TextMessage) message;
            System.out.println("Chegou: " + tm.getText());
        } catch (JMSException ex) {
            Logger.getLogger(SegundoConsumidorTopicAsync.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
