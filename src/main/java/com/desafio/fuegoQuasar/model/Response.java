package com.desafio.fuegoQuasar.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Response {
    private String message;
    private Position position;
}
