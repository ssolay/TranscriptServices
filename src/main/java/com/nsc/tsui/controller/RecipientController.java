package com.nsc.tsui.controller;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.nsc.tsui.model.School;
import com.nsc.tsui.model.Views;
import com.nsc.tsui.model.generated.RecipientOrganization;
import com.nsc.tsui.model.generated.SchoolProfile;
import com.nsc.tsui.model.mvn.generated.RequestPostRecipient;
import com.nsc.tsui.service.TSUIRequestBuilder;
import com.nsc.tsui.service.TSUIService;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.http.entity.ContentType.MULTIPART_FORM_DATA;

@RestController
@RequestMapping("/api/recipient-organization")
public class RecipientController {

    public static final Logger logger = LoggerFactory.getLogger(RecipientController.class);

    public static final String RECIPIENT_ORGANIZATION_BY_INSTITUION_ENDPOINT = "/institution";
    public static final String RECIPIENT_ORGANIZATION_BY_EO_ENDPOINT = "/eo";
    public static final String RECIPIENT_ORGANIZATION_BY_STATE_ENDPOINT = "/state";
    public static final String POST_RECIPIENTS_ENDPOINT = "/recipients";
    public static final String RECIPIENT_EXCHANGE_DETAILS_ENDPOINT = "/exchange-detail";
    public static final String POST_ATTACHMENT_ENDPOINT = "/attachment";

    @Autowired
    TSUIRequestBuilder tsuiRequestBuilder;

    @Autowired
    TSUIService tsuiService;

    @Value("${nsc.recipient.organization.endpoint}")
    private String recipientOrganization;

    @Value("${nsc.order.information}")
    private String orderInformationEndpoint;

    @Value("${nsc.exchange.detail.endpoint}")
    private String exchangeDetailsEndpoint;

    ObjectMapper objectMapper = new ObjectMapper();

//    @Cacheable("recipient-organization-institution")
    @GetMapping(value = RECIPIENT_ORGANIZATION_BY_INSTITUION_ENDPOINT, produces = MediaType.APPLICATION_JSON)
    public @ResponseBody String findByInstitution() throws IOException {
        String responseBody = tsuiService.callWebService(tsuiRequestBuilder.buildGet(recipientOrganization +
                RECIPIENT_ORGANIZATION_BY_INSTITUION_ENDPOINT));
        return objectMapper.writerWithView(Views.WebApp.class)
                .writeValueAsString(objectMapper.readValue(responseBody,
                        new TypeReference<List<RecipientOrganization>>(){}));
    }

//    @Cacheable("recipient-organization-eo")
    @GetMapping(value = RECIPIENT_ORGANIZATION_BY_EO_ENDPOINT, produces = MediaType.APPLICATION_JSON)
    public @ResponseBody String findByEo() throws IOException {
        List<RecipientOrganization> recipientOrganizations =
                objectMapper.readValue(tsuiService.callWebService(tsuiRequestBuilder.buildGet(recipientOrganization +
                                RECIPIENT_ORGANIZATION_BY_EO_ENDPOINT)),
                        new TypeReference<List<RecipientOrganization>>(){});
        return objectMapper.writerWithView(Views.WebApp.class).writeValueAsString(recipientOrganizations);
    }

    @GetMapping(value = RECIPIENT_ORGANIZATION_BY_INSTITUION_ENDPOINT +
            RECIPIENT_ORGANIZATION_BY_STATE_ENDPOINT + "/{stateCode}", produces = MediaType.APPLICATION_JSON)
    public @ResponseBody String findInstitutionByState(@PathVariable("stateCode") String stateCode) throws IOException {
        List<RecipientOrganization> recipientOrganizations =
                objectMapper.readValue(tsuiService.callWebService(tsuiRequestBuilder.buildGet(recipientOrganization +
                                RECIPIENT_ORGANIZATION_BY_INSTITUION_ENDPOINT)),
                        new TypeReference<List<RecipientOrganization>>(){});
        return objectMapper.writerWithView(Views.WebApp.class).writeValueAsString(recipientOrganizations
                .stream()
                .filter(x -> stateCode.equalsIgnoreCase(x.state))
                .collect(Collectors.toList()));
    }

    @Metered(name = "post-recipient-metered")
    @Timed(name = "post-recipient-ws-timed")
    @PostMapping(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public @ResponseBody String postRecipients(@RequestBody List<RequestPostRecipient> requestPostRecipient) throws IOException {
        logger.debug(" post recipients request {} | ", requestPostRecipient);
        String rawResponse = tsuiService.callWebService(
                tsuiRequestBuilder.buildPost(orderInformationEndpoint + "/" +
                                requestPostRecipient.get(0).getToOrderId() +
                                POST_RECIPIENTS_ENDPOINT,
                        new StringEntity(objectMapper.writeValueAsString(requestPostRecipient))));
        return rawResponse;
    }

    @Metered(name = "get-exchange-details-metered")
    @Timed(name = "get-exchange-details-ws-timed")
    @GetMapping(value = RECIPIENT_EXCHANGE_DETAILS_ENDPOINT + "/{orderId}/{orgId}", produces = MediaType.APPLICATION_JSON)
    public @ResponseBody String getExchangeDetails(@PathVariable("orderId") String orderId,
                                                   @PathVariable("orgId") String orgId){
        return tsuiService.callWebService(tsuiRequestBuilder.buildGet(
                exchangeDetailsEndpoint +
                        "/" + orderId +
                        "/" + orgId));
    }

    @GetMapping(value = RECIPIENT_EXCHANGE_DETAILS_ENDPOINT + "/{orgId}", produces = MediaType.APPLICATION_JSON)
    public @ResponseBody String getExchangeDetailsWithoutOrder(@PathVariable("orgId") String orgId){
        return tsuiService.callWebService(tsuiRequestBuilder.buildGet(
                exchangeDetailsEndpoint +
                        "/" + orgId));
    }

    @Metered(name = "post-recipient-metered")
    @Timed(name = "post-recipient-ws-timed")
    @PostMapping(value = POST_ATTACHMENT_ENDPOINT, produces = MediaType.APPLICATION_JSON)
    public @ResponseBody String postAttachmen(@ModelAttribute MultipartFile file) throws IOException {
        logger.debug("file posted | {}", file);
//        File attachment = new File(file.getOriginalFilename());
//        attachment.createNewFile();
//        file.transferTo(attachment);

        String response = tsuiService.postFile(tsuiRequestBuilder.buildPost(
                POST_ATTACHMENT_ENDPOINT, file.getBytes()));
        return response;
    }
}
