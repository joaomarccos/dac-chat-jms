package edu.ifpb.dac;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Ricardo Job
 */
@MessageDriven(mappedName = "java:global/jms/demoQueue")
public class ReceberAsync implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage tm = (TextMessage) message;
            System.out.println("Mensagem Recebida: " + tm.getText());
        } catch (JMSException ex) {
//            Logger.getLogger(ReceberAsync.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
