package com.nsc.tsui.controller;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsc.tsui.model.mvn.generated.RequestPostPayment;
import com.nsc.tsui.service.TSUIRequestBuilder;
import com.nsc.tsui.service.TSUIService;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.io.UnsupportedEncodingException;


@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    public static final Logger logger = LoggerFactory.getLogger(PaymentController.class);


    public static final String POST_PAYMENT_ENDPOINT = "/payment";

    @Autowired
    TSUIRequestBuilder tsuiRequestBuilder;

    @Autowired
    TSUIService tsuiService;

    @Value("${nsc.order.information}")
    private String orderInformationEndpoint;

    ObjectMapper objectMapper = new ObjectMapper();

    @Metered(name = "post-payment-metered")
    @Timed(name = "post-payment-ws-timed")
    @PostMapping(value = "/{orderId}", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public @ResponseBody String postPayment(@PathVariable("orderId") String orderId,
                                            @RequestBody RequestPostPayment requestPostPayment)
            throws JsonProcessingException, UnsupportedEncodingException {
        logger.debug(" post PAYMENT request {} | ", requestPostPayment);
        String rawResponse = tsuiService.callWebService(
                tsuiRequestBuilder.buildPost(orderInformationEndpoint + "/" +
                                orderId +
                                POST_PAYMENT_ENDPOINT,
                        new StringEntity(objectMapper.writeValueAsString(requestPostPayment))));
        return rawResponse;
    }
}
