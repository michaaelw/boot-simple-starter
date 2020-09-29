package com.shapestone.spring.boot.java.starter.mw.domain.service;

import com.shapestone.spring.boot.java.starter.mw.domain.model.Hello;
import com.shapestone.spring.boot.java.starter.mw.repository.HelloRepository;
import io.reactivex.Single;

public class HelloService {

    private HelloRepository repository;

    public HelloService(final HelloRepository repository) {
        this.repository = repository;
    }

    public Single<Hello> addHello(final Hello hello) {
        return repository.save(hello);
    }

}
