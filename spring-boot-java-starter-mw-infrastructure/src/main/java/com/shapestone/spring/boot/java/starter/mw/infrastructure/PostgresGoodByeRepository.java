package com.shapestone.spring.boot.java.starter.mw.infrastructure;

import com.shapestone.spring.boot.java.starter.mw.repository.GoodByeRepository;
import com.shapestone.spring.boot.java.starter.mw.domain.model.GoodBye;
import io.reactivex.Single;

import static io.reactivex.Single.just;

public class PostgresGoodByeRepository implements GoodByeRepository {

    @Override
    public Single<GoodBye> save(final GoodBye goodBye) {
        return just(goodBye);
    }

}
