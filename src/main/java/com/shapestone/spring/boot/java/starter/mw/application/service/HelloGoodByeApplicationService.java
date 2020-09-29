package com.shapestone.spring.boot.java.starter.mw.application.service;

import com.shapestone.spring.boot.java.starter.mw.application.dto.HelloGoodByeRequest;
import com.shapestone.spring.boot.java.starter.mw.application.dto.HelloGoodByeResponse;
import com.shapestone.spring.boot.java.starter.mw.domain.model.GoodBye;
import com.shapestone.spring.boot.java.starter.mw.domain.model.Hello;
import com.shapestone.spring.boot.java.starter.mw.domain.service.GoodByeService;
import com.shapestone.spring.boot.java.starter.mw.domain.service.HelloService;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import org.springframework.beans.factory.annotation.Autowired;

import static io.reactivex.Single.zip;

@SuppressWarnings({"Convert2Lambda", "Convert2Diamond", "RedundantThrows"})
public class HelloGoodByeApplicationService {

    private final GoodByeService goodByeService;
    private final HelloService helloService;

    @Autowired
    public HelloGoodByeApplicationService(final GoodByeService goodByeService, final HelloService helloService) {
        this.goodByeService = goodByeService;
        this.helloService = helloService;
    }

    public Single<HelloGoodByeResponse> addHelloGoodBye(final HelloGoodByeRequest helloGoodByeRequest) {
        final Single<Hello> helloSingle = helloService.addHello(new Hello(helloGoodByeRequest.getHello()));
        final Single<GoodBye> goodByeSingle = goodByeService.addGoodBye(new GoodBye(helloGoodByeRequest.getGoodBye()));

        return zip(helloSingle, goodByeSingle,
        new BiFunction<Hello, GoodBye, HelloGoodByeResponse>() {
            @NonNull
            @Override
            public HelloGoodByeResponse apply(@NonNull final Hello hello, @NonNull final GoodBye goodBye) throws Exception {
                return new HelloGoodByeResponse(hello.getValue(), "and", goodBye.getValue());
            }
        });
    }


}
