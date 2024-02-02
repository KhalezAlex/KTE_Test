package org.klozevitz.kte_test.controllers;

import io.spring.guides.gs_producing_web_service.CreateTimeTableRequest;
import io.spring.guides.gs_producing_web_service.CreateTimeTableResponse;
import lombok.RequiredArgsConstructor;
import org.klozevitz.kte_test.util.TimeTableResolver;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
@RequiredArgsConstructor
public class CreateTimeTableEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private final TimeTableResolver resolver;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createTimeTableRequest")
    @ResponsePayload
    public CreateTimeTableResponse createTimeTableResponse(@RequestPayload CreateTimeTableRequest request) {
        CreateTimeTableResponse response = new CreateTimeTableResponse();
        resolver.generate(request);
        response.setCode(200);
        return response;
    }
}