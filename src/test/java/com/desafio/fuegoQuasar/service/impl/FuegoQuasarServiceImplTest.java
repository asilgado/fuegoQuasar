package com.desafio.fuegoQuasar.service.impl;

import com.desafio.fuegoQuasar.TestObjectFactory;
import com.desafio.fuegoQuasar.exception.FuegoQuasarException;
import com.desafio.fuegoQuasar.model.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.desafio.fuegoQuasar.TestObjectFactory.FINAL_MESSAGE;
import static com.desafio.fuegoQuasar.constant.Constants.MESSAGE_ERROR;
import static com.desafio.fuegoQuasar.constant.Constants.POSITION_ERROR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FuegoQuasarServiceImplTest {
    private FuegoQuasarServiceImpl fuegoQuasarService;

    @BeforeEach
    void setUp() {
        fuegoQuasarService = new FuegoQuasarServiceImpl();
    }

    @Test
    void topSeretServiceWhenListIsEmpty() {
        Exception exception = assertThrows(FuegoQuasarException.class, () -> fuegoQuasarService.topSecretService(Collections.emptyList()));
        assertTrue(exception.getMessage().contains(POSITION_ERROR));
    }

    @Test
    void topSeretServiceWhenCicleNotIntercept() {
        Exception exception = assertThrows(FuegoQuasarException.class, () -> fuegoQuasarService.topSecretService(TestObjectFactory.buildSatelliteListDistanceError()));
        assertTrue(exception.getMessage().contains(POSITION_ERROR));
    }


    @Test
    void topSeretService() {
        Response response = fuegoQuasarService.topSecretService(TestObjectFactory.buildSatelliteList());
        assertEquals(-100, (int) response.getPosition().getX());
        assertEquals(75, (int) response.getPosition().getY());
        assertEquals(FINAL_MESSAGE, response.getMessage());
    }

    @Test
    void topSeretServiceWhenListMessageIsEmpty() {
        Exception exception = assertThrows(FuegoQuasarException.class, () ->
                fuegoQuasarService.topSecretService(TestObjectFactory.buildSatelliteListMessageEmpty()));
        assertTrue(exception.getMessage().contains(MESSAGE_ERROR));
    }

    @Test
    void topSeretServiceWhenListMessageIsNoEquals() {
        Exception exception = assertThrows(FuegoQuasarException.class, () ->
                fuegoQuasarService.topSecretService(TestObjectFactory.buildSatelliteListMessageSizeError()));
        assertTrue(exception.getMessage().contains(MESSAGE_ERROR));
    }

    @Test
    void topSecretSplitService() {
        fuegoQuasarService.setQueue(TestObjectFactory.buildSatelliteListQueueSuccess());
        fuegoQuasarService.topSecretSplitService(TestObjectFactory.buildSatellite(600.5f, "sato", Arrays.asList("este", "", "un", "")), "sato");
        assertEquals(3, fuegoQuasarService.getQueue().size());
    }
}