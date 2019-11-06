package io.linus18.stream;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {
  @KafkaListener(topics = "orders", groupId = "foo")
  public void orderListener(String order) {
    System.out.println("Got a message: " + order);
  }
}
