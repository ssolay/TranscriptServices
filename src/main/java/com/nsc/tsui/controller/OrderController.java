package com.nsc.tsui.controller;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsc.tsui.model.Views;
import com.nsc.tsui.model.mvn.generated.RequestPostConsentSignature;
import com.nsc.tsui.model.mvn.generated.RequestPostOrder;
import com.nsc.tsui.model.mvn.generated.ResponseGetOrder;
import com.nsc.tsui.service.TSUIRequestBuilder;
import com.nsc.tsui.service.TSUIService;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class OrderController {

    public static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    public static final String POST_CONCENT_ENDPOINT = "/consent-signature";

    @Autowired
    TSUIRequestBuilder tsuiRequestBuilder;

    @Autowired
    TSUIService tsuiService;

    @Value("${nsc.order.information}")
    private String orderInformationEndpoint;

    ObjectMapper objectMapper = new ObjectMapper();

    @Metered(name = "order-submit-metered")
    @Timed(name = "order-submit-ws-timed")
    @PostMapping(value = "/order", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public @ResponseBody String submitOrder(@RequestBody RequestPostOrder orderRequest) throws IOException {
        String responseBody = tsuiService.callWebService(tsuiRequestBuilder.buildPost(orderInformationEndpoint,
                new StringEntity(objectMapper.writeValueAsString(orderRequest))));
        logger.info("order response raw | {}", responseBody);
        return responseBody;
    }

    @Metered(name = "order-details-metered")
    @Timed(name = "order-details-ws-timed")
    @GetMapping(value = "/order/{id}", produces = MediaType.APPLICATION_JSON)
    public @ResponseBody String getOrderInformation(@PathVariable("id") String id) throws IOException {
        String response = tsuiService.callWebService(tsuiRequestBuilder.buildGet(orderInformationEndpoint +
                        "/"+id));
        logger.debug("found order | {}",response);
        return response;
    }

    @Metered(name = "post-concent-metered")
    @Timed(name = "post-concent-ws-timed")
    @PostMapping(value = "/consent/{orderId}", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public @ResponseBody String postCocent(@PathVariable("orderId") String orderId,
                                           @RequestBody RequestPostConsentSignature consentRequest) throws IOException {
        logger.debug(" post consent request {} | ", consentRequest);
        String rawResponse = tsuiService.callWebService(
                tsuiRequestBuilder.buildPost(orderInformationEndpoint + "/" +
                                orderId +
                                POST_CONCENT_ENDPOINT,
                        new StringEntity(objectMapper.writeValueAsString(consentRequest))));
        return rawResponse;
    }


}
