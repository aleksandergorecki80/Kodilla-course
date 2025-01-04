package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderFacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeWatcher.class);

    @AfterThrowing(value = "execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))", throwing = "exception")
    public void logException(OrderProcessingException exception) {
        LOGGER.error("Exception occurred: " + exception.getMessage());
    }

    @Before(value = "execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..)) && args(order, userId) && target(object)",
            argNames = "order,userId,object")
    public void logProcessedOrder(OrderDto order, Long userId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + "User ID: " + userId + " Order details: " + order);
    }

}
