package com.desafio.fuegoQuasar.controller;

import com.desafio.fuegoQuasar.exception.FuegoQuasarException;
import com.desafio.fuegoQuasar.model.Request;
import com.desafio.fuegoQuasar.model.Response;
import com.desafio.fuegoQuasar.model.Satellite;
import com.desafio.fuegoQuasar.service.FuegoQuasarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.desafio.fuegoQuasar.constant.Constants.NOT_ENOUGH_INFORMATION;
import static com.desafio.fuegoQuasar.constant.Constants.PATH_ROOT;
import static com.desafio.fuegoQuasar.constant.Constants.PATH_TOP_SECRET;
import static com.desafio.fuegoQuasar.constant.Constants.PATH_TOP_SECRET_SPLIT;
import static com.desafio.fuegoQuasar.constant.Constants.PATH_TOP_SECRET_SPLIT_GET;
import static com.desafio.fuegoQuasar.constant.Constants.SATELLITE_NAME;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = PATH_ROOT)
public class FuegoQuasarController {
    private final FuegoQuasarService fuegoQuasarService;

    @PostMapping(value = PATH_TOP_SECRET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> topSecret(@Valid @RequestBody Request request) {
        Response response = null;
        try {
            response = fuegoQuasarService.topSeretService(request.getSatellites());
        } catch (FuegoQuasarException fuegoQuasarException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping(value = PATH_TOP_SECRET_SPLIT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void topSecretSplit(@PathVariable(SATELLITE_NAME) String satelliteName, @RequestBody Satellite satellite) {
        fuegoQuasarService.topSecretSplitService(satellite, satelliteName);
    }

    @GetMapping(value = PATH_TOP_SECRET_SPLIT_GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> topSecretSplit() {
        Response response = null;
        try {
            response = fuegoQuasarService.topSeretService();
        } catch (FuegoQuasarException fuegoQuasarException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Response.builder().message(NOT_ENOUGH_INFORMATION).build());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
