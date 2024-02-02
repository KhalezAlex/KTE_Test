package org.klozevitz.kte_test.controllers;

import io.spring.guides.gs_producing_web_service.CreateTimeTableRequest;
import io.spring.guides.gs_producing_web_service.CreateTimeTableResponse;
import io.spring.guides.gs_producing_web_service.ObjectFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;


@Endpoint
public class CreateTimeTableEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createTimeTableRequest")
    @ResponsePayload
    public CreateTimeTableResponse createTimeTableResponse(@RequestPayload CreateTimeTableRequest request) {
        CreateTimeTableResponse response = new CreateTimeTableResponse();
        response.setCode(200);
        System.out.println("Наконец-то");
//        ObjectFactory factory = new ObjectFactory();
//        JAXBElement<CreateTimeTableResponse> element = factory.createCreateTimeTableResponse();
        return response;
    }
}