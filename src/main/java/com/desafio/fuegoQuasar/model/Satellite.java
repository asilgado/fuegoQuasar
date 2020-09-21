package com.desafio.fuegoQuasar.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@EqualsAndHashCode(exclude = {"distance", "message"})
public class Satellite {
    @NotNull
    @Setter
    private String name;
    @NotNull
    private float distance;
    @NotNull
    private List<String> message;

}
