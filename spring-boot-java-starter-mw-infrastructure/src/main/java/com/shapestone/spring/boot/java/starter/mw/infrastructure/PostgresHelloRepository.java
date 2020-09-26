package com.shapestone.spring.boot.java.starter.mw.infrastructure;

import com.shapestone.spring.boot.java.starter.mw.domain.model.Hello;
import com.shapestone.spring.boot.java.starter.mw.repository.HelloRepository;
import io.reactivex.Single;

import static io.reactivex.Single.just;

public class PostgresHelloRepository implements HelloRepository {

    @Override
    public Single<Hello> save(final Hello hello) {
        return just(hello);
    }

}
