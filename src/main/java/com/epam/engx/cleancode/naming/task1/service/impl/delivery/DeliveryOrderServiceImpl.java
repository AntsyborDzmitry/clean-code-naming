package com.epam.engx.cleancode.naming.task1.service.impl.delivery;

import com.epam.engx.cleancode.naming.task1.service.OrderService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.*;

public class DeliveryOrderServiceImpl implements OrderService {

    private DeliveryService deliveryService;

    private OrderFulfilmentService orderFulfilmentService;

    public void submit(Order order) {
        if (deliveryService.isDeliverable(order)) {
            orderFulfilmentService.fulfilProducts(order.getProducts());
            return;
        }
        throw new NotDeliverableOrderException();
    }

    public void setDeliveryService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    public void setOrderFulfilmentService(OrderFulfilmentService orderFulfilmentService) {
        this.orderFulfilmentService = orderFulfilmentService;
    }
}
