package io.linus18.service;

import io.linus18.api.DefaultApi;
import io.linus18.model.Order;
import io.linus18.client.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  private io.linus18.api.DefaultApi client;

  public OrderService(@Value("io.linus18.consumer.url") final String url) {
    final ApiClient apiClient = new ApiClient();
    apiClient.setBasePath(url);
    client = new DefaultApi(apiClient);
  }

  public Order getOrder(final Long id) {
    return client.getOrder(id);
  }

}
