package com.shapestone.spring.boot.java.starter.mw.repository;

import com.shapestone.spring.boot.java.starter.mw.domain.model.GoodBye;
import com.shapestone.spring.boot.java.starter.mw.domain.model.Hello;
import io.reactivex.Single;

public interface GoodByeRepository {
    Single<GoodBye> save(final GoodBye goodBye);
}
