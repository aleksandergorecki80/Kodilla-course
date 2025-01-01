package com.kodilla.good.patterns.challenges;

public class OrderProcessor {
  private final NotificationService notificationService;
  private final OrderService orderService;
  private final OrderRepository orderRepository;

  public OrderProcessor(final NotificationService notificationService, final OrderService orderService, final OrderRepository orderRepository) {
    this.notificationService = notificationService;
    this.orderService = orderService;
    this.orderRepository = orderRepository;
  }

  public OrderDto process(final OrderRequest orderRequest) {
    boolean isPlaced = orderService.addOrder(orderRequest);
    if (isPlaced) {
      notificationService.sendNotification(orderRequest.getUser());
      orderRepository.createOrder(orderRequest);
      return new OrderDto(orderRequest.getUser(), true);
    }
    return new OrderDto(orderRequest.getUser(), false);
  }

}
