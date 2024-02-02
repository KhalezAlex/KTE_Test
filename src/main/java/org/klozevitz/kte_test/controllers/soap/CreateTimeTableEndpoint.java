package org.klozevitz.kte_test.controllers.soap;

import io.spring.guides.gs_producing_web_service.CreateTimeTableRequest;
import io.spring.guides.gs_producing_web_service.CreateTimeTableResponse;
import lombok.RequiredArgsConstructor;
import org.klozevitz.kte_test.util.TimeTableResolver;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Не получилось решить проблему пространства имен, но метод работает,
 * если убрать метки tns перед свойствами
 * (тестировал в постмене- может, это глюк... потому что, все перепробовал)
 * В README файле будет пример вызова, который генерируется на основе WSDL-ки
 * и пример вызова, который проходит- разница только в пространстве имен.
 * Защиту от дурака не успел сделать, поэтому формат ввода данных строгий:
 * дата начала расписания - "YYYY-MM-DD"
 * время начала и окончания рабочего дня- "HH-MM"
 * сначала решил заморочиться с кварцеванием, но с наскока не получилось. оставил, чтобы продолжить.
 * Задание вызвало интерес
 *
 * В поле класса лежит сервис- TimeTableResolver, который занимается заполнением расписания
 * */

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