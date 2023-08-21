package com.asg.jboss04;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "MDB01", activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/myQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "acknowledge", propertyValue = "Auto-acknowledge")
})
public class MDB01 implements MessageListener {
    private static Logger LOGGER = Logger.getLogger(MDB01.class.toString());

    @Override
    public void onMessage(Message arg0) {
        if (arg0 instanceof TextMessage) {
            TextMessage msg = (TextMessage) arg0;
            try {
                LOGGER.info("Received message: " + msg.getText());
            } catch (JMSException e) {
                
                e.printStackTrace();
            }
        }
        
    }
    
}
