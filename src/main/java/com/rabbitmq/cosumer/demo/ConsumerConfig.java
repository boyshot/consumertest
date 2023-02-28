package com.rabbitmq.cosumer.demo;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {

  @Autowired
  private ConnectionFactory connectionFactory;
  @Autowired
  private BasicListener basicListener;

  @Autowired
  private SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory;

  @Bean
  public MessageListenerContainer listenerContainer()  {
    var container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    container.setQueueNames("Fila_001");
    container.setMessageListener(basicListener);
    return container;
  }
}
