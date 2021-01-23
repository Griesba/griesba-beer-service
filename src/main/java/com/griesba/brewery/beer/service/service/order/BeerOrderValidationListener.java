package com.griesba.brewery.beer.service.service.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.griesba.brewery.beer.service.config.JmsConfig;
import com.griesba.brewery.model.BeerOrderDto;
import com.griesba.brewery.model.events.ValidateBeerOrderRequest;
import com.griesba.brewery.model.events.ValidateOrderResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import static com.griesba.brewery.beer.service.config.JmsConfig.VALIDATE_ORDER_QUEUE;

@RequiredArgsConstructor
@Component
@Slf4j
public class BeerOrderValidationListener {

    private final BeerOrderRequestValidator beerOrderRequestValidator;
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = VALIDATE_ORDER_QUEUE)
    public void listen(ValidateBeerOrderRequest validateBeerOrderRequest) {
        boolean isValid = beerOrderRequestValidator.validate(validateBeerOrderRequest.getBeerOrderDto());
        try {
            log.info(new ObjectMapper().writeValueAsString(validateBeerOrderRequest));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        log.info("Order validation request for beerOrder Id {}", validateBeerOrderRequest.getBeerOrderDto().getId());

        jmsTemplate.convertAndSend(
                JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE,
                new ValidateOrderResult.ValidateOrderResultBuilder()
                        .withIsValid(isValid)
                        .withOrderId(validateBeerOrderRequest.getBeerOrderDto().getId()).build());
    }
}
