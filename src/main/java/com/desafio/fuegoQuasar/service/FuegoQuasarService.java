package com.desafio.fuegoQuasar.service;

import com.desafio.fuegoQuasar.model.Response;
import com.desafio.fuegoQuasar.model.Satellite;

import java.util.List;

public interface FuegoQuasarService {
    Response topSeretService(List<Satellite> satellites);
    void topSecretSplitService(Satellite satellite, String satelliteName);
    Response topSeretService();
}
