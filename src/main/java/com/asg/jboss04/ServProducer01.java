package com.asg.jboss04;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/")
public class ServProducer01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    Producer01 producer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // super.doGet(req, resp);
        producer.sendMsg("first hello from jboss server.");
        resp.getWriter().write("sent a message from jboss server via jms");


    }
    
    
}
