package com.rabbitmq.cosumer.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class BasicListener implements MessageListener {

  private Logger log = LoggerFactory.getLogger(BasicListener.class);

  @Override
  public void onMessage(Message message) {
    try {
      String messageBody = new String(message.getBody(), "UTF-8");
      log.info("Mensagem: "+ messageBody);
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }
}
