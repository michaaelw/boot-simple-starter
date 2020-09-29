package com.shapestone.spring.boot.java.starter.mw.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloGoodByeRequest {
    private String hello;
    private String goodBye;
}
