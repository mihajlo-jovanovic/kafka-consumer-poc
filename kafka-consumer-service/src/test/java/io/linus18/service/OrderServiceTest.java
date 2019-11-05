package io.linus18.service;

import io.linus18.model.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = "io.linus18:order-api-producer-external:1.0-SNAPSHOT")
public class OrderServiceTest {

  private OrderService orderService;

  @StubRunnerPort("order-api-producer-external")
  int port;

  @Before
  public void setup() {
    orderService = new OrderService("http://localhost:" + port);
  }

  @Test
  public void getOrder() {
    Order order = orderService.getOrder(1l);
    assertEquals(Integer.valueOf(1), order.getId());
    assertEquals("Some Order", order.getName());
  }
}