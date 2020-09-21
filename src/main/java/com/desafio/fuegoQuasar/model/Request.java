package com.desafio.fuegoQuasar.model;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class Request {
    @Valid
    private List<Satellite> satellites;
}
