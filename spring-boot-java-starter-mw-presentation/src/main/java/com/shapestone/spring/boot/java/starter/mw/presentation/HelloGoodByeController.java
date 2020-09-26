package com.shapestone.spring.boot.java.starter.mw.presentation;

import com.shapestone.spring.boot.java.starter.mw.application.dto.HelloGoodByeRequest;
import com.shapestone.spring.boot.java.starter.mw.application.dto.HelloGoodByeResponse;
import com.shapestone.spring.boot.java.starter.mw.application.service.HelloGoodByeApplicationService;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.reactivex.annotations.NonNull;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@SuppressWarnings({"Convert2Diamond", "Convert2Lambda", "RedundantThrows"})
@RestController
public class HelloGoodByeController {

    private final HelloGoodByeApplicationService helloGoodByeApplicationService;

    @Autowired
    public HelloGoodByeController(final HelloGoodByeApplicationService helloGoodByeApplicationService) {
        this.helloGoodByeApplicationService = helloGoodByeApplicationService;
    }

    @RequestMapping(path = "starter/hello/good-bye", method = POST, consumes = "application/json")
    @ApiOperation(value = "Create Environment", response = HelloGoodByeResponse.class)
    public Single<ResponseEntity<HelloGoodByeResponse>> createHelloGoodBye(@RequestBody final HelloGoodByeRequest helloGoodBye) {
        return helloGoodByeApplicationService.addHelloGoodBye(helloGoodBye)
        .map(new Function<HelloGoodByeResponse, ResponseEntity<HelloGoodByeResponse>>() {
            @Override
            public ResponseEntity<HelloGoodByeResponse> apply(@NonNull final HelloGoodByeResponse helloGoodByeResponse) throws Exception {
                return new ResponseEntity<>(helloGoodByeResponse, OK);
            }
        });
    }

}
