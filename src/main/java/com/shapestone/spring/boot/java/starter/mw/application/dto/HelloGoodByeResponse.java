package com.shapestone.spring.boot.java.starter.mw.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloGoodByeResponse {
    private String hello;
    private String conjunction;
    private String goodBye;
}
