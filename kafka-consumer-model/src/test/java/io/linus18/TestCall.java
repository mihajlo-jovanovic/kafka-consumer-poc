package io.linus18;

import io.linus18.api.DefaultApi;
import io.linus18.client.ApiClient;
import io.linus18.model.Order;
import org.junit.Ignore;
import org.junit.Test;

public class TestCall {
  @Test
  @Ignore
  public void call() {
    ApiClient apiClient = new ApiClient();
    apiClient.setBasePath("http://127.0.0.1:9999");
    DefaultApi defaultApi = new DefaultApi(apiClient);
    Order order = defaultApi.getOrder(1l);
    System.out.println(order.getId() + ":" + order.getName());
  }
}
