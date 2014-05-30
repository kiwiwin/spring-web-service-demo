package org.kiwi.spring.webservice;

import org.kiwi.spring.webservice.request.HelloRequest;
import org.kiwi.spring.webservice.request.HelloResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class HelloEndpoint {

    @PayloadRoot(namespace = "http://kiwi.org/schema/HelloRequest", localPart = "HelloRequest")
    public
    @ResponsePayload
    HelloResponse hello(@RequestPayload HelloRequest helloRequest) {
        HelloResponse helloResponse = new HelloResponse();
        helloResponse.setMessage("hello, " + helloRequest.getMessage());
        helloResponse.setFrom(helloRequest.getTo());
        helloResponse.setTo(helloRequest.getFrom());

        return helloResponse;
    }
}
