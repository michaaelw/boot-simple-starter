package com.shapestone.spring.boot.java.starter.mw.repository;

import com.shapestone.spring.boot.java.starter.mw.domain.model.Hello;
import io.reactivex.Single;

public interface HelloRepository {
    Single<Hello> save(final Hello hello);
}
