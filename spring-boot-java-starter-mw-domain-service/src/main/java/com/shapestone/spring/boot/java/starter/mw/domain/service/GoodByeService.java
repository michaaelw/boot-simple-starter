package com.shapestone.spring.boot.java.starter.mw.domain.service;

import com.shapestone.spring.boot.java.starter.mw.domain.model.GoodBye;
import com.shapestone.spring.boot.java.starter.mw.domain.model.Hello;
import com.shapestone.spring.boot.java.starter.mw.repository.GoodByeRepository;
import com.shapestone.spring.boot.java.starter.mw.repository.HelloRepository;
import io.reactivex.Single;

public class GoodByeService {

    private GoodByeRepository repository;

    public GoodByeService(final GoodByeRepository repository) {
        this.repository = repository;
    }

    public Single<GoodBye> addGoodBye(final GoodBye goodBye) {
        return repository.save(goodBye);
    }

}
