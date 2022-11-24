package com.epam.engx.cleancode.naming.task1.service.impl.collection;

import com.epam.engx.cleancode.naming.task1.service.OrderService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.CollectionService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Message;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.NotificationManager;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Order;

public class CollectionOrderServiceImpl implements OrderService {

    private static final int NOTIFICATION_LEVEL_INFO = 4;
    private static final int NOTIFICATION_LEVEL_CRITICAL = 1;

    private CollectionService collectionService;
    private NotificationManager notificationManager;

    public void submit(Order order) {
        if (collectionService.isEligibleForCollection(order)) {
            notificationManager.notifyCustomer(Message.READY_FOR_COLLECT, NOTIFICATION_LEVEL_INFO);
            return;
        }
        notificationManager.notifyCustomer(Message.IMPOSSIBLE_TO_COLLECT, NOTIFICATION_LEVEL_CRITICAL);
    }

    public void setCollectionService(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    public void setNotificationManager(NotificationManager notificationManager) {
        this.notificationManager = notificationManager;
    }
}
