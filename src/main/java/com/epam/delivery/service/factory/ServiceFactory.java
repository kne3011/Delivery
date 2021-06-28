package com.epam.delivery.service.factory;

import com.epam.delivery.service.*;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {

  private static final Map<String, Service> SERVICE_MAP = new HashMap<>();
  private static final ServiceFactory SERVICE_FACTORY = new ServiceFactory();

  private ServiceFactory() {
  }

  static {
    SERVICE_MAP.put("/DeliveryController/register", new RegistrationService());
    SERVICE_MAP.put("/DeliveryController/login", new LoginService());
    SERVICE_MAP.put("/DeliveryController/main", new LoadMainService());
    SERVICE_MAP.put("/DeliveryController/search", new LoadSearchService());
    SERVICE_MAP.put("/DeliveryController/my_basket", new LoadBasketService());
    SERVICE_MAP.put("/DeliveryController/my_history", new LoadHistoryService());
    SERVICE_MAP.put("/DeliveryController/logout", new LogoutService());
    SERVICE_MAP.put("/DeliveryController/buy", new BuyService());
    SERVICE_MAP.put("/DeliveryController/clearBasket", new ClearService());
    SERVICE_MAP.put("/DeliveryController/teg/create", new CreateTegService());
    SERVICE_MAP.put("/DeliveryController/teg/update", new UpdateTegService());
    SERVICE_MAP.put("/DeliveryController/teg/delete", new DeleteTegService());
    SERVICE_MAP.put("/DeliveryController/product/create", new CreateProductService());
    SERVICE_MAP.put("/DeliveryController/product/update", new UpdateProductService());
    SERVICE_MAP.put("/DeliveryController/product/delete", new DeleteProductService());
    SERVICE_MAP.put("/DeliveryController/product/teg/add", new AddTegToProductService());
    SERVICE_MAP.put("/DeliveryController/product/teg/delete", new DeleteTegToProductService());
    SERVICE_MAP.put("/DeliveryController/addToCurt", new AddToCurtService());
    SERVICE_MAP.put("/ERROR", new ErrorService());
  }
  public Service getService(String request) {
    Service service = SERVICE_MAP.get("/ERROR");
    System.out.println(request);
    for (Map.Entry<String, Service> pair : SERVICE_MAP.entrySet()) {
      if (request.equalsIgnoreCase(pair.getKey())) {
        service = SERVICE_MAP.get(pair.getKey());
      }
    }
    return service;
  }

  public static ServiceFactory getInstance() {
    return SERVICE_FACTORY;
  }
}
