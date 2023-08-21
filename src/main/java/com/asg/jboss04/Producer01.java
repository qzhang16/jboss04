package com.asg.jboss04;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
@LocalBean
public class Producer01 {

    @Resource(mappedName="java:/queue/myQueue")
    Queue queue01;

    @Inject
    JMSContext jmsContext;
    
    public void sendMsg(String msg) {
        jmsContext.createProducer().send(queue01, msg);
    }
    
}
